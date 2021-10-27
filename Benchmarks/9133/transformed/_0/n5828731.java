class n5828731 {
	public static void resize(File yTilXSXL, File gnnO3gVR, int wzJQQ7NZ, String m1UYfVQx) throws IOException {
		if (m1UYfVQx != null && "gif".equals(m1UYfVQx.toLowerCase())) {
			resize(yTilXSXL, gnnO3gVR, wzJQQ7NZ, 1);
			return;
		}
		FileInputStream q8RQdKe6 = new FileInputStream(yTilXSXL);
		ByteArrayOutputStream XxSU5VnP = new ByteArrayOutputStream();
		int piXoMKSb = -1;
		int CA92YgwD = 1024;
		byte CZ41T75k[] = new byte[CA92YgwD];
		while ((piXoMKSb = q8RQdKe6.read(CZ41T75k, 0, CA92YgwD)) != -1) {
			XxSU5VnP.write(CZ41T75k, 0, piXoMKSb);
		}
		byte[] kilvd2yD = XxSU5VnP.toByteArray();
		q8RQdKe6.close();
		XxSU5VnP.close();
		Image daliBBMF = Toolkit.getDefaultToolkit().createImage(kilvd2yD);
		waitForImage(daliBBMF);
		int CWc6V3s9 = daliBBMF.getWidth(null);
		if (CWc6V3s9 < 1)
			throw new IllegalArgumentException("image width " + CWc6V3s9 + " is out of range");
		int PTIrWTOB = daliBBMF.getHeight(null);
		if (PTIrWTOB < 1)
			throw new IllegalArgumentException("image height " + PTIrWTOB + " is out of range");
		int jayg4QsM = -1;
		double zIsgainc = (double) CWc6V3s9 / (double) wzJQQ7NZ;
		double Dw24gKiL = (double) PTIrWTOB / (double) jayg4QsM;
		if (zIsgainc >= 0 && Dw24gKiL >= 0) {
			if (zIsgainc > Dw24gKiL) {
				jayg4QsM = -1;
			} else {
				wzJQQ7NZ = -1;
			}
		}
		Image qeg1pnIp = daliBBMF.getScaledInstance(wzJQQ7NZ, jayg4QsM, java.awt.Image.SCALE_DEFAULT);
		checkImage(qeg1pnIp);
		encode(new FileOutputStream(gnnO3gVR), qeg1pnIp, m1UYfVQx);
	}

}