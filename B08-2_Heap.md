Heap
---

**TODO:** Insert your answer for task 1 - 3!

a)
  MiniHeap sorts the entries from smaller to larger=> the smallest value is at the top
  order does not matter - whether right is smaller or larger than parent node
  new node is inserted at the lowest level where there is still space.
  if the new node is smaller than the parent node, new node is swapped with parent node

  Eg: 5,4,3,2
  			5
  		       /\

  		        4
  		       /\
  		      5

  		       3
  		      /\
  		     4  5

  		       3			 2
  		      /\			/\
  		     4  5	->  	       3  5
  		    /\			      /\
  		   2 			     4

b)
 largest element is in one of the leaves
 a field sorted in ascending order is a minHeap, since each element <= the successor and is always left-justified at the next free position -> each node >= parent node


c)
  							E
  				                      / \
	                                            A    S
  			                            /\   / \
  		                                  Y  Q  U   E
  	       				  /\  /\ /
            					 S T I O N


  --> tausche S und Y


  							E
  						    /      \
  			                         A	     S
  			                        /\          /\
  		   		               S  Q	    U  E
  	       			      /\  /\       /
            				     Y T I  O      N


  --> tausche I und Q					E
  						    /      \
  			                         A	     S
  			                        /\          /\
  		    				S   I	    U	E
  	                                      /\  /\      /
            				      Y  T Q O    N

  --> tausche U und N

  							E
  				  		   /         \
  			  			  A	      S
  			 			/  \	     /  \
  		    			      S     I      N     E
  	           			     /\     /\    /
            				    Y  T   Q  O  U



  --> tausche E und S
  							E
  				  		   /         \
  			  			  A	      E
  			 			/  \	     /  \
  		    			      S     I      N     S
  	           			     /\     /\    /
            				    Y  T   Q  O  U



  --> tausche E und A  							A
  				  		   /         \
  			  			  E	      E
  			 			/  \	     /  \
  		    			      S     I      N     S
  	           			     /\     /\    /
            				    Y  T   Q  O  U

Komplexität im schlechtesten Fall: n * Einfügen in Baum --> O(n)