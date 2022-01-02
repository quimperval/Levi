package com.perval.levi.tuberias;

import java.util.HashMap;

public class PipeProvider {

    private static HashMap<String, String[][]> listaTuberias = null;



    public static final String PVC_SANITARIO = "PVC Sanitario";

    public static final String CONCRETO_SIMPLE  = "Concreto Simple";

    public static final String CONCRETO_REFORZADO = "Concreto Reforzado";

    public static final String PAD_SANITARIO = "PEAD Sanitario";

    public static final String DURO_MAXX = "Duromaxx";

    public static final String ULTRA_FLO16 = "Ultraflo 16 Galv";

    public static final String ULTRA_FLO14 = "Ultraflo 14 Galv";

    public static final String ULTRA_FLO12 = "Ultraflo 12 Galv";


    public static final String ULTRA_FLO16_AL = "Ultraflo 16 Alum";

    public static final String ULTRA_FLO14_AL = "Ultraflo 14 Alum";

    public static final String ULTRA_FLO12_AL = "Ultraflo 12 Alum";
    public static final String ULTRA_FLO10_AL = "Ultraflo 10 Alum";


    //Columna 0 Diámetro nominal
    //Columna 1 Diámetro exterior
    //Columna 2 Espesor
    //Columna 3 Diámetro interior.
    private static String PVCSanitario[][] = {
            {"1 1/2","40.3","1.8","36.7"},
            {"2","50.3","1.8","46.7"},
            {"3","75.3","1.8","71.7"},
            {"4","110.4","2.3","105.8"},
            {"5","160.5","3.3","153.9"},
            {"8","200.6","4","192.6"}
    };



    //Columna 0 Diámetro nominal
    //Columna 1 Diámetro exterior
    //Columna 2 Espesor
    //Columna 3 Diámetro interior.
    //Columna 4 Peso por metro
    private static String ConcretoSimple[][] = {
            {"6","198","24","150","38"},
            {"8","256","28","200","54"},
            {"10","316","33","250","85"},
            {"12","386","43","300","119"},
            {"15","486","53","380","388"},
            {"18","564","57","450","480"},
            {"24","762","76","610","817"}
    };

    //Columna 0 Diámetro nominal
    //Columna 1 Diámetro exterior
    //Columna 2 Espesor
    //Columna 3 Diámetro interior.
    //Columna 4 Peso por metro
    private static String ConcretoReforzado[][] = {
            {"12","386","43","300","119"},
            {"15","486","53","380","388"},
            {"18","564","57","450","480"},
            {"24","762","76","610","817"},
            {"30","938","89","760","1200"},
            {"36","1112","101","910","1683"},
            {"42","1298","114","1070","2237"},
            {"48","1474","127","1220","2400"},
            {"60","1824","152","1520","4636"},
            {"72","2186","178","1830","6215"},
            {"84","2550","210","2130","8640"},
            {"96","2900","230","2440","11060"}
    };
    //Columna 0 Diámetro nominal
    //Columna 1 Diámetro exterior
    //Columna 2 Espesor
    //Columna 3 Diámetro interior.
    //Columna 4 Peso por metro
    private static String PADSanitario[][] = {
            {"4","121","","100",""},
            {"6","176","","145",""},
            {"8","232","","195",""},
            {"10","288","","245",""},
            {"12","359","","294",""},
            {"15","448","","369",""},
            {"18","545","","450",""},
            {"24","716","","588",""},
            {"30","891","","751",""},
            {"36","1041","","902",""},
            {"42","1222","","1051",""},
            {"48","1380","","1185",""},
            {"60","1690","","1501",""}
    };

    //Columna 0  diámetro nominal - in
    //Columna 1 - Diámetro exterior mm
    //Columna 2 - espesor mm
    //Columna 3 - Diámetro interior mm
    //Columna 4 - peso kg/m
    //Duromax Tubo de polietileno reforzado de acero
    private static String DuroMaxx[][] = {
            {"30","785","","749","27.98"},
            {"36","942","","354","35.12"},
            {"42","1097","","413","40.18"},
            {"48","1257","","472","45.84"},
            {"54","1410","","532","53.72"},
            {"60","1600","","591","63.84"},
            {"66","1722","","650","84.68"},
            {"72","1872","","709","97.63"},
            {"84","2182","","827","113.55"},
            {"96","2484","","945","129.47"},
            {"108","2827","","1080","138.37"},
            {"120","3096","","1181","162.22"}
    };

