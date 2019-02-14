$(document).ready(function () {
    function schakersOphalen() {
        $.ajax({
            type: "get",
            url: "/api/schakers"
        }).done(function (schakers) {
            vulschakers(schakers)
        });
    }

    $('#toonAlleSchakers').click(function () {
        schakersOphalen()
    });

    $('#schakerToevoegenForm').submit(function (event) {
        var $schakerForm = $(this).serializeArray();
        console.log($schakerForm)
        var $submitSchaker = {};
        $($schakerForm).each(function (i, field) {
            $submitSchaker[field.name] = field.value
        });
        $.ajax({
            type: "post",
            url: "/api/schakertoevoegen",
            data: JSON.stringify($submitSchaker),
            contentType: "application/json"
        }).done(function () {
            schakersOphalen()
        });
        return false
    });

    $(document).on('click','#verwijderschaker', function () {
        var id = $(this).parent().next('td').text();
        $.ajax({
            type: "delete",
            url: "/api/schakerverwijderen/" + id
        }).done(function () {
            schakersOphalen()
        });
        return false
    });


    function vulschakers(schakers) {
        var content = '<table id = "alleSchakers" class="table table-bordered table-striped table-hover table-condensed">'
        content += '<thead id = "thead">'
        content += '<tr> <th></th>'
        content += '<th> id </th>';
        content += '<th> Voornaam </th>';
        content += '<th> Tussenvoegsel </th>';
        content += '<th> Achternaam </th>';
        content += '<th> Geboortedatum </th>';
        content += '<th> Gewonnen </th>';
        content += '<th> Remises </th>';
        content += '<th> Verloren </th>';
        content += '</thead>';
        content += '<tbody id = tableBody>';

        $.each(schakers, function (index, value) {
            content += '<tr>';
            content += '<td><button id = "verwijderschaker">Verwijderen</button></td>'
            content += '<td>' + value.id + '</td>';
            content += '<td>' + value.voornaam + '</td>';
            content += '<td>' + value.tussenvoegsel + '</td>';
            content += '<td>' + value.achternaam + '</td>';
            content += '<td>' + value.geboortedatum + '</td>';
            content += '<td>' + value.gewonnenPartijen + '</td>';
            content += '<td>' + value.remises + '</td>';
            content += '<td>' + value.verlorenPartijen + '</td>';
            content += "</tr>";
        })

        content += '</tbody> </table> <div class = "row"></div>';
        $("#allContent").html(content);
        $('#allReservations').DataTable();

    }

});


