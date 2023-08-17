package com.abc.demo.ott.service;

import com.abc.demo.ott.entity.GenreEntity;
import com.abc.demo.ott.entity.VideoEntity;
import com.abc.demo.ott.repository.GenreRepositoryInterface;
import com.abc.demo.ott.repository.VideoRepositoryInterface;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GenreService {

    @Autowired
    GenreRepositoryInterface gri;

    @Autowired
    VideoRepositoryInterface videoRepositoryInterface;

    @Autowired
    KafkaTemplate<String, String> kt;

    public List<GenreEntity> sendAllGenreList() {
        return gri.findAll();
    }

    public GenreEntity addGenre(GenreEntity entity)  {
        return gri.save(entity);
    }

    public GenreEntity updateGenre(GenreEntity newDetails, int genreID)   {
        GenreEntity currentDetails = gri.findById(genreID).get();
        currentDetails.setGenreName((newDetails.getGenreName()!=null)?newDetails.getGenreName():currentDetails.getGenreName());
        currentDetails.setGenreDescription((newDetails.getGenreDescription()!=null)?newDetails.getGenreDescription():currentDetails.getGenreDescription());
        kt.send("genre_updates", "Genre details for \""+currentDetails.getGenreName()+"\" has been updated");
        return gri.save(currentDetails);
    }

    public void deleteGenre(int genreID)    {
        List<VideoEntity> list = videoRepositoryInterface.findAll();
        for (VideoEntity video: list)   {
            if (video.getVideoGenreID().contains(gri.findById(genreID).get())){
                video.getVideoGenreID().remove(gri.findById(genreID).get());
            }
        }
        gri.delete(gri.findById(genreID).get());
    }
}
