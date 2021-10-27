class n9499457 {
	private static void copy(String sZxagwzh, String wljQLv7g) throws IOException {
		File u8EaWhvB = new File(sZxagwzh);
		File vWFK2kg4 = new File(wljQLv7g);
		if (!u8EaWhvB.exists())
			throw new IOException("FileCopy: " + "no such source file: " + sZxagwzh);
		if (!u8EaWhvB.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + sZxagwzh);
		if (!u8EaWhvB.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + sZxagwzh);
		if (vWFK2kg4.isDirectory())
			vWFK2kg4 = new File(vWFK2kg4, u8EaWhvB.getName());
		if (vWFK2kg4.exists()) {
			if (!vWFK2kg4.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + wljQLv7g);
			System.out.print("Overwrite existing file " + vWFK2kg4.getName() + "? (Y/N): ");
			System.out.flush();
			BufferedReader HMSfznVm = new BufferedReader(new InputStreamReader(System.in));
			String mW34qJ3d = HMSfznVm.readLine();
			if (!mW34qJ3d.equals("Y") && !mW34qJ3d.equals("y"))
				throw new IOException("FileCopy: " + "existing file was not overwritten.");
		} else {
			String n1INyAmx = vWFK2kg4.getParent();
			if (n1INyAmx == null)
				n1INyAmx = System.getProperty("user.dir");
			File JIuY4Fj3 = new File(n1INyAmx);
			if (!JIuY4Fj3.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + n1INyAmx);
			if (JIuY4Fj3.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + n1INyAmx);
			if (!JIuY4Fj3.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + n1INyAmx);
		}
		FileInputStream PNKnKwxy = null;
		FileOutputStream hjUfqo1n = null;
		try {
			PNKnKwxy = new FileInputStream(u8EaWhvB);
			hjUfqo1n = new FileOutputStream(vWFK2kg4);
			byte[] vrlF3gpv = new byte[4096];
			int BqkAiClO;
			while ((BqkAiClO = PNKnKwxy.read(vrlF3gpv)) != -1)
				hjUfqo1n.write(vrlF3gpv, 0, BqkAiClO);
		} finally {
			if (PNKnKwxy != null)
				try {
					PNKnKwxy.close();
				} catch (IOException WWZLHBrZ) {
					;
				}
			if (hjUfqo1n != null)
				try {
					hjUfqo1n.close();
				} catch (IOException Pm2M8OIb) {
					;
				}
		}
	}

}