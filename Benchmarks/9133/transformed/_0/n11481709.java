class n11481709 {
	public boolean copy(File MSdDJluS) throws IOException {
		FileUtility avLL0mUZ = this;
		if (!MSdDJluS.exists()) {
			abort("FileUtility: no such source file: " + MSdDJluS.getAbsolutePath());
			return false;
		}
		if (!MSdDJluS.isFile()) {
			abort("FileUtility: can't copy directory: " + MSdDJluS.getAbsolutePath());
			return false;
		}
		if (!MSdDJluS.canRead()) {
			abort("FileUtility: source file is unreadable: " + MSdDJluS.getAbsolutePath());
			return false;
		}
		if (this.isDirectory())
			avLL0mUZ = (FileUtility) (new File(this, MSdDJluS.getName()));
		if (avLL0mUZ.exists()) {
			if (!avLL0mUZ.canWrite()) {
				abort("FileUtility: destination file is unwriteable: " + pathName);
				return false;
			}
		} else {
			String hSRzEyL2 = avLL0mUZ.getParent();
			File Sc1Savu0 = new File(hSRzEyL2);
			if (!Sc1Savu0.exists()) {
				abort("FileUtility: destination directory doesn't exist: " + hSRzEyL2);
				return false;
			}
			if (Sc1Savu0.isFile()) {
				abort("FileUtility: destination is not a directory: " + hSRzEyL2);
				return false;
			}
			if (!Sc1Savu0.canWrite()) {
				abort("FileUtility: destination directory is unwriteable: " + hSRzEyL2);
				return false;
			}
		}
		FileInputStream IH91brYu = null;
		FileOutputStream xRO3MeHW = null;
		try {
			IH91brYu = new FileInputStream(MSdDJluS);
			xRO3MeHW = new FileOutputStream(avLL0mUZ);
			byte[] lHDOlPbi = new byte[4096];
			int xGK5KY5z;
			while ((xGK5KY5z = IH91brYu.read(lHDOlPbi)) != -1)
				xRO3MeHW.write(lHDOlPbi, 0, xGK5KY5z);
		} finally {
			if (IH91brYu != null)
				try {
					IH91brYu.close();
				} catch (IOException lP6njj0Y) {
					;
				}
			if (xRO3MeHW != null)
				try {
					xRO3MeHW.close();
				} catch (IOException Q57BaxVY) {
					;
				}
		}
		return true;
	}

}