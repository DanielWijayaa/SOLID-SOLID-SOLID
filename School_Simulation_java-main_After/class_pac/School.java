///////////////////////////
// Implementation of School
///////////////////////////

// SRP
// Naming package
package class_pac;


// School
public class School {

    private Floor[] floors; // Array of Floors
    private Yard yard;      // Schoolyard
    private Stairs stairs;  // Stairs

    private int Lj;         // Units for Junior
    private int Ls;         // Units for Senior
    private int Lt;         // Units for Teacher


    // Constructor
    public School(int Lj, int Ls, int Lt, int Cclass) {

        // Initialization
        this.Lj = Lj;
        this.Ls = Ls;
        this.Lt = Lt;

        yard = new Yard();
        stairs = new Stairs();

        floors = new Floor[3];
        for (int i = 0; i < 3; ++i) {
            floors[i] = new Floor(i, Cclass);
        }

        System.out.println("A New School has been created!");
    }


    // Enter student in school
    // SRP: School only manages the school, not student behavior
    public void enter(Student s) {

        System.out.println(s.get_name() + " enters school");

        // Yard
        yard.enter(s);
        s = yard.exit();

        // Stairs
        stairs.enter(s);
        s = stairs.exit();

        // Floor
        floors[s.get_flo()].enter(s);
    }


    // Place teacher in school
    public void place(Teacher t) {
        floors[t.get_flo()].place(t);
    }


    // Operate school
    // SRP: operation logic delegated to Floor
    public void operate(int N) {

        for (int i = 0; i < 3; ++i) {
            floors[i].operate(N, Lj, Ls, Lt);
        }
    }


    // Print school status
    public void print() {

        System.out.println("School life consists of:");

        for (int i = 0; i < 3; ++i) {
            floors[i].print();
        }
    }


    // Empty school
    public void empty() {

        // Empty students
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

        // Empty teachers
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 6; ++j) {
                floors[i].teacher_out(j);
            }
        }
    }
}
