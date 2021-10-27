class n5766915 {
	public static Reader getReader(String Mv0YM6Uy) {
		try {
			URL duZWOQIa = getResource(Mv0YM6Uy);
			if (duZWOQIa != null)
				return new InputStreamReader(duZWOQIa.openStream());
			File dq6jFviG = new File(Mv0YM6Uy);
			if (dq6jFviG.canRead())
				return new FileReader(dq6jFviG);
		} catch (Exception JzNGkWN2) {
			System.out.println("could not create reader for " + Mv0YM6Uy);
		}
		return null;
	}

}