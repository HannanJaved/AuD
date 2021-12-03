Solution
---
AVL-Baum ist ein Baum, dessen linke und rechte Teilbäume entweder die gleiche Höhe haben oder sich um maximal 1 unterscheiden.
Der Grund dafür ist, dass die Höhe des Baums auf einem minimalen Wert gehalten wird und der Baum nicht zu einer Liste wird.
Und dass die TimeComplexity(Suchaufwand) auf einem Minimum bleibt.

**TODO** show what happens during the insertion of the numbers 14, 15,
17, 7, 5, 10 and 16 (in this order) into an AVL-Tree

Tree + 14
			14
			/\
		(both sub trees have height 0,add next)
Tree + 15
			14
			/\
			  15
			  /\
                (AVL condition satisfied,add next)
Tree + 17
			14
			/\
			 15
			 /\
			  17
		(AVL Condition not satisfied, changes needed)

		        |
		        v

		        15
		        /\
		       14 17
		       /\ /\
Tree + 7
			    15
		        /\
		       14 17
		       /\ /\
		      7
		     /\

		     (AVL Condition satisfied, add next)

Tree + 5
			    15
		        /\
		       14 17
		       /\ /\
		      7
		     /\
		    5
		    (AVL Condition not satisfied, changes needed)

		        |
		        v

		    	15
		        /\
		       7 17
		      /\ /\
		     5 14
		    /\ /\
Tree + 10
			        15
		         /       \
		        7        17
		      /  \      /  \
		     5    14
		    / \  / \
		        10
		        /\
		   (AVL Condition not satisfied, changes needed)

		        |
		        v

		          14
		        /    \
		       7     15
		      /\     /\
		     5 10     17
		    /\ /\     /\
Tree + 16
			      14
		        /    \
		       7     16
		      /\     /\
		     5 10   15 17
		    /\ /\   /\ /\

		    (AVL Condition satisfied)