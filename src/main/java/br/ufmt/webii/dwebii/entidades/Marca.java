package br.ufmt.webii.dwebii.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
@SequenceGenerator(allocationSize = 1, name = "seq_marca", sequenceName = "seq_marca_id")
public class Marca implements Serializable {

  private static final long serialVersionUID = 8511769146052363824L;

  @Id
  @GeneratedValue(generator = "seq_marca")
  private int id;
  private String nome;

  @OneToMany(mappedBy = "marca")
  private List<Produto> produtos;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 79 * hash + Objects.hashCode(this.nome);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Marca other = (Marca) obj;
    if (!Objects.equals(this.nome, other.nome)) {
      return false;
    }
    return true;
  }

}
