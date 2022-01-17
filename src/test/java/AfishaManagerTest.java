import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {

        AfishaManager manager = new AfishaManager(10);

        @Test
        void shouldAdd() {
            AfishaItem first = new AfishaItem(1, "Film1", "http://1.ru", "comedy");
            AfishaItem second = new AfishaItem(2, "Film2", "http://2.ru", "action");
            AfishaItem third = new AfishaItem(6, "Film3", "http://3.ru", "cartoon");
            AfishaItem four = new AfishaItem(3, "Film4", "http://4.ru", "horror");


            manager.add(first);
            manager.add(second);
            manager.add(third);
            manager.add(four);


            AfishaItem[] actual = manager.getLastItems();
            AfishaItem[] expected = new AfishaItem[]{four, third, second, first};

            assertArrayEquals(expected, actual);
        }

    @Test
    void shouldAfishaEmpty() {

        AfishaItem[] actual = manager.getLastItems();
        AfishaItem[] expected = new AfishaItem[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddMoreThanTen() {
        AfishaItem first = new AfishaItem(1, "Film1", "http://1.ru", "comedy");
        AfishaItem second = new AfishaItem(2, "Film2", "http://2.ru", "action");
        AfishaItem third = new AfishaItem(6, "Film5", "http://5.ru", "cartoon");
        AfishaItem fourth = new AfishaItem(3, "Film3", "http://3.ru", "horrors");
        AfishaItem fifth = new AfishaItem(4, "Film4", "http://4.ru", "cartoon");
        AfishaItem sixth = new AfishaItem(7, "Film7", "http://7.ru", "comedy");
        AfishaItem seventh = new AfishaItem(5, "Film6", "http://6.ru", "comedy");
        AfishaItem eighth = new AfishaItem(8, "Film8", "http://8.ru", "action");
        AfishaItem ninth = new AfishaItem(9, "Film9", "http://10.ru", "drama");
        AfishaItem tenth = new AfishaItem(10, "Film10", "http://9.ru", "horrors");
        AfishaItem eleventh = new AfishaItem(11, "Film11", "http://11.ru", "drama");
        AfishaItem twelfth = new AfishaItem(12, "Film12", "http://12.ru", "drama");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);

        AfishaItem[] actual = manager.getLastItems();
        AfishaItem[] expected = new AfishaItem[]{twelfth, eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }




    }