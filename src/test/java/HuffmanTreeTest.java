import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HuffmanTreeTest {

    @Test
    public void namestest1() {
        Name name1 = new Name("Amisha", 1, "F");
        Name name2 = new Name("Ayesha", 2, "F");
        Name evaluator = new Name(name1);
        evaluator = new Name(name2);
        assertEquals("Ayesha",evaluator.toString());
    }

    @Test
    public void nametest2() {
        Name evaluator = new Name();
        assertEquals("", evaluator.toString());
    }

    @Test
    public void nametest3() {
        Name oneName = new Name("Olivia", 17535.0, "F");
        Name evaluator = new Name(oneName);
        assertEquals("Olivia", evaluator.toString());
    }


    @Test
    public void compresstest1() {
        Name oneName = new Name("Olivia", 17535.0, "M");
        Compress evaluator = new Compress(oneName, "/*/*//*");
        assertEquals("Olivia\t/*/*//*", evaluator.toString());
    }

    @Test
    public void compresstest2() {
        Name oneName = new Name("Ava:Olivia",12345,"None");
        Compress evaluator = new Compress(oneName, "/*//****/**/");
        assertEquals("Ava:Olivia\t/*//****/**/", evaluator.toString());
    }

    @Test
    public void compresstest3() {
        Name oneName = new Name("Ava:Olivia:Amisha",12345,"None");
        Compress evaluator = new Compress(oneName, "/*//****/**/***/////");
        assertEquals("Ava:Olivia:Amisha\t/*//****/**/***/////", evaluator.toString());
    }


    @Test
    public void compresstest4() {
        ArrayList<Compress> evaluator = new ArrayList<>();
        evaluator.add(new Compress(new Name(":", 111111.0, "none"), "*"));
        evaluator.add(new Compress(new Name("Amelia", 12704.0, "F"), "**/**//*"));
        evaluator.add(new Compress(new Name("Olivia", 17535.0, "F"), "/*/*//*"));
        evaluator.add(new Compress(new Name("Ava", 13084.0, "F"), "***///**"));
        evaluator.add(new Compress(new Name("Benjamin", 12136.0, "M"), "**//*///"));
        evaluator.add(new Compress(new Name("Charlotte", 13003.0, "F"), "***/////"));
        evaluator.add(new Compress(new Name("Elijah", 13034.0, "M"), "***////*"));
        evaluator.add(new Compress(new Name("Alexander", 10151.0, "M"), "*//*/**/"));
        evaluator.add(new Compress(new Name("Henry", 10705.0, "M"), "*/*//**/"));
        evaluator.add(new Compress(new Name("Liam", 19659.0, "F"), "*///*//"));
        evaluator.add(new Compress(new Name("Mia", 11157.0, "F"), "*/**/*//"));
        Compress.bubbleSort(evaluator);

        String output = "";
        for (Compress oneName : evaluator)
            output += oneName.getName() + "-";

        assertEquals("Amelia-Ava-Benjamin-Charlotte-Elijah-Alexander-Henry-Mia-Olivia-Liam-:-", output);

    }

    @Test
    void HuffmanTreetest1() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020_10.csv");
        assertEquals("::Liam:Noah:Olivia:Emma:Oliver:Ava:Elijah:Charlotte:Sophia:William:", evaluator.toString());
    }

    @Test
    public void HuffmanTreetest2() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020_10.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        Compress.bubbleSort(compressNames);
        assertEquals("William\t/**//",compressNames.get(0).toString() );
    }

    @Test
    public void HuffmanTreetest3() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020_10.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        Compress.bubbleSort(compressNames);
        assertEquals("Noah\t/*//", compressNames.get(compressNames.size() - 3).toString());
    }


    @Test
    public void HuffmanTreetest4() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020_20.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        Compress.bubbleSort(compressNames);
        assertEquals("Michael\t/**///", compressNames.get(0).toString());
    }

    @Test
    public void HuffmanTreetest5() throws FileNotFoundException {
        assertThrows(FileNotFoundException.class, () -> {
            HuffmanTree evaluator = new HuffmanTree("names202v");
            ArrayList<Compress> compressNames = evaluator.compressCodes();
            compressNames.get(0);
        });
    }

    @Test
    public void HuffmanTreetest6() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020_20.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        Compress.bubbleSort(compressNames);
        assertEquals(":\t*", compressNames.get(compressNames.size() - 1).toString());
    }




    @Test
    public void HuffmanTreetest7() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        Compress.bubbleSort(compressNames);
        assertEquals("Liam\t*///*//", compressNames.get(compressNames.size() - 1).toString());

    }



    @Test
    public void encodetest1() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        assertEquals("*/*///*//***", evaluator.encode("Zyaire"));
    }

    @Test
    public void encodetest2() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        assertEquals("*****//*/*", evaluator.encode("Aaliyah"));
    }

    @Test
    public void encodetest3() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        assertEquals("//**///*/*****//*/**////**/**/*/", evaluator.encode("Zavier:Alexander:Tanner"));
    }

    @Test
    public void encodetest4() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020_20.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        assertEquals("/*//**/*/**", evaluator.encode("Olivia:Liam"));
    }

    @Test
    public void encodetest5() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020_10.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        assertEquals("//***/*/*", evaluator.encode("Olivia:Liam"));
    }


    @Test
    public void encodetest6() throws FileNotFoundException {
        assertThrows(InvalidHuffmanCodeException.class, () -> {
            HuffmanTree evaluator = new HuffmanTree("names2020_20.csv");
            ArrayList<Compress> compressNames = evaluator.compressCodes();
            evaluator.encode("Liam-Olivia");
        });
    }

    @Test
    public void encodetest7() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        assertEquals("/*/*//**///*//***////****///**//**///*/****", evaluator.encode("Olivia:Liam:Elijah:Ava:Zavier"));
    }

    @Test
    public void encodetest8() throws FileNotFoundException {
        assertThrows(InvalidHuffmanCodeException.class, () -> {
            HuffmanTree evaluator = new HuffmanTree("names2020_20.csv");
            ArrayList<Compress> compressNames = evaluator.compressCodes();
            evaluator.encode("");
        });
    }

    @Test
    public void encodetest9() throws FileNotFoundException {
        assertThrows(InvalidHuffmanCodeException.class, () -> {
            HuffmanTree evaluator = new HuffmanTree("names2020_20.csv");
            ArrayList<Compress> compressNames = evaluator.compressCodes();
            evaluator.encode(":");
        });
    }

    @Test
    public void decodetest1() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020_10.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        assertEquals("Liam", evaluator.decode("/*/*"));
    }

    @Test
    public void decodetest2() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        assertEquals("Eleanor:Elijah:Emma", evaluator.decode("**/**////***////*///****"));
    }

    @Test
    public void decodetest3() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020_20.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        assertEquals("Liam:Noah:Elijah:Emma", evaluator.decode("/*/***/*/*/*//*/**/*///"));
    }

    @Test
    public void decodetest4() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        assertEquals("Liam:Elijah:Emma:Eva", evaluator.decode("*///*//***////*///*****/***//**/"));
    }

    @Test
    public void decodetest5() throws FileNotFoundException {
        assertThrows(InvalidHuffmanCodeException.class, () -> {
            HuffmanTree evaluator = new HuffmanTree("names2020_20.csv");
            ArrayList<Compress> compressNames = evaluator.compressCodes();
            evaluator.decode("Liam~Ava");
        });
    }

    @Test
    public void decodetest6() throws FileNotFoundException {
        HuffmanTree evaluator = new HuffmanTree("names2020_10.csv");
        ArrayList<Compress> compressNames = evaluator.compressCodes();
        assertEquals("Liam:Oliver:Noah:Elijah:Charlotte:Sophia", evaluator.decode("/*/**///**/*//*/*****/***/*/**/*"));
    }



    @Test
    public void decodetest7() throws FileNotFoundException {
        assertThrows(InvalidHuffmanCodeException.class, () -> {
            HuffmanTree evaluator = new HuffmanTree("names2020_20.csv");
            ArrayList<Compress> compressNames = evaluator.compressCodes();
            evaluator.decode("~");
        });
    }





}

