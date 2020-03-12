package br.ufmt.webii.dwebii.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "estoque")
@SequenceGenerator(allocationSize = 1, name = "seq_estoque", sequenceName = "seq_estoque_id")
public class Estoque implements Serializable {

  private static final long serialVersionUID = 226110065928170372L;

  @Id
  @GeneratedValue(generator = "seq_estoque")
  private int id;
  private int qtd;

  @OneToOne
  @MapsId
  // @JoinColumn(name = "produto_id")
  private Produto produto;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getQtd() {
    return qtd;
  }

  public void setQtd(int qtd) {
    this.qtd = qtd;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 79 * hash + Objects.hashCode(this.qtd);
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
    final Estoque other = (Estoque) obj;
    if (!Objects.equals(this.qtd, other.qtd)) {
      return false;
    }
    return true;
  }

}
