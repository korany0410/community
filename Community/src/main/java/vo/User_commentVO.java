package vo;

public class User_commentVO {
	private int user_idx, comment_idx;
	private String isUp, isDown;

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public int getComment_idx() {
		return comment_idx;
	}

	public void setComment_idx(int comment_idx) {
		this.comment_idx = comment_idx;
	}

	public String getIsUp() {
		if (this.isUp == null) {
			return "no";
		}
		return isUp;
	}

	public void setIsUp(String isUp) {
		this.isUp = isUp;
	}

	public String getIsDown() {
		if (this.isDown == null) {
			return "no";
		}
		return isDown;
	}

	public void setIsDown(String isDown) {
		this.isDown = isDown;
	}

}
