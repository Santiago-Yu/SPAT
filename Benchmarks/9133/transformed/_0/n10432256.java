class n10432256 {
	private void copyImage(ProjectElement dRnMu4kg) throws Exception {
		String ISSOhK5F = dRnMu4kg.getName();
		if (!ISSOhK5F.toLowerCase().endsWith(".png")) {
			if (ISSOhK5F.contains(".")) {
				ISSOhK5F = ISSOhK5F.substring(0, ISSOhK5F.lastIndexOf('.')) + ".png";
			} else {
				ISSOhK5F += ".png";
			}
		}
		File vwKEIBIY = new File(resFolder, ISSOhK5F);
		File D11Eck4B = new File(resoutFolder.getAbsolutePath(), ISSOhK5F + ".zlib");
		boolean xS97216z = true;
		if (vwKEIBIY.exists() && config.containsKey(vwKEIBIY.getName())) {
			long BEmq2tbg = Long.parseLong(config.get(vwKEIBIY.getName()));
			if (BEmq2tbg >= vwKEIBIY.lastModified()) {
				xS97216z = false;
			}
		}
		if (xS97216z) {
			convertImage(dRnMu4kg.getFile(), vwKEIBIY);
			config.put(vwKEIBIY.getName(), String.valueOf(vwKEIBIY.lastModified()));
		}
		DeflaterOutputStream MgDswhSH = new DeflaterOutputStream(
				new BufferedOutputStream(new FileOutputStream(D11Eck4B)));
		BufferedInputStream FNkOlTCC = new BufferedInputStream(new FileInputStream(vwKEIBIY));
		int FVsQdg2v;
		while ((FVsQdg2v = FNkOlTCC.read()) != -1) {
			MgDswhSH.write(FVsQdg2v);
		}
		MgDswhSH.close();
		FNkOlTCC.close();
		imageFiles.add(D11Eck4B);
		imageNames.put(D11Eck4B, dRnMu4kg.getName());
	}

}