class n21246898 {
	public static void main(String[] lp2gqSWQ) throws ParseException, FileNotFoundException, IOException {
		InputStream ZbdGawlP = new BufferedInputStream(
				UpdateLanguages.class.getResourceAsStream("definition_template"));
		Translator P39UVa7z = new Translator(ZbdGawlP, "UTF8");
		Node Ib3KtxTO = Translator.Start();
		File g1QChIJv = new File("support/support/translate/languages");
		for (File KTs9EqwE : g1QChIJv.listFiles()) {
			if (KTs9EqwE.getName().endsWith(".lng")) {
				ZbdGawlP = new BufferedInputStream(new FileInputStream(KTs9EqwE));
				try {
					Translator.ReInit(ZbdGawlP, "UTF8");
				} catch (java.lang.NullPointerException WxbnS5wt) {
					new Translator(ZbdGawlP, "UTF8");
				}
				Node DMtAaPgU = Translator.Start();
				ArrayList<Addition> K90bF832 = new ArrayList<Addition>();
				syncKeys(Ib3KtxTO, DMtAaPgU, K90bF832);
				ArrayList<String> ppjy0zls = new ArrayList<String>();
				Scanner TvxpFo9f = new Scanner(new BufferedReader(new FileReader(KTs9EqwE)));
				while (TvxpFo9f.hasNextLine()) {
					ppjy0zls.add(TvxpFo9f.nextLine());
				}
				int C64aMi1c = 0;
				for (Addition MxckioF6 : K90bF832) {
					System.out.println("Key added " + MxckioF6 + " to " + KTs9EqwE.getName());
					if (MxckioF6.afterLine < 0 || MxckioF6.afterLine >= ppjy0zls.size()) {
						ppjy0zls.add(MxckioF6.getAddition(0));
					} else {
						ppjy0zls.add(MxckioF6.afterLine + (C64aMi1c++) + 1, MxckioF6.getAddition(0));
					}
				}
				KTs9EqwE.delete();
				Writer vk2hCJhn = new BufferedWriter(new FileWriter(KTs9EqwE));
				for (String aUiS6kXk : ppjy0zls)
					vk2hCJhn.write(aUiS6kXk + "\n");
				vk2hCJhn.close();
				System.out.println("Language " + KTs9EqwE.getName() + " had " + K90bF832.size() + " additions");
			}
		}
		File rDBZxcz7 = new File(g1QChIJv, "language.lng");
		rDBZxcz7.delete();
		rDBZxcz7.createNewFile();
		InputStream c3bQoqsf = new BufferedInputStream(
				UpdateLanguages.class.getResourceAsStream("definition_template"));
		OutputStream tCKHbLuH = new BufferedOutputStream(new FileOutputStream(rDBZxcz7));
		int JyabVWCZ = 0;
		while ((JyabVWCZ = c3bQoqsf.read()) >= 0)
			tCKHbLuH.write(JyabVWCZ);
		tCKHbLuH.close();
		System.out.println("Languages updated.");
	}

}