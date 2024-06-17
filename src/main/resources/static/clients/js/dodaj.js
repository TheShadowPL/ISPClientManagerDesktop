document.addEventListener('DOMContentLoaded', function () {
    const form = document.querySelector('form');

    form.addEventListener('submit', function (event) {
        event.preventDefault();

        const imie = document.getElementById('imie').value;
        const nazwisko = document.getElementById('nazwisko').value;
        const numerKlienta = document.getElementById('numerKlienta').value;

        addKlient(imie, nazwisko, numerKlienta)
            .then(response => {
                console.log(response)
                if (response.status === 'success') {
                    window.location.href = 'lista.html';
                } else {
                    alert('Błąd podczas dodawania klienta. Spróbuj ponownie.');
                }
            })
            .catch(error => {
                console.error('Błąd podczas wysyłania żądania dodawania klienta:', error);
                alert('Wystąpił błąd. Spróbuj ponownie później.');
            });
    });
});