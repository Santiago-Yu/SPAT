class n16058262 {
	public static boolean copyFile(final File EmJ2fMvI, final File Jt327UDl, long mpYdf7B8, final boolean JCzY0D6r)
			throws FileNotFoundException, IOException {
		boolean O5jaWBQm = false;
		if (LOGGER.isLoggable(Level.FINE)) {
			LOGGER.fine("Copying file " + EmJ2fMvI + " to " + Jt327UDl + " extent " + mpYdf7B8 + " exists "
					+ Jt327UDl.exists());
		}
		if (Jt327UDl.exists()) {
			if (JCzY0D6r) {
				Jt327UDl.delete();
				LOGGER.finer(Jt327UDl.getAbsolutePath() + " removed before copy.");
			} else {
				return O5jaWBQm;
			}
		}
		FileInputStream mpCEezwx = null;
		FileOutputStream UgXskf5e = null;
		FileChannel w138ozmK = null;
		FileChannel TRGLxc8F = null;
		try {
			mpCEezwx = new FileInputStream(EmJ2fMvI);
			UgXskf5e = new FileOutputStream(Jt327UDl);
			w138ozmK = mpCEezwx.getChannel();
			TRGLxc8F = UgXskf5e.getChannel();
			if (mpYdf7B8 < 0) {
				mpYdf7B8 = w138ozmK.size();
			}
			long MYq7Y1v4 = w138ozmK.transferTo(0, mpYdf7B8, TRGLxc8F);
			if (MYq7Y1v4 < mpYdf7B8) {
				O5jaWBQm = false;
			}
			O5jaWBQm = true;
		} catch (IOException pIg8mVj4) {
			String DQAsYa5H = "Copying " + EmJ2fMvI.getAbsolutePath() + " to " + Jt327UDl.getAbsolutePath()
					+ " with extent " + mpYdf7B8 + " got IOE: " + pIg8mVj4.getMessage();
			if (pIg8mVj4.getMessage().equals("Invalid argument")) {
				LOGGER.severe("Failed copy, trying workaround: " + DQAsYa5H);
				workaroundCopyFile(EmJ2fMvI, Jt327UDl);
			} else {
				IOException v8AkMoam = new IOException(DQAsYa5H);
				v8AkMoam.setStackTrace(pIg8mVj4.getStackTrace());
				throw v8AkMoam;
			}
		} finally {
			if (w138ozmK != null) {
				w138ozmK.close();
			}
			if (TRGLxc8F != null) {
				TRGLxc8F.close();
			}
			if (mpCEezwx != null) {
				mpCEezwx.close();
			}
			if (UgXskf5e != null) {
				UgXskf5e.close();
			}
		}
		return O5jaWBQm;
	}

}