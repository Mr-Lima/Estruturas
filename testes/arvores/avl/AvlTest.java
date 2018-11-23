package arvores.avl;

import java.util.Random;

public class AvlTest {

    public static void main(String[] args) {
        Random rng = new Random(50);
        Avl<Integer, Integer> tree = new Avl<>();

        System.out.println("Inserting values 1 to 10");
        for (int i = 0; i < 10; i++) {
            Integer chave = rng.nextInt(99);
            System.out.println("chave = " + chave);
            tree.insert(chave, rng.nextInt(99));
        }
        System.out.print("Printing balance: ");
        tree.printBalance();
    }
}
