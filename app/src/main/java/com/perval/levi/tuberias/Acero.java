package com.perval.levi.tuberias;

public class Acero {

    private String listaClase[][] = {
            {"5","22.1"},
            {"5S","22.1"},
            {"10","14"},
            {"10S","14"},
            {"20","11.2"},
            {"30","6.9"},
            {"40","11.2"},
            {"60","11.2"},
            {"80","11.2"},
            {"120","11.2"},
            {"140","11.2"},
            {"160","11.2"},
            {"XS","11.2"},
            {"XXS","11.2"},
            {"N/A","000"}
    };

    //Case 0
    private String Clase5[][]  = {
            {"1/8","10.3","0.89","8.52","0.21"},
            {"1/4","13.7","1.24","11.22","0.38"},
            {"3/8 ","17.1","1.24","14.62","0.49"},
            {"1/2","21.3","1.65","18","0.8"},
            {"3/4","26.7","1.65","23.4","1.02"},
            {"1","33.4","1.65","30.1","1.29"},
            {"1 1/4","42.2","1.65","38.9","1.29"},
            {"1 1/2","48.3","1.65","45","1.9"},
            {"2","60.3","1.65","57","2.39"},
            {"2 1/2","73","2.11","68.78","3.69"},
            {"3","88.9","2.11","84.68","4.51"},
            {"3 1/2","101.6","2.11","97.38","5.17"},
            {"4","114.3","2.11","110.08","5.83"},
            {"5","141.3","2.77","135.76","9.46"},
            {"6","168.3","2.77","162.76","11.3"},
            {"8","219.1","2.77","213.56","14.77"},
            {"10","273.1","3.4","266.3","22.63"},
            {"12","323.9","4.19","315.52","33.04"}
    };

    private String Clase5S[][] = {
            {"1/22","21.3","1.65","18","0.8"},
            {"3/4","26.7","1.65","23.4","1.02"},
            {"1","33.4","1.65","30.1","1.29"},
            {"1 1/4","42.2","1.65","38.9","1.29"},
            {"1 1/2","48.3","1.65","45","1.9"},
            {"2","60.3","1.65","57","2.39"},
            {"2 1/2","73","2.11","68.78","3.69"},
            {"3","88.9","2.11","84.68","4.51"},
            {"3 1/2","101.6","2.11","97.38","5.17"},
            {"4","114.3","2.11","110.08","5.83"},
            {"5","141.3","2.77","135.76","9.46"},
            {"6","168.3","2.77","162.76","11.3"},
            {"8","219.1","2.77","213.56","14.77"},
            {"10","273.1","3.4","266.3","22.63"},
            {"12","323.9","3.96","315.98","31.26"},
            {"14","355.6","3.96","347.68","34.36"},
            {"16","406.4","4.19","398.02","41.57"},
            {"18","457.2","4.19","448.82","46.82"},
            {"20","508","4.78","498.44","59.26"},
            {"24","609.6","5.54","598.52","82.48"},
            {"30","762","6.35","749.3","118.33"}
    };

    private String Clase10[][] = {
            {"1 / 8","10.3","1.24","7.82","0.28"},
            {"1 / 4","13.7","1.65","10.4","0.49"},
            {"3/8 ","17.1","1.65","13.8","0.63"},
            {"1/2","21.3","2.11","17.08","1"},
            {"3/4","26.7","2.11","22.48","1.28"},
            {"1","33.4","2.77","27.86","2.09"},
            {"1 1/4","42.2","2.77","36.66","2.09"},
            {"1 1/2","48.3","2.77","42.76","3.11"},
            {"2","60.3","2.77","54.76","3.93"},
            {"2 1/2","73","3.5","66","5.26"},
            {"3","88.9","3.05","82.8","6.45"},
            {"3 1/2","101.6","3.05","95.5","7.41"},
            {"4","114.3","3.05","108.2","8.36"},
            {"5","141.3","3.4","134.5","11.57"},
            {"6","168.3","3.4","161.5","13.84"},
            {"8","219.1","3.76","211.58","19.96"},
            {"10","273.1","4.19","264.72","27.79"},
            {"12","323.9","4.57","314.76","36"},
            {"14","355.6","6.35","342.9","54.69"},
            {"16","406.4","6.35","393.7","62.64"},
            {"18","457.2","6.35","444.5","70.6"},
            {"20","508","6.35","495.3","78.55"},
            {"22","558.8","6.35","546.1","86.51"},
            {"24","609.6","6.35","596.9","94.46"},
            {"26","660.4","7.92","644.56","127.51"},
            {"28","711.2","7.92","695.36","137.44"},
            {"30","762","7.92","746.16","147.37"},
            {"32","812.8","7.92","796.96","157.29"},
            {"34","863.6","7.92","847.76","167.22"},
            {"36","914.4","7.92","898.56","177.15"}
    };

