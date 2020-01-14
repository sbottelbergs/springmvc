package be.syntra.java.advanced.springmvc.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionScope
@RequestMapping("/products")
public class ProductController {
    private final List<String> products;

    public ProductController() {
        this.products = new ArrayList<>();
    }

    @ModelAttribute("products")
    public List<String> getProducts() {
        return this.products;
    }

    @GetMapping
    public String handleGetProducts() {
        return "products/products";
    }

    @PostMapping
    public String handlePost(@RequestParam String action, @RequestParam String product, @RequestParam(required = false) Integer index) {
        switch (action) {
            case "Add":
                this.products.add(product);
                break;
            case "Del":
                this.products.remove(this.products.get(index));
                break;
            case "Change":
                this.products.set(index, product);
        }
        return "products/products";
    }
}
