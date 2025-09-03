public class Actors {
    int actorCount;
    String[] actorNames;

    Actors(int count, String[] names) {
        this.actorCount = count;
        this.actorNames = names;
    }

    public int getActorCount() {
        return actorCount;
    }

    public void setActorCount(int actorCount) {
        this.actorCount = actorCount;
    }

    public String[] getActorNames() {
        return actorNames;
    }

    public void setActorNames(String[] actorNames) {
        this.actorNames = actorNames;
    }
}
