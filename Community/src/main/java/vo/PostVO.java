package vo;

public class PostVO {
	private int post_idx, read_hit, up, down;
	private String title, content, username, category, sub_category, regdate;

	public int getPost_idx() {
		return post_idx;
	}

	public void setPost_idx(int post_idx) {
		this.post_idx = post_idx;
	}

	public int getRead_hit() {
		return read_hit;
	}

	public void setRead_hit(int read_hit) {
		this.read_hit = read_hit;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSub_category() {
		return sub_category;
	}

	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
