package Stack;
import java.util.Stack;

public class SimplyDirectoryPath {
	static public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String arr[] = path.split("/");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(".") || arr[i].equals(""))
                continue;
            else if (arr[i].equals(".."))
           { if(!st.isEmpty())
                st.pop();}
            else
                st.push(arr[i]);

        }

        for(int i=0;i<st.size();i++) {
            sb.append("/");
            sb.append(st.get(i));
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
	
	public static void main(String args[]) {
		
		
		String str="/home/user/Documents/../Pictures";
		System.out.println(simplifyPath(str));
		
	}
}
