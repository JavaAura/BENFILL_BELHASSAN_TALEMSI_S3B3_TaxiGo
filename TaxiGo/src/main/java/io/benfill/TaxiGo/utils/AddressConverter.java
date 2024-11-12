package io.benfill.TaxiGo.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import io.benfill.TaxiGo.model.Address;

@Converter
public class AddressConverter implements AttributeConverter<Address, String> {
    private static final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(Address address) {
        if (address == null) {
            return null;
        }
        
        return String.format("%s%s%s", 
            address.getCity(), 
            SEPARATOR, 
            address.getNeighborhood());
    }

    @Override
    public Address convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().isEmpty()) {
            return null;
        }
        
        String[] parts = dbData.split(SEPARATOR);
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid address format");
        }
        
        return new Address(parts[0], parts[1]);
    }
}
