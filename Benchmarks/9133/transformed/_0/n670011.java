class n670011 {
	public static void copy(String YxJuppSJ, String nV3yzWKq) throws IOException {
		File m1Z4Nyji = new File(YxJuppSJ);
		File U0lHuidT = new File(nV3yzWKq);
		if (!m1Z4Nyji.exists())
			abort("FileCopy: no such source file: " + YxJuppSJ);
		if (!m1Z4Nyji.isFile())
			abort("FileCopy: can't copy directory: " + YxJuppSJ);
		if (!m1Z4Nyji.canRead())
			abort("FileCopy: source file is unreadable: " + YxJuppSJ);
		if (U0lHuidT.isDirectory())
			U0lHuidT = new File(U0lHuidT, m1Z4Nyji.getName());
		if (U0lHuidT.exists()) {
			if (!U0lHuidT.canWrite())
				abort("FileCopy: destination file is unwriteable: " + nV3yzWKq);
			System.out.print("Overwrite existing file " + nV3yzWKq + "? (Y/N): ");
			System.out.flush();
			BufferedReader DnS3iYLl = new BufferedReader(new InputStreamReader(System.in));
			String PYStYh4Q = DnS3iYLl.readLine();
			if (!PYStYh4Q.equals("Y") && !PYStYh4Q.equals("y"))
				abort("FileCopy: existing file was not overwritten.");
		} else {
			String MBEpTgT8 = U0lHuidT.getParent();
			if (MBEpTgT8 == null)
				MBEpTgT8 = System.getProperty("user.dir");
			File jlyNbOZV = new File(MBEpTgT8);
			if (!jlyNbOZV.exists())
				abort("FileCopy: destination directory doesn't exist: " + MBEpTgT8);
			if (jlyNbOZV.isFile())
				abort("FileCopy: destination is not a directory: " + MBEpTgT8);
			if (!jlyNbOZV.canWrite())
				abort("FileCopy: destination directory is unwriteable: " + MBEpTgT8);
		}
		FileInputStream eDNkCiYU = null;
		FileOutputStream dPmL8LUv = null;
		try {
			eDNkCiYU = new FileInputStream(m1Z4Nyji);
			dPmL8LUv = new FileOutputStream(U0lHuidT);
			byte[] BHcplgWG = new byte[4096];
			int T98OXC9e;
			while ((T98OXC9e = eDNkCiYU.read(BHcplgWG)) != -1)
				dPmL8LUv.write(BHcplgWG, 0, T98OXC9e);
		} finally {
			if (eDNkCiYU != null)
				try {
					eDNkCiYU.close();
				} catch (IOException pjx3VINZ) {
					;
				}
			if (dPmL8LUv != null)
				try {
					dPmL8LUv.close();
				} catch (IOException ORfWz0yu) {
					;
				}
		}
	}

}