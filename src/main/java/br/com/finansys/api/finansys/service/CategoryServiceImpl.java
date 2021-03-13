package br.com.finansys.api.finansys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.finansys.api.finansys.dto.CategoryDTO;
import br.com.finansys.api.finansys.exceptions.DataIntegrityExecpition;
import br.com.finansys.api.finansys.exceptions.ObjectNotFoundExecpition;
import br.com.finansys.api.finansys.model.Category;
import br.com.finansys.api.finansys.repositories.CategoryRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository repo;

	@Override
	public Category find(Long id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExecpition(
				"Objeto nao encontrado! Id: " + id + " Tipo: " + Category.class.getName()));
	}

	@Override
	public Category insert(Category obj) {
		obj.setId(null);
		return repo.saveAndFlush(obj);
	}

	@Override
	public Category update(Category obj) {
		Category newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	@Override
	public void delete(Long id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExecpition("Não é possivel exluir uma categoria que possiu produtos.");
		}
	}

	@Override
	public List<Category> findAll() {
		return repo.findAll();
	}
	@Override
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	@Override
	public Category fromDTO(CategoryDTO objDto) {
		return new Category(objDto.getId(), objDto.getName(), objDto.getDescription());
	}

	private void updateData(Category newObj, Category obj) {
		newObj.setName(obj.getName());
		newObj.setDescription(obj.getDescription());
	}
}
