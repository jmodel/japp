package com.github.jmodel.japp.example.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.jmodel.japp.example.domain.entity.News;

public interface NewsRepository extends JpaRepository<News, String> {

}
