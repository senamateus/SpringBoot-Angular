package app.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.entity.Marca;
import app.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired //ISSO É INSTANCIAR UM OBJETO, AQUI NO CASO É A INTERFACE
	private CarroRepository carroRepository;
	
	public String save(Carro carro) {
		this.carroRepository.save(carro);
		return "Carro salvo com sucesso";
	}
	
	public String update(Carro carro, long id) {
		carro.setId(id);
		this.carroRepository.save(carro);
		return "Carro foi atualizado com sucesso !!!";
	}
	
	public String delete(long id) {
		this.carroRepository.deleteById(id);
		return "Carro deletado com sucesso";
	}
	
	public List<Carro> findAll(){
		List<Carro> lista = this.carroRepository.findAll();
		return lista;
	}
	
	public Carro findById(long id) {
		Carro carro = this.carroRepository.findById(id).get();
		return carro;
	}
	
	public List<Carro> findByNome(String nome){
		return this.carroRepository.findByNome(nome);
	}
	
	public List<Carro> findByMarca(long idMarca){
		Marca marca = new Marca();
		marca.setId(idMarca);
		return this.carroRepository.findByMarca(marca);
	}
	
	public List<Carro> findAcimaAno(int ano){
		return this.carroRepository.findAcimaAno(ano);
	}

	
}
