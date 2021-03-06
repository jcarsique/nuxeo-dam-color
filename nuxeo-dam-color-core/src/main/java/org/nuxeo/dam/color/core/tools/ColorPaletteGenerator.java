package org.nuxeo.dam.color.core.tools;

import org.nuxeo.dam.color.core.model.palette.ColorPalette;
import org.nuxeo.dam.color.core.model.palette.group.ColorGroup;

import java.io.*;

/**
 * Created by Michaël on 21/05/2015.
 */
public class ColorPaletteGenerator {

    public static void main(String[] args) {
        File outputfile = new File("colors.csv");
        try {
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(outputfile));
            out.write("id, label, parent, obsolete\n");
            for (ColorGroup group : ColorPalette.COLORS_LIST) {
                out.write("\""+group.average().toRGBHex()+"\",\""+group.getName()+"\",\"\",\"0\"\n");
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
