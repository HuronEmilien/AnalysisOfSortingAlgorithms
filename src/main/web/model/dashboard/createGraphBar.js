function createBarChart(ctxId, label, sortName, data) {
    const canvas = document.getElementById(ctxId);
    canvas.height = 300;
    const ctx = canvas.getContext('2d');
    

    let { sortNameModif, dataModif } = segmentData(sortName, data, 5);

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: sortNameModif,
            datasets: [{
                label: label,
                data: dataModif,
                backgroundColor: CHART_COLORS,
                borderColor: CHART_COLORS,
                borderWidth: 2,
                borderRadius: 5,
                barPercentage: 0.7
            }]
        },
        options: {
            responsive: false,
            maintainAspectRatio: false,
            animation: {
                duration: 1000,
                easing: 'easeInOutQuart'
            },
            scales: {
                y: {
                    beginAtZero: true,
                    grid: {
                        color: 'rgba(255, 255, 255, 0.1)'
                    },
                    ticks: {
                        color: '#FFFFFF',
                        font: {
                            size: 12
                        }
                    }
                },
                x: {
                    grid: {
                        display: false
                    },
                    ticks: {
                        color: '#FFFFFF',
                        font: {
                            size: 12
                        }
                    }
                }
            },
            plugins: {
                legend: {
                    display: false
                },
                tooltip: {
                    backgroundColor: 'rgba(0, 0, 0, 0.8)',
                    titleFont: {
                        size: 14
                    },
                    bodyFont: {
                        size: 13
                    }
                }
            }
        }
    });
}

function segmentData(sortName,data, segment) {
    let pairs = sortMultiArray(sortName, data);
    let sortNameModif = [];
    let dataModif = [];

    for (let i = 0; i < segment; i++) {
        sortNameModif[i] = pairs[i].name;
        dataModif[i] = pairs[i].value;
    }

    return { sortNameModif, dataModif };
}

function sortMultiArray(sortName, data) {
    let pairs = sortName.map((name, index) => ({
        name: name,
        value: data[index]
    }));
    pairs.sort((a, b) => a.value - b.value);
    return pairs;
}

function createListBar(dataName, data, sortName, chart) {
    
    let { sortNameModif, dataModif } = segmentData(sortName, data, 5);

    chart.labels = sortNameModif;
    chart.datasets[0].label = dataName;
    chart.datasets[0].data = dataModif;
}
