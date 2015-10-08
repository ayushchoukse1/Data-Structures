package geekforgeeks.linkedlist;

public class LinkedListApp {

	public static void main(String[] args) {
		MergeLL merge=new MergeLL();
		Median med=new Median();
		CheckLoopLL check=new CheckLoopLL();
		ReverseALinkedList rev= new ReverseALinkedList();
		ReverseLL reverse= new  ReverseLL();
		MergeIterator mergeIterator =new MergeIterator();
		LinkedList linkedList =new LinkedList();
		LinkedList linkedList2 =new LinkedList();
		//LinkedList1
		linkedList.insertLinkedList(1, 0);
		linkedList.insertLinkedList(2, 1);
		linkedList.insertLinkedList(5, 2);
		linkedList.insertLinkedList(8, 3);
		linkedList.insertLinkedList(9, 4);
		linkedList.insertLinkedList(10, 5);
		linkedList.insertLinkedList(11, 6);
		//linkedList.createLoop();
		//LinkedList2 
		linkedList2.insertLinkedList(3, 0);
		linkedList2.insertLinkedList(5, 1);
		linkedList2.insertLinkedList(7, 2);
		linkedList2.insertLinkedList(11, 3);
		
		linkedList.displayLinkedList();
		System.out.println("");
		linkedList2.displayLinkedList();
		System.out.println("");
		System.out.println("The legnth of Linked list 1 is "+ linkedList.getLength()+" \n");
		//System.out.println("The legnth of Linked list 2 is  "+ linkedList2.getLength());
	/*	linkedList.deleteLinkedList(4);
		linkedList.displayLinkedList();
		System.out.println("");
		System.out.println("The legnth of Linked list is "+ linkedList.getLength());*/
		//System.out.println("The position of node with data 7 is "+linkedList.getPosition(7));
		//linkedList.getHead().displayNode();
		/*LinkedListNode newlist=reverse.reverseIterator(linkedList.getHead());
		
		while (newlist.getNext()!=null) {
			newlist.displayNode();
			newlist=newlist.getNext();
			
		}*/
		
		IntersectionLL intersection= new IntersectionLL();
int a=intersection.getIntesection(linkedList.getHead(), linkedList2.getHead());
System.out.println(a);
//	newintersection.displayNode();
		//System.out.println(check.checkLoop(linkedList.getHead()));
		//System.out.println("The Median of Linked list 1 is "+ med.mediannode(linkedList.getHead()).getData());
		
	}

}
