package br.com.systemsgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemsgs.model.ModelClientes;

@Repository
public interface ClienteRepository extends JpaRepository<ModelClientes, Long>{

}
