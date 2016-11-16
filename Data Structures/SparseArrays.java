class SparseArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int stringCount = Integer.parseInt(in.nextLine());
        String[] strings = new String[stringCount];
        for (int i = 0; i < stringCount; i++) {
            strings[i] = in.nextLine();
        }

        int queryCount = Integer.parseInt(in.nextLine());
        for (int i = 0; i < queryCount; i++) {
            String query = in.nextLine();
            int count = 0;
            for (int j = 0; j < stringCount; j++) {
                if (strings[j].equals(query))
                    count++;
            }
            System.out.println(count);
        }
    }
}
