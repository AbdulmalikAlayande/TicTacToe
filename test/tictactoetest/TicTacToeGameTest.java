package tictactoetest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tictactoe.Board;
import tictactoe.Player;
import tictactoe.TicTacToeGame;
import tictactoe.Values;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeGameTest {
	TicTacToeGame ticTacToeGame;
	Player player;
	Player player1;
	@BeforeEach void startAllTestWith(){
		Board board = new Board();
		player = new Player();
		player.setIdentity(Values.O);
		player.setName("Abdulmalik");
		player1 = new Player();
		player1.setName("Amirah");
		player1.setIdentity(Values.X);
		ticTacToeGame = new TicTacToeGame(board);
	}
	
	@Test void testTheGameHasABoardToPlayTheGame(){
		assertNotNull(ticTacToeGame.getBoard());
	}
	
	@Test void testTheGameHasTwoPlayers(){
		ticTacToeGame.setPlayers(new Player[]{player, player1});
		Player[] players = ticTacToeGame.getPlayers();
		assertEquals(BigInteger.TWO.intValue(), players.length);
	}
	
	@Test void testTheBoardElementsAreInitializedToZeroAtTheBeginningOfEachGame(){
		Arrays.stream(ticTacToeGame.getBoard().getElements())
				.forEach((x)-> Arrays
				.stream(x)
				.forEach(y-> assertEquals(Values.EMPTY, y)));
	}
	
	@Test void testThatPlayerCanPlayAndBoardAcceptsTheValuesPlayedByEachPlayer(){
		Board board = ticTacToeGame.accept(player1.play("1"));
		assertEquals(player1.getIdentity(), board.getElements()[BigInteger.ZERO.intValue()][BigInteger.ZERO.intValue()]);
	}
	
	@Test void testThatAFilledPositionCannotBePlayedAtAgain(){
		ticTacToeGame.accept(player.play("4"));
		assertThrows(IllegalArgumentException.class, ()->ticTacToeGame.accept(player1.play("4")));
	}
	
	@Test void invalidValuesEnteredByUsersThrowsExceptionTest(){
		assertThrows(InputMismatchException.class, ()->ticTacToeGame.accept(player.play("q")));
	}
}
