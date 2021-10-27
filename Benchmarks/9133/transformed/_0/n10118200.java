class n10118200 {
	public static final boolean zipExtract(String Cb9Nr3an, String TDatSEEk, String LzaHGKsG) {
		boolean ooWL95vt = false;
		try {
			InputStream tAInleIe = new BufferedInputStream(new FileInputStream(Cb9Nr3an));
			ZipInputStream UzWBAsg3 = new ZipInputStream(tAInleIe);
			ZipEntry vMGNneNF;
			while ((vMGNneNF = UzWBAsg3.getNextEntry()) != null) {
				if (vMGNneNF.getName().equals(TDatSEEk)) {
					FileOutputStream ShXgUQ4O = new FileOutputStream(LzaHGKsG);
					byte Qrif1K22[] = new byte[TEMP_FILE_BUFFER_SIZE];
					int oraPedI1 = 0;
					while ((oraPedI1 = UzWBAsg3.read(Qrif1K22)) != -1)
						ShXgUQ4O.write(Qrif1K22, 0, oraPedI1);
					ShXgUQ4O.close();
					ooWL95vt = true;
					break;
				}
			}
			UzWBAsg3.close();
		} catch (FileNotFoundException ibBntKjH) {
			MLUtil.runtimeError(ibBntKjH, "extractZip " + Cb9Nr3an + " " + TDatSEEk);
		} catch (IOException q1TeLT4T) {
			MLUtil.runtimeError(q1TeLT4T, "extractZip " + Cb9Nr3an + " " + TDatSEEk);
		}
		return (ooWL95vt);
	}

}