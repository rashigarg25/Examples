package com.practice.problems;

/*		/\
	   /  \
	  / /\ \
	 / /  \ \
	/ / /\ \ \
   / / /  \ \ \

        /\
	   /  \
	  / /\ \
	 / /  \ \
	/ / /\ \ \    */

public class Pattern1 {

	public static void main(String... args) {

		int total = 5;

		for (int i = 1; i <= total; i++) {

			for (int j = total; j >= i; j--) {

				if (i == j) {
					System.out.print("/");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();

		}

	}

}