package br.ufmt.webii.dwebii.controller;

import br.ufmt.webii.dwebii.dao.CategoriaDAO;
import br.ufmt.webii.dwebii.entidades.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.ufmt.webii.dwebii.dao.MarcaDAO;
import br.ufmt.webii.dwebii.dao.ProdutoDAO;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoDAO dao;

    @Autowired
    private MarcaDAO marcaDAO;

    @Autowired
    private CategoriaDAO catDAO;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("lista", dao.findAll());
        model.addAttribute("marcas", marcaDAO.findAll());
        model.addAttribute("categorias", catDAO.findAll());
        return "produto";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("produto") Produto novo) {
        dao.save(novo);
        return "redirect:/produto";
    }

    @GetMapping("/editar/{id}")
    public String editar(@ModelAttribute("id") int pk, Model model) {
        Produto edit = dao.findById(pk).get();
        model.addAttribute("produto", edit);
        model.addAttribute("lista", dao.findAll());
        model.addAttribute("marcas", marcaDAO.findAll());
        model.addAttribute("categorias", catDAO.findAll());
        return "produto";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@ModelAttribute("id") int pk) {
        dao.deleteById(pk);
        return "redirect:/produto";
    }

}
