class n2910383 {
	public String downloadAndOpen(JProgressBar lhH6tC9w) {
		long rmAgvUvE = 0;
		try {
			rmAgvUvE = photo.getSize();
		} catch (ServiceException Wk3nwBIQ) {
			Wk3nwBIQ.printStackTrace();
		}
		try {
			lhH6tC9w.setMaximum((int) rmAgvUvE);
		} catch (Exception IDZDaYUx) {
			IDZDaYUx.printStackTrace();
		}
		lhH6tC9w.setValue(0);
		image = new File("TMP/" + photo.getTitle().getPlainText());
		try {
			if (!image.exists()) {
				image.createNewFile();
				image.deleteOnExit();
				URL XCK7axDS = null;
				BufferedOutputStream Vab6Kufr = null;
				try {
					XCK7axDS = new URL(photo.getMediaContents().get(0).getUrl());
					InputStream s4bb9DMj = null;
					s4bb9DMj = XCK7axDS.openStream();
					Vab6Kufr = new BufferedOutputStream(new FileOutputStream(image));
					byte[] e9odbVKK = new byte[32 * 1024];
					int B55FfOne = 0;
					int y01y0AiD = 0;
					while ((B55FfOne = s4bb9DMj.read(e9odbVKK)) != -1) {
						y01y0AiD += B55FfOne;
						lhH6tC9w.setValue(y01y0AiD);
						Vab6Kufr.write(e9odbVKK, 0, B55FfOne);
					}
					s4bb9DMj.close();
					Vab6Kufr.close();
				} catch (Exception C3seXaUS) {
					C3seXaUS.printStackTrace();
				}
			}
		} catch (Exception Jmm2xR05) {
			Jmm2xR05.printStackTrace();
		}
		return image.getAbsolutePath();
	}

}