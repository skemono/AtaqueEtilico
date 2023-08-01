import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Write a description of class hidravida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class hidravida extends Actor
{
    int goalX = 0;
    int goalY = 0;
    int speed = 30;
    
    int pastX = 0;
    int pastY = 0;
    
    int orgX;
    int orgY;
    
    int[] negOrPos = {-1,1};
    
    int desTime;
    
    public void act()
    {
        // Add your action code here
        if (goalX != 0 && goalY != 0)
        {
            if (getX() != pastX || getY() != pastY)
            {
                float distanceX = Math.abs(goalX-getX())/speed;
                float distanceY = Math.abs(goalY-getY())/speed;
                pastX = getX();
                pastY = getY();
                if (goalX < getX()) setLocation(getX()-(int) distanceX, getY());
                if (goalX > getX()) setLocation(getX()+(int) distanceX, getY());
                if (goalY < getY()) setLocation(getX(), getY() -(int) distanceY);
                if (goalY > getY()) setLocation(getX(), getY() +(int) distanceY);
                
                turn(15);
            }
        } else{
            Random numerito = new Random();
            goalX = Greenfoot.getRandomNumber(((world)getWorld()).getWidth()) + 1;
            goalY = Greenfoot.getRandomNumber(((world)getWorld()).getHeight()-100) + 100;
            
            
            if ((Math.abs(goalX - orgX)) <= 100) goalX = (goalX + (100 + Greenfoot.getRandomNumber(100) * negOrPos[numerito.nextInt(negOrPos.length)]));
            if ((Math.abs(goalY - orgY)) <= 100) goalY = goalY + 200 + Greenfoot.getRandomNumber(100);
        }
        desTime++;
        if (desTime >= 440){((world)getWorld()).removeHidra(this); desTime = 0;}
    }
    
    public void setOrigin(int x, int y, Actor target){
        orgX = x;
        orgY = y;
        
        int rndOffset = ((Greenfoot.getRandomNumber(10))/5) + 1;
        goalX = x + ((target.getX() - x) * rndOffset);
        goalY = y + ((target.getY() - y) * rndOffset);
        
    }
}
