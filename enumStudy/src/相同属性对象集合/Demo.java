package 相同属性对象集合;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add((new Student("张山","16",82)));
        list.add((new Student("张山","16",85)));
        list.add((new Student("张山","16",81)));
        list.add((new Student("张山","16",81)));
        list.add((new Student("李四","16",81)));
        List<Student> studentList = new ArrayList<>();
        Map<String, List<Student>> collect = list.parallelStream().collect(Collectors.groupingBy(o -> (o.getName() + "/" + o.getAge()), Collectors.toList()));
//                .forEach((id,transfer) -> {
//                    transfer.stream().reduce((a,b) -> new Student(a.getName(),a.getAge(),a.getScore() + b.getScore()))
//                            .ifPresent(studentList::add);
//                });
//        System.out.println(studentList);

        for (String s : collect.keySet()){
            System.out.println(s);
        }
    }
}

class Student{
    private String name;
    private String age;
    private Integer score;

    public Student(String name, String age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", score=" + score +
                '}';
    }
}