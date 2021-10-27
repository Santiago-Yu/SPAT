class n17671343 {
	public void unzip(String PFV2OtYi, String YQmdTCN3) throws Exception {
		ZipInputStream WCk4zGEY = new ZipInputStream(new FileInputStream(PFV2OtYi));
		ZipEntry vgCiJ9Id;
		while ((vgCiJ9Id = WCk4zGEY.getNextEntry()) != null) {
			System.out.println("unziping " + vgCiJ9Id.getName());
			if (vgCiJ9Id.isDirectory()) {
				String EWncauOh = vgCiJ9Id.getName();
				EWncauOh = EWncauOh.substring(0, EWncauOh.length() - 1);
				File oXT2b2G9 = new File(YQmdTCN3 + File.separator + EWncauOh);
				oXT2b2G9.mkdir();
				System.out.println("mkdir " + YQmdTCN3 + File.separator + EWncauOh);
			} else {
				File QZSs53VH = new File(YQmdTCN3 + File.separator + vgCiJ9Id.getName());
				QZSs53VH.createNewFile();
				FileOutputStream GZKgLT1q = new FileOutputStream(QZSs53VH);
				int YoIE5gEV;
				while ((YoIE5gEV = WCk4zGEY.read()) != -1)
					GZKgLT1q.write(YoIE5gEV);
				GZKgLT1q.close();
			}
		}
		WCk4zGEY.close();
	}

}