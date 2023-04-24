package project.com.community;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.AdvertisementDAO;
import dao.CommentDAO;
import dao.PostDAO;
import dao.UserDAO;
import dao.User_CommentDAO;
import dao.User_PostDAO;
import db.DB;
import vo.CommentVO;
import vo.PostVO;

@Controller
public class CommuController {

	AdvertisementDAO advertisement_dao;
	CommentDAO comment_dao;
	PostDAO post_dao;
	User_CommentDAO user_comment_dao;
	User_PostDAO user_post_dao;
	UserDAO user_dao;

	Random random = new Random();

	@Autowired // 자동주입 : spring으로부터 자동생성이 가능한 객체를 new없이 알아서 생성해 준다.
	HttpServletRequest request;

	public CommuController(AdvertisementDAO advertisement_dao, CommentDAO comment_dao, PostDAO post_dao,
			User_CommentDAO user_comment_dao, User_PostDAO user_post_dao, UserDAO user_dao) {
		// TODO Auto-generated constructor stub
		this.advertisement_dao = advertisement_dao;
		this.comment_dao = comment_dao;
		this.post_dao = post_dao;
		this.user_comment_dao = user_comment_dao;
		this.user_post_dao = user_post_dao;
		this.user_dao = user_dao;
	}

	@RequestMapping(value = { "/", "main_screen.do" })
	public String main_screen() {

		System.out.println("a");
		return "/WEB-INF/views/commu/main_screen.jsp";
	}

	@RequestMapping("/data_insert.do")
	public String data_insert() throws IOException, ParseException {

		String[] c_category = { "sf", "가족", "갱스터", "계몽", "공포", "군사", "느와르", "드라마", "로드무비", "로맨스", "무협", "문예", "뮤지컬",
				"뮤직", "미스터리", "범죄", "사극", "사회물(경향)", "서부", "스릴러", "스포츠", "신파", "실험", "아동", "액션", "어드벤처", "옴니버스", "재난",
				"전기", "전쟁", "종교", "첩보", "청춘영화", "코미디", "판타지", "하이틴(고교)", "합작(번안물)", "활극" };

		String[] m_category = { "전사", "마법사", "도적", "팁", "관리자인증", "자유게시판", "질문과답변" };
		String[] s_category = { "수다", "투표", "테섭", "이벤트", "웃긴글", "인사", "알림", "정보", "기타" };
		String[] name = { "가", "나", "김", "민", "주", "영", "한", "사", "후", "현" };

		for (String c : c_category) {
			String file_path = "C:\\Embedded_Spring\\work\\Community\\Community\\src\\main\\webapp\\resources\\DB\\"
					+ c + ".txt";
			// 김볼탱 DB 절대 경로 :
			// C:\Embedded_Spring\work\project_3\MOVIE_MATE\src\main\webapp\resources\DB
			// 민지 DB 절대 경로 :
			// C:\\embedded_kmz_spring\\work\\Project_movie_mate\\MOVIE_MATE\\src\\main\\webapp\\resources\\DB
			DB db_text = new DB();
			String[] file_path_arr = db_text.run(file_path);
			for (String link : file_path_arr) {
				// 1. 경로 확인
				String s = URLEncoder.encode(c, "utf-8");
				System.out.println("api 경로 : " + link);
				link = link.replace("genre=" + c, "genre=" + s);
				System.out.println("api 경로 : " + link);

				// 2. URL url 생성
				StringBuilder urlBuilder = new StringBuilder(link);
				// 3. URL 객체 생성.
				URL url = new URL(urlBuilder.toString());
				// 4. 요청하고자 하는 URL과 통신하기 위한 Connection 객체 생성.
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				// 5. 통신을 위한 메소드 SET.
				conn.setRequestMethod("GET");
				// 6. 통신을 위한 Content-type SET.
				conn.setRequestProperty("Content-type", "application/json");
				// 7. 통신 응답 코드 확인.
				// System.out.println("Response code: " + conn.getResponseCode());
				// 8. 전달받은 데이터를 BufferedReader 객체로 저장.
				BufferedReader rd;
				if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
					rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				} else {
					rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
				}
				// 9. 저장된 데이터를 라인별로 읽어 StringBuilder 객체로 저장.
				StringBuilder sb = new StringBuilder();
				String line;
				while ((line = rd.readLine()) != null) {
					sb.append(line);
				}
				// 10. 객체 해제.
				rd.close();
				conn.disconnect();
				// 11. 전달받은 데이터 확인

				JSONParser parser = new JSONParser();
				JSONObject jsonObject = (JSONObject) parser.parse(sb.toString());
				JSONArray data = (JSONArray) jsonObject.get("Data");

				for (Object arr : data) {
					PostVO post_vo = new PostVO();
					JSONObject obj = (JSONObject) arr; // JSONArray 데이터를 하나씩 가져와 JSONObject로 변환해준다.
					JSONArray result = (JSONArray) obj.get("Result");
					for (Object arr2 : result) {
						int name_length = random.nextInt(4) + 1;
						String username = "";
						for (int i = 0; i < name_length; i++) {
							username += name[random.nextInt(name.length)];
						}
						post_vo.setUsername(username);
						System.out.println("username : " + username);
						String category = m_category[random.nextInt(m_category.length)];
						post_vo.setCategory(category);
						System.out.println("category : " + category);
						String sub_category = s_category[random.nextInt(s_category.length)];
						post_vo.setSub_category(sub_category);
						System.out.println("sub_category : " + sub_category);
						JSONObject obj2 = (JSONObject) arr2;
						String title = (String) obj2.get("title");
						System.out.println("title : " + title);
						post_vo.setTitle(title);
						JSONObject obj3 = (JSONObject) obj2.get("plots");
						JSONArray plot = (JSONArray) obj3.get("plot");
						for (Object arr3 : plot) {
							JSONObject obj4 = (JSONObject) arr3;
							String content = (String) obj4.get("plotText");
							if (obj4.get("plotLang").equals("한국어")) {
								if (content.length() == 0) {
									content = "내용설명이 한국어로 존재하지 않습니다.";
								}
								post_vo.setContent(content);
								break;
							} else {
								content = "내용설명이 한국어로 존재하지 않습니다.";
								post_vo.setContent(content);
							}
						}
						post_dao.insert_data(post_vo);
					}
				}
			}
		}

		return "/WEB-INF/views/commu/main_screen.jsp";
	}
}
