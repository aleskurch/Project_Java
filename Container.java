package com.company;

import javax.xml.datatype.DatatypeConfigurationException;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Container {
    private ArrayList<Commercial> Cont = new ArrayList<>();

    public void Read() throws IOException, DatatypeConfigurationException {
        File file = new File("input.txt");
        RandomAccessFile raf = new RandomAccessFile("input.txt", "rw");
        raf.writeBytes("NLOS");
        Scanner sc = new Scanner(file);
        for(int i=0; i<6; i++)
        {
            Commercial A1= new Commercial();
            Cont.add(i, A1.Read(sc));
        }

    }
    public void Write()
    {
        for(int i=0; i<6; i++)
    {
        System.out.println(Cont.get(i));
    }
    }
    public void Malysheva() throws IOException {
        for(int i=0; i<6; i++)
        {

            Cont.get(i).Write_Malysheva();
        }
    }

    public void setCont(ArrayList<Commercial> cont) {
        Cont = cont;
    }

    public ArrayList<Commercial> getCont() {
        return Cont;
    }

    public void XML()
    {
        try {
            FileOutputStream foo = new FileOutputStream("foo.xml");
            XMLEncoder xenc = new XMLEncoder(foo);
            xenc.writeObject(Cont);
            xenc.close();
            foo.close();
            FileInputStream os = new FileInputStream("foo.xml");
            XMLDecoder dcr = new XMLDecoder(os);
            setCont((ArrayList<Commercial>) dcr.readObject());
            dcr.close();
            System.out.println("----------------------\n");
            Write();
        } catch (Exception e) {
            e.printStackTrace();}
    }
    public void Binary() throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Cont);
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        setCont((ArrayList<Commercial>) ois.readObject());
        System.out.println("----------------------\n");
        Write();
        ois.close();
        oos.close();
    }
}
