package Queue;

public class CircularTour {

	static class petrolPump {
        public int petrol, distance;
        public petrolPump(int petrol, int distance)
        {
            this.petrol = petrol;
            this.distance = distance;
        }
    }
	
	static int tour(int gas[], int cost[]) {
		int start = 0;
		int end = 1;
		int n = gas.length;
		int currPet = gas[0] - cost[0];
		while (end != start || currPet < 0) {
			while (end != start && currPet <= 0) {
				currPet -= gas[start] - cost[start];
				start = (start + 1) % n;

				if (start == 0) {
					return -1;
				}
			}

			currPet += gas[end] - cost[end];
			end = (end + 1) % n;
		}

		return start;
	}

	 static int printTour(petrolPump p[], int n)
	  {

	    // deficit is used to store the value of the capacity as
	    // soon as the value of capacity becomes negative so as
	    // not to traverse the array twice in order to get the
	    // solution
	    int start = 0, deficit = 0;
	    int capacity = 0;
	    for (int i = 0; i < n; i++) {
	      capacity += p[i].petrol - p[i].distance;
	      if (capacity < 0) {
	        // If this particular step is not done then the
	        // between steps would be redundant
	        start = i + 1;
	        deficit += capacity;
	        capacity = 0;
	      }
	    }
	    return (capacity + deficit >= 0) ? start : -1;
	  }
	public static void main(String[] args) {

		int gas[] = { 62, 49, 8, 18, 98, 70, 39, 70, 40, 29, 71, 19, 93, 86, 43, 81, 34, 55, 44, 8, 51, 1, 86, 22, 21,
				89, 41, 91, 48, 35, 84, 26, 95 };
		int cost[] = { 62, 31, 43, 64, 92, 21, 21, 39, 55, 93, 43, 23, 31, 86, 35, 95, 9, 9, 81, 3, 45, 85, 46, 88, 23,
				58, 26, 3, 36, 49, 93, 87, 97 };

		int start = tour(gas, cost);

		System.out.println(start == -1 ? "No Solution" : "Start = " + start);
	}

}
