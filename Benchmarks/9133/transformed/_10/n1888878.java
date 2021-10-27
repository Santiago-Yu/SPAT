class n1888878 {
	protected void copyFile(File source, File destination) throws ApplicationException {
		try {
			DataInputStream in = new DataInputStream(new FileInputStream(source));
			OutputStream out = new FileOutputStream(destination);
			byte[] buf = new byte[8192];
			for (int nread = in.read(buf); nread > 0; nread = in.read(buf)) {
				out.write(buf, 0, nread);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			throw new ApplicationException("Can't copy file " + source + " to " + destination);
		}
	}

}