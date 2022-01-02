package com.perval.levi.tuberias;

import android.util.Log;

import junit.framework.TestCase;

public class TuberiaSanitariaTest extends TestCase {

    public void testPEAD1500mm_250_lps() {
        String TAG = "testPEAD1500mm_250_lps";
        TuberiaSanitaria tuberia = new TuberiaSanitaria(true);
        tuberia.setDiametro(1.501);
        tuberia.setRugosidad(0.009);
        tuberia.setGastoLPS(250);
        tuberia.setSlope(1);
        tuberia.CalcfromQ();
        //Checking data of qmax
        double deltaAreamax =0.001;
        double deltaPmmax =0.001;
        double deltaRhmax =0.001;
        double deltaVmax =0.001;
        double deltaQmax =0.001;
        Log.i(TAG , "LogTest, GastoMax: " + tuberia.getQMAX_gastoX());
        Log.i(TAG , "LogTest, AreaMax: " + tuberia.getQMAX_CrossAreaX());
        Log.i(TAG , "LogTest, VelocidadMax: " + tuberia.getQMAX_velocityX());
        Log.i(TAG , "LogTest, RhMax: " + tuberia.getQMAX_vRhX());
        Log.i(TAG , "LogTest, PmMax: " + tuberia.getQMAX_PmX());



        //The results
        Log.i(TAG , "LogTest, Gasto: " + tuberia.getGasto());
        Log.i(TAG , "LogTest, Rugosidad: " + tuberia.getRugosidad());
        Log.i(TAG , "LogTest, Slope: " + tuberia.getSlope());
        Log.i(TAG , "LogTest, Area: " + tuberia.getArea());
        Log.i(TAG , "LogTest, Velocidad: " + tuberia.getVelocity());
        Log.i(TAG , "LogTest, Tirante: " + tuberia.getTirante());
        boolean success = tuberia.isSuccess();
        assertTrue(success);
        assertEquals(tuberia.getTirante(), 0.2823, 0.0002);
    }
}