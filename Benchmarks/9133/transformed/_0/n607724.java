class n607724 {
	public void copyFile(String pzKdL1gY, String M6Y0TChM) {
		try {
			int bzS5IafA = 0;
			int vFPItZ9x = 0;
			File TSDzcvdP = new File(pzKdL1gY);
			if (TSDzcvdP.exists()) {
				InputStream sAHM7aM2 = new FileInputStream(pzKdL1gY);
				FileOutputStream AMfn39dH = new FileOutputStream(M6Y0TChM);
				byte[] KDgPRejq = new byte[1444];
				while ((vFPItZ9x = sAHM7aM2.read(KDgPRejq)) != -1) {
					bzS5IafA += vFPItZ9x;
					System.out.println(bzS5IafA);
					AMfn39dH.write(KDgPRejq, 0, vFPItZ9x);
				}
				sAHM7aM2.close();
			}
		} catch (Exception Eq8bbwBs) {
			message = ("??????????????????");
		}
	}

}