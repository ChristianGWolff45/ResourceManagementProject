import java.util.ArrayList;

public class Mine extends Building {
    private final int maxWorkers = 10;
    public Mine() {
        super();
    }

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
    public boolean mineStone(Stone stone) {
        stone.add(2);
        return true;
    }
    public boolean mineOre(Ore ore) {
        ore.add(1);
        return true;
    }

}
