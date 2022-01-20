import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;



class AfishaManagerTest {

    private AfishaRepository repo = Mockito.mock(AfishaRepository.class);

    AfishaManager manager = new AfishaManager(repo);

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

    @Test
    void shouldAdd() {

        manager.add(first);
        manager.add(second);
        manager.add(third);

        AfishaItem[] returned = new AfishaItem[]{first, second, third};
        doReturn(returned).when(repo).findAll();
        doNothing().when(repo).save(fourth);

        manager.add(fourth);
        AfishaItem[] actual = manager.getLastItems();
        AfishaItem[] expected = new AfishaItem[]{third, second, first};

        assertArrayEquals(expected, actual);
        verify(repo).save(fourth);


    }

    @Test
    void shoulAfishaEmpty() {

        AfishaItem[] returned = new AfishaItem[]{};
        doReturn(returned).when(repo).findAll();
        doNothing().when(repo).save(first);

        manager.add(first);
        AfishaItem[] actual = manager.getLastItems();
        AfishaItem[] expected = new AfishaItem[]{};

        assertArrayEquals(expected, actual);
        verify(repo, times(1)).save(first);
    }

    @Test
    void shouldAddMoreThanTen() {


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


        AfishaItem[] returned = new AfishaItem[]
                {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        doReturn(returned).when(repo).findAll();
        doNothing().when(repo).save(twelfth);

        manager.add(twelfth);
        AfishaItem[] actual = manager.getLastItems();
        AfishaItem[] expected = new AfishaItem[]
                {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
        verify(repo, times(1)).save(twelfth);
    }





}