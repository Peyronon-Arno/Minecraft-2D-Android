package fr.iut.minecraft2d.data;


import java.io.FileInputStream;

/**
 * This interface will allow to load a file containing datas
 */
public interface Loader {
    Object load(FileInputStream fichier);

}
