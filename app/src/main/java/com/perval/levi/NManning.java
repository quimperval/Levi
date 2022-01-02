package com.perval.levi;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.util.Arrays;

public class NManning {

    private Resources resources;

    private String[][] listado;

    public NManning(){

    };

    public NManning(Resources resources){
        this.resources = resources;
    }

    public String getvalue(int row, int col){
        return listado[row][col];
    }

    public String[][] getListado(){
        //Log.i("nManning", "method: getListado");
        String[] startArray;
        startArray = resources.getStringArray(R.array.manning_values);
        //Log.i("nManning", Arrays.toString(startArray));
        listado = new String[startArray.length][5];

        //Log.i("nManning", "Array length: " + startArray.length);

        for(int i=0; i<startArray.length;i++){
            //Log.i("nManning", "counter: " + i);
            listado[i] = startArray[i].split("\\|");

            for(int j=0; j<listado[i].length; j++){
                listado[i][j] = listado[i][j].replace("_", "");
            }

            //Log.i("nManning", Arrays.toString(listado[i]));

        }

        return listado;

    }

}
