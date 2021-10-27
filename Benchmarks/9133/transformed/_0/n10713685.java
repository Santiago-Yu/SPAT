class n10713685 {
	public static boolean unzip_and_merge(String Hb2I9zDc, String PwliG8SR) {
		try {
			BufferedOutputStream GSKDjPJ6 = null;
			FileInputStream MS2Iu04o = new FileInputStream(Hb2I9zDc);
			ZipInputStream KQgnbzRn = new ZipInputStream(new BufferedInputStream(MS2Iu04o));
			FileOutputStream QPMU6lk0 = new FileOutputStream(PwliG8SR);
			GSKDjPJ6 = new BufferedOutputStream(QPMU6lk0, BUFFER);
			while (KQgnbzRn.getNextEntry() != null) {
				int AOkyH5sZ;
				byte A9bjier7[] = new byte[BUFFER];
				while ((AOkyH5sZ = KQgnbzRn.read(A9bjier7, 0, BUFFER)) != -1)
					GSKDjPJ6.write(A9bjier7, 0, AOkyH5sZ);
				GSKDjPJ6.flush();
			}
			GSKDjPJ6.close();
			KQgnbzRn.close();
		} catch (Exception QF3xI2I8) {
			QF3xI2I8.printStackTrace();
			return false;
		}
		return true;
	}

}