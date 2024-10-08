// Package declaration
package dgraphics.dcombo;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import javax.swing.JComboBox;
import dgraphics.DFont;
import dgraphics.dtheme.DColors_CBO;


/**
 * Class ComboBox, created in order to simplify style application
 * 
 * @author  AdrienG
 * @version 0.0
 * 
 * It act like a normal JComboBox but has a different looking :
 * - rounded angle
 * - arrow button that has dynamic color change
 * - popup that has dynamic color change
 */
public class DComboBox<E> extends JComboBox<E> {

    /**
     * Graphical attribute
     */
    private final Color       fontDefaultColor;
    private final Color       fontActiveColor;
    private final Color       boxDefaultColor;
    private final Color       boxFlyoverColor;
    private final Color       boxActiveColor;
    private final int         fontSize;




    /**
      * Constructor
      * 
      * @param items            item to select in the Combo
      * @param fontSize         font size
      * @param fontDefaultColor font default color
      * @param fontActiveColor  font color on click
      * @param boxDefaultColor  default color
      * @param boxFlyoverColor  color on flyover
      * @param boxActiveColor   color on click
      */
    public DComboBox(E[] items, int fontSize, DColors_CBO colorSet) {

        // Herited constructor
        super(items);


        // Getting attributes
        this.fontSize           = fontSize;
        this.fontDefaultColor   = colorSet.FNT_D;
        this.fontActiveColor    = colorSet.FNT_L;
        this.boxDefaultColor    = colorSet.BCK_D;
        this.boxFlyoverColor    = colorSet.BCK_N;
        this.boxActiveColor     = colorSet.BCK_L;


        // Setting up UI
        this.setUI      (new DComboBoxUI(fontSize, fontDefaultColor, fontActiveColor, boxDefaultColor, boxFlyoverColor, boxActiveColor));


        // Setting up list renderer
        this.setRenderer(new DComboBoxRenderer(fontSize, fontDefaultColor, fontActiveColor, boxDefaultColor, boxFlyoverColor));


        // Set custom editor
        this.setEditor  (new DComboBoxEditor(fontActiveColor));
        this.setEditable(true);



        // Setting up font
        try {

            // Getting localy installed font
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(DFont.JOST_SEMIBOLD.getFontPath()));
            this.setFont(font.deriveFont((float) fontSize));


        } catch (FontFormatException | IOException | NullPointerException  e) {
            
            // Default font
            this.setFont(new Font("Serif", Font.PLAIN, fontSize));

        }


        // Make it transparent
        this.setOpaque   (false);
    }




    /**
     * Painting the component
     */
    @Override
    protected void paintComponent(Graphics g) {

        // Use Graphics2D to get anti-aliasing
        Graphics2D g2d =    (Graphics2D) g.create();
        
        
        // Acivate aliasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        
        // Painting the button with cornered angle
        g2d.setColor        (this.getBackground());
        g2d.fillRoundRect   (0, 0, getWidth(), getHeight(), 20, 20); // Bordure arrondie


        // Repainting the component
        super   .paintComponent(g);
        g2d     .dispose();
    }




    /**
     * Update UI
     */
    @Override
    public void updateUI() {
        this.setUI(new DComboBoxUI(fontSize, fontDefaultColor, fontActiveColor, boxDefaultColor, boxFlyoverColor, boxActiveColor));
    }

}
