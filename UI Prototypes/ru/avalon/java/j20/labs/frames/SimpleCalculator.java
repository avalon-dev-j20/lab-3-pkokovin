/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.j20.labs.frames;
import ru.avalon.java.ui.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author pashak
 */
public class SimpleCalculator extends AbstractFrame{
    private JLabel textField = new JLabel("0", JLabel.RIGHT);
    private JButton button0 = new JButton("0");
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");
    private JButton button9 = new JButton("9");
    private JButton buttonCE = new JButton("CE");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonEnd = new JButton("=");
    private JButton buttonDot = new JButton(".");
    private JButton buttonDivide = new JButton("/");
    private JButton buttonMultiple = new JButton("*");
    private JPanel resultPanel = new JPanel();
    private JPanel endPanel = new JPanel();
    

    @Override
    protected void onCreate() {
        setTitle("Simple Calculator");
        setLayout(new BorderLayout());
        Dimension maxSize = new Dimension(400, 600);
        Dimension minSize = new Dimension(300, 400);
        Dimension prefSize = new Dimension(350, 550);
        setPreferredSize(prefSize);
        setMaximumSize(maxSize);
        setMinimumSize(minSize); // почему-то не работает
        addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent e){
                if (e.getNewState() == MAXIMIZED_BOTH) {
                    setExtendedState(NORMAL);
                }
            }

        });
        add(createResultPanel(), BorderLayout.PAGE_START);
        add(createButtonPanel(), BorderLayout.CENTER);
        add(createEndButtonPanel(), BorderLayout.PAGE_END);                
    }
    
    private JPanel createResultPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(textField, BorderLayout.LINE_END);
        Border border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        panel.setBorder(border);
        return panel;
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonPlus);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonMinus);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonMultiple);
        panel.add(buttonCE);
        panel.add(button0);
        panel.add(buttonDot);
        panel.add(buttonDivide);
        Border border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        panel.setBorder(border);
        return panel;
    }
    
    private JPanel createEndButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(buttonEnd, BorderLayout.CENTER);
        Border border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        panel.setBorder(border);
        return panel;
    }
    
}
