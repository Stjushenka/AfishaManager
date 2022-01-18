public class AfishaManager {
    private AfishaRepository repo;
    private int itemsToReturn;

    public AfishaManager(int itemsToReturn) {
        this.itemsToReturn = itemsToReturn;
    }

    public AfishaManager(AfishaRepository repo) {
        this.repo = repo;
        this.itemsToReturn = 10;
    }

    public void add(AfishaItem newItem) {
        repo.save(newItem);
    }

    public void removeById(int id) {repo.removeById(id);};


    public AfishaItem[] getLastItems() {
        int resultLength = itemsToReturn;
        AfishaItem[] items = repo.findAll();
        if (resultLength > items.length) {
            resultLength = items.length;
        }

        AfishaItem[] result = new AfishaItem[resultLength];

        for (int i = 0; i < resultLength; i++) {
            result[i] = items[items.length - i - 1];
        }
        return result;
    }
}
