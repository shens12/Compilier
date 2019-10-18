package enshud.s1.lexer;

public class PascalString extends Token{
	
	private final String pascalStr;

	public PascalString(String pascalStr) {
		super(45, "SSTRING");
		this.pascalStr = pascalStr;
	}
	
	// getter
	public String getLexeme() {
		return this.pascalStr;
	}

	// printer
	public String toString() {
		return this.pascalStr + "\t" + this.getName() + "\t" + this.getTag();
	}

}
