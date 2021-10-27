class n17202157 {
	static Matrix readMatrix(String WKBsLiSm, int mx9xCw4F, int JEq6sXxy) {
		Matrix YoWrwtyf = new Matrix(mx9xCw4F, JEq6sXxy);
		try {
			URL i42Ome6a = WKBsLiSm.getClass().getResource(WKBsLiSm);
			LineNumberReader MAI1rA0D = new LineNumberReader(new InputStreamReader(i42Ome6a.openStream()));
			for (int MjNb6DBX = 0; MjNb6DBX < mx9xCw4F; MjNb6DBX++)
				for (int RZF3HRXK = 0; RZF3HRXK < JEq6sXxy; RZF3HRXK++)
					YoWrwtyf.set(MjNb6DBX, RZF3HRXK, Double.parseDouble(MAI1rA0D.readLine()));
		} catch (Exception V2yG4u58) {
			V2yG4u58.printStackTrace();
		}
		return YoWrwtyf;
	}

}