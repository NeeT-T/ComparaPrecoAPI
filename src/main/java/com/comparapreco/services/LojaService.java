package com.comparapreco.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.comparapreco.dtos.LojaDTO;
import com.comparapreco.models.Loja;
import com.comparapreco.repository.ILojaRepository;
import com.comparapreco.specifications.LojaSpecification;

@Service
public class LojaService {

	@Autowired
	ILojaRepository iLojaRepository;

	// @Cacheable("lojas")
	public Page<LojaDTO> findAll( String nome, String telefone, String cnpj, String localizacao, Integer page, Integer size, String direction, String orderby) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderby);
		LojaSpecification specification = new LojaSpecification(nome, telefone, cnpj, localizacao);
		Page<Loja> lojasFromDB = (Page<Loja>) iLojaRepository.findAll(specification, pageRequest);  // Qual o tipo de dado que o banco retorna? No caso de não haver o cast
		List<LojaDTO> lojas = lojasFromDB.stream()
				.map(loja -> new LojaDTO(loja)).collect(Collectors.toList());
		return new PageImpl<LojaDTO>(lojas, pageRequest, lojasFromDB.getTotalElements());
	}

}