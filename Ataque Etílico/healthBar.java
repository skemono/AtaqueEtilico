import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class healthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class healthBar extends Actor
{
    /**
     * Act - do whatever the healthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void changeHealth(int health){
        System.out.println(health);
        switch(health){
            case 6:
                setImage("sprite6.png");
                break;
            case 5:
                setImage("sprite5.png");
                break;
            case 4:
                setImage("sprite4.png");
                break;
            case 3:
                setImage("sprite3.png");
                break;
            case 2:
                setImage("sprite2.png");
                break;
            case 1:
                setImage("sprite1.png");
                break;
        }
    }
}
