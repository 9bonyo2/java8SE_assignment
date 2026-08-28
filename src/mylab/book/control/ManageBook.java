package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ManageBook {

	public static void main(String[] args) {
		//Publication 타입 배열을 선언 및 생성
		Publication[] pubs = new Publication[7];

		pubs[0] = new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월");
		pubs[1] = new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월");
		pubs[2] = new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설");
		pubs[3] = new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설");
		pubs[4] = new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학");
		pubs[5] = new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설");
		pubs[6] = new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설");

		//도서 정보 출력
		System.out.println("==== 도서 정보 출력 ====");

		for (int i = 0; i < pubs.length; i++) {
			System.out.println((i + 1) + ". " + pubs[i]);
		}

		//가격 변경
		Publication pub = pubs[6];
		int oldPrice = pub.getPrice();

		System.out.println("==== 가격 변경 ====");
		System.out.println(pub.getTitle() + " 변경 전 가격: " + oldPrice + "원");

		modifyPrice(pub);

		System.out.println(pub.getTitle() + " 변경 후 가격: " + pub.getPrice() + "원");
		System.out.println("차액: "
				+ (oldPrice - pub.getPrice()) + "원");

		//통계 분석
		StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
		analyzer.printStatistics(pubs);
	}

	//다형적 아규먼트(Polymorphic Argument)
	public static void modifyPrice(Publication pub) {
		double rate = 0.0;

		if(pub instanceof Magazine) {
			rate = 0.6; //40% 할인
		}

		if(pub instanceof Novel) {
			rate = 0.8; //20% 할인
		}

		if(pub instanceof ReferenceBook) {
			rate = 0.9; //10% 할인
		}

		pub.setPrice((int)(pub.getPrice() * rate));
	}
}