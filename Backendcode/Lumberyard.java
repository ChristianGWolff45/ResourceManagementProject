import java.util.ArrayList;

public class Lumberyard {
    private int workers;
    private ArrayList<Person> worklist;
    private final int maxWorkers = 4;
    public Lumberyard() {
        this.workers = 0;
        worklist = new ArrayList<>();
    }
    public int getWorkers() {
        return workers;
    }
    public ArrayList<Person> getWorklist() {
        return worklist;
    }
    public void setWorklist(ArrayList<Person> worklist) {
        if (worklist.size() < maxWorkers) {
            workers = worklist.size();
            this.worklist = worklist;
        }
    }
    public void addWorker(Person person) {
        if (!worklist.contains(person) && person.isEmployed() == false && getWorkers() < maxWorkers) {
            worklist.add(person);
            workers++;
        }
    }
    public void removeWorker(Person person) {
        worklist.remove(person);
        workers--;
    }
    public boolean harvest(Wood wood) {
        wood.add(2);
        return true;
    }

}
