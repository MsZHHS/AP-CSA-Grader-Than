import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * version 1.11
 * 
 * Project created by: Dave Ruth .. Niles North High School .. Skokie, IL ..
 * www.MrRuth.com
 * 
 * ~~~~~~~~~~~~~~~~~~~~~ Escape from Rectangulus ~~~~~~~~~~~~~~~~~~~~~<br>
 * You are an American Astronaut named jon exploring the uncharted planet
 * Rectangulus. You find yourself attempting to evade a seemingly infinite swarm
 * of attacking alien Rectangles. Somehow they have transformed your body to be
 * of similar shape and color to their own. The slightest touch of their
 * rectangular perimeter causes instant death. You have no weapons, but you can
 * accelerate horizontally and jump to avoid these persistent aliens. How long
 * can jon stay alive?
 * <p>
 * This game is implemented as a simple JPanel embedded in a JFrame<br>
 * with a Timer for animation. <br>
 * 
 * <xmp><code><pre>
 * Task 0:
 * compile and run EscapeFromRectangulus.
 * 
 * Task 1: (in class Astronaut)
 * create a class called Astronaut in a separate Java source file.
 * import java.awt.*;
 * required fields (or instance variables):
 *   Rectangle body; int xVelocity, yVelocity, direction;
 *   A Rectangle Object has four public fields:
 *   body.x and body.y are the (x,y) pixel coordinates of the top-left corner
 *   and body.width and body.height are the pixel width and height.
 *   look up Rectangle in the Java Documentation for more information
 * write a default constructor that creates a Astronaut 
 *   where the body is a Rectangle that is 20x40 
 *   and is standing at the bottom/center of the window (i.e. coordinates (390,360))
 *   the int variables can stay at their default values of 0
 * write method: public void draw(Graphics2D g)
 *   that will render the body of the Astronaut ..use  g.fill(body)
 * 
 * Task 1a: (in class EscapeFromRectangulus)
 * uncomment the jon instance variable
 * in method initRound()
 *   initialize variable jon
 * in method draw()
 *   render jon by invoking its draw method
 *   (  example:   jon.draw(g);  )
 * YOU SHOULD SEE jon STANDING ALONE ON THE SURFACE OF RECTANGULUS!
 * 
 * Task 2: (in class EscapeFromRectangulus)
 * uncomment the aliens instance variable
 * in method initRound()
 *    initialize variable aliens
 * in method draw()
 *   write a for loop in to render all the Rectangles in aliens
 *   .. use g.draw(..)
 * in method actionPerformed() 
 *   Uncomment the A.I. code
 *   write a loop to subtract the width of each Rectangle from its x-coordinate
 *   write the code to remove the first Rectangle of aliens
 *     if its x-coordinate is less than 0
 * THE ALIENS SHOULD APPEAR QUICK AND NASTY AT THIS TIME!
 * 
 * Task 3: (in class Astronaut)
 * write method: public int getDirection() that returns direction
 * write method: public Rectangle getBody() that returns body
 * write method: public void setDirection(int d)
 *   Note: d will be -1 for moving left,
 *   1 for moving right, and 0 for stationary
 * write method: public void move()
 *   3 exclusive cases for the value of direction:
 *   .. direction is 1 (i.e. right)
 *     add 1 to xVelocity only if xVelocity is less than 8
 *   .. direction is -1 (i.e. left)
 *     subtract 1 from xVelocity only if xVelocity is greater than -8
 *   .. direction is 0 (i.e. stationary)
 *     if xVelocity is negative, add 1 to xVelocity (i.e. to slow down)
 *     if xVelocity is positive, subtract 1 from xVelocity (i.e. to slow down)
 *       PHUN PHYSICS NOTE:
 *       by adding 1 or -1 to xVelocity.. the constant value 1 is actually 
 *       the acceleration and the value 8 is actually the terminal velocity
 *   now add xVelocity to body.x (this physically moves the Astronaut)
 *   if body.y is less than 360,(i.e. body is above the ground)
 *     subtract yVelocity from body.y and decrement yVelocity by 1
 *       (special note.. since the (0,0) origin is at the top-left corner 
 *        of the window, y increases going down)
 *        
 * Task 3a: (in class EscapeFromRectangulus)
 * uncomment the lines that invoke setDirection and move methods of jon
 * YOU SHOULD BE ABLE TO MOVE AMONG THE ALIEN SWARM!
 * 
 * Task 4 (in class Astronaut)
 * continue in method: public void move()
 *   (... boundary checking ...)
 *   if body.x is negative, assign 0 to body.x
 *   if body.x is greater than 780, assign 780 to body.x
 *   if body.y is greater than 360 (ground level), assign 360 to body.y
 * write method: public void jump()
 *   if body.y is 360 (i.e. body is on the ground),
 *     set yVelocity to 15 and subtract 15 from body.y 
 * 
 * Task 4a: (in class EscapeFromRectangulus)
 * uncomment the lines that invoke jump method of jon
 * YOU SHOULD BE ABLE TO MOVE AND JUMP AMONG THE ALIEN SWARM!
 * 
 * Task 5: (in class EscapeFromRectangulus)
 * in method actionPerformed()
 *   write code to stop the timer if jon intersects any Rectangle in aliens
 *   .. example:   jon.getBody().intersects(..)
 * (hint: to learn how to stop the timer, examine how Timer timer was started)
 * 
 * ==========================================================================
 *      CONGRATULATIONS! YOU HAVE CREATED AN ADDICTING PLATFORM GAME!
 * ==========================================================================
 * 
 * Some possibilities to change the game into something more original
 * (for advanced programmers)
 * 
 * Display a current High Score
 * 
 * Change the color of jon or aliens (could be a random color)
 * 
 * Change the Font type, style or size of title..
 * as well as the title text.
 *   (Create a Font instance variable and use g.setFont(..)
 *   
 * Have the title only visible if (!timer.isRunning())
 * 
 * Change the original dimensions of the window:
 *   in EscapeFromRectangulus..
 *     use BORDER.height - jon.getBody().height instead of 360
 *     use jon.getBody().width instead of 20
 *   in Astronaut..
 *     use EscapeFromRectangulus.BORDER.height - body.height instead of 360
 *   etc.
 * 
 * 
 * In class Astronaut, change Rectangle body to Rectangle2D.Double body
 *   (public fields: x,y,width,height are double values 
 *    that allow for more precise position, velocity and acceleration
 *    since you are not restricted to integer values)
 *    
 * Change ArrayList<Rectangle> aliens to ArrayList<Rectangle2D.Double>
 * 
 * Change the size of any game Objects (Astronaut, aliens, playing field, etc)
 * 
 * Experiment with the AI..
 *   change the value of any of the following:
 *   (note: keep the original code as a comment
 *    if you need to set any values back to the default)
 *  - percent chance of creating during a given frame
 *  - frame rate (i.e. delay of the Timer timer) 
 *  - height of alien Rectangles.. could be random
 *  - speed and/or width of alien Rectangles
 *  - initial jumping velocity of Astronaut
 *  - terminal velocity of Astronaut
 *  - acceleration of Astronaut
 *  
 * Add sound effects
 *   private AudioClip boing;
 *   boing = Applet.newAudioClip(getClass().getResource("boing.wav"));
 *   //boing.wav file must be in the same directory as the class files
 *   //.. in eclipse, simply place boing.wav in the src directory
 *   boing.play();//play sound once
 *   boing.loop();//continuous play .. could be used for background music
 *   //be careful with this one.. consider overriding public void destroy();
 * 
 * Add images
 *   private BufferedImage img;
 *   try {
 *       img = ImageIO.read(getClass().getResource("viking.gif"));
 *   } catch (IOException ex) {
 *     ex.printStackTrace();
 *   }
 *   g.drawImage(img,100,150,null);//img rendered at coordinates (100,150)
 *   //viking.gif file must be in the same directory as the class files
 *   //.. in eclipse, simply place viking.gif in the src directory
 * 
 * Add sprites (animated images .. use an array of BufferedImage)
 *   ??
 *   
 * Additional gameplay changing ideas...
 *  - include a super-zapper (like in 1981 Atari hit Tempest or
 *    the smart-bomb in 1980 Williams game Defender)
 *    that zaps all the aliens on the screen with one keystroke..
 *    perhaps you gain one of these every 1000 points or something..
 *    
 *  - ??
 */
public class EscapeFromRectangulus extends JPanel implements KeyListener,
    ActionListener {

  // DECLARE ALL INSTANCE VARIABLES HERE..

  // private ArrayList<Rectangle> aliens;
  // private Astronaut jon;
  public static final Rectangle BORDER = new Rectangle(0, 0, 800, 400);
  private int frameCount;// used for the score
  private String title = "~~ Escape From Rectangulus ~~  .. (click here first) .. "
      + "CONTROLS: arrows = move, space = jump, r = restart .. ..........";
  private Timer timer;// handles animation
  private static Image offScreenBuffer;// needed for double buffering graphics
  private Graphics offScreenGraphics;// needed for double buffering graphics

  /**
   * main() is needed to initialize the window.<br>
   * THIS METHOD SHOULD NOT BE MODIFIED! .. <br>
   * you should write all necessary initialization code in initRound()
   */
  public static void main(String[] args) {
    JFrame window = new JFrame("Escape From Rectangulus");
    window.setBounds(100, 100, 807, 428);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);

    EscapeFromRectangulus game = new EscapeFromRectangulus();
    game.setBackground(Color.WHITE);
    window.getContentPane().add(game);
    window.setVisible(true);
    game.init();
    window.addKeyListener(game);
  }

  /**
   * init method needed to initialize non-static fields<br>
   * THIS METHOD SHOULD NOT BE MODIFIED! ..
   */
  public void init() {
    offScreenBuffer = createImage(getWidth(), getHeight());// should be 800x400
    offScreenGraphics = offScreenBuffer.getGraphics();
    timer = new Timer(30, this);
    // timer fires every 30 milliseconds.. invokes method actionPerformed()
    initRound();
  }

  /**
   * initializes all fields needed for each round of play (i.e. restart)
   */
  public void initRound() {
    frameCount = 0;

    // YOUR CODE GOES HERE..
    // initialize aliens and jon instance variables here
  }

  /**
   * Called automatically after a repaint request<br>
   * THIS METHOD SHOULD NOT BE MODIFIED! ..
   */
  public void paint(Graphics g) {
    draw((Graphics2D) offScreenGraphics);
    g.drawImage(offScreenBuffer, 0, 0, this);
  }

  /**
   * renders all objects to Graphics g
   */
  public void draw(Graphics2D g) {
    super.paint(g);// refresh the background
    g.setColor(Color.BLACK);
    g.drawString(title, 100, 20);// draw the title towards the top
    g.drawRect(BORDER.x, BORDER.y, BORDER.width - 1, BORDER.height - 1);
    g.drawString("score:  " + frameCount, 380, 100);// approximate middle

    // YOUR CODE GOES HERE..
    // render all game objects here
  }

  /**
   * Called automatically when the timer fires<br>
   * this is where all the game fields will be updated
   */
  public void actionPerformed(ActionEvent e) {

    // jon.move();

    // Simple AI: Each frame there is a 5% chance of creating an alien Rectangle
    // with a random position and width. (note: its width is also its velocity)
    if (Math.random() < 0.05) {
      // aliens.add(new Rectangle(BORDER.width, 360 - (int) (Math.random() *
      // 40), (int) (Math.random() * 15 + 1), 20));
    }

    // YOUR CODE GOES HERE..
    // update all alien Rectangles and stop the timer if any intersect with jon

    frameCount++;// used for the score
    repaint();// needed to refresh the animation
  }

  /**
   * handles any key pressed events and updates the player's direction by
   * setting their direction to either 1 or -1 for right or left respectively
   * and updates their jumping status by invoking jump()
   */
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_LEFT) {
      // jon.setDirection(-1);
    } else if (keyCode == KeyEvent.VK_RIGHT) {
      // jon.setDirection(1);
    } else if (keyCode == KeyEvent.VK_SPACE) {
      // jon.jump();
    }
  }

  /**
   * handles any key released events and updates the player's direction by
   * setting their direction to 0 if they need to stop and restarts the game if
   * the Timer is not running and user types 'r'
   */
  public void keyReleased(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_LEFT /* && jon.getDirection() == -1 */) {
      // jon.setDirection(0);
    } else if (keyCode == KeyEvent.VK_RIGHT/* && jon.getDirection() == 1 */) {
      // jon.setDirection(0);
    } else if (keyCode == KeyEvent.VK_R) {
      if (!timer.isRunning()) {
        timer.start();
        initRound();
      }
    }
  }

  /**
   * this method is needed for implementing interface KeyListener<br>
   * THIS METHOD SHOULD NOT BE MODIFIED! ..
   */
  public void keyTyped(KeyEvent e) {
  }

}// end class EscapeFromRectangulus
