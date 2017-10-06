package com.github.jmodel.japp.example.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jmodel.adapter.api.persistence.Action;
import com.github.jmodel.japp.AbstractAction;
import com.github.jmodel.japp.example.domain.entity.News;

/**
 * 
 * 
 * @author jianni@hotmail.com
 *
 */
public class InsertNewsAction extends AbstractAction implements Action<JpaRepository<News, Long>, News, Long> {

	@Override
	public Long apply(JpaRepository<News, Long> repository, News news) {
		return repository.save(news).getId();
	}

	@Override
	public String getItemId() {
		return "InsertNewsAction";
	}

}
