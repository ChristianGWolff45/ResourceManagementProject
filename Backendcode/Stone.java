public class Stone {
    private static int count = 0;
    public Stone() {

    }
    public void use_stone(int amount) {
        count -= amount;
    }
    public void make_stone(int amount) {
        count += amount;
    }
    public int get_stone() {
        return count;
    }
}
