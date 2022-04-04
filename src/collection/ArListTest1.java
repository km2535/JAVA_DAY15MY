package collection;

import java.util.ArrayList;

public class ArListTest1 {
	public static void main(String[] args) {
//		ArrayList클래스는 제너릭으로 만들어져 있어 타입을 정해야 한다.
		ArrayList<String> arr1 = new ArrayList<String>();
//		이미 toString이 재정의 되어 있어 보기 편하다., 값을 넣지 않으면 빈배열을 반환한다.
		System.out.println(arr1);
//		배열의 추가 
		arr1.add("Hellow");
		arr1.add("Java");
		arr1.add("Is");
		arr1.add("Sweet");
		arr1.add("Language");
		System.out.println(arr1);
//		ArrayList의 요소를 수정할 수 있다.
		arr1.set(2, "is");
		System.out.println(arr1);
//		arr요소 전부 가져오기 
//		arrayList는 length를 사용하지 못한다. 대신 size라는 메소드를 이용한다.
//		또한 배열을 가져오기위해 get이라는 메소드를 이용한다.
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}
//		배열 삭제, 배열 삭제는 index와 object로 삭제가 가능하다 . \
		arr1.remove(2);
		arr1.remove("Sweet");
		System.out.println(arr1);
		
	}
}
