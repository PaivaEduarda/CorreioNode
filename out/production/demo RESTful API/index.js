const express  = require ('express');
const bd       = require ('./bd.js');
const rotas    = require ('./rotas.js');

async function ativacaoDoServidor ()
{
    const ret = await bd.estrutureSe();

    if (ret===null)
    {
        console.log ('Não foi possível estabelecer conexão com o BD!');
        process.exit(1);
    }

    if (ret===false)
    {
        console.log ('Não foi possível estruturar o BD!');
        process.exit(1); 
    }

    const express = require('express');
    const app     = express();
    
    app.use(express.json());   // faz com que o express consiga processar JSON

    app.post   ('/correio'        , rotas.inclusao);
    app.put    ('/atualizarCorreio/:idCorreio', rotas.atualizacao);
    app.delete ('/RemoverCorreio/:idCorreio', rotas.remocao);
    app.get    ('/RecuperarCorreio/:idCorreio', rotas.recuperacaoDeUm);
    app.get    ('/correios'        , rotas.recuperacaoDeTodos);
    app.get    ('/ultimoId'        , rotas.ultimoId);

    console.log ('Servidor ativo na porta 3000...');
    app.listen(3000);
}
ativacaoDoServidor();
