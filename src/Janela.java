import bd.daos.Correios;
import bd.dbos.Correio;
import Endereco.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Janela extends JFrame {
    //Logradouro agencia = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", "13058442");
    private JTabbedPane tab = new JTabbedPane();
    //panels
    private JPanel ler                = new JPanel();
    private JPanel adicionar              = new JPanel();
    private JPanel atualizar          = new JPanel();
    private JPanel deletar            = new JPanel();

    //Text box do panel ler
    private JTextField txtCodigo = new JTextField();

    //text box do panel adicionar

    private JTextField addTxtCPFRemetente = new JTextField();
    private JTextField addTxtRemetente = new JTextField();
    private JTextField addTxtNomeDest = new JTextField();
    private JTextField addTxtCep = new JTextField();
    private JTextField addTxtRua = new JTextField();
    private JTextField addTxtBairro = new JTextField();
    private JTextField addTxtCidade = new JTextField();
    private JTextField addTxtEstado = new JTextField();
    private JTextField addTxtComplemento = new JTextField();
    private JTextField addTxtNmrCasa = new JTextField();

    //text box do panel deletar
    private JTextField deleteTxtCodigo = new JTextField();


    //text box do panel atualizar
    private JTextField updatetxtCodigo = new JTextField();
    private JTextField updateTxtCPFRemetente = new JTextField();
    private JTextField updateTxtRemet= new JTextField();
    private JTextField updateTxtNomeDest = new JTextField();
    private JTextField updateTxtCep = new JTextField();
    private JTextField updateTxtRua = new JTextField();
    private JTextField updateTxtBairro = new JTextField();
    private JTextField updateTxtCidade = new JTextField();
    private JTextField updateTxtEstado = new JTextField();
    private JTextField updateTxtComplemento = new JTextField();
    private JTextField updateTxtNmrCasa = new JTextField();

    //Buttons
    private JButton procurarEntrega = new JButton("Procurar");
    private JButton btnAdicionar = new JButton("Adicionar");

    private JButton btnDeletar = new JButton("Cancelar Entrega");
    private JButton btnProcurarDeletar = new JButton("Procurar");

    private JButton updateProcurarEntrega = new JButton("Procurar");
    private JButton updateAdicionar = new JButton("Atualizar");

    //label do panel ler
    private JLabel digiteCodigo = new JLabel("Digite o codigo de rastreio: ");
    private JLabel infoRemetente = new JLabel("INFORMACOES DO REMETENTE: ");
    private JLabel cpfRemetente = new JLabel("CPF:");
    private JLabel nomeRemetente = new JLabel("Nome: ");
    private JLabel dest = new JLabel("INFORMACOES DO DESTINATARIO: ");
    private JLabel nomeDestinatario = new JLabel("Nome: ");
    private JLabel cep = new JLabel("CEP: ");
    private JLabel logradouro = new JLabel("Logradouro: ");
    private JLabel bairro = new JLabel("Bairro: ");
    private JLabel cidade = new JLabel("Cidade: ");
    private JLabel estado = new JLabel("Estado: ");
    private JLabel complemento = new JLabel("Complemento: ");
    private JLabel nmrCasa = new JLabel("Numero da casa: ");
    //label do panel adicionar
    private JLabel addCodigo = new JLabel("Codigo de rastreio: ");
    private JLabel addInfoRemetente = new JLabel("INFORMACOES DO REMETENTE: ");
    private JLabel addCPFRemetente = new JLabel("CPF do remetente: ");
    private JLabel addRemetente = new JLabel("Nome do remetente: ");
    private JLabel addInfoDestinatario = new JLabel("INFORMACOES DO DESTINATARIO: ");
    private JLabel addNomeDest = new JLabel("Nome: ");
    private JLabel addCep = new JLabel("Cep: ");
    private JLabel addRua = new JLabel("Logradouro: ");
    private JLabel addBairro = new JLabel("Bairro: ");
    private JLabel addCidade = new JLabel("Cidade: ");
    private JLabel addEstado = new JLabel("Estado: ");
    private JLabel addComplemento = new JLabel("Complemento: ");
    private JLabel addNmrCasa = new JLabel("Numero da casa:");

    //label do panel deletar
    private JLabel deletarDigiteCodigo = new JLabel("Digite o codigo de rastreio: ");
    private JLabel deletarInfoRemetente = new JLabel("INFORMACOES DO REMETENTE: ");
    private JLabel deletarCPFRemetente = new JLabel("CPF:");
    private JLabel deletarNomeRemetente = new JLabel("Nome: ");
    private JLabel deletarDest = new JLabel("INFORMACOES DO DESTINATARIO: ");
    private JLabel deletarNomeDestinatario = new JLabel("Nome: ");
    private JLabel deletarCep = new JLabel("CEP: ");
    private JLabel deletarLogradouro = new JLabel("Logradouro: ");
    private JLabel deletarBairro = new JLabel("Bairro: ");
    private JLabel deletarCidade = new JLabel("Cidade: ");
    private JLabel deletarEstado = new JLabel("Estado: ");
    private JLabel deletarComplemento = new JLabel("Complemento: ");
    private JLabel deletarNmrCasa = new JLabel("Numero da casa: ");

    //label do panel atualizar

    private JLabel updateCodigo = new JLabel("Codigo de rastreio: ");
    private JLabel updateInfoRemetente = new JLabel("INFORMACOES DO REMETENTE: ");
    private JLabel updateCPFRemetente = new JLabel("CPF do remetente: ");
    private JLabel updateNomeRemetente = new JLabel("Nome do remetente: ");
    private JLabel updateInfoDestina = new JLabel("INFORMACOES DO DESTINATARIO: ");
    private JLabel updateNomeDest = new JLabel("Nome: ");
    private JLabel updateCep = new JLabel("Cep: ");

    private JLabel updateLogradouro = new JLabel("Logradouro: ");
    private JLabel updateBairro = new JLabel("Bairro: ");
    private JLabel updateCidade = new JLabel("Cidade: ");
    private JLabel updateEstado = new JLabel("Estado: ");
    private JLabel updateComplemento = new JLabel("Complemento: ");
    private JLabel updateNmrCasa = new JLabel("Numero da casa:");


    public boolean encontrarInfo( boolean encontrou )
    {
        if(encontrou == false) {
            JOptionPane.showMessageDialog(null, "Entrega não localizada!");
            cpfRemetente.setText("CPF: ");
            nomeRemetente.setText("Nome: " );
            nomeDestinatario.setText("Nome: " );
            cep.setText("Cep: " );
            complemento.setText("Complemento: " );
            nmrCasa.setText("Número da Casa: ");

            logradouro.setText("Rua: " );
            bairro.setText("Bairro: ");
            cidade.setText("Cidade: " );
            estado.setText("Estado: ");
            return false;
        }
        return true;
    }
    public Janela()
    {
        super("Correios");
        super.setSize(500, 570);
        super.setVisible(true);
        super.add(tab);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*try {
            var result = Correios.getCorreio();
            while (result.next())
            {
               // Correio correio = new Correio(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getInt(7));
                vetorCorreio.add(correio);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

        ler.setLayout(null);
        adicionar.setLayout(null);
        deletar.setLayout(null);
        atualizar.setLayout(null);

        tab.add("Ler", ler);
        tab.add("Adicionar", adicionar);
        tab.add("Deletar", deletar);
        tab.add("Atualizar", atualizar);

        Dimension size = tab.getSize();

        //ler
        digiteCodigo.setBounds(10, 20, 200, 20);
        txtCodigo.setBounds(10,60, 200, 20);
        procurarEntrega.setBounds(220, 60, 100, 20);

        infoRemetente.setBounds(140, 110, 200, 20);
        cpfRemetente.setBounds(10, 140, 200, 20);
        nomeRemetente.setBounds(10, 170, 300, 20);

        dest.setBounds(140, 200, 300, 20);
        nomeDestinatario.setBounds(10, 230, 100, 20);
        cep.setBounds(10, 260, 100, 20);
        logradouro.setBounds(10, 290, 300, 20);
        bairro.setBounds(10, 320, 300, 20);
        cidade.setBounds(10, 350, 300, 20);
        estado.setBounds(10, 380, 300, 20);
        complemento.setBounds(10, 410, 300, 20);
        nmrCasa.setBounds(10, 440, 200, 20);

        ler.add(digiteCodigo);
        ler.add(txtCodigo);
        ler.add(procurarEntrega);

        ler.add(infoRemetente);
        ler.add(cpfRemetente);
        ler.add(nomeRemetente);

        ler.add(dest);
        ler.add(nomeDestinatario);

        ler.add(cep);
        ler.add(logradouro);
        ler.add(bairro);
        ler.add(cidade);
        ler.add(estado);
        ler.add(complemento);
        ler.add(nmrCasa);

        procurarEntrega.addActionListener(e ->{
            try {
                Correio cr = Correios.getCorreio(Integer.parseInt(txtCodigo.getText()));
                if(cr != null)
                {
                    if(txtCodigo.getText().equals(cr.getIdCorreio().toString())) {
                        cpfRemetente.setText("CPF: " + cr.getCpf());
                        nomeRemetente.setText("Nome: " + cr.getNomeRemetente());
                        nomeDestinatario.setText("Nome: " + cr.getNomeDestinatario());
                        cep.setText("Cep: " + cr.getCep());
                        complemento.setText("Complemento: " + cr.getComplemento());
                        nmrCasa.setText("Número da Casa: " + cr.getNmrCasa());

                        Logradouro agencia = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", cr.getCep());

                        logradouro.setText("Rua: " + agencia.getLogradouro());
                        bairro.setText("Bairro: " + agencia.getBairro());
                        cidade.setText("Cidade: " + agencia.getCidade());
                        estado.setText("Estado: " + agencia.getEstado());
                    }
                }
                else{
                    cpfRemetente.setText("CPF: ");
                    nomeRemetente.setText("Nome: ");
                    nomeDestinatario.setText("Nome: ");
                    cep.setText("Cep: ");
                    complemento.setText("Complemento: ");
                    nmrCasa.setText("Número da Casa: ");
                    logradouro.setText("Rua: ");
                    bairro.setText("Bairro: ");
                    cidade.setText("Cidade: ");
                    estado.setText("Estado: ");
                    JOptionPane.showMessageDialog(null, "Entrega não localizada!");
                }
            }
            catch (Exception err)
            {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        });

        //adicionar

        addCodigo.setBounds(10,10,200,20);

        addInfoRemetente.setBounds(140,40,200,20);

        addCPFRemetente.setBounds(10,80,200,20);
        addTxtCPFRemetente.setBounds(200,80,200,20);

        addRemetente.setBounds(10,110,200,20);
        addTxtRemetente.setBounds(200,110,200,20);

        addInfoDestinatario.setBounds(140,150,200,20);

        addNomeDest.setBounds(10,180,200,20);
        addTxtNomeDest.setBounds(200,180,200,20);

        addCep.setBounds(10,210,200,20);
        addTxtCep.setBounds(200,210,200,20);

        addRua.setBounds(10,240,200,20);
        addTxtRua.setBounds(200,240,200,20);

        addBairro.setBounds(10,270,200,20);
        addTxtBairro.setBounds(200,270,200,20);

        addCidade.setBounds(10,300,200,20);
        addTxtCidade.setBounds(200,300,200,20);

        addEstado.setBounds(10,330,200,20);
        addTxtEstado.setBounds(200,330,200,20);

        addComplemento.setBounds(10,360,200,20);
        addTxtComplemento.setBounds(200,360,200,20);

        addNmrCasa.setBounds(10,390,200,20);
        addTxtNmrCasa.setBounds(200,390,200,20);

        btnAdicionar.setBounds(140, 440, 200, 20);

        addTxtEstado.setEditable(false);
        addTxtCidade.setEditable(false);
        addTxtBairro.setEditable(false);
        addTxtRua.setEditable(false);

        adicionar.add(addCodigo);
        adicionar.add(addInfoRemetente);
        adicionar.add(addCPFRemetente);
        adicionar.add(addTxtCPFRemetente);
        adicionar.add(addRemetente);
        adicionar.add(addTxtRemetente);
        adicionar.add(addInfoDestinatario);
        adicionar.add(addNomeDest);
        adicionar.add(addTxtNomeDest);
        adicionar.add(addCep);
        adicionar.add(addTxtCep);
        adicionar.add(addRua);
        adicionar.add(addTxtRua);
        adicionar.add(addBairro);
        adicionar.add(addTxtBairro);
        adicionar.add(addCidade);
        adicionar.add(addTxtCidade);
        adicionar.add(addEstado);
        adicionar.add(addTxtEstado);
        adicionar.add(addComplemento);
        adicionar.add(addTxtComplemento);
        adicionar.add(addNmrCasa);
        adicionar.add(addTxtNmrCasa);
        adicionar.add(btnAdicionar);

        //Ação do botão adicionar
        btnAdicionar.addActionListener(e -> {
            try{
                Correio correio = new Correio(0, addTxtCPFRemetente.getText(), addTxtRemetente.getText(), addTxtNomeDest.getText(), addTxtCep.getText(), addTxtComplemento.getText(), Integer.parseInt(addTxtNmrCasa.getText()));
                addCodigo.setText("Codigo de rastreio: " + correio.getIdCorreio().toString());
                try
                {
                    Logradouro agencia = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", addTxtCep.getText());
                    addTxtRua.setText(agencia.getLogradouro());
                    addTxtBairro.setText(agencia.getBairro());
                    addTxtCidade.setText(agencia.getCidade());
                    addTxtEstado.setText(agencia.getEstado());
                }
                catch (Exception erro)
                {
                    JOptionPane.showMessageDialog(null, "Cep inválido!! Confira suas informações novamente!");
                }

                String[] options = {"Sim", "Nao"};

                int x = JOptionPane.showOptionDialog(null,  "\n" + "\n" +  "INFORMACOES DO REMETENTE: " + "\n" + "\n" +  "CPF: " + addTxtCPFRemetente.getText() + "\n" + "Nome: " + addTxtRemetente.getText() + "\n" + "\n" +"INFORMACOES DO DESTINATARIO: " + "\n" + "\n" + "Nome: " + addTxtNomeDest.getText()
                                + "\n" + "Cep: " + addTxtCep.getText() + "\n" + "Rua: " + addTxtRua.getText() + "\n" + "Cidade: " + addTxtCidade.getText() + "\n" +  "Estado: " + addTxtBairro.getText() + "\n" + "Complemento: " + addTxtComplemento.getText() + "\n" + "Numero da Casa: " + addTxtNmrCasa.getText() + "\n", "Revise as informacoes da entrega:",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                System.out.println(x);

                if(x == 0) {
                    if (correio != null) {
                        try {
                            Correios.incluir(correio);
                            txtCodigo.setText("Codigo de rasteio: " + correio.getIdCorreio().toString());
                            /*addCodigo.setText(String.valueOf(Correios.ultimoId()));*/
                        } catch (Exception erro) {
                            JOptionPane.showMessageDialog(null, "Erro ao incluir!");
                        }

                    }
                    JOptionPane.showMessageDialog(null, "Entrega incluida com sucesso!");
                    JOptionPane.showMessageDialog(null, "Seu código de rastreio é:" + Integer.toString(Correios.ultimoId()));
                }
            }
            catch (Exception erro)
            {
                JOptionPane.showMessageDialog(null, "Informações inválidas! Revise suas informações");
            }
        });

        //deletar

        deletarDigiteCodigo.setBounds(10, 20, 200, 20);
        deleteTxtCodigo.setBounds(10,60, 200, 20);
        btnProcurarDeletar.setBounds(220, 60, 100, 20);

        deletarInfoRemetente.setBounds(140, 110, 200, 20);
        deletarCPFRemetente.setBounds(10, 140, 200, 20);
        deletarNomeRemetente.setBounds(10, 170, 300, 20);

        deletarDest.setBounds(140, 200, 300, 20);
        deletarNomeDestinatario.setBounds(10, 230, 300, 20);
        deletarCep.setBounds(10, 260, 200, 20);
        deletarLogradouro.setBounds(10, 290, 300, 20);
        deletarBairro.setBounds(10, 320, 300, 20);
        deletarCidade.setBounds(10, 350, 300, 20);
        deletarEstado.setBounds(10, 380, 300, 20);
        deletarComplemento.setBounds(10, 410, 300, 20);
        deletarNmrCasa.setBounds(10, 440, 150, 20);

        btnDeletar.setBounds(140, 470, 150, 20);

        deletar.add(deletarDigiteCodigo);
        deletar.add(deleteTxtCodigo);
        deletar.add(btnProcurarDeletar);

        deletar.add(deletarInfoRemetente);
        deletar.add(deletarCPFRemetente);
        deletar.add(deletarNomeRemetente);

        deletar.add(deletarDest);
        deletar.add(deletarNomeDestinatario);

        deletar.add(deletarCep);
        deletar.add(deletarLogradouro);
        deletar.add(deletarBairro);
        deletar.add(deletarCidade);
        deletar.add(deletarEstado);
        deletar.add(deletarComplemento);
        deletar.add(deletarNmrCasa);

        deletar.add(btnDeletar);

        btnProcurarDeletar.addActionListener(e -> {
            try 
            {
                Correio cr = Correios.getCorreio(Integer.parseInt(deleteTxtCodigo.getText()));
                if(cr != null)
                {
                    if (deleteTxtCodigo.getText().equals(cr.getIdCorreio().toString())) {
                        deletarCPFRemetente.setText("CPF: " + cr.getCpf());
                        deletarNomeRemetente.setText("Nome: " + cr.getNomeRemetente());
                        deletarNomeDestinatario.setText("Nome: " + cr.getNomeDestinatario());
                        deletarCep.setText("Cep: " + cr.getCep());
                        deletarComplemento.setText("Complemento: " + cr.getComplemento());
                        deletarNmrCasa.setText("Numero da Casa: " + cr.getNmrCasa());

                        Logradouro agencia = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", cr.getCep());

                        deletarLogradouro.setText("Rua: " + agencia.getLogradouro());
                        deletarBairro.setText("Bairro: " + agencia.getBairro());
                        deletarCidade.setText("Cidade: " + agencia.getCidade());
                        deletarEstado.setText("Estado: " + agencia.getEstado());
                    }
                }
                else{
                    deletarCPFRemetente.setText("CPF: ");
                    deletarNomeRemetente.setText("Nome: " );
                    deletarNomeDestinatario.setText("Nome: " );
                    deletarCep.setText("Cep: " );
                    deletarComplemento.setText("Complemento: " );
                    deletarNmrCasa.setText("Número da Casa: ");
                    deletarLogradouro.setText("Rua: " );
                    deletarBairro.setText("Bairro: ");
                    deletarCidade.setText("Cidade: " );
                    deletarEstado.setText("Estado: ");
                    JOptionPane.showMessageDialog(null,"Erro ao localizar a entrega");
                }
            }
            catch (Exception erro)
            {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        });

        btnDeletar.addActionListener(e -> {
            try{
                String[] options = {"Sim", "Nao"};

                Correio cr = Correios.getCorreio(Integer.parseInt(deleteTxtCodigo.getText()));
                Logradouro agencia = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", cr.getCep());

                int x = JOptionPane.showOptionDialog(null,  "\n" + "\n" +  "INFORMACOES DO REMETENTE: " + "\n" + "\n" +  "CÓDIGO DE RASTREIO: " +  cr.getIdCorreio() + "\n"  + "CPF: " +  cr.getCpf() + "\n" + "Nome: " + cr.getNomeRemetente() + "\n" + "\n" +"INFORMACOES DO DESTINATARIO: " + "\n" + "\n" + "Nome: " + cr.getNomeDestinatario()
                                + "\n" + "Cep: " + cr.getCep() + "\n" + "Rua: " + agencia.getLogradouro() + "\n" + "Cidade: " + agencia.getCidade() + "\n" +  "Estado: " + agencia.getEstado() + "\n" + "Complemento: " + cr.getComplemento() + "\n" + "Numero da Casa: " + cr.getNmrCasa() + "\n", "Revise as informacoes da entrega:",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                System.out.println(x);

                if(x == 0) {
                        try {
                            Boolean excluiu = Correios.excluir(Integer.parseInt(deleteTxtCodigo.getText()));

                            if(excluiu)
                            {
                                deletarCPFRemetente.setText("CPF: ");
                                deletarNomeRemetente.setText("Nome: " );
                                deletarNomeDestinatario.setText("Nome: " );
                                deletarCep.setText("Cep: " );
                                deletarComplemento.setText("Complemento: " );
                                deletarNmrCasa.setText("Número da Casa: ");
                                deletarLogradouro.setText("Rua: " );
                                deletarBairro.setText("Bairro: ");
                                deletarCidade.setText("Cidade: " );
                                deletarEstado.setText("Estado: ");
                                JOptionPane.showMessageDialog(null, "Entrega cancelada com sucesso!");
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "erro ao excluir a entrega!!!!!!!!!!");
                            }
                        } catch (Exception erro) {
                            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
                        }
                }
            }
            catch (Exception erro)
            {
                JOptionPane.showMessageDialog(null, erro);
            }
        });

        //update
        updateCodigo.setBounds(10,10,130,20);
        updatetxtCodigo.setBounds(135,10,100,20);
        updateProcurarEntrega.setBounds(260,10,100,20);

        updateInfoRemetente.setBounds(140,40,200,20);

        updateCPFRemetente.setBounds(10,80,200,20);
        updateTxtCPFRemetente.setBounds(200,80,200,20);

        updateNomeRemetente.setBounds(10,110,200,20);
        updateTxtRemet.setBounds(200,110,200,20);

        updateInfoDestina.setBounds(140,150,200,20);

        updateNomeDest.setBounds(10,180,200,20);
        updateTxtNomeDest.setBounds(200,180,200,20);

        updateCep.setBounds(10,210,200,20);
        updateTxtCep.setBounds(200,210,200,20);

        updateLogradouro.setBounds(10,240,200,20);
        updateTxtRua.setBounds(200,240,200,20);

        updateBairro.setBounds(10,270,200,20);
        updateTxtBairro.setBounds(200,270,200,20);

        updateCidade.setBounds(10,300,200,20);
        updateTxtCidade.setBounds(200,300,200,20);

        updateEstado.setBounds(10,330,200,20);
        updateTxtEstado.setBounds(200,330,200,20);

        updateComplemento.setBounds(10,360,200,20);
        updateTxtComplemento.setBounds(200,360,200,20);

        updateNmrCasa.setBounds(10,390,200,20);
        updateTxtNmrCasa.setBounds(200,390,200,20);

        updateAdicionar.setBounds(140, 440, 200, 20);

        atualizar.add(updatetxtCodigo);
        atualizar.add(updateCodigo);
        atualizar.add(updateProcurarEntrega);
        atualizar.add(updateInfoRemetente);
        atualizar.add(updateCPFRemetente);
        atualizar.add(updateTxtCPFRemetente);
        atualizar.add(updateNomeRemetente);
        atualizar.add(updateTxtRemet);
        atualizar.add(updateInfoRemetente);
        atualizar.add(updateInfoDestina);
        atualizar.add(updateNomeDest);
        atualizar.add(updateTxtNomeDest);
        atualizar.add(updateCep);
        atualizar.add(updateTxtCep);
        atualizar.add(updateLogradouro);
        atualizar.add(updateTxtRua);
        atualizar.add(updateBairro);
        atualizar.add(updateTxtBairro);
        atualizar.add(updateCidade);
        atualizar.add(updateTxtCidade);
        atualizar.add(updateEstado);
        atualizar.add(updateTxtEstado);
        atualizar.add(updateComplemento);
        atualizar.add(updateTxtComplemento);
        atualizar.add(updateNmrCasa);
        atualizar.add(updateTxtNmrCasa);
        atualizar.add(updateAdicionar);

        updateTxtEstado.setEditable(false);
        updateTxtRua.setEditable(false);
        updateTxtCidade.setEditable(false);
        updateTxtBairro.setEditable(false);

        //Ação do botão atualizar
        updateProcurarEntrega.addActionListener(e -> {
            try{
                Correio cr = Correios.getCorreio(Integer.parseInt(updatetxtCodigo.getText()));

                if(cr != null)
                {
                    if(updatetxtCodigo.getText().equals(cr.getIdCorreio().toString()))
                    {
                        updateTxtCPFRemetente.setText(cr.getCpf());
                        updateTxtRemet.setText(cr.getNomeRemetente());
                        updateTxtNomeDest.setText(cr.getNomeDestinatario());
                        updateTxtCep.setText(cr.getCep());
                        updateTxtComplemento.setText(cr.getComplemento());
                        updateTxtNmrCasa.setText(cr.getNmrCasa().toString());

                        Logradouro agencia = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", cr.getCep());

                        updateTxtRua.setText(agencia.getLogradouro());
                        updateTxtBairro.setText(agencia.getBairro());
                        updateTxtCidade.setText(agencia.getCidade());
                        updateTxtEstado.setText(agencia.getEstado());
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Erro ao localizar a entrega");

                    updateTxtCPFRemetente.setText("");
                    updateTxtRemet.setText("");
                    updateTxtNomeDest.setText("");
                    updateTxtCep.setText("");
                    updateTxtComplemento.setText("");
                    updateTxtNmrCasa.setText("");
                    updateTxtRua.setText("");
                    updateTxtBairro.setText("");
                    updateTxtCidade.setText("");
                    updateTxtEstado.setText("");
                }
            }
            catch (Exception err)
            {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        });

        updateAdicionar.addActionListener(e -> {
            try{
                String[] options = {"Sim", "Nao"};
                Logradouro agencia = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", updateTxtCep.getText());

                int x = JOptionPane.showOptionDialog(null,  "\n" + "\n" +  "INFORMACOES DO REMETENTE: " + "\n" + "\n" +  "CPF: " +  updateTxtCPFRemetente.getText() + "\n" + "Nome: " + updateTxtRemet.getText() + "\n" + "\n" +"INFORMACOES DO DESTINATARIO: " + "\n" + "\n" + "Nome: " + updateTxtNomeDest.getText()
                                + "\n" + "Cep: " + updateTxtCep.getText() + "\n" + "Rua: " + agencia.getLogradouro() + "\n" + "Cidade: " + agencia.getCidade() + "\n" +  "Estado: " + agencia.getEstado() + "\n" + "Complemento: " + updateTxtComplemento.getText() + "\n" + "Numero da Casa: " + updateTxtNmrCasa.getText() + "\n", "Revise as informacoes da entrega:",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                System.out.println(x);

                if(x == 0) {
                    Correio correio = new Correio(Integer.parseInt(updatetxtCodigo.getText()), updateTxtCPFRemetente.getText(), updateTxtRemet.getText(), updateTxtNomeDest.getText(), updateTxtCep.getText(), updateTxtComplemento.getText(), Integer.parseInt(updateTxtNmrCasa.getText()));
                    if (correio != null) {
                        // AtualizarPorID(Integer.parseInt(updatetxtCodigo.getText()), correio);
                        Correios.alterar(correio);
                    }
                }

                JOptionPane.showMessageDialog(null, "Entrega atualizada com sucesso!");
            }
            catch (Exception erro)
            {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        });
    }
}
