class n13843203 {
	private void downloadFile(File QBvQCc0N, String LR1Yh431) {
		String QVOav0uk = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(QVOav0uk)) {
			InputStream OqJpmiNA = null;
			BufferedOutputStream FESfH7KA = null;
			try {
				OqJpmiNA = new BufferedInputStream(new URL(LR1Yh431).openStream(), IO_BUFFER_SIZE);
				final FileOutputStream VRGsHGPJ = new FileOutputStream(QBvQCc0N);
				FESfH7KA = new BufferedOutputStream(VRGsHGPJ, IO_BUFFER_SIZE);
				byte[] VY9fzRlo = new byte[IO_BUFFER_SIZE];
				while (OqJpmiNA.read(VY9fzRlo) > 0) {
					FESfH7KA.write(VY9fzRlo);
				}
			} catch (IOException SRtzRRP5) {
				SRtzRRP5.printStackTrace();
			} finally {
				if (OqJpmiNA != null) {
					try {
						OqJpmiNA.close();
					} catch (IOException OVqkI5KZ) {
						OVqkI5KZ.printStackTrace();
					}
				}
				if (FESfH7KA != null) {
					try {
						FESfH7KA.close();
					} catch (IOException eAJMeFt8) {
						eAJMeFt8.printStackTrace();
					}
				}
			}
		}
	}

}