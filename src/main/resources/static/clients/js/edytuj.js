document.addEventListener("DOMContentLoaded", function() {
    const getParams = function(url) {
        const params = {};
        const parser = document.createElement('a');
        parser.href = url;
        const query = parser.search.substring(1);
        const vars = query.split('&');
        for (let i = 0; i < vars.length; i++) {
            const pair = vars[i].split('=');
            params[pair[0]] = decodeURIComponent(pair[1]);
        }
        return params;
    };

    const params = getParams(window.location.href);

    document.getElementById('imie').value = params.imie;
    document.getElementById('nazwisko').value = params.nazwisko;
    document.getElementById('numerKlienta').value = params.numerKlienta;

    document.getElementById('editForm').addEventListener('submit', function(event) {
        event.preventDefault();

        const updatedKlient = {
            imie: document.getElementById('imie').value,
            nazwisko: document.getElementById('nazwisko').value,
            numerKlienta: document.getElementById('numerKlienta').value
        };

        updateKlient(params.id, updatedKlient.imie, updatedKlient.nazwisko, updatedKlient.numerKlienta)
            .then(response => {
                console.log(response.status)
                if (response.status === 'success') {
                    window.location.href = 'lista.html';
                } else {
                    alert('Błąd podczas aktualizacji danych klienta. Spróbuj ponownie.');
                }
            })
            .catch(error => {
                console.error('Błąd podczas wysyłania żądania aktualizacji klienta:', error);
                alert('Wystąpił błąd. Spróbuj ponownie później.');
            });
    });
});