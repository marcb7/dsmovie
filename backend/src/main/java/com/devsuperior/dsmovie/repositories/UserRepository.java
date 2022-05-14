package com.devsuperior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// Método customizado para buscar o usuário pelo email. Esse método cria uma
	// busca usando o prórpio nome do campo.
	User findByEmail(String email);
}
