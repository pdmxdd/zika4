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
  const reportSource = new ol.source.Vector({
      format: new ol.format.GeoJSON(),
      url: 'http://localhost:8080/report'
  });
  const reportLayer = new ol.layer.Vector({
      source: reportSource,
      style: function(feature) {
          return pointStyle;
      }
  });
  map.addLayer(reportLayer);



});
