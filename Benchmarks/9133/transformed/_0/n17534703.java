class n17534703 {
	public static void copy(String amHCzRZS, String L1CCNt7A) throws IOException {
		File mTJME5qi = new File(amHCzRZS);
		File kYpu3Xkh = new File(L1CCNt7A);
		if (!mTJME5qi.exists())
			throw new IOException("FileCopy: " + "no such source file: " + amHCzRZS);
		if (!mTJME5qi.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + amHCzRZS);
		if (!mTJME5qi.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + amHCzRZS);
		if (kYpu3Xkh.isDirectory())
			kYpu3Xkh = new File(kYpu3Xkh, mTJME5qi.getName());
		if (kYpu3Xkh.exists()) {
			if (!kYpu3Xkh.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + L1CCNt7A);
			System.out.print("Overwrite existing file " + kYpu3Xkh.getName() + "? (Y/N): ");
			System.out.flush();
			BufferedReader KBSltYJW = new BufferedReader(new InputStreamReader(System.in));
			String H9wcN7ea = KBSltYJW.readLine();
			if (!H9wcN7ea.equals("Y") && !H9wcN7ea.equals("y"))
				throw new IOException("FileCopy: " + "existing file was not overwritten.");
		} else {
			String SVm29Vvj = kYpu3Xkh.getParent();
			if (SVm29Vvj == null)
				SVm29Vvj = System.getProperty("user.dir");
			File DjjYo5gU = new File(SVm29Vvj);
			if (!DjjYo5gU.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + SVm29Vvj);
			if (DjjYo5gU.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + SVm29Vvj);
			if (!DjjYo5gU.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + SVm29Vvj);
		}
		FileInputStream wIZ9srvW = null;
		FileOutputStream BKT228vR = null;
		try {
			wIZ9srvW = new FileInputStream(mTJME5qi);
			BKT228vR = new FileOutputStream(kYpu3Xkh);
			byte[] u9IKIumT = new byte[4096];
			int yhATLAZZ;
			while ((yhATLAZZ = wIZ9srvW.read(u9IKIumT)) != -1)
				BKT228vR.write(u9IKIumT, 0, yhATLAZZ);
		} finally {
			if (wIZ9srvW != null)
				try {
					wIZ9srvW.close();
				} catch (IOException SuoVV08a) {
					;
				}
			if (BKT228vR != null)
				try {
					BKT228vR.close();
				} catch (IOException v6TKUNN5) {
					;
				}
		}
	}

}