package others.interface_multilevel_inheritence;

public class Child implements Parent1, Parent2{
    @Override
    public void showMe() {
        System.out.println("From child class");
    }
}
