class n4697213 {
	protected void downloadJar(URL yuLaLCpi, File Swz3b1dP, IProgressListener i8midZGT) {
		BufferedOutputStream qdMOE6lz = null;
		InputStream zXykLvHO = null;
		URLConnection ZiK0Iy1B = null;
		try {
			ZiK0Iy1B = yuLaLCpi.openConnection();
			qdMOE6lz = new BufferedOutputStream(new FileOutputStream(Swz3b1dP));
			zXykLvHO = ZiK0Iy1B.getInputStream();
			int aXRMREoN = zXykLvHO.available();
			Log.log("downloading jar with size: " + ZiK0Iy1B.getContentLength());
			if (aXRMREoN < 1)
				aXRMREoN = 1024;
			byte[] CJfa53hI = new byte[aXRMREoN];
			while ((aXRMREoN = zXykLvHO.read(CJfa53hI)) > 0) {
				qdMOE6lz.write(CJfa53hI, 0, aXRMREoN);
			}
			qdMOE6lz.close();
			zXykLvHO.close();
		} catch (Exception WLgUP4OQ) {
		} finally {
			if (qdMOE6lz != null) {
				try {
					qdMOE6lz.close();
				} catch (IOException NA38dDNn) {
				}
			}
			if (zXykLvHO != null) {
				try {
					zXykLvHO.close();
				} catch (IOException w70mI8ZG) {
				}
			}
		}
	}

}