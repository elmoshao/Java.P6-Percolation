public class PercolationDFSFast extends PercolationDFS {

    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationDFSFast(int n) {
        super(n);
    }

    @Override
    protected void updateOnOpen(int row, int col) {
        //super.updateOnOpen(row, col);
       // if (row == 0 || isFull(row,col - 1) ||isFull(row, col + 1) || isFull(row - 1, col) || isFull(row+1, col) ){
       //     dfs(row , col);
       // }
        if ( row == 0){
            dfs(row,col);
        }
        else if (row != myGrid.length - 1 && col == 0){
            if(isFull(row - 1, col ) || isFull(row + 1, col ) || isFull(row,col + 1)){
                dfs(row,col);
            }
        }
        else if(row != myGrid.length - 1 && col == myGrid[0].length - 1){
            if(isFull(row - 1,col ) ||isFull(row + 1, col) || isFull(row,col - 1)){
                dfs(row,col);
            }
        }
        else if(row == myGrid.length - 1 && col == 0){
            if(isFull(row - 1, col ) ||  isFull(row,col + 1)){
                dfs(row,col);
            }
        }
        else if(row == myGrid.length - 1 && col == myGrid[0].length - 1){
            if(isFull(row - 1, col ) ||  isFull(row,col - 1)){
                dfs(row,col);
            }
        }
        else if(row == myGrid.length - 1 ){
            if(isFull(row - 1, col ) ||  isFull(row,col - 1) || isFull(row, col + 1)){
                dfs(row,col);
            }
        }
        else{
            if(isFull(row,col - 1) ||isFull(row, col + 1) || isFull(row - 1, col) || isFull(row+1, col) ){
                dfs(row,col);
            }

            }
    }
}
