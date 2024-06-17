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

    document.getElementById('termin-platnosci').value = params.terminPlatnosci;
    document.getElementById('kwota-do-zaplaty').value = params.kwotaDoZaplaty;
    document.getElementById('typ-instalacji').value = parms.instalacja

    document.getElementById('editForm').addEventListener('submit', function(event) {
        event.preventDefault();

        const updatedNaliczoneNaleznosci = {
            terminPlatnosci: document.getElementById('termin-platnosci').value,
            kwotaDoZaplaty: document.getElementById('kwota-do-zaplaty').value,
            instalacja: document.getElementById('typ-instalacji').value
        };

        updateNaliczoneNaleznosci(params.id, updatedNaliczoneNaleznosci.terminPlatnosci, updatedNaliczoneNaleznosci.kwotaDoZaplaty, updatedNaliczoneNaleznosci.instalacja)
            .then(response => {
                console.log(response.status);
                if (response.status === 'success') {
                    window.location.href = 'lista.html';
                } else {
                    alert('Blad podczas aktualizacji danych naliczonej naleznosci. Sprobuj ponownie.');
                }
            })
            .catch(error => {
                console.error('Blad podczas wysylania zadania aktualizacji naliczonej naleznosci:', error);
                alert('Wystapil blad. Sprobuj ponownie pozniej.');
            });
    });
});
