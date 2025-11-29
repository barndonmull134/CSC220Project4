import java.util.*;

public class NameRecord {

    private static final int START_YEAR = 1900;
    private static final int DECADE_INTERVAL = 10;
    private static final int MAX_RANK = 1100;
    private static final int NUM_DECADES = 11;
    
    private String name;
    private List<Integer> counts;
    

    public NameRecord(String dataLine) {

        Scanner lineScanner = new Scanner(dataLine);

        if (lineScanner.hasNext()) {

            this.name = lineScanner.next();
        } else {

            this.name = "Unknown";
            this.counts = new ArrayList<>();
            lineScanner.close();
            return;
        }

        this.counts = new ArrayList<>();

        while (lineScanner.hasNextInt()) {

            this.counts.add(lineScanner.nextInt());
        }

        lineScanner.close();
        System.out.println("Created NameRecord: " + this.name + " with " + this.counts.size() + " counts.");

    }

    public String getName() {
        return name;
    }

    public int getRank(int decade) {

        if (decade >= 0 && decade < this.counts.size()) {
            return this.counts.get(decade);
        }

        return 0;
    }

    public int bestYear() {

        int bestRank = MAX_RANK + 1;
        int bestDecadeIndex = - 1;

        for (int i = 0; i < this.counts.size(); i++) {
            int currentRank = this.counts.get(i);

            if (currentRank != 0 && currentRank < bestRank){

                bestRank = currentRank;
            }

        }

        if (bestDecadeIndex == -1) {
            return START_YEAR;
        }

        return START_YEAR + (bestDecadeIndex * DECADE_INTERVAL);

    }

    public void plot() {

        StdDraw.setXscale(0, NUM_DECADES - 1);
    }

}