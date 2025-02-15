import java.util.Scanner;


public class MainClass{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ManagementSystemClass msc = new ManagementSystemClass();

        while(true){
            System.out.println("\n Welcome to the Student Management App. What would you like to do?");
            System.out.println("1. Add new student information");
            System.out.println("2. Delete student information");
            System.out.println("3. Search for student information");
            System.out.println("4. Display  all student information");
            System.out.println("5. Exit application");
            System.out.println("Please select an option: ");

            int option = scanner.nextInt();

            switch(option){
                case 1: 

                System.out.println("Please enter your enroll number: ");
                int enrollNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter your name: ");
                String name = scanner.nextLine();
                System.out.println("Please enter your surname: ");
                String surname = scanner.nextLine();
                System.out.println("Please enter your email");
                String email = scanner.nextLine();
                System.out.println("Please enter your phone number: ");
                String phoneNumber = scanner.nextLine();
                System.out.println("Please enter your grade (A, B, C, D or F): ");
                String grade = scanner.nextLine();
                msc.addStudent(enrollNumber, name, surname, email, phoneNumber, grade);
                break;

                case 2: 

                System.out.println("Enter enroll number to delete student information");
                int deleteEnrollNumber = scanner.nextInt();
                msc.deleteStudent(deleteEnrollNumber);
                break;

                case 3:
                    System.out.println("Please enter enroll number: ");
                    int searchNumber = scanner.nextInt();
                    StudentClass studentClass = msc.findStudent(searchNumber);
                    if (studentClass != null){
                        System.out.println("Student Found: " + studentClass);
                    } else{
                        System.out.println("Student not found.");
                    }
                break;

                case 4:
                    msc.showStudents();
                break;

                case 5:
                    System.out.println("Closing application. Goodbye");
                    scanner.close();
                return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

    }
}