package br.ufrn.imd.lii.pidriver;

/**
 * Created by Tiago on 20/02/2017.
 */
public class PiItemValue {

    private static String SQL_COLUNA_SEPARADOR =  ",";

    private String tag;
    private String time;
    private String value;
    private String status;
    private String pointtype;
    private String pointtypex;

    private boolean isNullValue;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPointtype() {
        return pointtype;
    }

    public void setPointtype(String pointtype) {
        this.pointtype = pointtype;
    }

    public String getPointtypex() {
        return pointtypex;
    }

    public void setPointtypex(String pointtypex) {
        this.pointtypex = pointtypex;
    }

    public boolean isNullValue() {
        return isNullValue;
    }

    public void setNullValue(boolean nullValue) {
        isNullValue = nullValue;
    }

    @Override
    public String toString() {
        return "br.ufrn.imd.lii.pidriver.PiItemValue{" +
                "tag='" + tag + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PiItemValue that = (PiItemValue) o;

        if (!tag.equals(that.tag)) return false;
        if (!time.equals(that.time)) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        return status.equals(that.status);
    }

    @Override
    public int hashCode() {
        int result = tag.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + status.hashCode();
        return result;
    }

    /**
     * Retorna os parametros que devem ser solicitados na query SQL para o br.ufrn.imd.lii.pidriver.PiItemValue
     *
     * @param opt A opcao de origem do ItemValue, util para especificar a tabela a ser utilizada na query
     * @return String com as colunas desejadas.
     */
    public static String query(ItemValueSource opt) {
        StringBuilder builder = new StringBuilder();
        switch (opt) {
            case PI_SOURCE_SNAPSHOT: {
                builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PISNAPSHOT_TAG).append(SQL_COLUNA_SEPARADOR);
                builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PISNAPSHOT_TIME).append(SQL_COLUNA_SEPARADOR);
                builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PISNAPSHOT_VALUE).append(SQL_COLUNA_SEPARADOR);
                builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PISNAPSHOT_STATUS).append(SQL_COLUNA_SEPARADOR);
                break;
            }
            case PI_SOURCE_COMP: {
                builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PICOMP2_TAG).append(SQL_COLUNA_SEPARADOR);
                builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PICOMP2_TIME).append(SQL_COLUNA_SEPARADOR);
                builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PICOMP2_VALUE).append(SQL_COLUNA_SEPARADOR);
                builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PICOMP2_STATUS).append(SQL_COLUNA_SEPARADOR);
                break;
            }
            case PI_SOURCE_INTERP: {
                builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PIINTERP2_TAG).append(SQL_COLUNA_SEPARADOR);
                builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PIINTERP2_TIME).append(SQL_COLUNA_SEPARADOR);
                builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PIINTERP2_VALUE).append(SQL_COLUNA_SEPARADOR);
                builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PIINTERP2_STATUS).append(SQL_COLUNA_SEPARADOR);
                break;
            }
        }
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PIPOINT2_POINTTYPE).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_FULL_NAME_PIPOINT2_POINTTYPEX);
        return builder.toString();
    }

    public enum ItemValueSource {
        PI_SOURCE_SNAPSHOT, PI_SOURCE_COMP, PI_SOURCE_INTERP;
    }
}
