package bookish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookish.model.User;
import bookish.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public User saveUser(UserPayload body){
        User u = new User();
        u.setEmail(body.getEmail());
        u.setName(body.getName());
        u.setLastName(body.getLastName());
        u.setRole(Role.valueOf(body.getRole()));
        u.setPassword(body.getPassword());
        return userRepo.save(u);
    }

    public Page<User> findAll(int page, int size, String sortBy) {
        if (size < 0)
            size = 10;
        if (size > 100)
            size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return userRepo.findAll(pageable);
    }

    public User findByEmail(String email) throws NotFoundException {
        return userRepo.findById(email)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public User findUserByEmail(String email) throws NotFoundException {
        Optional<User> userOptional = userRepo.findById(email);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new NotFoundException("User not found");
        }
    }

    public User findByEmailAndUpdate(String email, UserPayload g)
            throws NotFoundException {
        User found = this.findByEmail(email);

        found.setEmail(g.getEmail());
        found.setName(g.getName());
        found.setLastName(g.getLastName());
        found.setRole(Role.valueOf(g.getRole()));
        found.setPassword(g.getPassword());

        return userRepo.save(found);
    }

    public void findByEmailAndDelete(String email) throws NotFoundException {
        User found = this.findByEmail(email);
        userRepo.delete(found);
    }


}
