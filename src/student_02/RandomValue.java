package student_02;

public class RandomValue {

	public static String randomName1() {
		// 한글 3자를 출력한다.
		char[] name = new char[3];
		// 유니코드 한글범위설정 (AC00~D7AF)
		for (int i = 0; i < name.length; i++) {
			name[i] = (char) (Math.random() * (0xD7AF - 0xAC00 + 1) + 0xAC00);
		}
		return new String(name);
	}

	public static String randomName2() {
		String[] firstName = { "김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안", "송",
				"류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
				"우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염",
				"양", "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반",
				"왕", "금", "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용" };
		String[] secondName = { "가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
				"단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바",
				"박", "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수",
				"숙", "순", "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우",
				"원", "월", "위", "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제",
				"조", "종", "주", "준", "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하",
				"한", "해", "혁", "현", "형", "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉",
				"혼", "황", "량", "린", "을", "비", "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언",
				"령", "섬", "들", "견", "추", "걸", "삼", "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더",
				"손", "술", "훔", "반", "빈", "실", "직", "흠", "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평",
				"늘", "늬", "랑", "얀", "향", "울", "련" };

		String name1 = firstName[(int) (Math.random() * (firstName.length))];
		String name2 = secondName[(int) (Math.random() * (firstName.length))];
		String name3 = secondName[(int) (Math.random() * (firstName.length))];
		return name1 + name2 + name3;
	}

	public static String randomId() {
		String[] id = { "A", "B", "C", "D", "E", "F", "a", "b", "c", "d", "f" };

		String createId1 = id[(int) (Math.random() * (id.length))];
		String createId2 = id[(int) (Math.random() * (id.length))];
		String createId3 = id[(int) (Math.random() * (id.length))];

		return createId1 + createId2 + createId3;
	}

	public static int randomNo() {
		int[] no = { 1, 2, 3, 4, 5 };

		int createNo = no[(int) (Math.random() * (no.length))];
		int createNo2 = no[(int) (Math.random() * (no.length))];
		int createNo3 = no[(int) (Math.random() * (no.length))];

		return createNo + createNo2 + createNo3;
	}

	public static int randomPoint() {

		int randomPoint = (int) (Math.random() * (120 - 80 + 1) + 80);

		return randomPoint;
	}
}
