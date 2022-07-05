// Online Java Compiler
// Use this online editor to compile and run Java code online
import java.util.*;
import java.io.*;


class CustomHashMap
{
// 	hashmap class, building our custom hashmap here
// <K, V> is generic support. It will support all data types
	public class HashMap<K, V>{

//------------------------------------------------------------------------		
// 		Creating a node of Generic parameter(K, V)
		private class HMNode{
			K key;
			V value;
			
			HMNode(K _key, V _value){
				this.key = _key;
				this.value = _value;
			}
		}
		
// 		Total no of nodes(key, value pair), n
		private int size; 
// 		array of linkedlist
		private LinkedList<HMNode> buckets[];
		
		
		HashMap(){
// 			initialise Bucket size = 4, N
			buckets = new LinkedList[4];
// 			filling bucket with empty linkedlist
			Arrays.fill(buckets, new LinkedList<>());
// 			initilising total number of nodes = 0; 
			size = 0;
		}
		
// -----------------------------------------------------------------------	
// 		HASH FUNCTION
		private int hashFunction(K key){
			int hash = key.hashCode();
			int absolute_hash = Math.abs(hash);
			
			return absolute_hash % buckets.length;
		}
		
// 		INDEX OF KEY WITH IN BUCKET AT INDEX BUCKET_INDEX
		private int getKeyIndex(K key, int bucket_index){
			int i = 0;
			for(HMNode node : buckets[bucket_index]){
				if(node.key == key)return i;
				i++;
			}
			return -1;
		}
		
// 		REHASH FUNCTION
		private void rehash(){
			LinkedList<HMNode> oldBuckets[] = buckets;
			
// 			initialising the new bucket which is twice the ise of old bucket
			buckets = new LinkedList[oldBuckets.length * 2];
			Arrays.fill(buckets, new LinkedList<>());
			size = 0;
			
			for(int i = 0; i<oldBuckets.length; i++){
				for(HMNode node : oldBuckets[i])put(node.key, node.value);
			}
		}
//------------------------------------------------------------------------ 
		
		public void put(K key, V value){
			int bucket_index = hashFunction(key);
			int key_index = getKeyIndex(key, bucket_index);
			
// 			key not found in bucket at bucket_index
			if(key_index == -1){
				HMNode node = new HMNode(key, value);
				buckets[bucket_index].add(node);
				size++; 
			}
// 			key found in bucket at bucket_index
			else{
				HMNode node = buckets[bucket_index].get(key_index);
				node.value = value;
			}
			
// 			Calculating the load factor and rehashing
			double lambda = size * 1.0 / buckets.length;
			
// 			k = 2.0;
			if(lambda > 2.0)rehash();
			
		}
		
		public boolean containsKey(K key){
			int bucket_index = hashFunction(key);
			int key_index = getKeyIndex(key, bucket_index);
			
// 			key not found in bucket at bucket_index
			if(key_index == -1){
				return false; 
			}
			else{
				return true;
			}
		}
		
		public V get(K key){
			int bucket_index = hashFunction(key);
			int key_index = getKeyIndex(key, bucket_index);
			
// 			key not found in bucket at bucket_index
			if(key_index == -1){
				return null; 
			}
			else{
				HMNode node = buckets[bucket_index].get(key_index);
				return node.value;
			}
		}
		
		public V remove(K key){
			int bucket_index = hashFunction(key);
			int key_index = getKeyIndex(key, bucket_index);
			
// 			key not found in bucket at bucket_index
			if(key_index == -1){
				return null; 
			}
			else{
				HMNode node = buckets[bucket_index].get(key_index);
				buckets[bucket_index].remove(key_index);

				size--;

				return node.value;				
			}
		}
		
		public int size(){
			return size;
		}
		
		public ArrayList<K> keyset(){
			ArrayList<K> keys = new ArrayList<>();
			
			for(int i = 0; i<buckets.length; i++){
				for(HMNode node : buckets[i]){
					keys.add(node.key);
				}
			}
			
			return keys;
		}
		
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		System.out.print(3.4);
	}
}