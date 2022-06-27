package fr.efficom.countries.country.authentification;
import javax.persistence.*;
import java.io.Serializable;

@Entity

public class UserModel implements Serializable {

    @Column(unique = true)
    private String name;
    @Column
    private String president;
    @Id
    @GeneratedValue
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpresident() {
        return president;
    }

    public void setpresident(String president) {
        this.president = president;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}