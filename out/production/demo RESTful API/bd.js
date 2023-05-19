const mysql    = require("mysql2/promise");
DATABASE_URL='mysql://imjr3fol3yedjm2afbwl:pscale_pw_Ym7i3sQRq1LDtm5dqwRpmL3qjHdxmRuV02Ivpyn5N8f@aws.connect.psdb.cloud/projetocorreio?ssl={"rejectUnauthorized":true}'

async function getConexao ()
{
    if (global.conexao && global.conexao.state !== 'disconnected')
        return global.conexao;

    try
    {
        const conexao = await mysql.createConnection (DATABASE_URL);
        global.conexao = conexao;
        return conexao;
    }
    catch (erro)
    {
        return null;
    }
}

async function estrutureSe ()
{
    const conexao = await getConexao ();
    if (conexao==undefined) return null;

    const sql = 'CREATE TABLE IF NOT EXISTS CorreioEntrega (idCorreio int auto_increment, cpf VARCHAR(11) NOT NULL, nomeRemetente VARCHAR(30) NOT NULL, nomeDestinatario VARCHAR(30) NOT NULL, cep VARCHAR(8) NOT NULL, complemento VARCHAR(30), nmrCasa INT NOT NULL, primary key(idCorreio))';
    
    try
    {
        await conexao.query (sql);
        return true;
    }
    catch (erro)
    {
        return false;
    }
}

module.exports = {getConexao, estrutureSe}
