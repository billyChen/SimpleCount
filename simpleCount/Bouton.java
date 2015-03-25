package simpleCount;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import	javax.swing.JButton;

/**
 * <p>
 * Bouton est une classe qui représente une touche de la calculatrice.
 * Chaque instance est instanciée selon le constructeur.
 * Dans ces derniers, on initialise le bouton (fond, text, dimension).
 * </p>
 * @author Billy CHEN
 *
 */
public class Bouton extends JButton
{
	/**
	 * Ce constructeur initialise les boutons à fond gris
	 * @param colorBg
	 * 			Couleur du fond du bouton
	 * @param text
	 * 			Le texte du bouton
	 */
	public	Bouton(Color colorBg, String text)
	{
		super(text);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.setPreferredSize(new Dimension(60, 75));
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		this.setBackground(colorBg);
	}
	
	/**
	 * Ce constructeur initialise les boutons à fond orange
	 * La couleur du texte n'est pas par défaut en blanc
	 * @param colorBg
	 * 			Couleur du fond du bouton
	 * @param colorFont
	 * 			Couleur du texte
	 * @param text
	 * 			Le texte du bouton
	 */
	public	Bouton(Color colorBg, Color colorFont, String text)
	{
		super(text);
		this.setPreferredSize(new Dimension(60, 75));
		this.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		this.setBackground(colorBg);
		this.setForeground(colorFont);
	}
}
