class n12561424 {
	private boolean copyFile(File xepg50u4) throws Exception {
		destination = new File(ServiceLocator.getSqliteDir(), xepg50u4.getName());
		logger.debug("Writing to: " + destination);
		if (destination.exists()) {
			Frame.showMessage(ServiceLocator.getText("Error.file.exists") + xepg50u4.getName(), null);
			logger.debug("File already exists: " + xepg50u4);
			return false;
		}
		destination.createNewFile();
		InputStream UZPyBYk1 = null;
		OutputStream kXdPo98H = null;
		try {
			UZPyBYk1 = new FileInputStream(xepg50u4);
			kXdPo98H = new FileOutputStream(destination);
			int tAMZS6tf = 0;
			byte[] qEObJonk = new byte[2048];
			while ((tAMZS6tf = UZPyBYk1.read(qEObJonk)) > 0) {
				kXdPo98H.write(qEObJonk, 0, tAMZS6tf);
			}
		} finally {
			if (UZPyBYk1 != null)
				UZPyBYk1.close();
			if (kXdPo98H != null)
				kXdPo98H.close();
		}
		return true;
	}

}