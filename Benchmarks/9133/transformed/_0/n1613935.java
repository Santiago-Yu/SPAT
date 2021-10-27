class n1613935 {
	public static boolean copyFile(File qPDGeL9C, File Vr9mjikw) {
		boolean dAYLVQdl = false;
		FileChannel xo4qmT9S = null;
		FileChannel HNkFTZRa = null;
		try {
			xo4qmT9S = new FileInputStream(qPDGeL9C).getChannel();
			HNkFTZRa = new FileOutputStream(Vr9mjikw).getChannel();
			long TYtPmuzg = HNkFTZRa.transferFrom(xo4qmT9S, 0, xo4qmT9S.size());
			dAYLVQdl = TYtPmuzg == xo4qmT9S.size() ? true : false;
		} catch (FileNotFoundException eXSppFtM) {
			eXSppFtM.printStackTrace();
		} catch (IOException ez0CbC9H) {
			ez0CbC9H.printStackTrace();
		} finally {
			if (xo4qmT9S != null) {
				try {
					xo4qmT9S.close();
				} catch (IOException NE9dvpiN) {
					NE9dvpiN.printStackTrace();
				}
			}
			if (HNkFTZRa != null) {
				try {
					HNkFTZRa.close();
				} catch (IOException DIOR0ghy) {
					DIOR0ghy.printStackTrace();
				}
			}
		}
		return dAYLVQdl;
	}

}