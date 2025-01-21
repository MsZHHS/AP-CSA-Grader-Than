import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Astronaut {

    private Rectangle body;
    private int playerNum;
    private int xVelocity, yVelocity, direction;
    private int terminalVelocity = 8;
  
    public Astronaut() {
      body = new Rectangle(390, 360, 20, 40);
  
    }
  
    public Astronaut(int pNum) {
      playerNum = pNum;
      body = new Rectangle(390, 360 + playerNum * 400, 20, 40);
  
    }
  
    private double theta = 0.0;
  
    public void draw(Graphics2D g) {
      g.fill(body);
    }

    
}