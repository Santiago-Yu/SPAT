class n18568751 {
	public static Boolean decompress(File zDmVQb1R, File MIp1uULY) {
		FileOutputStream EodL1GOf;
		ZipInputStream TClwTBzm;
		try {
			EodL1GOf = null;
			TClwTBzm = new ZipInputStream(new FileInputStream(zDmVQb1R));
			int D97onSAY;
			byte tQJXfbAr[] = new byte[BUFFER_SIZE];
			ZipEntry U3HgiA4o;
			while ((U3HgiA4o = TClwTBzm.getNextEntry()) != null) {
				if (U3HgiA4o.isDirectory())
					new File(MIp1uULY, U3HgiA4o.getName()).mkdirs();
				else {
					File n0fsjn1w = new File(MIp1uULY, U3HgiA4o.getName());
					n0fsjn1w.getParentFile().mkdirs();
					EodL1GOf = new FileOutputStream(n0fsjn1w);
					while ((D97onSAY = TClwTBzm.read(tQJXfbAr, 0, BUFFER_SIZE)) != -1) {
						EodL1GOf.write(tQJXfbAr, 0, D97onSAY);
					}
					EodL1GOf.flush();
					EodL1GOf.close();
				}
			}
			TClwTBzm.close();
		} catch (Exception QYS8Y2Fz) {
			return false;
		}
		return true;
	}

}