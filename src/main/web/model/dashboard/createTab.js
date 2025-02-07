

function createListTab(data){
    let tabcontainer = document.getElementsByClassName('Tabcontainer');

    let table = document.createElement('table');

    let thead = document.createElement('thead');
    thead.className = 'theadTab';

    let theadValue = ["Generator","Sort","arrayAccess","comparaisons","Set","Swap","Delay"]
    let tr = document.createElement('tr');

    for (let i = 0; i < theadValue.length; i++){
        let th = document.createElement('th');
        th.textContent = theadValue[i];
        tr.appendChild(th);
    }

    console.log(data);
    let tbody = document.createElement('tbody');
    tbody.className = 'tbodyTab';

    for (let i = 0; i < data.length; i++){
        let tr = document.createElement('tr');
        for (let j = 0; j < data[i].length; j++){
            let td = document.createElement('td');
            td.textContent = data[i][j];
            tr.appendChild(td);
        }
        tbody.appendChild(tr);

        
        
    }
    thead.appendChild(tr);
    table.appendChild(thead);
    table.appendChild(tbody);
    tabcontainer[0].appendChild(table);




}