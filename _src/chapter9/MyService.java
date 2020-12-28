public class MyService {
    //method which has a return value
    public String echo(String value) {
        return value;
    }

    // does not have a return value
    public void update(int value) {
        System.out.println("value is :" + value);
    }
}
