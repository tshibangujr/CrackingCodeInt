ArrayList<LinkedList<Node>> listOfDepth(Node n){
	if(n != null){
		n.depth = 0;
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		detailedDepth(n, result);
		return result;
	}
	return null;
}

void detailedDepth(Node n, ArrayList<LinkedList<Node>> result){
	if(n != null){
		//Add in result list
		if(result.get(n.depth) == null){
			LinkedList<Node> item =  new LinkedList<Node>();
			item.add(n);
			result.add(n.depth, item);
		}
		else{
			result.get(n.depth).add(n);
		}
		
		if(n.left != null)
			n.left.depth = n.depth + 1;
		if(n.right != null)
			n.right.depth = n.depth + 1;
		
		detailedDepth(n.left, result);
		detailedDepth(n.right, result);
			
	}
}