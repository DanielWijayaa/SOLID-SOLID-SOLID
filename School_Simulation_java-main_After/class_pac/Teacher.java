package class_pac;
//LSP
// Teacher
public class Teacher extends Person {

    // Constructor
    public Teacher(String name, int nf, int nc) {
        super(name, nf, nc);
        System.out.println("A New Teacher has been created!");
    }

    // Specific behavior of Teacher
    public void teach(int N, int Lt) {
        // increase tired level
        this.tired += (N * Lt);
    }

    // Override print (LSP compliant)
    @Override
    public void print() {
        System.out.print("The Teacher is: ");
        super.print();
    }
}
