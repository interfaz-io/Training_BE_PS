
package io.interfaz.training.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.interfaz.training.entities.Merchant;
import io.interfaz.training.services.MerchantService;


/***
 * 
 * @author kcambronero
 *
 */
@RestController
public class MerchantController {
	@Autowired
	public MerchantService merchantService;
	
	@GetMapping("/merchant")
	public List<Merchant> all(){
		return merchantService.getAll();
	}
	@GetMapping("/merchant/{id}")
	public Optional<Merchant> productId(@PathVariable int id) {
		return merchantService.getById(id);
	}
	@PostMapping("/addMerchant")
	public Merchant newOrder(@RequestBody Merchant newMerchant) {
		return merchantService.createMerchant(newMerchant);
	}
	@DeleteMapping("/merchant/{id}")
	public void deleteOrder(@PathVariable int id) {
		merchantService.deleteMerchant(id);
	}
}
