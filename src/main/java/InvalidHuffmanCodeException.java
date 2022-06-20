
public class InvalidHuffmanCodeException extends RuntimeException{
    /**
     * Sets up this exception with an appropriate message.
     * @param collection the name of the collection
     */
    public InvalidHuffmanCodeException()
    {
        super("The Huffman Code could not be determined!");
    }

}
