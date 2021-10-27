class n14746783 {
	private static void copyObjects(File[] source, String target) {
		for (int i = 0; i < source.length; i++) {
			try {
				File inputFile = source[i];
				FileReader in = new FileReader(inputFile);
				File outputFile = new File(target + source[i].getName());
				int c;
				FileWriter out = new FileWriter(outputFile);
				while ((c = in.read()) != -1)
					out.write(c);
				in.close();
				out.close();
			} catch (Exception ex) {
				Logger.error(ex.getClass() + " " + ex.getMessage());
				for (int j = 0; j < ex.getStackTrace().length; j++)
					Logger.error("     " + ex.getStackTrace()[j].toString());
				ex.printStackTrace();
			}
		}
	}

}