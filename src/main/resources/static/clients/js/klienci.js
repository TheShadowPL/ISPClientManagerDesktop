function getAllKlienci() {
    fetch('/klienci')
        .then(response => response.json())
        .then(data => {
            console.log('Dane wszystkich klientów:', data);
            renderKlienci(data);
        })
        .catch(error => console.error('Błąd podczas pobierania danych klientów:', error));
}

function renderKlienci(klienci) {
    const klienciLista = document.getElementById('klienci-lista');
    klienciLista.innerHTML = '';

    klienci.forEach((klient, index) => {
        const row = `<tr>
                        <th scope="row">${index + 1}</th>
                        <td>${klient.imie}</td>
                        <td>${klient.nazwisko}</td>
                        <td>${klient.numerKlienta}</td>
                        <td>
                            <button class="btn btn-primary" onclick="editKlient(${klient.id})">Edytuj</button>
                            <button class="btn btn-danger" onclick="deleteKlient(${klient.id})">Usuń</button>
                        </td>
                    </tr>`;
        klienciLista.innerHTML += row;
    });
}

function editKlient(id) {
    fetch(`/klienci/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            window.location.href = `edytuj.html?id=${id}&imie=${data.imie}&nazwisko=${data.nazwisko}&numerKlienta=${data.numerKlienta}`;
        })
        .catch(error => console.error('Błąd podczas pobierania danych klienta:', error));
}

function updateKlient(id, imie, nazwisko, numerKlienta) {
    const klient = { imie: imie, nazwisko: nazwisko, numerKlienta: numerKlienta };
    return fetch(`/klienci/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(klient)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            return { status: 'success', data: data };
        })
        .catch(error => {
            console.error('Błąd podczas aktualizowania klienta:', error);
            throw error;
        });
}
function deleteKlient(id) {
    return fetch(`/klienci/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return { status: 'success' };
        })
        .then(() => {
            window.location.reload();
        })
        .catch(error => {
            console.error('Błąd podczas usuwania klienta:', error);
            throw error;
        });
}

function addKlient(imie, nazwisko, numerKlienta) {
    return fetch('/klienci', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ imie, nazwisko, numerKlienta })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json().then(data => {
                data.status = "success";
                return data;
            });
        })
        .catch(error => {
            console.error('Błąd podczas wysyłania żądania dodawania klienta:', error);
            throw error;
        });
}