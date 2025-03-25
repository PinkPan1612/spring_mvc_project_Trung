package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.UploadFileService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

    private UploadFileService uploadService;
    private ProductService productService;

    public ProductController(UploadFileService uploadService, ProductService productService) {
        this.uploadService = uploadService;
        this.productService = productService;
    }

    @GetMapping("/admin/products/create")
    public String getProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "/admin/product/create";
    }

    @PostMapping("/admin/products/create")
    public String postCreateProduct(@ModelAttribute("newProduct") @Valid Product newProduct,
            BindingResult newProductBindingResult,
            @RequestParam("productFile") MultipartFile file) {
        // Kiểm tra nếu có lỗi validation
        if (newProductBindingResult.hasErrors()) {
            System.out.println("Validation failed. Errors:");
            return "admin/product/create";
        }
        String product_image = this.uploadService.handleSaveUploadFile(file, "product");
        newProduct.setImage(product_image);
        this.productService.saveProduct(newProduct);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/products")
    public String getMethodName(Model model) {
        List<Product> products = this.productService.getAllPr();
        model.addAttribute("products", products);
        return "/admin/product/show";
    }

}
