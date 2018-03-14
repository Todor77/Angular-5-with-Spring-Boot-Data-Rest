package de.isys.demo;

public class GreeterLowercaseImplementation implements GreeterService {
	@Override
	public String transformation(String name) {
		return name.toLowerCase();
	}
}
