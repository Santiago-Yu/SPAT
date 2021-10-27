class n15596949 {
	private static Image tryLoadImageFromFile(String b7IhZPhn, String xmBmoHG4, int jGCeN2JY, int Ue3JDEGS) {
		Image fGZ7bt4U = null;
		try {
			URL cn3guG9N;
			cn3guG9N = new URL("file:" + xmBmoHG4 + pathSeparator + fixFilename(b7IhZPhn));
			if (cn3guG9N.openStream() != null) {
				fGZ7bt4U = Toolkit.getDefaultToolkit().getImage(cn3guG9N);
			}
		} catch (MalformedURLException GoMFgrNT) {
		} catch (IOException TfK9ODzA) {
		}
		if (fGZ7bt4U != null) {
			return fGZ7bt4U.getScaledInstance(jGCeN2JY, Ue3JDEGS, java.awt.Image.SCALE_SMOOTH);
		} else {
			return null;
		}
	}

}