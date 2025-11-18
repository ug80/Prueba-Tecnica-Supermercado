package com.supermercado.pruebatecnica.repository;

import com.supermercado.pruebatecnica.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository <Venta, Long> {
}
