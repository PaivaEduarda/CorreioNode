const Correios     = require ('./Correios.js');
const Correio      = require ('./Correio.js');
const Comunicado = require ('./comunicado.js');


// para a rota de CREATE
async function inclusao (req, res)
{
    if (Object.values(req.body).length!=7 || !req.body.cpf || !req.body.nomeRemetente || !req.body.nomeDestinatario || !req.body.cep || !req.body.complemento || !req.body.nmrCasa)
    {
        const erro = Comunicado.novo('DdI','Dados inesperados','Não foram fornecidos exatamente as 6 informações esperadas de um Correio (cpf, nomeRemetente, nomeDestinatario, cep, complemento e nmrCasa)').object;
        return res.status(422).json(erro);
    }
    
    let Cor;
    try
    {
        Cor = Correio.novo (req.body.cpf,req.body.nomeRemetente, req.body.nomeDestinatario, req.body.cep, req.body.complemento, req.body.nmrCasa);
    }

    catch (excecao)
    {
        console.log("oi");
        const erro = Comunicado.novo('TDE','Dados de tipos errados','Codigo deve ser um numero natural positivo, nome deve ser um texto não vazio e preço deve ser um número real positivo').object;
        return res.status(422).json(erro);
    }

    const ret = await Correios.incluir(Cor);

    if (ret===null)
    {
        const  erro = Comunicado.novo('CBD','Sem conexão com o BD','Não foi possível estabelecer conexão com o banco de dados').object;
        return res.status(500).json(erro);
    }

    if (ret===false)
    {
        const  erro = Comunicado.novo('LJE','Correio já existe','Já há correio cadastrado com o código informado').object;
        return res.status(409).json(erro);
    }

  //if (ret===true)
  //{
        const  sucesso = Comunicado.novo('IBS','Inclusão bem sucedida','O correio foi incluído com sucesso').object;
        return res.status(201).json(sucesso);
  //}
}

// para a rota de UPDATE
async function atualizacao (req, res)
{
    if (Object.values(req.body).length!= 7 || !req.body.cpf || !req.body.nomeRemetente || !req.body.nomeDestinatario || !req.body.cep || !req.body.complemento || !req.body.nmrCasa)
    {
        const erro = Comunicado.novo('DdI','Dados inesperados','Não foram fornecidos exatamente as 6 informações esperadas de um Correio (cpf, nomeRemetente, nomeDestinatario, cep, complemento e nmrCasa)').object;
        return res.status(422).json(erro);
    }
    
    let Correio;
    try
    {
        Correio = Correio.novo (req.body.cpf,req.body.nomeRemetente, req.body.nomeDestinatario, req.body.cep, req.body.complemento, req.body.nmrCasa);
    }
    catch (excecao)
    {
        const erro = Comunicado.novo('TDE','Dados de tipos errados','Codigo deve ser um numero natural positivo, nome deve ser um texto não vazio e preço deve ser um número real positivo').object;
        return res.status(422).json(erro);
    }

    const idCorreio = req.params.idCorreio;
    
    if (idCorreio!=Correio.idCorreio)
    {
        const erro = Comunicado.novo('TMC','Mudança de código','Tentativa de mudar o código do Correio').object;
        return res.status(400).json(erro);    
    }
    
    let ret = await Correios.recuperacaoDeUm(idCorreio);

    if (ret===null)
    {
        const  erro = Comunicado.novo('CBD','Sem conexão com o BD','Não foi possível estabelecer conexão com o banco de dados').object;
        return res.status(500).json(erro);
    }

    if (ret===false)
    {
        const  erro = Comunicado.novo('FNC','Falha no comando SQL','O comando SQL apresenta algum erro').object;
        return res.status(409).json(erro);
    }

    if (ret.length==0)
    {
        const erro = Comunicado.novo('LNE','Correio inexistente','Não há Correio cadastrado com o código informado').object;
        return res.status(404).json(erro);
    }

    ret = await Correios.alterar(Correio);

    if (ret===null)
    {
        const  erro = Comunicado.novo('CBD','Sem conexão com o BD','Não foi possível estabelecer conexão com o banco de dados').object;
        return res.status(500).json(erro);
    }

    if (ret===false)
    {
        const  erro = Comunicado.novo('FNC','Falha no comando SQL','O comando SQL apresenta algum erro').object;
        return res.status(409).json(erro);
    }

  //if (ret===true)
  //{
        const sucesso = Comunicado.novo('ABS','Alteração bem sucedida','O correio foi atualizado com sucesso').object;
        return res.status(201).json(sucesso);
  //}
}

