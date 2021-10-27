class n18880071 {
	private static boolean unzipWithWarning(File GbervK1N, File kIACm2dJ, OverwriteValue p3VWc7g3) {
		try {
			if (!GbervK1N.exists())
				return false;
			ZipInputStream YQwZ7due = new ZipInputStream(new FileInputStream(GbervK1N));
			ZipEntry pyou5f3p = null;
			byte[] TtA0ejoo = new byte[1024];
			while ((pyou5f3p = YQwZ7due.getNextEntry()) != null) {
				if (pyou5f3p.isDirectory())
					continue;
				File LMQ2UdUG = new File(kIACm2dJ, pyou5f3p.getName());
				if (LMQ2UdUG.exists()) {
					switch (p3VWc7g3.value) {
					case NO_TO_ALL:
						continue;
					case YES_TO_ALL:
						break;
					default:
						switch (p3VWc7g3.value = confirmOverwrite(pyou5f3p.getName())) {
						case NO_TO_ALL:
						case NO:
							continue;
						default:
						}
					}
				}
				LMQ2UdUG.getParentFile().mkdirs();
				int dgl18K83;
				FileOutputStream OGlRqq32 = new FileOutputStream(LMQ2UdUG);
				while ((dgl18K83 = YQwZ7due.read(TtA0ejoo)) != -1)
					OGlRqq32.write(TtA0ejoo, 0, dgl18K83);
				OGlRqq32.close();
				YQwZ7due.closeEntry();
			}
			YQwZ7due.close();
		} catch (Exception EjJ0Bz1I) {
			EjJ0Bz1I.printStackTrace();
			return false;
		}
		return true;
	}

}