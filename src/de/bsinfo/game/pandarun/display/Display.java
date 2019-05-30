package de.bsinfo.game.pandarun.display;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    public Display (String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();

    }

    private void createDisplay(){

        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



        // For Images
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        // So the canvas always has the size that we give it
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);

        frame.add(canvas);
        // Will resize the canvas so we se it fully
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}