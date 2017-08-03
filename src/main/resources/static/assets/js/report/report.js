var Script = function () {

    $(function () {
      Morris.Bar({
        element: 'hero-bar',
        data: [
          {device: 'iPhone', geekbench: 10},
          {device: 'iPhone 3G', geekbench: 20},
          {device: 'iPhone 3GS', geekbench: 40},
          {device: 'iPhone 4', geekbench: 70},
          {device: 'iPhone 4S', geekbench: 90},
          {device: 'iPhone 5', geekbench: 120}
        ],
        xkey: 'device',
        ykeys: ['geekbench'],
        labels: ['Geekbench'],
        barRatio: 0.4,
        xLabelAngle: 35,
        hideHover: 'auto',
        barColors: ['#ac92ec']
      });

    });
    

    
   
}();




