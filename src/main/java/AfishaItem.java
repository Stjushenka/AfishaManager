import  lombok.AllArgsConstructor ;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AfishaItem {
    private int movieId;
    private String movieName;
    private String movieUrl;
    private String movieGenre;


}
