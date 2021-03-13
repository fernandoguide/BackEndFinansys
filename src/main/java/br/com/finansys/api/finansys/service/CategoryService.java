package br.com.finansys.api.finansys.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.finansys.api.finansys.dto.CategoryDTO;
import br.com.finansys.api.finansys.model.Category;

public interface CategoryService {

	Category insert(Category category);

	Category update(Category category);

	void delete(Long id);

	List<Category> findAll();

	Category find(Long id);

	Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);

	Category fromDTO(CategoryDTO objDto);

}
