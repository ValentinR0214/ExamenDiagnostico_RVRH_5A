package mx.edu.utez.diagnostico_rvrh.service;

import mx.edu.utez.diagnostico_rvrh.model.dto.ClienteDto;
import mx.edu.utez.diagnostico_rvrh.model.entity.ClienteBean;

import java.util.List;

public interface ICliente {
    ClienteBean save(ClienteDto cliente);

    ClienteBean findById(Integer id);

    List<ClienteBean> findAll();

    void delete(ClienteBean cliente);
}
