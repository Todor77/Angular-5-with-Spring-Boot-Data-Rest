package de.isys.demo;

public class GreeterUppercaseImplementation implements GreeterService {
	@Override
	public String transformation(String name) {
		return name.toUpperCase();
	}
}
