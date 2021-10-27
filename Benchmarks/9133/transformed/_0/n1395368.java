class n1395368 {
	private File copyFile(File WpGCqBSj) throws IOException {
		String q7xA1Fw4 = WpGCqBSj.getPath().substring(_distDir.length() + 1);
		File CIb2BOAL = new File(_installDir, q7xA1Fw4);
		if (CIb2BOAL.exists()) {
			log(CIb2BOAL.getPath() + " already exists, skipping libcopy", Project.MSG_INFO);
			return CIb2BOAL;
		} else {
			if (!CIb2BOAL.getParentFile().exists()) {
				if (!CIb2BOAL.getParentFile().mkdirs()) {
					log("Unable to create target dir tree for " + CIb2BOAL.getPath(), Project.MSG_ERR);
					throw new IOException();
				}
			}
		}
		FileInputStream kh7pa2mO = null;
		FileOutputStream rUK8R1Zx = null;
		try {
			kh7pa2mO = new FileInputStream(WpGCqBSj);
		} catch (FileNotFoundException UYyf55iQ) {
			log("Library from plugin manifest appears to have been deleted: " + WpGCqBSj.getPath(), Project.MSG_ERR);
			throw new IOException();
		}
		try {
			rUK8R1Zx = new FileOutputStream(CIb2BOAL);
		} catch (FileNotFoundException racS5MEa) {
			log("Unable to create target file to write to: " + CIb2BOAL.getPath(), Project.MSG_ERR);
			throw new IOException();
		}
		BufferedInputStream SEqgru6v = new BufferedInputStream(kh7pa2mO);
		BufferedOutputStream EUrBo5H5 = new BufferedOutputStream(rUK8R1Zx);
		int lx02MPvm = 0;
		byte[] kXuVJhpa = new byte[65536];
		boolean LSQOmMOm = true;
		while (lx02MPvm != -1 && LSQOmMOm) {
			try {
				lx02MPvm = SEqgru6v.read(kXuVJhpa, 0, 65536);
			} catch (IOException GIUEHVe3) {
				log("Read error whilst reading from: " + WpGCqBSj.getPath(), Project.MSG_ERR);
				LSQOmMOm = false;
			}
			if (lx02MPvm != -1 && LSQOmMOm) {
				try {
					EUrBo5H5.write(kXuVJhpa, 0, lx02MPvm);
				} catch (IOException AanClCNP) {
					log("Write error whilst writing to: " + CIb2BOAL.getPath(), Project.MSG_ERR);
					LSQOmMOm = false;
				}
			}
		}
		try {
			SEqgru6v.close();
		} catch (IOException trOxlpgI) {
		}
		try {
			EUrBo5H5.close();
		} catch (IOException OcUn0aBb) {
		}
		try {
			kh7pa2mO.close();
		} catch (IOException TXF5RNpk) {
		}
		try {
			rUK8R1Zx.close();
		} catch (IOException n2AZ3qgY) {
		}
		if (!LSQOmMOm) {
			throw new IOException();
		}
		return CIb2BOAL;
	}

}