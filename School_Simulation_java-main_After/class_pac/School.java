// Naming package
package class_pac;

// ==============================
// DIP: Abstraction
// ==============================
interface TransitionArea {
    void enter(Student s);
    Student exit();
}


// ==============================
// School
// ==============================
public class School {

    private Floor[] floors;
    private TransitionArea yard;
    private TransitionArea stairs;

    private int Lj;
    private int Ls;
    private int Lt;

    // Constructor
    public School(int Lj, int Ls, int Lt, int Cclass) {

        this.Lj = Lj;
        this.Ls = Ls;
        this.Lt = Lt;

        // ==============================
        // Dependency Inversion via Adapter
        // ==============================

        Yard realYard = new Yard();
        this.yard = new TransitionArea() {
            @Override
            public void enter(Student s) {
                realYard.enter(s);
            }

            @Override
            public Student exit() {
                return realYard.exit();
            }
        };

        Stairs realStairs = new Stairs();
        this.stairs = new TransitionArea() {
            @Override
            public void enter(Student s) {
                realStairs.enter(s);
            }

            @Override
            public Student exit() {
                return realStairs.exit();
            }
        };

        floors = new Floor[3];
        for (int i = 0; i < 3; ++i)
            floors[i] = new Floor(i, Cclass);

        System.out.println("A New School has been created!");
    }

    // Enter student
    public void enter(Student s) {
        System.out.println(s.get_name() + " enters school");

        yard.enter(s);
        s = yard.exit();

        stairs.enter(s);
        s = stairs.exit();

        floors[s.get_flo()].enter(s);
    }

    // Place teacher
    public void place(Teacher t) {
        floors[t.get_flo()].place(t);
    }

    // Operate school
    public void operate(int N) {
        for (int i = 0; i < 3; ++i)
            floors[i].operate(N, Lj, Ls, Lt);
    }

    // Print
    public void print() {
        System.out.println("School life consists of:");
        for (int i = 0; i < 3; ++i)
            floors[i].print();
    }

    // Empty school
    public void empty() {

        for (int i = 0; i < 3; ++i) {
            for (int k = 0; k < 6; ++k) {
                for (int j = 0; j < floors[i].get_ccls(); ++j) {

                    Student s = floors[i].exit(k);

                    stairs.enter(s);
                    s = stairs.exit();

                    yard.enter(s);
                    yard.exit();
                }
            }
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 6; ++j) {
                floors[i].teacher_out(j);
            }
        }
    }
}