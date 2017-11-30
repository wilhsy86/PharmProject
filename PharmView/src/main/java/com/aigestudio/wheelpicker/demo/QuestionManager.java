package com.aigestudio.wheelpicker.demo;

import android.content.res.AssetManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class QuestionManager {

    public QuestionManager() throws IOException {
        String fileName = "Drugs.txt";
        String[] colors = {"Red", "Lime", "Orange", "Brown", "Blue", "Grey",
                "Yellow", "Green", "Pink", "Purple", "Maroon", "White", "Black"
        };
        List<String> colorList = Arrays.asList(colors);

//        LinkedList<String> drugAttributes = new LinkedList<>();
//        ArrayList<LinkedList> drugObjects = new ArrayList<>();
        int ind = 0;
        try {
            File file = new File("@assets/drugs");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\t|\r\n");

            while (scanner.hasNextLine()) {
                String input = scanner.next();
                System.out.println(input);
//                drugAttributes.add(input);

                if (colorList.contains(input)) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                            + fileName + "'");
        }
    }

}
