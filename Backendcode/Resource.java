public class Resource {
    private int count;
    public Resource() {
        count = 0;
    }
    public void add(int amount) {
        count += amount;
    }
    public void remove(int amount) {
        count -= amount;
    }
    public int getAmount() {
        return count;
    }
}
