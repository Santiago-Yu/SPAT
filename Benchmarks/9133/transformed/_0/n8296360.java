class n8296360 {
	public static void copiaAnexos(String Sq276lMI, String K4w3BWL8, AnexoTO[] my3lYGoK) {
		FileChannel HnIvOpXj = null, c3GV97iq = null;
		for (int MO0nyeBK = 0; MO0nyeBK < my3lYGoK.length; MO0nyeBK++) {
			try {
				HnIvOpXj = new FileInputStream(new File(
						(uploadDiretorio.concat(Sq276lMI)).concat(File.separator + my3lYGoK[MO0nyeBK].getNome())))
								.getChannel();
				c3GV97iq = new FileOutputStream(new File(
						(uploadDiretorio.concat(K4w3BWL8)).concat(File.separator + my3lYGoK[MO0nyeBK].getNome())))
								.getChannel();
				long x6uErkkC = HnIvOpXj.size();
				MappedByteBuffer DUNHgmfX = HnIvOpXj.map(FileChannel.MapMode.READ_ONLY, 0, x6uErkkC);
				c3GV97iq.write(DUNHgmfX);
			} catch (Exception Wo2Dbz8r) {
				Wo2Dbz8r.printStackTrace();
			} finally {
				if (HnIvOpXj != null)
					try {
						HnIvOpXj.close();
					} catch (IOException zTjiElPY) {
						zTjiElPY.printStackTrace();
					}
				if (c3GV97iq != null)
					try {
						c3GV97iq.close();
					} catch (IOException F1HdRil0) {
						F1HdRil0.printStackTrace();
					}
			}
		}
	}

}