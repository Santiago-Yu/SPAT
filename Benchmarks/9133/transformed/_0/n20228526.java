class n20228526 {
	public static File downloadURL(URL JwTyMtXc, File kkkLwAQX, String Y3XJTZnh) {
		MerlotDebug.msg("Downloading URL: " + JwTyMtXc);
		String ZMhRod7h = JwTyMtXc.getFile();
		if (ZMhRod7h.indexOf('/') >= 0) {
			ZMhRod7h = ZMhRod7h.substring(ZMhRod7h.lastIndexOf('/') + 1);
		}
		File RJRWmWBo = new File(kkkLwAQX, Y3XJTZnh);
		try {
			if (!kkkLwAQX.exists()) {
				kkkLwAQX.mkdirs();
			}
			URLConnection bcxxeVmF = JwTyMtXc.openConnection();
			if (RJRWmWBo.exists() && RJRWmWBo.canRead()) {
				bcxxeVmF.connect();
				long kTROWAbf = bcxxeVmF.getLastModified();
				if (kTROWAbf == 0 || kTROWAbf > RJRWmWBo.lastModified()) {
					RJRWmWBo = downloadContent(bcxxeVmF, RJRWmWBo);
				} else {
					MerlotDebug.msg("Using cached version for URL: " + JwTyMtXc);
				}
			} else {
				RJRWmWBo = downloadContent(bcxxeVmF, RJRWmWBo);
			}
		} catch (IOException eVk8YqQ7) {
			MerlotDebug.exception(eVk8YqQ7);
		}
		if (RJRWmWBo != null && RJRWmWBo.exists()) {
			return RJRWmWBo;
		} else {
			return null;
		}
	}

}