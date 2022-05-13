package com.devsuperior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService service;

	// Este método vai responder pela requisição GET do http, através do
	// @GetMapping. O método vai responder no caminho /movies pelo verbo GET do http.
	@GetMapping
	public Page<MovieDTO> findAllMovies(Pageable pageable) {
		return service.findAll(pageable);
	}

	// A annotation @PathVariable serve para configurar que o argumento da URL "/{id}" vai casar com o parâmetro id.
	@GetMapping(value = "/{id}")
	public MovieDTO findMovieById(@PathVariable Long id) {
		return service.findById(id);
	}
}
