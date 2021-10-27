class n7682648 {
	public static void copyFile(File MkP70IEX, File xPCNtwAk) throws IOException {
		InputStream yp7iz4SE = null;
		OutputStream BQxlWIBz = null;
		try {
			yp7iz4SE = new BufferedInputStream(new FileInputStream(MkP70IEX));
			BQxlWIBz = new BufferedOutputStream(new FileOutputStream(xPCNtwAk));
			int eu41MZ8e = 1024;
			byte[] trzCzRpZ = new byte[eu41MZ8e];
			while (yp7iz4SE.read(trzCzRpZ) > 0)
				BQxlWIBz.write(trzCzRpZ);
		} finally {
			if (null != yp7iz4SE)
				yp7iz4SE.close();
			if (null != BQxlWIBz)
				BQxlWIBz.close();
		}
	}

}