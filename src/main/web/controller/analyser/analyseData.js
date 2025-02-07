const CONFIG_PATH = '../../setting/complexity.json';

async function openJson(path) {
    const response = await fetch(path);
    tmp = await response.json();
    return tmp;
   
}

async function initTopDashboard() {
    
    const config = await openJson(CONFIG_PATH);
    const main = document.querySelector('.main-content');


    for (const [key, value] of Object.entries(config)) {
        const card = createCard(key, value);
        main.appendChild(card);
    }
    
}





initTopDashboard();