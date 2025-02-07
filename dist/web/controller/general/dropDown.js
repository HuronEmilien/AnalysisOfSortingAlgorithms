function initButtonDropDown(){
    const dropdowns = document.querySelectorAll('.dropdown');
    
    dropdowns.forEach(dropdown => {
        const dropdownButton = dropdown.querySelector('.dropdown-button');
        const dropdownContent = dropdown.querySelector('.dropdown-content');
        const dropdownItems = dropdown.querySelectorAll('.dropdown-item');

        // Ouvrir/Fermer le menu déroulant
        dropdownButton.addEventListener('click', () => {
            dropdownButton.classList.toggle('active');
            dropdownContent.classList.toggle('active');
        });

        // Sélectionner une option
        dropdownItems.forEach(item => {
            item.addEventListener('click', () => {
                dropdownButton.textContent = item.textContent;
                dropdownButton.classList.remove('active');
                dropdownContent.classList.remove('active');
                console.log(`Valeur sélectionnée : ${item.textContent}`);
            });
        });

        // Fermer le menu si on clique en dehors
        document.addEventListener('click', (e) => {
            if (!e.target.closest('.dropdown')) {
                dropdownButton.classList.remove('active');
                dropdownContent.classList.remove('active');
            }
        });
    });
}

