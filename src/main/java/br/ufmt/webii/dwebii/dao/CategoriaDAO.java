package br.ufmt.webii.dwebii.dao;

import br.ufmt.webii.dwebii.entidades.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaDAO extends CrudRepository<Categoria, Integer> {

    public Categoria findByNome(String sigla);

}
