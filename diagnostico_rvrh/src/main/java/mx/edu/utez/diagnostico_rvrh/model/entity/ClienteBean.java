package mx.edu.utez.diagnostico_rvrh.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "cliente", uniqueConstraints = {@UniqueConstraint(columnNames = "curp", name = "uk_curp")})
public class ClienteBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "curp", nullable = false, unique = true)
    private String curp;

    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;

}
