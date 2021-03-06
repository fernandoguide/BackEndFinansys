package br.com.finansys.api.finansys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.finansys.api.finansys.model.Entry;
import br.com.finansys.api.finansys.repositories.EntryRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EntryServiceImpl implements EntryService {

	private final EntryRepository repo;

	@Override
	public Entry saveEntry(Entry entry) {
		return repo.save(entry);
	}

	@Override
	public Entry editEntry(Entry entry, Long id) throws Exception {
		Entry entryById = this.getEntryById(id);
		entryById.setAmount(entry.getAmount());
		entryById.setDescription(entry.getDescription());
		entryById.setName(entry.getName());
		entryById.setPaid(entry.getPaid());
		return entryById;
	}

	@Override
	public void deleteEntry(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Entry> getAllEntry() {
		return repo.findAll();
	}

	@Override
	public Entry getEntryById(Long id) throws Exception {
		return repo.findById(id).orElseThrow(() -> new Exception("Nao encontrado"));

	}

}
