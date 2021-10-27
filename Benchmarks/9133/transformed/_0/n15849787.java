class n15849787 {
	public static Document getDocument(String lbbMAqrB, String b9Yd5C8q) {
		DOMParser mFKBrjGg = new DOMParser();
		try {
			URL BlCfCAUI = new URL(lbbMAqrB);
			HttpURLConnection Cfu4zt32 = (HttpURLConnection) BlCfCAUI.openConnection();
			Cfu4zt32.setConnectTimeout(10000);
			Cfu4zt32.setUseCaches(false);
			Cfu4zt32.addRequestProperty("_", UUID.randomUUID().toString());
			String KSuZ4k02 = Cfu4zt32.getContentType();
			if (KSuZ4k02 == null) {
				return null;
			}
			String Ik7ye8WW = KSuZ4k02.replaceFirst("(?i).*charset=(.*)", "$1");
			String wJnxrNFH = Cfu4zt32.getContentEncoding();
			BufferedReader G2mBEkfc = null;
			if (!KSuZ4k02.equals(Ik7ye8WW)) {
				wJnxrNFH = Ik7ye8WW;
			}
			if (wJnxrNFH == null) {
				G2mBEkfc = new BufferedReader(new InputStreamReader(Cfu4zt32.getInputStream(), b9Yd5C8q));
			} else {
				G2mBEkfc = new BufferedReader(new InputStreamReader(Cfu4zt32.getInputStream(), wJnxrNFH));
			}
			InputSource TfoCrstu = new InputSource(G2mBEkfc);
			mFKBrjGg.setFeature("http://xml.org/sax/features/namespaces", false);
			mFKBrjGg.parse(TfoCrstu);
			Document LrttEyBX = mFKBrjGg.getDocument();
			String MxI9T9Ga = getMetaTagCharset(LrttEyBX);
			if (MxI9T9Ga != null && !MxI9T9Ga.equals(wJnxrNFH)) {
				HttpURLConnection eyNBD19w = (HttpURLConnection) BlCfCAUI.openConnection();
				eyNBD19w.setConnectTimeout(10000);
				eyNBD19w.setUseCaches(false);
				eyNBD19w.addRequestProperty("_", UUID.randomUUID().toString());
				G2mBEkfc = new BufferedReader(new InputStreamReader(eyNBD19w.getInputStream(), MxI9T9Ga));
				TfoCrstu = new InputSource(G2mBEkfc);
				mFKBrjGg.setFeature("http://xml.org/sax/features/namespaces", false);
				mFKBrjGg.parse(TfoCrstu);
				LrttEyBX = mFKBrjGg.getDocument();
			}
			G2mBEkfc.close();
			return LrttEyBX;
		} catch (DOMException y85CIsGX) {
			if (!"UTF-8".equals(b9Yd5C8q)) {
				return getDocument(lbbMAqrB, "UTF-8");
			}
			return null;
		} catch (Exception O4rejDWe) {
			return null;
		}
	}

}