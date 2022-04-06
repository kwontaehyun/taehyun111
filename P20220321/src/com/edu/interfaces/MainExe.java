package com.edu.interfaces;

public class MainExe {

	public static void main(String[] args) {
		// 리모콘 -> TV, radio, 냉장고.
		RemoteControl rm = new TV();
		rm.PowerOn();
		rm.PowerOff();
		
		
		RemoteControl rm2 = new Radio();
		rm2.PowerOn();
		rm2.PowerOff();
		RemoteControl rm3 = new Refrigerator();
		rm3.PowerOn();
		rm3.PowerOff();
	}

}
