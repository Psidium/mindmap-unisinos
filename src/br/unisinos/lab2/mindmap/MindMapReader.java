package br.unisinos.lab2.mindmap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MindMapReader<E> {
	
	public MindMap<E> read() throws IOException {
            String strXml = readFileToReturnString();
            System.out.println(strXml);
	//	return new MindMap<MindMapReader.E>(new E());
        return null;
	}
        
        public String readFileToReturnString() throws FileNotFoundException, IOException  {
            File xmlFile = new File("fileMindMapXml.xml");
            FileReader readXml = new FileReader(xmlFile);
            BufferedReader bufferReader = new BufferedReader(readXml);
            String line = bufferReader.readLine();
            String convertXml = "";
            while(line != null ){
                convertXml += line + "\n";
                line = bufferReader.readLine();
            }
            bufferReader.close();           
            
            return convertXml;
        }

}
