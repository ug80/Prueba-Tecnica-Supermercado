package com.supermercado.pruebatecnica.service;

import com.supermercado.pruebatecnica.dto.SucursalDTO;

import java.util.List;

public interface ISucursalService {
    List<SucursalDTO> traerSucursales();
    SucursalDTO crearSucursal(SucursalDTO sucursalDTO);
    SucursalDTO actualizarSucrsal(Long id, SucursalDTO sucursalDTO);
    void eliminarSucursal(Long id);

}
