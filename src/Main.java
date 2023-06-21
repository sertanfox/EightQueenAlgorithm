// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static int[][] TABLE;
    public static int[][] QueenPositions;
    public static int currentRow = 0;
    public static int currentColumn = 0;
    public static int EMPTY = 0;
    public static int QUEEN = 1;
    public static int generation = 1;

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        setTable();
        resetQueens();

        while(QueenPositions[0][1] <= 7){
            if(isQueenSafe(currentRow,currentColumn)){
                QueenPositions[currentRow][1] = currentColumn;
                putToTable(QUEEN);

                if(currentRow == 7) {
                    printTableDesign();
                    putToTable(EMPTY);

                    backToLastRow();
                    isLastColumn();
                }
                else{
                    currentRow++;
                    currentColumn = QueenPositions[currentRow][1];
                }

            } else {
                if(currentColumn < 7)
                    currentColumn++;
                else {
                    backToLastRow();
                    isLastColumn();
                }
            }
        }
    }

    public static void isLastColumn(){
        if(currentColumn >= 7){
            QueenPositions[currentRow][1] = 0;

            currentRow--;
            currentColumn = QueenPositions[currentRow][1];
            putToTable(EMPTY);
            currentColumn++;
        }
        else
            currentColumn++;

    }

    public static void backToLastRow(){
        QueenPositions[currentRow][1] = 0;
        currentRow--;
        currentColumn = QueenPositions[currentRow][1];
        putToTable(EMPTY);
    }

    public static void putToTable(int value){
        TABLE[currentRow][currentColumn] = value;
    }

    private static void printTableDesign() {

        System.out.println(generation+". GENERATION : ");
        for(int i = 0; i <= 7; i++){
            for(int y = 0; y <= 7; y++){
                System.out.print(TABLE[i][y]+ "  ");
            }
            System.out.println();
        }
        System.out.println();
        generation++;
    }

    public static void setTable(){
        TABLE = new int[8][8];
        for(int row=0; row<8; row++){
            for(int column=0; column<8; column++){
                TABLE[row][column] = EMPTY;
            }
        }
    }

    public static void resetQueens(){
        QueenPositions = new int[8][2];
        for(int row=0; row<8; row++){
            QueenPositions[row][0] = row;
            QueenPositions[row][1] = 0;
        }
    }

    public static boolean isQueenSafe(int row, int column){
        int localColumn;
        int localRow;

        //region Check Top
        localColumn = column;
        localRow = row;
        while(localRow >=0){
            if(TABLE[localRow][localColumn]==QUEEN)
                return false;
            localRow--;
        }
        //endregion

        //region Check Top Left
        localColumn = column;
        localRow = row;
        while(localRow >=0 && localColumn >= 0){
            if(TABLE[localRow][localColumn]==QUEEN)
                return false;
            localRow--; localColumn--;
        }
        //endregion

        //region Check Top Right
        localColumn = column;
        localRow = row;
        while(localRow >=0 && localColumn < 8){
            if(TABLE[localRow][localColumn]==QUEEN)
                return false;
            localRow--; localColumn++;
        }
        //endregion

        return true;
    }

}