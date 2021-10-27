class n4612220 {
	private void copy(File source, File destination) throws PackageException {
		try {
			FileOutputStream out = new FileOutputStream(destination);
			FileInputStream in = new FileInputStream(source);
			int len;
			byte[] buff = new byte[1024];
			while ((len = in.read(buff)) > 0)
				out.write(buff, 0, len);
			in.close();
			out.close();
		} catch (IOException e) {
			throw new PackageException(
					"Unable to copy " + source.getPath() + " to " + destination.getPath() + " :: " + e.toString());
		}
	}

}