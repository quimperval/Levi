package com.perval.levi.sections;

import junit.framework.TestCase;

public class PortalTest extends TestCase {

    private int slope = 1;
    private double h1_r = 2;
    private double h1_l= 2;

    private double h2_r = 3;
    private double h2_l = 3;
    private double base = 5;
    private double radius = 2.5;

    private double n_top= 0.025;
    private double n1_r = 0.013;
    private double n1_l = 0.013;
    private double n2_r = 0.013;
    private double n2_l = 0.013;
    private double nfondo = 0.013;

    private void populateVariables(Portal mPortal){
        mPortal.setBottom(base);
        mPortal.setRadio(radius);
        mPortal.setnfondo(nfondo);
        mPortal.setntop(n_top);
        mPortal.seth1der(h1_r);
        mPortal.seth1izq(h1_l);

        mPortal.seth2der(h2_r);
        mPortal.seth2izq(h2_l);

        mPortal.setn1der(n1_r);
        mPortal.setn2der(n2_r);

        mPortal.setn1izq(n1_l);
        mPortal.setn2izq(n2_l);

        mPortal.setslope(1);
        mPortal.setHrect();
        mPortal.setHT(mPortal.getHrect()+mPortal.getBottom()*0.5);
    }

    /*
    These tests are for using the method to find the hydraulic variables associated to a pre defined flow.
     */
    public void testPortal5000lps(){
        double gasto = 5000;
        Portal portal = new Portal();
        portal.setBottom(base);
        portal.setRadio(radius);
        portal.setnfondo(nfondo);
        portal.setntop(n_top);
        portal.seth1der(h1_r);
        portal.seth1izq(h1_l);

        portal.seth2der(h2_r);
        portal.seth2izq(h2_l);

        portal.setn1der(n1_r);
        portal.setn2der(n2_r);

        portal.setn1izq(n1_l);
        portal.setn2izq(n2_l);

        portal.setslope(1);
        portal.setGastoAsLPS(gasto);
        portal.setHrect();
        portal.setHT(portal.getHrect()+portal.getBottom()*0.5);
        portal.calcFromQLimitSearch(gasto/1000);
        assertEquals( gasto,portal.getGasto()*1000, 1);
        assertEquals(3.214,portal.getArea(),  0.002);
        assertEquals( 6.29,portal.getPm(), 0.01);
        assertEquals( 0.511,portal.getRh(), 0.001);
        assertEquals( 1.556,portal.getVel(), 0.001);
        assertTrue(portal.isSuccess());

    }

    public void testPortal10000lps(){
        double gasto = 10000;
        Portal portal = new Portal();
        portal.setBottom(base);
        portal.setRadio(radius);
        portal.setnfondo(nfondo);
        portal.setntop(n_top);
        portal.seth1der(h1_r);
        portal.seth1izq(h1_l);

        portal.seth2der(h2_r);
        portal.seth2izq(h2_l);

        portal.setn1der(n1_r);
        portal.setn2der(n2_r);

        portal.setn1izq(n1_l);
        portal.setn2izq(n2_l);

        portal.setslope(1);
        portal.setGastoAsLPS(gasto);
        portal.setHrect();
        portal.setHT(portal.getHrect()+portal.getBottom()*0.5);
        portal.calcFromQLimitSearch(gasto/1000);
        assertEquals( gasto,portal.getGasto()*1000, 1);
        assertEquals(5.098,portal.getArea(),  0.002);
        assertEquals( 7.04,portal.getPm(), 0.01);
        assertEquals( 0.724,portal.getRh(), 0.001);
        assertEquals( 1.962,portal.getVel(), 0.001);
        assertTrue(portal.isSuccess());

    }


