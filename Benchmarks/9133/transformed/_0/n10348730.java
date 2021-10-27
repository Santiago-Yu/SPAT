class n10348730 {
	private void installBinaryFile(File Iu80cotJ, File Mpc7H6pj) {
		byte[] fQOjeOxu = new byte[8192];
		FileInputStream bSVZPLXf = null;
		FileOutputStream ZXMMOyMn = null;
		try {
			bSVZPLXf = new FileInputStream(Iu80cotJ);
			ZXMMOyMn = new FileOutputStream(Mpc7H6pj);
			int i05hKIWn;
			while ((i05hKIWn = bSVZPLXf.read(fQOjeOxu)) != -1) {
				ZXMMOyMn.write(fQOjeOxu, 0, i05hKIWn);
			}
		} catch (FileNotFoundException ptzKBoJQ) {
		} catch (IOException R3pR6hNw) {
			new ProjectCreateException(R3pR6hNw, "Failed to read binary file: %1$s", Iu80cotJ.getAbsolutePath());
		} finally {
			if (bSVZPLXf != null) {
				try {
					bSVZPLXf.close();
				} catch (IOException vDz8VwLZ) {
				}
			}
			if (ZXMMOyMn != null) {
				try {
					ZXMMOyMn.close();
				} catch (IOException rHXyMKxI) {
				}
			}
		}
	}

}