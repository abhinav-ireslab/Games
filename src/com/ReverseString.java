package com;

public class ReverseString {

	public static void main(String[] arg) {

		String str = "String; 2be reversed...";
		String arr[] = str.split(" ");

		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[i].length() - 1; j >= 0; j--) {

				char riv = arr[i].charAt(j);
				System.out.print(riv);

			}

			System.out.print(" ");
		}

	}

}
