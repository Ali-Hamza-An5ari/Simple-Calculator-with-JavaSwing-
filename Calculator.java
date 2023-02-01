import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.*;
import static java.lang.Math.*;
class GUI implements ActionListener
{
	JFrame frame ;
	JPanel panel1 ;
	JRadioButton r1;
	JRadioButton r2;
	Container c ;
	JTextField inp,res;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,plus,min,Bs,clear,mul,div,eq,dec,sq,sqRt,Inv;
	Font font;
	String input = "", result = "" ,oper,str;
	StringBuilder sb;
	String [] token = null;
	char f,l;
	double num1,num2,ans;	
	int i,len;
	void Draw ()
	{
		frame = new JFrame ("CALCULATOR");
			frame.setBounds(100,50,360,550);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

			Color color = new Color (0,0,0);
			Color color2 = new Color (255,0,0);
			Color color3 = new Color (231,190,64);

		c = frame.getContentPane();
			c.setBackground(color);
			c.setLayout(null);
			
		
		font = new Font("Calibiri",Font.BOLD,15);

		r1 = new JRadioButton("On");
		r2 = new JRadioButton("Off");
		r1.setBounds(10,70,50,30);
		r2.setBounds(10,90,50,30);

		r1.setFont(font);
		r2.setFont(font);

		r1.setForeground(Color.WHITE);
		r2.setForeground(Color.WHITE);
		r1.setBackground(color);
		r2.setBackground(color);

		r1.addActionListener(this);
		r2.addActionListener(this);


		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);bg.add(r2);

		c.add(r1);
		c.add(r2);

		inp = new JTextField ();
			inp.setPreferredSize(new Dimension (1,24));
			inp.setBounds(10,12,310,32);
			c.add(inp);
		
		// ===================================Row1==========================

		clear = new JButton ("C");
			clear.setFont(font);
			clear.setBackground(color2);
			clear.addActionListener(this);
			clear.setBounds(90,70,65,50);
			c.add(clear);

		Bs = new JButton ("DEL");
		Bs.setFont(font);
		Bs.setBackground(color2);
			Bs.addActionListener(this);
			Bs.setBounds(170,70,65,50);
			c.add(Bs);

		div = new JButton ("/");
		div.setFont(font);
		div.setBackground(color3);
			div.addActionListener(this);
			div.setBounds(255,70,65,50);
			c.add(div);


		// ============================Row2===============================
		sqRt = new JButton("\u221A");
			sqRt.setFont(font);
			sqRt.addActionListener(this);
			sqRt.setBounds(10,140,65,50);
			c.add(sqRt);

		sq = new JButton ("X\u00B2");
		sq.setFont(font);
		sq.setBounds(90,140,65,50);
		sq.addActionListener(this);

		c.add(sq);

		Inv = new JButton ("1/x");
		Inv.setFont(font);
		Inv.addActionListener(this);
		Inv.setBounds(170,140,65,50);
		c.add(Inv);


		min = new JButton ("-");
		min.setFont(font);
		min.setBackground(color3);
		min.addActionListener(this);

		min.setBounds(255,140,65,50);
		c.add(min);

		// =============================Row3============================

		b7 = new JButton ("7");
			b7.setFont(font);
			b7.addActionListener(this);
			b7.setBounds(10,215,65,50);
			c.add(b7);
		b8 = new JButton ("8");
			b8.setFont(font);
			b8.addActionListener(this);
			b8.setBounds(90,215,65,50);
			c.add(b8);
		b9 = new JButton ("9");
			b9.setFont(font);
			b9.addActionListener(this);
			b9.setBounds(170,215,65,50);
			c.add(b9);
		mul = new JButton ("x");
		mul.setFont(font);
		mul.setBackground(color3);
			mul.addActionListener(this);
			mul.setBounds(255,215,65,50);
			c.add(mul);


		// ===================================Row4===============================
		
