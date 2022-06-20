import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HuffmanDriver {

    public static void main(String[] args) throws FileNotFoundException {
        int action;
        System.out.println("Start");
        // Instantiate LinkedBinaryTree and build Huffman tree from frequency file
        HuffmanTree namesToCompress = new HuffmanTree("names2020.csv");

        // Get the codes generated and print table
        ArrayList<Compress> huffman = namesToCompress.compressCodes();
        System.out.println("Number of compressed names is " + huffman.size());



        // Sort huffman ArrayList by calling the static bubblesort method in Compress
        Compress.bubbleSort(huffman);
        for (Compress c : huffman) {
            System.out.println(c);
        }




        // Test the encoding
        Scanner in = new Scanner(System.in);
        boolean done = false;
        do {
            System.out.println("Enter an action: 1 - encode  2 - decode   3 - exit");
            action = Integer.parseInt(in.nextLine());
            if(action == 1) {
                System.out.println("Enter a string to encode");
                encode(namesToCompress, in.nextLine());
            }
            else if(action == 2) {
                System.out.println("Enter a string to decode");
                decode(namesToCompress, in.nextLine());
            }

        } while (action != 3);

    }
    public static void encode(HuffmanTree namesToCompress, String input) {
        // Get and display encoding of string, with length
        String encoding = namesToCompress.encode(input);
        System.out.printf("Original string length is %d\n", input.length());
        System.out.printf("Encoded string (length %d), compressed %5.2f\n",
                encoding.length(), encoding.length()/16.0);   // Recall that characters are normally 2 bytes
        System.out.println(encoding);
        // Get and display decoding of encoded string
        System.out.println();

        System.out.println("Now we try to reconstruct the original from the encoded string");
        String original = namesToCompress.decode(encoding);
        if (original.equals(input)) {
            System.out.println("It worked! String is: " + original);
        }
        else {
            System.out.println("Oops. There was a problem.  Decoded string is: " + original);
        }
    }
    public static void decode(HuffmanTree namesToCompress, String input) {
        String original = namesToCompress.decode(input);
        System.out.println(original);
    }

}


