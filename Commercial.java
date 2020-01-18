package com.company;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.Serializable;

public class Commercial extends TV implements Not_work, Serializable {
   private int count_of_pauses;
   private int price;
   private String surname;
   public Commercial(){
       count_of_pauses=0;
       price=0;
       surname="Surname";
   }


   public Commercial Read(Scanner sc) throws IOException {
            String danny = sc.nextLine();
            StringTokenizer st = new StringTokenizer(danny, " /:");
            name= st.nextToken();
            number_chanel = Integer.parseInt(st.nextToken());
            date.set(Calendar.HOUR, Integer.parseInt(st.nextToken()));
            date.set(Calendar.MINUTE, Integer.parseInt(st.nextToken()));
            date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(st.nextToken()));
            date.set(Calendar.MONTH, Integer.parseInt(st.nextToken()));
            date.set(Calendar.YEAR, Integer.parseInt(st.nextToken()));
            count_of_pauses = Integer.parseInt(st.nextToken());
            price = Integer.parseInt(st.nextToken());
            surname = st.nextToken();
            return this;
    }

    public int getCount_of_pauses() {
        return count_of_pauses;
    }

    public int getPrice() {
        return price;
    }

    public String getSurname() {
        return surname;
    }

    public void setCount_of_pauses(int count_of_pauses) {
        this.count_of_pauses = count_of_pauses;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Commercial Write_Malysheva() throws IOException
    {
                if(Malysheva(this))
                {
                   name= "Error";
                   number_chanel = 0;
                   date.set(Calendar.HOUR, 0);
                   date.set(Calendar.MINUTE, 0);
                   date.set(Calendar.DAY_OF_MONTH, 1);
                   date.set(Calendar.MONTH, 1);
                   date.set(Calendar.YEAR,1111);
                   count_of_pauses = 0;
                   price = 0;
                   surname = "DELITED!!!";
                }
                return this;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ")
                .append(this.number_chanel).append(" ")
                .append(this.date.get(Calendar.HOUR)).append(":")
                .append(this.date.get(Calendar.MINUTE)).append(" ")
                .append(this.date.get(Calendar.DAY_OF_MONTH)).append("/")
                .append(this.date.get(Calendar.MONTH)).append("/")
                .append(this.date.get(Calendar.YEAR)).append(" ")
                .append(count_of_pauses).append(" ")
                .append(price).append(" ")
                .append(surname);
        return sb.toString();
    }

    public boolean Malysheva(Commercial A) {

        if (A.surname.equals("Малышева"))
        {
            return true;
        }
        else return false;
    }
    public boolean autorize() throws FileNotFoundException {
        File file = new File("DataBase.txt");
        Scanner sc = new Scanner(file);
        //int danny = sc.nextLine();
        return false;
    }
}
