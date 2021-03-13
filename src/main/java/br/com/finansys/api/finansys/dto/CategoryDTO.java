package br.com.finansys.api.finansys.dto;

import java.io.Serializable;

import br.com.finansys.api.finansys.model.Category;
import lombok.Data;

@Data
public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String description;

	public CategoryDTO(Category obj) {

		id = obj.getId();
		name = obj.getName();
		description = obj.getDescription();
	}

}