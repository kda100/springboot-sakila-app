package com.Sakila.api.Sakilaapp.Film;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/films")
@AllArgsConstructor
@CrossOrigin
public class FilmController {
    private FilmService filmService;


    @GetMapping()
    public Page<FilmDTO> getAllFilms(@RequestParam(name="categoryId", defaultValue = "-1", required = false) Long categoryId,
                                                  @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortByField,
                                                  @RequestParam(name = "offset", defaultValue = "1") int offset,
                                                  @RequestParam(name = "pageSize", defaultValue = "25") int pageSize) {
        return filmService.getAllFilms(categoryId, sortByField, offset, pageSize);
    }

    @GetMapping("{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmService.getFilmById(id);
    }
}
