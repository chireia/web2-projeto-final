package br.ufmt.webii.dwebii.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "produto_id_seq", allocationSize = 1)
public class Produto implements Serializable {

  private static final long serialVersionUID = -1209005758984673691L;

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
  private int id;
  private String nome;
  private int peso;
  private int preco;

  @ManyToOne
  @JoinColumn(name = "marca_id")
  private Marca marca;

  @ManyToOne
  @JoinColumn(name = "categoria_id")
  private Categoria categoria;

  @OneToOne(mappedBy = "produto")
  private Estoque estoque;

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

  public int getPeso() {
    return peso;
  }

  public void setPeso(int peso) {
    this.peso = peso;
  }

  public int getPreco() {
    return preco;
  }

  public void setPreco(int preco) {
    this.preco = preco;
  }

  public Marca getMarca() {
    return marca;
  }

  public void setMarca(Marca marca) {
    this.marca = marca;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  
  public Estoque getEstoque() {
    return estoque;
  }

  public void setEstoque(Estoque estoque) {
    this.estoque = estoque;
  }

}
