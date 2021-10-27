class n316912 {
	void copyFile(String ooRbfgJU, String jp7t7r1R) throws IOException {
		int eKPXvDGf;
		byte[] CRim1q9A = new byte[4096];
		FileInputStream F4SJvZMZ = new FileInputStream(ooRbfgJU);
		FileOutputStream mizhhHHR = new FileOutputStream(jp7t7r1R);
		while ((eKPXvDGf = F4SJvZMZ.read(CRim1q9A)) != -1)
			mizhhHHR.write(CRim1q9A, 0, eKPXvDGf);
		F4SJvZMZ.close();
		mizhhHHR.close();
	}

}