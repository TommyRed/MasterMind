package mastermind.ui.Impl;

import mastermind.ui.UserInput;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Tomáš Rechtig on 15.11.2016.
 */
public class ConsoleInput implements UserInput{

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String listenForString() {
        return scanner.nextLine();
    }

    @Override
    public int listenForInt() {
        try{
            return scanner.nextInt();
        }catch (InputMismatchException err){
            System.out.println("Invalid Input!");
            scanner.next();
        }
        return listenForInt();
    }
}
