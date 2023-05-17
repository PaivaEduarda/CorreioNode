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

async function alterar (correio)
{
    const conexao = await bd.getConexao ();
    if (conexao==null) return null;

    try
    {
        const sql   = 'UPDATE CorreioEntrega SET cpf=?, nomeRemetente=?, nomeDestinatario=?, cep=?, complemento=?, nmrCasa=? WHERE idCorreio=?';
        const dados = [correio.cpf,correio.nomeRemetente,correio.nomeDestinatario,correio.cep,correio.complemento, correio.nmrCasa];
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
        const dados = [codigo];
        await conexao.query (sql,dados);
        return true;
    }
    catch (excecao)
    {
        return false;
    }
}

async function getCorreio (codigo)
{
    const conexao = await bd.getConexao();
    if (conexao==null) return null;

    try
    {
        const  sql     = 'SELECT * FROM CorreioEntrega WHERE idCorreio=?';
        const  dados   = [codigo];
        const [linhas] = await conexao.execute(sql,dados);
        return linhas;
    }
    catch (excecao)
    {
        return false;
    }
}

async function getCorreio ()
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

module.exports = {incluir, atualizar, remover, getCorreio, getCorreio}



