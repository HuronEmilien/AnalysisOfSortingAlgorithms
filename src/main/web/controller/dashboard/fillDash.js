function createCard() {
    const droplines = document.getElementsByClassName('dropdownsligne');

    for (let i = 0; i < droplines.length; i++) {
        const dropline = droplines[i];
        const cardId = i + 1;

        const generatorDropdown = createDropdown({
            width: '200px',
            buttonId: 'dropdownGenerator'+cardId,
            defaultText: 'ReverseGenerator',
            options: [
                "RandomGenerator",
                "ReverseGenerator",
                "FirstHalfChunkGenerator",
                "FirstHalfReverseGenerator",
                "SecondHalfChunkGenerator",
                "SecondHalfReverseGenerator"
            ],
            onSelect: (value) => updateDropdownData(cardId)
        });

        const sortValueDropdown = createDropdown({
            width: '120px',
            buttonId: 'dropdownSortValue'+cardId,
            defaultText: 'delay',
            options: ["arrayAccess", "comparaisons", "delay","set","swap"],
            onSelect: (value) => updateDropdownData(cardId)
        });

        const countDropdown = createDropdown({
            width: '85px',
            buttonId: 'dropdownCount'+cardId,
            defaultText: '10000',
            options: [100, 1000, 10000],
            onSelect: (value) => updateDropdownData(cardId)
        });

        dropline.append(generatorDropdown, sortValueDropdown, countDropdown);

        const card = document.getElementById(`card${cardId}`);
        const canvas = document.createElement('canvas');
        canvas.id = `chart${cardId}`;
        card.appendChild(canvas);
    }
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
            onSelect(value);
        });
        dropdownContent.appendChild(option);
    });

    dropdown.append(dropdownButton, dropdownContent);
    return dropdown;
}

async function updateDropdownData(cardId) {
    const generatorName = document.getElementById("dropdownGenerator"+cardId).textContent + "Strategy";
    const count = document.getElementById("dropdownCount"+cardId).textContent;
    const sortValue = document.getElementById("dropdownSortValue"+cardId).textContent;

    const config = await openJson('../../setting/config.json');
    const chartId = `chart${cardId}`;
    const chart = Chart.getChart(chartId);

    const dataName = [];
    const data = [];

    for (const sortName of config.SortName) {
        const jsonSort = await openJson(`../resources/data/json/${generatorName}/${count}/${sortName}.json`);
        dataName.push(sortName);
        data.push(jsonSort.global[sortValue]);
    }


    if (cardId===1) {
        createListDoughnut(sortValue, data,chart.data);
    }else if (cardId===2) {
        console.log(config.SortName);
        console.log(data);
        createListBar(sortValue, data,config.SortName,chart.data);
    }
    
    chart.update();
    
}