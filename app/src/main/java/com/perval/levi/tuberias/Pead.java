package com.perval.levi.tuberias;

public class Pead {

    private double resistencia;
    private String tipo;


    private String listaRD[][] = {
            {"7","23"},
            {"7.3","22"},
            {"9","17"},
            {"11","14"},
            {"13.5","11"},
            {"15.5","10"},
            {"17","9"},
            {"21","7"},
            {"26","6"},
            {"32.5","4"},
            {"41","3"}
    };


    // col 0 = DN
    //col 1 = Dext
    //col 2 = e
    //col 3 = Dint
    //col 4 peso por metro


    //case 1
    private String RD73[][] = {
            {"1/2","21.3","2.4","16.5","0.14"},
            {"3/4","26.7","3","20.7","0.22"},
            {"1","33.4","3.7","26","0.34"},
            {"1 1/4","42.2","4.7","32.8","0.55"},
            {"1 1/2","48.3","5.4","37.5","0.73"},
            {"2","60.3","6.7","46.9","1.13"},
            {"2 1/2","73","8.1","56.8","1.65"},
            {"3","88.9","9.9","69.1","2.45"},
            {"4","114.3","12.7","88.9","4.04"},
            {"6","168.3","18.7","130.9","8.77"},
            {"8","219.1","24.3","170.5","14.83"},
            {"10","273.1","30.3","212.5","23.05"},
            {"12","323.8","36","251.8","32.47"},
            {"14","355.6","39.5","276.6","39.13"},
            {"16","406.4","45.2","316","51.16"},
            {"18","457.2","50.8","355.6","64.7"},
            {"20","508","56.4","395.2","79.82"}
    };
    //case 2
    private String RD9[][]={
            {"1/2","21.3","2.4","16.5","0.14"},
            {"3/4","26.7","3","20.7","0.22"},
            {"1","33.4","3.7","26","0.34"},
            {"1 1/4","42.2","4.7","32.8","0.55"},
            {"1 1/2","48.3","5.4","37.5","0.73"},
            {"2","60.3","6.7","46.9","1.13"},
            {"2 1/2","73","8.1","56.8","1.65"},
            {"3","88.9","9.9","69.1","2.45"},
            {"4","114.3","12.7","88.9","4.04"},
            {"6","168.3","18.7","130.9","8.77"},
            {"8","219.1","24.3","170.5","14.83"},
            {"10","273.1","30.3","212.5","23.05"},
            {"12","323.8","36","251.8","32.47"},
            {"14","355.6","39.5","276.6","39.13"},
            {"16","406.4","45.2","316","51.16"},
            {"18","457.2","50.8","355.6","64.7"},
            {"20","508","56.4","395.2","79.82"}


    };
    //case 3
    private String RD11[][] = {
            {"1/2","21.3","1.9","17.5","0.12"},
            {"3/4","26.7","2.4","21.9","0.18"},
            {"1","33.4","3.1","27.2","0.29"},
            {"1 1/4","42.2","3.8","34.6","0.46"},
            {"1 1/2","48.3","4.4","39.5","0.61"},
            {"2","60.3","5.5","49.3","0.94"},
            {"2 1/2","73","6.6","59.8","1.37"},
            {"3","88.9","8.1","72.7","2.05"},
            {"4","114.3","10.4","93.5","3.39"},
            {"6","168.3","15.3","137.7","7.34"},
            {"8","219.1","19.9","179.3","12.42"},
            {"10","273.1","24.8","223.5","19.3"},
            {"12","323.8","29.4","265","27.12"},
            {"14","355.6","32.3","291","27.12"},
            {"16","406.4","37","332.4","27.12"},
            {"18","457.2","41.6","374","27.12"},
            {"20","508","46.2","415.6","27.12"},
            {"22","558.8","50.8","457.2","27.12"},
            {"24","609.6","55.4","498.8","27.12"},
            {"30","762","69.3","623.4","150.43"},
            {"36","914.4","83.1","748.2","216.48"}
    };
    //case 4
    private String RD135[][] = {
            {"1/2","21.3","1.6","18.1","0.1"},
            {"3/4","26.7","2","22.7","0.15"},
            {"1","33.4","2.5","28.4","0.24"},
            {"1 1/4","42.2","3.1","36","0.38"},
            {"1 1/2","48.3","3.6","41.1","0.5"},
            {"2","60.3","4.5","51.3","0.79"},
            {"2 1/2","73","5.4","62.2","1.14"},
            {"3","88.9","6.6","75.7","1.7"},
            {"4","114.3","8.5","97.3","2.82"},
            {"6","168.3","12.5","143.3","6.1"},
            {"8","219.1","16.2","186.7","10.3"},
            {"10","273.1","20.2","232.7","16.01"},
            {"12","323.8","24","275.8","22.55"},
            {"14","355.6","26.3","303","27.14"},
            {"16","406.4","30.1","346.2","35.49"},
            {"18","457.2","33.9","389.4","44.97"},
            {"20","508","37.6","432.8","55.43"},
            {"22","558.8","41.4","476","67.13"},
            {"24","609.6","45.2","519.2","79.94"},
            {"26","660.4","48.9","562.6","93.71"},
            {"28","711.2","52.7","605.8","108.75"},
            {"30","762","56.4","649.2","124.71"},
            {"32","812.8","60.2","692.4","141.98"},
            {"34","863.6","64","735.6","160.37"},
            {"36","914.4","67.7","779","179.63"},
            {"40","1016","75.3","865.4","221.98"},
            {"42","1066.8","79","908.8","244.55"},
            {"48","1219.2","90.3","1038.6","319.45"},

    };

