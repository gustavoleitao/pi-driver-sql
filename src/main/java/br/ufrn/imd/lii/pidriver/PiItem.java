package br.ufrn.imd.lii.pidriver;

/**
 * Classe entidade que representa cada item do PI Archive
 * Created by Tiago on 13/02/2017.
 */
public class PiItem {

    private static String SQL_COLUNA_SEPARADOR = ",";

    private String tag;
    private String descriptor;
    private Double pointid;
    private String pointtype;
    private String pointtypex;
    private Double typicalvalue;
    private Double zero;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public Double getPointid() {
        return pointid;
    }

    public void setPointid(Double pointid) {
        this.pointid = pointid;
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

    public Double getTypicalvalue() {
        return typicalvalue;
    }

    public void setTypicalvalue(Double typicalvalue) {
        this.typicalvalue = typicalvalue;
    }

    public Double getZero() {
        return zero;
    }

    public void setZero(Double zero) {
        this.zero = zero;
    }

    @Override
    public String toString() {
        return "br.ufrn.imd.lii.pidriver.PiItem{" +
                "tag='" + tag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PiItem piItem = (PiItem) o;

        if (!tag.equals(piItem.tag)) return false;
        if (!descriptor.equals(piItem.descriptor)) return false;
        if (!pointid.equals(piItem.pointid)) return false;
        if (!pointtype.equals(piItem.pointtype)) return false;
        return pointtypex.equals(piItem.pointtypex);
    }

    @Override
    public int hashCode() {
        int result = tag.hashCode();
        result = 31 * result + descriptor.hashCode();
        result = 31 * result + pointid.hashCode();
        result = 31 * result + pointtype.hashCode();
        result = 31 * result + pointtypex.hashCode();
        return result;
    }

    /**
     * Retorna os parametros que devem ser solicitados na query SQL para o br.ufrn.imd.lii.pidriver.PiItem
     * @return String com as colunas desejadas.
     */
    public static String query() {
        StringBuilder builder = new StringBuilder();
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_TAG).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_DESCRIPTOR).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_POINTID).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_POINTTYPE).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_POINTTYPEX).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_TYPICALVALUE).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_ZERO);
        return builder.toString();
    }
}
