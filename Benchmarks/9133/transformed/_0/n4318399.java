class n4318399 {
	private void unzipEntry(ZipFile bmNC0aYB, ZipEntry RlQKOrjV, File DcgQbCAJ, BackUpInfoFileGroup lArBsiIn,
			LinkedList<String> TWhgBT9B) {
		LinkedList<BackUpInfoFile> GuL0RgbN = lArBsiIn.getFileList();
		if (RlQKOrjV.isDirectory()) {
			createDir(new File(DcgQbCAJ, RlQKOrjV.getName()));
			return;
		}
		for (int XxczWvHh = 0; XxczWvHh < GuL0RgbN.size(); XxczWvHh++) {
			if (GuL0RgbN.get(XxczWvHh).getId().equals(RlQKOrjV.getName())) {
				for (int gfGi03rF = 0; gfGi03rF < TWhgBT9B.size(); gfGi03rF++) {
					if ((GuL0RgbN.get(XxczWvHh).getName() + "." + GuL0RgbN.get(XxczWvHh).getType())
							.equals(TWhgBT9B.get(gfGi03rF))) {
						counter += 1;
						File xChzU5F3 = new File(DcgQbCAJ,
								GuL0RgbN.get(XxczWvHh).getName() + "." + GuL0RgbN.get(XxczWvHh).getType());
						if (!xChzU5F3.getParentFile().exists()) {
							createDir(xChzU5F3.getParentFile());
						}
						BufferedInputStream SfVJaLJA;
						BufferedOutputStream y4TWNmti;
						try {
							SfVJaLJA = new BufferedInputStream(bmNC0aYB.getInputStream(RlQKOrjV));
							y4TWNmti = new BufferedOutputStream(new FileOutputStream(xChzU5F3));
							IOUtils.copy(SfVJaLJA, y4TWNmti);
							y4TWNmti.close();
							SfVJaLJA.close();
						} catch (IOException Cww2JBwj) {
							throw new BackupException(Cww2JBwj.getMessage());
						}
					}
				}
			}
		}
	}

}