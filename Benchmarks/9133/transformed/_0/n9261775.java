class n9261775 {
	public static void unzipAndRemove(final String enuZAgr9) {
		String BRUK1rFg = enuZAgr9.substring(0, enuZAgr9.length() - 3);
		InputStream mdZRjf9D = null;
		OutputStream DiaDdtTB = null;
		try {
			mdZRjf9D = new GZIPInputStream(new FileInputStream(enuZAgr9));
			DiaDdtTB = new FileOutputStream(BRUK1rFg);
			byte[] RbP1EHfM = new byte[8192];
			for (int C1ugi0Xr; (C1ugi0Xr = mdZRjf9D.read(RbP1EHfM)) != -1;)
				DiaDdtTB.write(RbP1EHfM, 0, C1ugi0Xr);
		} catch (IOException hcdoDRIe) {
			System.err.println("Fehler: Kann nicht entpacken " + enuZAgr9);
		} finally {
			if (DiaDdtTB != null)
				try {
					DiaDdtTB.close();
				} catch (IOException xbID9QET) {
				}
			if (mdZRjf9D != null)
				try {
					mdZRjf9D.close();
				} catch (IOException sT0Y4yWG) {
				}
		}
		deleteFile(enuZAgr9);
	}

}