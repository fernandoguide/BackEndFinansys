package br.com.finansys.api.finansys.service;

import java.util.List;

import br.com.finansys.api.finansys.model.Entry;

public interface EntryService {

	Entry saveEntry(Entry entry);

	Entry editEntry(Entry entry, Long id) throws Exception;

	void deleteEntry(Long id);

	List<Entry> getAllEntry();

	Entry getEntryById(Long id) throws Exception;

}
