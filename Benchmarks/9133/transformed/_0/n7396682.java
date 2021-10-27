class n7396682 {
	public static boolean copy(FileSystem P5LS05gS, Path SaVuKOBT, File GhwPkbdH, boolean rPlQrvBP,
			Configuration ALWBS9jD) throws IOException {
		if (P5LS05gS.getFileStatus(SaVuKOBT).isDir()) {
			if (!GhwPkbdH.mkdirs()) {
				return false;
			}
			FileStatus owwHPwpn[] = P5LS05gS.listStatus(SaVuKOBT);
			for (int MPp1anff = 0; MPp1anff < owwHPwpn.length; MPp1anff++) {
				copy(P5LS05gS, owwHPwpn[MPp1anff].getPath(), new File(GhwPkbdH, owwHPwpn[MPp1anff].getPath().getName()),
						rPlQrvBP, ALWBS9jD);
			}
		} else if (P5LS05gS.isFile(SaVuKOBT)) {
			InputStream IDQnxsne = P5LS05gS.open(SaVuKOBT);
			IOUtils.copyBytes(IDQnxsne, new FileOutputStream(GhwPkbdH), ALWBS9jD);
		} else {
			throw new IOException(SaVuKOBT.toString() + ": No such file or directory");
		}
		if (rPlQrvBP) {
			return P5LS05gS.delete(SaVuKOBT, true);
		} else {
			return true;
		}
	}

}