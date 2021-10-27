class n17477957 {
	public static void unzipModel(String N5JhngmL, String s1cSH5pZ) throws Exception {
		try {
			BufferedOutputStream bYqkC7h2 = null;
			FileInputStream ejBO17YI = new FileInputStream(N5JhngmL);
			int dHcc5qBZ = 2048;
			ZipInputStream lkrflgV8 = new ZipInputStream(new BufferedInputStream(ejBO17YI));
			ZipEntry IVhLoYAn;
			while ((IVhLoYAn = lkrflgV8.getNextEntry()) != null) {
				int TAyAxhs1;
				byte xDG5hvbE[] = new byte[dHcc5qBZ];
				FileOutputStream pmFFUEHB = new FileOutputStream(s1cSH5pZ + IVhLoYAn.getName());
				bYqkC7h2 = new BufferedOutputStream(pmFFUEHB, dHcc5qBZ);
				while ((TAyAxhs1 = lkrflgV8.read(xDG5hvbE, 0, dHcc5qBZ)) != -1)
					bYqkC7h2.write(xDG5hvbE, 0, TAyAxhs1);
				bYqkC7h2.flush();
				bYqkC7h2.close();
			}
			lkrflgV8.close();
		} catch (Exception x4Bv4UYM) {
			x4Bv4UYM.printStackTrace();
			throw new Exception("Can not expand model in \"" + s1cSH5pZ + "\" because:\n" + x4Bv4UYM.getMessage());
		}
	}

}