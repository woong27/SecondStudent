package student_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentExample {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		boolean loopFlag = false;
		while (!loopFlag) {
			int num = displayMenu();
			switch (num) {
			case 1:// 입력
				studentInput(list);
				break;
			case 2:// 수정
				studentUpdate(list);
				break;
			case 3:// 검색
				studentSearch(list);
				break;
			case 4: // 삭제
				studentDelete(list);
				break;
			case 5: // 출력
				studintOutput(list);
				break;
			case 6:// 정렬
				studentSort(list);
				break;
			case 7:// 통계(최고점수,최저점수)
				studentStats(list);
				break;
			case 8:
				loopFlag = true;
				break;
			default:
				System.out.println("1~8번 입력요망");
				break;
			}
		}
		System.out.println("종료");
	}

	// 통계
	private static void studentStats(List<Student> list) {
		sc.nextLine();
		System.out.println("|최고점수입렵.1|최저점수입력.2|");
		int data = sc.nextInt();

		if (data < 1 || data > 2) {
			System.out.println("1~2번 입력요망");
			return;
		}
		if (data == 1) {
			System.out.println(Collections.max(list));

		} else {
			System.out.println(Collections.min(list));
		}

	}

	// 정렬
	private static void studentSort(List<Student> list) {
		sc.nextLine();

		System.out.println("오름차순 : 1 | 내림차순 : 2>>");
		int sort = sc.nextInt();

		if (sort < 1 || sort > 2) {
			System.out.println("1~2번에서 입력요망");
		}

		for (int i = 0; i < list.size(); i++) {
			if (sort == 1) {
				list.sort(Comparator.naturalOrder());
				list.get(i).setRank(list.size() - i);
			} else {
				list.sort(Comparator.reverseOrder());
				list.get(i).setRank(i + 1);
			}

		}
	}

	// 검색
	private static void studentSearch(List<Student> list) {
		sc.nextLine();
		System.out.print("검색할 학생 번호>>");
		String no = sc.nextLine();
		boolean flag = false;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo().equals(no)) {
				System.out.println("<<" + no + "학생정보>>");
				System.out.println(list.get(i));
				flag = true;
				break;
			}
		}

		if (flag == false) {
			System.out.println(no + " 번호는 없는 학생입니다.");
			return;
		}
	}

	// 수정
	private static void studentUpdate(List<Student> list) {
		sc.nextLine();
		System.out.print("수정할 학생 번호>>");
		String no = sc.nextLine();
		boolean flag = false;
		int index = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo().equals(no)) {
				System.out.println("<<" + no + "학생정보>>");
				System.out.println(list.get(i));
				index = i;
				flag = true;
				break;
			}
		}

		if (flag == false) {
			System.out.println(no + " 번호는 없는 학생입니다.");
			return;
		}

		System.out.println("국어 입력 >>");
		int kor = sc.nextInt();
		list.get(index).setKor(kor);
		System.out.println("영어 입력 >>");
		int eng = sc.nextInt();
		list.get(index).setEng(eng);
		System.out.println("수학 입력 >>");
		int math = sc.nextInt();
		list.get(index).setMath(math);
		
		Student st = list.get(list.size() - 1);

		st.calTotal();
		st.calAvr();
		st.calGrade();
	}

	// 삭제
	private static void studentDelete(List<Student> list) {
		sc.nextLine();
		System.out.println("삭제할 학생번호>>");
		String Delete = sc.nextLine();
		boolean flag = false;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo().equals(Delete)) {
				System.out.println("삭제되었습니다.");
				list.remove(i);
				break;

			}
		}
		if (flag == true) {
			System.out.println(Delete + "없는 번호입니다.");
			return;
		}
	}

	// 출력
	private static void studintOutput(List<Student> list) {
		for (Student student : list) {
			System.out.println(student);
		}

	}

	// 입력
	private static void studentInput(List<Student> list) {

		int level = (int) (Math.random() * (3 - 1 + 1) + (1));
		int whatClass = (int) (Math.random() * (9 - 1 + 1) + (1));
		int classNumber = (int) (Math.random() * (30 - 1 + 1) + (1));
		String no = String.format("%02d%02d%02d", level, whatClass, classNumber);

		RandomValue rn = new RandomValue();
		String name = rn.randomName2();
		boolean gender = (int) (Math.random() * (1 - 0 + 1) + (0)) == 0 ? true : false;

		int kor = (int) (Math.random() * (100 - 0 + 1) + (0));
		int eng = (int) (Math.random() * (100 - 0 + 1) + (0));
		int math = (int) (Math.random() * (100 - 0 + 1) + (0));

		list.add(new Student(no, name, gender, kor, eng, math));

		Student st = list.get(list.size() - 1);

		st.calTotal();
		st.calAvr();
		st.calGrade();
	}

	public static int displayMenu() {
		System.out.println("1.입력|2.수정|3.검색|4.삭제|5.출력|6.정렬|7.통계|8.종료| \n입력>>");
		int num = sc.nextInt();
		return num;
	}

}
