/* funcoes genericas */

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