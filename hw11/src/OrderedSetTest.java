import static org.junit.Assert.*;

import org.junit.Test;

public class OrderedSetTest {

	@Test
	public void insertAndSizeTest() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		assertEquals(0, set.size());
		set.insert(50);
		assertEquals(1, set.size());
		set.insert(50);
		assertEquals(1, set.size());
		set.insert(44);
		assertEquals(2, set.size());
		set.insert(66);
		assertEquals(3, set.size());
		set.insert(33);
		assertEquals(4, set.size());
		set.insert(48);
		assertEquals(5, set.size());
		set.insert(60);
		assertEquals(6, set.size());
	}

	@Test
	public void toStringInorderTest() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		assertEquals("", set.toStringInorder());
		set.insert(50);
		set.insert(50);
		set.insert(44);
		set.insert(66);
		set.insert(33);
		set.insert(48);
		set.insert(60);
		assertEquals("33 44 48 50 60 66", set.toStringInorder());
	}

	@Test
	public void toStringPreorderTest() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		assertEquals("", set.toStringPreorder());
		set.insert(50);
		set.insert(50);
		set.insert(44);
		set.insert(66);
		set.insert(33);
		set.insert(48);
		set.insert(60);
		assertEquals("50 44 33 48 66 60", set.toStringPreorder());
	}

	@Test
	public void toStringPostorderTest() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		assertEquals("", set.toStringPostorder());
		set.insert(50);
		set.insert(50);
		set.insert(44);
		set.insert(66);
		set.insert(33);
		set.insert(48);
		set.insert(60);
		assertEquals("33 48 44 60 66 50", set.toStringPostorder());
	}

	@Test
	public void containsTest() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		assertFalse(set.contains(44));
		set.insert(50);
		assertFalse(set.contains(44));
		assertTrue(set.contains(50));
		set.insert(44);
		set.insert(66);
		set.insert(33);
		set.insert(48);
		assertTrue(set.contains(48));
		set.insert(60);
		assertTrue(set.contains(33));
		assertTrue(set.contains(44));
		assertTrue(set.contains(48));
		assertTrue(set.contains(50));
		assertTrue(set.contains(60));
		assertTrue(set.contains(66));
		assertFalse(set.contains(100));
	}

	@Test
	public void maxTest() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		assertNull(set.max());
		set.insert(50);
		set.insert(44);
		assertEquals(50, set.max().intValue());
		set.insert(66);
		set.insert(33);
		set.insert(48);
		set.insert(60);
		assertEquals(66, set.max().intValue());
	}

	@Test
	public void nodesAtLevelTest1() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		assertEquals(0, set.nodesAtLevel(0));
		assertEquals(0, set.nodesAtLevel(-1));
		assertEquals(0, set.nodesAtLevel(-2));
		assertEquals(0, set.nodesAtLevel(1));
		set.insert(50);
		assertEquals(1, set.nodesAtLevel(0));
		set.insert(44);
		assertEquals(1, set.nodesAtLevel(0));
		assertEquals(1, set.nodesAtLevel(1));
		assertEquals(0, set.nodesAtLevel(-1));
		assertEquals(0, set.nodesAtLevel(-2));
		set.insert(66);
		assertEquals(1, set.nodesAtLevel(0));
		assertEquals(2, set.nodesAtLevel(1));
		set.insert(33);
		assertEquals(1, set.nodesAtLevel(0));
		assertEquals(2, set.nodesAtLevel(1));
		assertEquals(1, set.nodesAtLevel(2));
		set.insert(48);
		assertEquals(2, set.nodesAtLevel(2));
		set.insert(60);
		assertEquals(3, set.nodesAtLevel(2));
		assertEquals(0, set.nodesAtLevel(3));
		assertEquals(0, set.nodesAtLevel(4));
		set.insert(70);
		assertEquals(4, set.nodesAtLevel(2));
	}
	
	@Test
	public void nodesAtLevelTestNull() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		assertEquals(0, set.nodesAtLevel(0));
	}
	
	@Test
	public void nodesAtLevelTest2() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		assertEquals(0, set.nodesAtLevel(0));
		assertEquals(0, set.nodesAtLevel(1));
		set.insert(50);
		assertEquals(1, set.nodesAtLevel(0));
		set.insert(66);
		assertEquals(1, set.nodesAtLevel(0));
		assertEquals(1, set.nodesAtLevel(1));
	}
	
	@Test
	public void nodesAtLevelTest3() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(4);
		set.insert(3);
		set.insert(1);
		set.insert(9);
		set.insert(5);
		set.insert(11);
		assertEquals(1, set.nodesAtLevel(0));
		assertEquals(2, set.nodesAtLevel(1));
		assertEquals(3, set.nodesAtLevel(2));
		assertEquals(0, set.nodesAtLevel(3));
	}

	@Test
	public void intersectionTest1() {
		OrderedSet<Integer> set1 = new OrderedSet<Integer>();
		set1.insert(50);
		set1.insert(44);
		set1.insert(66);
		set1.insert(33);
		set1.insert(48);
		set1.insert(60);

		OrderedSet<Integer> set2 = new OrderedSet<Integer>();
		set2.insert(50);
		set2.insert(47);
		set2.insert(68);
		set2.insert(33);
		set2.insert(44);
		set2.insert(88);
		set2.insert(89);
		set2.insert(91);
		set2.insert(1);

		OrderedSet<Integer> set3 = set1.intersection(set2);
		System.out.println(set3.toStringInorder());
	}

	@Test
	public void intersectionTestWhenSet2IsEmpty() {
		OrderedSet<Integer> set1 = new OrderedSet<Integer>();
		set1.insert(50);
		set1.insert(44);
		set1.insert(66);
		set1.insert(33);
		set1.insert(48);
		set1.insert(60);

		OrderedSet<Integer> set2 = new OrderedSet<Integer>();

		OrderedSet<Integer> set3 = set1.intersection(set2);
		assertEquals("", set3.toStringInorder());
	}

	@Test
	public void intersectionTestWhenSet1IsEmpty() {
		OrderedSet<Integer> set1 = new OrderedSet<Integer>();

		OrderedSet<Integer> set2 = new OrderedSet<Integer>();
		set2.insert(50);
		set2.insert(47);
		set2.insert(68);
		set2.insert(33);
		set2.insert(44);
		set2.insert(88);
		set2.insert(89);
		set2.insert(91);
		set2.insert(1);

		OrderedSet<Integer> set3 = set1.intersection(set2);
		assertEquals("", set3.toStringInorder());
	}

	@Test
	public void intersectionTestWhenBothAreEmpty() {
		OrderedSet<Integer> set1 = new OrderedSet<Integer>();

		OrderedSet<Integer> set2 = new OrderedSet<Integer>();

		OrderedSet<Integer> set3 = set1.intersection(set2);
		assertEquals("", set3.toStringInorder());
	}

	@Test
	public void intersectionTestWhenNoCommonElement() {
		OrderedSet<Integer> set1 = new OrderedSet<Integer>();
		set1.insert(50);
		set1.insert(44);
		set1.insert(66);
		set1.insert(33);
		set1.insert(48);
		set1.insert(60);

		OrderedSet<Integer> set2 = new OrderedSet<Integer>();
		set2.insert(51);
		set2.insert(47);
		set2.insert(68);
		set2.insert(34);
		set2.insert(43);
		set2.insert(88);
		set2.insert(89);
		set2.insert(91);
		set2.insert(1);

		OrderedSet<Integer> set3 = set1.intersection(set2);
		assertEquals("", set3.toStringInorder());
	}

	@Test
	public void sameStructureTestWhenBothEmpty() {
		OrderedSet<Integer> set1 = new OrderedSet<Integer>();
		OrderedSet<Integer> set2 = new OrderedSet<Integer>();
		assertTrue(set1.sameStructure(set2));
	}

	@Test
	public void sameStructureTestWhenOneIsEmpty() {
		OrderedSet<Integer> set1 = new OrderedSet<Integer>();
		OrderedSet<Integer> set2 = new OrderedSet<Integer>();
		set2.insert(51);
		set2.insert(47);
		set2.insert(68);
		set2.insert(34);
		set2.insert(43);
		set2.insert(88);
		set2.insert(89);
		set2.insert(91);
		set2.insert(1);
		assertFalse(set1.sameStructure(set2));

		OrderedSet<Integer> set3 = new OrderedSet<Integer>();
		OrderedSet<Integer> set4 = new OrderedSet<Integer>();
		set3.insert(51);
		set3.insert(47);
		set3.insert(68);
		set3.insert(34);
		set3.insert(43);
		set3.insert(88);
		set3.insert(89);
		set3.insert(91);
		set3.insert(1);
		assertFalse(set3.sameStructure(set4));
	}

	@Test
	public void sameStructureTestWhenStructuresAreDifferent() {
		OrderedSet<Integer> set1 = new OrderedSet<Integer>();
		OrderedSet<Integer> set2 = new OrderedSet<Integer>();

		set1.insert(50);
		set1.insert(44);
		set1.insert(66);
		set1.insert(33);
		set1.insert(48);
		set1.insert(60);

		set2.insert(51);
		set2.insert(47);
		set2.insert(68);
		set2.insert(34);
		set2.insert(43);
		set2.insert(88);
		set2.insert(89);
		set2.insert(91);
		set2.insert(1);

		assertFalse(set1.sameStructure(set2));
	}

	@Test
	public void sameSturctureTestWhenBothHave1Node() {
		OrderedSet<Integer> set1 = new OrderedSet<Integer>();
		OrderedSet<Integer> set2 = new OrderedSet<Integer>();
		set1.insert(1);
		set2.insert(2);
		assertTrue(set1.sameStructure(set2));
	}

	@Test
	public void sameStructurePass() {
		OrderedSet<Integer> set1 = new OrderedSet<Integer>();
		OrderedSet<Integer> set2 = new OrderedSet<Integer>();

		set1.insert(50);
		set1.insert(44);
		set1.insert(66);
		set1.insert(33);
		set1.insert(48);
		set1.insert(70);

		set2.insert(100);
		set2.insert(75);
		set2.insert(125);
		set2.insert(50);
		set2.insert(85);
		set2.insert(140);

		assertTrue(set1.sameStructure(set2));
	}

	@Test
	public void sameStructureFail1() {
		OrderedSet<Integer> set1 = new OrderedSet<Integer>();
		OrderedSet<Integer> set2 = new OrderedSet<Integer>();

		set1.insert(50);
		set1.insert(44);
		set1.insert(66);
		set1.insert(33);
		set1.insert(48);
		set1.insert(70);

		set2.insert(100);
		set2.insert(75);
		set2.insert(125);
		set2.insert(50);
		set2.insert(110);
		set2.insert(140);

		assertFalse(set1.sameStructure(set2));
	}

	@Test
	public void sameStructureFail2() {
		OrderedSet<Integer> set1 = new OrderedSet<Integer>();
		OrderedSet<Integer> set2 = new OrderedSet<Integer>();

		set1.insert(50);
		set1.insert(44);
		set1.insert(66);
		set1.insert(33);
		set1.insert(55);
		set1.insert(70);

		set2.insert(100);
		set2.insert(75);
		set2.insert(125);
		set2.insert(50);
		set2.insert(85);
		set2.insert(140);

		assertFalse(set1.sameStructure(set2));
	}

	@Test
	public void testFailedThoseGreaterThanWhenThereShouldBeThree() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(50);
		bst.insert(25);
		bst.insert(12);
		bst.insert(75);
		bst.insert(65);
		bst.insert(90);
		assertEquals("12 25 50 65 75 90", bst.toStringInorder());
		assertEquals("12 25", bst.subSet(1, 49).toStringInorder());
		assertEquals("25 50 65", bst.subSet(25, 75).toStringInorder());
	}

	@Test
	public void subSetTestWhenEmptySet() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();

		assertEquals("", bst.subSet(1, 49).toStringInorder());
		assertEquals("", bst.subSet(25, 75).toStringInorder());
	}

	@Test
	public void subSetTestWhenAllAreIncluded() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(50);
		bst.insert(25);
		bst.insert(12);
		bst.insert(75);
		bst.insert(65);
		bst.insert(90);
		assertEquals("12 25 50 65 75 90", bst.toStringInorder());
		assertEquals("12 25 50 65 75 90", bst.subSet(12, 91).toStringInorder());
	}

	@Test
	public void subSetTestBoundaryConditions() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(50);
		bst.insert(25);
		bst.insert(12);
		bst.insert(75);
		bst.insert(65);
		bst.insert(90);
		assertEquals("12 25 50 65 75 90", bst.toStringInorder());
		assertEquals("12", bst.subSet(12, 25).toStringInorder());
		assertEquals("12", bst.subSet(11, 25).toStringInorder());
		assertEquals("", bst.subSet(13, 25).toStringInorder());
	}

	@Test
	public void testInsertSizeAndTostringinorder() {
		OrderedSet<String> bst = new OrderedSet<String>();
		assertEquals("", bst.toStringInorder());
		assertTrue(bst.insert("d"));
		assertTrue(bst.insert("b"));
		assertTrue(bst.insert("e"));
		assertFalse(bst.insert("e"));
		assertTrue(bst.insert("a"));
		assertEquals(4, bst.size());
		assertEquals("a b d e", bst.toStringInorder());
	}
	
	@Test
	public void removeTestWhenEmptySet() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		assertFalse(set.remove(44));
		assertEquals("", set.toStringInorder());
	}
	
	@Test
	public void removeTestWhenElementNotFound() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(25);
		set.insert(12);
		set.insert(75);
		set.insert(65);
		set.insert(90);
		assertFalse(set.remove(44));
		assertEquals("12 25 50 65 75 90", set.toStringInorder());
	}
	
	@Test
	public void removeTestWhenRootRemovedAndHasNoLeftChild() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(75);
		set.insert(65);
		set.insert(90);
		assertTrue(set.remove(50));
		assertEquals("65 75 90", set.toStringInorder());
	}
	
	@Test
	public void removeTestWhenNotRootNoLeftChild1() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(25);
		set.insert(12);
		set.insert(75);
		set.insert(80);
		set.insert(95);
		set.insert(99);
		assertTrue(set.remove(95));
		assertEquals("12 25 50 75 80 99", set.toStringInorder());
	}
	
	@Test
	public void removeTestWhenNotRootNoLeftChild2() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(25);
		set.insert(12);
		set.insert(75);
		set.insert(80);
		set.insert(78);
		set.insert(79);
		assertTrue(set.remove(78));
		assertEquals("12 25 50 75 79 80", set.toStringInorder());
	}
	
	@Test
	public void removeTestWhenRootAndLeftChild() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(25);
		set.insert(12);
		set.insert(75);
		set.insert(80);
		set.insert(78);
		set.insert(79);
		assertTrue(set.remove(50));
		assertEquals("12 25 75 78 79 80", set.toStringInorder());
	}
	
	@Test
	public void removeTestWhenNotRootAndLeftChild1() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(25);
		set.insert(30);
		set.insert(75);
		set.insert(80);
		set.insert(95);
		set.insert(99);
		set.insert(85);
		set.insert(82);
		set.insert(90);
		set.insert(87);
		assertTrue(set.remove(95));
		assertEquals("25 30 50 75 80 82 85 87 90 99", set.toStringInorder());
	}
	
	@Test
	public void removeTestWhenNotRootAndLeftChild2() {
		OrderedSet<Integer> set = new OrderedSet<Integer>();
		set.insert(50);
		set.insert(25);
		set.insert(30);
		set.insert(75);
		set.insert(80);
		set.insert(95);
		set.insert(99);
		set.insert(85);
		set.insert(82);
		assertTrue(set.remove(95));
		assertEquals("25 30 50 75 80 82 85 99", set.toStringInorder());
	}
}
