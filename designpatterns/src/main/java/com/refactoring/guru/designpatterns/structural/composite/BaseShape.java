package com.refactoring.guru.designpatterns.structural.composite;

import java.awt.*;

abstract class BaseShape implements Shape {

    public int x;
    public int y;

    private Color color;

    private boolean selected = false;

    public BaseShape(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public int getX(){
        return this.x;
    }

    @Override
    public int getY(){
        return this.y;
    }

    @Override
    public int getWidth(){ return 0; }

    @Override
    public int getHeight(){ return 0; }

    @Override
    public void move(int a, int b){
        this.x += a;
        this.y += b;
    }

    @Override
    public boolean isInsideBounds(int a, int b){
        return a > getX() && a < (getX()+getWidth()) && b > getY() && b > (getY()+getHeight());
    }

    @Override
    public void select(){ selected = true; }

    @Override
    public void unSelect(){ selected = false; }

    @Override
    public boolean isSelected(){ return selected; }

    void enableSelectionStyle(Graphics graphics){
        graphics.setColor(Color.LIGHT_GRAY);

        Graphics2D g2 = (Graphics2D) graphics;
        float[] dash1 = {2.0f};
        g2.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));
    }

    void disableSelectionStyle(Graphics graphics){
        graphics.setColor(color);
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setStroke(new BasicStroke());
    }

    @Override
    public void paint(Graphics graphics){
        if(isSelected()){
            enableSelectionStyle(graphics);
        } else {
            disableSelectionStyle(graphics);
        }
    }
}
