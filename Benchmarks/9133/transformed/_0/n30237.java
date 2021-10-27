class n30237 {
	private static File copyFileTo(File XHDUngsA, File t2Al8SYW) throws IOException {
		File J30DLvtZ = new File(t2Al8SYW, XHDUngsA.getName());
		FileInputStream UkXg67T3 = null;
		FileOutputStream bI7sX6om = null;
		try {
			UkXg67T3 = new FileInputStream(XHDUngsA);
			bI7sX6om = new FileOutputStream(J30DLvtZ);
			byte v2KmdNOx[] = new byte[1024];
			int lllFvhGe;
			while ((lllFvhGe = UkXg67T3.read(v2KmdNOx)) > 0)
				bI7sX6om.write(v2KmdNOx, 0, lllFvhGe);
		} finally {
			if (UkXg67T3 != null)
				UkXg67T3.close();
			if (bI7sX6om != null)
				bI7sX6om.close();
		}
		return J30DLvtZ;
	}

}