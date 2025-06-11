import java.util.ArrayList;

public class Lumberyard extends Building {

    private final int maxWorkers = 4;

    public Lumberyard() {
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
    public boolean harvest(Wood wood) {
        wood.add(2);
        return true;
    }

}
