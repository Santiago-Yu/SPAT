class n23511345 {
	public static Bitmap[] getMaps(double lat, double lon, int zoom) throws MalformedURLException, IOException {
		int latitudeTileNumber = lat2tile(lat, zoom);
		Bitmap[] maps = new Bitmap[10];
		int longitudeTileNumber = lon2tile(lon, zoom);
		int cpt = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				try {
					URL url = new URL(("http://tile.openstreetmap.org/" + zoom + "/" + (longitudeTileNumber + j) + "/"
							+ (latitudeTileNumber + i) + ".png"));
					Bitmap bmImg = BitmapFactory.decodeStream(url.openStream());
					maps[cpt] = bmImg;
					cpt++;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return maps;
	}

}