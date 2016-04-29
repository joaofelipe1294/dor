/* funcoes genericas*/

function sao_iguais(campo_base , campo_copia , nome_botao){
    var base = $(campo_base);
    var copia = $(campo_copia);
    var botao = $(nome_botao);
    if(base.val() === copia.val() && base.val().length > 2){
        botao.prop("disabled" , false);
    }else{
        botao.prop("disabled" , true);
    }
}

/* funcoes anonimas */

$('#trocar_senha').on('click' , function (){
    var checado = document.getElementById("trocar_senha").checked;
    if(checado){
        $('#senhas').show();
        $('#botao').prop("disabled" , true);
    }else{
        $('#senhas').hide();
        $('#botao').removeProp("disabled");
    }
});

$('#email').on('blur' , function (){
    $.ajax({
         type: 'GET' ,
         dataType: 'json' ,
         url: 'http://localhost:8084/DOR/webresources/usuario/' + $('#email').val() ,
         success: function (data, textStatus, jqXHR) {
             if(data === true){
                 $('#div_email').addClass('has-error');
                 $('#div_email').removeClass('has-success');
             }else{
                 $('#div_email').removeClass('has-error');
                 $('#div_email').addClass('has-success');
             }
         }
    }); 
});

/* chamando as funcoes ! */

$('#senha').on('keyup' , function (){
    sao_iguais('#senha' , '#senha_repetida' , '#botao');
});

$('#senha_repetida').on('keyup' , function (){
    sao_iguais('#senha_repetida' , '#senha' , '#botao');
});

$('#email_repetido').on('keyup' , function (){
    sao_iguais('#email' , '#email_repetido' , '#botao');
});