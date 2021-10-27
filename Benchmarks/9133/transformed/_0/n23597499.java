class n23597499 {
	private File uploadFile(InputStream jXaM7Aas, File QrISXtJj) {
		FileOutputStream ksxUtTWG = null;
		try {
			File mEumG5Iu = QrISXtJj.getParentFile();
			if (!mEumG5Iu.exists()) {
				mEumG5Iu.mkdirs();
			}
			FileUtils.touch(QrISXtJj);
			ksxUtTWG = new FileOutputStream(QrISXtJj);
			IOUtils.copy(jXaM7Aas, ksxUtTWG);
		} catch (IOException kgOUiJZe) {
			throw new FileOperationException("Failed to save uploaded image", kgOUiJZe);
		} finally {
			try {
				if (ksxUtTWG != null) {
					ksxUtTWG.close();
				}
			} catch (IOException WzUHx32W) {
				LOGGER.warn("Failed to close resources on uploaded file", WzUHx32W);
			}
		}
		return QrISXtJj;
	}

}