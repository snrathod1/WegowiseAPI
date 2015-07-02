package com.joulebug.readability;

/**
 * Created with IntelliJ IDEA.
 * User: ShraddhaRathod
 * Date: 6/26/2015
 * Time:
 * To change this template use File | Settings | File Templates.
 */

import java.lang.reflect.Array;

/**
 {
 "structure_type": "building",
 "denominator_name": "sqft",
 "data_type": "electric",
 "unit": "btu"
 "filters": [
    {
 "name": "sqft",
 "operation": ">",
 "value": "2000"
     },

    {
 "name": "n_bedrooms",
 "operation": "=",
 "value": "2"
    },

    {
 "name": "building_type",
 "operation": "=",
 "value": "lowrise"
    }
 ]
 }

  */
public class Parser {

    private String structure_type;
    private String denominator_name;
    private String data_type;
    private String unit;
    private String[] filters;
    private String name;
    private String operation;
    private String value;

    public String getStructure_type() {
        return structure_type;
    }

    public void setAccount_number(String structure_type) {
        this.structure_type = structure_type;
    }

    public String getDenominator_name() {
        return denominator_name;
    }

    public void setDenominator_name(String denominator_name) {
        this.denominator_name = denominator_name;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String[] getFilters()
    {
        return filters;
    }
    public void setFilters(String[] filters, String name, String operation, String value)
    {

        this.filters = new String [3];
        this.name = name;
        this.operation = operation;
        this.value = value;

        filters[0] = name;
        filters[1] = operation;
        filters[2] = value;

    }

}
