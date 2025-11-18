package com.supermercado.pruebatecnica.repository;

import com.supermercado.pruebatecnica.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository <Producto, Long> {
}
