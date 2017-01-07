
public class Node {
	private int nodeId;
	private int nodeWeight;
	private int degree;
	
	public Node(int _id, int _weight)
	{
		nodeId=_id;
		nodeWeight=_weight;
	}
	public int GetNodeWeight()
	{
		return nodeWeight;
	}
	public int GetNodeId()
	{
		return nodeId;
	}
	public int GetNodeDegree()
	{
		return degree;
	}
	public void SetNodeDegree(int _degree)
	{
		degree=_degree;
	}
}
