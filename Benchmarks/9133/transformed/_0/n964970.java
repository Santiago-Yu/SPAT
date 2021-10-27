class n964970 {
	private Drawable fetchImage(String NI3jpumY, Context CuOYLvfC) {
		URL Z5QNndHc;
		HttpClient C9rkQ2m2 = new DefaultHttpClient();
		try {
			if (PreferenceManager.getDefaultSharedPreferences(CuOYLvfC).getBoolean("use.urlimg.com", true)) {
				NI3jpumY = NI3jpumY.substring(NI3jpumY.indexOf("//") + 2);
				NI3jpumY = "http://urlimg.com/width/100/" + NI3jpumY;
			}
			Log.d(ImageCache.class.getName(), "Loading image from: " + NI3jpumY);
			HttpGet IgPWYucE = new HttpGet(NI3jpumY);
			HttpResponse PqnYqaun = C9rkQ2m2.execute(IgPWYucE);
			InputStream i5945arR = PqnYqaun.getEntity().getContent();
			Drawable wgtpHhPV = Drawable.createFromStream(i5945arR, "src");
			i5945arR.close();
			IgPWYucE.abort();
			return wgtpHhPV;
		} catch (IOException X2OnBaM2) {
			Log.e(ImageCache.class.getName(), "IOException while fetching: " + NI3jpumY);
			return TELKA;
		} finally {
		}
	}

}