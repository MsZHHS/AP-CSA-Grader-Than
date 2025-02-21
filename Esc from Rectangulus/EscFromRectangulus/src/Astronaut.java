
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

  public int getDirection() {
    return direction;
  }

  public Rectangle getBody() {
    return body;
  }

  public void setDirection(int d) {
    direction = d;
  }

  public void move() {
    // move right
    if (direction == 1) {
      if (xVelocity < terminalVelocity) {
        xVelocity++;
      }
    }
    // move left
    else if (direction == -1) {
      if (xVelocity > -terminalVelocity) {
        xVelocity--;
      }
    }
    // stationary .. or slow down
    else {
      if (xVelocity < 0) {
        xVelocity++;
      } else if (xVelocity > 0) {
        xVelocity--;
      }
    }
    body.x += xVelocity;

    if (body.y < 360 + playerNum * 400) {
      body.y -= yVelocity;
      yVelocity--;
    }
    // boundary checking..
    if (body.x < 0) {
      body.x = 0;
    }
    if (body.x > 780) {
      body.x = 780;
    }
    if (body.y > 360 + playerNum * 400) {
      body.y = 360 + playerNum * 400;
    }
  }

  public void jump() {
    if (body.y == 360 + playerNum * 400) {
      yVelocity = 15;
      body.y -= 15;
    }
  }
}