    //case 5
    private String RD155[][] = {
            {"1 1/4","42.2","2.7","36.8","0.33"},
            {"1 1/2","48.3","3.1","42.1","0.44"},
            {"2","60.3","3.9","52.5","0.69"},
            {"2 1/2","73","4.7","63.6","1.01"},
            {"3","88.9","5.7","77.5","1.49"},
            {"4","114.3","7.4","99.5","2.48"},
            {"6","168.3","10.8","146.7","5.33"},
            {"8","219.1","14.1","190.9","9.06"},
            {"10","273.1","17.6","237.9","14.09"},
            {"12","323.8","20.9","282","19.84"},
            {"14","355.6","22.9","309.8","23.88"},
            {"16","406.4","26.2","354","31.22"},
            {"18","457.2","29.5","398.2","39.54"},
            {"20","508","32.8","442.4","48.84"},
            {"22","558.8","36","486.8","58.98"},
            {"24","609.6","39.3","531","70.24"},
            {"26","660.4","42.6","575.2","82.47"},
            {"28","711.2","45.9","619.4","95.7"},
            {"30","762","49.1","663.8","109.69"},
            {"32","812.8","52.5","707.8","125.09"},
            {"34","863.6","55.7","752.2","141.02"},
            {"36","914.4","59","796.4","158.16"},
            {"40","1016","65.5","885","195.1"},
            {"42","1066.8","68.8","929.2","215.17"},
            {"48","1219.2","78.7","1061.8","281.28"}

    };
    //case 6
    private String RD17[][] = {
            {"1 1/4","42.2","2.5","37.2","0.31"},
            {"1 1/2","48.3","2.8","42.7","0.4"},
            {"2","60.3","3.6","53.1","0.64"},
            {"2 1/2","73","4.3","64.4","0.93"},
            {"3","88.9","5.2","78.5","1.36"},
            {"4","114.3","6.7","100.9","2.26"},
            {"6","168.3","9.9","148.5","4.91"},
            {"8","219.1","12.9","193.3","8.34"},
            {"10","273.1","16.1","240.9","12.97"},
            {"12","323.8","19.1","285.6","18.24"},
            {"14","355.6","20.9","313.8","21.92"},
            {"16","406.4","23.9","358.6","28.65"},
            {"18","457.2","26.9","403.4","36.27"},
            {"20","508","29.9","448.2","44.8"},
            {"22","558.8","32.9","493","54.22"},
            {"24","609.6","35.9","537.8","64.54"},
            {"26","660.4","38.8","582.8","75.58"},
            {"28","711.2","41.8","627.6","87.69"},
            {"30","762","44.8","672.4","100.69"},
            {"32","812.8","47.1","718.6","113.02"},
            {"34","863.6","50.8","762","129.39"},
            {"36","914.4","53.8","806.8","145.09"},
            {"40","1016","59.8","896.4","179.19"},
            {"42","1066.8","62.8","941.2","197.59"},
            {"48","1219.2","71.7","1075.8","257.83"}
    };
    //case 7
    private String RD21[][] = {
            {"2","60.3","2.9","54.5","0.52"},
            {"2 1/2","73","3.5","66","0.76"},
            {"3","88.9","4.2","80.5","1.11"},
            {"4","114.3","5.4","103.5","1.84"},
            {"6","168.3","8","152.3","4.02"},
            {"8","219.1","10.4","198.3","6.8"},
            {"10","273.1","13","247.1","10.6"},
            {"12","323.8","15.4","293","14.88"},
            {"14","355.6","16.9","321.8","17.94"},
            {"16","406.4","19.4","367.6","23.53"},
            {"18","457.2","21.8","413.6","29.74"},
            {"20","508","24.2","459.6","36.69"},
            {"22","558.8","26.6","505.6","44.36"},
            {"24","609.6","29","551.6","52.76"},
            {"26","660.4","31.4","597.6","61.89"},
            {"28","711.2","33.9","643.4","71.95"},
            {"30","762","36.3","689.4","82.55"},
            {"32","812.8","38.7","735.4","93.88"},
            {"34","863.6","41.1","781.4","105.94"},
            {"36","914.4","43.5","827.4","118.72"},
            {"40","1016","48.4","919.2","146.76"},
            {"42","1066.8","50.8","965.2","161.74"},
            {"48","1219.2","58.1","1103","211.4"}

    };
    //case 8
    private String RD26[][] = {
            {"2 1/2","73","2.8","67.4","0.62"},
            {"3","88.9","3.4","82.1","0.91"},
            {"4","114.3","4.4","105.5","1.52"},
            {"6","168.3","6.5","155.3","3.3"},
            {"8","219.1","8.4","202.3","5.55"},
            {"10","273.1","10.5","252.1","8.64"},
            {"12","323.8","12.5","298.8","12.19"},
            {"14","355.6","13.7","328.2","14.68"},
            {"16","406.4","15.6","375.2","19.1"},
            {"18","457.2","17.6","422","24.25"},
            {"20","508","19.5","469","29.85"},
            {"22","558.8","21.5","515.8","36.2"},
            {"24","609.6","23.4","562.8","42.99"},
            {"26","660.4","25.4","609.6","50.54"},
            {"28","711.2","27.4","656.4","58.71"},
            {"30","762","29.3","703.4","67.28"},
            {"32","812.8","31.3","750.2","76.65"},
            {"34","863.6","33.2","797.2","86.4"},
            {"36","914.4","35.2","844","96.98"},
            {"40","1016","39.1","937.8","119.7"},
            {"42","1066.8","41","984.8","131.8"},
            {"48","1219.2","46.9","1125.4","172.3"}
    };
    //case 9
    private String RD325[][] = {
            {"3","88.9","2.7","83.5","0.73"},
            {"4","114.3","3.5","107.3","1.22"},
            {"6","168.3","5.2","157.9","2.66"},
            {"8","219.1","6.7","205.7","4.46"},
            {"10","273.1","8.4","256.3","6.97"},
            {"12","323.8","10","303.8","9.83"},
            {"14","355.6","10.9","333.8","11.77"},
            {"16","406.4","12.5","381.4","15.43"},
            {"18","457.2","14.1","429","19.58"},
            {"20","508","15.6","476.8","24.07"},
            {"22","558.8","17.2","524.4","29.19"},
            {"24","609.6","18.7","572.2","34.63"},
            {"26","660.4","20.3","619.8","40.72"},
            {"28","711.2","21.9","667.4","47.31"},
            {"30","762","23.4","715.2","54.16"},
            {"32","812.8","25","762.8","61.72"},
            {"34","863.6","26.6","810.4","69.77"},
            {"36","914.4","28.1","858.2","78.05"},
            {"40","1016","31.3","953.4","96.59"},
            {"42","1066.8","32.8","1001.2","106.28"},
            {"48","1219.2","37.5","1144.2","138.87"}
            };
    //case 10
    private String RD41[][] = {
            {"4","114.3","2.8","108.7","0.98"},
            {"6","168.3","4.1","160.1","2.11"},
            {"8","219.1","5.3","208.5","3.55"},
            {"10","273.1","6.7","259.7","5.59"},
            {"12","323.8","7.9","308","7.82"},
            {"14","355.6","8.7","338.2","9.46"},
            {"16","406.4","9.9","386.6","12.3"},
            {"18","457.2","11.2","434.8","15.65"},
            {"20","508","12.4","483.2","19.26"},
            {"22","558.8","13.6","531.6","23.24"},
            {"24","609.6","14.9","579.8","27.77"},
            {"26","660.4","16.1","628.2","32.51"},
            {"28","711.2","17.3","676.6","37.62"},
            {"30","762","18.6","724.8","43.33"},
            {"32","812.8","19.8","773.2","49.2"},
            {"34","863.6","21.1","821.4","55.71"},
            {"36","914.4","22.3","869.8","62.34"},
            {"40","1016","24.8","966.4","77.03"},
            {"42","1066.8","26","1014.8","84.8"},
            {"48","1219.2","29.7","1159.8","110.71"}
    };


