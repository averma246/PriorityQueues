// @author: Ana Verma

public class PQHeap implements PriorityQueue{

    Integer[] data;
    int numElts = 0;


    // resizes the underlying array by doubling the number
    // of elements that can be stored
    private void resize() {
	   Integer[] temp = new Integer[numElts * 2 + 1];

	   for(int i = 1; i <= numElts; i++) {
	       temp[i] = data[i];
	   }
	   data = temp;
    }

    public PQHeap() {
	   data = new Integer[2];
    }

    //add element
    public void add(Integer add){
        if(data.length - 1 == numElts) resize();

        numElts++;
        data[numElts] = add;
        siftUp(numElts);
    }

    //remove element 
    public Integer remove(){
        Integer toReturn = data[1];
        swap(1, numElts);
        numElts--;
        siftDown(1);

        return toReturn;
    }


    //size
    public int size(){
        return numElts;
    }


    //is the PQ empty 
    public boolean isEmpty(){
        return (numElts == 0);
    }

    //siftDown -- helper method in moving down the heap from a certain node
    private void siftDown(int pos){
        //if the node is a leaf or if it it already larger than its two children, no further 
        //action needs to be taken, so and method returns
        if(isLeaf(pos) || (data[pos] >= data[2 * pos] && data[pos] >= data[2 * pos +1]) ) return;

        int largerChild = 0;

        if(2*pos+1 > numElts || data[2 * pos] >= data[2 * pos + 1]) largerChild = 2*pos;

        else largerChild = 2 * pos + 1;

        swap(pos, largerChild);

        siftDown(largerChild);
    }

    //siftUp -- helper method in moving up the heap from a certain node
    private void siftUp(int pos){
        //if this node is already smaller than its parent, no further action needed 
        if (pos == 1 || data[pos] <= data[pos / 2]) return;

        swap(pos,pos/2);

        siftUp(pos/2);
    }

    //swap -- switch the positions of two elements
    private void swap (int pos1, int pos2){
        //temporarily store the value at one of the positons 
        Integer temp = data[pos1];

        //change the element at one of the positions 
        data[pos1] = data[pos2];

        //change the element at the other position
        data[pos2] = temp;
    }

    private boolean isLeaf(int pos){
        return (2*pos > numElts && 2*pos+1 > numElts);
    }


} 
