const CHART_COLORS = [
    'rgba(75, 192, 192, 0.8)',
    'rgba(54, 162, 235, 0.8)',
    'rgba(153, 102, 255, 0.8)',
    'rgba(255, 206, 86, 0.8)',
    'rgba(255, 99, 132, 0.8)',
    'rgba(255, 159, 64, 0.8)',
    'rgba(120, 12, 192, 0.8)',
    'rgba(2, 159, 64, 0.8)',
    'rgba(255, 99, 132, 0.8)',
    'rgba(255, 206, 86, 0.8)',
    'rgba(153, 2, 1, 0.8)'
];

function createDoughnutChart(ctxId, label, sortName,data) {
    const canvas = document.getElementById(ctxId);
    canvas.height = 300;
    const ctx = canvas.getContext('2d');
    new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: sortName,
            datasets: [{
                label: label,
                data: data,
                backgroundColor: CHART_COLORS,
                borderColor: CHART_COLORS,
                borderWidth: 1
            }]
        },
        options: {
            responsive: false,
            maintainAspectRatio: false,
            cutout: '70%',
            plugins: {
                legend: {
                    position: 'right',
                    labels: {
                        color: '#FFFFFF',
                        padding: 20
                    }
                      
                }
            }
        }
    });
}



function createListDoughnut(dataName, data,chart) {

    chart.datasets[0].label = dataName;
    chart.datasets[0].data = data;
}


