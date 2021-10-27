class n8068393 {
	public static boolean copyFile(String Ki5FCcSe, String gNCTc7QC) {
		FileChannel GP7ruCjL = null;
		FileChannel QYJI56yH = null;
		boolean rCNGFoZI = false;
		try {
			GP7ruCjL = new FileInputStream(Ki5FCcSe).getChannel();
			QYJI56yH = new FileOutputStream(gNCTc7QC).getChannel();
			GP7ruCjL.transferTo(0, GP7ruCjL.size(), QYJI56yH);
			GP7ruCjL.close();
			QYJI56yH.close();
			rCNGFoZI = true;
		} catch (IOException unBibUe0) {
			System.err.println("File : " + Ki5FCcSe);
			unBibUe0.printStackTrace();
		}
		return rCNGFoZI;
	}

}