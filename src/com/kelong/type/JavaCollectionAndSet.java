package com.kelong.type;

import java.util.HashSet;
import java.util.Iterator;

import com.kelong.type.JavaCollectionAndSet.Person;

/*
 * #####Collection#####
 * 
 * #####Set#####
 */
public class JavaCollectionAndSet {
	public static void test() {
		testHashSet();
	}

	//////////////Collection///////////////
	///Collection-Set-HashSet
	public static void testHashSet() {
		HashSet<Person> hs = new HashSet<Person>();
		boolean b = hs.add(new Person("li", 1));
		b = hs.add(new Person("li", 1));  			///add
		hs.add(new Person("li", 2));
		System.out.println(hs.size());
		
		HashSet<Person> hs1 = new HashSet<Person>();
		hs1.add(new Person("xx", 1));
		hs1.add(new Person("xx2", 1));
		hs.addAll(hs1);             			 	///addAll
		System.out.println(hs.containsAll(hs1));  	///containsAll
		System.out.println(hs.size());
		Iterator<Person> i = hs.iterator();   		///遍历Iterator
		while(i.hasNext()) {
			System.out.println(i.next().toString());
		}
		Object[] pArray = hs.toArray();  			///toArray
		System.out.println("*****************Array:");
		for(Object p : pArray) {
			System.out.println(p.toString());
		}
		Person pt = new Person("li", 1);
		System.out.println(hs.contains(pt));        ///contains
		hs.remove(pt);					 			////remove
		System.out.println("******************");
		for(Person p : hs) {                  		///遍历 for
			System.out.println(p.toString());
		}
		System.out.println("******************");
		hs.removeAll(hs1);      					///removeAll
		for(Person p : hs) {                  		///遍历 for
			System.out.println(p.toString());
		}
		hs.clear();             					///clear
		System.out.println(hs.size());
		System.out.println(hs.isEmpty());  			///isEmpty
		
		HashSet<String> hsS = new HashSet<String>();
		boolean add = hsS.add("1");
		System.out.println(add);
		add = hsS.add("1");
		System.out.println(add);
		System.out.println(hsS.size());
	}
	///Collection-Set-TreeSet
	public static void TestTreeSet() {
//		boolean                   add(E object)
//		boolean                   addAll(Collection<? extends E> collection)
//		void                      clear()
//		Object                    clone()
//		boolean                   contains(Object object)
//		E                         first()
//		boolean                   isEmpty()
//		E                         last()
//		E                         pollFirst()
//		E                         pollLast()
//		E                         lower(E e)
//		E                         floor(E e)
//		E                         ceiling(E e)
//		E                         higher(E e)
//		boolean                   remove(Object object)
//		int                       size()
//		Comparator<? super E>     comparator()
//		Iterator<E>               iterator()
//		Iterator<E>               descendingIterator()
//		SortedSet<E>              headSet(E end)
//		NavigableSet<E>           descendingSet()
//		NavigableSet<E>           headSet(E end, boolean endInclusive)
//		SortedSet<E>              subSet(E start, E end)
//		NavigableSet<E>           subSet(E start, boolean startInclusive, E end, boolean endInclusive)
//		NavigableSet<E>           tailSet(E start, boolean startInclusive)
//		SortedSet<E>              tailSet(E start)
	}
	
	public static void testArrayList() {
		
	}

	public static void testLinkedList() {
		
	}

	public static void testVector() {
		
	}
	
	//////////////Map///////////////
	
	public static void testHashMap() {
		
	}
	
	public static void testTreeMap() {
		
	}
	
	public static void testHashTable() {
		
	}
	
	
	
	static class Person {
		private String name;
		private int age;
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
		public String toString() {
			return "name: " + name + ", age: " + age;
		}
		//重写 Object 方法，set.add 时查找是否有相同的元素，先后调用 hasCode，equals
		public int hashCode() {
			return name.hashCode() + age;
		}
		// z作为
		public boolean equals(Object ob) {
			Person p = (Person)ob;
			return p.name.equals(name) && p.age == age;
		}
	}
}
/*
Collection: -每个位置只能保存一个元素（对象）
	一组“对立”的元素，通常这些元素都符合某些规则：
	1.List必须保持元素的特定顺序
	2.Set不能有重复元素
	3.Queue保持一个队列(先进先出)的顺序
Map: -保存键值对，可以通过“键”找到对应的“值”
	一组成对的“键值对”对象

List：元素有放入顺序，元素可重复。（注：可以用迭代器和 for 来遍历）
Set： 无序放入，不可重复，重复元素会覆盖掉。（注：元素虽然无放入顺序，但是元素在 set 中的位置是由 hasCode 决定的，其位置是固定的，加入 Set 的 object 必须定义equals() 方法；set 只能用迭代器来遍历）
List-Set:
	set:检索元素效率低下，删除，插入元素效率高，插入和删除不会引起元素位置变化。
	list:和数组类似，可以动态增长，查找元素效率高，插入/删除元素效率低，因为会引起其他元素位置改变。

Map: 适合存储键值对的数据

线程安全集合类和非线程安全集合类：
	LinkedList, ArrayList, HashSet 是非线程安全的；Vector 是线程安全的。
	HashMap 是非线程安全的；HashTable 是线程安全的。
	StringBuilder 是非线程安全的；StringBuffer 是线程安全的。
	
HashSet-TreeSet:
	HashSet:不能保存元素的排列顺序，顺序有可能发生变化。
			哈希表实现。
			不是同步的。
			集合元素可以是 null，但只能放入一个null-set 不重复特性。
	TreeSet:SortSet 的唯一实现类，可以确保集合元素处于排序状态（定制排序，自然排序<默认>）
			二叉树实现，不允许null值。
			自动排序好的。
	HashSet基于Hash算法实现，性能优于TreeSet。快速查找用HashSet，排序功能使用 TreeSet。
			
ArrayList-LinkedList:	
	ArrayList:	基于动态数组的数据结构，地址连续。查询效率高。
				插入/删除效率低。
				适合数据访问、查询。
	LinkedList:	基于链表数据结构，新增/删除速度快，适合头尾操作或插入指定位置的场景。
				查询操作性能低。
				适合数据操作，多次增删。
				
ArrayList-Vector:都是用数组实现的
	ArrayList:
	Vector:多线程安全的，类中很多方法有 synchronized 进行修饰，导致效率低于 ArrayList。老的动态数组，效率很低，不赞成用。
	如果集合中的元素的数目大于目前集合组的长度时，在集合中使用数据量比较大的数据，用 Vector 有一定的优势。
	两个都用线性连续空间存储，增加空间时，两个类的增长方式不同。
	Vector 可以设置增长因子，ArrayList 不可以。
	
HashMap-TreeMap-HashTable：
		HashMpa:基于哈希表实现，要求添加的键类明确定义了 hasCode() 和 equals() [可以重写 hasCode() 和 equals()]，为了优化 HashMap 空间的使用，可以调优初始容量和负载因子。
		TreeMap:非线程安全，基于红黑树实现。没有调优选项，因为该数总是处于平衡状态。
		HashMap-HashTable: HashMap 去掉了 HashTable 中的 contains方法，但加上了 containsValue() 和 containsKey() 方法。HashTable 是同步的，HashMap 非同步的，效率 HashMap 更高。HashMap 允许空键值，HashTable 不允许。
		HashMap: 适合插入，删除，定位元素。
		TreeMap: 适合用于自然顺序或自定义顺序遍历键(key)。 
*/