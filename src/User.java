public class User {
    private int rank;
    private int progress;

    public User() {
        rank = -8;
        progress = 0;
    }

    public int getRank() {
        return rank;
    }
    public int getProgress() {
        return progress;
    }
    public void incProgress(int problemRank) {
        if (problemRank == 0 || problemRank > 8 || problemRank < -8) throw new IllegalArgumentException(
                    "The rank of an activity cannot be less than 8, 0, or greater than 8!");
        if (problemRank < rank) progress++;
        else if (problemRank == rank) progress += 3;
        else if (problemRank > rank) {
            if (problemRank > 0 && rank < 0) {
                progress += 10 * (problemRank - rank - 1) * (problemRank - rank - 1);
            }
            else
                progress += 10 * (problemRank - rank) * (problemRank - rank);
        }

        while (progress >= 100) {
            if (rank == -1) {
                rank = 1;
            } else {
                rank++;
            }
            progress -= 100;
        }
    }

    public String toString() {
        return "User{rank=" + rank + ", progress=" + progress + '}';
    }

}
