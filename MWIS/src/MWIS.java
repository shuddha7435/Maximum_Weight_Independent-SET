//This is the Maximum Weight Independent Set Class.

public class MWIS {
	
	
	public static int IsCovered(Node [] _nodes, Node _node,int _i, int _numOfNodes)
	{
		int j;
		int res=0;
		for(j=_numOfNodes;j>=_i;j--)
		{
			if(_nodes[j].GetNodeId()==_node.GetNodeId())
			{
				res=1;
				break;
			}
		}
		return res;
	}
	
	
	
	
	public static int SumOfChildren(Node _node, Edge [] _edges, int _numOfNodes)
	{
		int sum=0;
		int j;
		
		for(j=0;j<=_numOfNodes;j++)
		{
			if(_edges[j].pNode.GetNodeId()==_node.GetNodeId())
			{
				sum=sum+_edges[j].cNode.GetNodeWeight();
			}
		}
		return sum;
	}
	
	
	
	public static Node GetEdgeCover(Node _parent,Node _child, Node [] _EC, Edge [] _edges, int _numOfNodes, int _currentEdgeNumber)
	{
		Node _node=new Node(-1,0);
		
		if(_child.GetNodeWeight()>_parent.GetNodeWeight() && IsCovered(_EC,_parent,_currentEdgeNumber,_numOfNodes)==0 &&  IsCovered(_EC,_child,_currentEdgeNumber,_numOfNodes)==0 )
		{
			
			_node=_parent;
			
		}
		else if(_parent.GetNodeWeight()>_child.GetNodeWeight() && IsCovered(_EC,_child,_currentEdgeNumber,_numOfNodes)==0 &&  IsCovered(_EC,_parent,_currentEdgeNumber,_numOfNodes)==0 )
		{
			if(SumOfChildren(_parent,_edges, _numOfNodes)>_parent.GetNodeWeight() )
			{
				if(IsCovered(_EC,_parent,_currentEdgeNumber,_numOfNodes)==0 )
				{
					_node=_parent;
				}
			}
			else
			{
				_node=_child;
			}
			
		}
		
		
		return _node;
	}
	
	public static int Max(Node [] _nodes, Node [] _EC,int _numOfNodes)
	{
		int max=0;
		int i;
		for(i=0;i<=_numOfNodes;i++)
		{
			max=max+_nodes[i].GetNodeWeight()- _EC[i].GetNodeWeight();
			
		}
		return max;
	}
	
	public static void GetIndependentSet(int _numOfNodes, Node [] _EC, Node [] _nodes, Node [] _IS)
	{
		int i;
		
		
		for(i=0;i<_numOfNodes-1;i++)
		{
			if(IsCovered(_EC,_nodes[i],0,_numOfNodes-2)==0)
			{
				_IS[i]=_nodes[i];
			}
		}
		
		
		for(i=0;i<_numOfNodes-1;i++)
		{
			
			if(_IS[i].GetNodeId()!=-1)
			{
				System.out.print(_IS[i].GetNodeId()+", ");
			}
		}
	}
	
	public static int HasChild(Node _node, Edge[] _edges, int _numOfNodes)
	{
		int i;
		int res=0;
		for(i=0;i<_numOfNodes-1;i++)
		{
			if(_node.GetNodeId()==_edges[i].pNode.GetNodeId())
			{
				res=1;
				break;
			}
		}
		return res;
	}
	
	/*public static void postOrder(Node _node, Edge [] _edges, int _numOfNodes)
	{
		int i;
		Node [] nodes=new Node[_numOfNodes];
		
		for(i=0;i<_numOfNodes;i++)
		{
			if(HasChild(_node)==1)
		}
	}*/
	
