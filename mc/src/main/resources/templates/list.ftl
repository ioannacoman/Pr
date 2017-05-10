[#ftl]
<body>
<table class="table">
    <tr>
        <th>Nr.Crt</th>
        <th>Nume Produs</th>
        <th>Continut</th>
        <th>Cantitate</th>
        <th></th>
        <th>Pret</th>
        <th></th>
    </tr>
    <tr></tr>
    [#list produs as produs]
    <tr>
        <td>${produs.nrCrt}</td>
        <td>${produs.numeProdus}</td>
        <td>${produs.descriere}</td>
        <td>${produs.cant}</td>
        <td>${produs.unitateMasura}</td>
        <td>${produs.pret}</td>
        <td>adauga</td>
    </tr>
    [/#list]
</table>
</body>
