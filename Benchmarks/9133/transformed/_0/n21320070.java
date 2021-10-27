class n21320070 {
	public static void copy(File yGfNSTG2, File lLe6KAFd) throws IOException {
		if (!yGfNSTG2.exists()) {
			throw new IOException("FileCopy: no such source file: " + yGfNSTG2.getPath());
		}
		if (!yGfNSTG2.isFile()) {
			throw new IOException("FileCopy: can't copy directory: " + yGfNSTG2.getPath());
		}
		if (!yGfNSTG2.canRead()) {
			throw new IOException("FileCopy: source file is unreadable: " + yGfNSTG2.getPath());
		}
		if (lLe6KAFd.isDirectory()) {
			lLe6KAFd = new File(lLe6KAFd, yGfNSTG2.getName());
		}
		if (lLe6KAFd.exists()) {
			if (!lLe6KAFd.canWrite()) {
				throw new IOException("FileCopy: destination file is unwriteable: " + lLe6KAFd.getPath());
			}
			int M9d8MGuN = JOptionPane.showConfirmDialog(null, "Overwrite existing file " + lLe6KAFd.getPath(),
					"File Exists", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (M9d8MGuN != JOptionPane.YES_OPTION) {
				throw new IOException("FileCopy: existing file was not overwritten.");
			}
		} else {
			String CQLILk7i = lLe6KAFd.getParent();
			if (CQLILk7i == null) {
				CQLILk7i = Globals.getDefaultPath();
			}
			File BDEomRaA = new File(CQLILk7i);
			if (!BDEomRaA.exists()) {
				throw new IOException("FileCopy: destination directory doesn't exist: " + CQLILk7i);
			}
			if (BDEomRaA.isFile()) {
				throw new IOException("FileCopy: destination is not a directory: " + CQLILk7i);
			}
			if (!BDEomRaA.canWrite()) {
				throw new IOException("FileCopy: destination directory is unwriteable: " + CQLILk7i);
			}
		}
		FileInputStream lYxJaASf = null;
		FileOutputStream LojhLkhU = null;
		try {
			lYxJaASf = new FileInputStream(yGfNSTG2);
			LojhLkhU = new FileOutputStream(lLe6KAFd);
			byte[] Qw55ELQB = new byte[4096];
			int Jz1OlmQh;
			while ((Jz1OlmQh = lYxJaASf.read(Qw55ELQB)) != -1) {
				LojhLkhU.write(Qw55ELQB, 0, Jz1OlmQh);
			}
		} finally {
			if (lYxJaASf != null) {
				try {
					lYxJaASf.close();
				} catch (IOException nKz2L7u8) {
				}
			}
			if (LojhLkhU != null) {
				try {
					LojhLkhU.close();
				} catch (IOException NHgOQzAX) {
				}
			}
		}
	}

}