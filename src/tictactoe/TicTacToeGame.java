package tictactoe;

import org.apache.commons.collections4.list.LazyList;

import javax.swing.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class TicTacToeGame {
	private static final String[] validNumbers = {"1","2","3","4","5","6","7","8","9"};
	private static final int SIZE_OF_PLAYERS = BigInteger.TWO.intValue();
	private Board board;
	private Player[] players;
	
	public TicTacToeGame(Board board) {
		this.board = board;
	}
	
	public TicTacToeGame(){}
	
	public Board getBoard() {
		return board;
	}
	
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public Board accept(PlayerReturnValue value){
		String positionPlayedAt = value.getPositionPlayed();
		Player player = value.getWhoPlayed();
//		JCheckBox
		validatePosition(positionPlayedAt);
		int position = parseInt(positionPlayedAt);
		board.setValuesToBoard(player.getIdentity(), position);
		System.out.println(board.toString());
		return board;
	}
	
	private void validatePosition(String positionPlayedAt) {
		for (String validNumber : validNumbers)
			if (validNumber.equals(positionPlayedAt)) return;
		throw new InputMismatchException("Invalid Number");
	}
}
