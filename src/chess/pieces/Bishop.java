package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCols()];

        Position p = new Position(0,0);

        //searching northwest
        p.setValues(position.getRow()-1, position.getCol()-1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPieace(p)){
            mat[p.getRow()][p.getCol()] = true;
            p.setValues(p.getRow()-1, p.getCol()-1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        //searching northeast
        p.setValues(position.getRow()-1, position.getCol()+1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPieace(p)){
            mat[p.getRow()][p.getCol()] = true;
            p.setValues(p.getRow()-1, p.getCol()+1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        //searching southeast
        p.setValues(position.getRow()+1, position.getCol()+1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPieace(p)){
            mat[p.getRow()][p.getCol()] = true;
            p.setValues(p.getRow()+1, p.getCol()+1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        //searching southwest
        p.setValues(position.getRow()+1, position.getCol()-1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPieace(p)){
            mat[p.getRow()][p.getCol()] = true;
            p.setValues(p.getRow()+1, position.getCol()-1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        return mat;
    }
}
