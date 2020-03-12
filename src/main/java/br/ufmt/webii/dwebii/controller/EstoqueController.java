package br.ufmt.webii.dwebii.controller;

import br.ufmt.webii.dwebii.entidades.Estoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.ufmt.webii.dwebii.dao.EstoqueDAO;
import br.ufmt.webii.dwebii.dao.ProdutoDAO;

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
    public String salvar(@ModelAttribute("estoque") Estoque novo) {
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
