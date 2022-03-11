package com.dh.proyectointegradorctd.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Converter(autoApply = true)
public class StringListConverter implements AttributeConverter<List<String>, String> {

    /* =============== Atributos =================== */

    private static final String SPLIT_CHAR = ",";

    /* =============== Métodos ===================== */

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return attribute != null ? String.join(SPLIT_CHAR, attribute) : "";
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return dbData != null ? Arrays.asList(dbData.split(SPLIT_CHAR)) : Collections.emptyList();
    }
}
