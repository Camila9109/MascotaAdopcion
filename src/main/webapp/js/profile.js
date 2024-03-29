var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {


    fillUsuario().then(function () {

        getSolicitadas(user.username);
    });

    $("#adoptar-btn").attr("href", `home.html?username=${username}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            username: username,
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-username").val(parsedResult.username);
                $("#input-contrasena").val(parsedResult.contrasena);
                $("#input-nombre").val(parsedResult.nombre);
                $("#input-apellido").val(parsedResult.apellido);
                $("#input-direccion").val(parsedResult.direccion);
                $("#input-email").val(parsedResult.email);
                $("#input-telefono").val(parsedResult.telefono);
                $("#input-ciudad").val(parsedResult.ciudad);

            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}

function getSolicitadas(username) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletSolicitadasListar",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarHistorial(parsedResult);

            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}

function mostrarHistorial(mascotas) {
    let contenido = "";
    if (mascotas.length >= 1) {
        $.each(mascotas, function (index, mascota) {
            mascota = JSON.parse(mascota);

            contenido += '<tr><th scope="row">' + mascota.id_mascota + '</th>' +
                    '<td>' + mascota.nombre + '</td>' +
                    '<td>' + mascota.tipo + '</td>' +
                    '<td>' + mascota.edad + '</td>' +
                    '<td>' + mascota.sexo + '</td>' +
                    '<td>' + mascota.raza + '</td>' +
                    '<td>' + mascota.novedad + '</td>' +
                    '<td>' + mascota.fechaSolicitud + '</td>';


        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}


function devolverPelicula(id) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletPeliculaDevolver",
        data: $.param({
            username: username,
            id: id
        }),
        success: function (result) {

            if (result != false) {

                location.reload();

            } else {
                console.log("Error devolviendo el Pelicula");
            }
        }
    });

}

function modificarUsuario() {

    let username = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let nombre = $("#input-nombre").val();
    let apellido = $("#input-apellido").val();
    let direccion = $("#input-direccion").val(); 
    let email = $("#input-email").val();
    let telefono = $("#input-telefono").val();
    let ciudad = $("#input-ciudad").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioModificar",
        data: $.param({
            username: username,
            contrasena: contrasena,
            nombre: nombre,
            apellido: apellido,
            direccion: direccion,
            email: email,
            telefono: telefono,
            ciudad: ciudad
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}
async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            username: username
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado");

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}



