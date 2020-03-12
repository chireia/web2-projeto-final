
package br.ufmt.webii.dwebii.dao;

import br.ufmt.webii.dwebii.entidades.Produto;
import org.springframework.data.repository.CrudRepository;


public interface ProdutoDAO extends CrudRepository<Produto, Integer> {
    
}
