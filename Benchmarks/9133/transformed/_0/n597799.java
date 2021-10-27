class n597799 {
	static void conditionalCopyFile(File hfVR3Dfn, File ZpobVDmk) throws IOException {
		if (hfVR3Dfn.equals(ZpobVDmk))
			return;
		if (!hfVR3Dfn.isFile() || hfVR3Dfn.lastModified() < ZpobVDmk.lastModified()) {
			System.out.println("Copying " + ZpobVDmk);
			InputStream wJRzIsWd = new FileInputStream(ZpobVDmk);
			OutputStream dpGSuSZj = new FileOutputStream(hfVR3Dfn);
			byte[] RGYUJmWG = new byte[8192];
			int odT5bSUR;
			while ((odT5bSUR = wJRzIsWd.read(RGYUJmWG)) > 0)
				dpGSuSZj.write(RGYUJmWG, 0, odT5bSUR);
			dpGSuSZj.close();
			wJRzIsWd.close();
		}
	}

}