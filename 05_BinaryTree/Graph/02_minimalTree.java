public static class NodeTree<T>{
        T value;
        NodeTree<T> left;
        NodeTree<T> right;
        public NodeTree(T value){
            this.value = value;
        }
}
public static class BinarySearchTree<T>{
	//Build minimal Binary Search Tree from sorted array
	public NodeTree<T> minimalTree(T[] A){
		if(A != null){
			int min = 0;
			int max = A.length - 1;
			return construct(A, min, max);
		}
		return null;
	}
	public NodeTree<T> construct(T[] A, int min, int max){
		int mid;
		if(min <= max){
			mid = (min + max) / 2;
			NodeTree<T> root = new NodeTree<T>(A[mid]);
			root.left = construct(A, min, mid - 1);
			root.right = construct(A, mid + 1, max);
			return root;
		}
		return null;
	} 
}