    private String Clase10S[][] = {
            {"1/2","21.3","2.11","17.08","1"},
            {"3/4","26.7","2.11","22.48","1.28"},
            {"1","33.4","2.77","27.86","2.09"},
            {"1 1/4","42.2","2.77","36.66","2.09"},
            {"1 1/2","48.3","2.77","42.76","3.11"},
            {"2","60.3","2.77","54.76","3.93"},
            {"2 1/2","73","3.5","66","5.26"},
            {"3","88.9","3.05","82.8","6.45"},
            {"3 1/2","101.6","3.05","95.5","7.41"},
            {"4","114.3","3.05","108.2","8.36"},
            {"5","141.3","3.4","134.5","11.57"},
            {"6","168.3","3.4","161.5","13.84"},
            {"8","219.1","3.76","211.58","19.96"},
            {"10","273.1","4.19","264.72","27.79"},
            {"12","323.9","4.57","314.76","36"},
            {"14","355.6","4.78","346.04","41.31"},
            {"16","406.4","4.78","396.84","47.29"},
            {"18","457.2","4.78","447.64","53.28"},
            {"20","508","5.56","496.88","68.92"},
            {"30","762","7.92","746.16","147.37"}
    };

    private String Clase20[][] = {
            {"8","219.1","6.35","206.4","33.31"},
            {"10","273.1","6.35","260.4","41.76"},
            {"14","355.6","7.92","339.76","67.94"},
            {"16","406.4","7.92","390.56","77.87"},
            {"18","457.2","7.92","441.36","87.8"},
            {"20","508","9.53","488.94","117.09"},
            {"22","558.8","9.53","539.74","129.02"},
            {"24","609.6","9.53","590.54","140.95"},
            {"26","660.4","12.7","635","202.85"},
            {"28","711.2","12.7","685.8","218.76"},
            {"30","762","12.7","736.6","234.67"},
            {"32","812.8","12.7","787.4","250.58"},
            {"34","863.6","12.7","838.2","266.49"}
    };

    private String Clase30[][] = {
            {"8","219.1","7.04","205.02","36.79"},
            {"10","273.1","7.8","257.5","51.01"},
            {"12","323.9","6.35","311.2","49.72"},
            {"12","323.9","8.38","307.14","65.21"},
            {"14","355.6","9.53","336.54","81.29"},
            {"16","406.4","9.53","387.34","93.22"},
            {"18","457.2","11.13","434.94","122.38"},
            {"20","508","12.7","482.6","155.12"},
            {"22","558.8","12.7","533.4","171.03"},
            {"24","609.6","14.27","581.06","209.56"},
            {"28","711.2","15.88","679.44","272.2"},
            {"30","762","15.88","730.24","292.09"},
            {"32","812.8","15.88","781.04","311.98"},
            {"34","863.6","15.88","831.84","331.87"},
            {"36","914.4","15.88","882.64","351.75"}
    };

