/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.j20.labs.frames;
import ru.avalon.java.ui.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author pashak
 */
public class ColorSelectionSlider extends AbstractFrame{
    private JLabel labelR = new JLabel("Red"); // создаем надписи к слайдерам
    private JLabel labelG = new JLabel("Green");
    private JLabel labelB = new JLabel("Blue");
    private JSlider sliderR = new JSlider(0, 255, 125); // создаем слайдеры
    private JSlider sliderG = new JSlider(0, 255, 125);
    private JSlider sliderB = new JSlider(0, 255, 125);
    private JPanel colorPanel = new JPanel(); // создаем панель, отображающую цвет
    private JPanel controlsPanel = new JPanel(); // создаем панель, на которую положим слайдеры
    private Clipboard clipboard = Toolkit  // инструмент для работы с клипбордом
            .getDefaultToolkit()
            .getSystemClipboard();
    
  
    @Override
    protected void onCreate() {
        setTitle("Color Picker");  // устанавливаем название окна
        setSize(600, 300); // устанавливаем начальный размер окна
        setLayout(new GridLayout(1, 2)); // назначаем компоновщик, который разделит область на холст и элементы управления
        
        add(createColorPanel()); // добавляем холст
        add(createSlidersPanel()); // добавляем слайдеры
        
        sliderR.addChangeListener(this::onSliderChange); // устанавливаем обработчики на изменение слайдера 
        sliderG.addChangeListener(this::onSliderChange); //
        sliderB.addChangeListener(this::onSliderChange); //
        
        updateColor(); // метод меняющий состояния при изменении положений слайдеров 
    }
    
    // создаем холст
    private JPanel createColorPanel() {
        colorPanel.setLayout(new BorderLayout());
        Color color = new Color(sliderR.getX(), sliderG.getX(), sliderB.getX()); // берет начальный цвет из изначального положения слайдеров
        colorPanel.setBackground(color); // устанавливает цвет
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10); // почему-то не влияет на границы...
        colorPanel.setBorder(border);
        colorPanel.setToolTipText("#" + Integer.toHexString(color.getRGB()).substring(2).toUpperCase()); // устанавливаем всплывающую подсказку по начальному цвету   
        return colorPanel;
    }
    
    private void updateColor()  { // метод изменяющий переменные цвета холста и значения всплывающей подсказки в зависимости от положений слайдеров
        int R = sliderR.getValue();
        int G = sliderG.getValue();
        int B = sliderB.getValue();
        Color color = new Color(R, G, B);
        colorPanel.setBackground(color);
        String hexColor = "#" + Integer.toHexString(color.getRGB()).substring(2).toUpperCase();
        colorPanel.setToolTipText(hexColor);        
        if (!isBlank(hexColor)) copyToClipboard(hexColor);
    }
    
    
    private void onSliderChange(ChangeEvent e) { // метод запускающий обновления значений при наступлении событий
        updateColor();
    }
    
    private JPanel createSlidersPanel() { // создаем панель со слайдерами
        controlsPanel.setLayout(new GridLayout(3, 1));
        Border border = BorderFactory.createEmptyBorder(25, 25, 25, 25);
        JPanel slidersPanelR = new JPanel();
        slidersPanelR.setLayout(new BorderLayout());
        slidersPanelR.setBorder(border);
        sliderR.setPaintTicks(true);    // показывает шкалу на слайдере
        sliderR.setMajorTickSpacing(20); // устанавливает значение между указателями шкалы на слайдере (не нашел параметра, чтобы можно было указать только первую и последнюю цифры на шкале)
        slidersPanelR.add(labelR, BorderLayout.LINE_START);
        slidersPanelR.add(sliderR);
        controlsPanel.add(slidersPanelR);
        JPanel slidersPanelG = new JPanel();
        slidersPanelG.setLayout(new BorderLayout());
        slidersPanelG.setBorder(border);
        sliderG.setPaintTicks(true);
        sliderG.setMajorTickSpacing(20);
        slidersPanelG.add(labelG, BorderLayout.LINE_START);
        slidersPanelG.add(sliderG);
        controlsPanel.add(slidersPanelG);
        JPanel slidersPanelB = new JPanel();
        slidersPanelB.setLayout(new BorderLayout());
        slidersPanelB.setBorder(border);
        sliderB.setPaintTicks(true);
        sliderB.setMajorTickSpacing(20);
        slidersPanelB.add(labelB, BorderLayout.LINE_START);
        slidersPanelB.add(sliderB);
        controlsPanel.add(slidersPanelB);
        return controlsPanel;
    }
    
    private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, selection);
    }
    
    private boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }
  
           
}
