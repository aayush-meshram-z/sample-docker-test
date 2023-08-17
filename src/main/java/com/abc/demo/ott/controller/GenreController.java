package com.abc.demo.ott.controller;

import com.abc.demo.ott.entity.GenreEntity;
import com.abc.demo.ott.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping("/api/genres")
    public ResponseEntity<List<GenreEntity>> getAllGenre()  {
        return new ResponseEntity<>(genreService.sendAllGenreList(), HttpStatus.OK);
    }

    @PostMapping("/api/admin/genres")
    public ResponseEntity<String> createGenre(@RequestBody GenreEntity genreEntity) {
        genreService.addGenre(genreEntity);
        return new ResponseEntity<>("Genre added successfully", HttpStatus.OK);
    }

    @PutMapping("/api/admin/genres/{genreID}")
    public ResponseEntity<String> updateGenreDetails(@PathVariable("genreID")int genreID, @RequestBody GenreEntity genreEntity)      {
        genreService.updateGenre(genreEntity, genreID);
        return new ResponseEntity<>("Genre details updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/api/admin/genres/{genreID}")
    public ResponseEntity<String> deleteGenre(@PathVariable("genreID") int genreID) {
        genreService.deleteGenre(genreID);
        return new ResponseEntity<>("Genre deleted successfully", HttpStatus.OK);
    }

}
