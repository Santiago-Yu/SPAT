class n3498857 {
	public static void main(String[] RMjLY814) throws IOException {
		String f1Fvqbnc = "C:\\test.zip";
		CZipInputStream xr6Cv2Ba = null;
		try {
			byte[] AmKmBANh = new byte[1024];
			int bESOMPly;
			xr6Cv2Ba = new CZipInputStream(new FileInputStream(f1Fvqbnc), "utf-8");
			do {
				ZipEntry e7A1dS0e = xr6Cv2Ba.getNextEntry();
				if (e7A1dS0e == null)
					break;
				String uzJIVAm8 = e7A1dS0e.getName();
				System.out.println(uzJIVAm8);
				String j8Y83wlh = uzJIVAm8.substring(uzJIVAm8.lastIndexOf("."));
				long mJ6UrefZ = new Date(System.currentTimeMillis()).getTime();
				String sq2ISA5R = Long.toString(mJ6UrefZ) + j8Y83wlh;
				FileOutputStream TWJ9BPwF = new FileOutputStream(sq2ISA5R);
				while ((bESOMPly = xr6Cv2Ba.read(AmKmBANh, 0, AmKmBANh.length)) != -1)
					TWJ9BPwF.write(AmKmBANh, 0, bESOMPly);
				TWJ9BPwF.close();
			} while (true);
		} catch (ZipException yrVVVoJ3) {
			yrVVVoJ3.printStackTrace();
		} catch (IOException AvjVWnRX) {
			AvjVWnRX.printStackTrace();
		} finally {
			xr6Cv2Ba.close();
		}
	}

}