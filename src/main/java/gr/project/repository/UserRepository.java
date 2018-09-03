package gr.project.repository;

import gr.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT t FROM Customer_User t where t.email = :email" + "")
    public User findUserByEmail(@Param("email") String email);

//    @Query(value = "SELECT t FROM Customer_User t where t.ip_address = :ipAddress")
//    public User findUserByIp(@Param("ip_address") String ipAddress);

}