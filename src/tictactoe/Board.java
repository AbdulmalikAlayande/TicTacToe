package tictactoe;

import java.util.Arrays;

public class Board {
	
	
	private final Values[][] elements = new Values[3][3];
	
	public Board(){
		for (Values[] row : elements)
			Arrays.fill(row, Values.EMPTY);
	}
	
	public static void main(String... args) {
		Board board = new Board();
		System.out.println(Arrays.deepToString(board.elements));
	}
	
	public void setValuesToBoard(Values value, int position){
		checkIfPositionHasNotBeenFilled(position);
		switch (position) {
			case 1 -> elements[0][0] = value;
			case 2 -> elements[0][1] = value;
			case 3 -> elements[0][2] = value;
			case 4 -> elements[1][0] = value;
			case 5 -> elements[1][1] = value;
			case 6 -> elements[1][2] = value;
			case 7 -> elements[2][0] = value;
			case 8 -> elements[2][1] = value;
			case 9 -> elements[2][2] = value;
		}
	}
	
	private void checkIfPositionHasNotBeenFilled(int position){
		int positionCount = 0;
		for (Values[] values: elements)
			for (Values value : values) {
				positionCount++;
				if (position == positionCount && value != Values.EMPTY) throw new IllegalArgumentException("Space Already Filled");
			}
	}
	
	public Values[][] getElements() {
		return elements;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for (Values[] arrayOfValues:elements) {
			builder.append(Arrays.toString(arrayOfValues)).append("\n");
		}
		return builder.toString();
	}
}
