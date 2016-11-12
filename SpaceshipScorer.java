import java.io.*;
import java.util.*;

class Spaceship implements Comparable<Spaceship> {
    int id;
    long startTime;
    long endTime;
    int index;

    Spaceship(String[] tokens) {
        id = Integer.parseInt(tokens[0]);
        startTime = Long.parseLong(tokens[1]);
        endTime = Long.parseLong(tokens[2]);
    }

    public String toString() {
       String results = id + " " + startTime + " " + endTime;
       return results;
    }

    public int compareTo(Spaceship other) {
        return this.id - other.id;
    }
}

class StartTimeComparator implements Comparator<Spaceship> {
    public int compare(Spaceship left, Spaceship right) {
        if (left.startTime > right.startTime)
            return 1;
        if (left.startTime < right.startTime)
            return -1;
        return 0;
    }
}

class EndTimeComparator implements Comparator<Spaceship> {
    public int compare(Spaceship left, Spaceship right) {
        if (left.endTime > right.endTime)
            return 1;
        if (left.endTime < right.endTime)
            return -1;
        return 0;
    }
}

class IdComparator implements Comparator<Spaceship> {
    public int compare(Spaceship left, Spaceship right) {
        if (left.id > right.id)
            return 1;
        if (left.id < right.id)
            return -1;
        return 0;
    }
}

class Score implements Comparable<Score> {
    int id;
    int score;

    Score(int id) {
        this.id = id;
        this.score = 0;
    }

    public String toString() {
        String string = id + " " + score;
        return string;
    }

    public int compareTo(Score other) {
        if (this.score != other.score)
            return this.score - other.score;
        else
            return this.id - other.id;
    }
}

class SpaceshipScorer {
    static int latestStart(List<Spaceship> list) {
        long startTime = 0;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            Spaceship ship = list.get(i);
            if (ship.startTime > startTime) {
                startTime = ship.startTime;
                index = i;
            }
        }
        return index;
    }

    static int findShip(List<Spaceship> list, Spaceship object) {
        int index = Collections.binarySearch(list, object);
        return list.get(index).index;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        List<Spaceship> starters = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            String[] tokens = line.split(" ");
            Spaceship ship = new Spaceship(tokens);
            starters.add(ship);
        }

        Collections.sort(starters, new StartTimeComparator());
        Spaceship last = starters.get(starters.size() - 1);

        List<Spaceship> finishers = new ArrayList<>(starters);
        Collections.sort(finishers, new EndTimeComparator());
        for (int i = 0; i < finishers.size(); i++) {
            finishers.get(i).index = i;
        }
        Collections.sort(finishers, new IdComparator());

        List<Score> scores = new ArrayList<>();
        for (int i = starters.size()-1; i >= 0; i--) {
            Spaceship starter = starters.get(i);
            int index = findShip(finishers, starter);
            Score score = new Score(starter.id);
            scores.add(score);
            // System.out.println("outer loop, i: " + i);

            for (int j = i+1; j < starters.size(); j++) {
                // System.out.println("inner loop, j: " + j);
                int jndex = findShip(finishers, starters.get(j));
                if (jndex < index) {
                    score.score += 1;
                }
            }

        }

        Collections.sort(scores);
        for (Score score : scores)
            System.out.println(score);
    }
}
