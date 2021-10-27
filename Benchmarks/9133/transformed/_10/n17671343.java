class n17671343 {
	public void unzip(String zipFileName, String outputDirectory) throws Exception {
		ZipEntry z;
		ZipInputStream in = new ZipInputStream(new FileInputStream(zipFileName));
		while ((z = in.getNextEntry()) != null) {
			System.out.println("unziping " + z.getName());
			if (z.isDirectory()) {
				String name = z.getName();
				name = name.substring(0, name.length() - 1);
				File f = new File(outputDirectory + File.separator + name);
				f.mkdir();
				System.out.println("mkdir " + outputDirectory + File.separator + name);
			} else {
				File f = new File(outputDirectory + File.separator + z.getName());
				f.createNewFile();
				int b;
				FileOutputStream out = new FileOutputStream(f);
				while ((b = in.read()) != -1)
					out.write(b);
				out.close();
			}
		}
		in.close();
	}

}