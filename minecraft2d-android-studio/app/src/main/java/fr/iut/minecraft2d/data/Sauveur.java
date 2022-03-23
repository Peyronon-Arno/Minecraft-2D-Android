package fr.iut.minecraft2d.data;

import java.io.FileOutputStream;

/**
 * This interface will allow to save datas
 */
public interface Sauveur {
    void save(FileOutputStream file, int toSave);

}
