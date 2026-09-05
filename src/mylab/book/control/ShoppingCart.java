package mylab.book.control;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ShoppingCart {
	//장바구니에 담긴 출판물 목록
	private List<Publication> items;

	public ShoppingCart() {
		items = new ArrayList<>();
	}

	//장바구니에 출판물 추가
	public void addItem(Publication item) {
		items.add(item);
		System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
	}

	//제목으로 출판물 검색 후 제거
	public boolean removeItem(String title) {
		for (int i = 0; i < items.size(); i++) {
			Publication item = items.get(i);

			if(item.getTitle().equals(title)) {
				Publication removedItem = items.remove(i);
				System.out.println(removedItem.getTitle() + "이(가) 장바구니에서 제거되었습니다.");
				return true;
			}
		}

		System.out.println("해당 제목의 출판물을 찾을 수 없습니다.");
		return false;
	}

	//장바구니 전체 가격 계산
	public int calculateTotalPrice() {
		int totalPrice = 0;

		for (Publication item : items) {
			totalPrice += item.getPrice();
		}

		return totalPrice;
	}

	//출판물 타입에 따른 할인 가격 계산
	public int calculateDiscountedPrice() {
		int discountedPrice = 0;
 
		for (Publication item : items) {
			if(item instanceof Magazine) {
				discountedPrice += item.getPrice() * 0.9;
			}

			if(item instanceof Novel) {
				discountedPrice += item.getPrice() * 0.85;
			}

			if(item instanceof ReferenceBook) {
				discountedPrice += item.getPrice() * 0.8;
			}
		}

		return discountedPrice;
	}

	//장바구니 내용 출력
	public void displayCart() {
		DecimalFormat df = new DecimalFormat("#,###");

		System.out.println("====== 장바구니 내용 ======");

		int num = 1;

		for (Publication item : items) {
			System.out.println(num + ". " + item.getTitle()	+ " - " + df.format(item.getPrice()) + "원");
			num++;
		}

		System.out.println("총 가격: " 	+ df.format(calculateTotalPrice()) + "원");
		System.out.println("할인 적용 가격: " + calculateDiscountedPrice() + "원");
	}

	//장바구니 출판물 통계 출력
	public void printStatistics() {
		int magazineCount = 0;
		int novelCount = 0;
		int referenceBookCount = 0;

		for (Publication item : items) {
			if(item instanceof Magazine) {
				magazineCount++;
			}

			if(item instanceof Novel) {
				novelCount++;
			}

			if(item instanceof ReferenceBook) {
				referenceBookCount++;
			}
		}

		System.out.println("====== 장바구니 통계 ======");
		System.out.println("잡지: " + magazineCount + "권");
		System.out.println("소설: " + novelCount + "권");
		System.out.println("참고서: " + referenceBookCount + "권");
		System.out.println("총 출판물: " + items.size() + "권");
	}

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		//출판물 객체 생성
		Publication pub1 = new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월");
		Publication pub2 = new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월");
		Publication pub3 = new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설");
		Publication pub4 = new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설");
		Publication pub5 = new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학");

		//장바구니에 출판물 추가
		cart.addItem(pub1);
		cart.addItem(pub2);
		cart.addItem(pub3);
		cart.addItem(pub4);
		cart.addItem(pub5);

		//장바구니 내용과 통계 출력
		cart.displayCart();
		cart.printStatistics();

		//빠삐용 제거 후 장바구니 다시 출력
		cart.removeItem("빠삐용");
		cart.displayCart();
	}
}