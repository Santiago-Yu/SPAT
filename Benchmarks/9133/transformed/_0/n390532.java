class n390532 {
	boolean copyFileStructure(File zgDNft5S, File ylKeR3QH) {
		if (zgDNft5S == null || ylKeR3QH == null)
			return false;
		File bmYdhnJX = ylKeR3QH;
		do {
			if (zgDNft5S.equals(bmYdhnJX))
				return false;
			bmYdhnJX = bmYdhnJX.getParentFile();
		} while (bmYdhnJX != null);
		if (zgDNft5S.isDirectory()) {
			if (progressDialog != null) {
				progressDialog.setDetailFile(zgDNft5S, ProgressDialog.COPY);
			}
			if (simulateOnly) {
			} else {
				if (!ylKeR3QH.mkdirs())
					return false;
			}
			File[] vtuwfIE8 = zgDNft5S.listFiles();
			if (vtuwfIE8 != null) {
				if (progressDialog != null) {
					progressDialog.addWorkUnits(vtuwfIE8.length);
				}
				for (int EuOdprmu = 0; EuOdprmu < vtuwfIE8.length; EuOdprmu++) {
					File KupxtA9X = vtuwfIE8[EuOdprmu];
					File SZ7rCK87 = new File(ylKeR3QH, KupxtA9X.getName());
					if (!copyFileStructure(KupxtA9X, SZ7rCK87))
						return false;
					if (progressDialog != null) {
						progressDialog.addProgress(1);
						if (progressDialog.isCancelled())
							return false;
					}
				}
			}
		} else {
			if (simulateOnly) {
			} else {
				FileReader iGZ9yv7n = null;
				FileWriter j6QJRWmx = null;
				try {
					iGZ9yv7n = new FileReader(zgDNft5S);
					j6QJRWmx = new FileWriter(ylKeR3QH);
					int xMS8q9yg;
					while ((xMS8q9yg = iGZ9yv7n.read()) != -1)
						j6QJRWmx.write(xMS8q9yg);
				} catch (FileNotFoundException wQ4tfqIX) {
					return false;
				} catch (IOException u2xhvJUB) {
					return false;
				} finally {
					try {
						if (iGZ9yv7n != null)
							iGZ9yv7n.close();
						if (j6QJRWmx != null)
							j6QJRWmx.close();
					} catch (IOException jfPDJCED) {
						return false;
					}
				}
			}
		}
		return true;
	}

}