    public void testPortal20000lps(){
        double gasto = 20000;
        Portal portal = new Portal();
        portal.setBottom(base);
        portal.setRadio(radius);
        portal.setnfondo(nfondo);
        portal.setntop(n_top);
        portal.seth1der(h1_r);
        portal.seth1izq(h1_l);

        portal.seth2der(h2_r);
        portal.seth2izq(h2_l);

        portal.setn1der(n1_r);
        portal.setn2der(n2_r);

        portal.setn1izq(n1_l);
        portal.setn2izq(n2_l);

        portal.setslope(1);
        portal.setGastoAsLPS(gasto);
        portal.setHrect();
        portal.setHT(portal.getHrect()+portal.getBottom()*0.5);
        portal.calcFromQLimitSearch(gasto/1000);
        assertEquals( gasto,portal.getGasto()*1000, 1);
        assertEquals(8.254,portal.getArea(),  0.002);
        assertEquals( 8.30,portal.getPm(), 0.01);
        assertEquals( 0.994,portal.getRh(), 0.001);
        assertEquals( 2.423,portal.getVel(), 0.001);
        assertTrue(portal.isSuccess());

    }


    public void testPortal30000lps(){
        double gasto = 30000;
        Portal portal = new Portal();
        portal.setBottom(base);
        portal.setRadio(radius);
        portal.setnfondo(nfondo);
        portal.setntop(n_top);
        portal.seth1der(h1_r);
        portal.seth1izq(h1_l);

        portal.seth2der(h2_r);
        portal.seth2izq(h2_l);

        portal.setn1der(n1_r);
        portal.setn2der(n2_r);

        portal.setn1izq(n1_l);
        portal.setn2izq(n2_l);

        portal.setslope(1);
        portal.setGastoAsLPS(gasto);
        portal.setHrect();
        portal.setHT(portal.getHrect()+portal.getBottom()*0.5);
        portal.calcFromQLimitSearch(gasto/1000);
        assertEquals( gasto,portal.getGasto()*1000, 1);
        assertEquals(11.078,portal.getArea(),  0.002);
        assertEquals( 9.43,portal.getPm(), 0.01);
        assertEquals( 1.175,portal.getRh(), 0.001);
        assertEquals( 2.708,portal.getVel(), 0.001);
        assertTrue(portal.isSuccess());

    }
    public void testPortal40000lps(){
        double gasto = 40000;
        Portal portal = new Portal();
        portal.setBottom(base);
        portal.setRadio(radius);
        portal.setnfondo(nfondo);
        portal.setntop(n_top);
        portal.seth1der(h1_r);
        portal.seth1izq(h1_l);

        portal.seth2der(h2_r);
        portal.seth2izq(h2_l);

        portal.setn1der(n1_r);
        portal.setn2der(n2_r);

        portal.setn1izq(n1_l);
        portal.setn2izq(n2_l);

        portal.setslope(1);
        portal.setGastoAsLPS(gasto);
        portal.setHrect();
        portal.setHT(portal.getHrect()+portal.getBottom()*0.5);
        portal.calcFromQLimitSearch(gasto/1000);
        assertEquals( gasto,portal.getGasto()*1000, 1);
        assertEquals(13.741,portal.getArea(),  0.002);
        assertEquals( 10.50,portal.getPm(), 0.01);
        assertEquals( 1.309,portal.getRh(), 0.001);
        assertEquals( 2.911,portal.getVel(), 0.001);
        assertTrue(portal.isSuccess());

    }
    public void testPortal60000lps(){
        double gasto = 60000;
        Portal portal = new Portal();
        portal.setBottom(base);
        portal.setRadio(radius);
        portal.setnfondo(nfondo);
        portal.setntop(n_top);
        portal.seth1der(h1_r);
        portal.seth1izq(h1_l);

        portal.seth2der(h2_r);
        portal.seth2izq(h2_l);

        portal.setn1der(n1_r);
        portal.setn2der(n2_r);

        portal.setn1izq(n1_l);
        portal.setn2izq(n2_l);

        portal.setslope(1);
        portal.setGastoAsLPS(gasto);
        portal.setHrect();
        portal.setHT(portal.getHrect()+portal.getBottom()*0.5);
        portal.calcFromQLimitSearch(gasto/1000);
        assertEquals(portal.getGasto()*1000, gasto, 1);
        assertEquals(portal.getArea(), 18.808, 0.002);
        assertEquals(portal.getPm(), 12.52, 0.01);
        assertEquals(portal.getRh(), 1.502, 0.001);
        assertEquals(portal.getVel(), 3.19, 0.001);
        assertTrue(portal.isSuccess());

    }

