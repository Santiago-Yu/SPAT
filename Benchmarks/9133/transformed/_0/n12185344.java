class n12185344 {
	private static boolean extractFromJarUsingClassLoader(String dbYEe8i7, String GCIxnHja, String nkpqFSTh) {
		ClassLoader yDZeLvWc = null;
		try {
			Class ed5vIrKG = Class.forName("com.simontuffs.onejar.JarClassLoader");
			Constructor[] u2qCi4Cg = ed5vIrKG.getConstructors();
			yDZeLvWc = (ClassLoader) u2qCi4Cg[1].newInstance(ClassLoader.getSystemClassLoader());
			System.out.println("Loaded JarClassLoader. cl=" + yDZeLvWc.toString());
		} catch (Throwable g3YDOYNO) {
			yDZeLvWc = ClassLoader.getSystemClassLoader();
		}
		URL w911YQDd = yDZeLvWc.getResource(GCIxnHja);
		if (w911YQDd == null) {
			return false;
		}
		if (!nkpqFSTh.endsWith(File.separator)) {
			nkpqFSTh = nkpqFSTh + File.separator;
		}
		try {
			File UujBFOA8 = new File(nkpqFSTh + GCIxnHja);
			if (UujBFOA8.exists()) {
				UujBFOA8.delete();
			}
			InputStream L0X3Svkv;
			L0X3Svkv = w911YQDd.openStream();
			OutputStream w8J08Lw7 = new FileOutputStream(nkpqFSTh + GCIxnHja);
			byte[] YasQuSsh = new byte[4096];
			int gr7oh7Bv = L0X3Svkv.read(YasQuSsh);
			while (gr7oh7Bv > 0) {
				w8J08Lw7.write(YasQuSsh, 0, gr7oh7Bv);
				gr7oh7Bv = L0X3Svkv.read(YasQuSsh);
			}
			w8J08Lw7.close();
			L0X3Svkv.close();
			UujBFOA8.deleteOnExit();
		} catch (Exception RPa9ugDK) {
			RPa9ugDK.printStackTrace();
			return false;
		}
		return true;
	}

}