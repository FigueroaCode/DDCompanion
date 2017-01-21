import java.util.Scanner;

public class testCharacter {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name of your character");
		String name = input.next();
		System.out.println("Nice, now enter the race");
		String race = input.next();
		Character guy = new Character(name, race);
		guy.standardSet(input);
		System.out.println("Okay, " + guy.getName() + ", now you must choose your class");
		System.out.println("Choose one of the following classes: ");
		System.out.println("Cleric(Wisdom), Fighter(Strength or Dex.), Rogue(Dex.), "
				+ "Wizard(Intelli)");
		String profession = input.next();
		guy.setProfession(profession);
		guy.addHPAndWealth();
		System.out.println("Okay let's recap, is this information correct?");
		//Prints information on created object
		System.out.println("Output information into file?(1=Yes)");
		int choice = input.nextInt();
		if(choice == 1){
			guy.toWrite();
		}
		else
			System.out.println("Alright");
	}
}
