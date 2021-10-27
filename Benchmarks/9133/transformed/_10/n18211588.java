class n18211588 {
	public static boolean copyTextFile(File src, File dst) {
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dst));
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
			int readsize = 0;
			byte[] buf = new byte[1024];
			while ((readsize = bis.read(buf)) != -1) {
				bos.write(buf, 0, readsize);
			}
			bos.flush();
			bos.close();
			bis.close();
		} catch (IOException e) {
			ServerConsoleServlet.printSystemLog(e.toString() + " " + e.getMessage(), ServerConsoleServlet.LOG_ERROR);
			return false;
		}
		return true;
	}

}