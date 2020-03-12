package br.ufmt.webii.dwebii.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufmt.webii.dwebii.dao.EstoqueDAO;
import br.ufmt.webii.dwebii.dao.ProdutoDAO;
import br.ufmt.webii.dwebii.entidades.Estoque;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {

  @Autowired
  private EstoqueDAO dao;

  @Autowired
  private ProdutoDAO prodDAO;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("estoque", new Estoque());
    model.addAttribute("lista", dao.findAll());
    model.addAttribute("produtos", prodDAO.findAll());
    return "estoque";
  }

  @PostMapping("/salvar")
  public String salvar(@ModelAttribute("estoque") Estoque novo) throws Exception {
    Iterable<Estoque> idsAtuais = dao.findAll();
    if (novo.getProduto() == null)
      return "redirect:/estoque";
    for (Estoque estoque : idsAtuais) {
      if (novo.getProduto().getNome() == estoque.getProduto().getNome() && novo.getId() == 0) {
        return "redirect:/estoque?erro=true";
      }
    }
    dao.save(novo);
    return "redirect:/estoque";
  }

  @GetMapping("/editar/{id}")
  public String editar(@ModelAttribute("id") int pk, Model model) {
    Estoque edit = dao.findById(pk).get();
    model.addAttribute("estoque", edit);
    model.addAttribute("lista", dao.findAll());
    model.addAttribute("produtos", prodDAO.findAll());
    return "estoque";
  }

  @GetMapping("/excluir/{id}")
  public String excluir(@ModelAttribute("id") int pk) {
    dao.deleteById(pk);
    return "redirect:/estoque";
  }

}
