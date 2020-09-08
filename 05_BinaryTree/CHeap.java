	private static class HeapNode{
            int data;
            HeapNode leftNode;
            HeapNode rightNode;
            
            public HeapNode(int data){
                this.data = data;
            }
    }
    private static class CHeap{
        //Assuming current Node is at a wrong position
        public void max_heapify(HeapNode node){
            if(node != null){
                int maximum = node.data;
                char direction = 'P';//Parent
                if(node.leftNode != null){
                    if(node.leftNode.data > maximum){
                        //Set left node data to max
                        maximum = node.leftNode.data;
                        direction = 'L'; //Left
                    }
                }
                if(node.rightNode != null){
                    if(node.rightNode.data > maximum){
                        maximum = node.rightNode.data;
                        direction = 'R';
                    }
                }
                //Determine direction to take
                if(direction != 'P'){
                    switch(direction){
                        case 'L':
                            //Swap left with parent
                            node.data = node.leftNode.data;
                            node.leftNode.data = maximum;
                            //Move to leftNode
                            max_heapify(node.leftNode);
                            break;
                        case 'R':
                            node.data = node.rightNode.data;
                            node.rightNode.data = maximum;
                            //Move to rightNode
                            max_heapify(node.rightNode);
                            break;
                    }
                }
            }
        }
        
        public void build_max_heap(HeapNode root){
            if((root != null) && (root.leftNode != null || root.rightNode != null)){
                max_heapify(root);
                build_max_heap(root.leftNode);
                build_max_heap(root.rightNode);
            }
        }
        
        //Heap Size
        public int heap_size(HeapNode root){
            if(root == null)
                return 0;
            else
                return 1 + heap_size(root.leftNode) + heap_size(root.rightNode);
        }
        
        public void insert(int item){
            
        }
        
    }