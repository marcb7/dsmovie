package com.devsuperior.dsmovie.dto;

// Classe que tem os 3 dados que são enviados na requisição.
public class ScoreDTO {
	
	private Long movieId;	// O id do filme.
	private String email; 	// O email que o usuário preencheu no formulário.
	private Double score;
	
	public ScoreDTO() {		
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
}
