import java.time.LocalTime;

public class Test {
    public static void main(String[] args) {
        Person pete = new Person("Pete", 30);
        Person chris = new Person("Chris", 30);
        Person bob = new Person("Bob", 30);
        Wood wood = new Wood();
        Stone stone = new Stone();
        Food food = new Food();

        wood.add(3);
        System.out.println(wood.getAmount());
        System.out.println(food.getAmount());
        if (wood.getAmount() == 3) {
            Lumberyard lumberyard = new Lumberyard();
            lumberyard.addWorker(pete);
            lumberyard.addWorker(chris);
            lumberyard.addWorker(bob);
            pete.setEmployment(true);
            bob.setEmployment(true);
            chris.setEmployment(true);
            System.out.println(lumberyard.getWorklist());
            lumberyard.harvest(wood);
            System.out.println(wood.getAmount());
        }
        else {
            System.out.println("Not enough wood to make a lumberyard");
        }

        LocalTime startTime = LocalTime.now();
        System.out.println(startTime);
    }
}
