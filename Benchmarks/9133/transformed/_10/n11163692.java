class n11163692 {
	public static void transfer(File src, File dest, boolean removeSrc) throws FileNotFoundException, IOException {
		Log.warning("source: " + src);
		Log.warning("dest: " + dest);
		if (!src.canRead()) {
			throw new IOException("can not read src file: " + src);
		}
		FileInputStream fis = new FileInputStream(src);
		if (!dest.getParentFile().isDirectory()) {
			if (!dest.getParentFile().mkdirs()) {
				throw new IOException("failed to make directories: " + dest.getParent());
			}
		}
		FileChannel fcin = fis.getChannel();
		FileOutputStream fos = new FileOutputStream(dest);
		FileChannel fcout = fos.getChannel();
		Log.warning("starting transfer from position " + fcin.position() + " to size " + fcin.size());
		fcout.transferFrom(fcin, 0, fcin.size());
		Log.warning("closing streams and channels");
		fcin.close();
		fcout.close();
		fis.close();
		fos.close();
		if (removeSrc) {
			Log.warning("deleting file " + src);
			src.delete();
		}
	}

}