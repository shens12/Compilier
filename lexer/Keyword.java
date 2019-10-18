package enshud.s1.lexer;

public class Keyword extends Token {
	
	private final String lexeme;

	public Keyword(int tag, String name, String lexeme) {
		super(tag, name);
		this.lexeme = lexeme;
	}
	
	// getter
	public String getLexeme() {
		return this.lexeme;
	}
	
	// printer
	public String toString() {
		return this.getLexeme() + "	" + this.getName() + "	" + this.getTag();
	}
	

	
}
