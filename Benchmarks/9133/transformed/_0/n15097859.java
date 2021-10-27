class n15097859 {
	public static Bitmap loadBitmap(String nlH3PeHJ, String ghPcvYw4, final String NbQmlnFS) {
		String uqn0xWme = XMLfunctions.URL;
		uqn0xWme = uqn0xWme.replace("{0}", nlH3PeHJ);
		uqn0xWme = uqn0xWme.replace("{1}", ghPcvYw4);
		InputStream wQBsyq3C = null;
		try {
			HttpGet WZ05h8aa = new HttpGet(new URL(uqn0xWme).toURI());
			HttpResponse BcF0ovGp = (HttpResponse) new DefaultHttpClient().execute(WZ05h8aa);
			WZ05h8aa = null;
			BufferedHttpEntity E0FNN7yX = new BufferedHttpEntity(BcF0ovGp.getEntity());
			BcF0ovGp = null;
			wQBsyq3C = E0FNN7yX.getContent();
			E0FNN7yX = null;
			if (wQBsyq3C != null) {
				final BitmapFactory.Options A4UymCZK = new BitmapFactory.Options();
				if (NbQmlnFS.equals("image")) {
					A4UymCZK.inSampleSize = 2;
				}
				return BitmapFactory.decodeStream(wQBsyq3C, null, A4UymCZK);
			} else {
			}
		} catch (IOException cCDyNcDE) {
		} catch (URISyntaxException pWcl0dZa) {
		} finally {
			if (wQBsyq3C != null)
				closeStream(wQBsyq3C);
		}
		return null;
	}

}