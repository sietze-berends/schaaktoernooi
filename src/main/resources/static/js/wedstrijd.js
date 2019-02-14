$(document).ready(function () {
    function wedstrijdenOphalen() {
        $.ajax({
            type: "get",
            url: "/api/wedstrijden"
        }).done(function (wedstrijden) {
            vulwedstrijden(wedstrijden)
        });
    }

    $('#toonAlleWedstrijden').click(function () {
        wedstrijdenOphalen()
    })

    $('#wedstrijdAanmakenForm').submit(function (event) {
        var $wedstrijdForm = $(this).serializeArray();
        var $submitWedstrijd = {}
        $($wedstrijdForm).each(function (i, field) {
            $submitWedstrijd[field.name] = field.value
        });
        $.ajax({
            type: "post",
            url: "/api/wedstrijdtoevoegen",
            data: JSON.stringify($submitWedstrijd),
            contentType: "application/json"
        }).done(function () {
            wedstrijdenOphalen()
        });
        return false
    });

    function vulwedstrijden(wedstrijden) {
        var content = '<table id = "alleWedstrijden" class="table table-bordered table-striped table-hover table-condensed">'
        content += '<thead id = "thead">'
        content += '<tr>'
        content += '<th> id </th>';
        content += '<th> Speler 1 </th>';
        content += '<th> Speler 2</th>';
        content += '<th> Datum </th>';
        content += '<th> Winnaar </th>';
        content += '</thead>';
        content += '<tbody id = tableBody>';

        $.each(wedstrijden, function (index, value) {
            content += '<tr>';
            content += '<td id = "wedstrijdId">' + value.id + '</td>';
            content += '<td>' + value.speler1 + '</td>';
            content += '<td>' + value.speler2 + '</td>';
            content += '<td>' + value.datum + '</td>';
            content += '<td>' + value.winnaar + '</td>';
            content += "</tr>";
        })

        content += '</tbody> </table> <div class = "row"></div>';
        $("#allContent").html(content);
        $('#allReservations').DataTable();

    }
});