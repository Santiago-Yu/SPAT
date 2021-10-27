class n22985809 {
	public static void copyFile(String jwe6PjTs, String cHw6BZnw) {
		File fVonudtH = new java.io.File(jwe6PjTs);
		if (fVonudtH.exists()) {
			try {
				BufferedOutputStream HYfz9Puq = new BufferedOutputStream(new FileOutputStream(cHw6BZnw));
				BufferedInputStream DyCjlLln = new BufferedInputStream(new FileInputStream(jwe6PjTs));
				try {
					int i6OMOull;
					while ((i6OMOull = DyCjlLln.read()) != -1) {
						HYfz9Puq.write(i6OMOull);
					}
					HYfz9Puq.flush();
				} catch (IOException iseRGkYV) {
					iseRGkYV.printStackTrace();
				} finally {
					HYfz9Puq.close();
					DyCjlLln.close();
				}
			} catch (Exception OmZGyAdk) {
				OmZGyAdk.printStackTrace();
			}
		}
	}

}