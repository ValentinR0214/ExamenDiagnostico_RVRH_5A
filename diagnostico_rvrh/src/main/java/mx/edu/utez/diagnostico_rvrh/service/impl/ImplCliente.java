package mx.edu.utez.diagnostico_rvrh.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mx.edu.utez.diagnostico_rvrh.model.dao.ClienteDao;
import mx.edu.utez.diagnostico_rvrh.model.dto.ClienteDto;
import mx.edu.utez.diagnostico_rvrh.model.entity.ClienteBean;
import mx.edu.utez.diagnostico_rvrh.service.ICliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplCliente implements ICliente {

    private final ClienteDao clienteDao;

    @Override
    @Transactional
    public ClienteBean save(ClienteDto clienteDto){
        ClienteBean cliente = ClienteBean.builder()
                .idCliente(clienteDto.getId_cliente())
                .nombre(clienteDto.getNombre())
                .apellidos(clienteDto.getApellidos())
                .curp(clienteDto.getCurp())
                .fechaNacimiento(clienteDto.getFechaNacimiento())
                .build();
        return clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteBean findById(Integer id){
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteBean> findAll(){
        return (List<ClienteBean>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void delete(ClienteBean cliente){
        clienteDao.delete(cliente);
    }

}
