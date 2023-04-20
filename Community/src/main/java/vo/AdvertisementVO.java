package vo;

public class AdvertisementVO {
	private int ad_idx;
	private String company_name, term_start, term_end, ad_img;

	public int getAd_idx() {
		return ad_idx;
	}

	public void setAd_idx(int ad_idx) {
		this.ad_idx = ad_idx;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getTerm_start() {
		return term_start;
	}

	public void setTerm_start(String term_start) {
		this.term_start = term_start;
	}

	public String getTerm_end() {
		return term_end;
	}

	public void setTerm_end(String term_end) {
		this.term_end = term_end;
	}

	public String getAd_img() {
		if (this.ad_img == null) {
			return "no_data.jpg";
		}
		return ad_img;
	}

	public void setAd_img(String ad_img) {
		this.ad_img = ad_img;
	}

}