    private String Clase40[][] = {
            {"1/8","10.3","1.73","6.84","0.36"},
            {"1/4","13.7","2.24","9.22","0.63"},
            {"3/8 ","17.1","2.31","12.48","0.85"},
            {"1/2","21.3","2.77","15.76","1.27"},
            {"3/4","26.7","2.87","20.96","1.68"},
            {"1","33.4","3.38","26.64","2.5"},
            {"1 1/4","42.2","3.56","35.08","3.39"},
            {"1 1/2","48.3","3.68","40.94","4.05"},
            {"2","60.3","3.91","52.48","5.44"},
            {"2 1/2","73","5.16","62.68","8.63"},
            {"3","88.9","5.49","77.92","11.29"},
            {"3 1/2","101.6","5.74","90.12","13.57"},
            {"4","114.3","6.02","102.26","16.07"},
            {"4.5","127","6.27","114.46","18.68"},
            {"5","141.3","6.55","128.2","21.78"},
            {"6","168.3","7.11","154.08","28.27"},
            {"8","219.1","8.18","202.74","42.54"},
            {"10","273.1","9.27","254.56","60.31"},
            {"12","323.9","10.31","303.28","79.73"},
            {"14","355.6","11.13","333.34","94.51"},
            {"16","406.4","12.7","381","123.3"},
            {"18","457.2","14.27","428.66","155.92"},
            {"20","508","15.09","477.82","183.39"},
            {"24","609.6","17.48","574.64","255.17"},
            {"32","812.8","17.48","777.84","342.74"},
            {"34","863.6","17.48","828.64","364.63"},
            {"36","914.4","19.05","876.3","420.61"}
    };


    private String Clase60[][] = {
            {"4","114.3","7.14","100.02","18.86"},
            {"8","219.1","10.31","198.48","53.09"},
            {"10","273.1","12.7","247.7","81.54"},
            {"12","323.9","14.27","295.36","108.98"},
            {"14","355.6","15.09","325.42","126.69"},
            {"16","406.4","16.66","373.08","160.14"},
            {"18","457.2","19.05","419.1","205.83"},
            {"20","508","20.62","466.76","247.88"},
            {"22","558.8","22.23","514.34","294.08"},
            {"24","609.6","24.61","560.38","355.06"}
    };

    private String Clase80[][] = {
            {"1 / 8","10.3","2.41","5.48","0.47"},
            {"1 / 4","13.7","3.02","7.66","0.8"},
            {"3 / 8 ","17.1","3.2","10.7","1.1"},
            {"1 / 2","21.3","3.73","13.84","1.62"},
            {"3 / 4","26.7","3.91","18.88","2.2"},
            {"1","33.4","4.55","24.3","3.24"},
            {"1.25","42.2","4.85","32.5","4.46"},
            {"1.5","48.3","5.08","38.14","5.41"},
            {"2","60.3","5.54","49.22","7.48"},
            {"2.5","73","7.01","58.98","11.41"},
            {"3","88.9","7.62","73.66","15.27"},
            {"3.5","101.6","8.08","85.44","18.63"},
            {"4","114.3","8.56","97.18","22.32"},
            {"4.5","127","9.02","108.96","26.23"},
            {"5","141.3","9.53","122.24","30.95"},
            {"6","168.3","10.97","146.36","42.56"},
            {"8","219.1","12.7","193.7","64.63"},
            {"10","273.1","15.09","242.92","95.98"},
            {"12","323.9","17.48","288.94","132.03"},
            {"14","355.6","19.05","317.5","158.1"},
            {"16","406.4","21.44","363.52","203.51"},
            {"18","457.2","23.83","409.54","254.62"},
            {"20","508","26.19","455.62","311.15"},
            {"22","558.8","28.58","501.64","373.63"},
            {"24","609.6","30.96","547.68","441.81"}
    };

    private String Clase100[][] = {
            {"8","219.1","15.09","188.92","75.9"},
            {"10","273.1","18.26","236.58","114.74"},
            {"12","323.9","21.44","281.02","159.87"},
            {"14","355.6","23.83","307.94","194.93"},
            {"16","406.4","26.19","354.02","245.53"},
            {"18","457.2","29.36","398.48","309.79"},
            {"20","508","32.54","442.92","381.5"},
            {"22","558.8","34.93","488.94","451.19"},
            {"24","609.6","38.89","531.82","547.29"}
    };

    private String Clase120[][] = {
            {"4","114.3","11.13","92.04","28.31"},
            {"5","141.3","12.7","115.9","40.28"},
            {"6","168.3","14.27","139.76","54.21"},
            {"8","219.1","18.26","182.58","90.44"},
            {"10","273.1","21.44","230.22","133.02"},
            {"12","323.9","25.4","273.1","186.94"},
            {"14","355.6","27.79","300.02","224.63"},
            {"16","406.4","30.96","344.48","286.66"},
            {"18","457.2","34.93","387.34","363.68"},
            {"20","508","38.1","431.8","441.49"},
            {"22","558.8","41.28","476.24","526.76"},
            {"24","609.6","46.02","517.56","639.64"}
    };

