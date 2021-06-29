package com.rastrm.sba;

import com.rastrm.sba.entity.Product;
import com.rastrm.sba.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class SController {
    private final ProductRepository productRepository;

    public SController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping()
    public String getindex(Model model) {
        model.addAttribute("productList", productRepository.getAllList());
        return "index";
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());

        return "newProductForm";
    }

    @RequestMapping(value = "/makenew", method = RequestMethod.POST)
    public String makeProductAndReturn(@ModelAttribute("product") Product product) {

        productRepository.newItem(product);
        return "redirect:/";

    }

    @RequestMapping(value = "/delbyid", method = RequestMethod.POST)
    public String delProduct(@ModelAttribute("id") int id) {

        productRepository.delByID(id);
        return "redirect:/";

    }

}
