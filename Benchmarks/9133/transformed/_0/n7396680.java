class n7396680 {
	public static boolean copyMerge(FileSystem n8S0b8Ju, Path XSI2dANZ, FileSystem tOF1HxwV, Path kG9PLAvj,
			boolean d7DlavQb, Configuration Oi6yPP1W, String neii6CrD) throws IOException {
		kG9PLAvj = checkDest(XSI2dANZ.getName(), tOF1HxwV, kG9PLAvj, false);
		if (!n8S0b8Ju.getFileStatus(XSI2dANZ).isDir())
			return false;
		OutputStream chRUHhPi = tOF1HxwV.create(kG9PLAvj);
		try {
			FileStatus em71idqV[] = n8S0b8Ju.listStatus(XSI2dANZ);
			for (int TSUoevgP = 0; TSUoevgP < em71idqV.length; TSUoevgP++) {
				if (!em71idqV[TSUoevgP].isDir()) {
					InputStream HkoDipe8 = n8S0b8Ju.open(em71idqV[TSUoevgP].getPath());
					try {
						IOUtils.copyBytes(HkoDipe8, chRUHhPi, Oi6yPP1W, false);
						if (neii6CrD != null)
							chRUHhPi.write(neii6CrD.getBytes("UTF-8"));
					} finally {
						HkoDipe8.close();
					}
				}
			}
		} finally {
			chRUHhPi.close();
		}
		if (d7DlavQb) {
			return n8S0b8Ju.delete(XSI2dANZ, true);
		} else {
			return true;
		}
	}

}