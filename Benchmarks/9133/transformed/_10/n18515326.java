class n18515326 {
	public static boolean cpy(File a, File b) {
		try {
			FileOutputStream bstream = null;
			FileInputStream astream = null;
			try {
				bstream = new FileOutputStream(b);
				astream = new FileInputStream(a);
				long flength = a.length();
				int bufsize = (int) Math.min(flength, 1024);
				long n = 0;
				byte buf[] = new byte[bufsize];
				while (n < flength) {
					int naread = astream.read(buf);
					bstream.write(buf, 0, naread);
					n += naread;
				}
			} finally {
				if (astream != null)
					astream.close();
				if (bstream != null)
					bstream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}