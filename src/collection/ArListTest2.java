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
	
	@Override
	public int hashCode() {
	return this.userid.length();
	}
	
}