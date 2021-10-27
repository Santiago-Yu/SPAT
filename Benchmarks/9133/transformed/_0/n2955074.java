class n2955074 {
	public static void copyFile(File QKaAJwum, File cfoGRd1u) throws IOException {
		if (QKaAJwum == null) {
			String beA7uvTM = Logging.getMessage("nullValue.SourceIsNull");
			Logging.logger().severe(beA7uvTM);
			throw new IllegalArgumentException(beA7uvTM);
		}
		if (cfoGRd1u == null) {
			String REDVAHCn = Logging.getMessage("nullValue.DestinationIsNull");
			Logging.logger().severe(REDVAHCn);
			throw new IllegalArgumentException(REDVAHCn);
		}
		FileInputStream xH5dPTIl = null;
		FileOutputStream RInJlhyO = null;
		FileChannel eib3QJH9, urmzYqeK;
		try {
			xH5dPTIl = new FileInputStream(QKaAJwum);
			eib3QJH9 = xH5dPTIl.getChannel();
			RInJlhyO = new FileOutputStream(cfoGRd1u);
			urmzYqeK = RInJlhyO.getChannel();
			urmzYqeK.transferFrom(eib3QJH9, 0, eib3QJH9.size());
			RInJlhyO.flush();
			xH5dPTIl.close();
			RInJlhyO.close();
		} finally {
			WWIO.closeStream(xH5dPTIl, QKaAJwum.getPath());
			WWIO.closeStream(RInJlhyO, cfoGRd1u.getPath());
		}
	}

}