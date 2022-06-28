package fr.efficom.countries.country.authentification;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserModel implements Serializable {

    @Column(unique = true)
    private String name;
    
    @Column
    private String email;
    
    @Column
    private String password;
    
    @Id
    @GeneratedValue
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}