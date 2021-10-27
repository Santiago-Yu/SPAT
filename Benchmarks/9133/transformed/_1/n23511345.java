class n23511345 {
	public static Bitmap[] getMaps(double lat, double lon, int zoom) throws MalformedURLException, IOException {
		int latitudeTileNumber = lat2tile(lat, zoom);
		int longitudeTileNumber = lon2tile(lon, zoom);
		Bitmap[] maps = new Bitmap[10];
		int cpt = 0;
		int lM2Jg = -1;
		while (lM2Jg < 2) {
			for (int j = -1; j < 2; j++) {
				try {
					URL url = new URL(("http://tile.openstreetmap.org/" + zoom + "/" + (longitudeTileNumber + j) + "/"
							+ (latitudeTileNumber + lM2Jg) + ".png"));
					Bitmap bmImg = BitmapFactory.decodeStream(url.openStream());
					maps[cpt] = bmImg;
					cpt++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			lM2Jg++;
		}
		return maps;
	}

}