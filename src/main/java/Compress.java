import java.util.ArrayList;

public class Compress {
    Name n;
    String code;

    public Compress() {
        n = null;
        code = "";
    }


    public Compress (Name n, String code) {
        this.n = n;
        this.code = code;
    }

    public Compress (Compress c) {
        c = new Compress(n, code);
    }


    public static<T> void bubbleSort(ArrayList<Compress> list) {
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getCode().length() < list.get(j + 1).getCode().length()) {
                    swap(list,j,j+1);
                }
            }
        }
    }

    private static void swap(ArrayList<Compress> list, int i, int j) {
        Compress temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }



    public String getName() {
        return n.getName();
    }

    public Double getRank() {
        return n.getRank();
    }

    public String getGender() {
        return n.getGender();
    }

    public void setN(Name n) {
        this.n = n;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toString() {
        return getName() + "\t" + getCode();
    }
}
