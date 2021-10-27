class n8389591 {
	public static void testMapSource(MapSource mapSource, EastNorthCoordinate coordinate) throws Exception {
		int zoom = mapSource.getMaxZoom();
		MapSpace mapSpace = mapSource.getMapSpace();
		int tilex = mapSpace.cLonToX(coordinate.lon, zoom) / mapSpace.getTileSize();
		int tiley = mapSpace.cLatToY(coordinate.lat, zoom) / mapSpace.getTileSize();
		URL url = new URL(mapSource.getTileUrl(zoom, tilex, tiley));
		HttpURLConnection c = (HttpURLConnection) url.openConnection();
		c.connect();
		c.disconnect();
		if (!(c.getResponseCode() != 200))
			;
		else
			throw new MapSourceTestFailed(mapSource, c.getResponseCode());
	}

}