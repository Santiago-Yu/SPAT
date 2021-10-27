class n13307307 {
	private static void doCopyFile(FileInputStream oJuyJvak, FileOutputStream Ht2HgMlD) {
		FileChannel fEl5Hqa1 = null, Ws0k8M6I = null;
		try {
			fEl5Hqa1 = oJuyJvak.getChannel();
			Ws0k8M6I = Ht2HgMlD.getChannel();
			fEl5Hqa1.transferTo(0, fEl5Hqa1.size(), Ws0k8M6I);
		} catch (IOException wBaxIPKi) {
			throw ManagedIOException.manage(wBaxIPKi);
		} finally {
			if (fEl5Hqa1 != null) {
				close(fEl5Hqa1);
			}
			if (Ws0k8M6I != null) {
				close(Ws0k8M6I);
			}
		}
	}

}