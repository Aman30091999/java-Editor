package note;
import java.io.*;
class Save{
	Save(String st){
		char ch[]=st.toCharArray();
		int i;
		try{
	     	FileOutputStream fout=new FileOutputStream("newfile.txt");
	     	for(i=0;i<st.length();i++){
	     		fout.write(ch[i]);
	     	}
	     	fout.close();

    	} 
    	catch (IOException e) {
    		System.out.println("Exception Occurred:");
		}
   }
   Save(String st,String fn){
   		char ch[]=st.toCharArray();
		int i;
		try{
	     	FileOutputStream fout=new FileOutputStream(fn+".txt");
	     	for(i=0;i<st.length();i++){
	     		fout.write(ch[i]);
	     	}
	     	fout.close();

    	} 
    	catch (IOException e) {
    		System.out.println("Exception Occurred:");
		}

   }
   /*public static void main(String[] args) {
   		Save s=new Save("Just Checking");
   		System.out.println("haha");
   		Save ss=new Save("Kidding","file2");
   /}*/
}
				
		