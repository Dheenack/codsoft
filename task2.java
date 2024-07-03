/*
 * Student Grade calculator
 * input: number of subject marks(each out of 100) as an integer
 * output: total marks, average percentage and grade as an integers
 */
package task2;
//required packages and classes
import java.util.Scanner;
import java.util.Arrays;
//Main class
public class task2 {
    public static void main(String...args){
        //* Required variables and objects
        int tot_subjects,total_marks;
        float average_percentage;
        int [] subject_marks;
        Scanner scan = new Scanner(System.in);
        String grade;
        //getting total number of subjects
        System.out.println("Enter the total number of subjects:");
        tot_subjects=scan.nextInt();
        subject_marks= new int[tot_subjects];
        //Getting marks of subjects
        for(int i=0;i<tot_subjects;i++){
            System.out.println("Enter mark for subject"+(i+1)+" :");
            subject_marks[i]=scan.nextInt();}
        total_marks=Arrays.stream(subject_marks).sum();
        average_percentage=(float)(total_marks/(float)(tot_subjects*100))*100;
        //?Assigning grades to the user percentage
        grade=(average_percentage>=90)?"O":
        (average_percentage<90 && average_percentage>=80)?"A+":
        (average_percentage<80 && average_percentage>=70)?"A":
        (average_percentage<70 && average_percentage>=60)?"B+":
        (average_percentage<60 && average_percentage>=50)?"B":
        (average_percentage<50 && average_percentage>=45)?"C":"U";
        System.out.println("***************************************************************************************************");
        System.out.println("Results:");
        System.out.println("***************************************************************************************************");
        System.out.println("Total marks obtained: "+total_marks);
        System.out.println("Average percentage: "+average_percentage);
        System.out.println("Grade: "+grade);
        //End of main method
        scan.close();
    }
}