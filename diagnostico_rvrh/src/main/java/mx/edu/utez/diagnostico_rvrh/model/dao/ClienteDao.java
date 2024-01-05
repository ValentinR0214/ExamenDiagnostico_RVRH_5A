package mx.edu.utez.diagnostico_rvrh.model.dao;

import mx.edu.utez.diagnostico_rvrh.model.entity.ClienteBean;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<ClienteBean, Integer> {
}
