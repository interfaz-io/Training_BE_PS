package io.interfaz.training.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.interfaz.training.entities.Merchant;
import io.interfaz.training.repos.MerchantRepository;
/**
 * 
 * @author kcambronero
 *
 */
@Service
public class MerchantService {
	@Autowired
	private MerchantRepository merchantRespository;
	
	public Merchant createMerchant(Merchant merchan) {
		
		return merchantRespository.save(merchan);
	}
	
	public List<Merchant> getAll(){
		return (List<Merchant>) merchantRespository.findAll();
	}
	
	public Optional<Merchant> getById(int id) {
		return merchantRespository.findById(id);
	}
	
	public void deleteMerchant(int id) {
		merchantRespository.deleteById(id);
	}
}
