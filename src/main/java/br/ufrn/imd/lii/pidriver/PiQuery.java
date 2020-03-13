package br.ufrn.imd.lii.pidriver;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PiQuery {

    private static String SQL_SELECT_DECLARACAO = "SELECT";
    private static String SQL_FROM_DECLARACAO = "FROM";
    private static String SQL_WHERE_DECLARACAO = "WHERE";
    private static String SQL_AND_DECLARACAO = "AND";
    private static String SQL_OR_DECLARACAO = "OR";
    private static String SQL_IGUAL_OPERADOR = "=";
    private static String SQL_LIKE_DECLARACAO = "LIKE";
    private static String SQL_IN_DECLARACAO = "IN";
    private static String SQL_ESPACO = " ";
    private static String SQL_VIRGULA = ",";
    private static String SQL_PONTO_VIRGULA = ";";
    private static String SQL_ASPAS = "'";
    private static String SQL_PARENTESES_INICIO = "(";
    private static String SQL_PARENTESES_FIM = ")";
    private static String SQL_TOP_DECLARACAO = "TOP";
    private static String SQL_BETWEEN_DECLARACAO = "BETWEEN";
    private static String SQL_INSERT_DECLARACAO = "INSERT";
    private static String SQL_VALUES_DECLARACAO = "VALUES";
    private static String SQL_DIGCODE = "DIGCODE";

    /**
     * Retorna a query utilizada para o metodo SearchItemsQuery.
     * <p>
     * Padrao: SELECT br.ufrn.imd.lii.pidriver.PiItem.query FROM br.ufrn.imd.lii.pidriver.PiJdbcDefs.POINT2_TABLE_NAME WHERE tag LIKE 'tag' AND (descriptor LIKE 'description' OR descriptor LIKE '');
     *
     * @param tag         nome do item
     * @param description descricao
     * @return A query de execucao
     */
    public static String searchItemsQuery(String tag, String description) {
        StringBuilder builder = new StringBuilder();
        builder.append(SQL_SELECT_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiItem.query()).append(SQL_ESPACO);
        builder.append(SQL_FROM_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_TABLE_NAME_PIPOINT2).append(SQL_ESPACO);
        builder.append(SQL_WHERE_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_TAG).append(SQL_ESPACO);
        builder.append(SQL_LIKE_DECLARACAO).append(SQL_ESPACO).append(SQL_ASPAS);
        builder.append(tag).append(SQL_ASPAS).append(SQL_ESPACO);
        builder.append(SQL_AND_DECLARACAO).append(SQL_ESPACO);
        builder.append(SQL_PARENTESES_INICIO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_DESCRIPTOR).append(SQL_ESPACO);
        builder.append(SQL_LIKE_DECLARACAO).append(SQL_ESPACO).append(SQL_ASPAS);
        builder.append(description).append(SQL_ASPAS);
        builder.append(SQL_ESPACO).append(SQL_OR_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_DESCRIPTOR).append(SQL_ESPACO);
        builder.append(SQL_LIKE_DECLARACAO).append(SQL_ESPACO).append(SQL_ASPAS);
        builder.append(SQL_ASPAS).append(SQL_PARENTESES_FIM);
        builder.append(SQL_PONTO_VIRGULA);
        return builder.toString();
    }

    /**
     * Retorna a query utilizada para o metodo getTagInfo.
     * <p>
     * Padrao: SELECT br.ufrn.imd.lii.pidriver.PiItemInfo.query FROM br.ufrn.imd.lii.pidriver.PiJdbcDefs.POINT2_TABLE_NAME WHERE tag = 'tag';
     *
     * @param tag Nome do item
     * @return A query de execucao
     */
    public static String tagInfoQuery(String tag) {
        StringBuilder builder = new StringBuilder();
        builder.append(SQL_SELECT_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiItemInfo.query()).append(SQL_ESPACO);
        builder.append(SQL_FROM_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_TABLE_NAME_PIPOINT2).append(SQL_ESPACO);
        builder.append(SQL_WHERE_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_TAG).append(SQL_ESPACO);
        builder.append(SQL_IGUAL_OPERADOR).append(SQL_ESPACO).append(SQL_ASPAS);
        builder.append(tag).append(SQL_ASPAS);
        builder.append(SQL_PONTO_VIRGULA);
        return builder.toString();
    }


    /**
     * Retorna a query utilizada para o metodo getDigitalState.
     * <p>
     * Padrao: SELECT br.ufrn.imd.lii.pidriver.PiItemInfoDigitalStates.query FROM br.ufrn.imd.lii.pidriver.PiJdbcDefs.PIDS_TABLE_NAME WHERE digitalset = 'digitalset';
     *
     * @param digitalset Nome do grupo digital
     * @return A query de execucao
     */
    public static String getDigitalStateQuery(String digitalset) {
        StringBuilder builder = new StringBuilder();
        builder.append(SQL_SELECT_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiItemInfoDigitalStates.query()).append(SQL_ESPACO);
        builder.append(SQL_FROM_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_TABLE_NAME_PIDS).append(SQL_ESPACO);
        builder.append(SQL_WHERE_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIDS_DIGITAL_SET).append(SQL_ESPACO);
        builder.append(SQL_IGUAL_OPERADOR).append(SQL_ESPACO).append(SQL_ASPAS);
        builder.append(digitalset).append(SQL_ASPAS);
        builder.append(SQL_PONTO_VIRGULA);
        return builder.toString();
    }

    /**
     * Retorna a query utilizada para o metodo getSnapshots.
     * <p>
     * Padrao: SELECT br.ufrn.imd.lii.pidriver.PiItemValue.query FROM br.ufrn.imd.lii.pidriver.PiJdbcDefs.PISNAPSHOT_TABLE_NAME,br.ufrn.imd.lii.pidriver.PiJdbcDefs.PIPOINTS2_TABLE_NAME WHERE pisnapshot.tag=pipoint2.tag AND tag IN (tags);
     *
     * @param tag Tag a ser buscado último valor
     * @return A query de execucao
     */
    public static String snapshotQuery(String tag) {
        return snapshotQuery(Arrays.asList(tag));
    }


    /**
     * Retorna a query utilizada para o metodo getSnapshots.
     * <p>
     * Padrao: SELECT br.ufrn.imd.lii.pidriver.PiItemValue.query FROM br.ufrn.imd.lii.pidriver.PiJdbcDefs.PISNAPSHOT_TABLE_NAME,br.ufrn.imd.lii.pidriver.PiJdbcDefs.PIPOINTS2_TABLE_NAME WHERE pisnapshot.tag=pipoint2.tag AND tag IN (tags);
     *
     * @param tags Lista de tags na query
     * @return A query de execucao
     */
    public static String snapshotQuery(List<String> tags) {
        StringBuilder builder = new StringBuilder();
        builder.append(SQL_SELECT_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiItemValue.query(PiItemValue.ItemValueSource.PI_SOURCE_SNAPSHOT)).append(SQL_ESPACO);
        builder.append(SQL_FROM_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_TABLE_NAME_PISNAPSHOT).append(SQL_VIRGULA);
        builder.append(PiJdbcDefs.PI_JDBC_TABLE_NAME_PIPOINT2).append(SQL_ESPACO);
        builder.append(SQL_WHERE_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PISNAPSHOT_TAG);
        builder.append(SQL_IGUAL_OPERADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PIPOINT2_TAG).append(SQL_ESPACO);
        builder.append(SQL_AND_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PISNAPSHOT_TAG).append(SQL_ESPACO);
        builder.append(SQL_IN_DECLARACAO).append(SQL_ESPACO);

        builder.append(SQL_PARENTESES_INICIO);
        for (int i = 0; i < tags.size(); i++) {
            if (i != 0) builder.append(SQL_VIRGULA);
            builder.append(SQL_ASPAS);
            builder.append(tags.get(i));
            builder.append(SQL_ASPAS);
        }
        builder.append(SQL_PARENTESES_FIM);
        builder.append(SQL_PONTO_VIRGULA);
        return builder.toString();
    }

    /**
     * Retorna a query utilizada para o metodo getHistoricalValues.
     * <p>
     * Padrao: SELECT TOP nPoint br.ufrn.imd.lii.pidriver.PiItemValue.query FROM br.ufrn.imd.lii.pidriver.PiJdbcDefs.PICOMP2_TABLE_NAME,br.ufrn.imd.lii.pidriver.PiJdbcDefs.PIPOINTS2_TABLE_NAME WHERE picomp2.tag=pipoint2.tag AND picomp2.tag='tags' AND picomp2.time BETWEEN 'initDate' AND 'finalDate';
     *
     * @param tag      Nome do tag
     * @param initDate  Data de inicio
     * @param finalDate Data final
     * @param nPoints   numero de pontos
     * @return A query de execucao
     */
    public static String historicalValuesQuery(String tag, Date initDate, Date finalDate, int nPoints) {
        StringBuilder builder = new StringBuilder();
        builder.append(SQL_SELECT_DECLARACAO).append(SQL_ESPACO);
        builder.append(SQL_TOP_DECLARACAO).append(SQL_ESPACO).append(nPoints).append(SQL_ESPACO);
        builder.append(PiItemValue.query(PiItemValue.ItemValueSource.PI_SOURCE_COMP)).append(SQL_ESPACO);
        builder.append(SQL_FROM_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_TABLE_NAME_PICOMP2).append(SQL_VIRGULA);
        builder.append(PiJdbcDefs.PI_JDBC_TABLE_NAME_PIPOINT2).append(SQL_ESPACO);
        builder.append(SQL_WHERE_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PICOMP2_TAG);
        builder.append(SQL_IGUAL_OPERADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PIPOINT2_TAG).append(SQL_ESPACO);
        builder.append(SQL_AND_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PICOMP2_TAG).append(SQL_ESPACO);
        builder.append(SQL_IGUAL_OPERADOR).append(SQL_ESPACO).append(SQL_ASPAS);
        builder.append(tag).append(SQL_ASPAS).append(SQL_ESPACO);
        builder.append(SQL_AND_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PICOMP2_TIME).append(SQL_ESPACO);
        builder.append(SQL_BETWEEN_DECLARACAO).append(SQL_ESPACO);
        builder.append(SQL_ASPAS).append(PIUtil.convertDateToString(initDate)).append(SQL_ASPAS).append(SQL_ESPACO);
        builder.append(SQL_AND_DECLARACAO).append(SQL_ESPACO);
        builder.append(SQL_ASPAS).append(PIUtil.convertDateToString(finalDate)).append(SQL_ASPAS);
        builder.append(SQL_PONTO_VIRGULA);
        return builder.toString();
    }

    /**
     * Retorna a query utilizada para o metodo getHistoricalInterpolatedValues.
     * <p>
     * Padrao: SELECT TOP nPoint br.ufrn.imd.lii.pidriver.PiItemValue.query FROM br.ufrn.imd.lii.pidriver.PiJdbcDefs.PIINTERP2_TABLE_NAME,br.ufrn.imd.lii.pidriver.PiJdbcDefs.PIPOINTS2_TABLE_NAME WHERE piinterp2.tag=pipoint2.tag AND piinterp2.tag='tags' AND piinterp2.time BETWEEN 'initDate' AND 'finalDate' AND piinterp2.timestep= 'timestep';
     *
     * @param name      Nome do tag
     * @param initDate  Data de inicio
     * @param finalDate Data final
     * @param nPoints   numero de pontos
     * @param timestep  timestep utilizado
     * @return A query de execucao
     */
    public static String interpolatedHistoricalValuesQuery(String name, Date initDate, Date finalDate, int nPoints, String timestep) {
        StringBuilder builder = new StringBuilder();
        builder.append(SQL_SELECT_DECLARACAO).append(SQL_ESPACO);
        builder.append(SQL_TOP_DECLARACAO).append(SQL_ESPACO).append(nPoints).append(SQL_ESPACO);
        builder.append(PiItemValue.query(PiItemValue.ItemValueSource.PI_SOURCE_INTERP)).append(SQL_ESPACO);
        builder.append(SQL_FROM_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_TABLE_NAME_PIINTERP2).append(SQL_VIRGULA);
        builder.append(PiJdbcDefs.PI_JDBC_TABLE_NAME_PIPOINT2).append(SQL_ESPACO);
        builder.append(SQL_WHERE_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PIINTERP2_TAG);
        builder.append(SQL_IGUAL_OPERADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PIPOINT2_TAG).append(SQL_ESPACO);
        builder.append(SQL_AND_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PIINTERP2_TAG).append(SQL_ESPACO);
        builder.append(SQL_IGUAL_OPERADOR).append(SQL_ESPACO).append(SQL_ASPAS);
        builder.append(name).append(SQL_ASPAS).append(SQL_ESPACO);
        builder.append(SQL_AND_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PIINTERP2_TIME).append(SQL_ESPACO);
        builder.append(SQL_BETWEEN_DECLARACAO).append(SQL_ESPACO);
        builder.append(SQL_ASPAS).append(PIUtil.convertDateToString(initDate)).append(SQL_ASPAS).append(SQL_ESPACO);
        builder.append(SQL_AND_DECLARACAO).append(SQL_ESPACO);
        builder.append(SQL_ASPAS).append(PIUtil.convertDateToString(finalDate)).append(SQL_ASPAS).append(SQL_ESPACO);
        builder.append(SQL_AND_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PIINTERP2_TIMESTEP).append(SQL_ESPACO);
        builder.append(SQL_IGUAL_OPERADOR).append(SQL_ESPACO).append(SQL_ASPAS);
        builder.append(timestep).append(SQL_ASPAS);
        builder.append(SQL_PONTO_VIRGULA);
        return builder.toString();
    }

    /**
     * Retorna a query utilizada para o metodo writeValue.
     * <p>
     * Padrao: INSERT picomp2 (tag,time,value) VALUES ('tag', 'timestamp', 'value');
     *
     * @param tag       Nome da tag
     * @param timestamp Timestamp do evento
     * @param value     Valor do evento
     * @return A query de execucao
     */
    public static String writeValueQuery(String tag, Date timestamp, String value) {
        StringBuilder builder = new StringBuilder();
        builder.append(SQL_INSERT_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_TABLE_NAME_PICOMP2).append(SQL_ESPACO);
        builder.append(SQL_PARENTESES_INICIO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PICOMP2_TAG).append(SQL_VIRGULA);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PICOMP2_TIME).append(SQL_VIRGULA);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PICOMP2_VALUE);
        builder.append(SQL_PARENTESES_FIM).append(SQL_ESPACO);
        builder.append(SQL_VALUES_DECLARACAO).append(SQL_ESPACO);
        builder.append(SQL_PARENTESES_INICIO);
        builder.append(SQL_ASPAS).append(tag).append(SQL_ASPAS).append(SQL_VIRGULA);
        builder.append(SQL_ASPAS).append(PIUtil.convertDateToString(timestamp)).append(SQL_ASPAS).append(SQL_VIRGULA);
        builder.append(SQL_ASPAS).append(value).append(SQL_ASPAS);
        builder.append(SQL_PARENTESES_FIM);
        builder.append(SQL_PONTO_VIRGULA);
        return builder.toString();
    }

    /**
     * Retorna a query utilizada para o metodo getDigitalStateFromCode.
     * <p>
     * Padrao: SELECT br.ufrn.imd.lii.pidriver.PiItemInfoDigitalStates.query FROM br.ufrn.imd.lii.pidriver.PiJdbcDefs.PIDS_TABLE_NAME WHERE code = code;
     *
     * @param code
     * @return
     */
    public static String digitalStateFromCodeQuery(String code) {
        StringBuilder builder = new StringBuilder();
        builder.append(SQL_SELECT_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiItemInfoDigitalStates.query()).append(SQL_ESPACO);
        builder.append(SQL_FROM_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_TABLE_NAME_PIDS).append(SQL_ESPACO);
        builder.append(SQL_WHERE_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIDS_CODE).append(SQL_ESPACO);
        builder.append(SQL_IGUAL_OPERADOR).append(SQL_ESPACO);
        builder.append(code);
        builder.append(SQL_PONTO_VIRGULA);
        return builder.toString();
    }

    /**
     * Retorna a query utilizada para o metodo writeDigitalValue.
     * <p>
     * Padrao: INSERT picomp2 (tag,time,value) VALUES ('tag', 'timestamp', DIGCODE('value'));
     *
     * @param tag       Nome da tag
     * @param timestamp Timestamp do evento
     * @param value     Valor digital do evento
     * @return A query de execucao
     */
    public static String writeDigitalValueQuery(String tag, String timestamp, String value) {
        StringBuilder builder = new StringBuilder();
        builder.append(SQL_INSERT_DECLARACAO).append(SQL_ESPACO);
        builder.append(PiJdbcDefs.PI_JDBC_TABLE_NAME_PICOMP2).append(SQL_ESPACO);
        builder.append(SQL_PARENTESES_INICIO);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PICOMP2_TAG).append(SQL_VIRGULA);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PICOMP2_TIME).append(SQL_VIRGULA);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PICOMP2_VALUE);
        builder.append(SQL_PARENTESES_FIM).append(SQL_ESPACO);
        builder.append(SQL_VALUES_DECLARACAO).append(SQL_ESPACO);
        builder.append(SQL_PARENTESES_INICIO);
        builder.append(SQL_ASPAS).append(tag).append(SQL_ASPAS).append(SQL_VIRGULA);
        builder.append(SQL_ASPAS).append(timestamp).append(SQL_ASPAS).append(SQL_VIRGULA);
        builder.append(SQL_DIGCODE).append(SQL_PARENTESES_INICIO).append(SQL_ASPAS);
        builder.append(value).append(SQL_ASPAS).append(SQL_PARENTESES_FIM);
        builder.append(SQL_PARENTESES_FIM);
        builder.append(SQL_PONTO_VIRGULA);
        return builder.toString();
    }

}
