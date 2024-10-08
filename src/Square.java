// Imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import dgraphics.DFont;
import dgraphics.dtheme.DTheme;


/**
 * Square class
 * 
 * @author  AdrienG
 * @version 0.0
 * 
 * 
 */
public class Square extends JPanel implements MouseListener{

    /**
     * Attributes
     */
    private final   App     app;
    private final   int     posX;
    private final   int     posY;
    private         Color   mainColor   = DTheme.SQR_NTL.BCK_N;
    private         boolean isRevealed  = false;
    private         boolean isLocked    = false;
    private         int     sqSize;
    private         int     fontSize;
    private         int     coefficient;                        // 0 = 0 mine around        -1 = the square is a mine




    /**
     * Graphical attributes
     */
    private         Font    font;




    /**
     * Constructor
     */
    public Square(App app, int newPosX, int newPosY, int sqSize) {

        // Herited constructor
        super();


        // Getting attributes
        this.app        = app;
        this.posX       = newPosX;
        this.posY       = newPosY;
        this.sqSize     = sqSize;
        this.fontSize   = (int) (this.sqSize * 0.70);


        // Setting the listener
        this.initListener();

    }




    /**
     * setter : square Size
     * 
     * Note : square size has consequence on the font size
     * 
     * @param sqSize the size in px of the lenght (and width) of the square
     */
    public final void setSquareSize(int sqSize) {

        // Setting up square size
        this.sqSize = sqSize;
        this.setPreferredSize   (new Dimension(this.sqSize, this.sqSize));
        this.setMaximumSize     (new Dimension(this.sqSize, this.sqSize));
        this.setMinimumSize     (new Dimension(this.sqSize, this.sqSize));


        // CHanging font size
        this.fontSize = (int) (this.sqSize * 0.70);


        // Setting up font
        Font font_;
        try {

            // Getting localy installed font
            font_   = Font.createFont(Font.TRUETYPE_FONT, new File(DFont.JOST_SEMIBOLD.getFontPath())).deriveFont((float) fontSize);


        } catch (FontFormatException | IOException | NullPointerException e) {
            
            // Default font
            System.out.println(e);
            font_   = new Font("Arial", Font.BOLD, fontSize);

        }
        this.font = font_;


        // Appyling font
        this    .setFont(font);

    }




    /**
     * Listener intit
     */
    private void initListener() {
        addMouseListener(this);
    }




