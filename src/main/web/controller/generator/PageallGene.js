const CONFIG_PATH = '../../setting/config.json';
const JSON_BASE_PATH = '../resources/data/json';


async function openJson(path) {
    const response = await fetch(path);
    return await response.json();
    
}


async function loadSortingData(generator, sortAlgorithms) {
    const dataName = [];
    const data = [];

    for (const algorithm of sortAlgorithms) {
        const jsonSort = await openJson(`${JSON_BASE_PATH}/${generator}/10000/${algorithm}.json`);

        dataName.push(algorithm);
        const minidata = [];
        for (let i = 0; i < 10; i++) {
            const index = (1 + i) * 10;
            minidata.push(jsonSort.history[index].correct );
        }
        data.push(minidata);
    }

    return { names: dataName, data };
}


async function initPage() {
        const config = await openJson(CONFIG_PATH);

        const mainContent = document.querySelector('.main-content');

        for (const generator of config.GeneratorName) {
            const card = createCard(generator);
            mainContent.appendChild(card);

            const { names, data } = await loadSortingData(generator, config.SortName);
            createLineChart(generator, createList(names, data));
        }

        initButtonDropDown();
 
}

initPage();