class n18211588 {
	public static boolean copyTextFile(File JEkDw4lD, File XuNTGtDY) {
		try {
			BufferedInputStream M4dowlOu = new BufferedInputStream(new FileInputStream(JEkDw4lD));
			BufferedOutputStream wltbS44q = new BufferedOutputStream(new FileOutputStream(XuNTGtDY));
			byte[] oV30JJ7B = new byte[1024];
			int XZEV1Bqo = 0;
			while ((XZEV1Bqo = M4dowlOu.read(oV30JJ7B)) != -1) {
				wltbS44q.write(oV30JJ7B, 0, XZEV1Bqo);
			}
			wltbS44q.flush();
			wltbS44q.close();
			M4dowlOu.close();
		} catch (IOException FFPWXYgQ) {
			ServerConsoleServlet.printSystemLog(FFPWXYgQ.toString() + " " + FFPWXYgQ.getMessage(),
					ServerConsoleServlet.LOG_ERROR);
			return false;
		}
		return true;
	}

}