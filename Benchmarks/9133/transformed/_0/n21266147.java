class n21266147 {
	public void execute() {
		File FSrvlxU0 = new File(oarfilePath);
		File K50jwZEz = new File(deploymentDirectory + File.separator + FSrvlxU0.getName());
		try {
			FileInputStream NPfqUjrw = new FileInputStream(FSrvlxU0);
			FileOutputStream QIMEfUex = new FileOutputStream(K50jwZEz);
			byte[] OyN9F2oj = new byte[2048];
			while (NPfqUjrw.read(OyN9F2oj) != -1) {
				QIMEfUex.write(OyN9F2oj);
			}
			NPfqUjrw.close();
			QIMEfUex.flush();
			QIMEfUex.close();
		} catch (IOException ay6wq4Qe) {
			logger.severe("failed to copy the file:" + ay6wq4Qe);
		}
	}

}