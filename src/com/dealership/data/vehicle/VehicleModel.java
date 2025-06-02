package com.dealership.data.vehicle;

public enum VehicleModel {
	
    CAMRY(VehicleMake.TOYOTA, VehicleType.SEDAN),
    
    RAV4(VehicleMake.TOYOTA, VehicleType.SUV),
    
    CIVIC(VehicleMake.HONDA, VehicleType.SEDAN),
    
    F150(VehicleMake.FORD, VehicleType.TRUCK),
    
    MUSTANG(VehicleMake.FORD, VehicleType.COUPE),
    
    TAHOE(VehicleMake.CHEVROLET, VehicleType.SUV),
    
    MODEL_3(VehicleMake.TESLA, VehicleType.SEDAN),
    
    WRANGLER(VehicleMake.JEEP, VehicleType.SUV),
    
    X5(VehicleMake.BMW, VehicleType.SUV),
    
    A4(VehicleMake.AUDI, VehicleType.SEDAN),
    
    ELANTRA(VehicleMake.HYUNDAI, VehicleType.SEDAN),
    
    SORENTO(VehicleMake.KIA, VehicleType.SUV);

    private final VehicleMake make;
    private final VehicleType type;

    VehicleModel(VehicleMake make, VehicleType type) {
        this.make = make;
        this.type = type;
    }

    public VehicleMake getMake() {
        return make;
    }

    public VehicleType getType() {
        return type;
    }
}

