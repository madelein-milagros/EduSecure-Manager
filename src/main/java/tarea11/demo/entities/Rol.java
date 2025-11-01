package tarea11.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String authority;

    // Constructores
    public Rol() {}

    public Rol(String authority) {
        this.authority = authority;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAuthority() { return authority; }
    public void setAuthority(String authority) { this.authority = authority; }
}