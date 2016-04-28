function mascara_cnpj (nome_campo){
    alert('yo')
    var campo = $(nome_campo);
    var valor_atual = campo.val();
    if(valor_atual.length === 2 || valor_atual.length === 6){
        campo.val(valor_atual += '.');
    }else if (valor_atual.length === 10){
        campo.val(valor_atual += '/');
    }else if (valor_atual.length === 15){
        campo.val(valor_atual += '-');
    }
}

