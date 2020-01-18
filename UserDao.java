package com.company;

import java.io.*;
import java.rmi.NoSuchObjectException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class UserDao {
    public void saveUser(String name, String password) throws IOException {
        FileWriter writer= new FileWriter("users.txt",true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(name + " " + password+"\n");
        bufferedWriter.close();
    }

    public int findByName(String name) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("users.txt"));
        String line;
        int counter = 0;
        while((line = bufferedReader.readLine()) != null){
            if(line.contains(name)){
                return counter;
            }
            counter++;
        }
        return -1;
    }

    public int indexOfUser(String name, String password) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("users.txt"));
        String line;
        int counter=0;
        while((line = bufferedReader.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line, " ");
            if((name.equals(st.nextToken()))&& password.equals(st.nextToken())){
                return counter;
            }
            counter++;
        }
        return -1;
    }
}
