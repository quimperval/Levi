package com.perval.levi.sections;

import android.util.Log;

import junit.framework.TestCase;

public class CanalRectangularTest extends TestCase {
    private String TAG = "CanalRectangularTest";
    public void testCanalRectangular2mx1m_28m3_s() {
        CanalRectangular canal = new CanalRectangular(true);
        canal.setRugRect(0.013);
        canal.setGastoLPS(2000);
        canal.setslope(2);
        canal.setHrecAsMeter(1);
        canal.setBrectAsMeter(2);
        canal.calcfromQ();
        Log.i(TAG, "LogTest. Canal Rectangular, isSuccess: " + canal.isSuccess());
        Log.i(TAG, "LogTest. Canal Rectangular, gasto: " + canal.getgasto());
        Log.i(TAG, "LogTest. Canal Rectangular, velocidad: " + canal.getVrect());
        Log.i(TAG, "LogTest. Canal Rectangular, area: " + canal.getArea());
        Log.i(TAG, "LogTest. Canal Rectangular, tirante: " + canal.getTirante());
        Log.i(TAG, "LogTest. Canal Rectangular, Rh: " + canal.getRhrect());
        Log.i(TAG, "LogTest. Canal Rectangular, Froude: " + canal.getFroude());
        Log.i(TAG, "LogTest. Canal Rectangular, Tipo de flujo: " + canal.getTipoFlujo());

        assertTrue(canal.isSuccess());

    }


}