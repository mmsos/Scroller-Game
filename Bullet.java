import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Bullet implements KeyListener, ActionListener{
    public int x;
    public int y;
    Timer timer;
    Image image;
    ImageIcon imgIcon;
    Rectangle proj;
    boolean moving;

    public Bullet(){
        this.moving=false;

        imgIcon = new ImageIcon("image/shot.png");

        image=imgIcon.getImage();
        timer = new Timer(1,this);
        timer.start();
    }
    
    /*
    public String getMoving(){
        if(moving==true)
        {
            return "true";
        }
        return "false";
    }
    */

    public void paint(Graphics g){
        draw(g);
    }

    public void draw(Graphics g){

        if(moving==true){
            g.drawImage(image, this.x+1,y,null);
            proj=new Rectangle(x,y,30,30);
        }
        else{
            y=870;
            x=ScollerPanel.newX;
            g.drawImage(image, this.x+1,y,null);
            proj=new Rectangle(x,y,30,30);            
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(moving==false){
                this.x-=1;
            }
        }
        
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(moving==false){
                this.x+=3;
            }
        }
        
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            moving = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (moving==true){
            y=y-5;
        }
        
        if(y<=-0){ 
            moving = false;
        }
    }

}
