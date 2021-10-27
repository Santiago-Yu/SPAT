class n21722036 {
	public void loadXML(URL APUVUBqL, int HQiC8NiS, File Wmn25FpQ) {
		try {
			SAXBuilder Ryxpi8Rf = new SAXBuilder();
			try {
				if (Wmn25FpQ.exists()) {
					Wmn25FpQ.delete();
				}
				if (!Wmn25FpQ.exists()) {
					URLConnection pSe7IjgH = APUVUBqL.openConnection();
					pSe7IjgH.setConnectTimeout(5000);
					pSe7IjgH.setReadTimeout(10000);
					InputStream iqnkzaaT = pSe7IjgH.getInputStream();
					OutputStream lil2Em2W = new FileOutputStream(Wmn25FpQ);
					byte YyevjPdZ[] = new byte[1024];
					int JcxCahJ4;
					while ((JcxCahJ4 = iqnkzaaT.read(YyevjPdZ)) > 0)
						lil2Em2W.write(YyevjPdZ, 0, JcxCahJ4);
					lil2Em2W.close();
					iqnkzaaT.close();
				}
			} catch (Exception Idx0Gpft) {
				Log.e(Constants.PROJECT_TAG, "Exeption retrieving XML", Idx0Gpft);
			}
			try {
				document = Ryxpi8Rf.build(new FileInputStream(Wmn25FpQ));
			} catch (Exception AQalsBSF) {
				Log.e(Constants.PROJECT_TAG, "xml error ", AQalsBSF);
			}
		} catch (Exception gEtERk8k) {
			Log.e(Constants.PROJECT_TAG, "TsukiQueryError", gEtERk8k);
		}
		if (document != null) {
			root = document.getRootElement();
			PopulateDatabase(root, HQiC8NiS);
		}
	}

}