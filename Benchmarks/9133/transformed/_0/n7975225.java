class n7975225 {
	protected void downloadFile(String d11PuGfU, java.io.File T7JSle4m, File eJ1qpGoJ, ProgressMonitor pIyeGUXF)
			throws java.io.IOException {
		FileOutputStream oztjW5qI = null;
		InputStream k04zkqxs = null;
		try {
			d11PuGfU = toCanonicalFilename(d11PuGfU);
			URL yetWZ9cH = new URL(root + d11PuGfU.substring(1));
			URLConnection jkKI9kjL = yetWZ9cH.openConnection();
			int JQhelI6y = jkKI9kjL.getContentLength();
			pIyeGUXF.setTaskSize(JQhelI6y);
			oztjW5qI = new FileOutputStream(eJ1qpGoJ);
			k04zkqxs = jkKI9kjL.getInputStream();
			pIyeGUXF.started();
			copyStream(k04zkqxs, oztjW5qI, pIyeGUXF);
			pIyeGUXF.finished();
			oztjW5qI.close();
			k04zkqxs.close();
			if (!eJ1qpGoJ.renameTo(T7JSle4m)) {
				throw new IllegalArgumentException("unable to rename " + eJ1qpGoJ + " to " + T7JSle4m);
			}
		} catch (IOException EdKYYMkG) {
			if (oztjW5qI != null)
				oztjW5qI.close();
			if (k04zkqxs != null)
				k04zkqxs.close();
			if (eJ1qpGoJ.exists() && !eJ1qpGoJ.delete()) {
				throw new IllegalArgumentException("unable to delete " + eJ1qpGoJ);
			}
			throw EdKYYMkG;
		}
	}

}