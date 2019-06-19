package hashtable;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class HashTableTest {
	
	/* Testing Insert */
	
	@Test
	void testInsert1() {
		HashTable ht = new HashTable(5);
		
		assertArrayEquals(new Integer[] {null, null, null, null, null}, ht.toArray());
		ht.insert(0);
		assertArrayEquals(new Integer[] {0, null, null, null, null}, ht.toArray());
		ht.insert(1);
		assertArrayEquals(new Integer[] {0, 1, null, null, null}, ht.toArray());
		ht.insert(2);
		assertArrayEquals(new Integer[] {0, 1, 2, null, null, null, null, null, null, null}, ht.toArray());
		ht.insert(3);
		assertArrayEquals(new Integer[] {0, 1, 2, 3, null, null, null, null, null, null}, ht.toArray());
		ht.insert(4);
		assertArrayEquals(new Integer[] {0, 1, 2, 3, 4, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, ht.toArray());
	}
	
	@Test
	void testInsert2() {
		HashTable ht = new HashTable(5);
		
		assertArrayEquals(new Integer[] {null, null, null, null, null}, ht.toArray());
		ht.insert(-0);
		assertArrayEquals(new Integer[] {0, null, null, null, null}, ht.toArray());
		ht.insert(-101);
		assertArrayEquals(new Integer[] {0, -101, null, null, null}, ht.toArray());
		ht.insert(-202);
		assertArrayEquals(new Integer[] {0, -101, -202, null, null, null, null, null, null, null}, ht.toArray());
		ht.insert(-303);
		assertArrayEquals(new Integer[] {0, -101, -202, -303, null, null, null, null, null, null}, ht.toArray());
		ht.insert(-404);
		assertArrayEquals(new Integer[] {0, -101, -202, -303, -404, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, ht.toArray());
	}
	
	@Test
	void testInsert3() {
		HashTable ht = new HashTable(5);
		
		assertArrayEquals(new Integer[] {null, null, null, null, null}, ht.toArray());
		ht.insert(1);
		assertArrayEquals(new Integer[] {null, 1, null, null, null}, ht.toArray());
		ht.insert(2);
		assertArrayEquals(new Integer[] {null, 1, 2, null, null}, ht.toArray());
		ht.insert(3);
		assertArrayEquals(new Integer[] {null, 1, 2, 3, null, null, null, null, null, null}, ht.toArray());
		ht.insert(4);
		assertArrayEquals(new Integer[] {null, 1, 2, 3, 4, null, null, null, null, null}, ht.toArray());
		ht.insert(6);
		assertArrayEquals(new Integer[] {null, 1, 2, 3, 4, null, 6, null, null, null, null, null, null, null, null, null, null, null, null, null}, ht.toArray());
	}
	
	@Test
	void testInsertWithCollision1() {
		HashTable ht = new HashTable(10);
		
		assertArrayEquals(new Integer[] {null, null, null, null, null, null, null, null, null, null}, ht.toArray());
		ht.insert(0);
		assertArrayEquals(new Integer[] {0, null, null, null, null, null, null, null, null, null}, ht.toArray());
		ht.insert(10);
		assertArrayEquals(new Integer[] {0, 10, null, null, null, null, null, null, null, null}, ht.toArray());
		ht.insert(20);
		assertArrayEquals(new Integer[] {0, 10, 20, null, null, null, null, null, null, null}, ht.toArray());
		ht.insert(30);
		assertArrayEquals(new Integer[] {0, 10, 20, 30, null, null, null, null, null, null}, ht.toArray());
		ht.insert(40);
		assertArrayEquals(new Integer[] {0, 20, 40, null, null, null, null, null, null, null, 10, 30, null, null, null, null, null, null, null, null}, ht.toArray());
		ht.insert(50);
		assertArrayEquals(new Integer[] {0, 20, 40, null, null, null, null, null, null, null, 10, 30, 50, null, null, null, null, null, null, null}, ht.toArray());
		ht.insert(60);
		assertArrayEquals(new Integer[] {0, 20, 40, 60, null, null, null, null, null, null, 10, 30, 50, null, null, null, null, null, null, null}, ht.toArray());
		ht.insert(70);
		assertArrayEquals(new Integer[] {0, 20, 40, 60, null, null, null, null, null, null, 10, 30, 50, 70, null, null, null, null, null, null}, ht.toArray());
		ht.insert(80);
		assertArrayEquals(new Integer[] {0, 20, 40, 60, 80, null, null, null, null, null, 10, 30, 50, 70, null, null, null, null, null, null}, ht.toArray());
	}
	
	
	/* Testing Remove */
	
	@Test
	void testRemove1() {
		HashTable ht = new HashTable(5);
		
		ht.insert(0);
		ht.insert(101);
		ht.insert(202);
		ht.insert(303);
		ht.insert(404);
		
		ht.remove(101);
		
		assertArrayEquals(new Integer[] {0, null, 202, 303, 404, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, ht.toArray());
	}
	
	@Test
	void testRemove2() {
		HashTable ht = new HashTable(5);
		
		ht.insert(0);
		ht.insert(101);
		ht.insert(202);
		ht.insert(303);
		ht.insert(404);
		
		ht.remove(101);
		assertArrayEquals(new Integer[] {0, null, 202, 303, 404, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, ht.toArray());
		ht.insert(101);
		assertArrayEquals(new Integer[] {0, 101, 202, 303, 404, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, ht.toArray());
		ht.remove(101);
		assertArrayEquals(new Integer[] {0, null, 202, 303, 404, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, ht.toArray());
		ht.insert(101);
		assertArrayEquals(new Integer[] {0, 101, 202, 303, 404, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, ht.toArray());
	}
	
	@Test
	void testRemoveNoExistingEle1() {
		HashTable ht = new HashTable(5);
		
		ht.insert(0);
		ht.insert(101);
		ht.insert(202);
		ht.insert(303);
		ht.insert(404);
		
		ht.remove(102);
		
		assertArrayEquals(new Integer[] {0, 101, 202, 303, 404, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, ht.toArray());
	}
	
	@Test
	void testRemoveNoExistingEle2() {
		HashTable ht = new HashTable(5);
		
		ht.insert(0);
		ht.insert(101);
		ht.insert(202);
		ht.insert(303);
		ht.insert(404);
		
		ht.remove(101);
		ht.remove(101);
		
		assertArrayEquals(new Integer[] {0, null, 202, 303, 404, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, ht.toArray());
	}
	
	/* Testing size */
	
	@Test
	void testSize1() {
		HashTable ht = new HashTable(5);
		
		ht.insert(10);
		ht.insert(23);
		ht.insert(3214);
		ht.insert(655);
		ht.insert(-123);
		
		assertEquals(5, ht.size());
	}
	
	@Test
	void testSize2() {
		HashTable ht = new HashTable(5);
		
		assertEquals(0, ht.size());
	}
	
	@Test
	void testSize3() {
		HashTable ht = new HashTable(5);
		
		ht.insert(3232);
		ht.insert(-23123);
		ht.insert(3498);
		ht.insert(908409);
		ht.insert(-3908345);
		ht.insert(-95435);

		assertEquals(6, ht.size());
	}
	
	@Test
	void testSize4() {
		HashTable ht = new HashTable(5);
		
		ht.insert(3);
		ht.insert(4);
		ht.insert(5);
		
		
		assertEquals(3, ht.size());
	}
	
	@Test
	void testSize5() {
		HashTable ht = new HashTable(5);
		
		ht.insert(3);
		ht.insert(4);
		ht.insert(5);
		
		ht.remove(5);
		
		assertEquals(2, ht.size());
		
		ht.insert(5);
		
		assertEquals(3, ht.size());
	}
	
	/* Testing isEmpty */
	
	@Test
	void testIsEmpty1() {
		HashTable ht = new HashTable(5);
		
		ht.insert(0);
		ht.insert(1);
		ht.insert(2);
		ht.insert(3);
		ht.insert(4);
		
		assertFalse(ht.isEmpty());
	}
	
	@Test
	void testIsEmpty2() {
		HashTable ht = new HashTable(5);
		
		ht.insert(0);
		
		assertFalse(ht.isEmpty());
	}
	
	@Test
	void testIsEmpty3() {
		HashTable ht = new HashTable(5);
			
		assertTrue(ht.isEmpty());
	}
	
	@Test
	void testIsEmpty4() {
		HashTable ht = new HashTable(5);
		
		ht.insert(0);
		ht.insert(1);
		ht.insert(2);
		ht.insert(3);
		ht.insert(4);
		
		assertFalse(ht.isEmpty());
		
		ht.remove(4);
		ht.remove(3);
		ht.remove(2);
		ht.remove(1);
		ht.remove(0);
			
		assertTrue(ht.isEmpty());
	}
	
	/* Testing search */
	
	@Test
	void testSearch1() {
		HashTable ht = new HashTable(20);
		
		ht.insert(0);
		ht.insert(20);
		ht.insert(44);
		ht.insert(32);
		ht.insert(19);
		
		assertTrue(ht.search(0));
		assertTrue(ht.search(20));
		assertTrue(ht.search(44));
		assertTrue(ht.search(32));
		assertTrue(ht.search(19));
		
		System.out.println(Arrays.toString(ht.toArray()));
	}
	
	@Test
	void testSearch2() {
		HashTable ht = new HashTable(20);
		
		ht.insert(122);
		ht.insert(-2321321);
		ht.insert(-3213214);
		ht.insert(-33213);
		ht.insert(-321323);
		
		assertTrue(ht.search(122));
		assertTrue(ht.search(-2321321));
		assertTrue(ht.search(-3213214));
		assertTrue(ht.search(-33213));
		assertTrue(ht.search(-321323));
	}
	
	@Test
	void testSearchNoExisting1() {
		HashTable ht = new HashTable(20);
		
		ht.insert(0);
		ht.insert(20);
		ht.insert(44);
		ht.insert(32);
		ht.insert(19);
		
		assertFalse(ht.search(100));
		assertFalse(ht.search(21));
		assertTrue(ht.search(19));
	}
	
	@Test
	void testSearchNoExisting2() {
		HashTable ht = new HashTable(20);
		
		assertFalse(ht.search(100));
	}
	
	/* Testing searchByHash */
	
	@Test
	void testSearchByHash1() {
		HashTable ht = new HashTable(20);
		
		ht.insert(0);
		ht.insert(20);
		ht.insert(44);
		ht.insert(32);
		ht.insert(19);
		
		assertTrue(ht.searchByHash(0));
		assertTrue(ht.searchByHash(20));
		assertTrue(ht.searchByHash(44));
		assertTrue(ht.searchByHash(32));
		assertTrue(ht.searchByHash(19));
		
		System.out.println(Arrays.toString(ht.toArray()));
	}
	
	@Test
	void testSearchByHash2() {
		HashTable ht = new HashTable(20);
		
		ht.insert(122);
		ht.insert(-2321321);
		ht.insert(-3213214);
		ht.insert(-33213);
		ht.insert(-321323);
		
		assertTrue(ht.searchByHash(122));
		assertTrue(ht.searchByHash(-2321321));
		assertTrue(ht.searchByHash(-3213214));
		assertTrue(ht.searchByHash(-33213));
		assertTrue(ht.searchByHash(-321323));
	}
	
	@Test
	void testSearchByHashNoExisting1() {
		HashTable ht = new HashTable(20);
		
		ht.insert(0);
		ht.insert(20);
		ht.insert(44);
		ht.insert(32);
		ht.insert(19);
		
		assertFalse(ht.searchByHash(100));
		assertFalse(ht.searchByHash(21));
		assertTrue(ht.searchByHash(19));
	}
	
	@Test
	void testSearchByHashNoExisting2() {
		HashTable ht = new HashTable(20);
		
		assertFalse(ht.search(100));
	}
	
	/* Testing indexOf */
	
	@Test
	void testIndexOf1() {
		HashTable ht = new HashTable(10);
		
		ht.insert(0);
		ht.insert(10);
		ht.insert(20);
		ht.insert(30);
		ht.insert(40);
		ht.insert(50);
		ht.insert(60);
		ht.insert(70);
		ht.insert(80);
		
		assertEquals(0, ht.indexOf(0));
		assertEquals(1, ht.indexOf(20));
		assertEquals(2, ht.indexOf(40));
		assertEquals(3, ht.indexOf(60));
		assertEquals(4, ht.indexOf(80));
		
		assertEquals(10, ht.indexOf(10));
		assertEquals(11, ht.indexOf(30));
		assertEquals(12, ht.indexOf(50));
		assertEquals(13, ht.indexOf(70));
	}
	
	@Test
	void testIndexOfNoExisting1() {
		HashTable ht = new HashTable(10);
		
		ht.insert(0);
		ht.insert(10);
		ht.insert(20);
		ht.insert(30);
		ht.insert(40);
		ht.insert(50);
		ht.insert(60);
		ht.insert(70);
		ht.insert(80);
		
		ht.remove(0);
		
		assertEquals(-1, ht.indexOf(0));
		assertEquals(1, ht.indexOf(20));
		assertEquals(2, ht.indexOf(40));
		assertEquals(3, ht.indexOf(60));
		assertEquals(4, ht.indexOf(80));
		
		assertEquals(10, ht.indexOf(10));
		assertEquals(11, ht.indexOf(30));
		assertEquals(12, ht.indexOf(50));
		assertEquals(13, ht.indexOf(70));
	}
	
	@Test
	void testIndexOfNoExisting2() {
		HashTable ht = new HashTable(10);
		
		ht.insert(0);
		ht.insert(10);
		ht.insert(20);
		ht.insert(30);
		ht.insert(40);
		ht.insert(50);
		ht.insert(60);
		ht.insert(70);
		ht.insert(80);
		
		ht.remove(0);
		ht.remove(10);
		ht.remove(20);
		ht.remove(30);
		ht.remove(40);
		ht.remove(50);
		ht.remove(60);
		ht.remove(70);
		ht.remove(80);
		
		assertEquals(-1, ht.indexOf(0));
		assertEquals(-1, ht.indexOf(20));
		assertEquals(-1, ht.indexOf(40));
		assertEquals(-1, ht.indexOf(60));
		assertEquals(-1, ht.indexOf(80));
		
		assertEquals(-1, ht.indexOf(10));
		assertEquals(-1, ht.indexOf(30));
		assertEquals(-1, ht.indexOf(50));
		assertEquals(-1, ht.indexOf(70));
	}
	
	@Test
	void testIndexOfNoExisting3() {
		HashTable ht = new HashTable(10);
		
		assertEquals(-1, ht.indexOf(0));
	}
	
	/* Testing indexOfByHash */
/* Testing indexOf */
	
	@Test
	void testIndexOfByHash1() {
		HashTable ht = new HashTable(10);
		
		ht.insert(0);
		ht.insert(10);
		ht.insert(20);
		ht.insert(30);
		ht.insert(40);
		ht.insert(50);
		ht.insert(60);
		ht.insert(70);
		ht.insert(80);
		
		assertEquals(0, ht.indexOfByHash(0));
		assertEquals(1, ht.indexOfByHash(20));
		assertEquals(2, ht.indexOfByHash(40));
		assertEquals(3, ht.indexOfByHash(60));
		assertEquals(4, ht.indexOfByHash(80));
		
		assertEquals(10, ht.indexOfByHash(10));
		assertEquals(11, ht.indexOfByHash(30));
		assertEquals(12, ht.indexOfByHash(50));
		assertEquals(13, ht.indexOfByHash(70));
	}
	
	@Test
	void testIndexOfByHashNoExisting1() {
		HashTable ht = new HashTable(10);
		
		ht.insert(0);
		ht.insert(10);
		ht.insert(20);
		ht.insert(30);
		ht.insert(40);
		ht.insert(50);
		ht.insert(60);
		ht.insert(70);
		ht.insert(80);
		
		ht.remove(0);
		
		assertEquals(-1, ht.indexOfByHash(0));
		assertEquals(1, ht.indexOfByHash(20));
		assertEquals(2, ht.indexOfByHash(40));
		assertEquals(3, ht.indexOfByHash(60));
		assertEquals(4, ht.indexOfByHash(80));
		
		assertEquals(10, ht.indexOfByHash(10));
		assertEquals(11, ht.indexOfByHash(30));
		assertEquals(12, ht.indexOfByHash(50));
		assertEquals(13, ht.indexOfByHash(70));
	}
	
	@Test
	void testIndexOfByHashNoExisting2() {
		HashTable ht = new HashTable(10);
		
		ht.insert(0);
		ht.insert(10);
		ht.insert(20);
		ht.insert(30);
		ht.insert(40);
		ht.insert(50);
		ht.insert(60);
		ht.insert(70);
		ht.insert(80);
		
		ht.remove(0);
		ht.remove(10);
		ht.remove(20);
		ht.remove(30);
		ht.remove(40);
		ht.remove(50);
		ht.remove(60);
		ht.remove(70);
		ht.remove(80);
		
		assertEquals(-1, ht.indexOfByHash(0));
		assertEquals(-1, ht.indexOfByHash(20));
		assertEquals(-1, ht.indexOfByHash(40));
		assertEquals(-1, ht.indexOfByHash(60));
		assertEquals(-1, ht.indexOfByHash(80));
		
		assertEquals(-1, ht.indexOfByHash(10));
		assertEquals(-1, ht.indexOfByHash(30));
		assertEquals(-1, ht.indexOfByHash(50));
		assertEquals(-1, ht.indexOfByHash(70));
	}
	
	@Test
	void testIndexOfByHashNoExisting3() {
		HashTable ht = new HashTable(10);
		
		assertEquals(-1, ht.indexOfByHash(0));
	}
}
