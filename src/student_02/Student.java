package student_02;

import java.util.Objects;

public class Student implements Comparable<Student> {
	// �ʵ�(�й�,�̸�,����,����,����,����,����,���,���,���), �θ���(�����)
	public static double SU = 3.0;
	private String no;
	private String name;
	private boolean gender;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double avr;
	private String grade;
	private int rank;

	// ������(�Ż�(�й�,�̸�,����,����,����,����))
	public Student(String no, String name, boolean gender, int kor, int eng, int math) {
		this.no = no;
		this.name = name;
		this.gender = gender;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	// �޼ҵ�(����,���,���)
	public void calTotal() {
		this.total = this.kor + this.eng + this.math;
	}

	public void calAvr() {
		String data = String.format("%.2f", (double) this.total / SU);
		this.avr = Double.parseDouble(data);
	}

	public void calGrade() {
		if (this.avr >= 90) {
			this.grade = "A";
		} else if (this.avr >= 80) {
			this.grade = "B";
		} else if (this.avr >= 70) {
			this.grade = "C";
		} else if (this.avr >= 60) {
			this.grade = "D";
		} else {
			this.grade = "F";

		}
	}

	// �޼ҵ�(get,set)
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public double getAvr() {
		return avr;
	}

	public void setAvr(double avr) {
		this.avr = avr;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	// �޼ҵ�(plint)
	@Override
	public String toString() {
		char charValue = this.gender == true ? '��' : '��';
		System.out.println(
				"=============================================================================================================");
		return "�л���ȣ : " + no + "\t�̸� : " + name + "\t���� : " + charValue + "\n| ���� : " + kor + "\t| ���� : " + eng
				+ "\t| ���� : " + math + "\t| ���� : " + total + "\t| ��� : " + avr + "\t| ��� : " + grade + "\t| ��� : "
				+ rank + "|";

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student student = (Student) obj;
			return this.no.equals(student.no);
		}
		return false;
	}

	@Override
	public int hashCode() {

		return Objects.hash(this.no);
	}

	@Override
	public int compareTo(Student o) {
		return this.total - (o.total);
	}

}
