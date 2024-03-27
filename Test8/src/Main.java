public class Main {
	public static void main(String[] args) {
		Ex1();
		Ex2();
		Ex3();
		Ex4();
		Ex6();
	}
	//---------------------------------------------------------------------------------
	public static void Ex1(){
		String text = "I want it, I got it";
		String res = removeMostCommonWord(text);
		System.out.println(res);
	}
	public static String removeMostCommonWord(String text){
		String[] temp = text.split(" ");
		String res = "";
		int currentIndex;
		int maxIndex = 0;
		int index = 0 ;
		for (int startIndex = 0; startIndex < temp.length -1 ; startIndex++) {
			currentIndex = 1;
			String check = temp[startIndex];
			for (int j = 0; j < temp.length ; j++) {
				if (check.equalsIgnoreCase(temp[j])){
					currentIndex++;
				}else {
					break;
				}
			}
			if (currentIndex > maxIndex){
				maxIndex = currentIndex;
				index = startIndex;
			}
		}
		String remove = temp[index];
		for (int i = 0; i < temp.length ; i++) {
			if (!remove.equalsIgnoreCase(temp[i])){
				res+= temp[i]+" ";
			}
		}
		return res;
	}
	//---------------------------------------------------------------------------------
	public static void Ex2(){
		int number = 18;
		int[] res = getAllUniqueFactors(number);
		for (int index: res){
			System.out.print(index+",");
		}
	}
	public static int[] getAllUniqueFactors(int number){
		int[] arr;
		if (number < 0 ){
			number = number*(-1);
		}else if (number == 0){
			return null;
		}else {
			number = number;
		}
		int countDiv = 0;
		for (int i = 1; i <= number; i++) {
			if (number % i == 0){
				countDiv++;
			}
		}
		arr= new int[countDiv];
		int index = 0;
		for (int i = 1; i <= number; i++) {
			if (number % i ==0){
				arr[index] = i;
				index++;
			}
		}
		return arr;
	}
	//---------------------------------------------------------------------------------
	public static void Ex3(){
		int[] arr = {10,20,10,30,40,10};
		int[] res = getLongestAscendingSequence(arr);
		for (int index: res){
			System.out.print(index+",");
		}
	}
	public static int[] getLongestAscendingSequence(int[] arr){
		int maxIndex = 0;
		int currentIndex;
		int maxStart = 0;
		for (int startIndex = 0; startIndex < arr.length-1; startIndex++) {
			currentIndex = 1;
			for (int j = startIndex ; j < arr.length-1; j++) {
				if (arr[j] < arr[j+1]){
					currentIndex++;
				}else {
					break;
				}
			}
			if (currentIndex > maxIndex){
				maxIndex = currentIndex;
				maxStart = startIndex;
			}
		}
		int[] newArr = new int[maxIndex];
		int index = 0;
		for (int i = maxStart ; i < maxStart+maxIndex  ; i++) {
			newArr[index] = arr[i];
			index++;
		}
		return newArr;
	}
	//---------------------------------------------------------------------------------
	public static void Ex4(){
		int[] arr = {1,2,3,4,5};
		reversArray(arr);
	}
	public static void reversArray(int[] arr){
		String temp = "";
		for (int i = arr.length-1 ; i >= 0 ; i--) {
			 temp += String.valueOf(arr[i]);
		}
		for (int j = 0; j <= arr.length -1; j++) {
			int temp1 = Integer.parseInt(temp.charAt(j) +"");
			arr[j] = temp1;
			}

		for (int number : arr){
			System.out.print(number+",");
		}
	}
	//---------------------------------------------------------------------------------
	public static void Ex6(){
		int number = 13;
		boolean res = isFeb(number);
		System.out.println(res);

		int A = 3;
		int B = 8;
		int number2 = 19;
		boolean res2 = isInFibonacciSequence(A,B,number2);
		System.out.println(res2);
	}
	public static boolean isFeb(int number) {
		int result = 1;
		int fibonacci = 1;
		for (int i = 1; i <= number; i += fibonacci) {
			result = i;
			if (i == number) {
				break;
			}
			fibonacci += i;
		}
		if (result == number || fibonacci == number || number == 0) {
			return true;
		}
		return false;
	}
	public static boolean isInFibonacciSequence(int A, int B, int NUMBER) {
		int prev1 = A;
		int prev2 = B;

		if (NUMBER == prev1 || NUMBER == prev2) {
			return true;
		}

		int current = prev1 + prev2;
		while (current <= NUMBER) {
			if (current == NUMBER) {
				return true;
			}
			prev1 = prev2;
			prev2 = current;
			current = prev1 + prev2;
		}

		return false;
	}

}