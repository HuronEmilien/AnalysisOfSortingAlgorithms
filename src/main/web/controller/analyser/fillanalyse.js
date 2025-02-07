
function createCard(elt, value) {
    const card = document.createElement('div');
    card.className = 'card';
    
    const header = document.createElement('div');
    header.className = 'card-header';
    
    const title = document.createElement('h2');
    title.className = 'card-title';
    switch (value.Type) {
        case 'Quadratic':
            title.innerHTML = `${elt} [<span style="color: orange;"> ${value.Type} </span>]`;
            break;
        case 'Logarithmic':
            title.innerHTML = `${elt} [<span style="color: green;"> ${value.Type} </span>]`;
            break;
        case 'Wierd':
            title.innerHTML = `${elt} [<span style="color: red;"> ${value.Type} </span>]`;
            break;
        case 'Linear':
            title.innerHTML = `${elt} [<span style="color: pink;"> ${value.Type} </span>]`;
            break;

        default:
            title.innerHTML = `${elt} [<span style="color: gray;"> ${value.Type} </span>]`;
            break;
    }
    


    const body = document.createElement('div');
    body.className = 'card-body';

    const table = document.createElement('table');
    table.className = 'card-table';

    for (const [key, value1] of Object.entries(value)) {
        const row = document.createElement('tr');

        const cellKey = document.createElement('td');
        cellKey.className = 'card-table-key';
        cellKey.textContent = key;

        const cellValue = document.createElement('td');
        cellValue.className = 'card-table-value';
        cellValue.textContent = value1;

        row.appendChild(cellKey);
        row.appendChild(cellValue);
        table.appendChild(row);
    }

    body.appendChild(table);


    header.appendChild(title);
    card.appendChild(header);
    card.appendChild(body);


    return card;

}