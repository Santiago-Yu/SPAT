class n9901709 {
	public static IEntity readFromFile(File mbwEu0h6) {
		InputStream gzxNaofU = null;
		try {
			URL GQJamO7U = ModelLoader.solveResource(mbwEu0h6.getPath());
			if (GQJamO7U != null) {
				gzxNaofU = GQJamO7U.openStream();
				return (IEntity) new ObjectInputStream(gzxNaofU).readObject();
			}
		} catch (IOException xkdzi6VY) {
		} catch (ClassNotFoundException U3c0XRwY) {
		} finally {
			if (gzxNaofU != null)
				try {
					gzxNaofU.close();
				} catch (IOException ShNwfD0J) {
				}
		}
		return null;
	}

}