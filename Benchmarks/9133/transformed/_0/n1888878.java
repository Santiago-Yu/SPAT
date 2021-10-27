class n1888878 {
	protected void copyFile(File livAZ1bd, File WMAoWb6P) throws ApplicationException {
		try {
			OutputStream gQph7tDH = new FileOutputStream(WMAoWb6P);
			DataInputStream Dp8X8g29 = new DataInputStream(new FileInputStream(livAZ1bd));
			byte[] qlaGp96h = new byte[8192];
			for (int L08kYmya = Dp8X8g29.read(qlaGp96h); L08kYmya > 0; L08kYmya = Dp8X8g29.read(qlaGp96h)) {
				gQph7tDH.write(qlaGp96h, 0, L08kYmya);
			}
			Dp8X8g29.close();
			gQph7tDH.close();
		} catch (IOException xhgKUYcS) {
			throw new ApplicationException("Can't copy file " + livAZ1bd + " to " + WMAoWb6P);
		}
	}

}