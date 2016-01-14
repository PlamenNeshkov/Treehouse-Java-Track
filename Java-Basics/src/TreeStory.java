import java.util.Scanner;

public class TreeStory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age:");
        String ageAsString = sc.nextLine();
        int age = Integer.parseInt(ageAsString);

        if (age < 13) {
            System.out.println("Sorry, you must be at least 13 to use this program.");
            System.exit(0);
        }

        System.out.println("Enter a name: ");
        String name = sc.nextLine();

        System.out.println("Enter an adjective: ");
        String adjective = sc.nextLine();

        String noun;
        boolean isInvalid;
        do {
            System.out.println("Enter a noun:  ");
            noun = sc.nextLine();

            isInvalid = noun.equalsIgnoreCase("dork") ||
                        noun.equalsIgnoreCase("jerk");
            if (isInvalid) {
                System.out.println("That language is not allowed. Try again.");

            }
        } while (isInvalid);

        System.out.println("Enter an adverb:  ");
        String adverb = sc.nextLine();

        System.out.println("Enter a verb ending with -ing:  ");
        String verb = sc.nextLine();

        System.out.println("Your TreeStory:");
        System.out.printf("%s is a %s %s. ", name, adjective, noun);
        System.out.printf("They are always %s %s", adverb, verb);
        System.out.println();
    }
}