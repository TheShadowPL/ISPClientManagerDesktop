function getAllKlienci() {
    fetch('/klienci')
        .then(response => response.json())
        .then(data => {
            console.log('Dane wszystkich klientów:', data);
        })
        .catch(error => console.error('Błąd podczas pobierania danych klientów:', error));
}

function getKlientById(id) {
    fetch(`/klienci/${id}`)
        .then(response => response.json())
        .then(data => {
            console.log('Dane klienta o id', id, ':', data);
        })
        .catch(error => console.error('Błąd podczas pobierania danych klienta:', error));
}

function addKlient(imie, nazwisko, numer) {
    const klient = { imie: imie, nazwisko: nazwisko, numer: numer };
    fetch('/klienci', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(klient)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Nowy klient został dodany:', data);
        })
        .catch(error => console.error('Błąd podczas dodawania klienta:', error));
}

function updateKlient(id, imie, nazwisko, numer) {
    const klient = { imie: imie, nazwisko: nazwisko, numer: numer };
    fetch(`/klienci/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(klient)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Klient o id', id, 'został zaktualizowany:', data);
        })
        .catch(error => console.error('Błąd podczas aktualizowania klienta:', error));
}

function deleteKlient(id) {
    fetch(`/klienci/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            console.log('Klient o id', id, 'został usunięty');
        })
        .catch(error => console.error('Błąd podczas usuwania klienta:', error));
}



function getAllInstalacje() {
    fetch('/instalacje')
        .then(response => response.json())
        .then(data => {
            console.log('Dane wszystkich instalacji:', data);
        })
        .catch(error => console.error('Błąd podczas pobierania danych instalacji:', error));
}

function getInstalacjaById(id) {
    fetch(`/instalacje/${id}`)
        .then(response => response.json())
        .then(data => {
            console.log('Dane instalacji o id', id, ':', data);
        })
        .catch(error => console.error('Błąd podczas pobierania danych instalacji:', error));
}

function addInstalacja(adres, numerRouter, typUsługi) {
    const instalacja = { adres: adres, numerRouter: numerRouter, typUsługi: typUsługi };
    fetch('/instalacje', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(instalacja)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Nowa instalacja została dodana:', data);
        })
        .catch(error => console.error('Błąd podczas dodawania instalacji:', error));
}

function updateInstalacja(id, adres, numerRouter, typUsługi) {
    const instalacja = { adres: adres, numerRouter: numerRouter, typUsługi: typUsługi };
    fetch(`/instalacje/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(instalacja)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Instalacja o id', id, 'została zaktualizowana:', data);
        })
        .catch(error => console.error('Błąd podczas aktualizowania instalacji:', error));
}

function deleteInstalacja(id) {
    fetch(`/instalacje/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            console.log('Instalacja o id', id, 'została usunięta');
        })
        .catch(error => console.error('Błąd podczas usuwania instalacji:', error));
}




function getAllNaliczoneNależności() {
    fetch('/naliczone-naleznosci')
        .then(response => response.json())
        .then(data => {
            console.log('Dane wszystkich naliczonych należności:', data);
        })
        .catch(error => console.error('Błąd podczas pobierania danych naliczonych należności:', error));
}

function getNaliczoneNależnościById(id) {
    fetch(`/naliczone-naleznosci/${id}`)
        .then(response => response.json())
        .then(data => {
            console.log('Dane naliczonych należności o id', id, ':', data);
        })
        .catch(error => console.error('Błąd podczas pobierania danych naliczonych należności:', error));
}

function addNaliczoneNależności(terminPłatności, kwotaDoZapłaty) {
    const naliczoneNależności = { terminPłatności: terminPłatności, kwotaDoZapłaty: kwotaDoZapłaty };
    fetch('/naliczone-naleznosci', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(naliczoneNależności)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Nowe naliczone należności zostały dodane:', data);
        })
        .catch(error => console.error('Błąd podczas dodawania naliczonych należności:', error));
}

