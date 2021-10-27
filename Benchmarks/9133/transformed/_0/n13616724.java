class n13616724 {
	public void write(File JaGM5jmr) throws Exception {
		if (medooFile != null) {
			if (!medooFile.renameTo(JaGM5jmr)) {
				BufferedInputStream GLBhHHel = null;
				BufferedOutputStream R7cy23Ur = null;
				try {
					GLBhHHel = new BufferedInputStream(new FileInputStream(medooFile));
					R7cy23Ur = new BufferedOutputStream(new FileOutputStream(JaGM5jmr));
					IOUtils.copy(GLBhHHel, R7cy23Ur);
				} finally {
					if (GLBhHHel != null) {
						try {
							GLBhHHel.close();
						} catch (IOException evNFyPEO) {
						}
					}
					if (R7cy23Ur != null) {
						try {
							R7cy23Ur.close();
						} catch (IOException HPpMaOct) {
						}
					}
				}
			}
		} else {
			throw new FileUploadException("Cannot write uploaded file to disk!");
		}
	}

}