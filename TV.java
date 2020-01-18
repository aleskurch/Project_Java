package com.company;


import javax.xml.datatype.DatatypeFactory;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.Serializable;


public abstract class TV implements Serializable {


    protected String name= new String();
    protected int number_chanel;
    protected Calendar date = new GregorianCalendar();


    public void setName(String name) {
        this.name = name;
    }

    public void setNumber_chanel(int number_chanel) {
        this.number_chanel = number_chanel;
    }


    public String getName() {
        return name;
    }

    public int getNumber_chanel() {
        return number_chanel;
    }

    public Calendar getDate() {
        return date;
    }

    public TV()
    {
        name="Name";
        number_chanel = 111;
        date.set(Calendar.HOUR, 11);
        date.set(Calendar.MINUTE, 11);
        date.set(Calendar.DAY_OF_MONTH, 11);
        date.set(Calendar.MONTH, 11);
        date.set(Calendar.YEAR, 1111);
    }

    @Override
    public abstract String toString();
}
