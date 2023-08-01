import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class titleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class titleScreen extends World
{
    private GreenfootSound backgroundMusic = new GreenfootSound("darius.mp3");

    /**
     * Constructor for objects of class titleScreen.
     * 
     */
    public titleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1104, 621, 1);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        btonJugar btonJugar = new btonJugar();
        addObject(btonJugar,572,380);
        btonJugar.setLocation(571,368);
        backgroundMusic.playLoop();
    }
    
    public void start(){
        backgroundMusic.stop();
        world w = new world();
        Greenfoot.setWorld(w);
    }
}
