
public class Edge {
	Node pNode;
	Node cNode;
	int hasEdge;
	int numEdge;
	 
	
	public Edge(Node _sNode, Node _dNode)
	{
		 int sDegree, dDegree;
		 pNode=_sNode;
		 cNode=_dNode;
		 hasEdge=1;	
		 sDegree=pNode.GetNodeDegree();
		 sDegree=sDegree+1;
		 pNode.SetNodeDegree(sDegree);
		 dDegree=cNode.GetNodeDegree();
		 dDegree=dDegree+1;
		 cNode.SetNodeDegree(dDegree);
		 numEdge=numEdge+1;
	}

}
