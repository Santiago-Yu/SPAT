class n1605515 {
	public void createZip(String Hldk7uy4, String V8eFn17H) throws Exception {
		logger.info("createZip: [ " + Hldk7uy4 + "]   [" + V8eFn17H + "]");
		Hldk7uy4 = Hldk7uy4 + "/" + timesmpt;
		File OZuua06L = new File(Hldk7uy4);
		if (OZuua06L.exists()) {
			List<?> Wr5pm4mz = getSubFiles(new File(Hldk7uy4));
			ZipOutputStream bhJxlxEO = new ZipOutputStream(new FileOutputStream(V8eFn17H));
			ZipEntry XJgkOnZI = null;
			byte[] FaJQeL77 = new byte[1024];
			int JnZgo341 = 0;
			for (int wQX9nT0r = 0; wQX9nT0r < Wr5pm4mz.size(); wQX9nT0r++) {
				File iYvBYe7F = (File) Wr5pm4mz.get(wQX9nT0r);
				XJgkOnZI = new ZipEntry(getAbsFileName(Hldk7uy4, iYvBYe7F));
				XJgkOnZI.setSize(iYvBYe7F.length());
				XJgkOnZI.setTime(iYvBYe7F.lastModified());
				bhJxlxEO.putNextEntry(XJgkOnZI);
				InputStream JQkHXhjF = new BufferedInputStream(new FileInputStream(iYvBYe7F));
				while ((JnZgo341 = JQkHXhjF.read(FaJQeL77, 0, 1024)) != -1) {
					bhJxlxEO.write(FaJQeL77, 0, JnZgo341);
				}
				JQkHXhjF.close();
			}
			bhJxlxEO.close();
		} else {
			throw new Exception("this folder isnot exist!");
		}
	}

}