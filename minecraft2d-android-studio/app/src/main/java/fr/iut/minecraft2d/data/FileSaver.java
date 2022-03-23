package fr.iut.minecraft2d.data;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * This class will save the data in a file
 */
public class FileSaver implements Sauveur {
    @Override
    public void save(FileOutputStream file, int toSave){
        try (ObjectOutputStream oos = new ObjectOutputStream(file)){
            oos.writeObject(toSave);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
