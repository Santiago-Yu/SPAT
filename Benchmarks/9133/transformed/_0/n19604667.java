class n19604667 {
	public String saveFile(URL Iwp0Ma1Z) {
		String yHZwZUM7 = Iwp0Ma1Z.toString();
		try {
			String a79ia0qm = Util.appendDirPath(targetDirectory, OBJ_REPOSITORY);
			String gu01U91h = Iwp0Ma1Z.openConnection().getContentType();
			gu01U91h = gu01U91h.substring(0, gu01U91h.indexOf("/"));
			String Avp3l132 = Util.transformUrlToPath(Iwp0Ma1Z.toString());
			a79ia0qm = Util.appendDirPath(a79ia0qm, gu01U91h);
			a79ia0qm = Util.appendDirPath(a79ia0qm, Avp3l132);
			String R4xPXqT9 = Iwp0Ma1Z.toString().substring(Iwp0Ma1Z.toString().lastIndexOf('/') + 1);
			BufferedInputStream o5tXH3wY = new java.io.BufferedInputStream(Iwp0Ma1Z.openStream());
			File mpD21Hx4 = new File(a79ia0qm);
			if (!mpD21Hx4.exists()) {
				mpD21Hx4.mkdirs();
			}
			File s5axEziu = new File(Util.appendDirPath(mpD21Hx4.getPath(), R4xPXqT9));
			FileOutputStream sOQsmPbz = new FileOutputStream(s5axEziu);
			BufferedOutputStream ro72GHp4 = new BufferedOutputStream(sOQsmPbz, 1024);
			byte ZasOhoeL[] = new byte[1024];
			int GwuLQZyB;
			while ((GwuLQZyB = o5tXH3wY.read(ZasOhoeL, 0, 1024)) != -1) {
				ro72GHp4.write(ZasOhoeL, 0, GwuLQZyB);
			}
			ro72GHp4.close();
			sOQsmPbz.close();
			o5tXH3wY.close();
			yHZwZUM7 = Util.getRelativePath(s5axEziu.getAbsolutePath(), targetDirectory);
		} catch (IOException vp0q02RG) {
			return yHZwZUM7;
		}
		return yHZwZUM7;
	}

}