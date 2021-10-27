class n11163692 {
	public static void transfer(File QoTqi0Zp, File Cgju5cJw, boolean N47faM0A)
			throws FileNotFoundException, IOException {
		Log.warning("source: " + QoTqi0Zp);
		Log.warning("dest: " + Cgju5cJw);
		if (!QoTqi0Zp.canRead()) {
			throw new IOException("can not read src file: " + QoTqi0Zp);
		}
		if (!Cgju5cJw.getParentFile().isDirectory()) {
			if (!Cgju5cJw.getParentFile().mkdirs()) {
				throw new IOException("failed to make directories: " + Cgju5cJw.getParent());
			}
		}
		FileInputStream bbSgJwsk = new FileInputStream(QoTqi0Zp);
		FileOutputStream e4cEPcqY = new FileOutputStream(Cgju5cJw);
		FileChannel aWTBvllq = bbSgJwsk.getChannel();
		FileChannel u7N9WwL4 = e4cEPcqY.getChannel();
		Log.warning("starting transfer from position " + aWTBvllq.position() + " to size " + aWTBvllq.size());
		u7N9WwL4.transferFrom(aWTBvllq, 0, aWTBvllq.size());
		Log.warning("closing streams and channels");
		aWTBvllq.close();
		u7N9WwL4.close();
		bbSgJwsk.close();
		e4cEPcqY.close();
		if (N47faM0A) {
			Log.warning("deleting file " + QoTqi0Zp);
			QoTqi0Zp.delete();
		}
	}

}