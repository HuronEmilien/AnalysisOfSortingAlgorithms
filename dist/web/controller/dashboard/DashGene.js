const CONFIG_PATH = '../../setting/config.json';
const JSON_BASE_PATH = '../resources/data/json/ReverseGeneratorStrategy/10000';

async function openJson(path) {
    const response = await fetch(path);
    tmp = await response.json();
    return tmp;
   
}

async function loadStrategyDelays(strategies) {
    const delayPromises = [];
    for (const strategy of strategies) {
        const data = await openJson(`${JSON_BASE_PATH}/${strategy}.json`);
        delayPromises.push(data.global.delay);
    }
    return await Promise.all(delayPromises);
}


async function initTopDashboard() {
    const config = await openJson(CONFIG_PATH);
    const strategies = config.SortName;
    const delays = await loadStrategyDelays(strategies);

    createCard();
    createDoughnutChart("chart1", 'delay', strategies, delays);
    createBarChart("chart2", 'delay', strategies, delays);
    initBottomDashboard();
    initButtonDropDown();

}


async function initBottomDashboard() {
    const config = await openJson(CONFIG_PATH);
    const strategies = config.SortName;
    let tmp = [];
    for (let i = 0 ; i < config.GeneratorName.length; i++) {
        const generator = config.GeneratorName[i];
        for (let j = 0; j < config.SortName.length; j++) {
            const sort = config.SortName[j];
            const data = await openJson(`../resources/data/json/${generator}/${10000}/${sort}.json`);
            tmp.push([generator, sort, data.global.arrayAccess, data.global.comparaisons, data.global.set, data.global.swap, data.global.delay]);
        }

        
    }
    createListTab(tmp);

}


initTopDashboard();