    //Columna 0  diámetro nominal - in
    //Columna 1 - Diámetro exterior mm
    //Columna 2 - espesor mm
    //Columna 3 - Diámetro interior mm
    //Columna 4 - peso kg/m
    //Ultraflo acero aluminizado tipo 2 y acero galvanizado
    //Calibre 16 (1.625 mm)
    private static String Ultraflo16[][] = {
            {"18","","22.34","450",""},
            {"21","","26.81","540",""},
            {"24","","29.78","610",""},
            {"30","","37.22","760",""},
            {"36","","44.67","910",""},
            {"42","","52.12","1070",""},
            {"48","","59.56","1200",""},
            {"54","","67.00","1370",""},
            {"60","","74.45","1520",""}
    };

    private static String Ultraflo14[][]={
            {"36","","55.09","910",""},
            {"42","","64.03","1070",""},
            {"48","","72.96","1200",""},
            {"54","","81.89","1370",""},
            {"60","","90.83","1520",""},
            {"66","","99.76","1680",""},
            {"72","","108.7","1830",""},
            {"78","","119.12","1980",""}

    };

    private static String Ultraflo12[][]={
            {"42","","87.85","1070",""},
            {"48","","99.76","1200",""},
            {"54","","111.67","1370",""},
            {"60","","123.59","1520",""},
            {"66","","139.99","1680",""},
            {"72","","148.9","1830",""},
            {"78","","160.81","1980",""},
            {"84","","172.72","2130",""},
            {"90","","186.13","2290",""},
            {"96","","194.08","2440",""},
            {"102","","208.46","2600",""}
    };

    private static String Ultraflo16_alum[][] = {
            {"18","","22.34","450",""},
            {"21","","26.81","540",""},
            {"24","","29.78","610",""},
            {"30","","37.22","760",""},
            {"36","","44.67","910",""},
            {"42","","52.12","1070",""}
    };

    private static String Ultraflo14_alum[][]={
            {"24","","29.78","610",""},
            {"36","","55.09","910",""},
            {"42","","64.03","1070",""},
            {"48","","72.96","1200",""},
            {"54","","81.89","1370",""}

    };

    private static String Ultraflo12_alum[][]={
            {"30","","37.22","760",""},
            {"36","","44.67","910",""},
            {"42","","87.85","1070",""},
            {"48","","99.76","1200",""},
            {"54","","111.67","1370",""},
            {"60","","123.59","1520",""},
            {"66","","139.99","1680",""},
            {"72","","148.9","1830",""}
    };


    private static String Ultraflo10_alum[][]={
            {"36","","44.67","910",""},
            {"42","","87.85","1070",""},
            {"48","","99.76","1200",""},
            {"54","","111.67","1370",""},
            {"60","","123.59","1520",""},
            {"66","","139.99","1680",""},
            {"72","","148.9","1830",""},
            {"78","","160.81","1980",""},
            {"84","","172.72","2130",""},
    };

    public PipeProvider(){
        PopulateListaDeTuberias();
    }

    private static void PopulateListaDeTuberias(){

        if(listaTuberias==null){
            listaTuberias = new HashMap<String, String[][]>();

            if(listaTuberias.get(PVC_SANITARIO)==null){
                listaTuberias.put(PVC_SANITARIO, PVCSanitario);
            }

            if(listaTuberias.get(CONCRETO_SIMPLE)==null){
                listaTuberias.put(CONCRETO_SIMPLE,ConcretoSimple);
            }

            if(listaTuberias.get(CONCRETO_REFORZADO)==null){
                listaTuberias.put(CONCRETO_REFORZADO,ConcretoReforzado);
            }

            if(listaTuberias.get(PAD_SANITARIO)==null){
                listaTuberias.put(PAD_SANITARIO,PADSanitario);
            }

            if(listaTuberias.get(DURO_MAXX)==null){
                listaTuberias.put(DURO_MAXX,DuroMaxx);
            }

            if(listaTuberias.get(ULTRA_FLO12)==null){
                listaTuberias.put(ULTRA_FLO12,Ultraflo12);
            }

            if(listaTuberias.get(ULTRA_FLO14)==null){
                listaTuberias.put(ULTRA_FLO14,Ultraflo14);
            }

            if(listaTuberias.get(ULTRA_FLO16)==null){
                listaTuberias.put(ULTRA_FLO16, Ultraflo16);
            }


            if(listaTuberias.get(ULTRA_FLO10_AL)==null){
                listaTuberias.put(ULTRA_FLO10_AL,Ultraflo10_alum);
            }

            if(listaTuberias.get(ULTRA_FLO12_AL)==null){
                listaTuberias.put(ULTRA_FLO12_AL,Ultraflo12_alum);
            }

            if(listaTuberias.get(ULTRA_FLO14_AL)==null){
                listaTuberias.put(ULTRA_FLO14_AL,Ultraflo14_alum);
            }

            if(listaTuberias.get(ULTRA_FLO16_AL)==null){
                listaTuberias.put(ULTRA_FLO16_AL, Ultraflo16_alum);
            }
        }
    }

    public String[][] getPipeList(String pipename){
        return listaTuberias.get(pipename);
    }


}
