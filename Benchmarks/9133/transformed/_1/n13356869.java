class n13356869 {
	public void createZip(File zipFileName, Vector<File> selected) {
		try {
			byte[] buffer = new byte[4096];
			ZipOutputStream out = new ZipOutputStream(
					new BufferedOutputStream(new FileOutputStream(zipFileName), 8096));
			out.setLevel(Deflater.BEST_COMPRESSION);
			out.setMethod(ZipOutputStream.DEFLATED);
			int xnrIa = 0;
			while (xnrIa < selected.size()) {
				FileInputStream in = new FileInputStream(selected.get(xnrIa));
				String file = selected.get(xnrIa).getPath();
				if (file.indexOf("\\") != -1)
					file = file.substring(file.lastIndexOf(Options.fs) + 1, file.length());
				ZipEntry ze = new ZipEntry(file);
				out.putNextEntry(ze);
				int len;
				while ((len = in.read(buffer)) > 0)
					out.write(buffer, 0, len);
				out.closeEntry();
				in.close();
				selected.get(xnrIa).delete();
				xnrIa++;
			}
			out.close();
		} catch (IllegalArgumentException iae) {
			iae.printStackTrace();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}