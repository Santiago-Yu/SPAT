class n12914949 {
	private void downloadImage(final String sImgName) {
		boolean Mm9yQyNX = sImgName != null;
		if (Mm9yQyNX && sImgName.length() > 0) {
			File f = new File(m_sTargetDir);
			if (f.canWrite()) {
				f = new File(f, sImgName);
				if (!f.exists()) {
					try {
						URL url = new URL(m_sCodeBase + '/' + sImgName);
						BufferedInputStream is = new BufferedInputStream(url.openStream());
						BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(f));
						int c;
						while ((c = is.read()) != -1) {
							os.write(c);
						}
						is.close();
						os.close();
					} catch (Exception exc) {
						System.out.println("TestImagesHelper::downloadImage(): " + exc);
					}
				}
			}
		}
	}

}