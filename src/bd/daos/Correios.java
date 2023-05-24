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
                c = ClienteWS.delete("http://localhost:3000/RemoverCorreio", Integer.toString(id));
                System.out.println(c);
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
        if (correio == null)
            throw new Exception("entrega ainda não cadastrada!");
        try {
            try {
                ClienteWS.putObjeto(correio, LinkedHashMap.class, "http://localhost:3000/atualizarCorreio/" + correio.getIdCorreio());
            } catch (Exception erro) {
                throw new Exception(erro.getMessage());
            }
        } catch (Exception erro) {
            throw new Exception("Erro ao atualizar AAAAAAAAAA");
        }
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
