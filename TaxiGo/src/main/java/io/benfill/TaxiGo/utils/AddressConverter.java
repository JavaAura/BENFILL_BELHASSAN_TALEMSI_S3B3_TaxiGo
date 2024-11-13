package io.benfill.TaxiGo.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class AddressConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String address) {
        return address;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }
}
