import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class goblinTender extends Actor
{
    private int atime = 0;
    private String action = "idle";
    
    private String currentThrowFrame0 = "throw0.png";
    private String currentThrowFrame1 = "throw1.png";
    private int rnd;

    /**
     * Act - do whatever the goblinTender wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    // Reference to the world
    public void act()
    {   
        
        atime=atime+1;
        if (action == "idle")
        {
            if (atime==39) atime = 0;
            if (atime==4) setImage("idle0.png");
            if (atime==8) setImage("idle1.png");
            if (atime==12) setImage("idle2.png");
            if (atime==16) setImage("idle3.png");
            if (atime==22) setImage("idle4.png");
            if (atime==28) setImage("idle5.png");
            if (atime==34) setImage("idle6.png");
            if (atime==38)
            {
                setImage("idle7.png");
                
                rnd = Greenfoot.getRandomNumber(2);
                
                if (rnd == 1){
                    action = "throw";
                }
                
            }
            
        } else if (action == "throw")
        {
            if (atime==39) atime = 0;
            if (atime == 0){
                rnd = Greenfoot.getRandomNumber(2);
                if (rnd <1){
                    currentThrowFrame0 = "throw0.png";
                    currentThrowFrame1 = "throw1.png";
                } else{
                    currentThrowFrame0 = "throw0vida.png";
                    currentThrowFrame1 = "throw1vida.png";
                }
            }
            if (atime==4) setImage(currentThrowFrame0);
            if (atime==8) setImage(currentThrowFrame1);
            if (atime==12) 
            {
                setImage("throw2.png");                
                if (rnd <1){
                    ((world)getWorld()).spawnObject(getX(), getY() - 5, "keg");
                } else{
                    ((world)getWorld()).spawnObject(getX(), getY() - 5,  "hidravida");
                }
            }
            if (atime==16) setImage("throw3.png");
            if (atime==22) setImage("throw4.png");
            if (atime==28) setImage("throw5.png");
            if (atime==34) setImage("throw6.png");
            if (atime==38) {
                setImage("throw7.png");
                atime = 0;
                action = "idle";
            }
        }
        
    }
}
