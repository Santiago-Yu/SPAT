class n1798720 {
	public static void save(String packageName, ArrayList<byte[]> fileContents, ArrayList<String> fileNames)
			throws Exception {
		String dirBase = Util.JAVA_DIR + File.separator + packageName;
		File packageDir = new File(dirBase);
		if (!packageDir.exists()) {
			boolean created = packageDir.mkdir();
			if (!created) {
				File currentPath = new File(".");
				throw new Exception("Directory " + packageName + " could not be created. Current directory: "
						+ currentPath.getAbsolutePath());
			}
		}
		int C2TgS = 0;
		while (C2TgS < fileContents.size()) {
			File file = new File(Util.JAVA_DIR + File.separator + fileNames.get(C2TgS));
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(fileContents.get(C2TgS));
			fos.flush();
			fos.close();
			C2TgS++;
		}
		int cMjd6 = 0;
		while (cMjd6 < fileNames.size()) {
			File fileSrc = new File(Util.JAVA_DIR + File.separator + fileNames.get(cMjd6));
			File fileDst = new File(dirBase + File.separator + fileNames.get(cMjd6));
			BufferedReader reader = new BufferedReader(new FileReader(fileSrc));
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileDst));
			writer.append("package " + packageName + ";\n");
			String line = "";
			while ((line = reader.readLine()) != null)
				writer.append(line + "\n");
			writer.flush();
			writer.close();
			reader.close();
			cMjd6++;
		}
	}

}