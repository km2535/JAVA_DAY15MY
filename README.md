# JAVA_DAY15MY

## 컬렉션 프레임워크(Collection Framework)

많은 데이터들을 쉽고 효과적으로 관리할 수 있는 표준화된 방법을 제공하는 클래스 및 인터페이스의 집합
![](https://imagedelivery.net/v7-TZByhOiJbNM9RaUdzSA/25c4254f-f399-4023-270c-610d0086e200/public)

```java
public interface List<E> extends Collection<E>
```

- List의 구현클래스
  - ArrayList
  - LinkedList
  - Vector

```java
public interface SortedSet<E> extends Set<E>
```

- Set의 구현 클래스
  - HashSet
  - LikedHahSet
  - TreeSet

### ArrayList

- 컬렉션 클래스 중 가장 많이 사용되는 클래스, 배열을 이용해 값을 저장한다.
- 인덱스를 이용해서 각 요소에 빠르게 접근 가능하지만 크기를 변경시키기 위해서는 새로운 배열을 생성하고 기존의 값들을 옮겨야 함으로 느리다.
- 배열은 처음에 몇칸을 할당할지 고정하지만 ArrayList는 값을 넣는 만큼 자동으로 늘어난다.

ArrayList의 객체화

```java
ArrayList<String> arr1 = new ArrayList<String>();
```

```java
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
```

ArrayList의 동위객체를 다루는 방법

```java
package collection;

import java.util.ArrayList;

public class ArListTest2 {
	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(20);
		arr1.add(30);
		arr1.add(40);
		arr1.add(50);
		arr1.add(60);
		arr1.add(70);
		System.out.println(arr1);
//		arr1이 int형일때는 값을 삭제할 수 없다.
//		따라서 remove메소드를 보면 obj를 담으라고 되어 있는데 이는 업캐스팅이 될 수 있는 조건을 만들어야
//		컴퓨터가 obj로 된 remove메소드를 이용한다는 것을 간접적으로 알 수있다.
//		따라서 먼저 값을 박싱시켜서 remove매개변수로 넘겨주면 된다.
		arr1.remove((Integer)50);

//		user클래스를 따로 정의하면 아래와 같이 User타입으로 이용 가능하다.
		ArrayList<User> arr2  = new ArrayList<User>();
//		이때는 객체화 하면서 값을 담아주어야 한다,
		arr2.add(new User("apple"));
		arr2.add(new User("banana"));
		arr2.add(new User("cherry"));
		arr2.add(new User("apple"));
//		이때 출력해보면 객체의 주소값의 toString으로 출력되고 있다. 재정의를 따로 해주어야 한다.
//		재정의를 해주면 우리가 원하는 값을 볼 수 있다.
		System.out.println(arr2);
//		인덱스를 이용한 값 제가가 아닌 우리는 obj를 이용하여 값을 제거하고 싶다.
//		remove에 객체를 그대로 넘겨주면 삭제되지 않고 동위객체로 인식하고 서로 다른 객체로 인정한다.
//		즉, 그냥 remove에 객체를 넘기면 삭제가 안된다.
//		따라서 우리는 동위객체 또한 같은 값으로 인정하기 위한 재정의를 해야한다.
//		동위객체 비교메소드를 재정의 하고 나면 아래와 같이 사용가능하다.
		arr2.remove(new User("apple"));
//		동위객체 비교는 0번째 요소부터 검사한다.
		System.out.println(arr2);
	}
}

class User{
	String userid;

	public User(String userid) {
		this.userid = userid;
	}
//	위에서 보듯이 toString을 따로 재정의를 해주지 않으면 주소값과 관련된 값이 출력된다.
	@Override
	public String toString() {
		return "아이디 : " + this.userid;
	}
//	동위객체여부를 판단하는 메소드는 equals이다.
	@Override
//  여기 매개변수에는 우리가 정의한 User객체가 들어 올 것이다. Object는 모든 타입의 상위객체로 매개변수로 들어오면
//	업캐스팅이 발생한다.
	public boolean equals(Object obj) {
//		업캐스팅이 발생되면 들어온 인자가 User객체의 인스턴스에 포함되는지 여부를 다시 판단한다.
//		이때 들어온 객체는 User로 객체화 된 obj가 들어옴으로 참이다.
		if(obj instanceof User) {
//			업캐스팅된 객체를 다시 User로 다운캐스팅하여 target객체를 생성한다.
			User target = (User)obj;
//			기존에 객체화 된 값인 userid가 인자로 들어온 값의 userid가 같으면 값이 같다는 것임으로 true를 리턴
			if(this.userid.equals(target.userid)) {
				return true;
			}
		}
//		인스턴스 판단에 들어오지 못하면 전혀 다른 객체임으로 false를 리턴한다.
		return false;
	}

}
```

### HashSet

- Set은 집합이다. 중복되는 원소(요소, 값)을 담을 수 없다.
  저장된 값들은 인덱스가 없기 때문에 저장 순서가 고정되어 있지 ㅇ낳다.
- 값의 **중복 제거와 유무 검사 목적이 있다.**

- .iterator()
  - 순서가 없는 set타입의 요소에 순서를 부여해주는 기능을 담당한다.
  - 순서가 부여되면 값을을 .next()를 통해 하나씩 가져올 수 있다.
  - 리턴 타입은 Iterator<> 이다.
- Set은 검색의 목적이 있기 때문에 순서 정보를 관리할 필요가 없다.
  따라서 데이터의 크기에 상관없이 검색에 걸리는시간이 매우 짧다.
  반면 ArrayList는 인덱스를 관리해야 하기 때문에 상대적으로 시간이 오래 걸린다.
  기능적으로 HashSet과 ArrayList로 구현한 것이 차이가 없다면 HashSet을 이용하는 것이 좋다.

```java
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
```

### HashMap

- Map구조 : Key(키)와 Value(값)이 상으로 저장되는 형태, key-value구조
<table style="width:50%">
  <tr style="border:1px solid black; text-align:center">
    <th>&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;</th>
    <th>Key</th>
    <th>Value</th>
  </tr>
  <tr style="border:1px solid black; text-align:center">
    <td>Entry</td>
    <td>fly</td>
    <td>날다</td>
  </tr>
  <tr style="border:1px solid black; text-align:center">
    <td>Entry</td>
    <td>walk</td>
    <td>걷다</td>
  </tr>
  <tr style="border:1px solid black; text-align:center">
    <td>Entry</td>
    <td>...</td>
    <td>...</td>
  </tr>
</table>

- key와 value가 한 쌍(entry)로 저장된다. 그러므로 검색에 용이하다.
- Key는 중복이 불가능하며, Value는 가능하다.
  따라서 Key는 Set타입이고, Value는 Collection 타입이다.
- 키 <-> 해쉬테이블 <-> 값 (이 과정이 맵핑한다라는 거임)
- Map 자료구조는 순서를 따지지 않기 때문에 Key만 가져오기, Value만 가져오기는 안됨.

```java
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

```
