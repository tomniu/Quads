package quods_and_quasars;
import java.awt.Color;
import java.awt.Event;

import javax.swing.JButton;
import javax.swing.JToggleButton;

public class Piece extends JButton {
	int x, y,count=0;
	int liberty;
	String name;
	int type;

	public Piece(int x, int y,int count) {
		super();
		this.x = x;
		this.y = y;
		this.count= count;

	}
	public Piece(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		

	}


	public int getXPosition() {
		return x;
	}

	public void setXPosition(int x) {
		this.x = x;
	}

	public int getYPosition() {
		return y;
	}

	public void setYPosition(int y) {
		this.y = y;
	}
	public void setCount(int count){
		this.count = count;
	}
	public int getCount(){
		return count;
	}
	public int[] getConnected(Piece p,Piece[][]list){
		int x = p.getXPosition();
		int y = p.getYPosition();
		Color c = list[x][y].getBackground();
		Color c1 = list[x-1][y].getBackground();
		Color c2 = list[x][y-1].getBackground();
		Color c3 = list[x+1][y].getBackground();
		Color c4 = list[x][y+1].getBackground();
		int []connect = {0,0,0,0};
		
		if(c1==c)connect[0]=1;
		else if(c1==Color.LIGHT_GRAY)connect[0]=0;
		else connect[0]=-1;
		
		if(c2==c)connect[1]=1;
		else if(c2==Color.LIGHT_GRAY)connect[1]=0;
		else connect[1]=-1;
		
		if(c3==c)connect[2]=1;
		else if(c3==Color.LIGHT_GRAY)connect[2]=0;
		else connect[2]=-1;
		
		if(c4==c)connect[3]=1;
		else if(c4==Color.LIGHT_GRAY)connect[3]=0;
		else connect[3]=-1;
		
		return connect;
	}
	public boolean hasConnected(Piece p, Piece[][]list){
		boolean value=false;
		for(int i = 0;i<4;i++){
		if(getConnected(p,list)[i]==1)value= true;
		}
		return value;
		
		
	}
	public int getLiberty(Piece p,Piece[][]list) {
		int x = p.getXPosition();
		int y = p.getYPosition();
		Color c = p.getBackground();
		
		int connect[]  = getConnected(p, list);
	
		
		return liberty;
	}

	public void setLiberty(int liberty) {
		this.liberty = liberty;
	}
	public String getStringColor(){
		Color c = this.getBackground();
		if(c==Color.BLACK)return "Black";
		else return "White";
	}
	public int[] getBlock(Piece p, Piece[][]list){
		int x = p.getXPosition();
		int y = p.getYPosition();
		int []a = {0,0,0};
		int max_v = 1;
		for(int i=0;i<8;i++){
			if(list[x-4+i][y].getBackground()==list[x-3+i][y].getBackground()&&list[x-4+i][y].getBackground()==list[x][y].getBackground()){max_v++;
			
			}
			else {a[0] = x-4+i+1;
				  a[1]= y;
				a[2]= max_v;  
				}
		}
		return a;
		
	}

