class n23511345 {
	public static Bitmap[] getMaps(double x6mWoPOu, double SMcIySlj, int m1XoB4dw)
			throws MalformedURLException, IOException {
		int LjzVC4lk = lat2tile(x6mWoPOu, m1XoB4dw);
		int RSlUC8oc = lon2tile(SMcIySlj, m1XoB4dw);
		Bitmap[] gY6PDpZi = new Bitmap[10];
		int MgcGvkTN = 0;
		for (int oxzFbiQz = -1; oxzFbiQz < 2; oxzFbiQz++) {
			for (int wiJWSZZi = -1; wiJWSZZi < 2; wiJWSZZi++) {
				try {
					URL RlBEHsgN = new URL(("http://tile.openstreetmap.org/" + m1XoB4dw + "/" + (RSlUC8oc + wiJWSZZi)
							+ "/" + (LjzVC4lk + oxzFbiQz) + ".png"));
					Bitmap IoGRqLzq = BitmapFactory.decodeStream(RlBEHsgN.openStream());
					gY6PDpZi[MgcGvkTN] = IoGRqLzq;
					MgcGvkTN++;
				} catch (IOException x4Zw0uLb) {
					x4Zw0uLb.printStackTrace();
				}
			}
		}
		return gY6PDpZi;
	}

}