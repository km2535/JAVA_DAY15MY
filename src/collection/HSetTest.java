package collection;

import java.util.HashSet;
import java.util.Iterator;

public class HSetTest {
	public static void main(String[] args) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		System.out.println(set1);
		set1.add(20);
		set1.add(10);
		set1.add(50);
		set1.add(30);
		set1.add(20);
//		중복된 값은 담기지 않는다.
		System.out.println(set1);
//		set은 size메소드를 그 크기를 알 수 있다.
		System.out.println(set1.size());
//		값의 유무를 파악하기 위한 목적으로 설계되어 있음으로 다음과 같이 유무를 확인 할 수 있다.
		System.out.println(set1.contains(20));
//		요소를 삭제하는 것은 인덱스가 없기 때문에 인덱스로 삭제하지 못하고 obj타입은 오토박싱으로 삭제된다.
		set1.remove(20);
		System.out.println(set1);
//		마찬가지로 ArrayList와 동일하게 사용자가 정의한 클래스타입을 이용할 수 있다. 
		HashSet<User> set2 = new HashSet<User>();
		set2.add(new User("apple"));
		set2.add(new User("banana"));
//		hashset은 중복된 값을 제거한다고 하였는데 동위객체는 hashCode를 가지고 있음으로 hashCode가 다르면
//		서로 다른 객체로 인식한다. 따라서 hashcode를 재정의하여 중복검사를 할 수 있다.
		set2.add(new User("apple"));
		System.out.println(set2);
//		HashSet으로 만든 객체는 iterator를 이용하여 순서대로 값을 사용 할 수 있다.
//		다만 사용하기 위해서는 기존에 만든 객체를 다시 Iterator 객체에 넣어주어야 한다.
		Iterator<User> iter = set2.iterator();
//		iter를 순서대로 사용하기 위해서는 다음과 같은 반복문을 사용한다.
//		다음 순서가 있는지 확인, 있다면 다음, 없으면 종료
		while(iter.hasNext()) {
//			다음 객체를 하나씩 가져온다.
			System.out.println(iter.next());
		}
//		반복문이 종료된 후 더이상의 값은 없음으로 바로 반복문을 사용하지 못한다.
//		대신 다시 iterator에 담아주고 사용한다.
		iter = set2.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
