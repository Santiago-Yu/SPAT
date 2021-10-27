class n3353742 {
	public static Image getImage(URL FPxKtSDU) throws IOException {
		InputStream j2L77d7S = null;
		try {
			j2L77d7S = FPxKtSDU.openStream();
			Image yxtTIfAx = getImage(j2L77d7S);
			yxtTIfAx.setUrl(FPxKtSDU);
			return yxtTIfAx;
		} finally {
			if (j2L77d7S != null) {
				j2L77d7S.close();
			}
		}
	}

}