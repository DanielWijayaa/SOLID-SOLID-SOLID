////////////////////////////
// Implementation of Student
////////////////////////////

// LSP
// Naming package
package class_pac;

// Student
public abstract class Student extends Person {

    // Constructor
    public Student(String name, int nf, int nc) {
        // Initialization of super-class
        super(name, nf, nc);

        System.out.println("A New Student has been created!");
    }

    // Attend
    // Must be implemented by all subclasses (Junior, Senior, etc)
    public abstract void attend(int N, int L);

    // Print behavior is inherited from Person
    // No override needed (LSP-safe)
}
