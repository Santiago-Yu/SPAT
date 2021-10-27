class n7407008 {
	public static Image loadImage(String Lc5oCCC3) {
		ByteArrayOutputStream ODu4TPWD = new ByteArrayOutputStream();
		InputStream uXgowxiZ = mainFrame.getClass().getResourceAsStream(Lc5oCCC3);
		if (uXgowxiZ == null)
			throw new RuntimeException("Ressource " + Lc5oCCC3 + " not found");
		try {
			IOUtils.copy(uXgowxiZ, ODu4TPWD);
			uXgowxiZ.close();
			ODu4TPWD.flush();
		} catch (IOException eYUuBgdo) {
			eYUuBgdo.printStackTrace();
			new RuntimeException("Error reading ressource " + Lc5oCCC3, eYUuBgdo);
		}
		return Toolkit.getDefaultToolkit().createImage(ODu4TPWD.toByteArray());
	}

}