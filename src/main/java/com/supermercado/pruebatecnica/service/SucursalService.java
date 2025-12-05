package com.supermercado.pruebatecnica.service;

import com.supermercado.pruebatecnica.dto.SucursalDTO;
import com.supermercado.pruebatecnica.exception.NotFoundException;
import com.supermercado.pruebatecnica.mapper.Mapper;
import com.supermercado.pruebatecnica.model.Sucursal;
import com.supermercado.pruebatecnica.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements ISucursalService{

    @Autowired
    private SucursalRepository repo;

    @Override
    public List<SucursalDTO> traerSucursales() {

        return repo.findAll()
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }

    @Override
    public SucursalDTO crearSucursal(SucursalDTO sucursalDTO) {
        Sucursal suc = Sucursal.builder()
                .nombre(sucursalDTO.getNombre())
                .direcion(sucursalDTO.getDireccion())
                .build();

        return Mapper.toDTO(repo.save(suc));

    }

    @Override
    public SucursalDTO actualizarSucrsal(Long id, SucursalDTO sucursalDTO) {
        Sucursal suc = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Sucursal no encontrada"));

        suc.setNombre(sucursalDTO.getNombre());
        suc.setDirecion(sucursalDTO.getDireccion());


        return Mapper.toDTO(repo.save(suc));
    }

    @Override
    public void eliminarSucursal(Long id) {
        if(!repo.existsById(id)){
            throw new NotFoundException("Sucursal no encontrada. No se pudo eliminar");
        }
    }
}
