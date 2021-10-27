class n16519742 {
	public File getFile(String FvFXPzPZ) {
		DirProperties Tx0YZlIu;
		List aPNA4qXn = new ArrayList();
		for (int fugyqC5n = 0; fugyqC5n < locs.size(); fugyqC5n++) {
			Tx0YZlIu = (DirProperties) locs.get(fugyqC5n);
			if (Tx0YZlIu.isReadable()) {
				File ecSGRyGg = new File(Tx0YZlIu.getLocation() + slash() + FvFXPzPZ);
				if (ecSGRyGg.exists())
					aPNA4qXn.add(ecSGRyGg);
			}
		}
		if (aPNA4qXn.size() == 0) {
			throw new UnsupportedOperationException("at least one DirProperty should get 'read=true'");
		} else if (aPNA4qXn.size() == 1) {
			return (File) aPNA4qXn.get(0);
		} else {
			File L6PJHH0c = (File) aPNA4qXn.get(aPNA4qXn.size() - 2);
			File hggEwQaT = (File) aPNA4qXn.get(aPNA4qXn.size() - 1);
			byte Ut3TdC88[] = new byte[2024];
			try {
				FileInputStream UZDe1nLG = new FileInputStream(L6PJHH0c);
				FileOutputStream FDUctmmF = new FileOutputStream(hggEwQaT);
				while (UZDe1nLG.read(Ut3TdC88) != -1) {
					FDUctmmF.write(Ut3TdC88);
				}
			} catch (FileNotFoundException GIXUvtIw) {
				getLogger().severe("FileNotFound: while copying from " + L6PJHH0c + " to " + hggEwQaT);
			} catch (IOException e1mCmHwD) {
				getLogger().severe("IOException: while copying from " + L6PJHH0c + " to " + hggEwQaT);
			}
			return hggEwQaT;
		}
	}

}