    public void testPortal80000lps(){
        double gasto = 80000;
        Portal portal = new Portal();
        portal.setBottom(base);
        portal.setRadio(radius);
        portal.setnfondo(nfondo);
        portal.setntop(n_top);
        portal.seth1der(h1_r);
        portal.seth1izq(h1_l);

        portal.seth2der(h2_r);
        portal.seth2izq(h2_l);

        portal.setn1der(n1_r);
        portal.setn2der(n2_r);

        portal.setn1izq(n1_l);
        portal.setn2izq(n2_l);

        portal.setslope(1);
        portal.setGastoAsLPS(gasto);
        portal.setHrect();
        portal.setHT(portal.getHrect()+portal.getBottom()*0.5);
        portal.calcFromQLimitSearch(gasto/1000);
        assertEquals( gasto,portal.getGasto()*1000, 1);
        assertEquals(23.684,portal.getArea(),  0.002);
        assertEquals( 14.47,portal.getPm(), 0.01);
        assertEquals( 1.636,portal.getRh(), 0.001);
        assertEquals( 3.378,portal.getVel(), 0.001);
        assertTrue(portal.isSuccess());

    }

    public void testPortal85000lps(){
        double gasto = 85000;
        Portal portal = new Portal();
        portal.setBottom(base);
        portal.setRadio(radius);
        portal.setnfondo(nfondo);
        portal.setntop(n_top);
        portal.seth1der(h1_r);
        portal.seth1izq(h1_l);

        portal.seth2der(h2_r);
        portal.seth2izq(h2_l);

        portal.setn1der(n1_r);
        portal.setn2der(n2_r);

        portal.setn1izq(n1_l);
        portal.setn2izq(n2_l);

        portal.setslope(1);
        portal.setGastoAsLPS(gasto);
        portal.setHrect();
        portal.setHT(portal.getHrect()+portal.getBottom()*0.5);
        portal.calcFromQLimitSearch(gasto/1000);
        assertEquals( gasto,portal.getGasto()*1000, 1);
        assertEquals(24.884,portal.getArea(),  0.002);
        assertEquals( 14.95,portal.getPm(), 0.01);
        assertEquals( 1.664,portal.getRh(), 0.001);
        assertEquals( 3.416,portal.getVel(), 0.001);
        assertTrue(portal.isSuccess());

    }

    public void testPortal95000lps(){
        double gasto = 95000;
        Portal portal = new Portal();
        portal.setBottom(base);
        portal.setRadio(radius);
        portal.setnfondo(nfondo);
        portal.setntop(n_top);
        portal.seth1der(h1_r);
        portal.seth1izq(h1_l);

        portal.seth2der(h2_r);
        portal.seth2izq(h2_l);

        portal.setn1der(n1_r);
        portal.setn2der(n2_r);

        portal.setn1izq(n1_l);
        portal.setn2izq(n2_l);

        portal.setslope(1);
        portal.setGastoAsLPS(gasto);
        portal.setHrect();
        portal.setHT(portal.getHrect()+portal.getBottom()*0.5);
        portal.calcFromQLimitSearch(gasto/1000);
        assertEquals( gasto,portal.getGasto()*1000, 1);
        assertEquals(29.895,portal.getArea(),  0.002);
        assertEquals( 17.07,portal.getPm(), 0.01);
        assertEquals( 1.751,portal.getRh(), 0.001);
        assertEquals( 3.178,portal.getVel(), 0.001);
        assertTrue(portal.isSuccess());

    }

        /*
    These tests are for using the method to find the hydraulic variables associated to a pre defined velocity
     */


