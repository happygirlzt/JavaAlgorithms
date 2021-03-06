<2018-06-07 Thu>

# Asymptotic Notations
## Big-Theta
The theta notation bounds a functions from above and below, so it defines exact asymptotic behavior.

Big-Theta serve as both a lower bound and upper bound.

## Big-O notation
To determine an /upper bound/ for the behavior od a function, that is, to determine how /bad/ the performance of the function can get.

## Big-Omega
To provide a crude /lower bound/ for a function.
To show how good a function can be.

# Data Structures
## Lists, stacks and queues
## Trees and graphs
## Sets, heaps
## Hashes and maps

# Algorithms
## Sorting
### Bubble Sort
### Selection Sort
### Insertion Sort
### Merge Sort
### Quick Sort
### Counting Sort
### Radix Sort
### Heap Sort
### Bucket Sort

## Graph algorithms
### Common Problems
1. Directed or undirected
2. Weighted or not
3. Sparse or dense with edges
4. Representation: adjacency matrix, adjacency list, an edge list or other sturcture

### Minimum Spanning Tree
#### Kruskal's Algorithm
#### Prim's Algorithm
### Shortest Path Problem

### Connectivity

### Detect Cycle
#### Directed Graphs
1. Depth First Search
O(V + E)

Use three colors to every vertex
- white: vertex is not processed. Initially, all vertices are white
- gray: vertex is being processed(dfs for this vertex has started, but not finished which means that all descendants (in dfs tree) of this vertex are not processed yet( or this vertex is in function call stack))
- black: vertex and all its descendants are processed.

While doing dfs, if we encounter an edge from current vertex to a gray vertex, then this edge is back edge and hence there is a cycle.

2. Breadth First Search
Step 1: Compute in-degree for each of the vertex present in the graphs
Step 2: Pick all the vertices with in-degree as 0 and add them into a queue
Step 3: Remove a vertex from a queue and:
     1. Increment count of visited nodes by 1
     2. Decrease in-degree by 1 for all its neighboring nodes
     3. If in-degree of a neighboring nodes is reduced to zero, then all it to the queue
Step 4: Repeat Step 3 until the queue is empty
Step 5: If count of visited nodes is not equal to the number of nodes in the graphm, the graph has cycle; otherwise not;


#### Undirected Graphs
1. Union-find
2. Depth-first search
O(V+E)
3. Breadth-first search

### Eulerian Path
O(E)

Visits every edge exactly once.

An Eulerian path to exist:
- At most one vertex has (outdegree - indegree) = 1
- At most one vertex has (indegree - outdegree) = 1
- All other vertices have equal in and out degrees

Find a valid starting node:
The node with exactly one extra outgoing edge(outdegree - indegree = 1), it will be the only valid start node.
Similarly, the node which (indegree - outdegree = 1) should be the end node.

### Topological Sort
The only type of graph which has a valid topological sort: Directed Acyclic Graphs(DAG)

## Dynamic programming
## Complexity analysis

# Math
## Basic probability
## Div/modulo
## Bit manipulation

# Operating Systems
## Threads, locks, processes
- Concurrency: multiple computations running simultaneously
### Process
A process is an instance of a running program that is isolated from other processes on the same machine. It has its own private section of the machine's memory.

### Thread
A thread is a locus of control inside a running program.

### Race condition
The correctness of the program(the satisfaction of postconditions and invariants) depends on the relative timing of events in concurrent computations A and B.
## Memory management
## Filesystems and networking

# System Design
## Distributed Systems
## Approximations

# References
1. [GeeksForGeeks Asymptotic Notations](https://www.geeksforgeeks.org/analysis-of-algorithms-set-3asymptotic-notations/)
2. [Detect Cycle in a directed graph using colors](https://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/)
3. [MIT 6.005 — Software Construction](http://web.mit.edu/6.005/www/fa15/classes/19-concurrency/)
4. [Hackerearth Algorithms Tutorial](https://www.hackerearth.com/zh/practice/algorithms/searching/linear-search/tutorial/)
