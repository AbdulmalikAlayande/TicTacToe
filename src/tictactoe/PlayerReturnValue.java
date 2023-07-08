package tictactoe;

public class PlayerReturnValue {
	
	private Player whoPlayed;
	private String positionPlayed;
	
	public Player getWhoPlayed() {
		return whoPlayed;
	}
	
	public void setWhoPlayed(Player whoPlayed) {
		this.whoPlayed = whoPlayed;
	}
	
	public String getPositionPlayed() {
		return positionPlayed;
	}
	
	public void setPositionPlayed(String positionPlayed) {
		this.positionPlayed = positionPlayed;
	}
}
