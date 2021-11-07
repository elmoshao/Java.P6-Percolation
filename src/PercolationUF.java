public class PercolationUF implements IPercolate{
    private IUnionFind myFinder;
    private boolean[][] myGrid;
    private final int VTOP;
    private final int VBOTTOM;
    private int myOpenCount;

    public PercolationUF(IUnionFind finder, int size){
        myGrid  = new boolean[size][size];
        finder.initialize(size * size + 2);
        myFinder = finder;
        VTOP = size * size;
        VBOTTOM = size * size + 1;
        myOpenCount = 0;
    }

    @Override
    public void open(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        if (!myGrid[row][col]){
            myGrid[row][col] = true;
            myOpenCount++;
            if(row==0){
                myFinder.union(row * myGrid.length + col, VTOP);
            }
            if(row == myGrid.length - 1){
                myFinder.union(row * myGrid.length + col, VBOTTOM);
            }
            if(row > 0 && row < myGrid.length - 1 && col == 0){
                int[] rowDelta = {-1,1,0};
                int[] colDelta = {0,0,1};
                for(int k=0; k < rowDelta.length; k++) {
                    int rowd = row + rowDelta[k];
                    int cold = col + colDelta[k];
                    if(myGrid[rowd][cold]){
                        myFinder.union(row * myGrid.length + col, rowd * myGrid.length + cold);

                    }

            }}
            if(row > 0 && row < myGrid.length - 1 && col == myGrid[0].length - 1) {
                int[] rowDelta = {-1, 1, 0};
                int[] colDelta = {0, 0, -1};
                for (int k = 0; k < rowDelta.length; k++) {
                    int rowd = row + rowDelta[k];
                    int cold = col + colDelta[k];
                    if (myGrid[rowd][cold]) {
                        myFinder.union(row * myGrid.length + col, rowd * myGrid.length + cold);

                    }
                }
            }
            if(row > 0 && row < myGrid.length - 1 && col > 0 && col < myGrid[0].length - 1){
                int[] rowDelta = {-1,1,0,0};
                int[] colDelta = {0,0,-1,1};
                for(int k=0; k < rowDelta.length; k++) {
                    int rowd = row + rowDelta[k];
                    int cold = col + colDelta[k];
                    if(myGrid[rowd][cold]){
                        myFinder.union(row * myGrid.length + col, rowd * myGrid.length + cold);

                    }
            }
            }
            if(row == myGrid.length - 1 && col == 0) {
                int[] rowDelta = {-1, 0};
                int[] colDelta = {0, 1};
                for (int k = 0; k < rowDelta.length; k++) {
                    int rowd = row + rowDelta[k];
                    int cold = col + colDelta[k];
                    if (myGrid[rowd][cold]) {
                        myFinder.union(row * myGrid.length + col, rowd * myGrid.length + cold);

                    }
                }
            }
            if(row == myGrid.length - 1 && col == myGrid[0].length - 1) {
                int[] rowDelta = {-1, 0};
                int[] colDelta = {0, -1};
                for (int k = 0; k < rowDelta.length; k++) {
                    int rowd = row + rowDelta[k];
                    int cold = col + colDelta[k];
                    if (myGrid[rowd][cold]) {
                        myFinder.union(row * myGrid.length + col, rowd * myGrid.length + cold);

                    }
                }
            }
            if(row == myGrid.length - 1 && col < myGrid[0].length - 1 && col > 0) {
                int[] rowDelta = {-1,0, 0};
                int[] colDelta = {0, -1,1};
                for (int k = 0; k < rowDelta.length; k++) {
                    int rowd = row + rowDelta[k];
                    int cold = col + colDelta[k];
                    if (myGrid[rowd][cold]) {
                        myFinder.union(row * myGrid.length + col, rowd * myGrid.length + cold);

                    }
                }
            }
        }



    }


    public boolean inBounds(int row, int col) {
        if (row < 0 || row >= myGrid.length) return false;
        if (col < 0 || col >= myGrid[0].length) return false;
        return true;
    }

    @Override
    public boolean isOpen(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        else{
            return myGrid[row][col];
        }

    }

    @Override
    public boolean isFull(int row, int col) {
        if (! inBounds(row,col)) {
            throw new IndexOutOfBoundsException(
                    String.format("(%d,%d) not in bounds", row,col));
        }
        else {return myFinder.connected(row * myGrid.length + col, VTOP);

    }}

    @Override
    public boolean percolates() {
        return myFinder.connected(VTOP, VBOTTOM);
    }

    @Override
    public int numberOfOpenSites() {
        return myOpenCount;
    }
}
