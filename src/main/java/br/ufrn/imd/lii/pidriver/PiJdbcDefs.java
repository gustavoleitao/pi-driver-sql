package br.ufrn.imd.lii.pidriver;

/**
 * Classe responsavel por oferecer um catalogo com todas as definicoes relacionadas ao driver PI JDBC
 * Created by Tiago on 10/02/2017.
 */
public class PiJdbcDefs {

    public static final String PI_JDBC_DRIVER_CLASS_NAME = "com.osisoft.jdbc.Driver";

    public static final String PI_JDBC_URL_PROP_DATA_SOURCE = "Data Source";
    public static final String PI_JDBC_URL_PROP_PI_USER = "User ID";
    public static final String PI_JDBC_URL_PROP_PI_PASS = "Password";
    public static final String PI_JDBC_URL_PROP_TRUSTED_CONNECTION_KEY = "Integrated Security";
    public static final String PI_JDBC_URL_PROP_TRUSTED_CONNECTION_VALUE = "SSPI";
    public static final String PI_JDBC_URL_PROP_CONNECT_TIMEOUT = "Connect Timeout";
    public static final String PI_JDBC_URL_PROP_COMMAND_TIMEOUT = "Command Timeout";

    public static final String PI_JDBC_PROPERTIES_CONNECTION_DAS_USER = "user";
    public static final String PI_JDBC_PROPERTIES_CONNECTION_DAS_PASS = "password";
    public static final String PI_JDBC_PROPERTIES_CONNECTION_TRUSTED_CONNECTION = "TrustedConnection";
    public static final String PI_JDBC_PROPERTIES_CONNECTION_PROTOCOL_ORDER = "ProtocolOrder";
    public static final String PI_JDBC_PROPERTIES_CONNECTION_LOG_CONSOLE = "LogConsole";
    public static final String PI_JDBC_PROPERTIES_CONNECTION_LOG_LEVEL = "LogLevel";

    public static final String PI_JDBC_TABLE_NAME_PIPOINT2 = "pipoint2";
    public static final String PI_JDBC_TABLE_NAME_PIPOINT = "pipoint";
    public static final String PI_JDBC_TABLE_NAME_PISNAPSHOT = "pisnapshot";
    public static final String PI_JDBC_TABLE_NAME_PICOMP2 = "picomp2";
    public static final String PI_JDBC_TABLE_NAME_PIINTERP2 = "piinterp2";
    public static final String PI_JDBC_TABLE_NAME_PIDS = "pids";

    public static final String PI_JDBC_COL_NAME_PIPOINT2_TAG = "tag";
    public static final String PI_JDBC_COL_NAME_PIPOINT2_DESCRIPTOR = "descriptor";
    public static final String PI_JDBC_COL_NAME_PIPOINT2_POINTID = "pointid";
    public static final String PI_JDBC_COL_NAME_PIPOINT2_POINTTYPE = "pointtype";
    public static final String PI_JDBC_COL_NAME_PIPOINT2_POINTTYPEX = "pointtypex";
    public static final String PI_JDBC_COL_NAME_PIPOINT2_TYPICALVALUE = "typicalvalue";
    public static final String PI_JDBC_COL_NAME_PIPOINT2_ZERO = "zero";
    public static final String PI_JDBC_COL_NAME_PIPOINT2_ENGUNITS = "engunits";
    public static final String PI_JDBC_COL_NAME_PIPOINT2_SPAN = "span";
    public static final String PI_JDBC_COL_NAME_PIPOINT2_DIGITAL_SET = "digitalset";
    public static final String PI_JDBC_COL_NAME_PIPOINT2_DATA_ACCESS = "dataaccess";
    public static final String PI_JDBC_COL_NAME_PIDS_CODE = "code";
    public static final String PI_JDBC_COL_NAME_PIDS_NAME = "name";
    public static final String PI_JDBC_COL_NAME_PIDS_DIGITAL_SET = "digitalset";
    public static final String PI_JDBC_COL_NAME_PISNAPSHOT_TAG = "tag";
    public static final String PI_JDBC_COL_NAME_PISNAPSHOT_TIME = "time";
    public static final String PI_JDBC_COL_NAME_PISNAPSHOT_VALUE = "value";
    public static final String PI_JDBC_COL_NAME_PISNAPSHOT_STATUS = "status";
    public static final String PI_JDBC_COL_NAME_PICOMP2_TAG = "tag";
    public static final String PI_JDBC_COL_NAME_PICOMP2_STATUS = "status";
    public static final String PI_JDBC_COL_NAME_PICOMP2_VALUE = "value";
    public static final String PI_JDBC_COL_NAME_PICOMP2_TIME = "time";
    public static final String PI_JDBC_COL_NAME_PIINTERP2_TAG = "tag";
    public static final String PI_JDBC_COL_NAME_PIINTERP2_STATUS = "status";
    public static final String PI_JDBC_COL_NAME_PIINTERP2_VALUE = "value";
    public static final String PI_JDBC_COL_NAME_PIINTERP2_TIME = "time";
    public static final String PI_JDBC_COL_NAME_PIINTERP2_TIMESTEP = "timestep";

