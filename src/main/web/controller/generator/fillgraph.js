function afficherJSON(data, key) {
    try {
        return data[key];
    } catch (error) {
        console.error('JSON reading error:', error.message);
    }
}

function createCard(elt) {
    // Create card container
    const card = document.createElement('div');
    card.className = 'card';
    
    // Create card header
    const header = document.createElement('div');
    header.className = 'card-header';
    
    // Create card title (convert camelCase to readable text)
    const title = document.createElement('h2');
    title.className = 'card-title';
    title.textContent = elt.slice(0, -8).replace(/([A-Z])/g, ' $1').trim();

    // Create dropdowns
    const sortValueDropdown = createDropdown({
        width: '120px',
        buttonId: 'dropdownSortValue',
        defaultText: 'correct',
        options: ["correct", "arrayAccess", "comparaison", "set", "swap", "delay"],
        onSelect: () => updateDatasets(elt)
    });

    const countDropdown = createDropdown({
        width: '100px',
        buttonId: 'dropdownCount',
        defaultText: '10000',
        options: [100, 1000, 10000],
        onSelect: () => updateDatasets(elt)
    });

    // Create dropdowns container
    const dropdownContainer = document.createElement('div');
    dropdownContainer.className = 'dropdownsligne';
    dropdownContainer.append(sortValueDropdown, countDropdown);
    
    // Assemble header
    header.append(title, dropdownContainer);
    
    // Create canvas
    const canvas = document.createElement('canvas');
    canvas.id = `chart-${elt}`;
    
    // Assemble card
    card.append(header, canvas);
    
    return card;
}

function createDropdown({ width, buttonId, defaultText, options, onSelect }) {
    const dropdown = document.createElement('div');
    dropdown.className = 'dropdown';
    dropdown.style.width = width;
    
    const dropdownButton = document.createElement('button');
    dropdownButton.className = 'dropdown-button';
    dropdownButton.id = buttonId;
    dropdownButton.textContent = defaultText;
    
    const dropdownContent = document.createElement('div');
    dropdownContent.className = 'dropdown-content';
    
    options.forEach(value => {
        const option = document.createElement('div');
        option.href = '#';
        option.className = 'dropdown-item';
        option.textContent = value;
        option.addEventListener('click', (e) => {
            e.preventDefault();
            dropdownButton.textContent = value;
            updateDatasets(dropdownButton.closest('.card').querySelector('canvas').id.replace('chart-', ''));
        });
        dropdownContent.appendChild(option);
    });
    
    dropdown.append(dropdownButton, dropdownContent);
    return dropdown;
}

async function updateDatasets(GeneratorName) {
    try {
        const count = document.getElementById('dropdownCount').textContent;
        const sortValue = document.getElementById('dropdownSortValue').textContent;
        const config = await openJson('../../setting/config.json');
        const chartId = `chart-${GeneratorName}`;
        const chart = Chart.getChart(chartId);

        const dataName = [];
        const data = [];

        for (const eltSort of config.SortName) {
            const jsonSort = await openJson(`../resources/data/json/${GeneratorName}/${count}/${eltSort}.json`);
            dataName.push(eltSort);

            const minidata = [];
            for (let i = 0; i < 10; i++) {
                minidata.push(jsonSort.history[(1 + i) * 10][sortValue]);
            }
            data.push(minidata);
        }

        chart.data.datasets = createList(dataName, data);
        chart.update();
    } catch (error) {
        console.error('Dataset update error:', error);
    }
}