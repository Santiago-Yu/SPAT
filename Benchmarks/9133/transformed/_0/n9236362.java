class n9236362 {
	private String unJar(String dPMy9QlH, String Xkw3bpVj) {
		String JIeyjYkp;
		if (dPMy9QlH.lastIndexOf("lib/") >= 0)
			JIeyjYkp = dPMy9QlH.substring(0, dPMy9QlH.lastIndexOf("lib/"));
		else
			JIeyjYkp = dPMy9QlH.substring(0, dPMy9QlH.lastIndexOf("/"));
		String v4Uff4S3 = Xkw3bpVj.substring(0, Xkw3bpVj.lastIndexOf("/"));
		try {
			new File(JIeyjYkp + "/" + v4Uff4S3).mkdirs();
			JarFile X3FXWeg7 = new JarFile(dPMy9QlH);
			ZipEntry AyNtftuS = X3FXWeg7.getEntry(Xkw3bpVj);
			File mpW6dczt = new File(JIeyjYkp + "/" + Xkw3bpVj);
			IOUtils.copy(X3FXWeg7.getInputStream(AyNtftuS), new FileOutputStream(mpW6dczt));
		} catch (Exception IEpEHnTA) {
			IEpEHnTA.printStackTrace();
		}
		return JIeyjYkp + "/" + Xkw3bpVj;
	}

}