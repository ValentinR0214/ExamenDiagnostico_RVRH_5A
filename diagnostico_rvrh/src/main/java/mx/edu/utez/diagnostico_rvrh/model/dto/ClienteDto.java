package mx.edu.utez.diagnostico_rvrh.model.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClienteDto {
    private Integer id_cliente;
    private String nombre;
    private String apellidos;
    private String curp;
    private LocalDate fechaNacimiento;
}
