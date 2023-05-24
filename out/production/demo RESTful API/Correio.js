class Correio
{
    #idCorreio
    #cpf
    #nomeRemetente
    #nomeDestinatario
    #cep
    #complemento
    #nmrCasa

    constructor (idCorreio, cpf, nomeRemetente, nomeDestinatario, cep, complemento, nmrCasa)
    {
        this.cpf = cpf
        this.nomeRemetente = nomeRemetente
        this.nomeDestinatario = nomeDestinatario
        this.cep = cep
        this.complemento = complemento
        this.nmrCasa = nmrCasa
        this.idCorreio = idCorreio
    }

    get idCorreio ()
    {
        return this.#idCorreio
    }

    get cpf ()
    {
        return this.#cpf
    }

    get nomeRemetente ()
    {
        return this.#nomeRemetente
    }

    get nomeDestinatario ()
    {
        return this.#nomeDestinatario
    }

    get cep ()
    {
        return this.#cep
    }

    get complemento ()
    {
        return this.#complemento
    }

    get nmrCasa()
    {
        return this.#nmrCasa
    }

    set idCorreio (idCorreio)
    {
        if (idCorreio===undefined || typeof idCorreio !== 'number' || isNaN(idCorreio) || idCorreio!==parseInt(idCorreio) || idCorreio<=0)
            throw ('código de rastreio inválido');

        this.#idCorreio = idCorreio;
    }

    set nomeRemetente (nomeRemetente)
    {
        if (nomeRemetente===undefined || typeof nomeRemetente !== 'string' || nomeRemetente==="")
            throw ('Nome inválido');

        this.#nomeRemetente = nomeRemetente;
    }

     set nomeDestinatario (nomeDestinatario)
     {
        if (nomeDestinatario===undefined || typeof nomeDestinatario !== 'string' || nomeDestinatario==="")
            throw ('Nome inválido');

        this.#nomeDestinatario = nomeDestinatario;
     }

     set cpf (cpf)
     {
        if (cpf===undefined || typeof cpf !== 'string' || cpf==="")
            throw ('CPF inválido');

        this.#cpf = cpf;
     }

     set cep (cep)
     {
        if (cep===undefined || typeof cep !== 'string' || cep==="")
           throw ('CEP inválido');

        this.#cep = cep;
     }

     set complemento (complemento)
     {
        if (complemento===undefined || typeof complemento !== 'string' || complemento==="")
            throw ('Complemento inválido');

        this.#complemento = complemento;
     }

    set nmrCasa (nmrCasa)
    {
        if (nmrCasa===undefined || typeof nmrCasa !== 'number' || isNaN(nmrCasa) || nmrCasa<=0)
            throw ('Número da casa inválido');

        this.#nmrCasa = nmrCasa;
    }
}

function novo (idCorreio, cpf,nomeRemetente,nomeDestinatario,cep,complemento,nmrCasa)
{
    return new Correio (idCorreio, cpf,nomeRemetente,nomeDestinatario,cep,complemento,nmrCasa);
}

module.exports = {novo}
