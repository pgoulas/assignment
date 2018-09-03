package gr.project.repository;

import gr.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT t FROM Customer_User t where t.email = :email" + "")
    public User findUserByEmail(@Param("email") String email);

    @Query(value = "SELECT t FROM Customer_User t where t.ipAddress = :ipAddress")
    public User findUserByIp(@Param("ipAddress") String ipAddress);

}