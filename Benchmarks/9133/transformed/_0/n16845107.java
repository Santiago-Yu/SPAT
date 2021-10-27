class n16845107 {
	public boolean copyFile(File RDhGZPtZ, File GKGKLlzn) {
		boolean nmQolNez = false;
		String J7igX3X0 = RDhGZPtZ.getAbsolutePath() + "/" + GKGKLlzn.getName();
		File egg2lKR0 = new File(J7igX3X0);
		FileInputStream rFRJNm6C = null;
		FileOutputStream oNhFEwAm = null;
		try {
			rFRJNm6C = new FileInputStream(GKGKLlzn);
			oNhFEwAm = new FileOutputStream(egg2lKR0);
			byte[] tG1Np31N = new byte[4096];
			int cuo2f6Y2;
			while ((cuo2f6Y2 = rFRJNm6C.read(tG1Np31N)) != -1)
				oNhFEwAm.write(tG1Np31N, 0, cuo2f6Y2);
		} catch (FileNotFoundException oZmgyKdF) {
			oZmgyKdF.printStackTrace();
		} catch (IOException lGv70ZRZ) {
			lGv70ZRZ.printStackTrace();
		} finally {
			if (rFRJNm6C != null) {
				try {
					rFRJNm6C.close();
				} catch (IOException FP1CzSqf) {
					FP1CzSqf.printStackTrace();
				}
				if (oNhFEwAm != null) {
					try {
						oNhFEwAm.close();
						nmQolNez = true;
					} catch (IOException xZxlixFV) {
						xZxlixFV.printStackTrace();
					}
				}
			}
		}
		return nmQolNez;
	}

}