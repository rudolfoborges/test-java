package br.com.rudolfoborges.user.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

import br.com.rudolfoborges.user.persistence.UserEntity;

/**
 * Created by rudolfoborges on 28/07/17.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>,
		PagingAndSortingRepository<UserEntity, Long> {

	Optional<UserEntity> findByEmail(String email);

}
