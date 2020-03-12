package br.ufmt.webii.dwebii.controller;

import br.ufmt.webii.dwebii.entidades.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.ufmt.webii.dwebii.dao.MarcaDAO;

@Controller
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaDAO dao;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("marca", new Marca());
        model.addAttribute("lista", dao.findAll());
        return "marca";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("marca") Marca novo) {
        dao.save(novo);
        return "redirect:/marca";
    }

    @GetMapping("/editar/{id}")
    public String editar(@ModelAttribute("id") int pk, Model model) {
        Marca edit = dao.findById(pk).get();
        model.addAttribute("marca", edit);
        model.addAttribute("lista", dao.findAll());
        return "marca";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@ModelAttribute("id") int pk) {
        dao.deleteById(pk);
        return "redirect:/marca";
    }

}
