package com.supermercado.pruebatecnica.repository;

import com.supermercado.pruebatecnica.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository <Sucursal, Long> {
}
