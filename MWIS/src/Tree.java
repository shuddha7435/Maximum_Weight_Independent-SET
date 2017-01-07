
public class Tree {
 Node sNode;
 Node dNode;
 int hasEdge;
 int numEdge;
 
 public Tree(Node _sNode, Node _dNode)
 {
	 int sDegree, dDegree;
	 sNode=_sNode;
	 dNode=_dNode;
	 hasEdge=1;	
	 sDegree=sNode.GetNodeDegree();
	 sDegree=sDegree+1;
	 sNode.SetNodeDegree(sDegree);
	 dDegree=dNode.GetNodeDegree();
	 dDegree=dDegree+1;
	 dNode.SetNodeDegree(dDegree);
	 numEdge=numEdge+1;
 }
 
 public void GetMaxDegree()
 {
	 int max, i;
	 i=10;
	
		 System.out.println(numEdge);
	 
	 
	 
 }
 
}
