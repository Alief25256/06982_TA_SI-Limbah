package projeklimbah;

import Database.koneksi;
import java.sql.SQLException;
import java.text.ParseException;
import View.TransaksiView;
public class Main {
     public static void main(String[] args) throws SQLException, ParseException {
        
         new TransaksiView().show();
    }
    
}
