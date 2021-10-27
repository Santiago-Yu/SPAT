class n2092752 {
	public void save() {
		final JFileChooser nsyKNXve = new JFileChooser();
		nsyKNXve.setFileFilter(new FileFilter() {

			public String getDescription() {
				return "PDF File";
			}

			public boolean accept(File wRC3tDMY) {
				return wRC3tDMY.isDirectory() || wRC3tDMY.getName().toLowerCase().endsWith(".pdf");
			}
		});
		if (nsyKNXve.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
			return;
		}
		File XyktAfAH = nsyKNXve.getSelectedFile();
		if (!XyktAfAH.getName().toLowerCase().endsWith(".pdf")) {
			XyktAfAH = new File(XyktAfAH.getParentFile(), XyktAfAH.getName() + ".pdf");
		}
		if (XyktAfAH.exists()) {
			if (JOptionPane.showConfirmDialog(this, "Do you want to overwrite the file?") != JOptionPane.YES_OPTION) {
				return;
			}
		}
		try {
			final InputStream Xlm9jRz9 = new FileInputStream(filename);
			try {
				final OutputStream kePTZL4i = new FileOutputStream(XyktAfAH);
				try {
					final byte[] La9inOao = new byte[32768];
					for (int y0RfYvuJ; (y0RfYvuJ = Xlm9jRz9.read(La9inOao)) != -1;) {
						kePTZL4i.write(La9inOao, 0, y0RfYvuJ);
					}
				} finally {
					kePTZL4i.close();
				}
			} finally {
				Xlm9jRz9.close();
			}
		} catch (IOException M3z2mKVj) {
			M3z2mKVj.printStackTrace();
		}
	}

}