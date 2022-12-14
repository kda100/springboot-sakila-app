package com.Sakila.api.Sakilaapp.Film;

import com.Sakila.api.Sakilaapp.Exceptions.ResourceNotFoundException;
import com.Sakila.api.Sakilaapp.Helpers.ModelMapperHelper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class FilmService{
    private FilmRepository filmRepository;
    private ModelMapperHelper modelMapperHelper;


    public Page<FilmDTO> getAllFilms(Long categoryId, String sortByField, int offset, int pageSize) {
        Page<Film> films;
        if(categoryId != -1) {
            films = filmRepository.findByCategories_id(categoryId, PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,
                    sortByField)));
        } else {
            films = filmRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC,
                    sortByField)));
        }
        return modelMapperHelper.mapPage(films, FilmDTO.class);
    }

    public Film getFilmById(Long id) {
        if(filmRepository.existsById(id)) {
            return filmRepository.findById(id).get();
        } else {
            throw new ResourceNotFoundException("Film", "Id", id);
        }
    }
}
