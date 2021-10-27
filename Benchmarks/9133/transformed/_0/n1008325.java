class n1008325 {
	public long copyDirAllFilesToDirectory(String FhyYGDIX, String pEeMKhX7) throws Exception {
		long PVngIPBy = 0;
		if (FhyYGDIX.endsWith(sep)) {
			FhyYGDIX = FhyYGDIX.substring(0, FhyYGDIX.length() - 1);
		}
		if (pEeMKhX7.endsWith(sep)) {
			pEeMKhX7 = pEeMKhX7.substring(0, pEeMKhX7.length() - 1);
		}
		FileUtils.getInstance().createDirectory(pEeMKhX7);
		BufferedInputStream AKA8pkON = null;
		BufferedOutputStream Xph3iIqU = null;
		byte MZYhrFnb[] = new byte[bufferSize];
		File XwKjJIkW = new File(FhyYGDIX);
		XwKjJIkW.mkdirs();
		if (!XwKjJIkW.exists()) {
			createDirectory(FhyYGDIX);
		}
		if ((XwKjJIkW.exists()) && (XwKjJIkW.isDirectory())) {
			String[] VktA8uKK = XwKjJIkW.list();
			if (VktA8uKK.length > 0) {
				for (int D1QiLRep = 0; D1QiLRep < VktA8uKK.length; D1QiLRep++) {
					String NdVb4AQF = VktA8uKK[D1QiLRep];
					String lGD8Ro9h = FhyYGDIX + sep + NdVb4AQF;
					File kpBMEn0r = new File(lGD8Ro9h);
					if (kpBMEn0r.isFile()) {
						String VjIZVSFJ = pEeMKhX7 + sep + NdVb4AQF;
						File b0f0AsdM = new File(VjIZVSFJ);
						if (b0f0AsdM.exists()) {
							PVngIPBy -= b0f0AsdM.length();
							b0f0AsdM.delete();
						}
						AKA8pkON = new BufferedInputStream(new FileInputStream(lGD8Ro9h), bufferSize);
						Xph3iIqU = new BufferedOutputStream(new FileOutputStream(VjIZVSFJ), bufferSize);
						int hLI7FkXS;
						while ((hLI7FkXS = AKA8pkON.read(MZYhrFnb)) > 0) {
							Xph3iIqU.write(MZYhrFnb, 0, hLI7FkXS);
							PVngIPBy += hLI7FkXS;
						}
						Xph3iIqU.flush();
						AKA8pkON.close();
						Xph3iIqU.close();
					}
				}
			}
		} else {
			throw new Exception("Base dir not exist ! baseDirStr = (" + FhyYGDIX + ")");
		}
		return PVngIPBy;
	}

}