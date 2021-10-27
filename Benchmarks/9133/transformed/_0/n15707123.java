class n15707123 {
	private Bitmap fetchImage(String pnaw0uwf) throws Exception {
		URL K5giw2tl;
		K5giw2tl = new URL(pnaw0uwf);
		HttpURLConnection hNv1iXbZ = (HttpURLConnection) K5giw2tl.openConnection();
		hNv1iXbZ.setDoInput(true);
		hNv1iXbZ.setRequestProperty("User-Agent", "Agent");
		hNv1iXbZ.connect();
		InputStream mvxoBfrV = hNv1iXbZ.getInputStream();
		Bitmap yTEp3Vpy;
		yTEp3Vpy = BitmapFactory.decodeStream(mvxoBfrV);
		return yTEp3Vpy;
	}

}