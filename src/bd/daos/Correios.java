package bd.daos;

import java.sql.*;
import java.util.LinkedHashMap;

import Endereco.ClienteWS;
import bd.*;
import bd.core.*;
import bd.dbos.*;
public class Correios {
    public static boolean cadastrado(int id) throws Exception {
        boolean retorno = false;
        try {
            String sql;
            sql = "SELECT * "
                    + "FROM CorreioEntrega "
                    + "WHERE idCorreio = ?;";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, id);
            MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
            retorno = resultado.first();
        } catch (SQLException erro) {
            throw new Exception(erro.getMessage());
        }
        return retorno;
    }

    public static void incluir(Correio correio) throws Exception {
        if (correio == null)
            throw new Exception("entrega ainda não cadastrada!");
        try {
            try {
                ClienteWS.postObjeto(correio, LinkedHashMap.class, "http://localhost:3000/correio");
            } catch (Exception erro) {
                throw new Exception(erro.getMessage());
            }

        } catch (Exception erro) {
            throw new Exception("Erro ao inserir AAAAAAAAAA");
        }
    }

    public static void excluir(int id) throws Exception {
        if (!(cadastrado(id)))
            throw new Exception("Código de rastreio não cadastrado!");
        try {
            String sql = "";
            sql = "DELETE FROM CorreioEntrega " +
                    "WHERE idCorreio = ?;";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setInt(1, id);

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        } catch (SQLException erro) {
            BDSQLServer.COMANDO.rollback();
            throw new Exception(erro);
        }
    }

    public static int ultimoId() throws Exception {
        try {
            int id = 0;
            String sql = "";
            sql = "select MAX(idCorreio) " +
                    "as ID from CorreioEntrega";
            BDSQLServer.COMANDO.prepareStatement(sql);

            MeuResultSet resultSet = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

            if (resultSet.first())
                id = resultSet.getInt("ID");

            return id + 1;
        } catch (SQLException erro) {
            BDSQLServer.COMANDO.rollback();
            throw new Exception(erro);
        }
    }

    public static void alterar(Correio correio) throws Exception {
        if (correio == null)
            throw new Exception("Informações não fornecidas. Verifique novamente!");
        if (!(cadastrado(correio.getId())))
            throw new Exception("Id não cadastrado!");
        try {
            String sql = "";
            sql = "UPDATE CorreioEntrega " +
                    "SET cpf = ?," +
                    "nomeRemetente = ?, " +
                    "nomeDestinatario = ?, " +
                    "cep = ?," +
                    "complemento = ?," +
                    "nmrCasa = ? " +
                    "WHERE idCorreio = ?;";
            BDSQLServer.COMANDO.prepareStatement(sql);
            BDSQLServer.COMANDO.setString(1, correio.getCPF());
            BDSQLServer.COMANDO.setString(2, correio.getNomeRemetente());
            BDSQLServer.COMANDO.setString(3, correio.getNomeDestinatario());
            BDSQLServer.COMANDO.setString(4, correio.getCep());
            BDSQLServer.COMANDO.setString(5, correio.getComplemento());
            BDSQLServer.COMANDO.setInt(6, correio.getNmrCasa());
            BDSQLServer.COMANDO.setInt(7, correio.getId());


            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        } catch (SQLException erro) {
            BDSQLServer.COMANDO.rollback();
            throw new Exception(erro.getMessage());
        }
    }

    public static Correio getCorreio(int id) throws Exception {
        Correio c = null;
        try {
            try {
                 c = (Correio) ClienteWS.getObjeto(Correio.class, "http://localhost:3000/RecuperarCorreios/id", String.valueOf(id));

            } catch (Exception erro) {
                throw new Exception("Erro ao recuperar o correio");
            }

        } catch (Exception erro) {
            throw new Exception("Erro ao inserir AAAAAAAAAA");
        }
        return c;
    }
}
