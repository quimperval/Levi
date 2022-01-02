package com.perval.levi.tuberias;

public class PVCIngles {
    private String listaClase[][] = {
            {"13.5","22.1"},
            {"21","14"},
            {"26","11.2"},
            {"41","6.9"}
    };

    // col 0 = DN
    //col 1 = Dext
    //col 2 = e
    //col 3 = Dint
    //col 4 peso por metro


    //Case 0
    private String Clase135[][]  = {
            {"1/2","21.3","1.6","18",""},

    };

    //Case 1
    private String Clase21[][]  = {
            {"1/4","26.7","1.5","23.4",""},
            {"1","33.4","1.6","30",""},


    };

    //Case 2
    private String Clase26[][]  = {
            {"1 1/4","42.2","1.6","38.7",""},
            {"1 1/2","48.3","1.9","44.3",""},
            {"2","60.3","2.3","55.4",""},
            {"2 1/2","73.0","2.8","67.1",""},
            {"3","88.9","3.4","81.6",""},
            {"4","114.3","4.4","105.0",""},
            {"6","168.3","6.5","154.5",""}
    };

    //Case 3
    private String Clase41[][]  = {
            {"2","60.3","1.5","57.3",""},
            {"2 1/2","73.0","1.8","69.4",""},
            {"3","88.9","2.2","84.6",""},
            {"4","114.3","2.8","108.7",""}
    };




    public String[][] getList(){
        return listaClase;
    }

    public String[][] getpipes(int RD){
        String ret[][] = {
                {"0","0"}
        };
        switch (RD){

            case 0:
                ret = Clase135;
                break;
            case 1:
                ret = Clase21;
                break;
            case 2:
                ret = Clase26;
                break;
            case 3:
                ret = Clase41;

        }

        return ret;
    }


}
