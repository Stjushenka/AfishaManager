public class AfishaRepository {
    private AfishaItem[] items = new AfishaItem[10];

    public AfishaItem[] findAll() {
        return items;
    }

    AfishaItem findById(int id) {
        for (AfishaItem newItem : items) {
            if (newItem.getMovieId() == id) {
                return newItem;
            }
        }
        return null;
    }

    public void save(AfishaItem newItem) {
        int resultLength = items.length + 1;
        AfishaItem[] tmp = new AfishaItem[resultLength];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }

        tmp[tmp.length - 1] = newItem;
        items = tmp;
    }

    public boolean removeById(int id) {
        int length = items.length - 1;
        AfishaItem[] tmp = new AfishaItem[length];
        int index = 0;
        boolean founded = false;
        for (AfishaItem item : items) {
            if (item.getMovieId() != id) {
                tmp[index] = item;
                index++;
            } else {
                founded = true;
            }
        }
        items = tmp;
        return founded;
    }

    public void removeAll() {
        items = new AfishaItem[10];
    }


}
