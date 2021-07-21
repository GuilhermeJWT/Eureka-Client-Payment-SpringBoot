package br.com.systemsgs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/payment")
public class PaymentController {
	
	@GetMapping(value = "/{preco}")
	private String testePreco(@PathVariable Double preco) {
		return "Preço: " + preco;
	}

}
