class n20334945 {
	public static String doGet(String NLFPpGLv, String AgxuH7Hq) {
		URL GpUeYLrh;
		try {
			if ((AgxuH7Hq != "") && (AgxuH7Hq != null)) {
				GpUeYLrh = new URL(NLFPpGLv + "?" + AgxuH7Hq);
			} else {
				GpUeYLrh = new URL(NLFPpGLv);
			}
			URLConnection psTobzbF = GpUeYLrh.openConnection();
			InputStream VmGonUoc = new BufferedInputStream(psTobzbF.getInputStream());
			try {
				StringBuffer oaHEfRkB = new StringBuffer();
				int QaSF5bdw;
				while ((QaSF5bdw = VmGonUoc.read()) != -1)
					oaHEfRkB.append((char) QaSF5bdw);
				return oaHEfRkB.toString();
			} finally {
				VmGonUoc.close();
			}
		} catch (IOException gnduIuyN) {
			;
		} catch (ClassCastException AbfvRDyE) {
			AbfvRDyE.printStackTrace();
		}
		return null;
	}

}