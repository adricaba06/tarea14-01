package com.salesianostriana.dam.fleetManager.exceptions;

public class ThisVehiculoAlreadyHasAnAsignaccion extends RuntimeException {
    public ThisVehiculoAlreadyHasAnAsignaccion(String message) {
        super(message);
    }

  public ThisVehiculoAlreadyHasAnAsignaccion(Long id) {
    super("Vehiculo con id: " + id + "ya tiene una asignación");
  }

  public ThisVehiculoAlreadyHasAnAsignaccion() {
    super("Vehiculo ya tiene una asignación");
  }
}
