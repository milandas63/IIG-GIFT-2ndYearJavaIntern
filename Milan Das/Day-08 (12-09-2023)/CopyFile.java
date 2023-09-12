package com.day08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {
	public InputStream input;
	public OutputStream output;
	
	public CopyFile() {
		int byteData;
		int count = 0;
		int times = 0;
		try {
			File f = new File("JavaGrammer.pdf");
			long size = f.length();
			long fivePc = (long)(size*0.05);
			output = new FileOutputStream("jg.pdf");
			input = new FileInputStream(f);
			while( (byteData=input.read()) != -1 ) {
				output.write(byteData);
				count++;
				if(count>=fivePc) {
					times+=5;
					//System.out.print(". "+times+"%");
					System.out.print(".");
					count = 0;
				}
			}
			output.close();
			input.close();
		} catch(FileNotFoundException e) {
		} catch(IOException e) {
			
		}
		
	}

	public static void main(String[] args) {
		new CopyFile();
	}

}
