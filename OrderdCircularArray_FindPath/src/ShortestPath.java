/**
 * class to find the path automatically
 * @author yunzhuo
 *
 */
public class ShortestPath {
	CityMap cityMap;
	public ShortestPath(CityMap theMap) {
		cityMap = theMap;
	}
	/**
	 * method ShortestPath uses the method nextcell()
	 * to add or remove cells of the stack then find the shortest path
	 * 
	 */
	public void findShortestPath() {
		OrderedCircularArray<MapCell> list = new OrderedCircularArray<MapCell>();
		MapCell start = cityMap.getStart();
		list.insert(start, 0);
		start.markInList();
		int distance = 0;
		boolean found = false;
		//first while loop to stop until find shortest path or no path found
		while (!list.isEmpty() && !start.isDestination()) {
			MapCell nearest = list.getSmallest();
			nearest.markOutList();
			if (nearest.isDestination()) {
		//don't know why it print wrong number when write at bottom
				System.out.println("The shortest path contains "+ (1+nearest.getDistanceToStart()) +" cells.");
				found = true;
				break;
			}else {
				MapCell next = nextCell(nearest);
		//second while loop to try every possible neighbor
				while(next != null) {
					distance = 1 + nearest.getDistanceToStart();
					if (next.getDistanceToStart() > distance) {
						next.setDistanceToStart(distance);
						next.setPredecessor(nearest);
					}
					int disToS = next.getDistanceToStart();
					if (next.isMarkedInList() && disToS < list.getValue(next)) {
						list.changeValue(next, disToS);
					} else if (!next.isMarkedInList()) {
						list.insert(next, disToS);
						next.markInList();
					}
					next = nextCell(nearest);
				}
			}
		}
		if (!found) {
			System.out.println("No valid path.");
		} 	
	}
	/**
	 *method nextCell determine the celltype and
	 *direction all neighbours of the cell
	 * @param cell
	 * @return a valid cell
	 */	
	private MapCell nextCell(MapCell cell) {
		MapCell n;
		for (int i2 = 0; i2 < 4; i2++) {
			if (cell.getNeighbour(i2) != null) {
				n = cell.getNeighbour(i2);
				//if current cell is north road or intersection, then its neighborcell
				//must be intersection or north road or destination to return,etc.
				if (!n.isBlock() && i2 == 0) {
					if ((n.isNorthRoad() || n.isIntersection() || n.isDestination()) && !n.isMarked()
							&& (cell.isNorthRoad() || cell.isIntersection() || cell.isStart()))
						return n;
				} else if (!n.isBlock() && i2 == 1) {
					if ((n.isEastRoad() || n.isIntersection() || n.isDestination()) && !n.isMarked()
							&& (cell.isEastRoad() || cell.isIntersection() || cell.isStart()))
						return n;
				} else if (!n.isBlock() && i2 == 2) {
					if ((n.isSouthRoad() || n.isIntersection() || n.isDestination()) && !n.isMarked()
							&& (cell.isSouthRoad() || cell.isIntersection() || cell.isStart()))
						return n;
				} else if (!n.isBlock() && i2 == 3) {
					if ((n.isWestRoad() || cell.isIntersection() || n.isDestination()) && !n.isMarked()
							&& (cell.isWestRoad() | cell.isIntersection() || cell.isStart()))
						return n;
				}
			}
		}
		return null;
	}

}
