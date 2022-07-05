/**
 * HuffmanCoding
 */
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;


class HuffmanNode {
	int frequency;
	char data;
	HuffmanNode left, right;

}


public class HuffmanCoding {
    static class  Pair{
        int codeSize;
        String code;
        Pair(int c, String s){
            codeSize = c;
            code = s;
        }
    }

    // Map below is mappping characters with thier respective byte codes which we have generated below using huffman coding
    private static Map<Character, String> characterCodeTable = new HashMap<>();

    // This is tree using which we will generate codes for each character in tree
	static HuffmanNode root;

    //------------------------------------------------------------------------------------------------------------------------

    private static void setPrefixCodes(HuffmanNode node, StringBuilder code) {

        if(node == null)return;
		
        if (node.left == null && node.right == null) {
            // if node does not have any child. Add character and correspoing code in to character code table
            characterCodeTable.put(node.data, code.toString());
		} 
        else {
            // adding '0' for left child
            code.append('0');
            setPrefixCodes(node.left, code);
            // Removing necessary character after recursive call is over
            code.deleteCharAt(code.length() - 1);

            // adding '1' for right child
            code.append('1');
            setPrefixCodes(node.right, code);
            // Removing necessary character after recursive call is over
            code.deleteCharAt(code.length() - 1);
		}
		

	}

    //------------------------------------------------------------------------------------------------------------------------
    
	private static HuffmanNode buildTree(Map<Character, Integer> freq) {

        // Max heap
		PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>((a,b) -> {
            return a.frequency - b.frequency;
        });

		Set<Character> keySet = freq.keySet();
		for (Character c : keySet) {
            // Here i am making a new node, initialising data frequency using keyset and freq map
			HuffmanNode node = new HuffmanNode();
			node.data = c;
			node.frequency = freq.get(c);
			node.left = null;
			node.right = null;
			
            // pushing node into priorityQueue
            priorityQueue.offer(node);
		}
        // for(HuffmanNode x : priorityQueue){
        //     System.out.print(x.frequency + " ");
        // }
		// assert priorityQueue.size() > 0;

		while (priorityQueue.size() > 1) {

            // Taking out top two elements from amx heap
			HuffmanNode x = priorityQueue.peek();
			priorityQueue.poll();

			HuffmanNode y = priorityQueue.peek();
			priorityQueue.poll();
            // System.out.println("x = " + x.data + x.frequency + "y = "+ y.data + y.frequency);

            // Creating new node and adding frequency of above two nodes into it
			HuffmanNode sum = new HuffmanNode();

			sum.frequency = x.frequency + y.frequency;
			sum.data = '$';

            // Making larger or equal node left child of sum, I am using this convention. It can be added to right aswell
			sum.left = x;

			sum.right = y;

			root = sum;

			priorityQueue.offer(sum);
		}

		return priorityQueue.poll();
	}

    //------------------------------------------------------------------------------------------------------------------------ 

    private static void decode(String s) {

		StringBuilder stringBuilder = new StringBuilder();

		HuffmanNode temp = root;

		System.out.println("Encoded: " + s);

		for (int i = 0; i < s.length(); i++) {
			int j = Integer.parseInt(String.valueOf(s.charAt(i)));

			if (j == 0) {
				temp = temp.left;
				if (temp.left == null && temp.right == null) {
					stringBuilder.append(temp.data);
					temp = root;
				}
			}
			if (j == 1) {
				temp = temp.right;
				if (temp.left == null && temp.right == null) {
					stringBuilder.append(temp.data);
					temp = root;
				}
			}
		}

		System.out.println("Decoded: " + stringBuilder.toString());

	}
    
    //------------------------------------------------------------------------------------------------------------------------ 

    public static void printTree(HuffmanNode root){
        if(root == null)return;
        printTree(root.left);
        System.out.print(root.data + root.frequency + "--");
        printTree(root.right);
    }

    //------------------------------------------------------------------------------------------------------------------------ 
    private static Pair encode(String text) {
		Map<Character, Integer> freq = new HashMap<>();
		for (int i = 0; i < text.length(); i++) {
			if (!freq.containsKey(text.charAt(i))) {
				freq.put(text.charAt(i), 0);
			}
			freq.put(text.charAt(i), freq.get(text.charAt(i)) + 1);
		}

		System.out.println("Character Frequency Map = " + freq);
		
        // Generating Tree for charcter and frequency
        root = buildTree(freq);
        System.out.print("Printing Tree | [LEFT -> ROOT -> RIGHT]:");
        printTree(root);
        System.out.println();    
        
        // Generating codes Using Trees
		setPrefixCodes(root, new StringBuilder());
        System.out.println("=================================================================");
        System.out.println("CHARCTER AND THIER CODES");
        int size_of_characterCodeTable = 0;

		for(Map.Entry<Character, String> entry: characterCodeTable.entrySet()){
            System.out.println(entry.getKey() + "     ||     " + entry.getValue());
            
            size_of_characterCodeTable += (freq.get(entry.getKey()) * entry.getValue().length());
        }
        // System.out.println("Size of Codes = " + size_of_characterCodeTable);
		
        
        // Generating finall code from text using character code hashmap
        StringBuilder s = new StringBuilder();

		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			s.append(characterCodeTable.get(c));
		}

		return new Pair(size_of_characterCodeTable, s.toString());
	}
    //------------------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        
        System.out.println("TEXT COMPRESSION USING HUFFMAN CODING ALGORITHM ");
        System.out.println("=================================================================");
        
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
        System.out.println("Enter a Text or String which You want to compress: ");  
        String str= sc.nextLine();              //reads string   
        sc.close();
        System.out.println("You have entered: "+str);   
        System.out.println("=================================================================");
        
		
		System.out.println("ORIGINAL TEXT = "+str);
        System.out.println("SIZE OF ORIGINAL TEXT = " + str.length() * 8  + " bits");
        System.out.println("-----------------------------------------------------------------");

        
		Pair s = encode(str);

        System.out.println("=================================================================");
        System.out.println("NEW HUFFMAN ENCODED TEXT = "+s.code);
        
        System.out.println("SIZE OF ENCODED TEXT = " + s.codeSize + " bits");
        System.out.println("=================================================================");
        
		decode(s.code);

	}
}
