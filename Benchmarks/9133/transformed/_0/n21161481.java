class n21161481 {
	public static void toZip(File Hth34NrO, File[] IdIYmA6M, String JcsHnAVQ, boolean kyRAV6Mn, int ydYMPsOR)
			throws IOException, FileNotFoundException, ZipException {
		if (Hth34NrO != null && IdIYmA6M != null) {
			new File(Hth34NrO.getParent()).mkdirs();
			ZipOutputStream SjnirngU = new ZipOutputStream(
					new BufferedOutputStream(new CheckedOutputStream(new FileOutputStream(Hth34NrO), new CRC32())));
			if (ZIP_NO_COMPRESSION <= ydYMPsOR && ydYMPsOR <= ZIP_MAX_COMPRESSION)
				SjnirngU.setLevel(ydYMPsOR);
			else
				SjnirngU.setLevel(ZIP_MAX_COMPRESSION);
			if (JcsHnAVQ != null)
				SjnirngU.setComment(JcsHnAVQ);
			for (int sRIwxkge = 0; sRIwxkge < IdIYmA6M.length; sRIwxkge++) {
				BufferedInputStream sx7xtcca;
				if (kyRAV6Mn) {
					sx7xtcca = new BufferedInputStream(new FileInputStream(IdIYmA6M[sRIwxkge]));
					SjnirngU.putNextEntry(new ZipEntry(cleanPath(IdIYmA6M[sRIwxkge].getAbsolutePath())));
				} else {
					sx7xtcca = new BufferedInputStream(new FileInputStream(IdIYmA6M[sRIwxkge]));
					SjnirngU.putNextEntry(new ZipEntry(IdIYmA6M[sRIwxkge].getName()));
				}
				for (int jh98eKNe = sx7xtcca.read(); jh98eKNe != -1; jh98eKNe = sx7xtcca.read())
					SjnirngU.write(jh98eKNe);
				sx7xtcca.close();
			}
			SjnirngU.close();
		} else
			throw new ZipException(MAIN_RESOURCE_BUNDLE.getString("default.ZipException.text"));
	}

}