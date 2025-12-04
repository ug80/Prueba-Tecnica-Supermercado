package com.supermercado.pruebatecnica.service;

import com.supermercado.pruebatecnica.dto.SucursalDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements ISucursalService{
    @Override
    public List<SucursalDTO> traerSucursales() {
        return List.of();
    }

    @Override
    public SucursalDTO crearSucursal(SucursalDTO sucursalDTO) {
        return null;
    }

    @Override
    public SucursalDTO actualizarSucrsal(Long id, SucursalDTO sucursalDTO) {
        return null;
    }

    @Override
    public void eliminarSucursal(Long id) {

    }
}
