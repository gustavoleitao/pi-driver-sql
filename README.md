# Antes de tudo

Este programa precisa dos seguintes requisitos, para funcionar adequadamente:

1. PIJDBCDriver (Biblioteca JDBC fornecida pela OsiSoft)
2. PI DAS (fornecido pela Osisoft)

Como a dependência PIJDBCDriver não está fornecida publicamente, você deve instalá-la primeiro no seru servidor Maven. Para isso, de posse do arquivo jar da dependência, execute o seguinte comando:

````shell script
mvn install:install-file \
   -Dfile=<path-to-file> \
   -DgroupId=com.osisoft.jdbc \
   -DartifactId=PIJDBCDriver \
   -Dversion=1.0.1 \
   -Dpackaging=jar \
   -DgeneratePom=true
````

Além disso, verifique se o path do PI DAS está definido nas seguintes variáveis de ambiente: PI_RDSA_LIB64 e PI_RDSA_LIB

# Como usar

Exemplo de uso:

```java
    String tag = "SINUSOID";
    String hostDas = "localhost"; // host onde o DAS foi instalado
    String hostPi = "localhost"; //Host do servidor do PI
    String user = "pidemo"; // Usuário de acesso ao PI
    String password = ""; // Senha de acesso ao PI
    PiDriver driver = new PiDriver(hostDas, hostPi,  user, password);
    ResultSet resultSet = driver.executarQuery(PiQuery.snapshotQuery(tag));
``` 

Para mais exemplos, localize a classe PiDriverITTest. Você pode alterar os valores de conexão com o PI e utilizar os testes para testar os métodos disponíveis.