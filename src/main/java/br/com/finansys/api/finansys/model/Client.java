package br.com.finansys.api.finansys.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.finansys.api.finansys.model.enums.Perfil;
import br.com.finansys.api.finansys.model.enums.TipoCliente;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "CLIENT")
@Entity
@Data
@AllArgsConstructor
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "ID do Cliente ")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENT")
	private Long id;

	@ApiModelProperty(value = "Nome do Cliente ")
	private String name;

	@ApiModelProperty(value = "Email do Cliente ")
	@Column(unique = true)
	private String email;

	@ApiModelProperty(value = "CPF ou CNPJ do Cliente ")
	private String cpfOrCnpj;

	@ApiModelProperty(value = "Tipo do Cliente pode ser PESSOA_FISICA ou PESSOA_JURIDICA")
	private Integer type;

	@JsonIgnore
	private String password;

	@ApiModelProperty(value = "Perfil do Cliente  pode ser ADMIN ou USUARIO")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	private Set<Integer> perfis = new HashSet<>();

	@ApiModelProperty(value = "URL da imagem do Cliente")
	private String imageUrl;

	public Client() {
		addPerfil(Perfil.CLIENT);
	}

	public Client(Long id, String nome, String email, String cpfOuCnpj, TipoCliente tipo, String senha) {
		super();
		this.id = id;
		this.name = nome;
		this.email = email;
		this.cpfOrCnpj = cpfOuCnpj;
		this.type = (tipo == null) ? null : tipo.getCod();
		this.password = senha;
		addPerfil(Perfil.CLIENT);
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(type);
	}

	public void setTipo(TipoCliente tipo) {
		this.type = tipo.getCod();
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

}
