//Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
//Time O(N), N is the length of String
//Space O(1), Constant time.
package ctci;

public class UniqueCharacters {

	public static void main(String[] args) {
		String s = "ABCDEFGHIJKLMNOPP";
		String temp="";
		boolean flag = true;
		
		for(int i=0;i<s.length()-1;i++) { 
			temp = s.substring(i+1);
			if(temp.contains(s.charAt(i)+"")){
				flag= false;
				break;
			}
		}
		if(flag)
			System.out.println("All characters are unique");
		else
			System.out.println("Not all characters are unique");
		
	}

}
