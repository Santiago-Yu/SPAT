class n22608285 {
	private void dealWith(String line) throws Exception {
		String sarr[];
		if (line.startsWith("#") || (line.length() == 0)) {
			return;
		}
		sarr = StringUtil.split(line, '\t');
		boolean copyFile = true;
		String path = destDir + File.separator + sarr[0];
		if (sarr.length == 2) {
			try {
				String serverHash = sarr[1];
				String fileHash = loadFileHash(destDir + File.separator + sarr[0]);
				if (fileHash != null) {
					if (serverHash.equalsIgnoreCase(fileHash)) {
						copyFile = false;
					} else {
						if (verbose) {
							System.out.println(" -- " + sarr[0] + " has changed");
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println(ex.getMessage());
				System.exit(2);
			}
		}
		if (copyFile) {
			int idx = path.lastIndexOf('/');
			if (idx > 0) {
				String dir = path.substring(0, idx);
				File f = new File(dir);
				f.mkdirs();
			}
			byte buf[] = new byte[1024];
			FileOutputStream os = new FileOutputStream(path);
			URLConnection urc = new URL(urlStr + "/" + sarr[0]).openConnection();
			boolean done = false;
			InputStream is = urc.getInputStream();
			while (!done) {
				int read = is.read(buf, 0, 1024);
				if (read == -1) {
					done = true;
				} else {
					os.write(buf, 0, read);
				}
			}
			os.close();
			is.close();
			if (verbose) {
				System.out.println(" -- Copied: " + sarr[0]);
			}
		}
	}

}