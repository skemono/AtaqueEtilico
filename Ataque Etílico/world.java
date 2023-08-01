import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class world extends World
{
    private GreenfootSound backgroundMusic = new GreenfootSound("music.mp3");
    private Actor gragiActor;
    /**
     * Constructor for objects of class world.
     */
    

    private int gragiHp = 6;
    public world()
    {
        super(1104, 621, 1);
        backgroundMusic.playLoop();
        prepare();
        showText("Score ", 80, 70);
    }

    public void spawnObject(int x, int y, String what)
    {
        if (what == "keg"){
            beerKeg newKeg = new beerKeg();
            newKeg.setOrigin(x,y);
            addObject(newKeg,x,y);
        } else if (what == "hidravida"){
            hidravida newVida = new hidravida();
            newVida.setOrigin(x,y, gragiActor);
            addObject(newVida,x,y);
        }

    }
    

    public void changeGragiHealth(Actor gragi, boolean damage){
        if (damage && gragiHp > 0){
            gragiHp--;
        }else if (!damage && gragiHp < 6) {
            gragiHp++;
        }
        if (gragiHp == 0){
            backgroundMusic.stop();
            Greenfoot.playSound("GragasDeath.mp3");
            overScreen w = new overScreen();
            Greenfoot.setWorld(w);
        }
        healthBar barraVida = getObjects(healthBar.class).get(0);
        barraVida.changeHealth(gragiHp);

    }
    
    public void changeScore(int score){
        showText("Score " + score, 80, 70);
    }
    
    public void removeHidra(Actor hidra){
        removeObject(hidra);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        healthBar healthBar = new healthBar();
        addObject(healthBar,82,36);
        goblinTender goblinTender = new goblinTender();
        addObject(goblinTender,564,65);
        table table = new table();
        addObject(table,568,159);
        gragi gragi = new gragi();
        addObject(gragi,653,387);
        gragi.setLocation(607,424);
        gragi.setLocation(587,423);
        
        gragiActor = gragi;
    }
}
