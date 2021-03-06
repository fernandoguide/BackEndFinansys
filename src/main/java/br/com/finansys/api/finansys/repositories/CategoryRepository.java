package br.com.finansys.api.finansys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.finansys.api.finansys.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
