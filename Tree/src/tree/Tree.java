package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree <E>{
	private class Node<T>{
		private E info;
		private int level=1;
		private Node<T> left;
		private Node<T> right;
		public Node(E info) {
			this.info=info;
			this.left=null;
			this.right=null;
		}
		public Node(E info,Node<T> left,Node<T> right) {
			this.info=info;
			this.left=left;
			this.right=right;
			this.level=level;
		}
	}
	private static final int Integer = 0;
		private Node<E> root;
		public Tree () {
			Node r4=new Node(7);
			Node r2=new Node(4, r4, null);
			Node r6=new Node(10, new Node(2), new Node(5));
			Node r3=new Node(1, new Node(8), r6);
			root=new Node(3, r2, r3);
		}
		private void inOrder(Node r) {
			if(r!=null) {
				System.out.println(r.info+" ");
				inOrder(r.left);
				inOrder(r.right);
			}
		}
		public void inOrder() {
			inOrder(root);
		}
		private void midOrder(Node r) {
			if(r!=null) {
				midOrder(r.left);
				System.out.println(r.info+" ");
				midOrder(r.right);
			}
		}
		public void midOrder() {
			midOrder(root);
		}
		private void postOrder(Node r) {
			if(r!=null) {
				postOrder(r.left);
				postOrder(r.right);
				System.out.println(r.info+" ");
			}
		}
		public void postOrder() {
			postOrder(root);
		}
		private int sum(Node r) {
			if(r==null) 
				return 0;
			else 
				return (Integer)r.info+sum(r.left)+sum(r.right);
		}
		public void sum() {
			System.out.println("sum= "+sum(root));
		}
		private int sumChan(Node r) {
				if(r==null) {
					return 0;
				}	
				if((Integer)r.info%2!=0)
					return sumChan(r.left)+sumChan(r.right); 
				else	
					return (Integer)r.info+sumChan(r.left)+sumChan(r.right);
		}
		public void sumChan() {
			System.out.println("sumchan= "+sumChan(root));
		}
		//dem cac node trong cay
		private int countNode(Node r) {
			if(r==null)
				return 0;
			else 
				return 1+countNode(r.left)+countNode(r.right);
		}
		public void countNode() {
			System.out.println("so node trong cay: "+countNode(root));
		}
		//dem cac node co chua so le
		private int countLe(Node r) {
			if(r==null)
				return 0;
			if((Integer)r.info%2==0)
				return countLe(r.left)+countLe(r.right);
			else 
				return 1+countLe(r.left)+countLe(r.right);
		}
		public void countLe() {
			System.out.println("so node co chua so le: "+countLe(root));
		}
		//dem so node la trong cay
		private int countLeaf(Node r) {
			if(r==null) return 0;
			
			if(r.left!=null&&r.right!=null)
				return countLe(r.left)+countLe(r.right);
			return 1+countLe(r.left)+countLe(r.right);
		}
		public void countLeaf() {
			System.out.println("so node la: "+countLe(root));
		}
		//tinh trung binh cong cac so nguyen to trong cay
		private int isPrime(Node r) {
			if((Integer)r.info<2)
				return 0;
			else
				for(int i=2;i<=Math.sqrt((Integer)r.info);i++)
					if((Integer)r.info%i==0)
						return 0;
			return 1;
		}
		private int countPrime(Node r) {
			if(r==null)
				return 0;
			if(isPrime(r)==0)
				return countPrime(r.left)+countPrime(r.right);
			return 1+countPrime(r.left)+countPrime(r.right);
		}
		public void countPrime() {
			System.out.println(countPrime(root));
		}
		private int sumPrime(Node r) {
			if(r==null) return 0;
			else if(isPrime(r)==1)
				return (Integer)r.info+sumPrime(r.left)+sumPrime(r.right);
			return sumPrime(r.left)+sumPrime(r.right);
		}
		public void sumPrime() {
			System.out.println(sumPrime(root));
		}
		public void tbcPrime() {
			System.out.println("trung binh cong cac so nguyen to: "+1.0*sumPrime(root)/countPrime(root));
		}
		//dem node bac1
		public int countBac1 (Node r)
		{
			if (r==null) return 0;
			else
			   if((r.right==null&&r.left!=null)||(r.right!=null&&r.left==null))
		            return 1+countBac1(r.left)+countBac1(r.right);
		       else 
		            return countBac1(r.left)+countBac1(r.right);
		}
		public void countBac1()
		{
			System.out.println("Số node bậc 1: "+countBac1(root));
		}
	    //cac node bac 2
		public int countBac2(Node r){
			if(r==null) 
				return 0;
		     else
		         if(r.left==null||r.right==null)
		               return countBac2(r.left)+countBac2(r.right);
		         else
		               return 1+ countBac2(r.left)+countBac2(r.right);
		    }
		public void countBac2(){
		   System.out.println("so node bac 2: "+countBac2(root));
		}
		//kiem tra x co trong cay khong
		private boolean find(Node r,int x) {
			if((Integer)r.info==x) {
				return true;
			}
			else 
				return find(r.left, x);
		}
		//tim chieu cao cua cay
		private int height(Node r) {
			if(r==null)
				return 0;
			else 
				return 1+Math.max(height(r.left), height(r.right));
		}
		public void height() {
			System.out.println("height= "+height(root));
		}
		public void find(int x) {
			if(find(root, x)==true)
				System.out.println(x+" co trong cay");
			else 
				System.out.println(x+" khong co trong cay");
		}
		//duyet cay theo chieu rong 
		public void chieurong() {
			if(root!=null)
			{
				Queue<Node> q=new LinkedList<Tree.Node>();
				q.add(root);
				while(!q.isEmpty()) {
					Node p=q.remove();
					System.out.println(p.info);
					if(p.left!=null) q.add(p.left);
					if(p.right!=null) q.add(p.right);
				}
			}
		}
		//tim muc cua gia tri x. 
		public void findMucx(int x) {
			if(root!=null)
			{
				Queue<Node> q=new LinkedList<Tree.Node>();
				q.add(root);
				while(!q.isEmpty()) {
					Node p=q.remove();
					if((Integer)p.info==x) {
						System.out.println(p.level);
					}
					if(p.left!=null) 
						{	p.left.level=p.level+1;
							q.add(p.left);
						}
					if(p.right!=null) 
						{	p.right.level=p.level+1;
							q.add(p.right);
						}
				}
			}
		}
		//tim gia tri lớn nhất trong cây
		public int max() {
			int max=(Integer)root.info;
			if(root!=null)
			{
				Queue<Node> q=new LinkedList<Tree.Node>();
				q.add(root);
				while(!q.isEmpty()) {
					Node p=q.remove();
					if((Integer)p.info>=max)
						max=(Integer)p.info;
					if(p.left!=null) 
						{	
							q.add(p.left);
						}
					if(p.right!=null) 
						{	
							q.add(p.right);
						}
				}
			}
			return max;
		}
		//tim gia tri nho nhat trong cay
		public int min() {
			int min=(Integer)root.info;
			if(root!=null)
			{
				Queue<Node> q=new LinkedList<Tree.Node>();
				q.add(root);
				while(!q.isEmpty()) {
					Node p=q.remove();
					if((Integer)p.info<=min)
						min=(Integer)p.info;
					if(p.left!=null) 
						{	
							q.add(p.left);
						}
					if(p.right!=null) 
						{	
							q.add(p.right);
						}
				}
			}
			return min;
		}
		//ktra root co gia tri lon nhat hay k
		public boolean isMax() {
			if((Integer)root.info==max()) {
				return true;
			}
			else 
				return false;
		}
		//ktra root co gia tri nho nhat k
		public boolean isMin() {
			if((Integer)root.info==min()) {
				return true;
			}
			return false;
		}
		//dem so node tren 1 muc
		public void count(int x) {
			int count=0;
			if(root!=null) {
				Queue<Node> q=new LinkedList<Tree.Node>();
				q.add(root);
				while(!q.isEmpty()) {
					Node p=q.remove();
					if(x==(Integer)p.info) {
						count++;
					}
					if(p.left!=null) q.add(p.left);
					if(p.right!=null) q.add(p.right);
				}
			}
			System.out.println("tong so node tren muc la: "+count);
		}
		//chieu sau
		public void chieusau() {
			if(root!=null) {
				Stack<Node> s=new Stack<Tree.Node>();
				s.push(root);
				while(!s.isEmpty()) {
					Node p=s.pop();
					System.out.println(p.info);
					if(p.left!=null) s.push(p.left);
					if(p.right!=null) s.push(p.right);
				}
			}
		}
		
	   	public static void main(String[] args) {
		Tree<Integer> t=new Tree<Integer>();
		//System.out.println("inOrder:");
		//t.inOrder();
//		System.out.println("midOrder");
//		t.midOrder();
//		System.out.println("postOrder");
//		t.postOrder();
//		t.sum();
//		t.sumChan();
//		t.countNode();
//		t.countLe();
//		t.countLeaf();
//		t.tbcPrime();
//		t.countBac1();
//		t.countBac2();
//		//t.find(11);
//		t.height();
		//t.chieurong();
		//t.findMucx(3);
		t.chieusau();
		System.out.println("root co gia tri lon nhat trong cay khong: "+t.isMax());
		System.out.println("root co gia tri nho nhat trong cay khong: "+t.isMin());
		System.out.println("Gia tri lon nhat trong cay: "+t.max());
		System.out.print("Muc cua gia tri lon nhat: ");
		t.findMucx(t.max());
		t.count(4);
	}

}
