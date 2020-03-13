package br.ufrn.imd.lii.pidriver;

/**
 * Classe entidade que representa os estados digitais de item do PI Archive
 * Created by Tiago on 17/02/2017.
 */
public class PiItemInfoDigitalStates {

    private static String SQL_COLUNA_SEPARADOR = ",";

    private String digitalset;
    private String name;
    private String code;

    public String getDigitalset() {
        return digitalset;
    }

    public void setDigitalset(String digitalset) {
        this.digitalset = digitalset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "br.ufrn.imd.lii.pidriver.PiItemInfoDigitalStates{" +
                "digitalset='" + digitalset + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PiItemInfoDigitalStates that = (PiItemInfoDigitalStates) o;

        if (digitalset != null ? !digitalset.equals(that.digitalset) : that.digitalset != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = digitalset != null ? digitalset.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    /**
     * Retorna os parametros que devem ser solicitados na query SQL para o br.ufrn.imd.lii.pidriver.PiItemInfoDigitalStates
     *
     * @return String com as colunas desejadas.
     */
    public static String query() {
        StringBuilder builder = new StringBuilder();
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIDS_CODE).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIDS_NAME).append(SQL_COLUNA_SEPARADOR);
        builder.append(PiJdbcDefs.PI_JDBC_COL_NAME_PIDS_DIGITAL_SET);
        return builder.toString();
    }
}
