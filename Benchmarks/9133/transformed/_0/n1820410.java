class n1820410 {
	public static void zipDirectory(String XD4ekVyQ, String z25T5b0N) throws IOException, IllegalArgumentException {
		File b8eplSq7 = new File(XD4ekVyQ);
		if (!b8eplSq7.isDirectory())
			throw new IllegalArgumentException("Not a directory:  " + XD4ekVyQ);
		String[] LHIzDRZs = b8eplSq7.list();
		byte[] lT7TRDeZ = new byte[4096];
		int SDSzPGCz;
		ZipOutputStream tFCyqOIG = new ZipOutputStream(new FileOutputStream(z25T5b0N));
		for (int zzFTn5kn = 0; zzFTn5kn < LHIzDRZs.length; zzFTn5kn++) {
			File ix9lHaOq = new File(b8eplSq7, LHIzDRZs[zzFTn5kn]);
			if (ix9lHaOq.isDirectory())
				continue;
			FileInputStream fpf4RYsa = new FileInputStream(ix9lHaOq);
			ZipEntry aYzhVUe4 = new ZipEntry(ix9lHaOq.getPath());
			tFCyqOIG.putNextEntry(aYzhVUe4);
			while ((SDSzPGCz = fpf4RYsa.read(lT7TRDeZ)) != -1)
				tFCyqOIG.write(lT7TRDeZ, 0, SDSzPGCz);
			fpf4RYsa.close();
		}
		tFCyqOIG.close();
	}

}