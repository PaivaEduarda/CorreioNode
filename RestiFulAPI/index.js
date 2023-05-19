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

    app.post  ('/correios'        , rotas.inclusao);
    app.put   ('/correios/:idCorreio', rotas.atualizacao);
    app.delete('/correios/:idCorreio', rotas.remocao);
    app.get   ('/correios/:idCorreio', rotas.recuperacaoDeUm);
    app.get   ('/correios'        , rotas.recuperacaoDeTodos);

    console.log ('Servidor ativo na porta 3000...');
    app.listen(3000);
}
ativacaoDoServidor();
