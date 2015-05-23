package org.nuxeo.demo.dam.core.operations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michaël on 21/05/2015.
 */
public class PaletteGeneration {

    public static void main(String[] args) {
        List<HSLColor> colors = new ArrayList<>();
        for (int i = 0; i < NxColors.HUE.length - 1; i++) {
            HSLColor color = new HSLColor(NxColors.HUE[i],NxColors.SATURATION,NxColors.LIGHTNESS,0);
            colors.add(color);
        }
        //Add white
        colors.add(new HSLColor(HSLColor.MIN_HUE,HSLColor.MIN_SATURATION,HSLColor.MAX_LIGHTNESS,0));
        //Add gray
        colors.add(new HSLColor(HSLColor.MIN_HUE, HSLColor.MIN_SATURATION, HSLColor.MAX_LIGHTNESS/2, 0));
        //Add Black
        colors.add(new HSLColor(HSLColor.MIN_HUE, HSLColor.MIN_SATURATION, HSLColor.MIN_LIGHTNESS, 0));

        // Return the buffered image
        File outputfile = new File("palette.csv");
        try {
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(outputfile));
            out.write("id, label, parent, obsolete\n");
            for (int i=0;i<colors.size();i++) {
                String id = String.format("%08X", colors.get(i).toRGB()).substring(2, 8);
                out.write("\""+id+"\",\""+NxColors.COLOR_NAMES[i]+"\",\"\",\"0\"\n");
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
