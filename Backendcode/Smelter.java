import java.util.ArrayList;

public class Smelter extends Building {
    private final int maxWorkers = 12;

    public void setWorklist(ArrayList<Person> worklist) {
        if (worklist.size() < maxWorkers) {
            super.setWorklist(worklist);
        }
    }
    public void addWorker(Person person) {
        if (getWorkers() < maxWorkers) {
            super.addWorker(person);
        }
    }
    public void removeWorker(Person person) {
        removeWorker(person);
    }
    public boolean makeOre(Wood wood, Ore ore, Iron iron) {
        wood.remove(2);
        ore.remove(2);
        iron.add(1);
        return true;
    }
}
