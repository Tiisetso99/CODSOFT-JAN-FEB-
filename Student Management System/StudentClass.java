
// Student Class that represents individual students
class StudentClass{

private String name;
private String surname;
private int enrollNumber;
private String email;
private String phoneNumber;
private String grade;

// initialize student details
public StudentClass(String name, String surname, int enrollNumber, String email, String phoneNumber, String grade){
    this.name = name;
    this.surname = surname;
    this.enrollNumber = enrollNumber;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.grade = grade;
   
    
}

//Getter methods to retrive student imformation
public String getName(){
    return name;
}

public String getSurname(){
    return surname;
}

public int getEnrollNumber(){
    return enrollNumber;
}

public String getEmail(){
    return email;
}

public String getPhoneNumber(){
    return phoneNumber;
}

public String getGrade(){
    return grade;
}

// Setter methods to update student information
public void setName(String name){
    this.name = name;
}

public void setSurname(String surname){
    this.surname = surname;
}

public void setEnrollNumber(int enrollNumber){
    this.enrollNumber = enrollNumber;  
}

public void setEmail(String email){
    this.email = email;
}

public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
}
public void setGrade(String grade){
    this.grade = grade;
}

// Override toString method for system to return correctly formatted student details
@Override
public String toString(){
    return "Enroll Number:" + enrollNumber + ", Name: " + name + "Surname: " + surname + ", Email: " + email + ", Phone Number: " + phoneNumber + ", Grade:" + grade;
}





}