// para a rota de DELETE
async function remocao (req, res)
{
    console.log("ret");

    if (Object.values(req.body).length!=0)
    {
        const erro = Comunicado.novo('DSP','Fornecimento de dados sem propósito','Foram fornecidos dados sem necessidade no corpo da requisição').object;
        return res.status(422).json(erro);
    }
    
    const idCorreio = req.params.idCorreio;
    console.log(idCorreio);
    let ret = await Correios.recuperacaoDeUm(idCorreio);
    console.log(ret);
    if (ret===null)
    {
        const  erro = Comunicado.novo('CBD','Sem conexão com o BD','Não foi possível estabelecer conexão com o banco de dados').object;
        return res.status(500).json(erro);
    }

    if (ret===false)
    {
        const  erro = Comunicado.novo('FNC','Falha no comando SQL','O comando SQL apresenta algum erro').object;
        return res.status(409).json(erro);
    }

    if (ret.length==0)
    {
        const erro = Comunicado.novo('LNE','Correio inexistente','Não há correio cadastrado com o código informado').object;
        return res.status(404).json(erro);
    }

    ret = await Correios.excluir(ret);
    console.log(ret);

    if (ret===null)
    {
        const  erro = Comunicado.novo('CBD','Sem conexão com o BD','Não foi possível estabelecer conexão com o banco de dados').object;
        return res.status(500).json(erro);
    }

    if (ret===false)
    {
        const  erro = Comunicado.novo('FNC','Falha no comando SQL','O comando SQL apresenta algum erro').object;
        return res.status(409).json(erro);
    }

  //if (ret===true)
  //{
        const sucesso = Comunicado.novo('RBS','Remoção bem sucedida','O correio foi removido com sucesso').object;
        console.log(sucesso);
        return res.status(200).json(sucesso);
  //}    
}

// para a segunda rota de READ (um)
async function recuperacaoDeUm (req, res)
{
    if (Object.values(req.body).length!=0)
    {
        const erro = Comunicado.novo('DSP','Fornecimento de dados sem propósito','Foram fornecidos dados sem necessidade no corpo da requisição').object;
        return res.status(422).json(erro);
    }

    const idCorreio = req.params.idCorreio;

    const ret = await Correios.getCorreio(idCorreio);

    if (ret===null)
    {
        const  erro = Comunicado.novo('CBD','Sem conexão com o BD','Não foi possível estabelecer conexão com o banco de dados').object;
        return res.status(500).json(erro);
    }

    if (ret===false)
    {
        const  erro = Comunicado.novo('FNC','Falha no comando SQL','O comando SQL apresenta algum erro').object;
        return res.status(409).json(erro);
    }

    if (ret.length==0)
    {
        const erro = Comunicado.novo('LNE','Correio inexistente','Não há correio cadastrado com o código informado').object;
        return res.status(404).json(erro);
    }

    return res.status(200).json(ret);
}

// para a primeira rota de READ (todos)
async function recuperacaoDeTodos (req, res)
{
    if (Object.values(req.body).length!=0)
    {
        const erro = Comunicado.novo('DSP','Fornecimento de dados sem propósito','Foram fornecidos dados sem necessidade no corpo da requisição').object;
        return res.status(422).json(erro);
    }

    const ret = await Correios.getCorreios();

    if (ret===null)
    {
        const  erro = Comunicado.novo('CBD','Sem conexão com o BD','Não foi possível estabelecer conexão com o banco de dados').object;
        return res.status(500).json(erro);
    }

    if (ret===false)
    {
        const  erro = Comunicado.novo('FNC','Falha no comando SQL','O comando SQL apresenta algum erro').object;
        return res.status(409).json(erro);
    }

    return res.status(200).json(ret);
}
async function ultimoId (req, res)
{
    if (Object.values(req.body).length!=0)
    {
        const erro = Comunicado.novo('DSP','Fornecimento de dados sem propósito','Foram fornecidos dados sem necessidade no corpo da requisição').object;
        return res.status(422).json(erro);
    }

    const ret = await Correios.ultimoId();

    if (ret===null)
    {
        const  erro = Comunicado.novo('CBD','Sem conexão com o BD','Não foi possível estabelecer conexão com o banco de dados').object;
        return res.status(500).json(erro);
    }

    if (ret===false)
    {
        const  erro = Comunicado.novo('FNC','Falha no comando SQL','O comando SQL apresenta algum erro').object;
        return res.status(409).json(erro);
    }

    return res.status(200).json(ret);
}

module.exports = {inclusao, atualizacao, remocao, recuperacaoDeUm, recuperacaoDeTodos, ultimoId}