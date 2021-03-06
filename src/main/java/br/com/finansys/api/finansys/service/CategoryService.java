package br.com.finansys.api.finansys.service;

import java.util.List;

import br.com.finansys.api.finansys.model.Category;

public interface CategoryService {

	Category saveCategory(Category category);

	Category editCategory(Category category, Long id) throws Exception;

	void deleteCategory(Long id);

	List<Category> getAllCategory();

	Category getCategoryById(Long id) throws Exception;

}