	public boolean isFiveRow(Piece p, Piece[][]list){
		int x = p.getXPosition();
		int y = p.getYPosition();
		boolean isTrue = false;
		if(x==-1)isTrue=false;
		else{
		
		for(int i = 0;i<5;i++){
		//vertical
			if(list[x-4+i][y].getBackground()==list[x-3+i][y].getBackground()&&list[x-3+i][y].getBackground()==list[x-2+i][y].getBackground()&&list[x-2+i][y].getBackground()==list[x-1+i][y].getBackground()&&
					list[x-1+i][y].getBackground()==list[x+i][y].getBackground()  &&list[x][y].getBackground()!=Color.LIGHT_GRAY)
				{
				
				if(list[x-4+i][y].getBackground()!=list[x-5+i][y].getBackground()&&list[x+i][y].getBackground()!=list[x+1+i][y].getBackground())
					isTrue=true;
				
				}
			
		//horizontal
			if(list[x][y-4+i].getBackground()==list[x][y-3+i].getBackground()&&list[x][y-3+i].getBackground()==list[x][y-2+i].getBackground()&&list[x][y-2+i].getBackground()==list[x][y-1+i].getBackground()&&
				list[x][y-1+i].getBackground()==list[x][y+i].getBackground()&&list[x][y].getBackground()!=Color.LIGHT_GRAY)
				{
				
				if(list[x][y-4+i].getBackground()!=list[x][y-5+i].getBackground()&&list[x][y+i].getBackground()!=list[x][y+1+i].getBackground())
					isTrue=true;
				
				}
		//diagonal to right
			if(list[x-4+i][y-4+i].getBackground()==list[x-3+i][y-3+i].getBackground()&&list[x-3+i][y-3+i].getBackground()==list[x-2+i][y-2+i].getBackground()&&list[x-2+i][y-2+i].getBackground()==list[x-1+i][y-1+i].getBackground()&&
				list[x-1+i][y-1+i].getBackground()==list[x+i][y+i].getBackground()&&list[x][y].getBackground()!=Color.LIGHT_GRAY)
				{
				
				if(list[x-4+i][y-4+i].getBackground()!=list[x-5+i][y-5+i].getBackground()&&list[x+i][y+i].getBackground()!=list[x+1+i][y+1+i].getBackground())
					isTrue=true;
				
				}
		//diagonal to left
			if(list[x-4+i][y+4-i].getBackground()==list[x-3+i][y+3-i].getBackground()&&list[x-3+i][y+3-i].getBackground()==list[x-2+i][y+2-i].getBackground()&&list[x-2+i][y+2-i].getBackground()==list[x-1+i][y+1-i].getBackground()&&
					list[x-1+i][y+1-i].getBackground()==list[x+i][y-i].getBackground()&&list[x][y].getBackground()!=Color.LIGHT_GRAY)
					{
					
					if(list[x-4+i][y+4-i].getBackground()!=list[x-5+i][y+5-i].getBackground()&&list[x+i][y-i].getBackground()!=list[x+1+i][y-1-i].getBackground())
						isTrue=true;
					
					}
			
		}
		}

			return isTrue;
		
	}

	
	
	
public int getType() {
		return type;
	}
public void setType(int type) {
		this.type = type;
	}
public static String isSquare(Piece[][]list){
		//2x2
		for(int i = 0;i<10;i++){
			for(int j = 0;j<10;j++){
			if(list[i][j].getBackground()==list[i][j+1].getBackground()&&list[i][j].getBackground()==list[i+1][j].getBackground()
					&&list[i][j].getBackground()==list[i+1][j+1].getBackground()&&
					(list[i][j].getBackground()==Color.blue||list[i][j].getBackground()==Color.red)){
					if(list[i][j].getBackground()==Color.blue)return "blue";
					else return "red";
				}
			
			}
		}
		//3x3
		for(int i = 0;i<9;i++){
			for(int j = 0;j<9;j++){
			if(list[i][j].getBackground()==list[i][j+2].getBackground()&&list[i][j].getBackground()==list[i+2][j].getBackground()
					&&list[i][j].getBackground()==list[i+2][j+2].getBackground()&&
					(list[i][j].getBackground()==Color.blue||list[i][j].getBackground()==Color.red)){
					if(list[i][j].getBackground()==Color.blue)return "blue";
					else return "red";
				}
			else if(list[i+1][j].getBackground()==list[i][j+1].getBackground()&&list[i+1][j].getBackground()==list[i+2][j+1].getBackground()
					&&list[i+1][j].getBackground()==list[i+1][j+2].getBackground()&&
					(list[i+1][j].getBackground()==Color.blue||list[i+1][j].getBackground()==Color.red)){
					if(list[i+1][j].getBackground()==Color.blue)return "blue";
					else return "red";
				}
			}
		}
		//4x4
				for(int i = 0;i<8;i++){
					for(int j = 0;j<8;j++){
					if(list[i][j].getBackground()==list[i][j+3].getBackground()&&list[i][j].getBackground()==list[i+3][j].getBackground()
							&&list[i][j].getBackground()==list[i+3][j+3].getBackground()&&
							(list[i][j].getBackground()==Color.blue||list[i][j].getBackground()==Color.red)){
							if(list[i][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i][j+1].getBackground()==list[i+1][j+3].getBackground()&&list[i][j+1].getBackground()==list[i+3][j+2].getBackground()
							&&list[i][j+1].getBackground()==list[i+2][j].getBackground()&&
							(list[i][j+1].getBackground()==Color.blue||list[i][j+1].getBackground()==Color.red)){
							if(list[i][j+1].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+1][j].getBackground()==list[i+3][j+1].getBackground()&&list[i+1][j].getBackground()==list[i+2][j+3].getBackground()
							&&list[i+1][j].getBackground()==list[i][j+2].getBackground()&&
							(list[i+1][j].getBackground()==Color.blue||list[i+1][j].getBackground()==Color.red)){
							if(list[i+1][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					
					
					}
				}
				//5x5
				for(int i = 0;i<7;i++){
					for(int j = 0;j<7;j++){
					if(list[i][j].getBackground()==list[i][j+4].getBackground()&&list[i][j].getBackground()==list[i+4][j].getBackground()
							&&list[i][j].getBackground()==list[i+4][j+4].getBackground()&&
							(list[i][j].getBackground()==Color.blue||list[i][j].getBackground()==Color.red)){
							if(list[i][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					//diagonals
					else if(list[i+1][j].getBackground()==list[i+4][j+1].getBackground()&&list[i+1][j].getBackground()==list[i+3][j+4].getBackground()
							&&list[i+1][j].getBackground()==list[i][j+3].getBackground()&&
							(list[i+1][j].getBackground()==Color.blue||list[i+1][j].getBackground()==Color.red)){
							if(list[i+1][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+2][j].getBackground()==list[i+4][j+2].getBackground()&&list[i+2][j].getBackground()==list[i+2][j+4].getBackground()
							&&list[i+2][j].getBackground()==list[i][j+2].getBackground()&&
							(list[i+2][j].getBackground()==Color.blue||list[i+2][j].getBackground()==Color.red)){
							if(list[i+2][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+3][j].getBackground()==list[i+4][j+3].getBackground()&&list[i+3][j].getBackground()==list[i+1][j+4].getBackground()
							&&list[i+3][j].getBackground()==list[i][j+1].getBackground()&&
							(list[i+3][j].getBackground()==Color.blue||list[i+3][j].getBackground()==Color.red)){
							if(list[i+3][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					
					}
				}
				//6x6
				for(int i = 0;i<6;i++){
					for(int j = 0;j<6;j++){
					if(list[i][j].getBackground()==list[i][j+5].getBackground()&&list[i][j].getBackground()==list[i+5][j].getBackground()
							&&list[i][j].getBackground()==list[i+5][j+5].getBackground()&&
							(list[i][j].getBackground()==Color.blue||list[i][j].getBackground()==Color.red)){
							if(list[i][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					//diagonals
					else if(list[i+1][j].getBackground()==list[i+5][j+1].getBackground()&&list[i+1][j].getBackground()==list[i+4][j+5].getBackground()
							&&list[i+1][j].getBackground()==list[i][j+4].getBackground()&&
							(list[i+1][j].getBackground()==Color.blue||list[i+1][j].getBackground()==Color.red)){
							if(list[i+1][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+2][j].getBackground()==list[i+5][j+2].getBackground()&&list[i+2][j].getBackground()==list[i+3][j+5].getBackground()
							&&list[i+2][j].getBackground()==list[i][j+3].getBackground()&&
							(list[i+2][j].getBackground()==Color.blue||list[i+2][j].getBackground()==Color.red)){
							if(list[i+2][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+3][j].getBackground()==list[i+5][j+3].getBackground()&&list[i+3][j].getBackground()==list[i+2][j+5].getBackground()
							&&list[i+3][j].getBackground()==list[i][j+2].getBackground()&&
							(list[i+3][j].getBackground()==Color.blue||list[i+3][j].getBackground()==Color.red)){
							if(list[i+3][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+4][j].getBackground()==list[i+5][j+4].getBackground()&&list[i+4][j].getBackground()==list[i+1][j+5].getBackground()
							&&list[i+4][j].getBackground()==list[i][j+1].getBackground()&&
							(list[i+4][j].getBackground()==Color.blue||list[i+4][j].getBackground()==Color.red)){
							if(list[i+4][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					
					
					
					}
				}
				//7x7
				for(int i = 0;i<5;i++){
					for(int j = 0;j<5;j++){
					if(list[i][j].getBackground()==list[i][j+6].getBackground()&&list[i][j].getBackground()==list[i+6][j].getBackground()
							&&list[i][j].getBackground()==list[i+6][j+6].getBackground()&&
							(list[i][j].getBackground()==Color.blue||list[i][j].getBackground()==Color.red)){
							if(list[i][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					//diagonals
					else if(list[i+1][j].getBackground()==list[i+6][j+1].getBackground()&&list[i+1][j].getBackground()==list[i+5][j+6].getBackground()
							&&list[i+1][j].getBackground()==list[i][j+5].getBackground()&&
							(list[i+1][j].getBackground()==Color.blue||list[i+1][j].getBackground()==Color.red)){
							if(list[i+1][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+2][j].getBackground()==list[i+6][j+2].getBackground()&&list[i+2][j].getBackground()==list[i+4][j+6].getBackground()
							&&list[i+2][j].getBackground()==list[i][j+4].getBackground()&&
							(list[i+2][j].getBackground()==Color.blue||list[i+2][j].getBackground()==Color.red)){
							if(list[i+2][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+3][j].getBackground()==list[i+6][j+3].getBackground()&&list[i+3][j].getBackground()==list[i+3][j+6].getBackground()
							&&list[i+3][j].getBackground()==list[i][j+3].getBackground()&&
							(list[i+3][j].getBackground()==Color.blue||list[i+3][j].getBackground()==Color.red)){
							if(list[i+3][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+4][j].getBackground()==list[i+6][j+4].getBackground()&&list[i+4][j].getBackground()==list[i+2][j+6].getBackground()
							&&list[i+4][j].getBackground()==list[i][j+2].getBackground()&&
							(list[i+4][j].getBackground()==Color.blue||list[i+4][j].getBackground()==Color.red)){
							if(list[i+4][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+5][j].getBackground()==list[i+6][j+5].getBackground()&&list[i+5][j].getBackground()==list[i+1][j+6].getBackground()
							&&list[i+5][j].getBackground()==list[i][j+1].getBackground()&&
							(list[i+5][j].getBackground()==Color.blue||list[i+5][j].getBackground()==Color.red)){
							if(list[i+5][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					
					
					}
				}
				//8x8
				for(int i = 0;i<4;i++){
					for(int j = 0;j<4;j++){
					if(list[i][j].getBackground()==list[i][j+7].getBackground()&&list[i][j].getBackground()==list[i+7][j].getBackground()
							&&list[i][j].getBackground()==list[i+7][j+7].getBackground()&&
							(list[i][j].getBackground()==Color.blue||list[i][j].getBackground()==Color.red)){
							if(list[i][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					//diagonals
					else if(list[i+1][j].getBackground()==list[i+7][j+1].getBackground()&&list[i+1][j].getBackground()==list[i+6][j+7].getBackground()
							&&list[i+1][j].getBackground()==list[i][j+6].getBackground()&&
							(list[i+1][j].getBackground()==Color.blue||list[i+1][j].getBackground()==Color.red)){
							if(list[i+1][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+2][j].getBackground()==list[i+7][j+2].getBackground()&&list[i+2][j].getBackground()==list[i+5][j+7].getBackground()
							&&list[i+2][j].getBackground()==list[i][j+5].getBackground()&&
							(list[i+2][j].getBackground()==Color.blue||list[i+2][j].getBackground()==Color.red)){
							if(list[i+2][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+3][j].getBackground()==list[i+7][j+3].getBackground()&&list[i+3][j].getBackground()==list[i+4][j+7].getBackground()
							&&list[i+3][j].getBackground()==list[i][j+4].getBackground()&&
							(list[i+3][j].getBackground()==Color.blue||list[i+3][j].getBackground()==Color.red)){
							if(list[i+3][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+4][j].getBackground()==list[i+7][j+4].getBackground()&&list[i+4][j].getBackground()==list[i+3][j+7].getBackground()
							&&list[i+4][j].getBackground()==list[i][j+3].getBackground()&&
							(list[i+4][j].getBackground()==Color.blue||list[i+4][j].getBackground()==Color.red)){
							if(list[i+4][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+5][j].getBackground()==list[i+7][j+5].getBackground()&&list[i+5][j].getBackground()==list[i+2][j+7].getBackground()
							&&list[i+5][j].getBackground()==list[i][j+2].getBackground()&&
							(list[i+5][j].getBackground()==Color.blue||list[i+5][j].getBackground()==Color.red)){
							if(list[i+5][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+6][j].getBackground()==list[i+7][j+6].getBackground()&&list[i+6][j].getBackground()==list[i+1][j+7].getBackground()
							&&list[i+6][j].getBackground()==list[i][j+1].getBackground()&&
							(list[i+6][j].getBackground()==Color.blue||list[i+6][j].getBackground()==Color.red)){
							if(list[i+6][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					}
				}
				//9x9
				for(int i = 0;i<3;i++){
					for(int j = 0;j<3;j++){
					if(list[i][j].getBackground()==list[i][j+8].getBackground()&&list[i][j].getBackground()==list[i+8][j].getBackground()
							&&list[i][j].getBackground()==list[i+8][j+8].getBackground()&&
							(list[i][j].getBackground()==Color.blue||list[i][j].getBackground()==Color.red)){
							if(list[i][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					//diagonals
					else if(list[i+1][j].getBackground()==list[i+8][j+1].getBackground()&&list[i+1][j].getBackground()==list[i+7][j+8].getBackground()
							&&list[i+1][j].getBackground()==list[i][j+7].getBackground()&&
							(list[i+1][j].getBackground()==Color.blue||list[i+1][j].getBackground()==Color.red)){
							if(list[i+1][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+2][j].getBackground()==list[i+8][j+2].getBackground()&&list[i+2][j].getBackground()==list[i+6][j+8].getBackground()
							&&list[i+2][j].getBackground()==list[i][j+6].getBackground()&&
							(list[i+2][j].getBackground()==Color.blue||list[i+2][j].getBackground()==Color.red)){
							if(list[i+2][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+3][j].getBackground()==list[i+8][j+3].getBackground()&&list[i+3][j].getBackground()==list[i+5][j+8].getBackground()
							&&list[i+3][j].getBackground()==list[i][j+5].getBackground()&&
							(list[i+3][j].getBackground()==Color.blue||list[i+3][j].getBackground()==Color.red)){
							if(list[i+3][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+4][j].getBackground()==list[i+8][j+4].getBackground()&&list[i+4][j].getBackground()==list[i+4][j+8].getBackground()
							&&list[i+4][j].getBackground()==list[i][j+4].getBackground()&&
							(list[i+4][j].getBackground()==Color.blue||list[i+4][j].getBackground()==Color.red)){
							if(list[i+4][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+5][j].getBackground()==list[i+8][j+5].getBackground()&&list[i+5][j].getBackground()==list[i+3][j+8].getBackground()
							&&list[i+5][j].getBackground()==list[i][j+3].getBackground()&&
							(list[i+5][j].getBackground()==Color.blue||list[i+5][j].getBackground()==Color.red)){
							if(list[i+5][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+6][j].getBackground()==list[i+8][j+6].getBackground()&&list[i+6][j].getBackground()==list[i+2][j+8].getBackground()
							&&list[i+6][j].getBackground()==list[i][j+2].getBackground()&&
							(list[i+6][j].getBackground()==Color.blue||list[i+6][j].getBackground()==Color.red)){
							if(list[i+6][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+7][j].getBackground()==list[i+8][j+7].getBackground()&&list[i+7][j].getBackground()==list[i+1][j+8].getBackground()
							&&list[i+7][j].getBackground()==list[i][j+1].getBackground()&&
							(list[i+7][j].getBackground()==Color.blue||list[i+7][j].getBackground()==Color.red)){
							if(list[i+7][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					}
				}
				//10x10
				for(int i = 0;i<2;i++){
					for(int j = 0;j<2;j++){
					if(list[i][j].getBackground()==list[i][j+9].getBackground()&&list[i][j].getBackground()==list[i+9][j].getBackground()
							&&list[i][j].getBackground()==list[i+9][j+9].getBackground()&&
							(list[i][j].getBackground()==Color.blue||list[i][j].getBackground()==Color.red)){
							if(list[i][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					//diagonals
					else if(list[i+1][j].getBackground()==list[i+9][j+1].getBackground()&&list[i+1][j].getBackground()==list[i+8][j+9].getBackground()
							&&list[i+1][j].getBackground()==list[i][j+8].getBackground()&&
							(list[i+1][j].getBackground()==Color.blue||list[i+1][j].getBackground()==Color.red)){
							if(list[i+1][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+2][j].getBackground()==list[i+9][j+2].getBackground()&&list[i+2][j].getBackground()==list[i+7][j+9].getBackground()
							&&list[i+2][j].getBackground()==list[i][j+7].getBackground()&&
							(list[i+2][j].getBackground()==Color.blue||list[i+2][j].getBackground()==Color.red)){
							if(list[i+2][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+3][j].getBackground()==list[i+9][j+3].getBackground()&&list[i+3][j].getBackground()==list[i+6][j+9].getBackground()
							&&list[i+3][j].getBackground()==list[i][j+6].getBackground()&&
							(list[i+3][j].getBackground()==Color.blue||list[i+3][j].getBackground()==Color.red)){
							if(list[i+3][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+4][j].getBackground()==list[i+9][j+4].getBackground()&&list[i+4][j].getBackground()==list[i+5][j+9].getBackground()
							&&list[i+4][j].getBackground()==list[i][j+5].getBackground()&&
							(list[i+4][j].getBackground()==Color.blue||list[i+4][j].getBackground()==Color.red)){
							if(list[i+4][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+5][j].getBackground()==list[i+9][j+5].getBackground()&&list[i+5][j].getBackground()==list[i+4][j+9].getBackground()
							&&list[i+5][j].getBackground()==list[i][j+4].getBackground()&&
							(list[i+5][j].getBackground()==Color.blue||list[i+5][j].getBackground()==Color.red)){
							if(list[i+5][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+6][j].getBackground()==list[i+9][j+6].getBackground()&&list[i+6][j].getBackground()==list[i+3][j+9].getBackground()
							&&list[i+6][j].getBackground()==list[i][j+3].getBackground()&&
							(list[i+6][j].getBackground()==Color.blue||list[i+6][j].getBackground()==Color.red)){
							if(list[i+6][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+7][j].getBackground()==list[i+9][j+7].getBackground()&&list[i+7][j].getBackground()==list[i+2][j+9].getBackground()
							&&list[i+7][j].getBackground()==list[i][j+2].getBackground()&&
							(list[i+7][j].getBackground()==Color.blue||list[i+7][j].getBackground()==Color.red)){
							if(list[i+7][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					else if(list[i+8][j].getBackground()==list[i+9][j+8].getBackground()&&list[i+8][j].getBackground()==list[i+1][j+9].getBackground()
							&&list[i+8][j].getBackground()==list[i][j+1].getBackground()&&
							(list[i+8][j].getBackground()==Color.blue||list[i+8][j].getBackground()==Color.red)){
							if(list[i+8][j].getBackground()==Color.blue)return "blue";
							else return "red";
						}
					}
				}
				//11x11
				for(int i = 0;i<1;i++){
					for(int j = 0;j<1;j++){
						//diagonals
						     if(list[i+1][j].getBackground()==list[i+10][j+1].getBackground()&&list[i+1][j].getBackground()==list[i+9][j+10].getBackground()
								&&list[i+1][j].getBackground()==list[i][j+9].getBackground()&&
								(list[i+1][j].getBackground()==Color.blue||list[i+1][j].getBackground()==Color.red)){
								if(list[i+1][j].getBackground()==Color.blue)return "blue";
								else return "red";
							}
						     else if(list[i+2][j].getBackground()==list[i+10][j+2].getBackground()&&list[i+2][j].getBackground()==list[i+8][j+10].getBackground()
								&&list[i+2][j].getBackground()==list[i][j+8].getBackground()&&
								(list[i+2][j].getBackground()==Color.blue||list[i+2][j].getBackground()==Color.red)){
								if(list[i+2][j].getBackground()==Color.blue)return "blue";
								else return "red";
							}
						     else if(list[i+3][j].getBackground()==list[i+10][j+3].getBackground()&&list[i+3][j].getBackground()==list[i+7][j+10].getBackground()
								&&list[i+3][j].getBackground()==list[i][j+7].getBackground()&&
								(list[i+3][j].getBackground()==Color.blue||list[i+3][j].getBackground()==Color.red)){
								if(list[i+3][j].getBackground()==Color.blue)return "blue";
								else return "red";
							}
						else if(list[i+4][j].getBackground()==list[i+10][j+4].getBackground()&&list[i+4][j].getBackground()==list[i+6][j+10].getBackground()
								&&list[i+4][j].getBackground()==list[i][j+6].getBackground()&&
								(list[i+4][j].getBackground()==Color.blue||list[i+4][j].getBackground()==Color.red)){
								if(list[i+4][j].getBackground()==Color.blue)return "blue";
								else return "red";
							}
						else if(list[i+5][j].getBackground()==list[i+10][j+5].getBackground()&&list[i+5][j].getBackground()==list[i+5][j+10].getBackground()
								&&list[i+5][j].getBackground()==list[i][j+5].getBackground()&&
								(list[i+5][j].getBackground()==Color.blue||list[i+5][j].getBackground()==Color.red)){
								if(list[i+5][j].getBackground()==Color.blue)return "blue";
								else return "red";
							}
						else if(list[i+6][j].getBackground()==list[i+10][j+6].getBackground()&&list[i+6][j].getBackground()==list[i+4][j+10].getBackground()
								&&list[i+6][j].getBackground()==list[i][j+4].getBackground()&&
								(list[i+6][j].getBackground()==Color.blue||list[i+6][j].getBackground()==Color.red)){
								if(list[i+6][j].getBackground()==Color.blue)return "blue";
								else return "red";
							}
						else if(list[i+7][j].getBackground()==list[i+10][j+7].getBackground()&&list[i+7][j].getBackground()==list[i+3][j+10].getBackground()
								&&list[i+7][j].getBackground()==list[i][j+3].getBackground()&&
								(list[i+7][j].getBackground()==Color.blue||list[i+7][j].getBackground()==Color.red)){
								if(list[i+7][j].getBackground()==Color.blue)return "blue";
								else return "red";
							}
						else if(list[i+8][j].getBackground()==list[i+10][j+8].getBackground()&&list[i+8][j].getBackground()==list[i+2][j+10].getBackground()
								&&list[i+8][j].getBackground()==list[i][j+2].getBackground()&&
								(list[i+8][j].getBackground()==Color.blue||list[i+8][j].getBackground()==Color.red)){
								if(list[i+8][j].getBackground()==Color.blue)return "blue";
								else return "red";
							}
						else if(list[i+9][j].getBackground()==list[i+10][j+9].getBackground()&&list[i+9][j].getBackground()==list[i+1][j+10].getBackground()
								&&list[i+9][j].getBackground()==list[i][j+1].getBackground()&&
								(list[i+9][j].getBackground()==Color.blue||list[i+9][j].getBackground()==Color.red)){
								if(list[i+9][j].getBackground()==Color.blue)return "blue";
								else return "red";
							}
					
				}
		
		
				}
	return "";
	
				
				
	}
}
	
