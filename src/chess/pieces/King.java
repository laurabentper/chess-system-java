package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    private boolean canMove(Position pos) {
        ChessPiece p = (ChessPiece) getBoard().piece(pos);
        return p == null || p.getColor() != getColor();
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

        return mat;
    }
}
