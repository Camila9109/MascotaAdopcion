var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {

        $("#mi-perfil-btn").attr("href", "profile.html?username=" + username);
       
        getMascotas(false, "ASC");
    });
});


async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}

function getMascotas(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletMascotaListar",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                mostrarMascotas(parsedResult);
            } else {
                console.log("Error recuperando los datos de las Mascotas");
            }
        }
    });
}

function mostrarMascotas(mascotas) {

    let contenido = "";

    $.each(mascotas, function (index, mascota) {

        mascota = JSON.parse(mascota);

        contenido += '<tr><th scope="row">' + mascota.id_mascota + '</th>' +
                '<td>' + mascota.nombre_mascota + '</td>' +
                '<td>' + mascota.tipo + '</td>' +
                '<td>' + mascota.edad + '</td>' +
                '<td>' + mascota.sexo + '</td>' +
                '<td>' + mascota.raza + '</td>' +
                '<td>' + mascota.novedad + '</td>';

        contenido += '></td>' +
                '<td><button onclick="adoptarMascota(' + mascota.id_mascota + ',' + mascota.nombre_mascota + ');" class="btn btn-success" ';
        contenido += '>Adoptar</button></td></tr>'

        $("#mascotas-tbody").html(contenido);
    });

}
