import java.util.Random;
import java.util.Scanner;

public class DiceRoll {

	public static void main(String[] args) {
		// Initialize

		UserCont();

	}

	public static int[] GetParam() {

		// Initialize
		Scanner scan = new Scanner(System.in);
		int[] vResult = new int[2];

		System.out.println("How many dice?");
		vResult[0] = scan.nextInt();

		System.out.println("How many sides?");
		vResult[1] = scan.nextInt();

		return vResult;
	}

	public static void UserCont() {

		Scanner scan = new Scanner(System.in);
		char vCont = 'y';
		String vUserInput;
		int[] vParam = new int[2];

		do {

			// Call Functional Methods
			Banner();
			vParam = GetParam(); // Get Number and Sides of Dice

			// Roll Dice
			int[] vRollResults = new int[vParam[0]];
			for (int i = vParam[0]; i > 0; i--) {

				vRollResults[i - 1] = Roller(vParam[1]);

			}

			// Show Results
			if (vParam[0] == 2 && vParam[1] == 6) {
				Output(vRollResults, 'C');
			} else {
				Output(vRollResults);
			}

			// Ask if User wants to repeat
			System.out.println("Continue? (y/n): ");
			vUserInput = scan.next();
			vCont = vUserInput.charAt(0);
			if (vCont == 'Y') {
				vCont = 'y';
			}
		} while (vCont == 'y');
		
		scan.close();
	}

	public static int Roller(int param) {
		Random random = new Random();

		// Roll Em

		return (random.nextInt(param) + 1);
	}

	public static void Output(int[] Results) {

		System.out.println("Roll:");

		for (int i = Results.length; i > 0; i--) {
			int vPos = i - 1;
			System.out.println(Results[vPos]);

		}
	}

	public static void Output(int[] Results, char Blah) {

		System.out.println("Roll:");

		for (int i = Results.length; i > 0; i--) {
			int vPos = i - 1;
			System.out.println(Results[vPos]);
		}
		switch (Results[0] + Results[1]) {
		case 2:
			System.out.println("2 Snake Eyes!");
			break;
		case 12:
			System.out.println("12 Boxcars!");
			break;
		case 7:
		case 11:
			System.out.println((Results[0] + Results[1]) + " Craps!");
			break;
			default:
				break;
		}
	}

	public static void Banner() {

		System.out.println("Welcome to the Grand Circus Casino!");
		System.out.println();
		System.out.println();
	}

} // End of Class
