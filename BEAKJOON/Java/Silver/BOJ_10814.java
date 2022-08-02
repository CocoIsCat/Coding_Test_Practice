import java.util.*;

class Person implements Comparable<Person>{
    public int age;
    public String name;
    public int index;

    Person(int a, String n, int i) {
        this.age = a;
        this.name = n;
        this.index = i;
    }

    public int compareTo(Person p) {
        if(this.age == p.age) {
            return this.index - p.index;
        }
        else {
            return this.age - p.age;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Person> people = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            people.add(new Person(sc.nextInt(), sc.next(), i));
        }
        Collections.sort(people);
        for(Person p : people) {
            System.out.println(p.age + " " + p.name);
        }
    }
}