package com.supermercado.pruebatecnica.service;

import com.supermercado.pruebatecnica.dto.ProductoDTO;
import com.supermercado.pruebatecnica.exception.NotFoundException;
import com.supermercado.pruebatecnica.mapper.Mapper;
import com.supermercado.pruebatecnica.model.Producto;
import com.supermercado.pruebatecnica.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository repo;

    @Override
    public List<ProductoDTO> traerProductos() {

        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDto) {
        var prod = Producto.builder()
                .nombre(productoDto.getNombre())
                .categoria(productoDto.getCategoria())
                .precio(productoDto.getPrecio())
                .cantidad(productoDto.getCantidad())
                .build();

        return Mapper.toDTO(repo.save(prod));
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDto) {
        //Buscar si existe el producto
        Producto prod = repo.findById(id)
                .orElseThrow(()-> new NotFoundException("Producto no encontrado"));

        prod.setNombre(productoDto.getNombre());
        prod.setPrecio(productoDto.getPrecio());
        prod.setCantidad(productoDto.getCantidad());
        prod.setCategoria(prod.getCategoria());

        return Mapper.toDTO(repo.save(prod));
    }

    @Override
    public void eliminarProducto(Long id) {

        if(!repo.existsById(id)){
            throw new NotFoundException("Producto no encontrado. NO se pudo eliminar");
        }
        repo.deleteById(id);

    }
}









