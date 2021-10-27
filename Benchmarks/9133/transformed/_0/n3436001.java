class n3436001 {
	public static void copyFile(File cvYDOMV4, File zvNJPons) {
		if (!cvYDOMV4.exists() || !cvYDOMV4.canRead()) {
			LOGGER.warn("Can't copy file : " + cvYDOMV4);
			return;
		}
		if (!zvNJPons.getParentFile().exists()) {
			if (!zvNJPons.getParentFile().mkdirs()) {
				LOGGER.info("Didn't create parent directories : " + zvNJPons.getParentFile().getAbsolutePath());
			}
		}
		if (!zvNJPons.exists()) {
			try {
				zvNJPons.createNewFile();
			} catch (IOException P0vFNME8) {
				LOGGER.error("Exception creating new file : " + zvNJPons.getAbsolutePath(), P0vFNME8);
			}
		}
		LOGGER.debug("Copying file : " + cvYDOMV4 + ", to : " + zvNJPons);
		FileChannel OvBy92fW = null;
		FileChannel ArLZP7Ta = null;
		FileInputStream b3sFedfU = null;
		FileOutputStream bzwPHYHO = null;
		try {
			b3sFedfU = new FileInputStream(cvYDOMV4);
			OvBy92fW = b3sFedfU.getChannel();
			bzwPHYHO = new FileOutputStream(zvNJPons);
			ArLZP7Ta = bzwPHYHO.getChannel();
			OvBy92fW.transferTo(0, OvBy92fW.size(), ArLZP7Ta);
		} catch (Exception IhHn5DLr) {
			LOGGER.error("Exception copying file : " + cvYDOMV4 + ", to : " + zvNJPons, IhHn5DLr);
		} finally {
			close(b3sFedfU);
			close(bzwPHYHO);
			if (OvBy92fW != null) {
				try {
					OvBy92fW.close();
				} catch (Exception pXxHd4Py) {
					LOGGER.error("Exception closing input channel : ", pXxHd4Py);
				}
			}
			if (ArLZP7Ta != null) {
				try {
					ArLZP7Ta.close();
				} catch (Exception vw84mP9M) {
					LOGGER.error("Exception closing output channel : ", vw84mP9M);
				}
			}
		}
	}

}