    private String Clase140[][] = {
            {"8","219.1","20.62","177.86","100.93"},
            {"10","273.1","25.4","222.3","155.12"},
            {"12","323.9","28.58","266.74","208.07"},
            {"14","355.6","31.75","292.1","253.56"},
            {"16","406.4","36.53","333.34","333.15"},
            {"18","457.2","39.67","377.86","408.5"},
            {"20","508","44.45","419.1","508.11"},
            {"22","558.8","47.63","463.54","600.34"},
            {"24","609.6","52.37","504.86","719.69"}
    };

    private String Clase160[][] = {
            {"1 / 2","21.3","4.78","11.74","1.95"},
            {"3 / 4","26.7","5.56","15.58","2.9"},
            {"1","33.4","6.35","20.7","4.24"},
            {"1.25","42.2","6.35","29.5","5.61"},
            {"1.5","48.3","7.14","34.02","7.24"},
            {"2","60.3","8.74","42.82","11.12"},
            {"2.5","73","9.53","53.94","14.92"},
            {"3","88.9","11.13","66.64","21.34"},
            {"4","114.3","13.49","87.32","33.53"},
            {"5","141.3","15.88","109.54","49.1"},
            {"6","168.3","18.26","131.78","67.56"},
            {"8","219.1","23.01","173.08","111.26"},
            {"10","273.1","28.58","215.94","172.27"},
            {"12","323.9","33.32","257.26","238.75"},
            {"14","355.6","35.71","284.18","281.71"},
            {"16","406.4","40.49","325.42","365.34"},
            {"18","457.2","45.24","366.72","459.57"},
            {"20","508","50.01","407.98","564.84"},
            {"22","558.8","53.98","450.84","671.93"},
            {"24","609.6","59.51","490.58","807.29"}
    };

    private String ClaseXS[][] = {
        {"1/8","10.3","2.41","5.48","0.47"},
        {"1/4","13.7","3.02","7.66","0.8"},
        {"3/8 ","17.1","3.2","10.7","1.1"},
        {"1/2","21.3","3.73","13.84","1.62"},
        {"3/4","26.7","3.91","18.88","2.2"},
        {"1","33.4","4.55","24.3","3.24"},
        {"1 1/4","42.2","4.85","32.5","4.46"},
        {"1 1/2","48.3","5.08","38.14","5.41"},
        {"2","60.3","5.54","49.22","7.48"},
        {"2 1/2","73","7.01","58.98","11.41"},
        {"3","88.9","7.62","73.66","15.27"},
        {"3 1/2","101.6","8.08","85.44","18.63"},
        {"4","114.3","8.56","97.18","22.32"},
        {"4 1/2","127","9.02","108.96","26.23"},
        {"5","141.3","9.53","122.24","30.95"},
        {"6","168.3","10.97","146.36","42.56"},
        {"7","193.7","12.7","168.3","56.68"},
        {"8","219.1","12.7","193.7","64.63"},
        {"9","244.5","12.7","219.1","72.59"},
        {"10","273.1","12.7","247.7","81.54"},
        {"11","298.5","12.7","273.1","89.49"},
        {"12","323.9","12.7","298.5","97.45"},
        {"14","355.6","12.7","330.2","107.39"},
        {"16","406.4","12.7","381","123.3"},
        {"18","457.2","12.7","431.8","139.21"},
        {"20","508","12.7","482.6","155.12"},
        {"22","558.8","12.7","533.4","171.03"},
        {"24","609.6","12.7","584.2","186.94"},
        {"26","660.4","12.7","635","202.85"},
        {"28","711.2","12.7","685.8","218.76"},
        {"30","762","12.7","736.6","234.67"},
        {"32","812.8","12.7","787.4","250.58"},
        {"34","863.6","12.7","838.2","266.49"},
        {"36","914.4","12.7","889","282.4"},
        {"42","1066.8","12.7","1041.4","330.13"},
        {"48","1219.2","12.7","1193.8","377.85"}
    };

