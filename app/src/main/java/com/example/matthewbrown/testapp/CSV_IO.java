package com.example.matthewbrown.testapp;

/**
 * Created by MatthewBrown on 3/3/2017.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.*;

import static java.lang.Character.isDigit;

public class CSV_IO {
    public Iterator itemIterator()
    {
        //TODO: Do this.
    return null;
    }

    //Does not work, do not use this method.
    public void sendToCSV() throws IOException
    {

        FileWriter toCSV = new FileWriter("data.csv");
        Iterator i = itemIterator();
        while (i.hasNext())
        {
            FoodItem current = (FoodItem) i.next();
            toCSV.append(current.getItemName());
            toCSV.append(",");
            toCSV.append(String.valueOf(current.getAmount()));
            toCSV.append(",");
            toCSV.append(String.valueOf(current.getDaysLeft()));
            toCSV.append(",");
            toCSV.append(String.valueOf(current.getUsagePerDay()));
            toCSV.append("\n");
        }
        toCSV.flush();
        toCSV.close();
    }

    public void writeToFile(String name, String amount, String daysLeft, String usagePerDay, String path) throws IOException
    {
        File f = new File(path+"/data.txt");
        FileOutputStream fOut = new FileOutputStream(f);
        OutputStreamWriter osw = new OutputStreamWriter(fOut);
        osw.write(name);
        osw.write(",");
        osw.write(amount);
        osw.write(",");
        osw.write(daysLeft);
        osw.write(",");
        osw.write(usagePerDay);
        osw.write("\n");
        osw.flush();
        osw.close();
    }

    //Reads the whole file, probably not useful for actual usage, just for development
    public void readFile(String path) throws IOException
    {
        File f = new File(path+"/data.txt");
        FileInputStream fIn = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fIn);
        char[] inputBuffer = new char[50];
        isr.read(inputBuffer);
        String readString = new String(inputBuffer);
        System.out.println(readString);
        isr.close();
        fIn.close();
    }

    //TODO: Implement this correctly. Right now it has more spaghetti than Olive Garden.
    //It should return an array list
    public ArrayList<FoodItem> getPantry(String path)
    {
        File f = new File(path+"/data.txt");
        ArrayList<FoodItem> toReturn = new ArrayList<FoodItem>();
        FoodItem f1 = new FoodItem();
        try {
            FileInputStream fIn = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fIn);
            char[] inputBuffer = new char[50];
            isr.read(inputBuffer);
            String readString = new String(inputBuffer);
            String foodName;
            String quantity;
            for(int i = 0; i < readString.length(); i++)
            {
                boolean haveName = false;
                boolean haveQuantity = false;
                boolean haveDaysLeft = false;
                boolean haveUsage = false;

                if(readString.charAt(i) == ',' && !haveName && !haveQuantity && !haveDaysLeft && !haveUsage)
                {
                    haveName = true;
                    foodName = readString.substring(0,i-1);
                    f1.setItemName(foodName);
                }
                if(haveName && isDigit(readString.charAt(i)))
                {
                    if(readString.charAt(i+1) == '.' || isDigit(readString.charAt(i+1)))
                    {
                        if(readString.charAt(i+2) == '.' || isDigit(readString.charAt(i+2)))
                        {
                            quantity = readString.substring(i,i+2);
                        }
                        quantity = readString.substring(i,i+1);
                    }
                }
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }

        return toReturn;

    }
}
