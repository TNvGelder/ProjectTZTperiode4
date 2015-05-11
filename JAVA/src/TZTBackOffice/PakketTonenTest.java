/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TZTBackOffice;

import javax.swing.JFrame;

/**
 *
 * @author Jasper
 */
public class PakketTonenTest {

    public static void main(String[] args) {
        PakketTonen s1 = new PakketTonen();
        PakketTonenScreen screen = new PakketTonenScreen(s1);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
