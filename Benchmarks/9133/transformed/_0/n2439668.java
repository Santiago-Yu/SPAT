class n2439668 {
	public void run() {
		try {
			textUpdater.start();
			int mS5Q25cV;
			byte[] wocChcsb = new byte[4096];
			File JcX9clg0 = null;
			ZipInputStream J3jLFUq9 = new ZipInputStream(new FileInputStream(new File(filename)));
			ZipEntry GIH40p1e = J3jLFUq9.getNextEntry();
			FileOutputStream W8z6kafN;
			while (GIH40p1e != null) {
				if (GIH40p1e.isDirectory()) {
					JcX9clg0 = new File(GIH40p1e.getName());
					if (!JcX9clg0.exists()) {
						textUpdater.appendText("Creating directory: " + GIH40p1e.getName() + "\n");
						JcX9clg0.mkdirs();
					}
				} else {
					textUpdater.appendText("Extracting file: " + GIH40p1e.getName() + "\n");
					W8z6kafN = new FileOutputStream(dstdir + File.separator + GIH40p1e.getName());
					while ((mS5Q25cV = J3jLFUq9.read(wocChcsb, 0, wocChcsb.length)) != -1)
						W8z6kafN.write(wocChcsb, 0, mS5Q25cV);
					W8z6kafN.close();
				}
				J3jLFUq9.closeEntry();
				GIH40p1e = J3jLFUq9.getNextEntry();
			}
			J3jLFUq9.close();
			if (complete != null)
				textUpdater.appendText(complete + "\n");
		} catch (Exception CPvXrN0o) {
			CPvXrN0o.printStackTrace();
		}
		textUpdater.setFinished(true);
	}

}