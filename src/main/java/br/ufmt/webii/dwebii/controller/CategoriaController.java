package br.ufmt.webii.dwebii.controller;

import br.ufmt.webii.dwebii.entidades.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.ufmt.webii.dwebii.dao.CategoriaDAO;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaDAO dao;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("lista", dao.findAll());
        return "categoria";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("categoria") Categoria novo) {
        dao.save(novo);
        return "redirect:/categoria";
    }

    @GetMapping("/editar/{id}")
    public String editar(@ModelAttribute("id") int pk, Model model) {
        Categoria edit = dao.findById(pk).get();
        model.addAttribute("categoria", edit);
        model.addAttribute("lista", dao.findAll());
        return "categoria";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@ModelAttribute("id") int pk) {
        dao.deleteById(pk);
        return "redirect:/categoria";
    }

}
