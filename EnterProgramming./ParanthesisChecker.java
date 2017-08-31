import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static Stack<Character> s ;
	static int t;
	static String res ;
	static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) {
		//code
	
		t = sc.nextInt();
		while(t-- > 0){
		    s = new Stack<>();
		    res = "balanced";
		    int i;
		    String str = sc.next();
		    for(i=0 ; i<str.length() ; i++){
		        char c = str.charAt(i);
		        //ADD OR POP FROM STACK WHILE READING THE VALUES.
		   //      System.out.println ( i);
		        if(c=='(' || c == '{' || c == '['){
		           
		            s.push(c);
		        }
		        else{
		       //     System.out.println("end");
		       
		            if(c==')'){
		                if(s.isEmpty() || s.peek()!='(')
		                    {
		                        res = "not balanced";
		                        break;
		                    }
		                    else
		                        s.pop();
		                        
		                    }
		            if(c=='}'){
		                if(s.isEmpty() || s.peek()!='{')
		                    {
		                        res = "not balanced";
		                        break;
		                    }
		                    else
		                        s.pop();
		                        
		            }
		            if(c==']'){
		                if(s.isEmpty() || s.peek()!='[')
		                    { //  System.out.println("heh");
		                        res = "not balanced";
		                        break;
		                    }
		                    else
		                       s.pop();
		                        
		            }
		            
		               
		        }
		    }
		   
		    if(!s.isEmpty())
		        res = "not balanced";
		    System.out.println(res);
		  

		}
		
		
	}
}
