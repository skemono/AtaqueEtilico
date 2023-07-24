import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class world extends World
{

    /**
     * Constructor for objects of class world.
     */
    
    private int gragiHp = 6;
    public world()
    {
        super(1104, 621, 1);
    }
    
    public void spawnObject(int x, int y, String what)
    {
        if (what == "keg"){
            beerKeg newKeg = new beerKeg();
            newKeg.setOrigin(x,y);
            addObject(newKeg,x,y);
        } else if (what == "hidravida"){
            hidravida newVida = new hidravida();
            newVida.setOrigin(x,y);
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
            removeObject(gragi);
        }
        healthBar barraVida = getObjects(healthBar.class).get(0);
        barraVida.changeHealth(gragiHp);
        
    }
    
}
