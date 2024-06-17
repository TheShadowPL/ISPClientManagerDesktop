function getAllNaliczoneNaleznosci() {
    fetch('/naliczone-naleznosci')
        .then(response => response.json())
        .then(data => {
            console.log('Dane wszystkich naliczonych należności:', data);
            renderNaliczoneNaleznosci(data);
        })
        .catch(error => console.error('Błąd podczas pobierania danych naliczonych należności:', error));
}

function renderNaliczoneNaleznosci(naliczoneNaleznosci) {
    const tabela = document.getElementById('naliczone-naleznosci-lista');
    tabela.innerHTML = '';

    naliczoneNaleznosci.forEach(naleznosc => {
        const wiersz = `<tr>
                            <td>${naleznosc.id}</td>
                            <td>${naleznosc.terminPlatnosci}</td>
                            <td>${naleznosc.kwotaDoZaplaty}</td>
                            <td>${naleznosc.instalacja}</td>
                            <td>
                                <button class="btn btn-primary" onclick="editNaliczoneNaleznosci(${naleznosc.id})">Edytuj</button>
                                <button class="btn btn-danger" onclick="deleteNaliczoneNaleznosci(${naleznosc.id})">Usuń</button>
                            </td>
                        </tr>`;
        tabela.innerHTML += wiersz;
    });
}
function getNaliczoneNaleznosciById(id) {
    fetch(`/naliczone-naleznosci/${id}`)
        .then(response => response.json())
        .then(data => {
            console.log('Dane naliczonych należności o id', id, ':', data);
        })
        .catch(error => console.error('Błąd podczas pobierania danych naliczonych należności:', error));
}

window.addEventListener('DOMContentLoaded', () => {
    getAllNaliczoneNaleznosci();
});

function addNaliczoneNaleznosci(terminPlatnosci, kwotaDoZaplaty, instalacja) {
    const naliczoneNaleznosci = { terminPlatnosci: terminPlatnosci, kwotaDoZaplaty: kwotaDoZaplaty, instalacja: instalacja };
    fetch('/naliczone-naleznosci', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(naliczoneNaleznosci)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Nowe naliczone należności zostały dodane:', data);
            window.location.href = 'lista.html';
        })
        .catch(error => console.error('Błąd podczas dodawania naliczonych należności:', error));
}

function updateNaliczoneNaleznosci(id, terminPlatnosci, kwotaDoZaplaty, instalacja) {
    const naliczoneNaleznosci = { terminPlatnosci: terminPlatnosci, kwotaDoZaplaty: kwotaDoZaplaty, instalacja: instalacja };
    fetch(`/naliczone-naleznosci/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(naliczoneNaleznosci)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Naliczone należności o id', id, 'zostały zaktualizowane:', data);
        })
        .catch(error => console.error('Błąd podczas aktualizowania naliczonych należności:', error));
}

function deleteNaliczoneNaleznosci(id) {
    fetch(`/naliczone-naleznosci/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            console.log('Naliczone należności o id', id, 'zostały usunięte');
        })
        .then(() => {
            window.location.reload();
        })
        .catch(error => console.error('Błąd podczas usuwania naliczonych należności:', error));
}

function editNaliczoneNaleznosci(){
    fetch(`/naliczone-naleznosci/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            window.location.href = `edytuj.html?id=${id}&termin-platnosci=${data.terminPlatnosci}&kwota-do-zaplaty=${data.kwotaDoZaplaty}&typ-instalacji=${data.instalacja}`;
        })
        .catch(error => console.error('Błąd podczas pobierania danych klienta:', error));
}
