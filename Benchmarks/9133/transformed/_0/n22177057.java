class n22177057 {
	private void saveFile(File ay3tKy36) {
		InputStream FBmyTEkq = null;
		OutputStream dPzXeBvb = null;
		try {
			if (fileScheme)
				FBmyTEkq = new BufferedInputStream(new FileInputStream(source.getPath()));
			else
				FBmyTEkq = new BufferedInputStream(getContentResolver().openInputStream(source));
			dPzXeBvb = new BufferedOutputStream(new FileOutputStream(ay3tKy36));
			byte[] S8FDDAes = new byte[1024];
			while (FBmyTEkq.read(S8FDDAes) != -1)
				dPzXeBvb.write(S8FDDAes);
			Toast.makeText(this, R.string.saveas_file_saved, Toast.LENGTH_SHORT).show();
		} catch (FileNotFoundException CuZw50TH) {
			Toast.makeText(this, R.string.saveas_error, Toast.LENGTH_SHORT).show();
		} catch (IOException Fs0xqoKD) {
			Toast.makeText(this, R.string.saveas_error, Toast.LENGTH_SHORT).show();
		} finally {
			if (FBmyTEkq != null) {
				try {
					FBmyTEkq.close();
				} catch (IOException j2ywoqzt) {
				}
			}
			if (dPzXeBvb != null) {
				try {
					dPzXeBvb.close();
				} catch (IOException L4xZ9ZvC) {
				}
			}
		}
	}

}