package quods_and_quasars;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Quod extends JPanel{
Layout l = new Layout(11);


Piece[][] list = l.getList();

Piece restart = new Piece(-1, -1);
Piece undo = new Piece(-1,-2);

JRadioButton quad_blue = new JRadioButton("quads");
JRadioButton quasar_blue = new JRadioButton("quasars");

JRadioButton quad_red = new JRadioButton("quads");
JRadioButton quasar_red = new JRadioButton("quasars");


int red_quad = 20,red_quasar = 6,count=0;
int blue_quad = 20,blue_quasar = 6;
ButtonGroup g1 = new ButtonGroup();
ButtonGroup g2 = new ButtonGroup();

JLabel red_wins = new JLabel(); 
JLabel blue_wins = new JLabel();
int RED=0,BLUE=0;

public Quod(){
	
	Layout.resetBoard(list,11);
	setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	
	JPanel ActionPanel = new JPanel();
	ActionPanel.setLayout(new BoxLayout(ActionPanel,BoxLayout.X_AXIS));
	
	JPanel control = new JPanel();
	
	control.add(restart);
	control.add(undo);
	
	JPanel score = new JPanel();
	score.add(red_wins);
	score.add(blue_wins);
	
	red_wins.setText("Red: 0");
	blue_wins.setText("Blue: 0");
	
	restart.setText("restart");
	undo.setText("undo");
	
	JPanel blue = new JPanel();
	blue.add(quad_blue);
	blue.add(quasar_blue);
	
	
	g1.add(quad_blue);
	g1.add(quasar_blue);
	quad_blue.setSelected(true);
	
	
	JPanel red = new JPanel();
	red.add(quad_red);
	red.add(quasar_red);
	
	
	g2.add(quad_red);
	g2.add(quasar_red);
	quad_red.setSelected(true);
	
	quad_blue.setText("quads"+" (20)");
	quasar_blue.setText("quasars"+" (6)");

	quad_red.setText("quads"+" (20)");
	quasar_red.setText("quasars"+" (6)");
	
	ActionPanel.add(blue);
	ActionPanel.add(l);
	ActionPanel.add(red);
	l.setPreferredSize(new Dimension(1000,2000));
	
	add(control);
	add(score);
	add(ActionPanel);
	
	ActionListener b  = new ButtonHandler();
	for(int i = 0;i<11;i++){
		for(int j = 0;j<11;j++){
			list[i][j].addActionListener(b);
		}
	}
	restart.addActionListener(b);
	undo.addActionListener(b);

}

public class ButtonHandler implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
	
				
		if(e.getActionCommand()=="Piece"){
			//for blue
			Piece p = (Piece)e.getSource();

			
		
			if((blue_quad>0)&&quad_blue.isSelected()&& blue_quad>0 &&  p.getBackground()!=Color.red&&p.getBackground()!=Color.blue&&p.getBackground()!=Color.lightGray){
				
				p.setBackground(Color.blue);
				p.setType(1);
				p.setCount(count);
				blue_quad--;
				count++;
				
				
				
			}
		
			else if((blue_quasar>0)&&quasar_blue.isSelected()&&blue_quasar>0&&  p.getBackground()!=Color.red&&p.getBackground()!=Color.blue&&p.getBackground()!=Color.lightGray){
				
				p.setBackground(Color.lightGray);
				p.setType(2);
				blue_quasar--;
				p.setCount(count);
				count++;
				System.out.println(p.getType());
			}	
	
		
		
		//for red
		

			else if((red_quad>0)&&quad_red.isSelected()&&red_quad>0&&  p.getBackground()!=Color.red&&p.getBackground()!=Color.blue&&p.getBackground()!=Color.lightGray){
				p.setBackground(Color.red);
				p.setType(-1);
				red_quad--;
				p.setCount(count);
				count++;
			}
			else if((red_quasar>0)&&quasar_red.isSelected()&&red_quasar>0&&  p.getBackground()!=Color.red&&p.getBackground()!=Color.blue&&p.getBackground()!=Color.lightGray){
				p.setBackground(Color.lightGray);
				p.setType(-2);
				red_quasar--;
				p.setCount(count);
				count++;
				
			}
			
			
			
		//test
			if(Piece.isSquare(list).equals("red")){
				JOptionPane.showMessageDialog(null,"red wins" );
				RED++;
			}
			else if(Piece.isSquare(list).equals("blue")){
				JOptionPane.showMessageDialog(null,"blue wins" );
				BLUE++;
			}
			
		
			
			
	
			quad_blue.setText("quads"+" ("+blue_quad+")");
			quasar_blue.setText("quasars"+" ("+blue_quasar+")");

			quad_red.setText("quads"+" ("+red_quad+")");
			quasar_red.setText("quasars"+" ("+red_quasar+")");
			
			g1.clearSelection();
			g2.clearSelection();
			
		
		
		
		}
		
		else{
			
			if(e.getSource()==restart){
				Layout.resetBoard(list,11);
				count=0;
				
				red_wins.setText("Red: "+RED);
				blue_wins.setText("Blue: "+BLUE);
				
				red_quad = 20;
				red_quasar = 6;
				
				blue_quad = 20;
				blue_quasar = 6;
				
				quad_blue.setText("quads"+" ("+blue_quad+")");
				quasar_blue.setText("quasars"+" ("+blue_quasar+")");

				quad_red.setText("quads"+" ("+red_quad+")");
				quasar_red.setText("quasars"+" ("+red_quasar+")");
				
				
			}
			else if(e.getSource()==undo){
				Piece p = null;
				for(int i = 0;i<11;i++){
					for(int j = 0;j<11;j++){
						
						
						if(list[i][j].getCount()==count-1){
							p = list[i][j];
							list[i][j].setBackground(Color.darkGray);
							
							
							
						}
						
					}
				
					
				}
				System.out.println(p.getType());
				if(p.getType()==1){
					blue_quad = blue_quad+1;
					System.out.println("CC");
				}
				if(p.getType()==2){
					blue_quasar = blue_quasar+1;
					System.out.println("SSSS");
				}
				if(p.getType()==-1){
					red_quad = red_quad+1;
				}
				if(p.getType()==-2){
					red_quasar = red_quasar+1;
				}
				quad_blue.setText("quads"+" ("+blue_quad+")");
				quasar_blue.setText("quasars"+" ("+blue_quasar+")");

				quad_red.setText("quads"+" ("+red_quad+")");
				quasar_red.setText("quasars"+" ("+red_quasar+")");
				p.setCount(2000);
				count--;
				
			}
			

		}
		
	
	}
	
}
public static void main(String []args){
	JFrame window = new JFrame("Quod");
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.getContentPane().add(new Quod());
	window.pack();
	window.setVisible(true);
}
}
