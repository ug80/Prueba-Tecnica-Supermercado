package com.supermercado.pruebatecnica.mapper;

import com.supermercado.pruebatecnica.dto.DetalleVentaDTO;
import com.supermercado.pruebatecnica.dto.ProductoDTO;
import com.supermercado.pruebatecnica.dto.SucursalDTO;
import com.supermercado.pruebatecnica.dto.VentaDTO;

import com.supermercado.pruebatecnica.model.Producto;
import com.supermercado.pruebatecnica.model.Sucursal;
import com.supermercado.pruebatecnica.model.Venta;

import java.util.stream.Collectors;



public class Mapper {


    public static ProductoDTO toDTO (Producto p){
        if(p == null) return null;

        return ProductoDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .categoria(p.getCategoria())
                .precio(p.getPrecio())
                .build();
    }


    public static SucursalDTO toDTO(Sucursal s){
        if(s == null) return null;

        return SucursalDTO.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .direccion(s.getDirecion())
                .build();
    }







    public static VentaDTO toDTO(Venta venta){
        if(venta == null) return null;



        var detalle = venta.getDetalle().stream().map(det ->
                        DetalleVentaDTO.builder()
                                .id(det.getProd().getId())
                                .nombreProd(det.getProd().getNombre())
                                .cantProd(det.getCantprod())
                                .precio(det.getPrecio())
                                .subtotal(det.getPrecio() * det.getCantprod())
                                .build()
                ).collect(Collectors.toList());

        var total = detalle.stream()
                .map(DetalleVentaDTO::getSubtotal)
                .reduce(0.0, Double::sum);

        return VentaDTO.builder()
                .id(venta.getId())
                .fecha(venta.getFecha())
                .idSucursal(venta.getSucursal().getId())
                .estado(venta.getEstado())
                .detalle(detalle)
                .total(total)
                .build();

    }


}