    public void testPortal_0_511ms(){
        double velocidad = 0.511;
        double gastoEsperado = 255.273;
        Portal portal = new Portal();
        portal.setBottom(base);
        portal.setRadio(radius);
        portal.setnfondo(nfondo);
        portal.setntop(n_top);
        portal.seth1der(h1_r);
        portal.seth1izq(h1_l);

        portal.seth2der(h2_r);
        portal.seth2izq(h2_l);

        portal.setn1der(n1_r);
        portal.setn2der(n2_r);

        portal.setn1izq(n1_l);
        portal.setn2izq(n2_l);

        portal.setslope(1);
        portal.setvel(velocidad);
        portal.setHrect();
        portal.setHT(portal.getHrect()+portal.getBottom()*0.5);
        portal.calcfromV(velocidad);
        assertEquals( gastoEsperado,portal.getGasto()*1000, 1);
        assertEquals(0.500,portal.getArea(),  0.002);
        assertEquals( 5.20,portal.getPm(), 0.01);
        assertEquals( 0.096,portal.getRh(), 0.001);
        assertEquals( velocidad,portal.getVel(), 0.001);
        assertTrue(portal.isSuccess());

    }

    public void testPortal_1_357ms(){
        double velocidad = 1.357;
        double gastoEsperado = 3392.521;
        Portal portal = new Portal();
        populateVariables(portal);
        portal.setvel(velocidad);
        portal.calcfromV(velocidad);
        assertEquals( gastoEsperado,portal.getGasto()*1000, 2);
        assertEquals(2.500,portal.getArea(),  0.002);
        assertEquals( 6.00,portal.getPm(), 0.01);
        assertEquals( 0.417,portal.getRh(), 0.001);
        assertEquals( velocidad,portal.getVel(), 0.001);
        assertTrue(portal.isSuccess());

    }

    public void testPortal_1_847ms(){
        double velocidad = 1.847;
        double gastoEsperado = 8302.41;
        Portal portal = new Portal();
        populateVariables(portal);
        portal.setvel(velocidad);
        portal.calcfromV(velocidad);
        assertEquals( gastoEsperado,portal.getGasto()*1000, 2);
        assertEquals(4.496,portal.getArea(),  0.02);
        assertEquals( 6.80,portal.getPm(), 0.01);
        assertEquals( 0.662,portal.getRh(), 0.01);
        assertEquals( velocidad,portal.getVel(), 0.01);
        assertTrue(portal.isSuccess());

    }

    public void testPortal_2_192ms(){
        double velocidad = 2.192;
        double gastoEsperado = 14258;
        Portal portal = new Portal();
        populateVariables(portal);
        portal.setvel(velocidad);
        portal.calcfromV(velocidad);
        assertEquals( gastoEsperado,portal.getGasto()*1000, 2);
        assertEquals(6.50,portal.getArea(),  0.02);
        assertEquals( 7.60,portal.getPm(), 0.01);
        assertEquals( 0.855,portal.getRh(), 0.01);
        assertEquals( velocidad,portal.getVel(), 0.01);
        assertTrue(portal.isSuccess());

    }

    public void testPortal_2_452ms(){
        double velocidad = 2.452;
        double gastoEsperado = 20838.13;
        Portal portal = new Portal();
        populateVariables(portal);
        portal.setvel(velocidad);
        portal.calcfromV(velocidad);
        assertEquals( gastoEsperado,portal.getGasto()*1000, 2);
        assertEquals(8.50,portal.getArea(),  0.02);
        assertEquals( 8.40,portal.getPm(), 0.01);
        assertEquals( 1.012,portal.getRh(), 0.01);
        assertEquals( velocidad,portal.getVel(), 0.01);
        assertTrue(portal.isSuccess());

    }

    public void testPortal_2_701ms(){
        double velocidad = 2.701;
        double gastoEsperado = 29718.76;
        Portal portal = new Portal();
        populateVariables(portal);
        portal.setvel(velocidad);
        portal.calcfromV(velocidad);
        assertEquals( gastoEsperado,portal.getGasto()*1000, 1);
        assertEquals(11.00,portal.getArea(),  0.002);
        assertEquals( 9.400,portal.getPm(), 0.01);
        assertEquals( 1.170,portal.getRh(), 0.001);
        assertEquals( velocidad,portal.getVel(), 0.001);
        assertTrue(portal.isSuccess());

    }

    public void testPortal_2_859ms(){
        double velocidad = 2.859;
        double gastoEsperado = 37137.76;
        Portal portal = new Portal();
        populateVariables(portal);
        portal.setvel(velocidad);
        portal.calcfromV(velocidad);
        assertEquals( gastoEsperado,portal.getGasto()*1000, 2);
        assertEquals(13.00,portal.getArea(),  0.02);
        assertEquals( 10.20,portal.getPm(), 0.01);
        assertEquals( 1.275,portal.getRh(), 0.01);
        assertEquals( velocidad,portal.getVel(), 0.01);
        assertTrue(portal.isSuccess());

    }

