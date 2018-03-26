import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ScollerPanel extends JPanel implements KeyListener, ActionListener{
    private int blockX;
    private int blockY = 200;
    private int x;
    private int wait;
    int newXValue = 0;
    public static int newX=56;
    boolean left;
    boolean right;
    Random rand = new Random();

    public Image block;
    public Image playerImg;
    public Image block2;
    public Image borderLine;
    public ImageIcon imgIcon; 
    public ImageIcon imgIcon2;
    public ImageIcon imgIcon3;
    public ImageIcon imgIcon4;
    public Bullet bullet;

    public Rectangle blockRect;
    public boolean hit;
    public Graphics g;
    public ScollerPanel(){
        blockX=0;
        left=false;
        right=true;
        x=56;
        wait=0;
        int newXValue = 0;
        hit=false;
        this.setSize(1000, 1000); //making this a set-able variable makes jank (in the other class)
        this.setVisible(true);
        this.setFocusable(true);

        imgIcon = new ImageIcon("image/block.png");
        imgIcon2 = new ImageIcon("image/player.png");
        imgIcon3 = new ImageIcon("image/block2.png");
        imgIcon4 = new ImageIcon("image/line.png");
        block = imgIcon.getImage();
        playerImg = imgIcon2.getImage();
        
        block2 = imgIcon3.getImage();
        borderLine = imgIcon4.getImage();

        bullet = new Bullet();
        addKeyListener(this);
        addKeyListener(bullet);
    }

    /*
    public int getxSize(){
    return Scoller.getxSize();
    }

    public int getySize(){
    return Scoller.getySize();
    }
     */

    public void paint(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(0, 0, /*getxSize()*/1000, /*getySize()*/1000);
        g.drawImage(borderLine, 200-29, 0,this);
        g.drawImage(borderLine, 400-29, 0,this); // we can clean this up if we want, I guess
        g.drawImage(borderLine, 600-29, 0,this);
        g.drawImage(borderLine, 800-29, 0,this);
        bullet.draw(g);
        
        if(hit==false)
        {
            g.drawImage(block,blockX, blockY,this);
        }
        else if(hit==true)  
        {
            g.drawImage(block2, blockX, blockY,this);
            wait++;
        }
        
        if(wait==175)
        {
            hit=false;
            blockX=newXValue;
            blockY=0;
            wait=0;
        }

        blockRect = new Rectangle(blockX,20,134,134);
        g.drawImage(playerImg,x,900,this);

        //some debuggers
        
        //System.out.println(bullet.proj.y);
        //System.out.println(blockY);
        
        //System.out.println(Bullet.getMoving());
        
        
        if(blockRect.x < bullet.proj.x 
        && blockRect.x + blockRect.width > bullet.proj.x 
        && blockY < bullet.proj.y 
        && blockY + 25 > bullet.proj.y
        //&& Bullet.moving == true
            //what even
        )
        {
            hit=true;
        }

        //more degbugging
        
        /*   
         * int blah = 0;
        if(blah == 0 || blah == 1){
        System.out.print("|||" + blockRect.x + "|||");
        System.out.println("???" + bullet.proj.x + "???");
        blah = blah +1;
        }
         */

        blockMovement();
        repaint();
    }

    public void blockMovement(){
        if(blockY<=1000){
            if(hit==false){
                blockY=blockY+1;
            }
            else{
                newXValue = 0 + (rand.nextInt(5) * 200);
                //blockX=newXValue;
            }
        }
        
        if(blockY>1000){
            System.out.println("Lose");
            if(hit==false){
                blockY=0;
            }
        }
    }

    @Override //tbh I still don't totally get what @override even does but it's what the guy said you had to do in the tut
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            x-=200;
            if(x<0){
                x=x+200;
                newX=x;
            }
            else{
                newX=x;
            }
        }
        
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            x+=200;
            if(x>1000){
                x=x-200;
                newX=x;
            }
            else{
                newX=x;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}