class n20684330 {
	public String downloadToSdCard(String XZcFFdhd, String cjVpWmwo, String ikh1JEA5) {
		InputStream Zgk8XBxx = null;
		FileOutputStream MLRQsSgo = null;
		String KWIW64d8 = null;
		try {
			Log.i(TAG, "Opening URL: " + url);
			StreamAndHeader n3pJdqsP = HTTPUtils.openWithHeader(url, cjVpWmwo);
			if (n3pJdqsP == null || n3pJdqsP.mStream == null) {
				return null;
			}
			Zgk8XBxx = n3pJdqsP.mStream;
			String ovqm7EZM = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
			String Bk4QPkbF = cjVpWmwo == null || n3pJdqsP.mHeaderValue == null ? "" : n3pJdqsP.mHeaderValue;
			Bk4QPkbF = Bk4QPkbF.replaceAll("[-:]*\\s*", "");
			String nuDCdC66 = ovqm7EZM + "/" + XZcFFdhd + Bk4QPkbF + (ikh1JEA5 == null ? "" : ikh1JEA5);
			mSize = Zgk8XBxx.available();
			Log.i(TAG, "Downloading " + nuDCdC66 + ", size: " + mSize);
			MLRQsSgo = new FileOutputStream(new File(nuDCdC66));
			int WqniUb7f = 1024;
			byte[] yjCVEM96 = new byte[WqniUb7f];
			int aiyuSBri = WqniUb7f;
			mCount = 0;
			while (aiyuSBri != -1) {
				aiyuSBri = Zgk8XBxx.read(yjCVEM96, 0, WqniUb7f);
				if (aiyuSBri > 0) {
					Log.i(TAG, "Read " + aiyuSBri + " bytes...");
					MLRQsSgo.write(yjCVEM96, 0, aiyuSBri);
					mCount += aiyuSBri;
				}
			}
			MLRQsSgo.flush();
			MLRQsSgo.close();
			FileInputStream MZKmRfgE = new FileInputStream(nuDCdC66);
			mSavedSize = MZKmRfgE.available();
			Log.v(TAG, "saved size: " + mSavedSize);
			mAbsolutePath = nuDCdC66;
			done();
		} catch (Exception qlJH5QrK) {
			Log.e(TAG, "LoadingWorker.run", qlJH5QrK);
		} finally {
			HTTPUtils.close(Zgk8XBxx);
		}
		return mAbsolutePath;
	}

}