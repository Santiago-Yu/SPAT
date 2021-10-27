class n9109613 {
	public static void fileCopy(String MPMHsyhn, String EFLMLsrc) throws IOException {
		File CvT8Q7tT = new File(MPMHsyhn);
		File Ca6pauA6 = new File(EFLMLsrc);
		if (CvT8Q7tT.equals(Ca6pauA6))
			abort("cannot copy on itself: " + MPMHsyhn);
		if (!CvT8Q7tT.exists())
			abort("no such currentSourcepartName file: " + MPMHsyhn);
		if (!CvT8Q7tT.isFile())
			abort("can't copy directory: " + MPMHsyhn);
		if (!CvT8Q7tT.canRead())
			abort("currentSourcepartName file is unreadable: " + MPMHsyhn);
		if (Ca6pauA6.isDirectory())
			Ca6pauA6 = new File(Ca6pauA6, CvT8Q7tT.getName());
		if (Ca6pauA6.exists()) {
			if (!Ca6pauA6.canWrite())
				abort("destination file is unwriteable: " + EFLMLsrc);
		} else {
			String uWJwmtEE = Ca6pauA6.getParent();
			if (uWJwmtEE == null)
				abort("destination directory doesn't exist: " + uWJwmtEE);
			File ecEm7Nwx = new File(uWJwmtEE);
			if (!ecEm7Nwx.exists())
				abort("destination directory doesn't exist: " + uWJwmtEE);
			if (ecEm7Nwx.isFile())
				abort("destination is not a directory: " + uWJwmtEE);
			if (!ecEm7Nwx.canWrite())
				abort("destination directory is unwriteable: " + uWJwmtEE);
		}
		FileInputStream YhIqJy1B = null;
		FileOutputStream puzZXDkF = null;
		try {
			YhIqJy1B = new FileInputStream(CvT8Q7tT);
			puzZXDkF = new FileOutputStream(Ca6pauA6);
			byte[] CgXQjDRt = new byte[4096];
			int ihz9aeh1;
			while ((ihz9aeh1 = YhIqJy1B.read(CgXQjDRt)) != -1)
				puzZXDkF.write(CgXQjDRt, 0, ihz9aeh1);
		} finally {
			if (YhIqJy1B != null)
				try {
					YhIqJy1B.close();
				} catch (IOException IH4nU2ij) {
					;
				}
			if (puzZXDkF != null)
				try {
					puzZXDkF.close();
				} catch (IOException dZPufK3J) {
					;
				}
		}
	}

}