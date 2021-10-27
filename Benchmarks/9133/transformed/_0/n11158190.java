class n11158190 {
	public static void copyFile(String UARcUnx0, String ZRJTOW25) {
		try {
			File dQa3UOWP = new File(UARcUnx0);
			String cr5vUi5O = (new File(ZRJTOW25)).getParent();
			File nAOQJv39 = new File(cr5vUi5O);
			if (!nAOQJv39.exists()) {
				nAOQJv39.mkdir();
			}
			File VRwRnkmV = new File(ZRJTOW25);
			if (!dQa3UOWP.getCanonicalPath().equals(VRwRnkmV.getCanonicalPath())) {
				FileInputStream hkw8ptAT = new FileInputStream(dQa3UOWP);
				FileOutputStream E1DWvmIS = new FileOutputStream(VRwRnkmV);
				int OvkZfuBV;
				while ((OvkZfuBV = hkw8ptAT.read()) != -1)
					E1DWvmIS.write(OvkZfuBV);
				hkw8ptAT.close();
				E1DWvmIS.close();
			}
		} catch (Exception O4N2STx4) {
			O4N2STx4.printStackTrace();
			LogHandler.log(O4N2STx4.getMessage(), Level.INFO, "LOG_MSG", isLoggingEnabled());
		}
	}

}