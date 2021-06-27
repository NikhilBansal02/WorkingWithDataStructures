//Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
package ctci;

public class CheckPermutation {
	public static void main(String[] args) {
		String s1 = "nikhil";
		String s2 = "xyz";
		if(checkPermutation(s1,s2))
			System.out.println("Are Permutations");
		else
			System.out.println("Not Permutations");
		
	}
	public static boolean checkPermutation(String a, String b){
		if(a.length() != b.length())
			return false;
		
		char[] ch = a.toCharArray();
		for(char c :ch){
			if(!b.contains(c+"")){
				return false;
			}
		}
		return true;
	}

}
