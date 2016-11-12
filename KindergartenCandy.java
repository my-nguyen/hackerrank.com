import java.util.*;

class KindergartenCandy {
    static int distributeCandy(int[] scores) {
        int[] counts = new int[scores.length];
        // each child receives at least 1 candy
        for (int i = 0; i < counts.length; i++)
            counts[i] = 1;

        int tally = 0;
        for (int j = 1; tally < counts.length; j++) {
            for (int i = 0; i < counts.length; i++) {
                if (scores[i] == j) {
                    if (j != 1) {
                        if (i == 0) {
                            if (scores[i] > scores[i+1]) {
                                counts[i] = counts[i+1] + 1;
                            }
                        } else if (i == counts.length-1) {
                            if (scores[i] > scores[i-1]) {
                                counts[i] = counts[i-1] + 1;
                            }
                        } else {
                            if (scores[i] > scores[i-1] && scores[i] > scores[i+1]) {
                                counts[i] = Math.max(counts[i-1], counts[i+1]) + 1;
                            } else if (scores[i] > scores[i-1]) {
                                counts[i] = counts[i-1] + 1;
                            } else if (scores[i] > scores[i+1]) {
                                counts[i] = counts[i+1] + 1;
                            }
                        }
                    }

                    tally++;
                    System.out.println("score: " + j + " at " + i + ", tally: " + tally);
                    if (tally == counts.length)
                        break;
                }
            }
        }

        int sum = 0;
        for (int count : counts)
            sum += count;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] scores = new int[count];
        for (int i = 0; i < count; i++) {
            scores[i] = scanner.nextInt();
        }

        System.out.println(distributeCandy(scores));
    }
}
