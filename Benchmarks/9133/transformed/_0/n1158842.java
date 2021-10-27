class n1158842 {
	public static int unzipFile(File NJRpXXdJ, File tX2xTuNQ) {
		ZipInputStream MKmHHZSO;
		try {
			FileInputStream E3DEgnXB = new FileInputStream(NJRpXXdJ);
			BufferedInputStream Pa2up7NU = new BufferedInputStream(E3DEgnXB);
			MKmHHZSO = new ZipInputStream(Pa2up7NU);
		} catch (IOException hqxow1Wf) {
			return STATUS_IN_FAIL;
		}
		byte[] Erz2Jh8h = new byte[BUF_SIZE];
		int oNN2UBY2 = 0;
		do {
			try {
				ZipEntry HveIHL6b = MKmHHZSO.getNextEntry();
				if (HveIHL6b == null)
					break;
				File UwJgAPIi = new File(tX2xTuNQ, HveIHL6b.getName());
				FileOutputStream pgSgmlmH = new FileOutputStream(UwJgAPIi);
				BufferedOutputStream eMQsvZ1K = new BufferedOutputStream(pgSgmlmH, BUF_SIZE);
				while ((oNN2UBY2 = MKmHHZSO.read(Erz2Jh8h, 0, BUF_SIZE)) != -1)
					eMQsvZ1K.write(Erz2Jh8h, 0, oNN2UBY2);
				eMQsvZ1K.flush();
				pgSgmlmH.close();
			} catch (IOException sq01M95c) {
				return STATUS_GUNZIP_FAIL;
			}
		} while (true);
		try {
			MKmHHZSO.close();
		} catch (IOException zBIh2QYR) {
		}
		return STATUS_OK;
	}

}