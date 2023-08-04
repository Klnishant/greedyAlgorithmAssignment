public class GasStation {
    public static int findStartingStation(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;  // Total gas in the tank
        int currentTank = 0;  // Current gas in the tank
        int startingStation = 0;  // Starting station index

        for (int i = 0; i < n; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];

            // If the current tank is negative, we cannot reach the next station from the current starting station.
            // So, we reset the current tank and choose the next station as the new starting station.
            if (currentTank < 0) {
                currentTank = 0;
                startingStation = i + 1;
            }
        }

        // If the total gas is greater than or equal to the total cost, there exists a solution, and the starting station is valid.
        return totalTank >= 0 ? startingStation : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int startingStation = findStartingStation(gas, cost);
        System.out.println("Starting Gas Station Index: " + startingStation);
    }

}

