class n18880060 {
	public static boolean copy(File source, File target) {
		try {
			if (!source.exists())
				return false;
			target.getParentFile().mkdirs();
			OutputStream output = new FileOutputStream(target);
			InputStream input = new FileInputStream(source);
			int len;
			byte[] buf = new byte[1024];
			while ((len = input.read(buf)) > 0)
				output.write(buf, 0, len);
			input.close();
			output.close();
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}

}