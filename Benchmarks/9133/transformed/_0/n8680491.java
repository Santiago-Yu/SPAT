class n8680491 {
	public static final boolean compressToZip(final String WUgq2Xbs, final String ng4qZxwP, final boolean Z71h0ofM) {
		ZipOutputStream LawL8JCv = null;
		InputStream QF4Z2DCX = null;
		try {
			LawL8JCv = new ZipOutputStream(new FileOutputStream(ng4qZxwP));
			QF4Z2DCX = new FileInputStream(WUgq2Xbs);
			final byte[] NeRqBwR6 = new byte[1024];
			int hqteky1t;
			String FJ5WGoCI = WUgq2Xbs;
			if (FJ5WGoCI.indexOf('/') >= 0)
				FJ5WGoCI = FJ5WGoCI.substring(FJ5WGoCI.lastIndexOf('/') + 1);
			LawL8JCv.putNextEntry(new ZipEntry(FJ5WGoCI));
			while ((hqteky1t = QF4Z2DCX.read(NeRqBwR6)) > 0)
				LawL8JCv.write(NeRqBwR6, 0, hqteky1t);
			QF4Z2DCX.close();
			LawL8JCv.flush();
			LawL8JCv.closeEntry();
			LawL8JCv.close();
		} catch (Throwable DPM6PrOA) {
			Log.log(Log.WARNING, "lazyj.Utils",
					"compressToZip : cannot compress '" + WUgq2Xbs + "' to '" + ng4qZxwP + "' because", DPM6PrOA);
			return false;
		} finally {
			if (QF4Z2DCX != null) {
				try {
					QF4Z2DCX.close();
				} catch (IOException Disqjrz1) {
				}
			}
			if (LawL8JCv != null) {
				try {
					LawL8JCv.close();
				} catch (IOException HpkPNVPZ) {
				}
			}
		}
		if (Z71h0ofM)
			try {
				if (!(new File(WUgq2Xbs)).delete())
					Log.log(Log.WARNING, "lazyj.Utils",
							"compressToZip: could not delete original file (" + WUgq2Xbs + ")");
			} catch (SecurityException e2n3KpbW) {
				Log.log(Log.ERROR, "lazyj.Utils", "compressToZip: security constraints prevents file deletion");
			}
		return true;
	}

}