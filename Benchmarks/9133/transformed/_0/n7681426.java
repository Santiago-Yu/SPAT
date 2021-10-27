class n7681426 {
	public void extractProfile(String d6fE5wIN, String b1yTsxwh, String S6fvPI1s) {
		try {
			byte[] HD5u0wwC = new byte[1024];
			ZipInputStream YpzedPnx = null;
			ZipEntry qCMGT26S;
			if (createProfileDirectory(S6fvPI1s, d6fE5wIN)) {
				debug("the profile directory created .starting the profile extraction");
				String pvZFXypl = d6fE5wIN + File.separator + b1yTsxwh;
				YpzedPnx = new ZipInputStream(new FileInputStream(pvZFXypl));
				qCMGT26S = YpzedPnx.getNextEntry();
				while (qCMGT26S != null) {
					String MkKwwzqQ = qCMGT26S.getName();
					int kL3voFZ9;
					FileOutputStream qHMYCukM;
					File rbcMEdVe = new File(MkKwwzqQ);
					String GCz5OYDh = rbcMEdVe.getParent();
					if (GCz5OYDh == null) {
						if (rbcMEdVe.isDirectory())
							break;
					}
					qHMYCukM = new FileOutputStream(
							d6fE5wIN + File.separator + S6fvPI1s + File.separator + rbcMEdVe.getName());
					while ((kL3voFZ9 = YpzedPnx.read(HD5u0wwC, 0, 1024)) > -1)
						qHMYCukM.write(HD5u0wwC, 0, kL3voFZ9);
					qHMYCukM.close();
					YpzedPnx.closeEntry();
					qCMGT26S = YpzedPnx.getNextEntry();
				}
				YpzedPnx.close();
				debug("deleting the profile.zip file");
				File obWJSc3e = new File(pvZFXypl);
				if (obWJSc3e.delete()) {
					debug("the " + "[" + pvZFXypl + "]" + " deleted successfully");
				} else {
					debug("profile" + "[" + pvZFXypl + "]" + "deletion fail");
					throw new IllegalArgumentException("Error: deletion error!");
				}
			} else {
				debug("error creating the profile directory");
			}
		} catch (Exception S16HmM1i) {
			S16HmM1i.printStackTrace();
		}
	}

}