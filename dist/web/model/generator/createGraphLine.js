const FLASHY_COLORS = [
  'rgb(255, 0, 0)',     // Rouge vif
  'rgb(0, 255, 0)',     // Vert flashy
  'rgb(0, 0, 255)',     // Bleu électrique
  'rgb(255, 0, 255)',   // Magenta
  'rgb(255, 255, 0)',   // Jaune vif
  'rgb(0, 255, 255)',   // Cyan
  'rgb(255, 128, 0)',   // Orange vif
  'rgb(128, 0, 255)',   // Violet
  'rgb(255, 0, 128)',   // Rose flashy
  'rgb(0, 255, 128)'    // Vert lime
];

function createLineChart(ctxId, datasets) {
    const canvas = document.getElementById(`chart-${ctxId}`);
    canvas.height = 330; // hauteur du graph
    const ctx = canvas.getContext('2d');
    new Chart(ctx, {
      type: 'line',
      data: {
        labels: ['10%', '20%', '30%', '40%', '50%', '60%', '70%', '80%', '90%', '100%'],
        datasets: datasets
      },
      options: {
        
        responsive: false,
        maintainAspectRatio: false, 
        scales: {
          x: {
            grid: {
              color: 'rgba(255, 255, 255, 0.2)' 
            },
            ticks: {
              color: ' #d5d8dc' 
            }
          },
          y: {
            grid: {
              color: 'rgba(255, 255, 255, 0.2)' 
            },
            ticks: {
              color: ' #d5d8dc' 
            }
          }
        }
      }
    });
  }



function createList(labels, data) {
  
  let list = [];
  
  for (let i = 0; i < labels.length; i++) {
    tmp = FLASHY_COLORS[i % FLASHY_COLORS.length];
    list.push({
      label: labels[i],
      data: data[i] || [],
      borderColor: tmp,
      borderWidth: 1,
      pointBackgroundColor: tmp,
      pointBorderColor: tmp,
      pointRadius: 2,
      tension: 0.2,
      fill: false,
      backgroundColor: tmp.replace('rgb', 'rgba').replace(')', ', 0.4)'),
    });
    
  }
  return list;
}


  
  
  