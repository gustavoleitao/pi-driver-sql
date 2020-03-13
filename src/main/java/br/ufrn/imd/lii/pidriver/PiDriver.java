package br.ufrn.imd.lii.pidriver;

import java.sql.*;
import java.util.Arrays;

public class PiDriver {

    private final String dashost;

    private final String pihost;

    private String user;

    private String senha;

    public PiDriver(String dashost, String pihost, String user, String senha) throws ClassNotFoundException {
        this.user = user;
        this.senha = senha;
        this.dashost = dashost;
        this.pihost = pihost;
        Class.forName("com.osisoft.jdbc.Driver");
    }

    private Connection getConnection() throws SQLException {
        PiJdbcUrl piUrl  = PiJdbcUrl.getDefaultPiJdbcUrl(dashost, pihost);
        piUrl.setPiLogin(user, senha);
        return DriverManager.getConnection( piUrl.getUrl());
    }

    public ResultSet executarQuery(String query) throws SQLException {
        ResultSet retorno;
        PreparedStatement pStatement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            pStatement = connection.prepareStatement(query);
            retorno = pStatement.executeQuery();
        }  finally {
            tryCloseStatement(pStatement);
            closeConnection(connection);
        }
        return retorno;
    }

    private void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    private void tryCloseStatement(PreparedStatement pStatement) {
        if (pStatement != null) {
            try {
                pStatement.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String hostDas = args[0];
        String hostPi = args[1];
        String user = args[2];
        String senha = args[3];
        String tag = args[4];
        if (senha.equals("-")){
            senha = "";
        }
        System.out.println("Conectando com o hostDas="+ hostDas + " hostpi=" + hostPi + " usuário=" + user + " senha="+ senha + " tag="+tag);
        PiDriver driver = new PiDriver(hostDas, hostPi,  user, senha);
        ResultSet resultSet = driver.executarQuery(PiQuery.snapshotQuery(tag));
        PIUtil.printResultSet(resultSet);
    }



}
