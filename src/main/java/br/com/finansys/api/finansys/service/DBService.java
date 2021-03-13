package br.com.finansys.api.finansys.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.finansys.api.finansys.model.Category;
import br.com.finansys.api.finansys.model.Client;
import br.com.finansys.api.finansys.model.enums.Perfil;
import br.com.finansys.api.finansys.model.enums.TipoCliente;
import br.com.finansys.api.finansys.repositories.CategoryRepository;
import br.com.finansys.api.finansys.repositories.ClientRepository;

@Service

public class DBService {

	@Autowired
	private CategoryRepository categoriaRepository;
	@Autowired
	private ClientRepository clienteRepository;

	private BCryptPasswordEncoder pe;

	public void instantiateTestDatabase() {

		Category cat1 = new Category(null, "Hardware", "");
		Category cat2 = new Category(null, "Acessorios", "");
		Category cat3 = new Category(null, "Perifericos", "");
		Category cat4 = new Category(null, "Monitores", "");
		Category cat5 = new Category(null, "Computador", "");
		Category cat6 = new Category(null, "Notebooks", "");
		Category cat7 = new Category(null, "SmartFones", "");
		Category cat8 = new Category(null, "All", "");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));

		Client cli1 = new Client(null, "Administrador", "eletronicstore2020@gmail.com", "31628382740",
				TipoCliente.PESSOAFISICA, pe.encode("admin"));

		Client cli2 = new Client(null, "Fernando Oliveira", "fernandoguide2014@gmail.com", "31628382740",
				TipoCliente.PESSOAFISICA, pe.encode("admin"));

		Client cli3 = new Client(null, "usuario", "usuario@gmail.com", "36378912377", TipoCliente.PESSOAFISICA,
				pe.encode("123"));

		Client cli4 = new Client(null, "Eletronic Store", "eletronicstore2020@outlook.com", "18221300000166",
				TipoCliente.PESSOAJURIDICA, pe.encode("admin"));

		cli1.addPerfil(Perfil.ADMIN);

		cli2.addPerfil(Perfil.ADMIN);

		cli4.addPerfil(Perfil.ADMIN);

		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4));

	}
}
