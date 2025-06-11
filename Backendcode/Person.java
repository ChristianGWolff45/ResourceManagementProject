public class Person {
    private static int population;
    private String name;
    private int age;
    private boolean employed;
    public Person(String name, int age, boolean employed) {
        this.name = name;
        this.age = age;
        this.employed = employed;
        population++;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public boolean isEmployed() {
        return employed;
    }
    public void setEmployment(boolean emplyed) {
        this.employed = employed;
    }
    public static int getPopulation() {
        return population;
    }
}
