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
			case 1:// �Է�
				studentInput(list);
				break;
			case 2:// ����
				studentUpdate(list);
				break;
			case 3:// �˻�
				studentSearch(list);
				break;
			case 4: // ����
				studentDelete(list);
				break;
			case 5: // ���
				studintOutput(list);
				break;
			case 6:// ����
				studentSort(list);
				break;
			case 7:// ���(�ְ�����,��������)
				studentStats(list);
				break;
			case 8:
				loopFlag = true;
				break;
			default:
				System.out.println("1~8�� �Է¿��");
				break;
			}
		}
		System.out.println("����");
	}

	// ���
	private static void studentStats(List<Student> list) {
		sc.nextLine();
		System.out.println("|�ְ������Է�.1|���������Է�.2|");
		int data = sc.nextInt();

		if (data < 1 || data > 2) {
			System.out.println("1~2�� �Է¿��");
			return;
		}
		if (data == 1) {
			System.out.println(Collections.max(list));

		} else {
			System.out.println(Collections.min(list));
		}

	}

	// ����
	private static void studentSort(List<Student> list) {
		sc.nextLine();

		System.out.println("�������� : 1 | �������� : 2>>");
		int sort = sc.nextInt();

		if (sort < 1 || sort > 2) {
			System.out.println("1~2������ �Է¿��");
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

	// �˻�
	private static void studentSearch(List<Student> list) {
		sc.nextLine();
		System.out.print("�˻��� �л� ��ȣ>>");
		String no = sc.nextLine();
		boolean flag = false;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo().equals(no)) {
				System.out.println("<<" + no + "�л�����>>");
				System.out.println(list.get(i));
				flag = true;
				break;
			}
		}

		if (flag == false) {
			System.out.println(no + " ��ȣ�� ���� �л��Դϴ�.");
			return;
		}
	}

	// ����
	private static void studentUpdate(List<Student> list) {
		sc.nextLine();
		System.out.print("������ �л� ��ȣ>>");
		String no = sc.nextLine();
		boolean flag = false;
		int index = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo().equals(no)) {
				System.out.println("<<" + no + "�л�����>>");
				System.out.println(list.get(i));
				index = i;
				flag = true;
				break;
			}
		}

		if (flag == false) {
			System.out.println(no + " ��ȣ�� ���� �л��Դϴ�.");
			return;
		}

		System.out.println("���� �Է� >>");
		int kor = sc.nextInt();
		list.get(index).setKor(kor);
		System.out.println("���� �Է� >>");
		int eng = sc.nextInt();
		list.get(index).setEng(eng);
		System.out.println("���� �Է� >>");
		int math = sc.nextInt();
		list.get(index).setMath(math);
		
		Student st = list.get(list.size() - 1);

		st.calTotal();
		st.calAvr();
		st.calGrade();
	}

	// ����
	private static void studentDelete(List<Student> list) {
		sc.nextLine();
		System.out.println("������ �л���ȣ>>");
		String Delete = sc.nextLine();
		boolean flag = false;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo().equals(Delete)) {
				System.out.println("�����Ǿ����ϴ�.");
				list.remove(i);
				break;

			}
		}
		if (flag == true) {
			System.out.println(Delete + "���� ��ȣ�Դϴ�.");
			return;
		}
	}

	// ���
	private static void studintOutput(List<Student> list) {
		for (Student student : list) {
			System.out.println(student);
		}

	}

	// �Է�
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
		System.out.println("1.�Է�|2.����|3.�˻�|4.����|5.���|6.����|7.���|8.����| \n�Է�>>");
		int num = sc.nextInt();
		return num;
	}

}
