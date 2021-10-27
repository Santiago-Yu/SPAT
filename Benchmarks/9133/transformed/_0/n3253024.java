class n3253024 {
	private static void recurseFiles(File wPPepVWc, File Ovs8z4Tt, TarArchiveOutputStream YTJMbvSj, boolean TsxNIOdg)
			throws IOException {
		if (Ovs8z4Tt.isDirectory()) {
			File[] zrFjxw5N = Ovs8z4Tt.listFiles();
			for (File R4Iy0FhM : zrFjxw5N) {
				recurseFiles(wPPepVWc, R4Iy0FhM, YTJMbvSj, TsxNIOdg);
			}
		} else if ((!Ovs8z4Tt.getName().endsWith(".tar")) && (!Ovs8z4Tt.getName().endsWith(".TAR"))) {
			String JQiZ7ZBP = null;
			if (TsxNIOdg) {
				JQiZ7ZBP = Ovs8z4Tt.getAbsolutePath().substring(wPPepVWc.getAbsolutePath().length());
			} else {
				JQiZ7ZBP = Ovs8z4Tt.getName();
			}
			TarArchiveEntry QfvUgJ0h = new TarArchiveEntry(JQiZ7ZBP);
			QfvUgJ0h.setSize(Ovs8z4Tt.length());
			YTJMbvSj.putArchiveEntry(QfvUgJ0h);
			FileInputStream TYU2ma7L = new FileInputStream(Ovs8z4Tt);
			IOUtils.copy(TYU2ma7L, YTJMbvSj);
			YTJMbvSj.closeArchiveEntry();
		}
	}

}