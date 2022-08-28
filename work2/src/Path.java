/**
 * class to find the path automatically
 * @author yunzhuo
 *
 */
public class Path {
	Map cityMap;
	public Path(Map theMap) {
		cityMap = theMap;		
	}
/**
 * method findPath uses the method nextcell
 * to add or remove cells of the stack then find the best path
 */
	public void findPath(){
		ArrayStack<MapCell> aStack = new ArrayStack(100,10,10);
		MapCell start = cityMap.getStart();
		aStack.push(start);
		(start).markInStack();
		int infLoop = 0;
		MapCell next = start;
		while (infLoop != 1) {
			next = nextCell(next);
			if (aStack.peek().isDestination()) {
				System.out.println("Reach the destination. There are " + aStack.size() + "cells in the path");
				break;
			}
			if (next != null) {
				aStack.push(next);
				next.markInStack();
				//System.out.print("1");
			} 
			if (next == null) {
				try {
				aStack.pop().markOutStack();
				next = aStack.peek();
				}catch (EmptyStackException e) {
				System.out.println("No valid path found");
				break;
				}
			}
			}
	}
/**
 *method nextCell determine the celltype and
 *direction all neighbours of the cell
 * @param cell
 * @return the best suitable neighbour
 */	
	private MapCell nextCell(MapCell cell) {
		MapCell n;
		for (int i = 0;i<4;i++ ) {
			if (cell.getNeighbour(i) != null) {
				n = cell.getNeighbour(i);
			if (!n.isBlock() &&n.isDestination() &&!n.isMarked() && cell.isIntersection()) return n ;
			if (!n.isBlock() &&n.isDestination() &&!n.isMarked() && cell.isNorthRoad() && i == 0) return n;
			if (!n.isBlock() &&n.isDestination() &&!n.isMarked() && cell.isEastRoad() && i == 1) return n;
			if (!n.isBlock() &&n.isDestination() &&!n.isMarked() && cell.isSouthRoad() && i == 2) return n;
			if (!n.isBlock() &&n.isDestination() &&!n.isMarked() && cell.isWestRoad() && i == 3) return n;
			}
		}
		for (int i1 = 0;i1<4;i1++ ) {
			if (cell.getNeighbour(i1) != null) {
				n = cell.getNeighbour(i1);
			if (!n.isBlock() &&n.isIntersection() &&!n.isMarked()) return n;
			}
		}
		for (int i2 = 0;i2<4;i2++ ) {
			if (cell.getNeighbour(i2) != null) {
				n = cell.getNeighbour(i2);
				if (!n.isBlock() && i2 == 0) {
				if (n.isNorthRoad() &&!n.isMarked() && (cell.isNorthRoad()||cell.isIntersection())) return n;
		} else if (!n.isBlock() && i2 == 1) {
			if (n.isEastRoad() &&!n.isMarked() && (cell.isEastRoad()||cell.isIntersection())) return n;
		} else if (!n.isBlock() && i2 == 2) {
			if (n.isSouthRoad() &&!n.isMarked() && (cell.isSouthRoad()||cell.isIntersection())) return n;
		}else if (!n.isBlock() && i2 == 3) {
			if (n.isWestRoad() &&!n.isMarked()&&(cell.isWestRoad()||cell.isIntersection())) return n;
		}
				}
		}
 
		return null;

	}
}

