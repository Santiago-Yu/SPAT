class n10840966 {
	public void copy(String sourcePath, String targetPath) throws IOException {
		File targetFile = new File(targetPath);
		File sourceFile = new File(sourcePath);
		FileOutputStream fileOutputStream = null;
		FileInputStream fileInputStream = null;
		try {
			fileOutputStream = new FileOutputStream(targetFile);
			fileInputStream = new FileInputStream(sourceFile);
			int bytesRead;
			byte[] buffer = new byte[4096];
			while ((bytesRead = fileInputStream.read(buffer)) != -1)
				fileOutputStream.write(buffer, 0, bytesRead);
		} finally {
			if (fileInputStream != null)
				try {
					fileInputStream.close();
				} catch (IOException exception) {
					JOptionPane.showMessageDialog(null,
							AcideLanguageManager.getInstance().getLabels().getString("s265") + sourcePath,
							AcideLanguageManager.getInstance().getLabels().getString("s266"),
							JOptionPane.ERROR_MESSAGE);
					AcideLog.getLog().error(exception.getMessage());
				}
			if (fileOutputStream != null)
				try {
					fileOutputStream.close();
				} catch (IOException exception) {
					JOptionPane.showMessageDialog(null,
							AcideLanguageManager.getInstance().getLabels().getString("s267") + targetPath,
							AcideLanguageManager.getInstance().getLabels().getString("268"), JOptionPane.ERROR_MESSAGE);
					AcideLog.getLog().error(exception.getMessage());
				}
		}
	}

}