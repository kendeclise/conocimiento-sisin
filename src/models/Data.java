package models;

public class Data {
	private Double speed;
	private Double turnspeed;
	private Double x;
	private Double y;
	private Double yaw;
	
	public Data() {
		// TODO Auto-generated constructor stub
	}

	public Data(Double speed, Double turnspeed, Double x, Double y, Double yaw) {
		super();
		this.speed = speed;
		this.turnspeed = turnspeed;
		this.x = x;
		this.y = y;
		this.yaw = yaw;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getTurnspeed() {
		return turnspeed;
	}

	public void setTurnspeed(Double turnspeed) {
		this.turnspeed = turnspeed;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getYaw() {
		return yaw;
	}

	public void setYaw(Double yaw) {
		this.yaw = yaw;
	}

	@Override
	public String toString() {
		return "Data [speed=" + speed + ", turnspeed=" + turnspeed + ", x=" + x + ", y=" + y + ", yaw=" + yaw + "]";
	}
	
	
	
	
}
