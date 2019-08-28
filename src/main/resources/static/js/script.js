/* global $, document, ol */
$(document).ready(() => {
  const view = new ol.View({
    center: [-9101767, 1823912],
    zoom: 5,
  });

  // our map loaded from OSM
  const map = new ol.Map({
    controls: ol.control.defaults().extend([
      new ol.control.FullScreen({
        source: 'fullscreen',
      }),
    ]),
    layers: [
      new ol.layer.Tile({
        source: new ol.source.OSM(),
      }),
    ],
    target: 'map',
    view,
  });

  const pointStyle = new ol.style.Style({
          image: new ol.style.Circle({
              radius: 5,
              fill: null,
              stroke: new ol.style.Stroke({color: 'red', width: 1})
          })
      });

  function generateSource(dateString) {
      return new ol.source.Vector({
          format: new ol.format.GeoJSON(),
          url: '/api/report?date=' + dateString
      })
  }

  const reportLayer = new ol.layer.Vector({
    source: generateSource('2016-08-20'),
    style: new ol.style.Style({
        fill: new ol.style.Fill({
            color: 'rgba(255, 255, 255, 0.6)',
        }),
        stroke: new ol.style.Stroke({
            color: '#319FD3',
            width: 1
        })
    }),

  })
  map.addLayer(reportLayer);

  map.on('click', function(event) {

    map.forEachFeatureAtPixel(event.pixel, function(feature,layer) {
        console.log(feature);
        console.log(feature.get('location_string'));
        console.log(feature.get('value'));
        console.log(feature.get('unit'));
        $('#sidepanel-reports').empty();
        // noinspection JSAnnotator
        //$('#sidepanel-reports').append(`<h1>TEST</h1>`);
        $('#sidepanel-reports').append(`<div id="reportList"><h3>${feature.get('location_string')}</h3><p>Value: ${feature.get('value')}</p><p>Unit: ${feature.get('unit')}</p></div>`);
    })
  });



  $('#date-select').empty()
  fetch('/api/report/dates/unique')
    .then(data => {
        data.json().then(json => {
            //console.log(json);
            for(let i = 0; i < json.length; i++) {
                //console.log(json[i]);
                $('#date-select').append('<option value=' + json[i] + '>' + json[i] + '</option>');
            }
        })
    })
  $('#date-select').change(data => {
    console.log('changed');
    console.log($('#date-select').val());
    reportLayer.setSource(generateSource($('#date-select').val()));
  });


});
