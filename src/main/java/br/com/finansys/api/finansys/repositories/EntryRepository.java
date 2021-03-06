package br.com.finansys.api.finansys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.finansys.api.finansys.model.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

}