    private String ClaseXXS[][] = {
            {"1 / 2","21.3","7.47","6.36","2.55"},
            {"3 / 4","26.7","7.82","11.06","3.64"},
            {"1","33.4","9.09","15.22","5.45"},
            {"1.25","42.2","9.7","22.8","7.77"},
            {"1.5","48.3","10.16","27.98","9.55"},
            {"2","60.3","11.07","38.16","13.45"},
            {"2.5","73","14.02","44.96","20.4"},
            {"3","88.9","15.24","58.42","27.68"},
            {"3.5","101.6","16.15","69.3","34.04"},
            {"4","114.3","17.12","80.06","41.03"},
            {"4.5","127","18.03","90.94","48.46"},
            {"5","141.3","19.05","103.2","57.43"},
            {"6","168.3","21.95","124.4","79.19"},
            {"7","193.7","22.23","149.24","93.97"},
            {"8","219.1","22.23","174.64","107.89"},
            {"10","273.1","25.4","222.3","155.12"},
            {"12","323.9","25.4","273.1","186.94"}
    };

    private String ClaseSTD[][] = {
            {"1/ 8","10.3","1.73","6.84","0.36"},
            {"1/ 4","13.7","2.24","9.22","0.63"},
            {"3/ 8 ","17.1","2.31","12.48","0.85"},
            {"1/ 2","21.3","2.77","15.76","1.27"},
            {"3/ 4","26.7","2.87","20.96","1.68"},
            {"1","33.4","3.38","26.64","2.5"},
            {"1 1/4","42.2","3.56","35.08","3.39"},
            {"1 1/2","48.3","3.68","40.94","4.05"},
            {"2","60.3","3.91","52.48","5.44"},
            {"2 1/2","73","5.16","62.68","8.63"},
            {"3","88.9","5.49","77.92","11.29"},
            {"3 1/2","101.6","5.74","90.12","13.57"},
            {"4","114.3","6.02","102.26","16.07"},
            {"4 1/2","127","6.27","114.46","18.68"},
            {"5","141.3","6.55","128.2","21.78"},
            {"6","168.3","7.11","154.08","28.27"},
            {"7","193.7","7.65","178.4","35.07"},
            {"8","219.1","8.18","202.74","42.54"},
            {"9","244.5","8.69","227.12","50.51"},
            {"10","273.1","9.27","254.56","60.31"},
            {"11","298.5","9.53","279.44","67.86"},
            {"12","323.9","9.53","304.84","73.83"},
            {"14","355.6","9.53","336.54","81.29"},
            {"16","406.4","9.53","387.34","93.22"},
            {"18","457.2","9.53","438.14","105.15"},
            {"20","508","9.53","488.94","117.09"},
            {"22","558.8","8.74","541.32","118.52"},
            {"24","609.6","9.53","590.54","140.95"},
            {"26","660.4","9.53","641.34","152.88"},
            {"28","711.2","9.53","692.14","164.81"},
            {"30","762","9.53","742.94","176.75"},
            {"32","812.8","9.53","793.74","188.68"},
            {"34","863.6","9.53","844.54","200.61"},
            {"36","914.4","9.53","895.34","212.54"},
            {"42","1066.8","9.53","1047.74","248.34"},
            {"48","1219.2","9.53","1200.14","284.14"}
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
                ret = Clase5;
                break;
            case 1:
                ret = Clase5S;
                break;
            case 2:
                ret = Clase10;
                break;
            case 3:
                ret = Clase10S;
                break;
            case 4:
                ret = Clase20;
                break;
            case 5:
                ret = Clase30;
                break;
            case 6:
                ret = Clase40;
                break;
            case 7:
                ret = Clase60;
                break;
            case 8:
                ret = Clase80;
                break;
            case 9:
                ret = Clase100;
                break;
            case 10:
                ret = Clase120;
                break;
            case 11:
                ret = Clase140;
                break;
            case 12:
                ret = Clase160;
                break;
            case 13:
                ret = ClaseXS;
                break;
            case 14:
                ret = ClaseXXS;
                break;
            case 15:
                ret = ClaseSTD;
                break;
        }

        return ret;
    }
}