    //case 0
    private String RD7[][] = {
            {"1/2","21.3","3","15.3","0.17"},
            {"3/4","26.7","3.8","19.1","0.27"},
            {"1","33.4","4.8","23.8","0.43"},
            {"1 1/4","42.2","6","30.2","0.68"},
            {"1 1/2","48.3","6.9","34.5","0.9"},
            {"2","60.3","8.6","43.1","1.39"},
            {"2 1/2","73","10.4","52.2","2.04"},
            {"3","88.9","12.7","63.5","3.03"},
            {"4","114.3","16.3","81.7","5.01"},
            {"6","168.3","24","120.3","10.85"},
            {"8","219.1","31.3","156.5","18.42"},
            {"10","273.1","39","195.1","28.61"},
            {"12","323.8","46.3","231.2","40.26"},
            {"14","355.6","50.8","254","48.52"},
            {"16","406.4","58.1","290.2","63.42"},
            {"18","457.2","65.3","326.6","80.2"},
            {"20","508","72.6","362.8","99.06"},
            {"22","558.8","79.8","399.2","119.78"},
            {"24","609.6","87.1","435.4","142.62"}

    };

    public void Pead(){

    }

    public String[][] getList(){
        return listaRD;
    }

    public String[][] getpipes(int RD){
        String ret[][] = {
                {"0","0"}
        };
        switch (RD){

            case 0:
                ret = RD7;
                break;
            case 1:
                ret = RD73;
                break;
            case 2:
                ret = RD9;
                break;
            case 3:
                ret = RD11;
                break;
            case 4:
                ret = RD135;
                break;
            case 5:
                ret = RD155;
                break;
            case 6:
                ret = RD17;
                break;
            case 7:
                ret = RD21;
                break;
            case 8:
                ret = RD26;
                break;
            case 9:
                ret = RD325;
                break;
            case 10:
                ret = RD41;

        }

        return ret;
    }

}
