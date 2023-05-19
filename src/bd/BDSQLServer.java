package bd;

import bd.core.*;
import bd.daos.*;

public class BDSQLServer
{
    public static final MeuPreparedStatement COMANDO;

    static
    {
    	MeuPreparedStatement comando = null;

    	try
        {
            comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://regulus.cotuca.unicamp.br;databasename=BD22127",
            "BD22127", "123456789Lol#@");
        }
        catch (Exception erro)
        {
            System.err.println (erro);
            System.exit(0); // aborta o programa
        }
        
        COMANDO = comando;
    }
}