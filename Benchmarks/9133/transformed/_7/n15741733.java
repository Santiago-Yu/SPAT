class n15741733 {
	public static void downloadURLNow(URL url, File to, SHA1Sum sha1, boolean force) throws Exception {
		{
			String sep = System.getProperty("file.separator");
			String folders = to.getPath();
			String path = "";
			for (int i = 0; i < folders.length(); i++) {
				path = path + (folders.charAt(i));
				if (path.endsWith(sep)) {
					File f = new File(path);
					if (!f.exists())
						f.mkdir();
					if (!f.isDirectory()) {
						Out.error(URLDownloader.class, path + " is not a directory!");
						return;
					}
				}
			}
		}
		Out.info(URLDownloader.class, "Downloading " + url.toExternalForm());
		URLConnection uc = url.openConnection();
		DataInputStream is = new DataInputStream(new BufferedInputStream(uc.getInputStream()));
		FileOutputStream os = new FileOutputStream(to);
		byte[] b = new byte[1024];
		int fileLength = uc.getHeaderFieldInt("Content-Length", 0) / b.length;
		Task task = null;
		if (fileLength > 0)
			task = TaskManager.createTask(url.toExternalForm(), fileLength, "kB");
		do {
			int c = is.read(b);
			if (c == -1)
				break;
			os.write(b, 0, c);
			if (task != null)
				task.advanceProgress();
		} while (true);
		if (task != null)
			task.complete();
		os.close();
		is.close();
	}

}