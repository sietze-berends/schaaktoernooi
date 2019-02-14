$(document).ready(function () {
    $('#toonAlleSchakers').click(function () {
        $.ajax({
            type: "get",
            url: "/api/schakers",
        }).done(function(schakers) {
            vulschakers(schakers)
        });
    })

    function vulschakers(schakers) {
        var content = '<table id = "alleSchakers" class="table table-bordered table-striped table-hover table-condensed">'
        content += '<thead id = "thead">'
        content += '<tr> <th> id </th>'
        content += '<th> Voornaam </th>'
        content += '<th> Tussenvoegsel </th>'
        content += '<th> Achternaam </th>'
        content += '<th> Geboortedatum </th>'
        content += '<th> Gewonnen </th>'
        content += '<th> Remises </th>'
        content += '<th> Verloren </th>'
        content += '</thead>'
        content += '<tbody id = tableBody>'

        $.each(schakers, function(index, value) {
            content += '<tr>'
            content += '<td>' + value.id + '</td>'
            content += '<td>' + value.voornaam + '</td>'
            content += '<td>' + value.tussenvoegsel + '</td>'
            content += '<td>' + value.achternaam + '</td>'
            content += '<td>' + value.geboortedatum + '</td>'
            content += '<td>' + value.gewonnenPartijen + '</td>'
            content += '<td>' + value.remises + '</td>'
            content += '<td>' + value.verlorenPartijen + '</td>'
            content += "</tr>";
        })

        content += '</tbody> </table> <div class = "row"></div>'
        $("#allContent").html(content)
        $('#allReservations').DataTable();

    }

});


