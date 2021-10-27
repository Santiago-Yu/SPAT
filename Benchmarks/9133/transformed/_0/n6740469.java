class n6740469 {
	private void copyFile(String RUOQnjHG, String j9SrVAbT) throws BuildException {
		log("Copying file " + RUOQnjHG + " to " + j9SrVAbT);
		File QhdHZqfx = getDestFile(RUOQnjHG, j9SrVAbT);
		InputStream ocLOh06G = null;
		OutputStream AuX2BvRl = null;
		try {
			ocLOh06G = new BufferedInputStream(new FileInputStream(RUOQnjHG));
			AuX2BvRl = new BufferedOutputStream(new FileOutputStream(QhdHZqfx));
			byte[] iryQiT99 = new byte[1024];
			int eeoWfsBB = 0;
			while ((eeoWfsBB = ocLOh06G.read(iryQiT99)) != -1)
				AuX2BvRl.write(iryQiT99, 0, eeoWfsBB);
		} catch (Exception IuLTr8pw) {
			throw new BuildException("Failed to copy file \"" + RUOQnjHG + "\" to directory \"" + j9SrVAbT + "\"");
		} finally {
			try {
				if (ocLOh06G != null)
					ocLOh06G.close();
			} catch (IOException ucKDVbq4) {
			}
			try {
				if (AuX2BvRl != null)
					AuX2BvRl.close();
			} catch (IOException Odtxgjrq) {
			}
		}
	}

}