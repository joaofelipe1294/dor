/* funcoes genericas */

function mascara_cnpj (nome_campo){
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


function sao_iguais(campo_base , campo_copia , nome_botao){
    var base = $(campo_base);
    var copia = $(campo_copia);
    var botao = $(nome_botao);
    if(base.val() === copia.val()){
        botao.prop("disabled" , false);
    }else{
        botao.prop("disabled" , true);
    }
}

/* chamando as funcoes ! */

$('#cnpj_repetido').on('keyup' , function (){
    mascara_cnpj('#cnpj_repetido');
    sao_iguais('#cnpj' , '#cnpj_repetido' , '#botao');
});

$('#cnpj').on('keyup' , function (){
    mascara_cnpj('#cnpj');
});