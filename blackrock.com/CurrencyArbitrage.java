// passes #1, 2, 6
// fails #3, 4, 5
    static int[] arbitrage(String[] quotes) {
        int[] profits = new int[quotes.length];
        for (int i = 0; i < quotes.length; i++) {
            // System.out.println(quotes[i]);
            String[] tokens = quotes[i].split(" ");
            double dollars = 100000.0F;
            for (String token : tokens) {
                float rate = Float.parseFloat(token);
                dollars /= rate;
            }
            int profit = (int)dollars - 100000;
            if (profit < 0)
                profit = 0;
            // System.out.println(profit);
            profits[i] = profit;
        }
        return profits;
    }
