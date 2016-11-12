// passes #1, 2
// fails #3, 4, 5... 11
class PortfolioManager {
    int function(String tree) {
        String[] tokens = tree.split(" ");
        for (String string : tokens)
            System.out.print(string);
        System.out.println();
        int max = 0;
        int maxLevel = (int)(Math.log(tokens.length+1) / Math.log(2));
        System.out.println("tokens: " + tokens.length + ", log: " + Math.log(tokens.length+1)/Math.log(2));
        int[] totals = new int[maxLevel];
        System.out.println("level from 0 to " + maxLevel);
        for (int level = 0; level < maxLevel; level++) {
            System.out.println("level " + level + ": ");
            for (int i = (int)Math.pow(2, level)-1; i < Math.pow(2, level+1)-1; i++) {
                System.out.println("i: " + i + ", token: " + tokens[i]);
                if (!tokens[i].equals("#")) {
                    totals[level] += Integer.parseInt(tokens[i]);
                }
            }
            System.out.println("total " + totals[level]);
        }
        int odd = 0;
        for (int i = 0; i < totals.length; i += 2)
            odd += totals[i];
        int even = 0;
        for (int i = 1; i < totals.length; i += 2)
            even += totals[i];
        return Math.max(odd, even);
    }

    public static void main(String[] args) {
        
    }
}
