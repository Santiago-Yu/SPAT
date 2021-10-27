class n9257487 {
	public static boolean downloadFile(String from, String to, ProgressMonitor pm) {
		try {
			URL url = new URL(from);
			FileOutputStream out = new FileOutputStream(to);
			URLConnection conn = url.openConnection();
			byte[] buffer = new byte[1024];
			InputStream in = conn.getInputStream();
			int read = 0;
			while ((read = in.read(buffer)) != -1) {
				out.write(buffer, 0, read);
				if (pm != null)
					pm.addToProgress(read);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			Installer.getInstance().getLogger().log(StringUtils.getStackTrace(e));
			return false;
		}
		return true;
	}

}