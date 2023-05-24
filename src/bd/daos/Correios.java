package bd.daos;

import java.sql.*;
import java.util.LinkedHashMap;

import Endereco.ClienteWS;
import bd.*;
import bd.core.*;
import bd.dbos.*;
public class Correios {

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

    public static Boolean excluir(int id) throws Exception {
        Boolean c = false;
        try {
            try {
                c = ClienteWS.delete("http://localhost:3000/RemoverCorreio", String.valueOf(id));
            } catch (Exception erro) {
                throw new Exception("Erro ao deletar correio");
            }

        } catch (Exception erro) {
            throw new Exception("Erro ao deletar AAAAAAAAAA");
        }
        return c;
    }

    /*public static int ultimoId() throws Exception {
        int c;
        try {
            try {
                c = (Correio) ClienteWS.getObjeto(Correio.class, "http://localhost:3000/ultimoId", String.valueOf(id));

            } catch (Exception erro) {
                throw new Exception("Erro ao recuperar o correio");
            }

        } catch (Exception erro) {
            throw new Exception("Erro ao inserir AAAAAAAAAA");
        }
        return c;
    }*/

    public static void alterar(Correio correio) throws Exception {
       /* if (correio == null)
            throw new Exception("Informações não fornecidas. Verifique novamente!");
        if (!(cadastrado(correio.getIdCorreio())))
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
            BDSQLServer.COMANDO.setString(1, correio.getCpf());
            BDSQLServer.COMANDO.setString(2, correio.getNomeRemetente());
            BDSQLServer.COMANDO.setString(3, correio.getNomeDestinatario());
            BDSQLServer.COMANDO.setString(4, correio.getCep());
            BDSQLServer.COMANDO.setString(5, correio.getComplemento());
            BDSQLServer.COMANDO.setInt(6, correio.getNmrCasa());
            BDSQLServer.COMANDO.setInt(7, correio.getIdCorreio());


            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        } catch (SQLException erro) {
            BDSQLServer.COMANDO.rollback();
            throw new Exception(erro.getMessage());
        }*/
    }

    public static Correio getCorreio(int id) throws Exception {
        Correio c = null;
        try {
            try {
                 c = (Correio) ClienteWS.getObjeto(Correio.class, "http://localhost:3000/RecuperarCorreio", String.valueOf(id));

            } catch (Exception erro) {
                throw new Exception("Erro ao recuperar o correio");
            }

        } catch (Exception erro) {
            throw new Exception("Erro ao inserir AAAAAAAAAA");
        }
        return c;
    }
}
