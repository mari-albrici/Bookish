package bookish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bookish.model.User;

@Repository
public class UserRepository extends JpaRepository<User, String> {
    
}
