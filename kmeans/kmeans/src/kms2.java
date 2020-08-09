import java.awt.Color;
import java.lang.Math.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.lang.Math.*;
import java.awt.geom.Line2D;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class kms2 extends JFrame {	
	
	int x=0;
	int k=0;
	int a=0;
	int k1=0;
	String tmpfilepath,knum,tmp ;
	double posX[] = new double[30000];
	double posY[] = new double[30000];
	Random rnd = new Random();
	JTextField jfd1 = new JTextField(5);
	JPanel pan = new JPanel(); 
	JLabel jlb1 = new JLabel("k=");
	JButton btn1 = new JButton("read file");
	JButton btn2 = new JButton("start");
	JButton btn3 = new JButton("clear");
	ArrayList alt1 = new ArrayList();
	void drawpoint()
	{
		for(int a=0;a<(Integer.valueOf((String)alt1.get(0))*2-2);a=a+2)
		{
			posX[x]=Double.parseDouble((String)alt1.get(a+2));
			posY[x]=Double.parseDouble((String)alt1.get(a+3));
		x++;
		}
		Graphics g1 = pan.getGraphics();
		Graphics2D g2 = (Graphics2D) g1; 
		g2.setColor(Color.BLACK);
		for(int i = 0 ; i < (Integer.valueOf((String)alt1.get(0))) ; i++)
		{
			g2.draw(new Line2D.Double((posX[i]/12)*400, (posY[i]/12)*400, (posX[i]/12)*400, (posY[i]/12)*400));
		}
				
	}
	void kms()
	{
		
	}

	
	void fileread()
	{
		final JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(new java.io.File("C:\\"));
		jfc.setApproveButtonText("確定");
		Component jLabel1 = null;
		jfc.showDialog(jLabel1, null); 
		File filePath = jfc.getSelectedFile();
		tmpfilepath = filePath.getPath().toString();
		try
		{
			FileReader fr = null;
			fr = new FileReader(tmpfilepath);
			BufferedReader br = new BufferedReader(fr);
			int i = 0;
			while((tmp=br.readLine()) != null)
			{
				String[] tmpfirst;
				tmpfirst = tmp.split(" ");				
				alt1.add(tmpfirst[0]);
				i++;
				alt1.add(tmpfirst[1]);
				//System.out.println((String)alt.get(i-1)+" "+(String)alt.get(i));
				i++;		
				
			}
			
						   
		}
			catch (FileNotFoundException e1)
			{
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public kms2() 
	{
			super("kmeans");
			Container c = getContentPane();
			GridBagLayout gb = new GridBagLayout();
			GridBagConstraints gbc = new GridBagConstraints();
			GridBagConstraints gbc1 = new GridBagConstraints();
			c.setLayout(gb);
			//版面配置
			pan.setBackground(Color.WHITE);  
			pan.setPreferredSize(new Dimension(400,400)); 
			gbc1.gridx = 0; gbc1.gridy = 0 ;
			gbc1.gridheight = 4 ;
			gb.setConstraints(pan, gbc1);
			gbc.insets=new Insets(5,5,5,5);
			gbc.gridx = 5 ; gbc.gridy = 1 ;
			gb.setConstraints(jfd1, gbc);
			gbc.insets=new Insets(5,5,5,5);
			gbc.gridx = 4; gbc.gridy = 1 ;
			gb.setConstraints(jlb1, gbc);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets=new Insets(5,5,5,5);
			gbc.gridx = 4 ; gbc.gridy = 0 ;
			gb.setConstraints(btn1, gbc);
			gbc.insets=new Insets(5,5,5,5);
			gbc.gridx = 4 ; gbc.gridy = 2 ;
			gb.setConstraints(btn2, gbc);
			gbc.insets=new Insets(5,5,5,5);
			gbc.anchor = GridBagConstraints.NORTH;
			gbc.gridx = 4 ; gbc.gridy = 3 ;
			gb.setConstraints(btn3, gbc);
			//物建梯加
			c.add(pan);
			c.add(jlb1);
			c.add(jfd1);
			c.add(btn1);
			c.add(btn2);
			c.add(btn3);
			
			btn1.addActionListener(new java.awt.event.ActionListener()
			{
		         public void actionPerformed(java.awt.event.ActionEvent evt) 
		         {
		               fileread();
		               drawpoint();
		         }
		    });
			btn2.addActionListener(new java.awt.event.ActionListener()
			{
		         public void actionPerformed(java.awt.event.ActionEvent evt) 
		         {

		         }
		    });
	}
	public static void main(String[] args)
	{
		
		kms2 tt = new kms2();
		tt.setSize(650, 650);
		tt.setVisible(true);
		
	}
}
