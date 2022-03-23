package fr.iut.minecraft2d.data;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * This class will prepare and load data in a file
 */
public class FileLoader implements Loader{
    @Nullable @Override
    public Serializable load(@NonNull FileInputStream file) {
        Serializable retour = null;
        try (ObjectInput ois = new ObjectInputStream(file)){
            retour = (Serializable) ois.readObject();

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return retour;
    }
}
