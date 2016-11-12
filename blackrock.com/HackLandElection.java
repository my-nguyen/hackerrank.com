// challenge 2. this passes all tests
class HackLandElection {
    static String electionWinner(String[] votes) {
        // keep count of the frequency of occurrence of each candidate's name
        Map<String, Integer> map = new HashMap<>();
        for (String vote : votes) {
            Integer count = map.get(vote);
            if (count == null)
                map.put(vote, 1);
            else
                map.put(vote, count+1);
        }

        // find the max count
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }

        // collect all names with the same vote count as max, while maintaining
        // the names in alphabetical order
        SortedMap<String, Integer> map2 = new TreeMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max)
                map2.put(entry.getKey(), entry.getValue());
        }

        // the last entry of the sorted map is the candidate's name to return
        return map2.lastKey();
    }

    public static void main(String[] args) {

    }
}
