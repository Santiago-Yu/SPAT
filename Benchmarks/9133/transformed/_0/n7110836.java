class n7110836 {
	private void copyFile(File SDZONn8h, File qFDF6HMI) {
		try {
			byte[] JcngPKf0 = new byte[1024];
			File iwY7ZHWC = new File(SDZONn8h.getCanonicalPath() + File.separatorChar + qFDF6HMI.getName());
			if (iwY7ZHWC.createNewFile()) {
				FileInputStream euDVoKXu = new FileInputStream(qFDF6HMI);
				FileOutputStream aPeOboAF = new FileOutputStream(iwY7ZHWC);
				int acPTV1Yc;
				do {
					acPTV1Yc = euDVoKXu.read(JcngPKf0);
					aPeOboAF.write(JcngPKf0, 0, acPTV1Yc);
				} while (acPTV1Yc == 0);
				aPeOboAF.flush();
				aPeOboAF.close();
				euDVoKXu.close();
			} else {
				logger.severe("unable to create file:" + iwY7ZHWC.getAbsolutePath());
			}
		} catch (IOException wNMkAeNt) {
			logger.severe("unable to create file:" + wNMkAeNt);
		}
	}

}