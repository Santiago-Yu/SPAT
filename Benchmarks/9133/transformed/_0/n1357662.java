class n1357662 {
	private void copyFileTo(File b1aeLzZX) throws IOException {
		logger.fine("Copying from " + b1aeLzZX + "...");
		FileChannel Sio0GLjo = new FileInputStream(getAbsolutePath()).getChannel();
		logger.fine("...got source channel " + Sio0GLjo + "...");
		FileChannel ELEwl3tE = new FileOutputStream(new File(b1aeLzZX.getAbsolutePath())).getChannel();
		logger.fine("...got destination channel " + ELEwl3tE + "...");
		logger.fine("...Got channels...");
		ELEwl3tE.transferFrom(Sio0GLjo, 0, Sio0GLjo.size());
		logger.fine("...transferred.");
		Sio0GLjo.close();
		ELEwl3tE.close();
	}

}