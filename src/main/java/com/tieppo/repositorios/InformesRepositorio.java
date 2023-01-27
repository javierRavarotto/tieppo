package com.tieppo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tieppo.entidades.Informes;
@Repository
public interface InformesRepositorio extends JpaRepository <Informes,Integer> {

}
