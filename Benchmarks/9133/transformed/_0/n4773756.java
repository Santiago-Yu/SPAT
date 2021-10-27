class n4773756 {
	public void zipDocsetFiles(SaxHandler zmnbZUAO, int PDGeja1B, Attributes YPD42TXT) throws BpsProcessException {
		ZipOutputStream vBAlJgAP = null;
		BufferedInputStream uFKZYxZN = null;
		String zYIL4QrH = null;
		String ZX0fvI2Q = null;
		String La56Ir90 = null;
		String VKXf34J5 = null;
		byte[] fZ2KALBw = null;
		int WtQ76nIu = 0;
		try {
			vBAlJgAP = new ZipOutputStream(new FileOutputStream(zYIL4QrH));
			vBAlJgAP.putNextEntry(new ZipEntry(ZX0fvI2Q + La56Ir90));
			uFKZYxZN = new BufferedInputStream(new FileInputStream(VKXf34J5));
			while ((WtQ76nIu = uFKZYxZN.read(fZ2KALBw, 0, 4096)) != -1)
				vBAlJgAP.write(fZ2KALBw, 0, WtQ76nIu);
			vBAlJgAP.closeEntry();
			vBAlJgAP.close();
		} catch (FileNotFoundException qBK6VILF) {
			throw (new BpsProcessException(BpsProcessException.ERR_OPEN_FILE,
					"FileNotFoundException while building zip dest file"));
		} catch (IOException hmLEhJEF) {
			throw (new BpsProcessException(BpsProcessException.ERR_OPEN_FILE,
					"IOException while building zip dest file"));
		}
	}

}