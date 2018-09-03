package gr.project.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Model for User
 */
@Data
@Entity(name = "Customer_User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(max = 100)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Size(max = 30)
    @Column(name = "email")
    @Email
    private String email;

    @NotNull
    @Size(max = 6)
    @Column(name = "gender")
    private String gender;

    @NotNull
    @Size(max=15)
    @Column(name = "ipAddress")
    private String ipAddress;

}