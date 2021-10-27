class n2014383 {
	public static void copyFile(String jmsTVxQd, String yJgM4Boy, TimeSlotTracker X4zhhTgE) {
		LOG.info("copying [" + jmsTVxQd + "] to [" + yJgM4Boy + "]");
		BufferedInputStream GKXDg6la = null;
		BufferedOutputStream QAenrqU4 = null;
		try {
			File iBRwLIJR = new File(yJgM4Boy);
			if (iBRwLIJR.exists()) {
				iBRwLIJR.delete();
			}
			GKXDg6la = new BufferedInputStream(new FileInputStream(jmsTVxQd));
			QAenrqU4 = new BufferedOutputStream(new FileOutputStream(iBRwLIJR));
			int HaCEDRyW;
			while ((HaCEDRyW = GKXDg6la.read()) > 0) {
				QAenrqU4.write(HaCEDRyW);
			}
			Object[] LtyqIkX2 = { iBRwLIJR.getName() };
			String MetCUgT9 = X4zhhTgE.getString("datasource.xml.copyFile.copied", LtyqIkX2);
			LOG.fine(MetCUgT9);
		} catch (Exception tWeNx2El) {
			Object[] X0o2X0Zy = { tWeNx2El.getMessage() };
			String ZOmJZZCK = X4zhhTgE.getString("datasource.xml.copyFile.exception", X0o2X0Zy);
			X4zhhTgE.errorLog(ZOmJZZCK);
			X4zhhTgE.errorLog(tWeNx2El);
		} finally {
			try {
				if (QAenrqU4 != null) {
					QAenrqU4.close();
				}
				if (GKXDg6la != null) {
					GKXDg6la.close();
				}
			} catch (Exception B23abtjo) {
				Object[] gMG9XO9u = { B23abtjo.getMessage() };
				String FRyAE4ud = X4zhhTgE.getString("datasource.xml.copyFile.exception", gMG9XO9u);
				X4zhhTgE.errorLog(FRyAE4ud);
				X4zhhTgE.errorLog(B23abtjo);
			}
		}
	}

}