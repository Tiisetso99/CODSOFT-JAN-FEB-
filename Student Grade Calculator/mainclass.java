import java.util.Scanner;

public class mainclass {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // prompting user to enter number of subjects 

        System.out.println("Please enter number of subjects:" );
        int numOfSubjects = scanner.nextInt();

        int [] subjectMarks = new int [numOfSubjects];
        int totalSubjectMarks =0;

        //creating a for loop for user input 

        for (int i = 0; i < numOfSubjects; i++) {

            System.out.println("Please enter subject mark out of 100: ");
            subjectMarks[i]=scanner.nextInt();

            //validating marks input

            while(subjectMarks[i] < 0 || subjectMarks[i] > 100 ){
                System.out.println("Invalid mark captured. Please try again.");
                System.out.print("Please enter mark out of 100 " +(i+1)+":");
                subjectMarks[i]=scanner.nextInt();
            }

            totalSubjectMarks += subjectMarks[i];
            
        }
        
        // calculating average of marks collected

        double marksAverage = totalSubjectMarks / (double) numOfSubjects;
        char finalMark;

        if (marksAverage >= 90) { 
            finalMark = 'A';  
        }
        else if (marksAverage >= 80){
                finalMark = 'B';
            }
            else if (marksAverage >= 60){
                finalMark = 'C';
            }
            else if(marksAverage >=50 ){
                finalMark = 'D';
            }else {
                finalMark = 'F';
            }

            //display final student average
        System.out.println("\n---- Student Results ----");
        System.out.println("Total of Marks Captured: "+totalSubjectMarks);
        System.out.println("Average grade percentage for student is: "+String.format("%.2f", marksAverage) + "%");
        System.out.println("Your grade mark is: "+ finalMark);

    }
}