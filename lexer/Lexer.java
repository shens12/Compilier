package enshud.s1.lexer;
 
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
 
public class Lexer {
	
	public static void main(final String[] args) throws IOException {
		/*
		String line = System.lineSeparator();
		if ("\r\n".equals(line)) {
			System.out.println("windows - This program is not working for windows");
			} else if ("\n".equals(line)) {
			System.out.println("Mac - OK");
			}else if ("\r".equals(line)){
			System.out.println("linux/unix - OK");
			}
		*/
		Lexer test = new Lexer();
		test.run("normal20.pas","out.ts");
	}
	
	public void run(final String inputFileName, final String outputFileName){
 
		try {
		// preprocess of input file
		char[] processedFile = loader(inputFileName);
		
		// Open the file ready for writing
		File outFile = new File(outputFileName);
		FileWriter fw = new FileWriter(outFile);
		PrintWriter writer = new PrintWriter(fw);
	
		int line = 1;
		int index = 0;
		String temp = "";
		
		while(index < processedFile.length) {
			char current = processedFile[index];
			if(current == ' ' || current == '\t') {
				//continue
			}
			else if(current == '\n') { //Compatibility?
				line = line + 1;
			}
			else if(current == '\0') { //end of array
				break;
			}
			else if(current == '{') {
				index = index + 1;
				char comment;
				while((comment = processedFile[index]) != '}') {
					//comment can be multi-line
					if(comment == '\n') {
						line = line + 1;
					}
					index = index + 1;
				}
			}
			else if(current == '\''){
				index = index + 1;
				temp = "\'";
				char charInStr; 
				while((charInStr = processedFile[index]) != '\'') {
					temp += charInStr;
					index = index + 1;
				}
				temp += '\'';
				//Record the string as a token
				PascalString str = new PascalString(temp);
				//print out to the file
				writer.print(str.toString() + "\t" + Integer.toString(line) + '\n');
			}
			else if(PascalKeywords.isLetter(current)) {
				//Begins with a letter
				temp = "";
				temp += current;
				//scan until next character is not letter or digit
				char next = (char) processedFile[++index];
				while(PascalKeywords.isLetter(next) || PascalKeywords.isDigit(next)) {
					temp += next;
					next = (char) processedFile[++index];
				}
				index = index - 1;
				//check if temp is a reserved word
				Keyword reservedWord = PascalKeywords.isReserved(temp);
				if(reservedWord != null) {
					writer.print(reservedWord.toString() + "\t" + Integer.toString(line) + '\n');
				}
				else{//Otherwise temp is an identifier
				Identifier identifier = new Identifier(temp);
				writer.print(identifier.toString() + "\t" + Integer.toString(line) + '\n');
				}
			}
			else if(PascalKeywords.isDigit(current)) {
				//Begin with a digit
				temp = "";
				temp += current;
				//Scan until there is no digit following
				char next = (char) processedFile[++index];
				while(PascalKeywords.isDigit(next)) {
					temp += next;
					next = (char) processedFile[++index];
				}
				index = index - 1;
				//output the number
				Constant num = new Constant(Integer.parseInt(temp));
				writer.print(num.toString() + "\t" + Integer.toString(line) + '\n');
				
			}
			else { //begin with a symbol
				//check if it is unique, if so, print to the output file
				if(PascalKeywords.isUnique(current)) {
					writer.print(PascalKeywords.isOperator(String.valueOf(current)).toString() + "\t" + Integer.toString(line) + '\n');
				}
				else {
					temp = "";
					temp += current;
					//scan until next char is not a symbol
					char next = (char) processedFile[++index];
					if(PascalKeywords.isSymbol(next)){
						temp += next;
					}else {
						index = index - 1;
					}
					//check if temp is an operator
					if(PascalKeywords.isOperator(temp) != null) {
						writer.print(PascalKeywords.isOperator(temp).toString() + "\t" + Integer.toString(line) + '\n');
					}
					else {
						writer.println("Illegal symbols detected");
					
					}
				}
			}
			index = index + 1;
			}
		writer.close();
		System.out.print("OK");
		}catch(Exception e) {
			System.err.print("File not found");
		}
	}
	
	private char[] loader(String inputFileName) throws IOException {
		//open the file and create an input stream with error handling
		BufferedReader reader = new BufferedReader(new FileReader(new File(inputFileName)));
		//read characters
		int c = 0;
		int index = 0;
		//What if the document is too large
		char [] processedFile = new char[60000];
		while(((c = reader.read()) != -1)) {
			char character = (char) c;
			processedFile[index++] = character;
		}
		processedFile[index] = '\0';
		reader.close();
		return processedFile;
	}
	
}