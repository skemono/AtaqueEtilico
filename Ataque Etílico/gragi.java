import lang.stride.*;
import java.util.*;
import greenfoot.*;



/**
 * 
 */
public class gragi extends Actor
{
    private boolean drinking = false;
    private int htime = 0;
    private int score = 0;

    /**
     * Act - do whatever the gragi wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        htime++;
        if (!drinking){
            if (Greenfoot.isKeyDown("d"))
            {
                setLocation(getX()+4, getY());
                turn(10);
            }else if (Greenfoot.isKeyDown("a"))
            {
                setLocation(getX()-4, getY());
                turn(-10);
            }else if (Greenfoot.isKeyDown("s"))
            {
                setLocation(getX(), getY()+4);
                turn(-10);
            }else if (Greenfoot.isKeyDown("w"))
            {
                setLocation(getX(), getY()-4);
                turn(10);
            }
        }
        if (htime == 150) {
            htime = 0;
            ((world)getWorld()).changeGragiHealth(this, true);
            Greenfoot.playSound("hurt.mp3");
        }
        
        Actor bkActor = checkKegColl();
        Actor hidraActor = checkHidraColl();
        if (bkActor != null){
            ((world)getWorld()).removeObject(bkActor);
            ((world)getWorld()).changeGragiHealth(this, false);
            score++;
            ((world)getWorld()).changeScore(score);
            Greenfoot.playSound("GragasConsume.mp3");

            // PLAY DRINK ANIMATION AND BURP SOUND
            
            
        }
        
        if (hidraActor != null){
            ((world)getWorld()).removeObject(hidraActor);
            ((world)getWorld()).changeGragiHealth(this, true);
            Greenfoot.playSound("hurt.mp3");
            
        }
    }
    
    private Actor checkKegColl(){
        Actor kegTouched = getOneIntersectingObject(beerKeg.class);
        return kegTouched;        
    }
    
    private Actor checkHidraColl(){
        Actor hidraTouched = getOneIntersectingObject(hidravida.class);
        return hidraTouched;
    }
}
