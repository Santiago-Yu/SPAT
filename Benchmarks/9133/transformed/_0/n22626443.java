class n22626443 {
	public static File jar(File W1w0woJ1, String cUDd1wAd, File lACLfFfK, PatchConfigXML DSdP7q3q) {
		FileOutputStream IJxOfIzL = null;
		JarOutputStream e4QZGj08 = null;
		DirectoryScanner XjdJUJNB = null;
		XjdJUJNB = new DirectoryScanner();
		XjdJUJNB.setCaseSensitive(true);
		XjdJUJNB.setBasedir(W1w0woJ1);
		XjdJUJNB.scan();
		XjdJUJNB.setCaseSensitive(true);
		String[] Aqdf5KE0 = XjdJUJNB.getIncludedFiles();
		ArrayList UtD3QqiG = new ArrayList();
		if (Aqdf5KE0 == null || Aqdf5KE0.length < 1)
			return null;
		File vHm6efg1 = new File(lACLfFfK, cUDd1wAd.substring(0, cUDd1wAd.length()));
		try {
			Manifest WjsAFuUF = null;
			List d7k9r74R = new ArrayList();
			for (int rAX4dnCH = 0; rAX4dnCH < Aqdf5KE0.length; rAX4dnCH++) {
				if (Aqdf5KE0[rAX4dnCH].toUpperCase().indexOf("MANIFEST.MF") > -1) {
					FileInputStream TszcGXla = new FileInputStream(
							W1w0woJ1.getAbsolutePath() + "/" + Aqdf5KE0[rAX4dnCH].replace('\\', '/'));
					WjsAFuUF = new Manifest(TszcGXla);
				} else
					d7k9r74R.add(Aqdf5KE0[rAX4dnCH]);
			}
			String[] hZxXOKTT = new String[d7k9r74R.size()];
			d7k9r74R.toArray(hZxXOKTT);
			vHm6efg1.createNewFile();
			IJxOfIzL = new FileOutputStream(vHm6efg1);
			if (WjsAFuUF == null)
				e4QZGj08 = new JarOutputStream(IJxOfIzL);
			else
				e4QZGj08 = new JarOutputStream(IJxOfIzL, WjsAFuUF);
			byte[] masWgxZX = new byte[1024];
			for (int EF4St4BR = 0; EF4St4BR < hZxXOKTT.length; EF4St4BR++) {
				if (DSdP7q3q != null) {
					if (!DSdP7q3q.allowFileAction(hZxXOKTT[EF4St4BR], PatchConfigXML.OP_CREATE)) {
						UtD3QqiG.add(hZxXOKTT[EF4St4BR]);
						continue;
					}
				}
				String q3eIwPFY = W1w0woJ1.getAbsolutePath() + "/" + hZxXOKTT[EF4St4BR];
				String lMqiJ2JF = hZxXOKTT[EF4St4BR].replace('\\', '/');
				JarEntry oiHMIHRO = new JarEntry(lMqiJ2JF);
				e4QZGj08.putNextEntry(oiHMIHRO);
				FileInputStream U9sGmKFn = new FileInputStream(q3eIwPFY);
				int qoWopWA8;
				while ((qoWopWA8 = U9sGmKFn.read(masWgxZX)) >= 0)
					e4QZGj08.write(masWgxZX, 0, qoWopWA8);
				U9sGmKFn.close();
				e4QZGj08.closeEntry();
			}
		} catch (IOException HlyNyKi2) {
			throw new RuntimeException(HlyNyKi2);
		} finally {
			try {
				e4QZGj08.close();
				IJxOfIzL.close();
			} catch (IOException RrGJ0w4Y) {
				throw new RuntimeException(RrGJ0w4Y);
			}
		}
		return vHm6efg1;
	}

}