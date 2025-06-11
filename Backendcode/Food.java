public class Food {
    private static int count = 0;
    public Food() {

    }
    public void use_food(int amount) {
        count -= amount;
    }
    public void make_food(int amount) {
        count += amount;
    }
    public int get_food() {
        return count;
    }

}