    public static final String PI_JDBC_COL_FULL_NAME_PIPOINT2_TAG = "pipoint2.tag";
    public static final String PI_JDBC_COL_FULL_NAME_PIPOINT2_DESCRIPTOR = "pipoint2.descriptor";
    public static final String PI_JDBC_COL_FULL_NAME_PIPOINT2_POINTID = "pipoint2.pointid";
    public static final String PI_JDBC_COL_FULL_NAME_PIPOINT2_POINTTYPE = "pipoint2.pointtype";
    public static final String PI_JDBC_COL_FULL_NAME_PIPOINT2_POINTTYPEX = "pipoint2.pointtypex";
    public static final String PI_JDBC_COL_FULL_NAME_PIPOINT2_TYPICALVALUE = "pipoint2.typicalvalue";
    public static final String PI_JDBC_COL_FULL_NAME_PIPOINT2_ZERO = "pipoint2.zero";
    public static final String PI_JDBC_COL_FULL_NAME_PIPOINT2_ENGUNITS = "pipoint2.engunits";
    public static final String PI_JDBC_COL_FULL_NAME_PIPOINT2_SPAN = "pipoint2.span";
    public static final String PI_JDBC_COL_FULL_NAME_PIPOINT2_DIGITAL_SET = "pipoint2.digitalset";
    public static final String PI_JDBC_COL_FULL_NAME_PIPOINT2_DATA_ACCESS = "pipoint2.access";
    public static final String PI_JDBC_COL_FULL_NAME_PIDS_CODE = "pids.code";
    public static final String PI_JDBC_COL_FULL_NAME_PIDS_NAME = "pids.name";
    public static final String PI_JDBC_COL_FULL_NAME_PIDS_DIGITAL_SET = "pids.digitalset";
    public static final String PI_JDBC_COL_FULL_NAME_PISNAPSHOT_TAG = "pisnapshot.tag";
    public static final String PI_JDBC_COL_FULL_NAME_PISNAPSHOT_TIME = "pisnapshot.time";
    public static final String PI_JDBC_COL_FULL_NAME_PISNAPSHOT_VALUE = "pisnapshot.value";
    public static final String PI_JDBC_COL_FULL_NAME_PISNAPSHOT_STATUS = "pisnapshot.status";
    public static final String PI_JDBC_COL_FULL_NAME_PICOMP2_TAG = "picomp2.tag";
    public static final String PI_JDBC_COL_FULL_NAME_PICOMP2_STATUS = "picomp2.status";
    public static final String PI_JDBC_COL_FULL_NAME_PICOMP2_VALUE = "picomp2.value";
    public static final String PI_JDBC_COL_FULL_NAME_PICOMP2_TIME = "picomp2.time";
    public static final String PI_JDBC_COL_FULL_NAME_PIINTERP2_TAG = "piinterp2.tag";
    public static final String PI_JDBC_COL_FULL_NAME_PIINTERP2_STATUS = "piinterp2.status";
    public static final String PI_JDBC_COL_FULL_NAME_PIINTERP2_VALUE = "piinterp2.value";
    public static final String PI_JDBC_COL_FULL_NAME_PIINTERP2_TIME = "piinterp2.time";
    public static final String PI_JDBC_COL_FULL_NAME_PIINTERP2_TIMESTEP = "piinterp2.timestep";


    public static final String PI_JDBC_DIGITAL_TYPE = "D";
    public static final String PI_JDBC_REAL_TYPE = "R";
    public static final String PI_JDBC_STRING_TYPE = "S";
    public static final String PI_JDBC_INTEGER_TYPE = "I";

    public static final String PI_JDBC_TIMESTAMP_TYPE = "timestamp";

    public static final String PI_JDBC_STATUS_GOOD = "0";


}
