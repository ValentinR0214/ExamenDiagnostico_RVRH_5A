package mx.edu.utez.diagnostico_rvrh.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.diagnostico_rvrh.model.dto.ClienteDto;
import mx.edu.utez.diagnostico_rvrh.model.entity.ClienteBean;
import mx.edu.utez.diagnostico_rvrh.service.ICliente;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cliente")
@AllArgsConstructor
public class ClienteController {

    private final ICliente clienteService;

    @GetMapping("/")
    public List<ClienteBean> getCliente(){
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ClienteBean showById(@PathVariable Integer id){
        return clienteService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto){
        try {
            ClienteBean clienteSave = clienteService.save(clienteDto);
            ClienteDto responseDto = ClienteDto.builder()
                    .id_cliente(clienteSave.getIdCliente())
                    .nombre(clienteSave.getNombre())
                    .apellidos(clienteSave.getApellidos())
                    .curp(clienteSave.getCurp())
                    .fechaNacimiento(clienteSave.getFechaNacimiento())
                    .build();
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                String mensajeError = "La CURP debe ser unica (¬_¬ )";
                return new ResponseEntity<>(mensajeError, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Error del servidor (⊙﹏⊙)", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ClienteDto update(@RequestBody ClienteDto clienteDto){
        ClienteBean clienteUpdate = clienteService.save(clienteDto);
        return ClienteDto.builder()
                .id_cliente(clienteUpdate.getIdCliente())
                .nombre(clienteUpdate.getNombre())
                .apellidos(clienteUpdate.getApellidos())
                .curp(clienteUpdate.getCurp())
                .fechaNacimiento(clienteUpdate.getFechaNacimiento())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        ClienteBean cliente = clienteService.findById(id);
        clienteService.delete(cliente);
    }

}
