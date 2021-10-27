class n12516574 {
	public static Image getImage(URL qPuAVU3A) throws IOException {
		InputStream jIz5oB2Y = null;
		try {
			jIz5oB2Y = qPuAVU3A.openStream();
			Image p17dkxP1 = getImage(jIz5oB2Y);
			p17dkxP1.setUrl(qPuAVU3A);
			return p17dkxP1;
		} finally {
			if (jIz5oB2Y != null) {
				jIz5oB2Y.close();
			}
		}
	}

}