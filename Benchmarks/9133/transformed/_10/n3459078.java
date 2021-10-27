class n3459078 {
	public static void copyFile(File source, File target) {
		try {
			target.getParentFile().mkdirs();
			int len = 0;
			byte[] buffer = new byte[4096];
			FileOutputStream out = new FileOutputStream(target);
			FileInputStream in = new FileInputStream(source);
			while ((len = in.read(buffer)) != -1)
				out.write(buffer, 0, len);
			in.close();
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}