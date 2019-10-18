package enshud.s1.lexer;

public class PascalKeywords {
	
	private static Keyword[] pascalReserved = {
	new Keyword (0,"SAND","and"),
	new Keyword (1,"SARRAY","array"),
	new Keyword (2,"SBEGIN","begin"),
	new Keyword (3,"SBOOLEAN","boolean"),
	new Keyword (4,"SCHAR","char"),
	new Keyword (5,"SDIVD","div"),
	new Keyword (6,"SDO","do"),
	new Keyword (7,"SELSE","else"),
	new Keyword (8,"SEND","end"),
	new Keyword (9,"SFALSE","false"),
	new Keyword (10,"SIF","if"),
	new Keyword (11,"SINTEGER","integer"),
	new Keyword (12,"SMOD","mod"),
	new Keyword (13,"SNOT","not"),
	new Keyword (14,"SOF","of"),
	new Keyword (15,"SOR","or"),
	new Keyword (16,"SPROCEDURE","procedure"),
	new Keyword (17,"SPROGRAM","program"),
	new Keyword (18,"SREADLN","readln"),
	new Keyword (19,"STHEN","then"),
	new Keyword (20,"STRUE","true"),
	new Keyword (21,"SVAR","var"),
	new Keyword (22,"SWHILE","while"),
	new Keyword (23,"SWRITELN","writeln")};
	
	private static Keyword[] pascalOperators = {
	new Keyword (24,"SEQUAL","="),
	new Keyword (25,"SNOTEQUAL","<>"),
	new Keyword (26,"SLESS","<"),
	new Keyword (27,"SLESSEQUAL","<="),
	new Keyword (28,"SGREATEQUAL",">="),
	new Keyword (29,"SGREAT",">"),
	new Keyword (30,"SPLUS","+"),
	new Keyword (31,"SMINUS","-"),
	new Keyword (32,"SSTAR","*"),
	new Keyword (42,"SDOT","."),
	new Keyword (39,"SRANGE",".."),
	new Keyword (38,"SCOLON",":"),
	new Keyword (40,"SASSIGN",":="),
	new Keyword (33,"SLPAREN","("),
	new Keyword (34,"SRPAREN",")"),
	new Keyword (35,"SLBRACKET","["),
	new Keyword (36,"SRBRACKET","]"),
	new Keyword (41,"SCOMMA",","),
	new Keyword (5,"SDIVD","/"),
	new Keyword (37,"SSEMICOLON",";")
	};
	
	
	// check if the character (peek) is a letter
	public static boolean isLetter(char c) {
		if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) return true;
		else return false;
	}
	
	// check if the string is a keyword, if so, return the keyword
	public static Keyword isReserved(String s) {
		Keyword keyword = null;
		for (int i = 0; i < pascalReserved.length; i++) {
			if (s.equals(pascalReserved[i].getLexeme())) {
				keyword = pascalReserved[i];
				break;
			}
		}
		return keyword;
	}
	
	// check if the string is an operator, if so, return the keyword
	public static Keyword isOperator(String s) {
		Keyword keyword = null;
		for (int i = 0; i < pascalOperators.length; i++) {
			if (s.equals(pascalOperators[i].getLexeme())) {
				keyword = pascalOperators[i];
				break;
			}
		}
		return keyword;
	}
	
	// check if the character is a digit
	public static boolean isDigit(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		}
		else {
			return false;
		}
	}
	
	//check if the character is a symbol
	public static boolean isSymbol(char c) {
		char[] symbols = {'+','-','*','>','<','=','.',':','[',']','(',')',',','/',';'};
		for(int i=0; i<symbols.length; i++) {
			if(symbols[i] == c) {
				return true;
			}
		}
		return false;
	}
	
	//check if the symbol is unique as an operator
	public static boolean isUnique(char c){
		int hit = 0;
		for(int i=0; i<pascalOperators.length; i++) {
			if(pascalOperators[i].getLexeme().charAt(0) == c) {
				hit = hit + 1;
				if(hit > 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(final String[] args) {
		char c = '.';
		System.out.print(isUnique(c));
	}
	
}
