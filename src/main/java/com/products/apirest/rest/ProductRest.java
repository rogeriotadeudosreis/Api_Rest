package com.products.apirest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.apirest.dao.ProductDao;
import com.products.apirest.entity.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*") // de qualquer url pode-se acessar esta aplicação
public class ProductRest {

	@Autowired
	private ProductDao productDao;

	@GetMapping("/products")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Product> listaProdutos() {
		return productDao.findAll();
	}

	@GetMapping("/products/{id}")
	@ApiOperation(value = "Retorna um produto único")
	public Product listProductUnico(@PathVariable(value = "id") long id) {
		return productDao.findById(id);
	}

	@PostMapping("/products")
	@ApiOperation(value = "Salva um produto")
	public void postSalvaProduct(@RequestBody Product product) {
		productDao.save(product);
	}

	@DeleteMapping("/products")
	@ApiOperation(value = "Deleta um produto")
	public void deleteProduct(@RequestBody Product product) {
		productDao.delete(product);
	}

	@PutMapping("/products")
	@ApiOperation(value = "Atualiza um produto")
	public Product updateProduct(@RequestBody Product product) {
		return productDao.save(product);
	}

}
