package br.ufrn.imd.lii.pidriver;

/**
 * Classe entidade que representa cada informacao de item do PI Archive
 * Created by Tiago on 14/02/2017.
 */
public class PiItemInfo {

    private static String SQL_COLUNA_SEPARADOR = ",";

    private String tag;
    private String descriptor;
    private String pointtype;
    private String pointtypex;
    private String engunits;
    private Double zero;
    private Double span;
    private String digitalset;
    private String dataaccess;

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

    public String getEngunits() {
        return engunits;
    }

    public void setEngunits(String engunits) {
        this.engunits = engunits;
    }

    public Double getZero() {
        return zero;
    }

    public void setZero(Double zero) {
        this.zero = zero;
    }

    public Double getSpan() {
        return span;
    }

    public void setSpan(Double span) {
        this.span = span;
    }

    public String getDigitalset() {
        return digitalset;
    }

    public void setDigitalset(String digitalset) {
        this.digitalset = digitalset;
    }

    public String getDataaccess() {
        return dataaccess;
    }

    public void setDataaccess(String dataaccess) {
        this.dataaccess = dataaccess;
    }

    @Override
    public String toString() {
        return "br.ufrn.imd.lii.pidriver.PiItemInfo{" +
                "tag='" + tag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PiItemInfo that = (PiItemInfo) o;

        return tag.equals(that.tag);
    }

    @Override
    public int hashCode() {
        return tag.hashCode();
    }

    /**
     * Retorna os parametros que devem ser solicitados na query SQL para o br.ufrn.imd.lii.pidriver.PiItemInfo
     * @return String com as colunas desejadas.
     */
    public static String query() {
        StringBuilder builder = new StringBuilder();
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_TAG).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_DESCRIPTOR).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_POINTTYPE).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_POINTTYPEX).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_ENGUNITS).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_ZERO).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_SPAN).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_DIGITAL_SET).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIPOINT2_DATA_ACCESS);
        return builder.toString();
    }
}