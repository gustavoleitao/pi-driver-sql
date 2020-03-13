package br.ufrn.imd.lii.pidriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Responsavel por padronizar o formato da URL de conexao JDBC com o PI
 * Created by Tiago on 10/02/2017.
 */
public class PiJdbcUrl {

    private static int DEFAULT_URL_TIMEOUT = Integer.valueOf(30);
    private static String DEFAULT_URL_DAS_HOST = "localhost";
    private static String DEFAULT_URL_PI_HOST = "localhost";

    private String URL_BASE_PI_ARCHIVE = "jdbc:pioledb://";
    private String URL_BASE_PI_AF = "jdbc:pioledbent://";
    private String URL_BASE_PI_INTEGRATOR = "jdbc:piintegrator://";
    private String URL_PROPRIEDADE_SEPARADOR = ";";
    private String URL_DAS_SEPARADOR = "/";
    private String URL_PROPRIEDADE_VALOR_SEPARADOR = "=";
    private String DasHost;
    private Map<String, String> urlProperties;

    public PiJdbcUrl(String DasHost, String PIHost) {
        this.DasHost = DasHost;
        urlProperties = new HashMap<>();
        setPropertie(PiJdbcDefs.PI_JDBC_URL_PROP_DATA_SOURCE, PIHost);
    }

    public void setPropertie(String key, String value) {
        urlProperties.put(key, value);
    }

    public String getUrl() {
        StringBuilder builder = new StringBuilder(URL_BASE_PI_ARCHIVE);
        builder.append(DasHost).append(URL_DAS_SEPARADOR);
        for (Map.Entry<String, String> propriedade : urlProperties.entrySet()) {
            String key = propriedade.getKey();
            String value = propriedade.getValue();
            builder.append(key).append(URL_PROPRIEDADE_VALOR_SEPARADOR).append(value);
            builder.append(URL_PROPRIEDADE_SEPARADOR);
        }
        return builder.toString();
    }

    public void setPiLogin(String user, String password) {
        setPropertie(PiJdbcDefs.PI_JDBC_URL_PROP_PI_USER, user);
        setPropertie(PiJdbcDefs.PI_JDBC_URL_PROP_PI_PASS, password);
    }

    public void setTrustedConnection() {
        setPropertie(PiJdbcDefs.PI_JDBC_URL_PROP_TRUSTED_CONNECTION_KEY, PiJdbcDefs.PI_JDBC_URL_PROP_TRUSTED_CONNECTION_VALUE);
    }

    public void setTimeout(int timeout) {
        setPropertie(PiJdbcDefs.PI_JDBC_URL_PROP_CONNECT_TIMEOUT, String.valueOf(timeout));
        setPropertie(PiJdbcDefs.PI_JDBC_URL_PROP_COMMAND_TIMEOUT, String.valueOf(timeout));
    }

    /**
     * Gera uma instancia default de br.ufrn.imd.lii.pidriver.PiJdbcUrl com DasHost e PiHost repassados.
     * Timeout definido como default.
     * @param dasHost DAS Host
     * @param piHost PI Host
     * @return instancia de br.ufrn.imd.lii.pidriver.PiJdbcUrl
     */
    public static PiJdbcUrl getDefaultPiJdbcUrl(String dasHost, String piHost) {
        PiJdbcUrl retorno = new PiJdbcUrl(dasHost, piHost);
        retorno.setTimeout(DEFAULT_URL_TIMEOUT);
        return retorno;
    }

    /**
     * Gera uma instancia default de br.ufrn.imd.lii.pidriver.PiJdbcUrl. O DasHost e PiHost sao definidos com base nas propriedades default.
     * Timeout definido como default.
     * @return instancia de br.ufrn.imd.lii.pidriver.PiJdbcUrl
     */
    public static PiJdbcUrl getDefaultPiJdbcUrl() {
        return PiJdbcUrl.getDefaultPiJdbcUrl(DEFAULT_URL_DAS_HOST, DEFAULT_URL_PI_HOST);
    }

    /**
     * Gera uma instancia do br.ufrn.imd.lii.pidriver.PiJdbcUrl padrao utilizada para o PI Archive
     * @param dasHost Host DAS
     * @param piHost Host PI
     * @param isPiLogin Verdadeiro se ha login no PI
     * @param piUser Usuario PI
     * @param piPassword Senha PI
     * @param useTrustedConnection Se ha necessidade de usar trustedConnection
     * @return Instancia de br.ufrn.imd.lii.pidriver.PiJdbcUrl
     */
    public static PiJdbcUrl getUrl(String dasHost, String piHost, boolean isPiLogin, String piUser, String piPassword, boolean useTrustedConnection) {
        PiJdbcUrl url = PiJdbcUrl.getDefaultPiJdbcUrl(dasHost, piHost);
        if (isPiLogin) {
            url.setPiLogin(piUser, piPassword);
        }
        if (useTrustedConnection) {
            url.setTrustedConnection();
        }
        return url;
    }

    @Override
    public String toString() {
        return getUrl();
    }
}
