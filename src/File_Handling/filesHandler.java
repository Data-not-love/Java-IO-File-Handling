package File_Handling;
import File_Handling.Basic_Handling.*;
import File_Handling.Encryption.*;
import java.io.IOException;
import java.util.Scanner;


public class filesHandler {
    public static void main (String [] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\u001B[33m" + "Enter 1 to start, Enter any button to quit : " + "\u001B[0m");
        String startProgram = scanner.nextLine();

        while (startProgram.equals("1")){
            System.out.println(
                    "A. Create File\n" +
                    "B. Write Content File\n" +
                    "C. Delete a File\n" +
                    "D. Overwrite Content\n" +
                    "F. Copy text\n" +
                    "G. File Encryption\n" +
                    "H. File Decryption\n" +
                    "L. Exit");

            String filesWorkingOptions = scanner.nextLine(); // Cập nhật giá trị để tránh vòng lặp vô hạn

            switch (filesWorkingOptions) {
                case "A":
                    System.out.println("Enter Number of Files : ");
                    Scanner scanner1 = new Scanner(System.in);
                    int numberOfFiles = scanner1.nextInt();
                        createFile newFiles = new createFile();
                        newFiles.createMultipleFile(numberOfFiles);
                        System.out.println("Done");
                    break;


                case "B":
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Enter Path : ");
                    String path = scanner2.nextLine();
                    System.out.println("Enter Text : ");
                    String content = scanner2.nextLine();
                    writeContent writeContent = new writeContent();
                    writeContent.writeContent(path,content);
                    System.out.println("Done");
                    break;


                case "C":
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Enter Path to delete : ");
                    String inputPath = scanner3.nextLine();
                    deletePath deletePath = new deletePath();
                    deletePath.delete(inputPath);
                    break;

                case  "D":
                    Scanner scanner4 = new Scanner(System.in);
                    System.out.println("Enter Path to overwrite : ");
                    String inputPathForOverwrite= scanner4.nextLine();
                    System.out.println("Enter content to overwrite : ");
                    String inputContentForOverwrite= scanner4.nextLine();
                    overwriteContent overwiteContent = new overwriteContent();
                    overwiteContent.overWrite(inputPathForOverwrite,inputContentForOverwrite);
                    System.out.println("Done Overwriting");
                    break;

                case "F":
                    Scanner scanner5 = new Scanner(System.in);
                    System.out.println("Enter First Path : ");
                    String inputPathForCopying = scanner5.nextLine();
                    System.out.println("Enter Final Path : ");
                    String inputFinalPathForCopying = scanner5.nextLine();
                    copyContent copyContent = new copyContent();
                    copyContent.copyText(inputPathForCopying,inputFinalPathForCopying);
                    System.out.println("Done Copying");
                    break;
                case "G":
                    Scanner scanner6 = new Scanner(System.in);
                    System.out.println("Enter file name to encrypt : ");
                    String inputPathEncrypt = scanner6.nextLine();
                    fileEncryption fileEncryption = new fileEncryption();
                    fileEncryption.checkEncrypted(inputPathEncrypt);
                    break;

                case "H":
                    Scanner scanner7 = new Scanner(System.in);
                    System.out.println("Enter file name to decrypt : ");
                    String inputPathDecrypt = scanner7.nextLine();
                    System.out.println("Enter key to decrypt : ");
                    String decryptKey = scanner7.nextLine();
                    fileDecryption fileDecryption = new fileDecryption();
                    fileDecryption.decryptFile(inputPathDecrypt,decryptKey);

                    //ileDecryption fileDecryption = new fileDecryption(inputPathDecrypt,decryptKey);
                    break;

                case "L":
                    System.out.println("End the program");
                    scanner.close(); // Đóng Scanner trước khi thoát
                    return; // Thoát chương trình
                default:
                    System.out.println("\u001B[31m" + "Invalid Options." + "\u001B[0m");
            }

        }
    }
}

