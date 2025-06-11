public class Wood {
    private static int count = 0;
    public Wood () {

    }
    public void use_wood(int amount) {
        count -= amount;
    }
    public void make_wood(int amount) {
        count += amount;
    }
    public int get_wood() {
        return count;
    }
}
