import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface HuffmanADT {
    public BinaryTreeNode<Name> getLeft();
    public BinaryTreeNode<Name> getRight();
    public boolean isEmpty();
    public ArrayList<Compress> compressCodes();
    public String encode(String str) throws FileNotFoundException;
    public String decode(String huffString);
}
