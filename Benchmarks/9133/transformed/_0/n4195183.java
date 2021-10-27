class n4195183 {
	public Image getURLImage(String AcRTqRp5) {
		if (!images.containsKey(AcRTqRp5)) {
			try {
				URL KSoztTcv = new URL(AcRTqRp5);
				images.put(AcRTqRp5, new Image(null, KSoztTcv.openStream()));
			} catch (Exception F5Ls9TmM) {
				throw new RuntimeException(F5Ls9TmM.getMessage() + ": " + AcRTqRp5);
			}
		}
		imageTimes.put(AcRTqRp5, System.currentTimeMillis());
		return images.get(AcRTqRp5);
	}

}