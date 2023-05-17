import bd.core.MeuResultSet;
import bd.daos.Correios;
import bd.dbos.Correio;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Janela extends JFrame {
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
    private JLabel digiteCodigo = new JLabel("Digite o código de rastreio: ");
    private JLabel infoRemetente = new JLabel("INFORMAÇÕES DO REMETENTE: ");
    private JLabel cpfRemetente = new JLabel("CPF:");
    private JLabel nomeRemetente = new JLabel("Nome: ");
    private JLabel dest = new JLabel("INFORMAÇÕES DO DESTINATÁRIO: ");
    private JLabel nomeDestinatario = new JLabel("Nome: ");
    private JLabel cep = new JLabel("CEP: ");
    private JLabel logradouro = new JLabel("Logradouro: ");
    private JLabel bairro = new JLabel("Bairro: ");
    private JLabel cidade = new JLabel("Cidade: ");
    private JLabel estado = new JLabel("Estado: ");
    private JLabel complemento = new JLabel("Complemento: ");
    private JLabel nmrCasa = new JLabel("Número da casa: ");
    //label do panel adicionar
    private JLabel addCodigo = new JLabel("Código de rastreio: ");
    private JLabel addInfoRemetente = new JLabel("INFORMAÇÕES DO REMETENTE: ");
    private JLabel addCPFRemetente = new JLabel("CPF do remetente: ");
    private JLabel addRemetente = new JLabel("Nome do remetente: ");
    private JLabel addInfoDestinatario = new JLabel("INFORMAÇÕES DO DESTINATÁRIO: ");
    private JLabel addNomeDest = new JLabel("Nome: ");
    private JLabel addCep = new JLabel("Cep: ");
    private JLabel addRua = new JLabel("Logradouro: ");
    private JLabel addBairro = new JLabel("Bairro: ");
    private JLabel addCidade = new JLabel("Cidade: ");
    private JLabel addEstado = new JLabel("Estado: ");
    private JLabel addComplemento = new JLabel("Complemento: ");
    private JLabel addNmrCasa = new JLabel("Número da casa:");

    //label do panel deletar
    private JLabel deletarDigiteCodigo = new JLabel("Digite o código de rastreio: ");
    private JLabel deletarInfoRemetente = new JLabel("INFORMAÇÕES DO REMETENTE: ");
    private JLabel deletarCPFRemetente = new JLabel("CPF:");
    private JLabel deletarNomeRemetente = new JLabel("Nome: ");
    private JLabel deletarDest = new JLabel("INFORMAÇÕES DO DESTINATÁRIO: ");
    private JLabel deletarNomeDestinatario = new JLabel("Nome: ");
    private JLabel deletarCep = new JLabel("CEP: ");
    private JLabel deletarLogradouro = new JLabel("Logradouro: ");
    private JLabel deletarBairro = new JLabel("Bairro: ");
    private JLabel deletarCidade = new JLabel("Cidade: ");
    private JLabel deletarEstado = new JLabel("Estado: ");
    private JLabel deletarComplemento = new JLabel("Complemento: ");
    private JLabel deletarNmrCasa = new JLabel("Número da casa: ");

    //label do panel atualizar

    private JLabel updateCodigo = new JLabel("Código de rastreio: ");
    private JLabel updateInfoRemetente = new JLabel("INFORMAÇÕES DO REMETENTE: ");
    private JLabel updateCPFRemetente = new JLabel("CPF do remetente: ");
    private JLabel updateNomeRemetente = new JLabel("Nome do remetente: ");
    private JLabel updateInfoDestina = new JLabel("INFORMAÇÕES DO DESTINATÁRIO: ");
    private JLabel updateNomeDest = new JLabel("Nome: ");
    private JLabel updateCep = new JLabel("Cep: ");

    private JLabel updateLogradouro = new JLabel("Logradouro: ");
    private JLabel updateBairro = new JLabel("Bairro: ");
    private JLabel updateCidade = new JLabel("Cidade: ");
    private JLabel updateEstado = new JLabel("Estado: ");
    private JLabel updateComplemento = new JLabel("Complemento: ");
    private JLabel updateNmrCasa = new JLabel("Número da casa:");

    private ArrayList<Correio> correios;


    public Janela()
    {
        super("Correios");
        super.setSize(500, 570);
        super.setVisible(true);
        super.add(tab);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        cpfRemetente.setBounds(10, 140, 100, 20);
        nomeRemetente.setBounds(10, 170, 100, 20);

        dest.setBounds(140, 200, 200, 20);
        nomeDestinatario.setBounds(10, 230, 100, 20);
        cep.setBounds(10, 260, 100, 20);
        logradouro.setBounds(10, 290, 200, 20);
        bairro.setBounds(10, 320, 150, 20);
        cidade.setBounds(10, 350, 150, 20);
        estado.setBounds(10, 380, 150, 20);
        complemento.setBounds(10, 410, 150, 20);
        nmrCasa.setBounds(10, 440, 150, 20);

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

        //deletar

        deletarDigiteCodigo.setBounds(10, 20, 200, 20);
        deleteTxtCodigo.setBounds(10,60, 200, 20);
        btnProcurarDeletar.setBounds(220, 60, 100, 20);

        deletarInfoRemetente.setBounds(140, 110, 200, 20);
        deletarCPFRemetente.setBounds(10, 140, 100, 20);
        deletarNomeRemetente.setBounds(10, 170, 100, 20);

        deletarDest.setBounds(140, 200, 200, 20);
        deletarNomeDestinatario.setBounds(10, 230, 100, 20);
        deletarCep.setBounds(10, 260, 100, 20);
        deletarLogradouro.setBounds(10, 290, 200, 20);
        deletarBairro.setBounds(10, 320, 150, 20);
        deletarCidade.setBounds(10, 350, 150, 20);
        deletarEstado.setBounds(10, 380, 150, 20);
        deletarComplemento.setBounds(10, 410, 150, 20);
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
        
    }
}