		b4 = new JButton ("4");
			b4.setFont(font);
			b4.addActionListener(this);
			b4.setBounds(10,290,65,50);
			c.add(b4);
		b5 = new JButton ("5");
			b5.setFont(font);
			b5.addActionListener(this);
			b5.setBounds(90,290,65,50);
			c.add(b5);
		b6 = new JButton ("6");
			b6.setFont(font);
			b6.addActionListener(this);
			b6.setBounds(170,290,65,50);
			c.add(b6);

		plus = new JButton ("+");
		plus.setFont(font);
		plus.setBackground(color3);
		plus.addActionListener(this);
		plus.setBounds(255,290,65,50);
		c.add(plus);


		// =========================Row5=============================
			
		b1 = new JButton ("1");
			b1.setFont(font);
			b1.addActionListener(this);
			b1.setBounds(10,360,65,50);
			c.add(b1);		
		b2 = new JButton ("2");
			b2.setFont(font);
			b2.addActionListener(this);
			b2.setBounds(90,360,65,50);
			c.add(b2);		
		
		b3 = new JButton ("3");
			b3.setFont(font);
			b3.addActionListener(this);
			b3.setBounds(170,360,65,50);
			c.add(b3);

		eq = new JButton ("=");
		eq.setFont(font);
		eq.setBackground(color3);
		eq.addActionListener(this);
		eq.setBounds(255,360,65,120);
		c.add(eq);

//			c.add(Tanx);

//		//////////////////////Row 6

		dec = new JButton(".");
			dec.setFont(font);
			dec.addActionListener(this);
			dec.setBounds(170,430,65,50);
			c.add(dec);		
			
