class n2612645 {
	public void populateDefaultIcons() {
		DomainNameTree newmap = new DomainNameTree();
		DomainNameTree defaultmap = this.getDefaultIconMap();
		File iconDir = new File(this.usrIconDir);
		if (!(iconDir.exists() && iconDir.isDirectory())) {
			int s = JOptionPane.showConfirmDialog(null, "Create icon directory " + this.usrIconDir + "?",
					"Icon directory does not exist!", JOptionPane.YES_NO_CANCEL_OPTION);
			if (s == JOptionPane.YES_OPTION) {
				iconDir.mkdir();
			} else {
				return;
			}
		}
		Set domains = defaultmap.domainSet();
		Iterator iter = domains.iterator();
		while (iter.hasNext()) {
			String dname = (String) iter.next();
			String fname = defaultmap.getImageFile(dname);
			if (fname != null) {
				System.out.println("Attempting to populate with:" + fname);
				if (!fname.equals("null")) {
					File file = new File(fname);
					String newname = this.usrIconDir.concat(File.separator).concat(file.getName());
					URL url = this.getClass().getResource(fname);
					File newfile = new File(newname);
					if (url != null) {
						FileOutputStream to = null;
						InputStream from = null;
						try {
							from = url.openStream();
							byte[] buffer = new byte[4096];
							int bytes_read = 0;
							to = new FileOutputStream(newfile);
							while ((bytes_read = from.read(buffer)) != -1) {
								to.write(buffer, 0, bytes_read);
							}
							newmap.insert(new DomainNameNode(dname, newname));
						} catch (Exception err) {
							throw new RuntimeException("Problem saving image to file.", err);
						} finally {
							if (from != null) {
								try {
									from.close();
								} catch (IOException err) {
									throw new RuntimeException("Problem closing URL input stream.");
								}
							}
							if (to != null) {
								try {
									to.close();
								} catch (IOException err) {
									throw new RuntimeException("Problem closing file output stream.");
								}
							}
						}
					} else {
						throw new RuntimeException("Trying to copy the default icon " + fname + " from "
								+ this.getClass().getPackage() + " but it does not exist.");
					}
				}
			}
		}
		int s = JOptionPane.showConfirmDialog(null, "Save default mappings in " + this.usrConfigFile + "?",
				"Icon directory populated...", JOptionPane.YES_NO_CANCEL_OPTION);
		if (s == JOptionPane.YES_OPTION) {
			saveToRegistry(newmap);
		}
	}

}