    /**
     * Setter
     * @param coefficient
     */
    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }




    /**
     * Repainting the component
     */
    @Override
    public void paintComponent(Graphics g) {

        // Clear the component
        super.paintComponent (g);


        // Background color
        this.setBackground(DTheme.GUI_NTL.BCK_N);


        // Use Graphics2D to get anti-aliasing
        Graphics2D g2d =    (Graphics2D) g;
        
        
        // Acivate aliasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        // Setting the new color
        g2d.setColor        (mainColor);
        g2d.fillRoundRect   (0, 0, sqSize, sqSize, sqSize / 4, sqSize / 4);


        // Setting the font color if necessary
        if (isRevealed) {            

            // Setting the string and the color for the display
            g2d.setFont(font);
            FontMetrics metrics = g2d.getFontMetrics(font);
            switch (coefficient) {
                case -1 -> {
                    g2d.setColor(DTheme.SQR_NTL.FNT_M);
                    g2d.drawString(
                            "¤",
                            (getWidth()     - metrics.stringWidth("¤")) / 2,
                            (getHeight()    - metrics.getHeight())          / 2 + metrics.getAscent()
                    );

                }

                case 1 -> {
                    g2d.setColor(DTheme.SQR_NTL.FNT_1);
                    g2d.drawString(
                            String.valueOf(coefficient),
                            (getWidth()     - metrics.stringWidth(String.valueOf(coefficient))) / 2,
                            (getHeight()    - metrics.getHeight())                              / 2 + metrics.getAscent()
                    );
                }
                
                case 2 -> {
                    g2d.setColor(DTheme.SQR_NTL.FNT_2);
                    g2d.drawString(
                            String.valueOf(coefficient),
                            (getWidth()     - metrics.stringWidth(String.valueOf(coefficient))) / 2,
                            (getHeight()    - metrics.getHeight())                              / 2 + metrics.getAscent()
                    );
                }

                case 3 -> {
                    g2d.setColor(DTheme.SQR_NTL.FNT_3);
                    g2d.drawString(
                            String.valueOf(coefficient),
                            (getWidth()     - metrics.stringWidth(String.valueOf(coefficient))) / 2,
                            (getHeight()    - metrics.getHeight())                              / 2 + metrics.getAscent()
                    );
                }

                case 4 -> {
                    g2d.setColor(DTheme.SQR_NTL.FNT_4);
                    g2d.drawString(
                            String.valueOf(coefficient),
                            (getWidth()     - metrics.stringWidth(String.valueOf(coefficient))) / 2,
                            (getHeight()    - metrics.getHeight())                              / 2 + metrics.getAscent()
                    );
                }

                case 5 -> {
                    g2d.setColor(DTheme.SQR_NTL.FNT_5);
                    g2d.drawString(
                            String.valueOf(coefficient),
                            (getWidth()     - metrics.stringWidth(String.valueOf(coefficient))) / 2,
                            (getHeight()    - metrics.getHeight())                              / 2 + metrics.getAscent()
                    );
                }

                case 6 -> {
                    g2d.setColor(DTheme.SQR_NTL.FNT_6);
                    g2d.drawString(
                            String.valueOf(coefficient),
                            (getWidth()     - metrics.stringWidth(String.valueOf(coefficient))) / 2,
                            (getHeight()    - metrics.getHeight())                              / 2 + metrics.getAscent()
                    );
                }

                case 7 -> {
                    g2d.setColor(DTheme.SQR_NTL.FNT_7);
                    g2d.drawString(
                            String.valueOf(coefficient),
                            (getWidth()     - metrics.stringWidth(String.valueOf(coefficient))) / 2,
                            (getHeight()    - metrics.getHeight())                              / 2 + metrics.getAscent()
                    );
                }

                case 8 -> {
                    g2d.setColor(DTheme.SQR_NTL.FNT_8);
                    g2d.drawString(
                            String.valueOf(coefficient),
                            (getWidth()     - metrics.stringWidth(String.valueOf(coefficient))) / 2,
                            (getHeight()    - metrics.getHeight())                              / 2 + metrics.getAscent()
                    );
                }

            }

            
        } else if (isLocked) {

            // Setting the string and the color for the display
            g2d.setFont(font);
            FontMetrics metrics = g2d.getFontMetrics(font);
            g2d.setFont(new Font("Serif", Font.PLAIN, fontSize));
            g2d.setColor(DTheme.SQR_NTL.BCK_L);
            g2d.drawString(
                    "⚑",
                    (getWidth()     - metrics.stringWidth("⚑")) / 2,
                    (getHeight()    - metrics.getHeight())                              / 2 + metrics.getAscent()
            );

        }


        // Free resources
        // g2d.dispose();

    }




    /**
     * Reveal the square
     */
    public int reveal() {

        // Checking if the square is already revealed
        if (!isRevealed) {

            // Reveal the square
            isRevealed  = true;

            // Applying the color according to its type (mine or not)
            if (coefficient != -1) {
                mainColor   = DTheme.SQR_NTL.BCK_D;
            } else {
                mainColor   = DTheme.SQR_NTL.BCK_M;
            }
            repaint();

            // Success code
            return 0;


        } else {

            // Fail code : the square is already revealed
            return -1;
        }
    }




    /**
     * Getter : to check if the square is revealed or not
     * 
     * @return isRevealed showing if the Square is revealed
     */
    public boolean isSquareRevealed() {
        return isRevealed;
    }




    /**
     * Getter : to check if the square is locked or not
     * 
     * @return isLocked showing if the Square is locked
     */
    public boolean isSquareLocked() {
        return isLocked;
    }




    /**
     * Getter : to get the size of the square
     * 
     * @return sqSize
     */
    public int getSquareSize() {
        return sqSize;
    }




    /**
     * Mouse Pressed on the square
     */  
    @Override 
    public void mousePressed (MouseEvent e) {

        // Action that depend on the click type
        if (SwingUtilities.isLeftMouseButton(e) && !isRevealed && !isLocked) {

            // Left button, we want to reveal this square
            app.clickEvent(posX, posY);


        } else if (SwingUtilities.isRightMouseButton(e) && !isRevealed) {

            // Enable / disable lock
            isLocked = !isLocked;
            this.repaint();

        }
        
    }
    

    
    
    /**
     * Mouse Clicked on the square
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // Nothing
    }




    /**
     * Mouse Released on the square
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        // Nothing
    }




    /**
     * Mouse enter the square
     */
    @Override
    public void mouseEntered(MouseEvent e) {

        // Changing color if it's not revealed
        if (!isRevealed) {
            mainColor = DTheme.SQR_NTL.BCK_L;
            repaint(); 
        }
    }




    /**
     * Mouse leave the square
     */
    @Override
    public void mouseExited(MouseEvent e) {

        // Reseting color according to its state
        if (!isRevealed) {
            mainColor = DTheme.SQR_NTL.BCK_N;
        }
        repaint();
    }
    

}
