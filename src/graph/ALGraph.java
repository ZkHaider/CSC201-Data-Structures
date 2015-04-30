package graph;

import java.util.*;
import java.util.List;

/**
 * Created by ZkHaider on 4/30/15.
 */

/*
    Name: Haider Khan
    Pledge: "I pledge that I have acted honorably" - Haider Khan
    Date: 4-29-15
    Class: CSC-202 Data Structures
    Description: To demonstrate the use of an adjacency list as a Graph ADT
 */

public class ALGraph<E> {

    private HashMap<E, List<E>> mAdjacencyList;
    private int mSize;

    /*
        Initialize an empty graph
     */
    public ALGraph() {
        this.mAdjacencyList = new HashMap<E, List<E>>();
        this.mSize = 0;
    }

    /*
        @return return the number of vertices in this graph
     */
    public int getSize() {
        return mSize;
    }

    /*
        Add a new vertex into the graph, I used a hashmap approach since lookup would simply be O(1)
     */
    public int addVertex(E e) {
        if (!mAdjacencyList.containsKey(e)) {
            mAdjacencyList.put(e, new ArrayList<E>());
        }
        mSize++;

        // I would question returning the index in the addVertex method
        int index = 0;
        List keys = new ArrayList(mAdjacencyList.keySet());
        for (int i = 0; i < keys.size(); i++) {
            Object obj = keys.get(i);
            if (obj.equals(e))
                index = keys.indexOf(obj);
        }

        return index;
    }

    /*
        Add an edge in the graph by checking to see if the vertex @param v is in the graph then add @param w
     */
    public void addEdge(E v, E w) {
        if (!mAdjacencyList.containsKey(v) || !mAdjacencyList.containsKey(w))
            throw new IllegalArgumentException("Vertex does not exist in this graph");

        if (!mAdjacencyList.get(v).contains(w) && !mAdjacencyList.get(w).contains(v)) {
            mAdjacencyList.get(v).add(w);
            mAdjacencyList.get(w).add(v);
        } else {
            throw new IllegalArgumentException("One of these vertices does not exist in the graph");
        }
    }

    /*
        Remove the vertex @param v but check first to see if that vertex exists in the graph
        The following code removes the list containing the edges as well
     */
    public void removeVertex(E v) {
        if (!mAdjacencyList.containsKey(v))
            throw new IllegalArgumentException("Vertex does not exist in this graph");
        mAdjacencyList.remove(v);
        for (Map.Entry<E, List<E>> entry : mAdjacencyList.entrySet()) {
            if (entry.getValue().contains(v)) {
                int index = entry.getValue().indexOf(v);
                E e = entry.getValue().remove(index); // Garbage collect
            }
        }
        mSize--;
    }

    /*
        Remove the vertex @param w from the key value @param v from the hashmap's value list
     */
    public void removeEdge(E v, E w) {
        if (!mAdjacencyList.containsKey(v) || !mAdjacencyList.containsKey(w))
            throw new IllegalArgumentException("Vertex does not exist in the graph");
        int index = mAdjacencyList.get(v).indexOf(w);
        mAdjacencyList.get(v).remove(index);
    }

    /*
        Return if the value list of the key @param v contains the value @param w
     */
    public boolean adjacent(E v, E w) {
        if (!mAdjacencyList.containsKey(v) || !mAdjacencyList.containsKey(w))
            throw new IllegalArgumentException("Vertex does not exist in the graph");

        return mAdjacencyList.get(v).contains(w);
    }

    public ArrayList<E> incidentVertices(E v) {
        if (!mAdjacencyList.containsKey(v))
            throw new IllegalArgumentException("Vertex does not exist");
        return (ArrayList<E>) mAdjacencyList.get(v);
    }

    public static void main(String[] args) {

        // Create a new graph of type string
        ALGraph<String> stringGraph = new ALGraph<String>();

        // Create two test variables
        String one = "One";
        String two = "Two";

        // Get their index
        int indexOfOne = stringGraph.addVertex(one);
        int indexOfTwo = stringGraph.addVertex(two);

        // Print their indices --- Works!
        System.out.println(String.valueOf(indexOfOne));
        System.out.println(String.valueOf(indexOfTwo));

        stringGraph.removeVertex(one);
        System.out.println(String.valueOf(stringGraph.getSize()));

        String three = "three";

        int indexOfThree = stringGraph.addVertex(three);
        System.out.println(indexOfThree);

        stringGraph.addEdge(two, three);

        // Returns true --- Works!
        System.out.println(String.valueOf(stringGraph.adjacent(two, three)));

        String four = "four";
        String five = "five";
        String six = "six";

        stringGraph.addVertex(four);
        stringGraph.addVertex(five);
        stringGraph.addVertex(six);

        stringGraph.addEdge(two, four);
        stringGraph.addEdge(two, five);
        stringGraph.addEdge(two, six);

        // Returns all the adjacent strings for the adjacency graph --- Works!
        List<String> incidentVertices = stringGraph.incidentVertices(two);
        for (String s : incidentVertices)
            System.out.println(s);

    }
}
