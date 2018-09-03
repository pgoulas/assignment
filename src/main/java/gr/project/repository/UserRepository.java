package gr.project.repository;

import gr.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail( String email);

    public User findByIpAddress(String ipAddress);
}