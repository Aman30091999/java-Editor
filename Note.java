package note;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.datatransfer.*;
public class Note extends Frame{
	public Note(){
		Image im = Toolkit.getDefaultToolkit().getImage("notepad.png");
  	    setIconImage(im);
  	    //setBackground(Color.BLUE);

		MenuBar mb=new MenuBar();
		Menu m1=new Menu("File");
		Menu m2=new Menu("Edit");
		Menu m3=new Menu("Format");
		Menu m6=new Menu("About");
		Menu m5=new Menu("Themes");
		//Menu m4=new Menu("Open");
		MenuItem aash=new MenuItem("About Creator");
		MenuItem fs=new MenuItem("Text Size");
		MenuItem t1=new MenuItem("Pink Mozarella");
		MenuItem t2=new MenuItem("Oceanic");
		MenuItem t3=new MenuItem("Silver Voilet");
		MenuItem t4=new MenuItem("Jacksie");
		MenuItem mi1=new MenuItem("New");
		MenuItem mi3=new MenuItem("Save");
		MenuItem mi4=new MenuItem("Save As");
		MenuItem mi5=new MenuItem("cut");
		MenuItem mi6=new MenuItem("copy");
		MenuItem mi11=new MenuItem("copy all");
		MenuItem mi7=new MenuItem("Over Paste");
		MenuItem mi12=new MenuItem("Paste");
		//MenuItem mi8=new MenuItem("font");
		//MenuItem mi9=new MenuItem("File 1");
		//MenuItem mi10=new MenuItem("File 2");
		CheckboxMenuItem cmi1=new CheckboxMenuItem("Word Wrap",true);
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m5);
		mb.add(m6);
		m6.add(aash);
		m3.add(fs);
		m1.add(mi1);
		//m1.add(m4);
		m1.add(mi3);
		m1.add(mi4);
		m1.add(mi4);
		m2.add(mi5);
		m2.add(mi6);
		m2.add(mi11);
		m2.add(mi12);
		m2.add(mi7);
		//m3.add(mi8);
		m3.add(cmi1);
		//m4.add(mi9);
		//m4.add(mi10);
		m5.add(t1);
		m5.add(t2);
		m5.add(t3);
		m5.add(t4);
		setMenuBar(mb);
		TextArea ta=new TextArea("What you have to type today?",23,34,TextArea.SCROLLBARS_VERTICAL_ONLY);
		Color clr = new Color(200, 100, 150);

    	//mb.setBackground(clr);
    	//mb.setForeground(Color.YELLOW); 

		
		ta.setFont(new Font("Roboto",Font.PLAIN,14));
		add(ta);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		mi3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String st=ta.getText();
				Save ss=new Save(st);
			}
		});
		mi1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();
				ta.setText("");
			}
		});
		mi4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String fname=JOptionPane.showInputDialog("Enter File Name");
				String st=ta.getText();
				Save sa=new Save(st,fname);   

			}
		});
		mi6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String st=ta.getSelectedText();
				System.out.println(st); //come here
			}	
		});
		mi11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String st=ta.getText();
				System.out.println(st);
			}
		});
		mi7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();
					ta.setText((String)c.getData(DataFlavor.stringFlavor));
					//System.out.println(c.getData(DataFlavor.stringFlavor));
				}
				catch(Exception e){}
			}
		});
		mi12.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();
					ta.append((String)c.getData(DataFlavor.stringFlavor));
					//System.out.println(c.getData(DataFlavor.stringFlavor));
				}
				catch(Exception e){}
			}
		});
		/*mi8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String FontName =(String)JOptionPane.showInputDialog(null, "Select Font Style", "Fonts",
        		JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Futura Md BT",
            	"Futura Bk BT", "Brush Script Std", "Californian FB", "Calisto MT", "Calisto MT", "Calibri",
            	"Clockopia",}, "Clockopia");
            	ta.setFont(new Font((String)FontName,Font.PLAIN,14));
			}

		});*/
		mi5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
			        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        			StringSelection testData;
        			String selt=ta.getSelectedText();
        			if ((selt.length() > 0))
            			testData = new StringSelection(selt);
        			else
            			testData = new StringSelection( "Test Data" );

        			c.setContents(testData, testData);
        			ta.setText(ta.getText().replace(ta.getSelectedText(),""));

	

				}
				catch(Exception e){}
			}
		});
		t1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				Color clr = new Color(200, 100, 150);
    			ta.setBackground(clr);
    			ta.setForeground(Color.YELLOW);
    			ta.setFont(new Font("Harrington",Font.PLAIN,24));
			}
		});
		t2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				Color clr = new Color(200, 200, 250);
    			ta.setBackground(clr);
    			ta.setForeground(Color.BLACK); 
    			ta.setFont(new Font("Arial Unicode MS",Font.PLAIN,24));

			}
		});
		t3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				Color clr = new Color(50, 40, 50);
    			ta.setBackground(clr);
    			ta.setForeground(Color.WHITE); 
    			ta.setFont(new Font("Roboto",Font.PLAIN,14));
			}
		});
		t4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				Color clr = new Color(0,0,0);
    			ta.setBackground(clr);
    			ta.setForeground(Color.WHITE); 
    			ta.setFont(new Font("Roboto",Font.BOLD,20));
			}
		});
		fs.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				
					String size=JOptionPane.showInputDialog(null,"Enter Numeric Values Only!");
					Float fsize=Float.parseFloat(size);
					Font font = ta.getFont();
					float nsize = fsize;
					ta.setFont( font.deriveFont(nsize) );

					//JOptionPane.showMessageDialog(null,"Please Enter Integer value for Text size.","Error",
    				//JOptionPane.ERROR_MESSAGE);

				
			}
		});
		aash.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				JOptionPane.showMessageDialog(null,"Created by:Ashraf Khan \n Email-ID:ashrafksalim1@gmail.com \n Thanks for using it :)");
			}
		});
		/*try {
     		GraphicsEnvironment ge = 
         	GraphicsEnvironment.getLocalGraphicsEnvironment();
     		ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("A.ttf")));
		} 
		catch (IOException|FontFormatException e) {
     		//Handle exception
		}*/
	}
	public static void main(String[] args) {
		Note m=new Note();
		m.setTitle("NotePad");
		m.setSize(300,300);
		m.setResizable(true);
		m.setVisible(true);
		Dimension dim = m.getToolkit().getScreenSize();
    	int screenWidth = dim.width;
     	int screenHeight = dim.height;
     	int frameWidth = screenWidth/3;
     	int frameHeight = screenHeight/3;
		m.setLocation((screenWidth-frameWidth)/2,(screenHeight-frameHeight)/2);
		
	}
}
   
