function getInformacion(json,url,id){
    $(id).html('<div class="mensajeNormal" ><img src="./../img/loading.gif" width="18px" height="18px"/>Cargando...</div>');    
    var data = jQuery.parseJSON(json);
    var ruta = url;
    $.ajax({
        url: ruta,
        type: "POST",
        data: data,
        success: function(datos)
        {
            $(id).html(datos);
        }
    }); 
}
function getInformacionSin(json,url,id){
    $(id).html('');    
    var data = jQuery.parseJSON(json);
    var ruta = url;
    $.ajax({
        url: ruta,
        type: "POST",
        data: data,
        success: function(datos)
        {
            $(id).html(datos);
        }
    }); 
}