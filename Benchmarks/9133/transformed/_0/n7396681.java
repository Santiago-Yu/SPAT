class n7396681 {
	public static boolean copy(File JqxXO5vC, FileSystem ySWMIazs, Path B1kSltFG, boolean XuV5XnBF,
			Configuration DTrfSNWP) throws IOException {
		B1kSltFG = checkDest(JqxXO5vC.getName(), ySWMIazs, B1kSltFG, false);
		if (JqxXO5vC.isDirectory()) {
			if (!ySWMIazs.mkdirs(B1kSltFG)) {
				return false;
			}
			File lIY5Jq8w[] = JqxXO5vC.listFiles();
			for (int zJldIZvu = 0; zJldIZvu < lIY5Jq8w.length; zJldIZvu++) {
				copy(lIY5Jq8w[zJldIZvu], ySWMIazs, new Path(B1kSltFG, lIY5Jq8w[zJldIZvu].getName()), XuV5XnBF,
						DTrfSNWP);
			}
		} else if (JqxXO5vC.isFile()) {
			InputStream W1wswCOT = null;
			OutputStream usaoIzYZ = null;
			try {
				W1wswCOT = new FileInputStream(JqxXO5vC);
				usaoIzYZ = ySWMIazs.create(B1kSltFG);
				IOUtils.copyBytes(W1wswCOT, usaoIzYZ, DTrfSNWP);
			} catch (IOException rGvL9Ces) {
				IOUtils.closeStream(usaoIzYZ);
				IOUtils.closeStream(W1wswCOT);
				throw rGvL9Ces;
			}
		} else {
			throw new IOException(JqxXO5vC.toString() + ": No such file or directory");
		}
		if (XuV5XnBF) {
			return FileUtil.fullyDelete(JqxXO5vC);
		} else {
			return true;
		}
	}

}