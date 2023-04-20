package vo;

public class User_PostVO {
	private int user_idx, post_idx;
	private String isUp, isDown;

	public int getUser_idx() {
		return user_idx;
	}

	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}

	public int getPost_idx() {
		return post_idx;
	}

	public void setPost_idx(int post_idx) {
		this.post_idx = post_idx;
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
