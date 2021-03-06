package br.com.finansys.api.finansys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.finansys.api.finansys.model.Category;
import br.com.finansys.api.finansys.repositories.CategoryRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository repo;

	@Override
	public Category saveCategory(Category category) {
		return repo.save(category);
	}

	@Override
	public Category editCategory(Category category, Long id) throws Exception {
		Category categoryById = this.getCategoryById(id);
		categoryById.setName(category.getName());
		categoryById.setDescription(category.getDescription());
		return categoryById;
	}

	@Override
	public void deleteCategory(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Category> getAllCategory() {
		return repo.findAll();
	}

	@Override
	public Category getCategoryById(Long id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("Nao encontrado"));
	}

}
