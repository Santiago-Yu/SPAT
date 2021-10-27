class n17497944 {
	public void format(File WZjShKw8, File BanT5WB4) {
		if (!WZjShKw8.exists()) {
			throw new IllegalArgumentException("Source '" + WZjShKw8 + " doesn't exist");
		}
		if (!WZjShKw8.isFile()) {
			throw new IllegalArgumentException("Source '" + WZjShKw8 + " is not a file");
		}
		BanT5WB4.mkdirs();
		String N8ak0PqC = WZjShKw8.getName().substring(WZjShKw8.getName().lastIndexOf(".") + 1);
		String XWvoNng6 = WZjShKw8.getName().replace(N8ak0PqC, "html");
		BanT5WB4 = new File(BanT5WB4.getPath() + "/" + XWvoNng6);
		try {
			Reader hH4vcECj = new FileReader(WZjShKw8);
			Writer mRlIPwpu = new FileWriter(BanT5WB4);
			this.format(hH4vcECj, mRlIPwpu);
		} catch (Exception OPHSnJ2F) {
			OPHSnJ2F.printStackTrace();
		}
	}

}