package com.wyx.lambdademo.CStream.收集器;

import org.apache.commons.collections.MapUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author : Just wyx
 * @Date : 2020/11/21
 */
public class DemoTest {

	private List<StudentDTOTest> students;
	@Before
	public void before() {
		StudentDTOTest student0 = new StudentDTOTest("周零", "清华大学", "男", 20, 95.5);
		StudentDTOTest student1 = new StudentDTOTest("郑一", "清华大学", "女", 22, 98.5);
		StudentDTOTest student2 = new StudentDTOTest("吴二", "北京大学", "男", 21, 95.5);
		StudentDTOTest student3 = new StudentDTOTest("张三", "复旦大学", "男", 24, 90.5);
		StudentDTOTest student4 = new StudentDTOTest("李四", "清华大学", "女", 22, 92.5);
		StudentDTOTest student5 = new StudentDTOTest("王五", "北京大学", "男", 20, 93.5);
		StudentDTOTest student6 = new StudentDTOTest("赵六", "清华大学", "男", 23, 96.5);
		StudentDTOTest student7 = new StudentDTOTest("钱七", "复旦大学", "女", 22, 97.5);
		StudentDTOTest student8 = new StudentDTOTest("秦八", "复旦大学", "男", 21, 99.5);
		StudentDTOTest student9 = new StudentDTOTest("段九", "北京大学", "女", 20, 92.5);

		students = Arrays.asList(student0,student1,student2,student3,
				student4,student5,student6,student7,student8,student9);
	}

	/**
	 * 可以将流中的元素转换为 List 或 Set 集合。
	 */
	@Test
	public void test1() {
		List<StudentDTOTest> collect = students.stream()
				.collect(Collectors.toList());
		System.out.println(collect);
	}

	/**
	 * 获取所有学生姓名列表
	 */
	@Test
	public void test2() {
		List<String> collect = students.stream()
				.map(StudentDTOTest::getName)
				.collect(Collectors.toList());
		System.out.println(collect);
	}

	/**
	 * 获取所有参赛院校名单
	 */
	@Test
	public void test3() {
		Set<String> collect = students.stream()
				.map(StudentDTOTest::getSchool)
				.collect(Collectors.toSet());
		System.out.println(collect);
	}

	/**
	 * 收集器默认使用的是无序的 HashSet，若要指定使用有序的 TreeSet，则可通过 toCollection()方法指定。
	 */
	@Test
	public void test4() {
		Set<String> collect = students.stream()
				.map(StudentDTOTest::getSchool)
				.collect(Collectors.toCollection(TreeSet::new));
		System.out.println(collect);
	}

	/*************************************  分组  *************************************/
	// 分组是指，按照流中指定的元素的属性值进行分组。

	/**
	 * 获取各个学校的学生，按照学校进行分组
	 */
	@Test
	public void test5() {
		Map<String, List<StudentDTOTest>> collect = students.stream()
				.collect(Collectors.groupingBy(StudentDTOTest::getSchool));
		MapUtils.verbosePrint(System.out, "学校", collect);
	}

	/**
	 * 统计各个学校参赛选手人数
	 */
	@Test
	public void test6() {
		Map<String, Long> collect = students.stream()
				.collect(Collectors.groupingBy(StudentDTOTest::getSchool, Collectors.counting()));
		MapUtils.verbosePrint(System.out, "学校", collect);
	}

	/*************************************  布尔分块  *************************************/
	// 布尔分块是按照指定断言的 true 与 false 结果进行分组，其只会划分为两组，且 key 只 能是 true 或 false。

	/**
	 * 按照性别对所有参赛选手分组
	 * 分组实现
	 */
	@Test
	public void test7() {
		Map<String, List<StudentDTOTest>> collect = students.stream()
				.collect(Collectors.groupingBy(StudentDTOTest::getGender));
		MapUtils.verbosePrint(System.out, "姓别", collect);
	}

	/**
	 * 按照性别对所有参赛选手分组
	 * 分块实现
	 */
	@Test
	public void test8() {
		Map<Boolean, List<StudentDTOTest>> collect = students.stream()
				.collect(Collectors.partitioningBy(s -> "男".equals(s.getGender())));
		MapUtils.verbosePrint(System.out, "姓别", collect);
	}

	/**
	 * 按分数分块
	 */
	@Test
	public void test9() {
		Map<Boolean, List<StudentDTOTest>> collect = students.stream()
				.collect(Collectors.partitioningBy(s -> s.getScore() > 95));
		MapUtils.verbosePrint(System.out, "95划分", collect);
	}

	/**
	 * 分块后求平均值
	 */
	@Test
	public void test10() {
		Map<Boolean, Double> collect = students.stream()
				.collect(Collectors.partitioningBy(s -> s.getScore() > 95, Collectors.averagingDouble(StudentDTOTest::getScore)));
		MapUtils.verbosePrint(System.out, "95划分", collect);
	}

	/**
	 * 获取汇总统计数据
	 */
	@Test
	public void test11() {
		DoubleSummaryStatistics collect = students.stream()
				.collect(Collectors.summarizingDouble(StudentDTOTest::getScore));
		System.out.println(collect);
	}
}
