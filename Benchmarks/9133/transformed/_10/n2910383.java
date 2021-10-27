class n2910383 {
	public String downloadAndOpen(JProgressBar bar) {
		long size = 0;
		try {
			size = photo.getSize();
		} catch (ServiceException ex) {
			ex.printStackTrace();
		}
		try {
			bar.setMaximum((int) size);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		bar.setValue(0);
		image = new File("TMP/" + photo.getTitle().getPlainText());
		try {
			if (!image.exists()) {
				image.createNewFile();
				image.deleteOnExit();
				BufferedOutputStream fOut = null;
				URL url = null;
				try {
					InputStream html = null;
					url = new URL(photo.getMediaContents().get(0).getUrl());
					html = url.openStream();
					byte[] buffer = new byte[32 * 1024];
					fOut = new BufferedOutputStream(new FileOutputStream(image));
					int in = 0;
					int bytesRead = 0;
					while ((bytesRead = html.read(buffer)) != -1) {
						in += bytesRead;
						bar.setValue(in);
						fOut.write(buffer, 0, bytesRead);
					}
					html.close();
					fOut.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return image.getAbsolutePath();
	}

}