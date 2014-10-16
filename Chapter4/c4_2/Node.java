public class Node<E> {
    private E data;
    private boolean visited;

    public Node(E data) {
	this.data = data;
    }
    
    public Node() {

    }

    public E getData() {
	return data;
    }

    public boolean isVisited() {
	return visited;
    }

    public void setVisited(boolean v) {
	visited = v;
    }

    public void setData(E data) {
	this.data = data;
    }
}
