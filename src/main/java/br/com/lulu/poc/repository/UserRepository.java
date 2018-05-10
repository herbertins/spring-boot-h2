package br.com.lulu.poc.repository;

import br.com.lulu.poc.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
