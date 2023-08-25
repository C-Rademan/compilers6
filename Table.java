// Skeleton to handle cross reference table for RE productions
// P.D. Terry, Rhodes University; modified 2023  (Java 1.5)

package RE;

import java.util.*;
import library.*;

  class Entry {                      	// Cross reference table entries
    public char name;              		// The identifier itself
    public ArrayList<Integer> refs;  	// Regex numbers where it appears
    public Entry(char name) {
      this.name = name;
      this.refs = new ArrayList<Integer>();
    }
  } // Entry

  class Table {
	  
	static ArrayList<Entry>list = new ArrayList<Entry>(); //initialise a table of entries (should it be global?)
	
    public static void clearTable() {
    // Clears cross-reference table
		list = new ArrayList<Entry>();
    } // clearTable
	
    public static void addRef(char name, int regnum) {
    // Enters name if not already there, adds another regex reference 
	   int i=0;
	   while ((i<list.size()) && (name != (list.get(i).name))){
		   i++;
	   }
	   if(i>=list.size()){ //if name is not in list, add a new terminal symbol name
		   list.add(new Entry(name));
	   }
	   list.get(i).refs.add(regnum); //add regnum to the reference list of the terminal symbol
	   
    } // addRef

    public static String printTable() {
    // Prints out all references in the table (eliminate duplicate regex numbers)
        String str ="Terminal    Regular Expressions \n";
		String regexNos="";
		String regexNo="";
		int i=0;
		int j=0;
		while (i<list.size()){
			str+=" ";
			str+=(list.get(i).name);
			str+="\t \t";
			while(j<list.get(i).refs.size()){
				regexNo+=(list.get(i).refs.get(j));
				if (! regexNos.contains(regexNo)){
					regexNos+="\t";
					regexNos+=regexNo;
				}
				regexNo="";
				j++;
			}
			str+=regexNos;
			regexNos="";
			str+="\n";
			j=0;
			i++;
		}
		return str;
    } // printTable


    public static String printAlphabet(int regnum) {
    // Prints out all terminals in table for particular regex number
		int i=0;
		int j=0;
		String alphabet ="Alphabet ";
		alphabet+=regnum;
		alphabet+=" =";
		while (i<list.size()){
			j=0;
			while(j<list.get(i).refs.size()){
				if ((list.get(i).refs.get(j))==regnum){
					alphabet=alphabet+" "+list.get(i).name;
				}
				j++;
			}
			i++;
		}
		return alphabet;
		
    } // printAlphabet

  } // Table
  
