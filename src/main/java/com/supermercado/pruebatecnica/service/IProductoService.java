package com.supermercado.pruebatecnica.service;

import com.supermercado.pruebatecnica.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {
    List<ProductoDTO> traerProductos();
    ProductoDTO crearProducto(ProductoDTO productoDto);
    ProductoDTO actualizarProducto(Long id, ProductoDTO procutoDto);
    void eliminarProducto(Long id);
}
