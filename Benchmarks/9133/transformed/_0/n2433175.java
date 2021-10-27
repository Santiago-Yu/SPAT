class n2433175 {
	private void copyFile(File D4HhQQf6, File DQoQmIXT) {
		byte[] FeRuLxRh = new byte[1024];
		try {
			FileInputStream lRc6WiVP = new FileInputStream(D4HhQQf6);
			FileOutputStream TMt9hT0g = new FileOutputStream(DQoQmIXT, true);
			int jLziA5R7 = 0;
			do {
				jLziA5R7 = lRc6WiVP.read(FeRuLxRh);
				if (jLziA5R7 > 0)
					TMt9hT0g.write(FeRuLxRh, 0, jLziA5R7);
			} while (jLziA5R7 > 0);
			TMt9hT0g.close();
			lRc6WiVP.close();
		} catch (Exception Ej8Zyaia) {
			Ej8Zyaia.printStackTrace();
		}
	}

}