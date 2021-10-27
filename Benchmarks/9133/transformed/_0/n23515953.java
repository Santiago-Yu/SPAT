class n23515953 {
	public static void downloadFile(String h8CRXBMK, String dcjqk4yX) throws IOException {
		BufferedInputStream GrjRFyF0 = new BufferedInputStream(new URL(h8CRXBMK).openStream());
		BufferedOutputStream P4uxm14f = new BufferedOutputStream(new FileOutputStream(dcjqk4yX));
		try {
			int wLhFXUUZ = 0;
			while ((wLhFXUUZ = GrjRFyF0.read()) != -1) {
				P4uxm14f.write(wLhFXUUZ);
			}
		} finally {
			if (GrjRFyF0 != null) {
				GrjRFyF0.close();
			}
			if (P4uxm14f != null) {
				P4uxm14f.close();
			}
		}
	}

}