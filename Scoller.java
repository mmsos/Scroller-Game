
import javax.swing.*;

public class Scoller extends JFrame{
    ScollerPanel scrollp;
    public int xWidth=1000;
    public int yHeight=1000;
    public Scoller(){
        setSize(xWidth,yHeight);
        scrollp = new ScollerPanel();
        add(scrollp);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Scoller();
    }
    
    public int getxSize(){ //bro what even is the "cannot be referenced from a static method error
        return xWidth;
    }
    
    public int getySize(){
        return yHeight;
    }
}