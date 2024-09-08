package boardgame;

public class Board {
    private int rows;
    private int cols;
    private Piece[][] pieces;

    public Board(int rows, int cols) {
        if(rows < 1 || cols < 1){
            throw new BoardException("Invalid board length: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.cols = cols;
        this.pieces = new Piece[rows][cols];
    }
    public int getRows() {return rows;}
    public int getCols() {return cols;}

    public Piece piece(int row, int col) {
        if(!positionExists(row, col)){
            throw new BoardException("Position not on the board");
        }
        return pieces[row][col];
    }
    public Piece piece(Position pos) {
        if(!positionExists(pos)){
            throw new BoardException("Position not on the board");
        }
        return pieces[pos.getRow()][pos.getCol()];
    }

    public void placePiece(Piece piece, Position pos) {
        if(thereIsAPieace(pos)){
            throw new BoardException("There is already a piece on position " + pos);
        }
        pieces[pos.getRow()][pos.getCol()] = piece;
        piece.position = pos;
    }

    public Piece removePiece(Position pos) {
        if(!positionExists(pos)){
            throw new BoardException("Position not on the board");
        }
        if(piece(pos)==null){
            return null;
        }
        Piece aux = piece(pos);
        aux.position = null;
        pieces[pos.getRow()][pos.getCol()] = null;
        return aux;
    }

    private boolean positionExists(int row, int col) {
       return  row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public boolean positionExists(Position pos) {
        return positionExists(pos.getRow(), pos.getCol());
    }

    public boolean thereIsAPieace(Position pos) {
        if(!positionExists(pos)){
            throw new BoardException("Position not on the board");
        }
        return piece(pos) != null;
    }

}
