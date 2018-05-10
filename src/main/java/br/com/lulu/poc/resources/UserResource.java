package br.com.lulu.poc.resources;

import br.com.lulu.poc.model.User;
import br.com.lulu.poc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> load() {

        Iterable<User> users = repository.findAll();

        if (users == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<List<User>> load(@PathVariable Integer id) {

        Optional<User> user = repository.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<List<User>> add(@RequestBody User user) {
        repository.save(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }

}
