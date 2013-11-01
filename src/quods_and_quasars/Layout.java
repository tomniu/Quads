package quods_and_quasars;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.*;

public class Layout extends JPanel{
	Piece [][]list = new Piece[11][11];

	
	public Layout(int size){
		
		JPanel p = new JPanel();
		
		p.setLayout(new GridLayout(size,size));
		
		for(int i=0;i<size;i++){
			for(int j = 0;j<size;j++){
				list[i][j]= new Piece(i,j,2000);
				list[i][j].setSize(10,10);
				p.add(list[i][j]);
				
				if(((i==0&&j==0)||(i==0&&j==10)||(i==10&&j==0)||(i==10&&j==10))){
					list[i][j].setEnabled(false);
					list[i][j].setVisible(false);
				}
		}
			p.setPreferredSize(new Dimension(900,900));
			add(p);
				
		}
		for(int i = 0;i<size;i++){
			for(int j = 0;j<size;j++){
				
				list[i][j].setActionCommand("Piece");
				
			}
		}
		
		
		

		

	}
	
	public Piece[][] getList(){
		return list;
		
	}

	public static void resetBoard(Piece[][]list,int size){

		for(int i = 0;i<size;i++){
			for(int j = 0;j<size;j++){
				list[i][j].setBackground(Color.darkGray);
				list[i][j].setEnabled(true);
				list[i][j].setCount(2000);
				list[i][j].setType(0);
			}
		}
	}
	

	
}