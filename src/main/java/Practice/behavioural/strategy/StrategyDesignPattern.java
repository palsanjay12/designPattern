package Practice.behavioural.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
    public String name;
    public int sal;
    public Employee(String s, int sl){
        name=s;
        sal=sl;
    }
}
public class StrategyDesignPattern {
    public static void main(String[] args) {
        List<Employee> emps= List.of(new Employee("sanjay",4),new Employee("pal",2),new Employee("sanjay",3));
        Strategy sortByName= new SortByName();
        emps= sortByName.sort(emps);
        emps.forEach(emp-> System.out.println(emp.name+" "+ emp.sal));
        Strategy strategySortBySal = new SortBySalary();
        System.out.println("------------------------------------");
        emps= strategySortBySal.sort(emps);
        emps.forEach(emp-> System.out.println(emp.name+" "+ emp.sal));

    }

}
interface Strategy{
    List<Employee> sort(List<Employee> emps);
}
class SortByName implements Strategy{

    @Override
    public  List<Employee> sort(List<Employee> emps) {
       emps= emps.stream().sorted((o1, o2) -> o1.name.compareTo(o2.name)).collect(Collectors.toList());
        return emps;
    }
}
class SortBySalary implements Strategy{

    @Override
    public  List<Employee> sort(List<Employee> emps) {
        emps=emps.stream().sorted((o1, o2) -> Integer.compare(o1.sal, o2.sal)).collect(Collectors.toList());
        return emps;
    }
}

class SortByNameThenSal implements Strategy{

    @Override
    public  List<Employee> sort(List<Employee> emps) {
       emps= emps.stream().sorted((o1, o2) -> {
                    if(o1.name.equals(o2.name)){
                        return Integer.compare(o1.sal,o2.sal);
                    }
                    return o1.name.compareTo(o2.name);
            }
        ).collect(Collectors.toList());
        return emps;
    }
}