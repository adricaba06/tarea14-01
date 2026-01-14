package com.salesianostriana.dam.fleetManager.exceptions;

public class VehiculoNotFoundException extends RuntimeException {
    public VehiculoNotFoundException(String message) {
        super(message);
    }

  public VehiculoNotFoundException(Long id){
      super("Vehiculo con id" + id+ "no encontrado");
  }
}
