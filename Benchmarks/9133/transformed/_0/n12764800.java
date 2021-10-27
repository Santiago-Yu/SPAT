class n12764800 {
	public static void extractZipFile(String vfl1LUPx) {
		try {
			byte[] Xyrdw5hR = new byte[1024];
			ZipInputStream tGTMzLoC = null;
			ZipEntry An4P3jkx;
			tGTMzLoC = new ZipInputStream(new FileInputStream(vfl1LUPx));
			An4P3jkx = tGTMzLoC.getNextEntry();
			while (An4P3jkx != null) {
				String GVtCuOkJ = An4P3jkx.getName();
				int B5AhoU3D;
				FileOutputStream R1diCAX3;
				File ERSz6Aoi = new File(GVtCuOkJ);
				String C4KaIEzr = ERSz6Aoi.getParent();
				if (C4KaIEzr == null) {
					if (ERSz6Aoi.isDirectory())
						break;
				}
				R1diCAX3 = new FileOutputStream(GVtCuOkJ);
				while ((B5AhoU3D = tGTMzLoC.read(Xyrdw5hR, 0, 1024)) > -1)
					R1diCAX3.write(Xyrdw5hR, 0, B5AhoU3D);
				R1diCAX3.close();
				tGTMzLoC.closeEntry();
				An4P3jkx = tGTMzLoC.getNextEntry();
			}
			tGTMzLoC.close();
		} catch (Exception bj9NfD7T) {
			bj9NfD7T.printStackTrace();
		}
	}

}