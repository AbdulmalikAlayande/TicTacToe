package tictactoe;

public class Player {
	
	private String name;
	private Values identity;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Values getIdentity() {
		return identity;
	}
	
	public void setIdentity(Values identity) {
		this.identity = identity;
	}
	
	public PlayerReturnValue play(String position){
		PlayerReturnValue value = new PlayerReturnValue();
		value.setWhoPlayed(this);
		value.setPositionPlayed(position);
		return value;
	}
}
