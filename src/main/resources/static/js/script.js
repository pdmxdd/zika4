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
});
