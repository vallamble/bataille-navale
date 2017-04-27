package cad.model;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import sun.security.tools.keytool.Main;

public class Board extends JPanel{
	
	private JButton[][] plateau;
	private int width = 10,height = 10;
	private char x = 'A';

	public Board(){
		this.plateau = new JButton[width + 1][height + 1];
		this.setLayout(new GridLayout(width + 1,height + 1,1,1));
		for(int i = 0;i <= width;i++){
			for(int j = 0;j <= height;j++){
				if(i == 0){
					if(j != 0)
						this.plateau[i][j] = new JButton("" + j);
					else	
						this.plateau[i][j] = new JButton();
					this.plateau[i][j].setEnabled(false);
				}else{
					if(j == 0){
						this.plateau[i][j] = new JButton("" + x);
						x += 1;						
						this.plateau[i][j].setEnabled(false);
					}else{
						this.plateau[i][j] = new JButton();
					}
				}
					this.plateau[i][j].setPreferredSize(new Dimension(50,50));
					this.add(plateau[i][j]);
				}
			}
		//pour nihad a supp//
		setimage(9,1);
		}
	
	//////pour nihad a supp d ici//
	public void setimage(int x,int y){
		URL img= Main.class.getResource("/cad/a.PNG");
		try {
			BufferedImage bimg = ImageIO.read(img);
	        int w=bimg.getWidth();
	        for(int j=0;j<5;j++){//nbre de case
                BufferedImage wim = bimg.getSubimage(j*50,0,50,50);
                //50 car les cases font une taille de 50*50
                Image sc=wim.getScaledInstance(50,50, Image.SCALE_AREA_AVERAGING);
        		this.plateau[x][y].setIcon(new ImageIcon(sc));
        		y++;
        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}



