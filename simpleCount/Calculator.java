package simpleCount;

import 	java.awt.BorderLayout;

import	javax.swing.JFrame;
import	javax.swing.JPanel;
import	javax.swing.JLabel;
import	javax.swing.JButton;
import 	java.awt.GridBagConstraints;
import	java.awt.GridBagLayout;
import	java.awt.Color;
import	java.awt.Font;
import	java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import	java.math.BigDecimal;
import	java.math.RoundingMode;

/**
 * <b>Calculator est la classe principale. Elle correspond à la calculatrice du projet.
 *  La classe possède toutes les fonctions nécessaire pour gérer les calculs (ActionListener).
 *  Les touches ont leur propre classe.
 *  </b>
 * <p>
 * La calculatrice contient deux éléments principaux :
 * <ul>
 * <li>Un conteneur, qui contiendra l'écran de la calculatrice ainsi que de ses touches. </li>
 * <li>L'écran, qui affichera ce que l'utilisateur saisira ainsi que le résultat des opérations. </li>
 * </ul>
 * </p>
 * 
 * @see Bouton
 * @author Billy CHEN
 *
 */
public class Calculator extends JFrame
{
	/**
	 * Le conteneur principale qui contient l'écran et les touches
	 * 
	 * @see Calculator#Calculator()
	 * @see Calculator#fillCenter(JPanel)
	 */
	JPanel				mainContainer = new JPanel();
	
	/**
	 * L'écran de la calculatrice
	 * 
	 * @see Calculator#fillInput(JLabel)
	 */
	JLabel				input = new JLabel("0");

	/**
	 *  Permet de récupérer l'operateur saisi par l'utilisateur
	 *  
	 *  @see Calculator#setOperator(char)
	 *  @see Calculator#getOperator()
	 */
	protected char					operator;
	
	/**
	 *  Variable utilisé lorsque l'on ajoute les touches de la calculatrice
	 *  
	 *  @see Calculator#fillCenter(JPanel)
	 */
	protected double				result;
	
	/**
	 * Correspond à l'operande saisi par l'utilisateur
	 * 
	 * @see Calculator#getOperand()
	 * @see Calculator#setOperand(double)
	 */
	protected double				operand;
	
	/**
	 * Booleen qui indique s'il y'a déjà une operande
	 * 
	 * @see Calculator#setOperand1(boolean)
	 * @see Calculator#getOperand1()
	 */
	protected boolean				operand1 = false;
	
	/**
	 * Boolean qui indique s'il y'a déjà un operateur
	 * 
	 * @see Calculator#getOperator1()
	 * @see Calculator#setOperator(char)
	 */
	protected boolean				operator1 = false;
	
	/**
	 * Permet de changer la précision des double
	 * 
	 * @see Calculator#getPrec()
	 * @see Calculator#setPrec(BigDecimal)
	 */
	protected BigDecimal			prec;
		
	/**
	 * <p>
	 * Change la valeur de la précision.
	 * </p>
	 * @param prec
	 * 			La précision du double.
	 * 
	 * @see Calculator#prec
	 */
	protected void			setPrec(BigDecimal prec)
	{
		this.prec = prec;
	}
	
	/**
	 * Retourne la précision du double.
	 * @return la précision du double, un BigDecimal.
	 */
	protected BigDecimal			getPrec()
	{
		return (this.prec);
	}

	/**
	 * Change la valeur du boolean operator1
	 * @param b
	 * 			La nouvelle valeur du boolean
	 * 
	 * @see Calculator#operator1
	 */
	protected void			setOperator1(boolean b)
	{
		this.operator1 = b;
	}
	
	/**
	 *  Retourne le boolean operator1
	 * @return le boolean operator1(boolean)
	 */
	protected boolean			getOperator1()
	{
		return (this.operator1);
	}

	/**
	 * Change la valeur du boolean operand1
	 * @param b
	 * 		La nouvelle valeur du boolean
	 * 
	 * @see Calculator#operand1
	 */
	protected void			setOperand1(boolean b)
	{
		this.operand1 = b;
	}
	
	/**
	 * Retourne le boolean operand1
	 * @return le boolean operand1 (boolean)
	 */
	protected boolean			getOperand1()
	{
		return (this.operand1);
	}

