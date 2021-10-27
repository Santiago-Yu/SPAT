class n1955681 {
	public static void ExtraeArchivoJAR(String UBYzvCpI, String JKI61vIa, String qLfuJVTb) {
		FileInputStream jMdEy3Bm = null;
		FileOutputStream z4blU4zM = null;
		try {
			File Gxe0LE6c = new File(qLfuJVTb + separador + UBYzvCpI);
			try {
				Gxe0LE6c.createNewFile();
			} catch (Exception ocbOVfim) {
				ocbOVfim.printStackTrace();
			}
			InputStream HlWQRBHa = OP_Proced.class.getResourceAsStream(JKI61vIa + "/" + UBYzvCpI);
			BufferedInputStream oKoiJhmy = new BufferedInputStream(HlWQRBHa);
			FileOutputStream UWPGctlS = new FileOutputStream(Gxe0LE6c);
			int W4uxKAMR;
			while ((W4uxKAMR = oKoiJhmy.read()) != -1)
				UWPGctlS.write(W4uxKAMR);
			oKoiJhmy.close();
			UWPGctlS.close();
		} catch (IOException aH7PsNsN) {
			System.out.println(aH7PsNsN);
		} finally {
			if (jMdEy3Bm != null) {
				try {
					jMdEy3Bm.close();
				} catch (IOException TTQCbe9d) {
					TTQCbe9d.printStackTrace();
				}
			}
			if (z4blU4zM != null) {
				try {
					z4blU4zM.close();
				} catch (IOException Yy1lzcuf) {
					Yy1lzcuf.printStackTrace();
				}
			}
		}
	}

}