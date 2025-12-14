///////////////////////////
// Implementation of Junior
///////////////////////////

package class_pac;

// Junior student (SRP applied)
public class Junior extends Student {

    // Constructor
    public Junior(String name, int nf, int nc) {
        super(name, nf, nc);
    }

    // Attend Junior
    @Override
    public void attend(int N, int L) {
        // Junior fatigue calculation
        this.tired += (N * L);
    }
}