    public void testPortal_2_991ms(){
        double velocidad = 2.991;
        double gastoEsperado = 44838.79;
        Portal portal = new Portal();
        populateVariables(portal);
        portal.setvel(velocidad);
        portal.calcfromV(velocidad);
        assertEquals( gastoEsperado,portal.getGasto()*1000, 2);
        assertEquals(15.00,portal.getArea(),  0.02);
        assertEquals( 11.00,portal.getPm(), 0.01);
        assertEquals( 1.364,portal.getRh(), 0.01);
        assertEquals( velocidad,portal.getVel(), 0.01);
        assertTrue(portal.isSuccess());

    }

    public void testPortal_3_103ms(){
        double velocidad = 3.103;
        double gastoEsperado = 52724.60;
        Portal portal = new Portal();
        populateVariables(portal);
        portal.setvel(velocidad);
        portal.calcfromV(velocidad);
        assertEquals( gastoEsperado,portal.getGasto()*1000, 1);
        assertEquals(17.000,portal.getArea(),  0.02);
        assertEquals( 11.80,portal.getPm(), 0.01);
        assertEquals( 1.441,portal.getRh(), 0.01);
        assertEquals( velocidad,portal.getVel(), 0.01);
        assertTrue(portal.isSuccess());

    }

    public void testPortal_3_199ms(){
        double velocidad = 3.199;
        double gastoEsperado = 60757.18;
        Portal portal = new Portal();
        populateVariables(portal);
        portal.setvel(velocidad);
        portal.calcfromV(velocidad);
        assertEquals( gastoEsperado,portal.getGasto()*1000, 2);
        assertEquals(19.000,portal.getArea(),  0.02);
        assertEquals( 12.60,portal.getPm(), 0.01);
        assertEquals( 1.508,portal.getRh(), 0.01);
        assertEquals( velocidad,portal.getVel(), 0.01);
        assertTrue(portal.isSuccess());

    }

    public void testPortal_3_262ms(){
        double velocidad = 3.262;
        double gastoEsperado = 66810;
        Portal portal = new Portal();
        populateVariables(portal);
        portal.setvel(velocidad);
        portal.calcfromV(velocidad);
        assertEquals( gastoEsperado,portal.getGasto()*1000, 1);
        assertEquals(20.500,portal.getArea(),  0.02);
        assertEquals( 13.20,portal.getPm(), 0.01);
        assertEquals( 1.553,portal.getRh(), 0.01);
        assertEquals( velocidad,portal.getVel(), 0.01);
        assertTrue(portal.isSuccess());

    }

    public void testPortal_3_320ms(){
        double velocidad = 3.320;
        double gastoEsperado = 73122.199;
        Portal portal = new Portal();
        populateVariables(portal);
        portal.setvel(velocidad);
        portal.calcfromV(velocidad);
        assertEquals( gastoEsperado,portal.getGasto()*1000, 1);
        assertEquals(22.00,portal.getArea(),  0.025);
        assertEquals( 13.80,portal.getPm(), 0.01);
        assertEquals( 1.594,portal.getRh(), 0.001);
        assertEquals( velocidad,portal.getVel(), 0.001);
        assertTrue(portal.isSuccess());

    }

    public void testPortal_3_419ms(){
        double velocidad = 3.419;
        double gastoEsperado = 85384.15;
        Portal portal = new Portal();
        populateVariables(portal);
        portal.setvel(velocidad);
        portal.calcfromV(velocidad);
        assertEquals( gastoEsperado,portal.getGasto()*1000, 1);
        assertEquals(25.00,portal.getArea(),  0.03);
        assertEquals( 15.00,portal.getPm(), 0.01);
        assertEquals( 1.667,portal.getRh(), 0.01);
        assertEquals( velocidad,portal.getVel(), 0.01);
        assertTrue(portal.isSuccess());

    }

}