	/**
	 * Change la valeur du double operand
	 * @param d
	 * 			La nouvelle valeur de operand
	 * 
	 * @see Calculator#operand
	 */
	protected void			setOperand(double d)
	{
		this.operand = d;
	}
	
	/**
	 * Retourne operand
	 * @return operand (double)
	 */
	protected double			getOperand()
	{
		return (this.operand);
	}

	/**
	 * Change la valeur de operator
	 * @param c
	 * 		La nouvelle valeur de operator
	 */
	protected void			setOperator(char c)
	{
		this.operator = c;
	}
	
	/**
	 * Retourne operator
	 * @return operator (char)
	 */
	protected char			getOperator()
	{
		return (this.operator);
	}
	
	/**
	 * Modifie l'apparence de l'écran de la calculatrice (police, fond, dimension, couleur).
	 * @param input
	 * 		L'écran de la calculatrice.
	 * 
	 * @see Calculator#input
	 */
	private	void			fillInput(JLabel input)
	{
		Font				police = new Font("Arial", Font.BOLD, 50);
		
		input.setFont(police);
		input.setPreferredSize(new Dimension(250, 92));
		input.setHorizontalAlignment(JLabel.RIGHT);
		input.setForeground(Color.white);
		input.setBackground(Color.black);
		input.setOpaque(true);
	}
	
	/**
	 *  Ajout des touches de la calculatrice et les lient à leur fonction ActionListener.
	 *  Les touches sont ajoutées dans un JPanel que l'on ajoutera(add) au conteneur principal.
	 * @param center
	 * 			Un conteneur dans lequel on y ajoutera les touches, et qu'on insèrera dans le conteneur principal.
	 * 
	 * @see Calculator#mainContainer
	 */
	private	void			fillCenter(JPanel center)
	{		
		int					i;
		int					mod = 6;
		GridBagLayout		grid = new GridBagLayout();
		GridBagConstraints	c = new GridBagConstraints();
		JButton				button;
		String[]			tabCenter = {	"AC",
											"C",
											"%",
											"/",
											"cos",
											"log",
											"7",
											"8",
											"9",
											"*",
											"tan",
											"exp",
											"4",
											"5",
											"6",
											"-",
											"sin",
											"1",
											"2",
											"3",
											"+",
											"sqrt",
											"0",
											".",
											"=",
											"x^2"
										};
		center.setLayout(grid);
		result = 5;
		for (i = 0; i < tabCenter.length; i++)
		{
			if (i == 12)
			{
				mod = mod - 1;
				result = 1;
			}
			if (i % mod == result && i != 0 || i == tabCenter.length - 1)
			{
				button = new Bouton(	new Color(255, 144, 33), 
										Color.WHITE, 
										tabCenter[i]);	
			}
			else if (i % mod != result && i != tabCenter.length - 1)
			{
				button = new Bouton(	new Color(249, 249, 249),
										tabCenter[i]);
			}
			else
			{
				button = new Bouton(	new Color(255, 144, 33),
										Color.WHITE,
										tabCenter[i]);				
			}
			if (i == 22)
				c.gridwidth = 2;
			else
			{
				if (i % mod == result && i != 0 || i == tabCenter.length - 1)
				{
					c.gridwidth = GridBagConstraints.REMAINDER;
				}
				else
				{
					c.gridwidth = 1;
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 1.0;
				}
			}
			switch (i)
			{
			case 0:
				button.addActionListener(new Delete());
				break;
			case 1:
				button.addActionListener(new Reset());
				break;
			case 2:
				button.addActionListener(new Modulo());
				break;
			case 3:
				button.addActionListener(new Divide());
				break;
			case 4:
				button.addActionListener(new Cosinus());
				break;
			case 5:
				button.addActionListener(new Logarithm());
				break;
			case 9:
				button.addActionListener(new Multi());
				break;
			case 10:
				button.addActionListener(new Tan());
				break;
			case 11:
				button.addActionListener(new Exp());
				break;
			case 15:
				button.addActionListener(new Subtraction());
				break;
			case 16:
				button.addActionListener(new Sin());
				break;
			case 20:
				button.addActionListener(new Sum());
				break;
			case 21:
				button.addActionListener(new SquareRoot());
				break;
			case 24:
				button.addActionListener(new Equal());
				break;
			case 25:
				button.addActionListener(new Square());
				break;
			default:
				button.addActionListener(new Operand());
				break;
			}
			grid.setConstraints(button,  c);
			center.add(button);
		}
}
	
