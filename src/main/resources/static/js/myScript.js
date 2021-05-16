function selectRadio(obj){

    var btnAceptarAsignacion = document.getElementById('btnAceptarAsignacion');
    var txtMantenimiento = document.getElementById('txtMantenimiento');

    btnAceptarAsignacion.removeAttribute('disabled');

    var data = obj.value;
    var dataArray = data.split('-');

    var requestUrl = '/saveAsignacionMecanico';
    requestUrl = requestUrl+'/'+dataArray[1]+'/'+dataArray[0]+'/'+txtMantenimiento.getAttribute('data-form');

    btnAceptarAsignacion.setAttribute('href', requestUrl);

    var valueClass = 'btn btn-success';
    btnAceptarAsignacion.setAttribute('class', valueClass);
}

function selectAsigMec(obj){

    var dataMantenimiento = obj.getAttribute('data-form');
    var txtMantenimiento = document.getElementById('txtMantenimiento');
    
    txtMantenimiento.setAttribute('data-form', dataMantenimiento)
}