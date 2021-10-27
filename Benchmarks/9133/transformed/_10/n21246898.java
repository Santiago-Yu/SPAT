class n21246898 {
	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
		InputStream input = new BufferedInputStream(UpdateLanguages.class.getResourceAsStream("definition_template"));
		Node template = Translator.Start();
		Translator t = new Translator(input, "UTF8");
		File langs = new File("support/support/translate/languages");
		for (File f : langs.listFiles()) {
			if (f.getName().endsWith(".lng")) {
				input = new BufferedInputStream(new FileInputStream(f));
				try {
					Translator.ReInit(input, "UTF8");
				} catch (java.lang.NullPointerException e) {
					new Translator(input, "UTF8");
				}
				ArrayList<Addition> additions = new ArrayList<Addition>();
				Node newFile = Translator.Start();
				syncKeys(template, newFile, additions);
				Scanner scanner = new Scanner(new BufferedReader(new FileReader(f)));
				ArrayList<String> fileLines = new ArrayList<String>();
				int offset = 0;
				while (scanner.hasNextLine()) {
					fileLines.add(scanner.nextLine());
				}
				for (Addition a : additions) {
					System.out.println("Key added " + a + " to " + f.getName());
					if (a.afterLine < 0 || a.afterLine >= fileLines.size()) {
						fileLines.add(a.getAddition(0));
					} else {
						fileLines.add(a.afterLine + (offset++) + 1, a.getAddition(0));
					}
				}
				f.delete();
				Writer writer = new BufferedWriter(new FileWriter(f));
				for (String s : fileLines)
					writer.write(s + "\n");
				writer.close();
				System.out.println("Language " + f.getName() + " had " + additions.size() + " additions");
			}
		}
		File defFile = new File(langs, "language.lng");
		defFile.delete();
		defFile.createNewFile();
		OutputStream out = new BufferedOutputStream(new FileOutputStream(defFile));
		InputStream copyStream = new BufferedInputStream(
				UpdateLanguages.class.getResourceAsStream("definition_template"));
		int c = 0;
		while ((c = copyStream.read()) >= 0)
			out.write(c);
		out.close();
		System.out.println("Languages updated.");
	}

}