///////////////////////////////////////
// Implementation of Person (LSP)
// ////////////////////////////////////

package class_pac;
//LSP
// Base abstraction
abstract class Person {

    // Private state
    private String name;
    private int no_flo;
    private int no_cls;

    // Protected for subclasses
    protected boolean in_cls;
    protected int tired;

    // Constructor
    Person(String name, int nf, int nc) {
        this.name = name;
        this.no_flo = nf;
        this.no_cls = nc;
        this.in_cls = false;
        this.tired = 0;
    }

    // Common behavior (safe for all subclasses)
    public void print() {
        System.out.println(name + " " + tired);
    }

    // Getters (LSP-safe)
    String get_name() { return name; }
    int get_flo() { return no_flo; }
    int get_cls() { return no_cls; }
    boolean get_in() { return in_cls; }
    int get_tired() { return tired; }

    // State change
    void set_in() { in_cls = true; }
    void set_out() { in_cls = false; }
}
