///////////////////////////
// Implementation of Senior
// (Liskov Substitution Principle)
///////////////////////////


// Naming package
package class_pac;


// Senior
// Kelas Senior dapat menggantikan Student
// TANPA mengubah perilaku yang diharapkan
// -> memenuhi Liskov Substitution Principle
public class Senior extends Student {

    // Constructor
    public Senior(String name, int nf, int nc) {
        // Inisialisasi superclass
        super(name, nf, nc);

        System.out.println("A New Senior has been created!");
    }

    // Attend Senior
    // Method ini memiliki:
    // - Nama method sama
    // - Parameter sama
    // - Tidak mengubah kontrak Student
    // - Tidak melempar exception baru
    // -> Senior bisa menggantikan Student di mana pun
    @Override
    public void attend(int N, int L) {

        // Logika attend tetap masuk akal
        // Tidak mengurangi perilaku yang dijanjikan Student
        this.tired += (N * L);
    }

    // Print
    // Tidak dioverride karena perilakunya sama
    // Tetap mengikuti kontrak Person
}
