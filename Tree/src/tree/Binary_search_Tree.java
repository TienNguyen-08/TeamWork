package tree;


public class Binary_search_Tree <E>{
	private class Node<T>{
		private Comparable <E> info;
		private int level=1;
		private Node<T> left;
		private Node<T> right;
		public Node(Comparable <E> info) {
			this.info=info;
			this.left=null;
			this.right=null;
		}
		public Node(Comparable <E> info,Node<T> left,Node<T> right) {
			this.info=info;
			this.left=left;
			this.right=right;
			this.level=level;
		}
	}
	private static final int Integer = 0;
	private Node<E> root=null;
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
			System.out.print(r.info+" ");
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
	private Node <E> add(Comparable<E> value,Node r){
		if(r==null)
		{
			r=new Node(value);
			return r;
		}
		else if(value.compareTo((E) r.info)<0) 
		{
			r.left=add(value, r.left);
			return r;
		}
		else if(value.compareTo((E)r.info)>0)
		{
			r.right=add(value, r.right);
			return r;
		}
		else {
			System.out.println("da ton tai gia tri");
			return r;
		}
		
	}
	public void add(Comparable<E> value) {
		root=add(value, root);
	}
	private boolean findx(Comparable<E> x,Node r) {
		if(r==null)
			return false;
		else if(x.compareTo((E)r.info)<0)
		{
			return findx(x, r.left);
		}
		else if(x.compareTo((E)r.info)>0){
			return findx(x, r.right);
		}
		return true;
	}
	public void findx(Comparable<E> x) {
		System.out.println(findx(x, root));
	}
	private Node<E> remove(Comparable<E> x,Node r){
		if(r==null) System.out.println("x is not roof");
		else 
			if(x.compareTo((E)r.info)<0)
			{
				r.left=remove(x, r.left);
				return r;
			}
			else 
				if(x.compareTo((E)r.info)>0) 
				{
					r.right=remove(x, r.right);
					return r;
				}
				else
				{
					if(r.left==r.right&&r.right==null) {
						r=null;
						return r;
					}
					else
						if(r.left==null)
						{
							r=r.right;
							return r;
						}
						else 
						{
							Node p=r.left;
							while(p.right!=null) {
								p=p.right;
								r.info=p.info;
								r.left=remove(p.info, r.left);
								return r;
							}
						}
				}
		return r;
	}
	public void remove(Comparable<E> x) {
		System.out.println(remove(x, root));
	}
	public static void main(String[] args) {
		Binary_search_Tree<Integer> tree=new Binary_search_Tree<Integer>();
		tree.add(10);
		tree.add(4);
		tree.add(18);
		tree.add(-4);
		tree.add(8);
		tree.add(15);
		tree.add(1);
		tree.add(-9);
		tree.add(3);
		tree.add(-5);
		tree.add(28);
		tree.add(17);
		tree.add(21);
		tree.add(35);
		tree.add(72);
		tree.add(16);
		tree.inOrder();
		tree.findx(100);
		tree.remove(21);
		tree.inOrder();
	}
}
