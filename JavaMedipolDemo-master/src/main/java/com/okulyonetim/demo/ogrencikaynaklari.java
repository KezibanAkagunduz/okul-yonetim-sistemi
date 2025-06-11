package com.okulyonetim.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ogrencikaynaklari extends JpaRepository<Ogrenci, Long> {}