	/**
	 * Constructeur de la classe.
	 * On initialise la fenêtre et on le rempli avec nos éléments (écran et touches)
	 */
	public	Calculator()
	{
		JPanel				center = new JPanel();
	
		fillCenter(center);
		
		this.setSize(500, 500);
		this.setTitle("Calculatrice");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);

	    fillInput(input);
		
	    mainContainer.setLayout(new BorderLayout(0,0));
		mainContainer.add(input, BorderLayout.NORTH);
		mainContainer.add(center, BorderLayout.CENTER);
		this.add(mainContainer);
		this.setVisible(true);		
	}

	/**
	 * Fixe la précision du double ne pouvant pas dépasser 8 chiffres après la virgule et au minimum 2 chiffres.
	 * @param operand
	 *			Le nombre à partir duquel l'on veut modifier la précision 
	 *
	 * @see Calculator#operand
	 */
	private void	setPrecision(double operand)
	{
		if ((String.valueOf(operand)).length() - (String.valueOf(operand)).indexOf('.') > 8)
		{
			prec = new BigDecimal(operand).setScale(8, RoundingMode.HALF_EVEN);								
		}
		else if ((String.valueOf(operand)).length() - (String.valueOf(operand)).indexOf('.') <= 2)
		{
			prec = new BigDecimal(operand).setScale(2, RoundingMode.HALF_EVEN);				
		}
		else
			prec = new BigDecimal(operand).setScale(String.valueOf(operand).length() - (String.valueOf(operand).indexOf('.') + 1),
													RoundingMode.HALF_EVEN);								
	}
	
	/**
	 *  Fonction appelé lorsque l'user clique sur un operateur (+, -, *, /, %)
	 *  Si une opérande à déjà été saisie, alors, on calcule cette dernière avec la nouvelle opérande saisie et l'opérateur
	 *  Sinon, on met à jour notre opérateur et notre opérande (operand, operator)
	 * @param op
	 * 		L'opérateur appelé
	 * 
	 * @see Calculator#operand1
	 * @see Calculator#operand
	 * @see Calculator#operator
	 * @see Calculator#operator1
	 */
	private	void	doOperator(char op)
	{
		if (operand1 == false)
		{
			operand = Double.valueOf(input.getText());
			operator = op;
		}
		else if (operand1 == true)
		{
			Calculate();
			operand1 = false;
			operator = op;
		}
		operator1 = true;
	}
	
	/**
	 *  Calcul les opérandes par rapport à l'operateur.
	 *  Une fois calculé, on affiche le résultat sur l'écran de la calculatrice.
	 */
	private	void	Calculate()
	{
		try
		{
			if (operator == '+')
			{
				operand = operand + Double.valueOf(input.getText());
				setPrecision(operand);
				input.setText(String.valueOf(prec));
			}
			else if (operator == '-')
			{			
				operand = operand - Double.valueOf(input.getText());
				setPrecision(operand);
				input.setText(String.valueOf(prec));
			}
			else if (operator == '*')
			{
				operand = operand * Double.valueOf(input.getText());
				setPrecision(operand);
				input.setText(String.valueOf(prec));
			}
			else if (operator == '/')
			{
				operand = operand / Double.valueOf(input.getText());
				setPrecision(operand);
				input.setText(String.valueOf(prec));
			}
			else if (operator == '%')
			{
				operand = operand % Double.valueOf(input.getText());
				setPrecision(operand);
				input.setText(String.valueOf(prec));
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Div. par zéro impossible");
		}
	}
	
	/**
	 * Classe interne.
	 * Calcule le cosinus du nombre affiché sur l'écran.
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "cos"
	 * @author Billy CHEN
	 *
	 */
	public class Cosinus implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			setPrecision(Math.cos(Math.toRadians(Double.valueOf(input.getText()))));
			input.setText(String.valueOf(prec));
		}
	}
	
	/**
	 * Classe interne.
	 * Efface l'écran et remet à zéro.
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "AC"
	 * @author Billy CHEN
	 *
	 */
	public class Delete implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			input.setText("0");
		}
	}

	
	/**
	 * Classe interne.
	 * Appele la fonction doOperator avec l'opérateur '/'
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "/"
	 * @author Billy CHEN
	 * @see Calculator#doOperator(char)
	 */
	public class Divide implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			doOperator('/');
		}
	}

	
	/**
	 * Classe interne.
	 * Calcule le total.
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche """
	 * @author Billy CHEN
	 * @see Calculator#Calculate()
	 */
	public class Equal implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			Calculate();
			operand1 = false;
			operator1 = true;
		}
	}

	
	/**
	 * Classe interne.
	 * Calcule l'exponentielle du nombre affiché sur l'écran.
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "exp"
	 * @author Billy CHEN
	 *
	 */
	public class Exp implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			setPrecision(Math.exp(Math.toRadians(Double.valueOf(input.getText()))));
			input.setText(String.valueOf(prec));
		}
	}

	
	/**
	 * Classe interne.
	 * Calcule le logarithm du nombre affiché sur l'écran.
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "log"
	 * @author Billy CHEN
	 *
	 */
	public class Logarithm implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			setPrecision(Math.log10(Double.valueOf(input.getText())));
			input.setText(String.valueOf(prec));
		}
	}

	/**
	 * Classe interne.
	 * Appele la fonction doOperator avec l'opérateur '%'
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "%"
	 * @author Billy CHEN
	 *@see Calculator#doOperator(char)
	 */
	public class Modulo implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			doOperator('%');
		}
	}

	/**
	 * Classe interne.
	 * Appele la fonction doOperator avec l'opérateur '*'
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "*"
	 * @author Billy CHEN
	 *@see Calculator#doOperator(char)
	 */
	public class Multi implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			doOperator('*');
		}
	}

	/**
	 * Classe interne.
	 * Affiche les chiffres saisies par l'utilisateur.
	 * Fonction appelé lorsque l'utilisateur appuie sur un chiffre.
	 * @author Billy CHEN
	 *
	 */
	public class Operand implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			if (operator1 == true)
			{
				input.setText("");
				operator1 = false;
				operand1 = true;
			}
			if (input.getText().equals("0"))
				input.setText(((JButton)e.getSource()).getText());
			else
				input.setText(input.getText() + ((JButton)e.getSource()).getText());
		}
	}

	/**
	 * Classe interne.
	 * Remet tous à zéro
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "C"
	 * @author Billy CHEN
	 *
	 */
	public class Reset implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			operand1 = false;
			operator1 = false;
			input.setText("0");
			operand = 0;
		}
	}

	/**
	 * Classe interne.
	 * Calcule le sinus du nombre affiché sur l'écran.
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "sin"
	 * @author Billy CHEN
	 *
	 */
	public class Sin implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			setPrecision(Math.sin(Math.toRadians(Double.valueOf(input.getText()))));
			input.setText(String.valueOf(prec));
		}
	}

	/**
	 * Classe interne.
	 * Calcule la puissance carré du nombre affiché sur l'écran.
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "x^2"
	 * @author Billy CHEN
	 *
	 */
	public class Square implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			setPrecision(Math.pow(Double.valueOf(input.getText()), 2));
			input.setText(String.valueOf(prec));
		}
	}

	/**
	 * Classe interne.
	 * Calcule la racine carré du nombre affiché sur l'écran.
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "sqrt"
	 * @author Billy CHEN
	 *
	 */
	public class SquareRoot implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			setPrecision(Math.sqrt(Double.valueOf(input.getText())));
			input.setText(String.valueOf(prec));
		}
	}
	
	/**
	 * Classe interne.
	 * Appele la fonction doOperator avec l'opérateur '-'
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "-"
	 * @author Billy CHEN
	 * @see Calculator#doOperator(char)
	 */
	public class Subtraction implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			doOperator('-');
		}
	}
	
	/**
	 * Classe interne.
	 * Appele la fonction doOperator avec l'opérateur '+'
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "+"
	 * @author Billy CHEN
	 * @see Calculator#doOperator(char)
	 */
	public class Sum implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			doOperator('+');
		}
	}
	
	/**
	 * Classe interne.
	 * Calcule la tangeante du nombre affiché sur l'écran.
	 * Fonction appelé lorsque l'utilisateur appuie sur la touche "tan"
	 * @author Billy CHEN
	 *
	 */
	public class Tan implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			setPrecision(Math.tan(Math.toRadians(Double.valueOf(input.getText()))));
			input.setText(String.valueOf(prec));
		}
	}

}
