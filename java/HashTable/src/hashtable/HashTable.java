package hashtable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


/**
 * Representa uma hashtable com enderecamento aberto e probing linear como estrategia de hashing
 * 
 * @author Wesley Silva
 *
 */
public class HashTable {
	public static int RESIZE_MULTIPLIER = 2;
	public static double RESIZE_THRESHOLD = 0.5;
	
	/**
	 * O array que guarda os elementos que são armazenados na tabela
	 */
	private DataItem[] table;
	
	
	/**
	 * Cria uma nova hashtable com um tamanho inicial
	 * 
	 * @param size O tamanho inicial da table
	 * 
	 */
	public HashTable(int size) {
		this.table = new DataItem[size];
	}
	
	/**
	 * Cria uma hashtable a partir de uma lista. O tamanho inicial da hashtable eh o dobro do tamanho da lista
	 * 
	 * @param list A lista que sera convertida em hashtable
	 * @return Um hashtable contendo os elementos da lista
	 */
	public static HashTable fromList(List<Integer> list) {
		HashTable table = new HashTable(list.size() * 2);	
		list.stream().forEach(e -> table.insert(e));
		return table;
	}
	
	/**
	 * Insere um elemento no hashtable. Se o RESIZE_THRESHOLD for ultrapassado, a tabela cresce de tamanho baseado no RESIZE_MULTIPLIER
	 * 
	 * @param element O elemento a ser inserido na hashtable
	 * @return O item inserido
	 */
	public DataItem insert(int element) {
		return (!isResizable()) ? (insertAux(element, hashFunction(element))) : (resizeAndInsert(element));
	}
	
	private DataItem insertAux(int element, int hash) {
		return (table[hash] == null || table[hash].isRemoved()) ? (table[hash] = new DataItem(element)) : (insertAux(element, (++hash) % table.length));
	}
	
	/**
	 * Checa se o hashtable eh vazio
	 * 
	 * @return True caso seja vazio, False caso contrário
	 */
	public boolean isEmpty() {
		return Arrays.stream(table).noneMatch(e -> e != null && !e.isRemoved()); 
	}
	
	/**
	 * Calcula o tamanho da hashtable, excluindo elementos removidos ou null da contagem
	 * 
	 * @return O tamanho da hashtable
	 */
	public long size() {
		return Arrays.stream(table).filter(e -> e != null && !e.isRemoved()).count();
	}
	
	/**
	 * Dado um elemento, encontra o index dele na hashtable utilizanto filter de java 8
	 * 
	 * @param element O elemento a ser procurado
	 * @return Retorna a posição do elemento na tabela ou -1 se não for encontrado
	 */
	public int indexOf(int element) {
		return IntStream.range(0, table.length).filter(i -> table[i] != null && !table[i].isRemoved() && table[i].getData() == element).findAny().orElse(-1);
	}
	
	/**
	 * Dado um elemento, encontra o index dele na hashtable utilizando o hash do elemento
	 * 
	 * @param element O elemento a ser procurado
	 * @return Retorna a posição do elemento na tabela ou -1 se não for encontrado
	 */
	public int indexOfByHash(int element) {
		return indexOfByHashAux(element, hashFunction(element));
	}
	
	private int indexOfByHashAux(int element, int hash) {
		return (table[hash] == null) ? (-1) : ((!table[hash].isRemoved() && table[hash].getData() == element) ? (hash) : (indexOfByHashAux(element, (++hash) % table.length)));
	}
	
	/**
	 * Remove um elemento da tabela
	 * 
	 * @param element O elemento a ser removido
	 * @return O DataItem removido caso o elemento esteja na tabela e null caso contrario
	 */
	public DataItem remove(int element) {
		return removeAux(element, hashFunction(element));
	}
	
	private DataItem removeAux(int element, int hash) {
		return (table[hash] == null) ? (null) : ((!table[hash].isRemoved() && table[hash].getData() == element) ? (removeFromTable(hash)) : (removeAux(element, (++hash) % table.length)));
	}

	/**
	 * Verifica se um elemento esta na tabela utilizando streams de java 8
	 * 
	 * @param element O elemento a ser procurado
	 * @return True se caso o elemento esteja na tabela e False caso contrario
	 */
	public boolean search(int element) {
		return Arrays.stream(table).anyMatch(e -> e != null && !e.isRemoved() && e.getData() == element);
	}
	
	/**
	 * Verifica se um elemento esta na tabela utilizando o hash
	 * 
	 * @param element O elemento a ser procurado
	 * @return True se caso o elemento esteja na tabela e False caso contrario
	 */
	public boolean searchByHash(int element) {
		return searchByHashAux(element, hashFunction(element));
	}
	
	private boolean searchByHashAux(int element, int hash) {
		return (table[hash] == null) ? (false) : ((!table[hash].isRemoved() && table[hash].getData() == element) ? (true) : (searchByHashAux(element, (++hash) % table.length)));
	}

	/**
	 * Transforma a hashtable em um array. Os elementos removidos se tornam null
	 * 
	 * @return O array com os elementos da hashtable nas suas respectivas posicoes
	 */
	public Integer[] toArray() {
		Integer[] iTable = new Integer[table.length];
		IntStream.range(0,  table.length).forEach(i -> { 
															if (table[i] != null && !table[i].isRemoved()) 
																iTable[i] = table[i].getData(); 
															else 
																table[i] = null;
														});
														
		return iTable;
	}
	
	/**
	 * 
	 * @return A tabela hash
	 */
	public DataItem[] getTable() {
		return table;
	}
	
	private int hashFunction(int item) {
		return Math.abs(item % table.length);
	}
	
	private boolean isResizable() {
		return (((Arrays.stream(table).filter(e -> e != null && !e.isRemoved()).count() + 1.0) / table.length) >= RESIZE_THRESHOLD) ? (true) : (false);
	}
	
	private DataItem resizeAndInsert(int element) {
		resizeTable();
		return insertAux(element, hashFunction(element));
	}
	
	private void resizeTable() {
		DataItem[] tableCopy = new DataItem[table.length];
		System.arraycopy(table, 0, tableCopy, 0, table.length);
		table = new DataItem[table.length * RESIZE_MULTIPLIER];
		Arrays.stream(tableCopy).filter(e -> e != null && !e.isRemoved()).forEach(e -> insert(e.getData()));
	}
	
	private DataItem removeFromTable(int hash) {
		table[hash].setRemoved(true);
		return table[hash];
	}
}
