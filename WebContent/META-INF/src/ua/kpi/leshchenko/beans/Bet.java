package ua.kpi.leshchenko.beans;

import java.io.Serializable;

public class Bet implements Serializable {

	private int idBet;
	private int event;
	private int user;
	private String winner;
	private double betValue;
	private String team1;
	private String team2;
	private String result;

	public Bet() {

	}

	public double getBetValue() {
		return betValue;
	}

	public void setBetValue(double betValue) {
		this.betValue = betValue;
	}

	public int getIdBet() {
		return idBet;
	}

	public void setIdBet(int idBet) {
		this.idBet = idBet;
	}

	public int getEvent() {
		return event;
	}

	public void setEvent(int event) {
		this.event = event;
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

	public void setResult(String result) {
		this.result = result;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(betValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + event;
		result = prime * result + idBet;
		result = prime * result + user;
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
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
		Bet other = (Bet) obj;
		if (Double.doubleToLongBits(betValue) != Double.doubleToLongBits(other.betValue))
			return false;
		if (event != other.event)
			return false;
		if (idBet != other.idBet)
			return false;
		if (user != other.user)
			return false;
		if (winner == null) {
			if (other.winner != null)
				return false;
		} else if (!winner.equals(other.winner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ua.kpi.leshchenko.beans.Bet: [idBet=").append(idBet);
		sb.append(", event=").append(event);
		sb.append(", user=").append(user);
		sb.append(", winner=").append(winner);
		sb.append(", betValue=").append(betValue);
		sb.append("]");
		return sb.toString();
	}
}