function updateNaliczoneNależności(id, terminPłatności, kwotaDoZapłaty) {
    const naliczoneNależności = { terminPłatności: terminPłatności, kwotaDoZapłaty: kwotaDoZapłaty };
    fetch(`/naliczone-naleznosci/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(naliczoneNależności)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Naliczone należności o id', id, 'zostały zaktualizowane:', data);
        })
        .catch(error => console.error('Błąd podczas aktualizowania naliczonych należności:', error));
}

function deleteNaliczoneNależności(id) {
    fetch(`/naliczone-naleznosci/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            console.log('Naliczone należności o id', id, 'zostały usunięte');
        })
        .catch(error => console.error('Błąd podczas usuwania naliczonych należności:', error));
}

function getAllDokonaneWpłaty() {
    fetch('/dokonane-wplaty')
        .then(response => response.json())
        .then(data => {
            console.log('Dane wszystkich dokonanych wpłat:', data);
        })
        .catch(error => console.error('Błąd podczas pobierania danych dokonanych wpłat:', error));
}

function getDokonaneWpłatyById(id) {
    fetch(`/dokonane-wplaty/${id}`)
        .then(response => response.json())
        .then(data => {
            console.log('Dane dokonanych wpłat o id', id, ':', data);
        })
        .catch(error => console.error('Błąd podczas pobierania danych dokonanych wpłat:', error));
}

function addDokonaneWpłaty(terminWpłaty, kwotaWpłaty) {
    const dokonaneWpłaty = { terminWpłaty: terminWpłaty, kwotaWpłaty: kwotaWpłaty };
    fetch('/dokonane-wplaty', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dokonaneWpłaty)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Nowe dokonane wpłaty zostały dodane:', data);
        })
        .catch(error => console.error('Błąd podczas dodawania dokonanych wpłat:', error));
}

function updateDokonaneWpłaty(id, terminWpłaty, kwotaWpłaty) {
    const dokonaneWpłaty = { terminWpłaty: terminWpłaty, kwotaWpłaty: kwotaWpłaty };
    fetch(`/dokonane-wplaty/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(dokonaneWpłaty)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Dokonane wpłaty o id', id, 'zostały zaktualizowane:', data);
        })
        .catch(error => console.error('Błąd podczas aktualizowania dokonanych wpłat:', error));
}

function deleteDokonaneWpłaty(id) {
    fetch(`/dokonane-wplaty/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            console.log('Dokonane wpłaty o id', id, 'zostały usunięte');
        })
        .catch(error => console.error('Błąd podczas usuwania dokonanych wpłat:', error));
}

function getAllCenniki() {
    fetch('/cenniki')
        .then(response => response.json())
        .then(data => {
            console.log('Dane wszystkich cenników:', data);
        })
        .catch(error => console.error('Błąd podczas pobierania danych cenników:', error));
}

function getCennikById(id) {
    fetch(`/cenniki/${id}`)
        .then(response => response.json())
        .then(data => {
            console.log('Dane cennika o id', id, ':', data);
        })
        .catch(error => console.error('Błąd podczas pobierania danych cennika:', error));
}

function addCennik(typUsługi, cena) {
    const cennik = { typUsługi: typUsługi, cena: cena };
    fetch('/cenniki', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(cennik)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Nowy cennik został dodany:', data);
        })
        .catch(error => console.error('Błąd podczas dodawania cennika:', error));
}

function updateCennik(id, typUsługi, cena) {
    const cennik = { typUsługi: typUsługi, cena: cena };
    fetch(`/cenniki/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(cennik)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Cennik o id', id, 'został zaktualizowany:', data);
        })
        .catch(error => console.error('Błąd podczas aktualizowania cennika:', error));
}

function deleteCennik(id) {
    fetch(`/cenniki/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            console.log('Cennik o id', id, 'został usunięty');
        })
        .catch(error => console.error('Błąd podczas usuwania cennika:', error));
}



