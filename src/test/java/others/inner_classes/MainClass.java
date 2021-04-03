package others.inner_classes;

public class MainClass {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.Inner inner = outer.new Inner();
        inner.msg();
    }
}
