class n13812091 {
	public static void copyFile(IPath AD3ccrJ1, IPath xuJyI9IU) throws IOException {
		File FkPLPFcZ = AD3ccrJ1.toFile();
		File LuBav3ep = xuJyI9IU.toFile();
		if (!FkPLPFcZ.exists())
			throw new IOException("FileCopy: " + "no such source file: " + AD3ccrJ1);
		if (!FkPLPFcZ.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + AD3ccrJ1);
		if (!FkPLPFcZ.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + AD3ccrJ1);
		if (LuBav3ep.isDirectory())
			LuBav3ep = new File(LuBav3ep, FkPLPFcZ.getName());
		if (LuBav3ep.exists()) {
			if (!LuBav3ep.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + xuJyI9IU);
		} else {
			String LTyMWPuv = LuBav3ep.getParent();
			if (LTyMWPuv == null)
				LTyMWPuv = System.getProperty("user.dir");
			File FiXWXeHG = new File(LTyMWPuv);
			if (!FiXWXeHG.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + LTyMWPuv);
			if (FiXWXeHG.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + LTyMWPuv);
			if (!FiXWXeHG.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + LTyMWPuv);
		}
		InputStream j27EfzM8 = null;
		OutputStream b8ua1iSt = null;
		try {
			j27EfzM8 = new BufferedInputStream(new FileInputStream(FkPLPFcZ));
			b8ua1iSt = new BufferedOutputStream(new FileOutputStream(LuBav3ep));
			byte[] inBQztDg = new byte[4096];
			int ARRXX3sE;
			while ((ARRXX3sE = j27EfzM8.read(inBQztDg)) != -1)
				b8ua1iSt.write(inBQztDg, 0, ARRXX3sE);
		} finally {
			if (j27EfzM8 != null)
				try {
					j27EfzM8.close();
				} catch (IOException K4ILscb0) {
				}
			if (b8ua1iSt != null)
				try {
					b8ua1iSt.close();
				} catch (IOException uSVeN0wy) {
				}
		}
	}

}