		b0 = new JButton ("0");
			b0.setFont(font);
			b0.addActionListener(this);
			b0.setBounds(10,430,145,50);
			c.add(b0);		
	
	}

	public void actionPerformed (ActionEvent ae)
	{
		token = new String[2];
		if(ae.getSource() == r1 )
		{
			if(r1.isSelected())
			{
				b0.setEnabled(true);
				b1.setEnabled(true);
				b2.setEnabled(true);
				b3.setEnabled(true);
				b4.setEnabled(true);
				b5.setEnabled(true);
				b6.setEnabled(true);
				b7.setEnabled(true);
				b8.setEnabled(true);
				b9.setEnabled(true);
				plus.setEnabled(true);
				min.setEnabled(true);
				mul.setEnabled(true);
				div.setEnabled(true);
				Inv.setEnabled(true);
				eq.setEnabled(true);
				sq.setEnabled(true);
				sqRt.setEnabled(true);
				dec.setEnabled(true);
				Bs.setEnabled(true);
				clear.setEnabled(true);

				inp.setEditable(true);

			}
		}
		if(ae.getSource() == r2 )
		{
			if(r2.isSelected())
			{
				b0.setEnabled(false);
				b1.setEnabled(false);
				b2.setEnabled(false);
				b3.setEnabled(false);
				b4.setEnabled(false);
				b5.setEnabled(false);
				b6.setEnabled(false);
				b7.setEnabled(false);
				b8.setEnabled(false);
				b9.setEnabled(false);
				plus.setEnabled(false);
				min.setEnabled(false);
				mul.setEnabled(false);
				div.setEnabled(false);
				Inv.setEnabled(false);
				eq.setEnabled(false);
				sq.setEnabled(false);
				sqRt.setEnabled(false);
				dec.setEnabled(false);
				Bs.setEnabled(false);
				clear.setEnabled(false);

				inp.setEditable(false);

			}
		}

//		}
		input = inp.getText();
		if (ae.getSource() == b0){input = input+ "0";}
		if (ae.getSource() == b1){input = input+ "1";}
		if (ae.getSource() == b2){input = input+ "2";}
		if (ae.getSource() == b3){input = input+ "3";}
		if (ae.getSource() == b4){input = input+ "4";}
		if (ae.getSource() == b5){input = input+ "5";}
		if (ae.getSource() == b6){input = input+ "6";}
		if (ae.getSource() == b7){input = input+ "7";}
		if (ae.getSource() == b8){input = input+ "8";}
		if (ae.getSource() == b9){input = input+ "9";}
		if (ae.getSource() == plus){input = input+ "+";}
		if (ae.getSource() == min){input = input+ "-";}
		if (ae.getSource() == mul){input = input+ "x";}
		if (ae.getSource() == div){input = input+ "/";}
		if (ae.getSource() == clear){input = ""; inp.setText("");}
		if (ae.getSource() == dec){input = input+ ".";}
		if (ae.getSource() == sq) {input = input + "^2";}
		if (ae.getSource() == sqRt) {input = "\u221A"+input;}
		if (ae.getSource() == Inv) {input = "1/"+input+"";}
		if (ae.getSource() == Bs)
		{
			sb = new StringBuilder(inp.getText());
			if (sb.length() > 0)
			{
				sb = sb.deleteCharAt(sb.length()-1);
				input = sb.toString();
			}
			
		}
		
		inp.setText(input);
		
		str = input;
		
		
		if (ae.getSource() == eq)
		{
			result = inp.getText();
			l = input.charAt(input.length()-1);
			f = input.charAt(0);
			
		//Here we are dealing with input syntax error of signs. This if will not allow to enter a sign at last of first.
			// if ((input.charAt(input.length()-1) != '+') || (input.charAt(input.length()-1) != '-') || (input.charAt(input.length()-1) != 'x') || (input.charAt(input.length()-1) != '/')||(input.charAt(0) != '+') ||(input.charAt (0) != '-') || (input.charAt(0) != 'x') || (input.charAt(0) != '/'))
		if ((f != '+') && (f != '-') && (f != 'x') && (f != '/')&& (f != '^') &&(l != '+') &&(l != '-') && (l != 'x') && (l != '/')&& (l != '^')&& (l != '\u221A'))
		{
			if (input.contains("+") )
			{
				token = input.split("[+]");
				num1= Double.parseDouble(token[0]);
				num2= Double.parseDouble(token[1]);
				
				ans = (num1+num2);
				result = ans+"" ;
			}
			if (input.contains("-"))
			{
				token = input.split("[-]");
				num1= Double.parseDouble(token[0]);
				num2= Double.parseDouble(token[1]);
				result = (num1-num2)+"";
			}
			if (input.contains("x"))
			{
				token = input.split("[x]");
				num1= Double.parseDouble(token[0]);
				num2= Double.parseDouble(token[1]);
				result = (num1*num2)+"";
			}
			if (input.contains("/"))
			{
				token = input.split("[/]");
				num1= Double.parseDouble(token[0]);
				num2= Double.parseDouble(token[1]);
				result = (num1/num2)+"";
			}
			if (input.contains("^")) 
			{
   
				token[0] = input.substring(0,input.indexOf('^'));
				token[1] = input.substring(input.indexOf('^')+1);
				if(token[1].equals("2") && token[1].length()==1)
				{

					num1 = Double.parseDouble(token[0]);
					result = String.valueOf(num1*num1);
				}
				else
				{
					result = "Syntax Error!";
				}

				
			} 
			if (input.contains("\u221A"))
			{
				token = input.split("[\u221A]");
				num2 = Double.parseDouble(token[1]);
				result = (sqrt(num2))+"";
				
			}
			if(input.contains("1/"))
			{
				token = input.split("[/]");
				num2= Double.parseDouble(token[1]);
				result = (1/num2)+"";
			}
		}
		else if(f == '-')
        {

            input = input.substring(1);
//            token[0] = input.substring(0,input.indexOf('-'));
            token = input.split("[-]");
            token[0] = "-"+token[0];
            token[1] = input.substring(input.indexOf('-'));
//            token = input.split("[-]");
            num1= Double.parseDouble(token[0]);
            num2= Double.parseDouble(token[1]);
            result = (num1+num2)+"";
        }
		else 
		{
			result = "Syntax Error!";
		}

			inp.setText(result);

		}
			
			
	}
	
	
}


public class Calculator
{
	public static void main (String args[])
	{
		GUI gui = new GUI ();
		gui.Draw();
	}
	
}
