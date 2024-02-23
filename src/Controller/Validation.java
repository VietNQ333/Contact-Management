package Controller;


import java.util.Scanner;


public class Validation {

    private final  Scanner in = new Scanner(System.in);
    private final String VALID_PHONE ="(\\+?84|0)([35789])([0-9]{8}|([0-9]{2}[-. ()]?){4}[0-9]{2})\\b";


    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (Exception e) {
                System.err.println("Please input number");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputPhone() {
        while (true) {
            String result = checkInputString();
            if (result.matches(VALID_PHONE)) {
                return result;
            }
            System.err.println("Please input Phone (10 number, start by +84 or 0 and next is 3|5|7|8|9)\n"
                    + "example\n"
                    + " 0987654321\n"
                    + " 0987-654-321 \n"
                    + " (0987)-654-321\n"
                    + " 0987.654.321\n");
            System.out.print("Enter again (10 number, start by +84 or 0 and next is 3|5|7|8|9): ");
        }
    }
}

