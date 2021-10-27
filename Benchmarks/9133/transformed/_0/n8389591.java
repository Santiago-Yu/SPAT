class n8389591 {
	public static void testMapSource(MapSource ZUMXUeuo, EastNorthCoordinate K6mY0tTa) throws Exception {
		int OApTxzbH = ZUMXUeuo.getMaxZoom();
		MapSpace f5KYKHo9 = ZUMXUeuo.getMapSpace();
		int Uhr1qAzV = f5KYKHo9.cLonToX(K6mY0tTa.lon, OApTxzbH) / f5KYKHo9.getTileSize();
		int Gls15DqG = f5KYKHo9.cLatToY(K6mY0tTa.lat, OApTxzbH) / f5KYKHo9.getTileSize();
		URL oAJv8bJX = new URL(ZUMXUeuo.getTileUrl(OApTxzbH, Uhr1qAzV, Gls15DqG));
		HttpURLConnection cH723Wuf = (HttpURLConnection) oAJv8bJX.openConnection();
		cH723Wuf.connect();
		cH723Wuf.disconnect();
		if (cH723Wuf.getResponseCode() != 200)
			throw new MapSourceTestFailed(ZUMXUeuo, cH723Wuf.getResponseCode());
	}

}