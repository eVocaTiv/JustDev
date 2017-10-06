/*
 * AUTHOR : KUNAL DEWAN
 * 			2015A7PS0011G	
 */





//SAMPLE INPUT FOR TESTING.

/*


tuple<main1,variable,bool>
tuple<main2,variable,bool>
{
tuple<br1a,variable,int>
tuple<br1b,variable,float>
{
tuple<br1.1a,function,void>
fptuple<brfxn1.1a,variable,double>
tuple<br1.1b,parameter,bool>
tuple<br1.1c,function,bool>
fptuple<brfxn1.1c,function,void>
}
tuple<br1c,function,void>
}
tuple<main3,variable,double>
{
tuple<br2a,function,void>
return 0;


 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

	static int param_no = 1;

	

	public static void printAll(SymbolTable focustable) {
		System.out.println(focustable.toString() + "........Printing entries : ");
		//System.out.println("no . of entries are " + focusTable.Entries.size());
		for(Tuple t : focustable.Entries) {
			System.out.println(t.id + " " + t.kind + " " + t.type);
		}
		System.out.println();
		for(SymbolTable st : focustable.ChildTables)
			printAll(st);
	}


	public static int getScopeCount(SymbolTable ft) {
		int res=1;
		if(ft.ChildTables.size()==0)
			return 1;
		else {
			for(int i=0 ; i<ft.ChildTables.size() ; i++) {
				res+=getScopeCount(ft.ChildTables.get(i));
			}
			return res;
		}



	}
	//ROOT OF TREE.
	static SymbolTable rootTable=new SymbolTable();

	//CURRENT SCOPE_NODE.
	static SymbolTable focusTable = rootTable;



	//ASSUMPTIONS.
	//1.NO BLANK LINES IN THE CODE.
	//2.FIRST BLANK LINE INDICATES END OF CODE!
	//3.ENTRY OF A NEW SCOPE IS ALWAYS DENOTED BY A '{'
	//4.EXIT OF CURRENT SCOPE IS ALWAYS DENOTED BY A '}'
	//5.IN ANY LINE , EITHER A NEW SCOPE by '{' or '}'
	//  OR A NEW TUPLE IS DEFINED IN THE FORMAT tuple<name , kind , type>
	//6.WHEN FUNCTION IS DETECTED , THE PARAMETERS ARE ENTERED INTO THE NEWLY CREATED SCOPE 
	//AND THEN CONTROL RETURN BACKS TO THE ORIGINAL SCOPE. ( I.E NO BRANCHING)
	//7.A function can have either 0 parameters or 1.
	//IF 1 parameter => THEN PARAMETER INPUT IS GIVEN AS fptuple< , , > in the next line
	//which is stored local to the function body
	//but branching doesn't happen.
	

	
	
	public static void main(String [] args) throws IOException {
		focusTable.ParentTable=rootTable;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		while(true) {

			str = br.readLine();
			//	System.out.println(str);

			//BREAK CONDITIONS.
			if(str.equals(null) || str.equals("") || str.contains("return 0;"))
				break;
			char[] arr = str.toCharArray();
			for(int i=0 ; i<arr.length; i++){

				if(arr[i]=='{') {
					Enter_Scope();
					break;
				}
				if(arr[i]=='}') {
					Exit_Scope();
					break;
				}


				//NAME CAN BE ANY IDENTIFIER NAME.
				//TYPE CAN BE VARIABLE , PARAMETER OR FUNCTION.
				//KIND CAN BE INT , VOID , BOOL , DOUBLE.




				//PARSE THE TUPLE AND ADD IT TO THE CURRENT SCOPE TABLE.
				//CALL THE DEFINED METHODS.


				//IF FUNCTION parameters followed by a function.
				//then input format is
				//fptuple<name , type , kind>
				else if(arr[0]=='f' && arr[1]=='p'){
				//	System.out.println("yess");

					//	int i=1;

					Enter_Scope();
					i=2;

					String tname , tkind , ttype;
					i=i+6;

					//System.out.println(arr);
					//EXTRACT NAME.
					StringBuilder sb = new StringBuilder();
					while(arr[i]!=',') {

						sb.append(arr[i]);
						i++;
					}
					//	System.out.println("comma1");


					tname = sb.toString();

					StringBuilder sb2 = new StringBuilder("");
					while(arr[i]!=',') {

						sb2.append(arr[i]);
					}
					//	System.out.println("comma2");


					tkind = sb2.toString();

					StringBuilder sb3 = new StringBuilder("");
					while(arr[i]!='>') {
						sb3.append(arr[i]);
						i++;
					}

					//System.out.println(" > detected");

					ttype = sb3.toString();


					InsertInTree(tname, ttype, tkind);

					Exit_Scope();
					//		System.out.println("Entry added!");

				}

				else {
					//add tuple
					//points to '<'
					String tname , tkind , ttype;
					i=i+6;

					//EXTRACT NAME.
					StringBuilder sb = new StringBuilder();
					while(arr[i]!=',') {

						sb.append(arr[i]);
						i++;
					}
					//	System.out.println("comma1");


					tname = sb.toString();

					StringBuilder sb2 = new StringBuilder("");
					while(arr[i]!=',') {

						sb2.append(arr[i]);
					}
					//	System.out.println("comma2");


					tkind = sb2.toString();

					StringBuilder sb3 = new StringBuilder("");
					while(arr[i]!='>') {
						sb3.append(arr[i]);
						i++;
					}

					//System.out.println(" > detected");

					ttype = sb3.toString();


					InsertInTree(tname, ttype, tkind);

					//		System.out.println("Entry added!");

				}

			}

		}


		//SAMPLE INPUT FOR TESTING.

		/*


tuple<flag1,variable,bool>
tuple<flag2,variable,bool>
{
tuple<x,variable,int>
tuple<y,variable,float>
{
tuple<foo2,function,void>
tuple<z,parameter,bool>
}
tuple<foo1,function,void>
}
tuple<j,variable,double>
{
tuple<sum,function,void>
return 0;

		 */

		//SOME SAMPLE TESTING FOR THE ABOVE GIVEN INPUT.
		//GIVES CORRECT COUNT OF TOTAL SCOPES ( INCLUDING MAIN (ROOT OF TREE) SCOPE ).




		//TOTAL SCOPES CREATED INCLUDING MAIN.
		//WILL BE 4.
		System.out.println("Total no. of scopes generated during entire program are " + getScopeCount(rootTable));
		System.out.println();
		System.out.println();

		printAll(rootTable);

		//PRINT EVERYTHING PRESENT IN CURRENT SCOPE.
		//I.E MAIN SCOPE's CHILD 1.
		// ANS SHOULD BE SUM. 
		//for(Tuple t : focusTable.Entries) {
		//	System.out.println(t.id);
		//	}

		//		System.out.println(focusTable.Lookup("flag1"));

		//TOTAL VARIABLES + FUNCTIONS + PARAMTERS IN MAIN SCOPE.
		//CONTAINS flag1 , flag2 and j
		//WILL BE 3
		//System.out.println(rootTable.Entries.size());

		//EVERYTHING IN CHILD 0 OF MAIN- x , y and foo1
		// WILL BE 3 
		//System.out.println(rootTable.ChildTables.get(0).Entries.size());





		//EVERYTHING IN CHILD 1 OF MAIN - sum
		// WILL BE 1 
		//System.out.println(rootTable.ChildTables.get(1).Entries.size());


		//NOW CURRENT SCOPE IS CHILD 1 OF MAIN.
		//WHICH HAS ONLY 1 function - sum
		//SEARCHING FOR 'flag1' will result true since it is present in the parent Symbol Table.

		//System.out.println(LookupInTree("flag1", focusTable));

		//BUT SEARCHING FOR 'x' will result in false
		//System.out.println(LookupInTree("x", focusTable));

		//SEARCHING FOR sum will return true since it's present in the current symbol table node.

		//System.out.println(LookupInTree("sum", focusTable));



		//TESTING
		/*
		InsertInTree("x", "int", "par");
		InsertInTree("m", "int", "par");
		InsertInTree("u", "int", "par");
		InsertInTree("i", "int", "par");
		Enter_Scope();
		InsertInTree("a", "int", "par");
		InsertInTree("b", "int", "par");	
		Exit_Scope();
		Enter_Scope();
		InsertInTree("g", "int", "par");
		InsertInTree("h", "int", "par");
		 */

		//for(Tuple t : focusTable.ParentTable.ParentTable.Entries)
		//	System.out.println(t.id);
		//System.out.println(focusTable.ParentTable.ParentTable.Entries.size());

		//System.out.println(getScopeCount(rootTable));
		//System.out.println(rootTable.ChildTables.size());
		//printAll(rootTable);
		//System.out.println(getScopeCount(rootTable));
		//System.out.println(LookupInTree("a" , focusTable));
		//System.out.println();
		System.out.println("Ended");




	}
	//HOLDS VALUES.
	public static class Tuple{
		String id , type , kind;

		public Tuple(String id , String type , String kind) {
			this.id = id;
			this .type = type;
			this.kind = kind;
		}

	}


	public static void InsertInTree(String name , String type , String kind) {
		focusTable.Insert(name, type, kind);
	}

	public static boolean LookupInTree(String name , SymbolTable ft) {
		if(ft == null) {
			System.out.println("Table null for search...");
			return false;
		}

		if(ft.Lookup(name)==false) {
			//System.out.println(focusTable.ParentTable.ParentTable.Entries.size());
			//System.out.println("try again");
			if(!ft.equals(rootTable))
				return LookupInTree(name, ft.ParentTable);
		}

		if(ft.equals(rootTable) && ft.Lookup(name)==false)
			return false;
		return true;


	}

	public static void Enter_Scope() {
		//CREATE NEW NODE.
		SymbolTable t = new SymbolTable();

		//SET PARENT AS CURRENT NODE.
		t.ParentTable= focusTable;

		//ADD THIS NEW NODE TO CHILD OF CURRENT NODE.
		focusTable.ChildTables.add(t);

		//SHIFT DOWN.
		focusTable = t;

	}

	public static void Exit_Scope() {
		/*
		  if(focusTable.ParentTable!=null) {

			//System.out.println();

			focusTable.Node_Exit_Scope();
			SymbolTable toBeDeletedTable = focusTable;
			focusTable = focusTable.ParentTable;
			focusTable.ChildTables.remove(toBeDeletedTable);
		}
		else {
			focusTable = rootTable;
		}

		 */

		focusTable = focusTable.ParentTable;

	}




	//IMPLEMENTATION OF A SYMBOL TABLE NODE!!!--------------------
	//HOLDS TUPLES.
	public static class SymbolTable{
		HashSet<Tuple> Entries;

		ArrayList<SymbolTable> ChildTables;
		SymbolTable ParentTable;

		//CREATES A NEW SYMBOL TABLE
		//CALLED BY ENTER_SCOPE OF MAIN CLASS.
		public SymbolTable() {
			ChildTables = new ArrayList<>();
			ParentTable = null;
			Entries = new HashSet<Tuple>();
		}

		//INSERT A NEW ENTRY IN CURRENT SYMBOL TABLE.
		public void Insert(String name , String type , String kind) {
			for(Tuple t : Entries) {
				if(t.id.equals(name) && t.type.equals(type))  {
					System.err.println("Variable already exists in Scope!!!");
					return;
				}
			}
			Entries.add(new Tuple(name , type , kind));
		}


		//LOOKUP AN ENTRY IN THE CURRENT SYMBOL TABLE.
		public boolean Lookup(String name) {
			for(Tuple t : Entries) {
				if(t.id.equals(name))
					return true;
			}
			return false;
		}

		//EXIT FROM CURRENT SCOPE.
		public void Node_Exit_Scope() {

			//DESTROY THIS TABLENODE.

		}





	}

	//IMPLEMENTATION OF A SYMBOL TABLE NODE!!!--------------------

}


/*
 * AUTHOR : KUNAL DEWAN
 * 			2015A7PS0011G	
 */
