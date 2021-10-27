class n11572565 {
	public static final boolean copy(File USl15qts, File XcNqjmGT, boolean gunSnpnK) {
		if (!gunSnpnK && XcNqjmGT.exists()) {
			LOGGER.error("Target file exist and it not permitted to overwrite it !");
			return false;
		}
		FileChannel EsZRxdas = null;
		FileChannel QOdiHUTC = null;
		try {
			EsZRxdas = new FileInputStream(USl15qts).getChannel();
			QOdiHUTC = new FileOutputStream(XcNqjmGT).getChannel();
			EsZRxdas.transferTo(0, EsZRxdas.size(), QOdiHUTC);
		} catch (FileNotFoundException VVdxONo0) {
			LOGGER.error(VVdxONo0.getLocalizedMessage());
			if (LOGGER.isDebugEnabled())
				VVdxONo0.printStackTrace();
			return false;
		} catch (IOException vfSSp4rt) {
			LOGGER.error(vfSSp4rt.getLocalizedMessage());
			if (LOGGER.isDebugEnabled())
				vfSSp4rt.printStackTrace();
			return false;
		} finally {
			try {
				EsZRxdas.close();
			} catch (Exception jiciNzks) {
			}
			try {
				QOdiHUTC.close();
			} catch (Exception XXkqnWve) {
			}
		}
		return true;
	}

}