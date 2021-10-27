class n17241450 {
	public static boolean copyFile(File src, File des) {
		try {
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(des));
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
			int b;
			while ((b = in.read()) != -1)
				out.write(b);
			out.flush();
			out.close();
			in.close();
			return true;
		} catch (IOException ie) {
			m_logCat.error("Copy file + " + src + " to " + des + " failed!", ie);
			return false;
		}
	}

}