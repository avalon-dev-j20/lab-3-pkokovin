/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.j20.labs;

import javax.swing.JFrame;
import ru.avalon.java.j20.labs.frames.ColorSelectionSlider;
import ru.avalon.java.j20.labs.frames.SimpleCalculator;


/**
 *
 * @author pashak
 */
public class Application {
    public static void main(String[] args) {
//        JFrame frame = new SimpleCalculator();
        JFrame frame = new ColorSelectionSlider();
        frame.setVisible(true);
    }
    
}
