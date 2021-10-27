class n1023562 {
	public static void downloadXrefTask(String url, String file) {
		if (debug)
			System.err.println("Downloading " + url + " into " + file);
		int n, progressi, progressn;
		FileOutputStream oo = null;
		Progress progress = Progress.crNew(null, "Downloading xref task");
		InputStream ii = null;
		try {
			URLConnection con = new URL(url).openConnection();
			File of = new File(file);
			ii = con.getInputStream();
			if (!of.getParentFile().exists()) {
				of.getParentFile().mkdir();
			}
			byte buffer[] = new byte[XREF_DOWNLOAD_BUFFER_SIZE];
			oo = new FileOutputStream(of);
			progressn = con.getContentLength();
			progressi = 0;
			n = 1;
			while (n >= 0) {
				n = ii.read(buffer, 0, XREF_DOWNLOAD_BUFFER_SIZE);
				if (n > 0) {
					oo.write(buffer, 0, n);
					progressi += n;
				}
				if (!progress.setProgress(progressi * 100 / progressn)) {
					n = -2;
				}
			}
			ii.close();
			oo.close();
			fileSetExecPermission(file);
			if (n == -2) {
				of.delete();
			}
		} catch (Exception e) {
			try {
				if (oo != null) {
					oo.close();
					new File(file).delete();
				}
				if (ii != null)
					ii.close();
			} catch (Exception ee) {
			}
			progress.setVisible(false);
			JOptionPane.showMessageDialog(null,
					e.toString() + "\nWhile downloading " + url + ".\nMaybe wrong proxy configuration?",
					"Xrefactory Error", JOptionPane.ERROR_MESSAGE);
		}
		progress.setVisible(false);
	}

}