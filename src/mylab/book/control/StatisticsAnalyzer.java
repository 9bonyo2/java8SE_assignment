package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

	//타입별 평균 가격 계산
	public Map<String, Double> calculateAveragePriceByType(Publication[] pubs) {
		Map<String, Double> totalPrices = new HashMap<>();
		Map<String, Integer> typeCounts = new HashMap<>();

		for (Publication pub : pubs) {
			String type = getPublicationType(pub);

			totalPrices.put(type, totalPrices.getOrDefault(type, 0.0) + pub.getPrice());
			typeCounts.put(type, typeCounts.getOrDefault(type, 0) + 1);
		}

		Map<String, Double> averagePrices = new HashMap<>();

		for (String type : totalPrices.keySet()) {
			double average = totalPrices.get(type) / typeCounts.get(type);
			averagePrices.put(type, average);
		}

		return averagePrices;
	}

	//출판물 유형별 분포 계산
	public Map<String, Double> calculatePublicationDistribution(Publication[] pubs) {

		Map<String, Integer> typeCounts = new HashMap<>();

		for (Publication pub : pubs) {
			String type = getPublicationType(pub);

			typeCounts.put(type, typeCounts.getOrDefault(type, 0) + 1);
		}

		Map<String, Double> distribution = new HashMap<>();

		for (String type : typeCounts.keySet()) {
			double ratio = (double)typeCounts.get(type)	/ pubs.length * 100;
			distribution.put(type, ratio);
		}

		return distribution;
	}

	//특정 연도에 출판된 출판물 비율 계산
	public double calculatePublicationRatioByYear(Publication[] pubs, String year) {

		int yearCount = 0;

		for (Publication pub : pubs) {
			if(pub.getPublishingDate().startsWith(year)) {
				yearCount++;
			}
		}

		return (double)yearCount / pubs.length * 100;
	}

	//출판물의 실제 타입 확인
	private String getPublicationType(Publication pub) {
		if(pub instanceof Novel) {
			return "소설";
		}

		if(pub instanceof Magazine) {
			return "잡지";
		}

		if(pub instanceof ReferenceBook) {
			return "참고서";
		}

		return "기타";
	}

	//출판물 통계 출력
	public void printStatistics(Publication[] pubs) {
		DecimalFormat df = new DecimalFormat("#,###.##");

		Map<String, Double> averagePrices =	calculateAveragePriceByType(pubs);
		Map<String, Double> distribution = calculatePublicationDistribution(pubs);

		System.out.println("===== 출판물 통계 분석 =====");

		System.out.println("1. 타입별 평균 가격:");
		System.out.println("   - 소설: "	+ df.format(averagePrices.get("소설")) + "원");
		System.out.println("   - 참고서: " + df.format(averagePrices.get("참고서")) + "원");
		System.out.println("   - 잡지: "	+ df.format(averagePrices.get("잡지")) + "원");

		System.out.println("2. 출판물 유형 분포:");
		System.out.println("   - 소설: "	+ df.format(distribution.get("소설")) + "%");
		System.out.println("   - 참고서: " + df.format(distribution.get("참고서")) + "%");
		System.out.println("   - 잡지: "	+ df.format(distribution.get("잡지")) + "%");

		double yearRatio =	calculatePublicationRatioByYear(pubs, "2007");

		System.out.println("3. 2007년에 출판된 출판물 비율: " + df.format(yearRatio) + "%");
	}
}