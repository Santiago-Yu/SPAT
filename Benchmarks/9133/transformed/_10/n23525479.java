class n23525479 {
	protected static final void copyFile(String from, String to) throws SeleniumException {
		try {
			java.io.File fileFrom = new File(from);
			FileReader in = new FileReader(fileFrom);
			java.io.File fileTo = new File(to);
			int c;
			FileWriter out = new FileWriter(fileTo);
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
		} catch (Exception e) {
			throw new SeleniumException("Failed to copy new file : " + from + " to : " + to, e);
		}
	}

}