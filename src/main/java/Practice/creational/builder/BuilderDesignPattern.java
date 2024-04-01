package Practice.creational.builder;

public class BuilderDesignPattern {

    public static void main(String[] args) {

        Student student= Student.StudentBuilder.getInstance()
                        .setName("sanjay")
                        .setAddress("mumbai")
                        .setRoll(1)
                        .build();

        System.out.println(student.name+" "+student.address+" "+student.rollno);
    }
}

class Student{
    String name, address;
   int rollno;
    public Student (StudentBuilder studentBuilder){
        this.name= studentBuilder.name;
        this.address=studentBuilder.address;
        this.rollno=studentBuilder.rollno;
    }
   static class StudentBuilder{
        public static StudentBuilder getInstance(){
            return new StudentBuilder();
        }
        String name, address;
        int rollno;
        public  StudentBuilder setName(String name){
            this.name=name;
            return this;
        }
        public  StudentBuilder setAddress(String ad){
            this.address=ad;
            return this;
        }
        public  StudentBuilder setRoll(int  r){
            this.rollno=r;
            return this;
        }
        public  Student build(){
            return new Student(this);
        }
    }
}
