package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean canMove(Position pos) {
        ChessPiece p = (ChessPiece) getBoard().piece(pos);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position pos) {
        ChessPiece p = (ChessPiece) getBoard().piece(pos);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount()==0;
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCols()];

        Position p = new Position(0,0);

        //searching above
        p.setValues(position.getRow()-1, position.getCol());
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        //searching below
        p.setValues(position.getRow()+1, position.getCol());
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        //searching left
        p.setValues(position.getRow(), position.getCol()-1);
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        //searching right
        p.setValues(position.getRow(), position.getCol()+1);
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        //searching northwest
        p.setValues(position.getRow()-1, position.getCol()-1);
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        //searching northeast
        p.setValues(position.getRow()-1, position.getCol()+1);
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        //searching southwest
        p.setValues(position.getRow()+1, position.getCol()-1);
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        //searching southeast
        p.setValues(position.getRow()+1, position.getCol()+1);
        if(getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getCol()] = true;
        }

        // special move castling
        if(getMoveCount()==0 && !chessMatch.getCheck()){
            //castling king side rook
            Position posT1 = new Position(position.getRow(), position.getCol()+3);
            if(testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getCol()+1);
                Position p2 = new Position(position.getRow(), position.getCol()+2);
                if(getBoard().piece(p1)==null && getBoard().piece(p2)==null){
                    mat[position.getRow()][position.getCol()+2] = true;
                }
            }
            //castling queen side rook
            Position posT2 = new Position(position.getRow(), position.getCol()-4);
            if(testRookCastling(posT2)) {
                Position p1 = new Position(position.getRow(), position.getCol()-1);
                Position p2 = new Position(position.getRow(), position.getCol()-2);
                Position p3 = new Position(position.getRow(), position.getCol()-3);
                if(getBoard().piece(p1)==null && getBoard().piece(p2)==null && getBoard().piece(p3)==null){
                    mat[position.getRow()][position.getCol()-2] = true;
                }
            }
        }
        return mat;
    }
}
