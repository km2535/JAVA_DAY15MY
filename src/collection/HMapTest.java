package collection;

import java.util.HashMap;

public class HMapTest {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
//		hashmap에 데이터 추가하기, add가 아닌 put메소드를 이용한다.
		map.put(1, "하나");
		map.put(2, "둘");
		map.put(3, "셋");
		map.put(4, "넷");
		map.put(5, "다섯");
		
//		hashmap의 데이터 수정하기
		map.put(3, "삼");
		
		System.out.println(map);
		
//		hashmap에서 요소 가져오기 get을 이용한다., 키값을 이용한다.
		System.out.println(map.get(2));
//		hashmap 요소 삭제하기 (키 값만 넘기는 경우) - value를 리턴 
		String map2 = map.remove(2);
//		기존 map 구조에서 제거가 되고 반환된 값을 따로 가져올 수 있다.
		System.out.println(map);
		System.out.println(map2);
//		hashmap 요소 삭제하기(키-값 둘다 넘기는 경우) - boolean타입 리턴
		Boolean map3 = map.remove(3, "삼");
		System.out.println(map);
		System.out.println(map3);
//		hashmap의 데이터 갯수(길이) - 한쌍을 하나로 셈
		System.out.println(map.size());
	}
}
