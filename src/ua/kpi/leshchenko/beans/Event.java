package ua.kpi.leshchenko.beans;

import java.io.Serializable;

public class Event implements Serializable {

	private int idEvent;
	private String team1;
	private String team2;
	private String result;
	private int gameType;
	private String gameName;
	private double teamValue1;
	private double teamValue2;

	public Event() {

	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getResult() {
		return result;
	}

	public double getTeamValue1() {
		return teamValue1;
	}

	public void setTeamValue1(double teamValue1) {
		this.teamValue1 = teamValue1;
	}

	public double getTeamValue2() {
		return teamValue2;
	}

	public void setTeamValue2(double teamValue2) {
		this.teamValue2 = teamValue2;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getGameType() {
		return gameType;
	}

	public void setGameType(int gameType) {
		this.gameType = gameType;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameName == null) ? 0 : gameName.hashCode());
		result = prime * result + gameType;
		result = prime * result + idEvent;
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((team1 == null) ? 0 : team1.hashCode());
		result = prime * result + ((team2 == null) ? 0 : team2.hashCode());
		long temp;
		temp = Double.doubleToLongBits(teamValue1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(teamValue2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (gameName == null) {
			if (other.gameName != null)
				return false;
		} else if (!gameName.equals(other.gameName))
			return false;
		if (gameType != other.gameType)
			return false;
		if (idEvent != other.idEvent)
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		if (team1 == null) {
			if (other.team1 != null)
				return false;
		} else if (!team1.equals(other.team1))
			return false;
		if (team2 == null) {
			if (other.team2 != null)
				return false;
		} else if (!team2.equals(other.team2))
			return false;
		if (Double.doubleToLongBits(teamValue1) != Double.doubleToLongBits(other.teamValue1))
			return false;
		if (Double.doubleToLongBits(teamValue2) != Double.doubleToLongBits(other.teamValue2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ua.kpi.leshchenko.beans.Event: [idEvent=").append(idEvent);
		sb.append(", team1=").append(team1);
		sb.append(", team2=").append(team2);
		sb.append(", result=").append(result);
		sb.append(", gameName=").append(gameName);
		sb.append(", teamValue1=").append(teamValue1);
		sb.append(", teamValue2=").append(teamValue2);
		sb.append("]");
		return sb.toString();
	}

}
