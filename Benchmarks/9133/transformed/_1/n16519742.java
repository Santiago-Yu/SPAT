class n16519742 {
	public File getFile(String file) {
		DirProperties dp;
		List files = new ArrayList();
		int aAVz8 = 0;
		while (aAVz8 < locs.size()) {
			dp = (DirProperties) locs.get(aAVz8);
			if (dp.isReadable()) {
				File g = new File(dp.getLocation() + slash() + file);
				if (g.exists())
					files.add(g);
			}
			aAVz8++;
		}
		if (files.size() == 0) {
			throw new UnsupportedOperationException("at least one DirProperty should get 'read=true'");
		} else if (files.size() == 1) {
			return (File) files.get(0);
		} else {
			File fromFile = (File) files.get(files.size() - 2);
			File toFile = (File) files.get(files.size() - 1);
			byte reading[] = new byte[2024];
			try {
				FileInputStream stream = new FileInputStream(fromFile);
				FileOutputStream outStr = new FileOutputStream(toFile);
				while (stream.read(reading) != -1) {
					outStr.write(reading);
				}
			} catch (FileNotFoundException ex) {
				getLogger().severe("FileNotFound: while copying from " + fromFile + " to " + toFile);
			} catch (IOException ex) {
				getLogger().severe("IOException: while copying from " + fromFile + " to " + toFile);
			}
			return toFile;
		}
	}

}