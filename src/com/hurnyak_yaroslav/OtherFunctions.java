package com.hurnyak_yaroslav;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static com.hurnyak_yaroslav.Main.taksopark;

public class OtherFunctions {
    public static void getInfo() {
        System.out.println("Available commands: \n" +
                "- read;\n" +
                "- addcar <name> <breakdown> <maxSpeed> <cost> <SEDAN|HATCHBAK|VERSATILE|PICKUP>;\n" +
                "- getfast <speed1> <speed2>;\n" +
                "- delete <ID>;\n" +
                "- getall;\n" +
                "- sort;\n" +
                "- sortr;\n" +
                "- save;\n" +
                "- getcost;\n" +
                "- exit.\n");
    }

    static public void toTheFile() {
        Ser s = new Ser(taksopark.getList());
        try {

            FileOutputStream fo = new FileOutputStream("E:\\s.bin");
            ObjectOutputStream serial = new ObjectOutputStream(fo);
            serial.writeObject(s);
            fo.close();
        } catch (Exception ex) {
            System.out.println("WriteERROR!!!");
            ex.printStackTrace();
        }

    }

    static public void fromTheFile() {

        try {

            FileInputStream fin = new FileInputStream("E:\\s.bin");
            ObjectInputStream ois = new ObjectInputStream(fin);
            Ser restored = (Ser) ois.readObject();
            taksopark.setList(restored.getList());
            fin.close();
        } catch (Exception ex) {
            System.out.println("ReadEROOR!!!");
            ex.printStackTrace();
        } finally {

        }

    }
}
