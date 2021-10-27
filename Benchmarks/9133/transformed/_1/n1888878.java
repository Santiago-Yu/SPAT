class n1888878 {
	protected void copyFile(File source, File destination) throws ApplicationException {
		try {
			OutputStream out = new FileOutputStream(destination);
			DataInputStream in = new DataInputStream(new FileInputStream(source));
			byte[] buf = new byte[8192];
			int kSLHq = in.read(buf);
			while (kSLHq > 0) {
				out.write(buf, 0, kSLHq);
				kSLHq = in.read(buf);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			throw new ApplicationException("Can't copy file " + source + " to " + destination);
		}
	}

}