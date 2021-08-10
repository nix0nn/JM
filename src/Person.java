public class Person implements Comparable <Person> {
    private String name;

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }

    public int compareTo(Object o) {
        return toString().compareTo(o.toString());
    }
}
