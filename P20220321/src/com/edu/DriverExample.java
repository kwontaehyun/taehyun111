package com.edu;

public class DriverExample {

	public static void main(String[] args) {
		
		Vehicle v1 = new Vehicle();
		v1 = new Taxi();
		Vehicle v2= new Vehicle();
		v2 = new Bus();
		Driver driver = new Driver();
		driver.drive(v1);
		driver.drive(v2);
		
		Vehicle vehicle = new Vehicle();
		Taxi taxi = new Taxi();
		Bus bus = new Bus();
		
		System.out.println(vehicle.getMaxSpeed());
		System.out.println(bus.getMaxSpeed());
		System.out.println(taxi.getMaxSpeed());
		
		Vehicle[] vehicles = new Vehicle[3];
		vehicles[0] = vehicle;
		vehicles[1] = taxi;
		vehicles[2] = bus;
		//속도가 빠른대로 정렬
		
		Vehicle vehiclesEX = null;
		for(int i=0; i<vehicles.length; i++)
		{
			for(int j=0; j<vehicles.length; j++)
			if(vehicles[i].getMaxSpeed() > vehicles[j].getMaxSpeed())
			{
				vehiclesEX = vehicles[i];
				vehicles[i] = vehicles[j];
				vehicles[j] = vehiclesEX;
			}
		}
		for(int i=0; i<vehicles.length; i++)
			System.out.println(vehicles[i].toString());
		
	}

}
