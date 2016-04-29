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

    function libera_botao(){
        var div_razao_social = $('#div_razao_social');
        var div_cnpj = $('#div_cnpj');
        console.log(div_razao_social.hasClass('has-error'));
        if(div_razao_social.hasClass('has-success') && div_cnpj.hasClass('has-success')){
            $('#botao').prop('disabled' , false);
        }else{
            $('#botao').prop('disabled' , true);
        }
    }
    
    function remove_mascara (mascara){
        var contador = 0;
        var cnpj = '';
        while(contador < mascara.length){
            if(mascara[contador] !== '.' && mascara[contador] !== '/' && mascara[contador] !== '-'){
                cnpj += mascara[contador];
            }
            contador++;
        }
        return cnpj;
    }

/* funcoes anonimas */

            
    $('#razao_social').on('blur' , function (){
        var razao_social = $('#razao_social').val();
        $.ajax({
            type: 'GET',
            dataType: 'json',
            url: "http://localhost:8084/DOR/webresources/empresa/razao_social/" + razao_social ,
            success: function (data, textStatus, jqXHR) {
                if(data === true){
                    $('#div_razao_social').addClass('has-error');
                    $('#div_razao_social').removeClass('has-success');
                }else{
                    $('#div_razao_social').removeClass('has-error');
                    $('#div_razao_social').addClass('has-success');
                }
                libera_botao();
            }
        });
    });
                    
    $('#cnpj').on('blur' , function (){
        var cnpj = remove_mascara($('#cnpj').val());
        $.ajax({
            type: 'GET' , 
            dataType: 'json' , 
            url: "http://localhost:8084/DOR/webresources/empresa/cnpj/" + cnpj ,
            success: function (data, textStatus, jqXHR) {
                if(data === true){
                    $('#div_cnpj').addClass('has-error');
                    $('#div_cnpj').removeClass('has-success');
                }else{
                    $('#div_cnpj').removeClass('has-error');
                    $('#div_cnpj').addClass('has-success'); 
                }
                libera_botao();
            }
        });
    });

/* chamando as funcoes ! */

$('#cnpj_repetido').on('keyup' , function (){
    mascara_cnpj('#cnpj_repetido');
    sao_iguais('#cnpj' , '#cnpj_repetido' , '#botao');
});

$('#cnpj').on('keyup' , function (){
    mascara_cnpj('#cnpj');
});