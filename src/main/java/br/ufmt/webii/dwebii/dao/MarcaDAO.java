package br.ufmt.webii.dwebii.dao;

import br.ufmt.webii.dwebii.entidades.Marca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaDAO extends CrudRepository<Marca, Integer>{
    
    public Marca findByNome(String sigla);
    
}
