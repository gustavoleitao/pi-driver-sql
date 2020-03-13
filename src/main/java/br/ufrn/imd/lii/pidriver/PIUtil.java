package br.ufrn.imd.lii.pidriver;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PIUtil {

    public static String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
    public static String TIMESTAMP_LOCALE = "";
    public static String DATE_TYPE_FORMAT =  "dd-MMM-yyyy HH:mm:ss";

    /**
     * Transforma o <code>date</code> fornecido em string. Util para geracao de query SQL.
     *
     * @param date   O date a ser convertido
     * @return A String representando o <code>date</code>
     */
    public static String convertDateToString(Date date) throws IllegalArgumentException {
        String retorno;
        if (date == null) {
            throw new IllegalArgumentException("A instancia date repassada e nula");
        }
        try {
            DateFormat formater = new SimpleDateFormat(TIMESTAMP_FORMAT, getLocale(TIMESTAMP_LOCALE));
            retorno = formater.format(date);
        } catch (Throwable t) {
            throw new IllegalArgumentException( "Algum erro ocorreu durante tentativa de conversao de date para string no formato " + TIMESTAMP_FORMAT, t);
        }
        return retorno;
    }

    private static Locale getLocale(String locale) {
        Locale retorno;
        try {
            retorno = Locale.forLanguageTag(locale);
        } catch (Throwable t) {
            retorno = Locale.getDefault();
        }
        return retorno;
    }

    static void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
    }

}
