/**
 * This program implements a simple note-taking application that allows the user to create and read notes.
 * It provides two options for the user to choose from: create a new note or read an existing note.
 * If the user chooses to create a note, they will be prompted to enter a note name and its content.
 * If the user chooses to read a note, they will be prompted to enter the note name.
 * @author [AUTHOR NAME]
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class NotePad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to NotePad!");
        System.out.println("Enter '1' to create a new note");
        System.out.println("Enter '2' to read a note");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                createNote();
                break;
            case 2:
                readNote();
                break;
            default:
                System.out.println("Invalid choice");
        }
        scanner.close();
    }

    private static void createNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the note: ");
        String fileName = scanner.nextLine() + ".txt";

        System.out.println("Enter the content of the note: ");
        String content = scanner.nextLine();

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("Note created successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the note");
            e.printStackTrace();
        }
        scanner.close();
    }

    private static void readNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the note to read: ");
        String fileName = scanner.nextLine() + ".txt";

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the note");
            e.printStackTrace();
        }
        scanner.close();
    }
}
