package tarea11.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    private Integer duracion;
    private Double precio;

    // Constructores
    public Curso() {}

    public Curso(String nombre, String descripcion, Integer duracion, Double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.precio = precio;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nombre=" + nombre +
                ", descripcion=" + descripcion + ", duracion=" + duracion +
                ", precio=" + precio + '}';
    }
}