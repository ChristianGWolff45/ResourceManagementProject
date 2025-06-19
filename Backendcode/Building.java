import java.util.ArrayList;

public class Building {
    private int workers;
    private ArrayList<Person> worklist;
    public Building() {
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
            workers = worklist.size();
            this.worklist = worklist;
    }
    public void addWorker(Person person) {
            worklist.add(person);
            workers++;
    }
    public void removeWorker(Person person) {
        worklist.remove(person);
        workers--;
    }
}
