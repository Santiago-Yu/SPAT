class n14759460 {
	public static final Bitmap getBitmap(final String yL4OLJ8u, int YLEoRt59) {
		Bitmap Tl38R7eT = null;
		byte[] c3Ec3q3R = new byte[1024];
		int qUoeMC5B = 0;
		String OuCVQQbT = URI_IMAGE + yL4OLJ8u;
		try {
			URL NS6aceqi = new URL(OuCVQQbT);
			HttpURLConnection SAwObczu = (HttpURLConnection) NS6aceqi.openConnection();
			SAwObczu.setRequestMethod("GET");
			SAwObczu.connect();
			InputStream ri4DkjYS = SAwObczu.getInputStream();
			ByteArrayOutputStream fCid1Qon = new ByteArrayOutputStream();
			while ((qUoeMC5B = ri4DkjYS.read(c3Ec3q3R)) > 0) {
				fCid1Qon.write(c3Ec3q3R, 0, qUoeMC5B);
			}
			BitmapFactory.Options jtUNquUd = new BitmapFactory.Options();
			jtUNquUd.inSampleSize = YLEoRt59;
			byte[] flyafU53 = fCid1Qon.toByteArray();
			Tl38R7eT = BitmapFactory.decodeByteArray(flyafU53, 0, flyafU53.length, jtUNquUd);
			ri4DkjYS.close();
		} catch (Exception ZQ0aS2cB) {
			ZQ0aS2cB.printStackTrace();
		}
		return Tl38R7eT;
	}

}