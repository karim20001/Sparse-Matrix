package sparse_matrix.model;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Comparator;

public class Sparsing {

    private static final ArrayList<int[]> A = new ArrayList<>();
    private static final ArrayList<int []> B = new ArrayList<>();
    private final ArrayList<int []> result = new ArrayList<>();

    public void sparsing(char check, int column, ArrayList<TextField> textFields){

        int tempRow = 0, tempCol = 0;
        for (int i = 0; i < textFields.size(); i++, tempCol++) {

            if (check == 'A' && !textFields.get(i).getText().equals("") && !textFields.get(i).getText().equals("0")) {

                int[] temp = {tempRow, tempCol, Integer.parseInt(textFields.get(i).getText())};
                A.add(temp);

            } else if (check == 'B' && !textFields.get(i).getText().equals("") && !textFields.get(i).getText().equals("0")) {

                int[] temp = {tempRow, tempCol, Integer.parseInt(textFields.get(i).getText())};
                B.add(temp);
            }

            if (tempCol == column - 1) {
                tempCol = -1;
                tempRow++;
            }
        }
    }

    public void adding_subtracting(int zarib) {

        int max = A.size() + B.size();
        int[] tempA = new int[3], tempB = new int[3];
        for (int i = 0, j = 0, k = 0; i < max; i++) {

            if (j >= A.size() && k >= B.size())
                break;

            if (j < A.size())
                tempA = A.get(j);
            if (k < B.size())
                tempB = B.get(k);

            if (tempA[0] > tempB[0] && k < B.size()) {

                tempB[2] = tempB[2] * zarib;
                result.add(tempB);
                k++;
            }
            if (k >= B.size() && j < A.size()) {
                result.add(tempA);
                j++;
            } else if (tempA[0] < tempB[0] && j < A.size()) {
                result.add(tempA);
                j++;
            }
            if (j >= A.size() && k < B.size()) {
                tempB[2] = tempB[2] * zarib;
                result.add(tempB);
                k++;
            } else if (tempA[0] == tempB[0]) {

                if (tempA[1] > tempB[1] && k < B.size()) {
                    tempB[2] = tempB[2] * zarib;
                    result.add(tempB);
                    k++;
                } else if (tempA[1] < tempB[1] && j < A.size()) {
                    result.add(tempA);
                    j++;
                } else if (tempA[1] == tempB[1]) {
                    int[] temp = {tempA[0], tempA[1], tempA[2] + tempB[2] * zarib};
                    j++;
                    k++;
                    result.add(temp);
                }
            }
        }
    }

    public void multiply(int rowA, int colB){

        //B.sort(Comparator.comparing(a -> a[1]));
        for (int i = 0; i < rowA; i++){

            //  save rows of sparse matrix A one by one
            ArrayList<int[]> temp = new ArrayList<>();
            for (int[] t : A) {

                if (t[0] == i) {
                    temp.add(t);
                }
            }
            for (int j = 0; j < colB; j++){

                int sum = 0;
                // save cols of sparse matrix B one by one
                ArrayList<int[]> tempColB = new ArrayList<>();
                for (int[] t : B) {

                    if (t[1] == j) {
                        tempColB.add(t);
                    }
                }

                // multiply & add
                for (int[] p : temp) {
                    for (int[] x : tempColB) {

                        if (p[1] == x[0]){
                            sum += p[2] * x[2];
                        }
                    }
                }
                // add to result Arraylist (sparse)
                if (sum != 0)
                    result.add(new int[] {i, j, sum});
            }
        }
    }

    public void transpose(){

        for (int[] ints : A) {
            int[] temp = {ints[1], ints[0], ints[2]};
            result.add(temp);
        }
        result.sort(Comparator.comparing(e -> e[0]));
    }

    public ArrayList<int[]> getA() {
        return A;
    }

    public ArrayList<int[]> getResult() {
        return result;
    }

    public ArrayList<int[]> getB() {
        return B;
    }

    public void reset(){
        A.clear();
        B.clear();
        result.clear();
    }
}
