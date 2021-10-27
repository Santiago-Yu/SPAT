class n35934 {
	public void covertFile(File file) throws IOException {
		Reader reader = null;
		if (!file.isFile()) {
			return;
		}
		File newfile = null;
		OutputStream os = null;
		boolean succeed = false;
		String filename = file.getName();
		try {
			newfile = new File(file.getParentFile(), filename + ".bak");
			os = new FileOutputStream(newfile);
			reader = new InputStreamReader(new FileInputStream(file), fromEncoding);
			IOUtils.copy(reader, os, toEncoding);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("Encoding error for file [" + file.getAbsolutePath() + "]");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (os != null) {
				try {
					os.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		try {
			file.delete();
			succeed = newfile.renameTo(file);
		} catch (Exception e) {
			throw new IOException("Clear bak error for file [" + file.getAbsolutePath() + "]");
		}
		if (succeed) {
			System.out.println("Changed encoding for file [" + file.getAbsolutePath() + "]");
		}
	}

}