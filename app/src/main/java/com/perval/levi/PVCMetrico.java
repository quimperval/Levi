package com.perval.levi;

public class PVCMetrico {
    private String listaClase[][] = {
            {"3.5","23"},
            {"5","22"},
            {"7","17"},
            {"10","14"},
    };

    // col 0 = DN
    //col 1 = Dext
    //col 2 = e
    //col 3 = Dint
    //col 4 peso por metro


    //Case 0
    private String Clase35[][]  = {
            {"6","160","2.0","156.0",""},
            {"8","200","2.5","195.0",""},
            {"10","250","3.1","243.8",""}
    };

    //Case 1
    private String Clase5[][] = {
            {"6","160","2.8","154.4",""},
            {"8","200","3.5","193.0",""},
            {"10","250","6.1","241.2",""},
            {"12","315","7.7","303.8",""},
            {"14","355","8.7","342.6",""},
            {"16","400","9.8","386",""},
            {"18","450","11.0","434",""},
    };

    //Case 2
    private String Clase7[][] = {
            {"6","160","3.9","152.2",""},
            {"8","200","4.9","190.2",""},
            {"10","250","6.1","237.8",""},
            {"12","315","7.7","299.6",""},
            {"14","355","8.7","337.6",""},
            {"16","400","9.8","380.4",""},
            {"18","450","11.0","428.0",""}
    };

    //Case 3
    private String Clase10[][] = {
            {"6","160","5.5","149",""},
            {"8","200","6.9","186.2",""},
            {"10","250","8.6","232.2",""},
            {"12","315","10.9","293.2",""},
            {"14","355","12.2","330.6",""},
            {"16","400","13.8","372.4",""},
            {"18","450","15.5","419",""}
    };


    public void Pead(){

    }

    public String[][] getList(){
        return listaClase;
    }

    public String[][] getpipes(int RD){
        String ret[][] = {
                {"0","0"}
        };
        switch (RD){

            case 0:
                ret = Clase35;
                break;
            case 1:
                ret = Clase5;
                break;
            case 2:
                ret = Clase7;
                break;
            case 3:
                ret = Clase10;

        }

        return ret;
    }


}
