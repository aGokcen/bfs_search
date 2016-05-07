        ======README ======
Bfs Search Algorithm Implementation
Alpaslan GOKCEN - #515077
-----------------------------------
Classes of program:
-----------------------------------
Node:
----------
This keeps data of our location and also keeps previous location.
This node class has 3 attiribute which are pRow,pCol and path.
pRow and pCol are integers which keeps current location of node.
Path is Node which keeps previous location.
Node is used for creating simple linked-list.
Node has 2 constuctor which are overloded.One is initializes with intergers other is intializes with strings.
getNode() - functions returns node like exapmle -> '(3,2)' ,first item is pRow second is pCol 
----------

bfs:
----------
This class has 4 attiribute and 3 function
This class uses composition technique that has 2 Node object.
travelled type is vector that keeps nodes.
Q type is Queque that keeps nodes.
start and end is node class objects.

LoopCheck(node) - is function that takes 1 parameter and checks it is travelled or not? and return boolean variable True or False.
bfs(node,node) - this is constuctor function that takes two node and initializes classes start and end variables than add start node in Q.
search() - This function tries to find solution for using our start and end positions, infinitly itarates until the goal reach or Q is empty and returns vector of our path or null.

Main:
----------
This is our main class and includes main function. This functions reads problem.txt file using bufferreader. Bufferreaders creates nodes with this informations and sents this nodes to the bfs class. Bfs's search() functions returns the result and the solution appends to the solution.txt file.


