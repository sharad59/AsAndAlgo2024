package String;

public class removeCharacterFromString {

	
	public static void main(String args[]) {
		
		char c='i';
		String a= "input string in iterative array";
		removeCharacter(a,c);		
	}

	private static void removeCharacter(String a, char c) {

		char ch[]= a.toCharArray();
		int j=0;
		String t=null;
	for(int i=0;i<ch.length;i++) {
		if(ch[i]!=c) {
			ch[j++]=ch[i];
		}
	}
	while(j<a.length()) {
		ch[j++]=' ';
	}
	t= new String(ch);

	System.out.println(t.trim());

	}
}
