package com.wallacecarlos.Usuario.infrastructure.repository;

import com.wallacecarlos.Usuario.infrastructure.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface enderencoRepository extends JpaRepository<Endereco,Long> {
}
//import com.wallacecarlos.Usuario.infrastructure.entity.Telefone;