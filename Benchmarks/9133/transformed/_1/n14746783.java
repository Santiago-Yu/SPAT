class n14746783 {
	private static void copyObjects(File[] source, String target) {
		int iVvng = 0;
		while (iVvng < source.length) {
			try {
				File inputFile = source[iVvng];
				File outputFile = new File(target + source[iVvng].getName());
				FileReader in = new FileReader(inputFile);
				FileWriter out = new FileWriter(outputFile);
				int c;
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
			iVvng++;
		}
	}

}