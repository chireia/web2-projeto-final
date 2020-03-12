package br.ufmt.webii.dwebii.dao;

import br.ufmt.webii.dwebii.entidades.Estoque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueDAO extends CrudRepository<Estoque, Integer> {

    public Estoque findByQtd(String sigla);

}
