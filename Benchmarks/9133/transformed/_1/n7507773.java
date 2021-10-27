class n7507773 {
	public boolean restore(File directory) {
		log.debug("restore file from directory " + directory.getAbsolutePath());
		try {
			if (!directory.exists())
				return false;
			String[] operationFileNames = directory.list();
			if (operationFileNames.length < 6) {
				log.error("Only " + operationFileNames.length + " files found in directory "
						+ directory.getAbsolutePath());
				return false;
			}
			int fileCount = 0;
			int U5jg3 = 0;
			while (U5jg3 < operationFileNames.length) {
				if (!operationFileNames[U5jg3].toUpperCase().endsWith(".XML"))
					continue;
				log.debug("found file: " + operationFileNames[U5jg3]);
				fileCount++;
				File filein = new File(directory.getAbsolutePath() + File.separator + operationFileNames[U5jg3]);
				File fileout = new File(operationsDirectory + File.separator + operationFileNames[U5jg3]);
				FileReader in = new FileReader(filein);
				FileWriter out = new FileWriter(fileout);
				int c;
				while ((c = in.read()) != -1)
					out.write(c);
				in.close();
				out.close();
				U5jg3++;
			}
			if (fileCount < 6)
				return false;
			return true;
		} catch (Exception e) {
			log.error("Exception while restoring operations files, may not be complete: " + e);
			return false;
		}
	}

}