const bd = require ('./bd');

async function incluir (correio)
{
    const conexao = await bd.getConexao ();
    if (conexao==null) return null;

    try
    {
        const sql     = 'INSERT INTO CorreioEntrega (cpf, nomeRemetente, nomeDestinatario, cep, complemento, nmrCasa) VALUES (?,?,?,?,?,?)';
        const dados   = [correio.cpf,correio.nomeRemetente,correio.nomeDestinatario,correio.cep,correio.complemento, correio.nmrCasa];
        await conexao.query (sql, dados);
        return true;
    }
    catch (excecao)
    {
        return false;
    }
}
async function ultimoId ()
{
    const conexao = await bd.getConexao ();
    if (conexao==null) return null;

    try
    {
        const  sql     = 'SELECT * FROM CorreioEntrega WHERE idCorreio = (SELECT Max(idCorreio) as id FROM CorreioEntrega);';
        const [linhas] = await conexao.query(sql);
        return linhas;
    }
    catch (excecao)
    {
        return false;
    }
}


async function alterar (correio)
{
    const conexao = await bd.getConexao ();
    console.log(conexao);
    if (conexao==null) return null;

    try
    {
        console.log(correio);
        console.log("correio");
        const sql   = 'UPDATE CorreioEntrega SET cpf=?, nomeRemetente=?, nomeDestinatario=?, cep=?, complemento=?, nmrCasa=? WHERE idCorreio=?';
        const dados = [correio.cpf,correio.nomeRemetente,correio.nomeDestinatario,correio.cep,correio.complemento, correio.nmrCasa, correio.idCorreio];

        await conexao.query (sql,dados);
        return true;
    }
    catch (excecao)
    {
        return false;
    }
}
    
async function excluir (correio)
{
    const conexao = await bd.getConexao ();
    if (conexao==null) return null;
    
    try
    {
        const sql   = 'DELETE FROM CorreioEntrega WHERE idCorreio=?';
        const dados = [correio];
        console.log(sql + dados)
        await conexao.query (sql,dados);
        return true;
    }
    catch (excecao)
    {
        return false;
    }
}

async function getCorreio (idCorreio)
{
    const conexao = await bd.getConexao();
    if (conexao==null) return null;

    try
    {
        const  codigo     = 'SELECT * FROM CorreioEntrega WHERE idCorreio=?';
        const  dados   = [idCorreio]; 
        const [linhas] = await conexao.execute(codigo, dados);
        return linhas;
    }
    catch (excecao)
    {
        return false;
    }
}

async function getCorreios ()
{
    const conexao = await bd.getConexao();
    if (conexao==null) return null;

    try
    {
        const  sql     = 'SELECT * FROM CorreioEntrega';
        const [linhas] = await conexao.query(sql);
        return linhas;
    }
    catch (excecao)
    {
        return false;
    }
}

module.exports = {incluir, alterar, excluir, getCorreio, getCorreios, ultimoId}



