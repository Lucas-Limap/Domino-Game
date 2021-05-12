 package br.edu.univas.list;

public class List {
		
		private ListNode head;
		private ListNode last;
		
		public void insert(Piece piece) {
			
			ListNode newNode = new ListNode();
			
			if (head == null) {
			
				head = newNode;
			
			}else {
				
				last.next = newNode;
				newNode.previous = last;
			}
			
			last = newNode;
			newNode.piece = piece;
			
		}

		public String getAsString() {
	        if(head == null) {
	            return "SEM PEÇAS";
	        }
	        StringBuilder builder = new StringBuilder();
	            
	        ListNode aux = head;
	        while(aux != null) {

	            builder.append("|").append(aux.piece.getSide1());
	            builder.append("|");
	            builder.append(aux.piece.getSide2()).append("|");
	            builder.append("  ");
	            
	            aux = aux.next;
	        }
	        return builder.toString();
	    }

		private ListNode getNode(int index) {
			if(index < 0) {
		        return null;
		    }
		       
		    int i = 0;
		    ListNode aux = head;
		    while(aux != null) {
		            
		        if(index == i) {
		            return aux;
		        }
		        i++; 
		        aux = aux.next; 
		    }
		    return null;
		}
		
		public Piece getElement(int index) {
		        ListNode node = getNode(index);
		        if(node != null) {
		            return node.piece;
		        }
		        return null;
		    }
		 	 
		public Piece remove (String name) {
			 
		      
		        if(head == null) { 
		            return null; 
		        }
		        
		       
		        ListNode current = head;
		        ListNode previous = head.previous;
		        ListNode next = head.next;
		       	        
		        while(current != null) {
		            if(current.piece.toString().equals(name)) {
		               break;
		            }
		            previous = current;
		            current = current.next;
		            next = next.next;
		        }
		      
		        if(current == null) { 
		            return null; 
		        }
		        
		        Piece removePiece = current.piece;
		        
		        
		        if(this.head == this.last) { 
		            this.head = null;
		            this.last = null;
		            return removePiece;
		        }

		        if(previous == null) {
		            head = next; 
		            next.previous = null;
		        } else {
		        	
		        	if (current.next != null) {
		        		previous.next = next;
		        	    next.previous = previous;
		        	} else{
		        		
			            this.last = previous;
			           	previous.next = null;
		        	}
		            
		        }
		        
		        return removePiece;
		    }
		
		public boolean movePiece (List list, Piece piece) {
			
			boolean aux = false;
			
			if (piece != null) { 
			
				
				if (list.head == null) {
				list.insert(piece);
				aux = true;
				
				}else if (head.piece.getSide1() == piece.getSide1() || head.piece.getSide1() == piece.getSide2()) {
					
					aux = true; 
					
					if(head.piece.getSide1() == piece.getSide1()) {
						int aux1 = piece.getSide1();
						int aux2 = piece.getSide2();
						piece.setSide2(aux1);
						piece.setSide1(aux2);
						
					}
					ListNode novoNode = new ListNode();
					head.previous = novoNode;
					novoNode.piece = piece;
					novoNode.next = head;
					head = novoNode;
					
					
				 }else if (last.piece.getSide2() == piece.getSide1() || last.piece.getSide2() == piece.getSide2()) {
					 
					 aux = true;
					 
					 if(last.piece.getSide2() == piece.getSide2()) {
							int aux1 = piece.getSide1();
							int aux2 = piece.getSide2();
							piece.setSide2(aux1);
							piece.setSide1(aux2);
							
					}
					 ListNode newNode = new ListNode();
					 last.next = newNode;
					 newNode.piece = piece;
					 newNode.previous = last;
					 last = newNode;
					 
				 }else {
					 
				 }
			 }else {
  
			 }
			 
			return aux;
		 }
		
		public void createPieces () {
			
			int aux = 0;
			
			for (int i = 0; i < 7; i++) {
				
				for(int j = 0; j+aux < 7; j++) {
					
					Piece newPiece = new Piece();
					newPiece.setSide1(i);
					newPiece.setSide2(j+aux);
					insert(newPiece);
								
				}
				aux++;
			}
		
		}
		
		public void setPieces(List list, List mainList) {
			
			Piece piece;
			
			int aux = listLength(mainList);
			
			for (int i = 0; i < 7; i++) {
				int random = 1 + (int) (Math.random() * aux);
				piece = getElement(random);
				piece = remove(piece.toString());
				list.insert(piece);
				aux--;
			}
			
		}

		public int listLength (List list) {
			
			ListNode aux1 = list.head;
			ListNode aux2 = list.last;
			
			int aux = 0;
			
			while (!aux1.piece.toString().equals(aux2.piece.toString())) {
				
				aux1 = aux1.next;
				aux++;
				if(aux1 == null) {
					break;
				}
			}
			
			return aux;
		
		}
	}


