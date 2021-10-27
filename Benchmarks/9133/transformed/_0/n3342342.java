class n3342342 {
	private void downloadPhoto(File Ep7bjGFP, String q5YubxlG) {
		try {
			HttpClient oZMZni6s = new DefaultHttpClient();
			Log.v(TAG, "Dowloading photo from " + Server.URL + q5YubxlG);
			HttpGet ud8Inlrb = new HttpGet(Server.URL + q5YubxlG);
			HttpResponse emGphufv = oZMZni6s.execute(ud8Inlrb);
			HttpEntity JSdOqf8v = emGphufv.getEntity();
			InputStream NRIXJ8bF = JSdOqf8v.getContent();
			Ep7bjGFP.createNewFile();
			FileOutputStream aduuE26e = new FileOutputStream(Ep7bjGFP);
			byte[] ktCgSzB4 = new byte[1024];
			int jwyVsyrw;
			while ((jwyVsyrw = NRIXJ8bF.read(ktCgSzB4)) > 0) {
				aduuE26e.write(ktCgSzB4, 0, jwyVsyrw);
			}
			aduuE26e.flush();
			aduuE26e.close();
		} catch (Exception iPkI5VIm) {
			Log.e(TAG, iPkI5VIm.getMessage());
		}
	}

}