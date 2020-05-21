package com.perval.levi;

public class PPR {

    private String listaClase[][] = {
            {"16","16"}
           };


    //Case 0
    private String Clase16[][]  = {
            {"20","20","2.80","14.40",""},
            {"25","25","3.50","18.00",""},
            {"32","32","4.40","23.20",""},
            {"40","40","5.50","29.00",""},
            {"50","50","6.90","36.20",""},
            {"63","63","8.60","45.80",""},
            {"75","75","10.30","54.40",""},
            {"90","90","12.30","65.40",""},
            {"110","110","15.10","79.80",""}


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
                ret = Clase16;
                break;


        }

        return ret;
    }
}
