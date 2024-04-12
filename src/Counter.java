public class Counter {
    private int counter = -1;
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

public int add(){
        counter++;
        return counter;
}

}