	public static void Get1(int _numOfNodes)
	{
		
		int i;
		
		
		Node [] nodes=new Node[_numOfNodes];
	    nodes[0]=new Node(1,10);
	    nodes[1]=new Node(2,5);
	    nodes[2]=new Node(3,8);
	    nodes[3]=new Node(4,4);
	    nodes[4]=new Node(5,4);
	    nodes[5]=new Node(6,9);
	    nodes[6]=new Node(7,3);
	    nodes[7]=new Node(8,11);
	    nodes[8]=new Node(9,2);
	    nodes[9]=new Node(10,7);
	    nodes[10]=new Node(11,8);
		
		
		
		Edge [] edges=new Edge[_numOfNodes-1];
		edges[0]= new Edge(nodes[0], nodes[1]);
		edges[1]= new Edge(nodes[0], nodes[2]);
		edges[2]= new Edge(nodes[1], nodes[3]);
		edges[3]= new Edge(nodes[1], nodes[4]);
		edges[4]= new Edge(nodes[1], nodes[5]);
		edges[5]= new Edge(nodes[2], nodes[6]);
		edges[6]= new Edge(nodes[2], nodes[7]);
		edges[7]= new Edge(nodes[4], nodes[8]);
		edges[8]= new Edge(nodes[4], nodes[9]);
		edges[9]= new Edge(nodes[7], nodes[10]);
		
		Node [] EC=new Node[_numOfNodes];
		Node dummy=new Node(-1,0);
		Node [] IS = new Node[_numOfNodes];
		
		
		for(i=0;i<_numOfNodes;i++)
		{
			EC[i]=dummy;
			IS[i]=dummy;
		}
	
		for(i=_numOfNodes-2;i>=0;i--)
		{
			EC[i]=GetEdgeCover(edges[i].pNode,edges[i].cNode,EC ,edges,_numOfNodes-2,i);
		}
		
		
		
		
		
		
		
		GetIndependentSet(_numOfNodes,EC, nodes,IS);
		System.out.println("The weight of the maximum weight Independent Set of the tree: "+Max(nodes, EC, _numOfNodes-1));
		
	}
	

	
	
	
	
	public static void Get2(int _numOfNodes)
	{

		int i;
		
	    
		Node [] nodes=new Node[_numOfNodes];
	    nodes[0]=new Node(1,6);
	    nodes[1]=new Node(2,4);
	    nodes[2]=new Node(3,8);
	    nodes[3]=new Node(4,8);
	    nodes[4]=new Node(5,5);
	    nodes[5]=new Node(6,6);
	    nodes[6]=new Node(7,2);
	    nodes[7]=new Node(8,8);
	    nodes[8]=new Node(9,3);
	    nodes[9]=new Node(10,9);
	    nodes[10]=new Node(11,7);
	    nodes[11]=new Node(12,5);
	    nodes[12]=new Node(13,4);
	    nodes[13]=new Node(14,6);
	    nodes[14]=new Node(15,2);
		
		
		
		Edge [] edges=new Edge[_numOfNodes-1];
		edges[0]= new Edge(nodes[0], nodes[1]);
		edges[1]= new Edge(nodes[0], nodes[2]);
		edges[2]= new Edge(nodes[0], nodes[3]);
		edges[3]= new Edge(nodes[1], nodes[4]);
		edges[4]= new Edge(nodes[1], nodes[5]);
		
		edges[5]= new Edge(nodes[2], nodes[6]);
		edges[6]= new Edge(nodes[2], nodes[7]);
		edges[7]= new Edge(nodes[2], nodes[8]);
		
		edges[8]= new Edge(nodes[3], nodes[9]);
		edges[9]= new Edge(nodes[3], nodes[10]);
		
		edges[10]= new Edge(nodes[7], nodes[11]);
		edges[11]= new Edge(nodes[7], nodes[12]);
		edges[12]= new Edge(nodes[7], nodes[13]);
		edges[13]= new Edge(nodes[9], nodes[14]);
		
		
		Node [] EC=new Node[_numOfNodes];
		Node [] IS=new Node[_numOfNodes];
		Node dummy=new Node(-1,0);
		
		
		for(i=0;i<_numOfNodes;i++)
		{
			EC[i]=dummy;
			IS[i]=dummy;
		}
	
		for(i=_numOfNodes-2;i>=0;i--)
		{

			EC[i]=GetEdgeCover(edges[i].pNode,edges[i].cNode,EC ,edges,_numOfNodes-2,i);
			
			
		}
		
		GetIndependentSet(_numOfNodes,EC, nodes,IS);
		System.out.println("The weight of the maximum weight Independent Set of the tree: "+ Max(nodes, EC, _numOfNodes-1));
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Get1(11);
		Get2(15);
	}
}
