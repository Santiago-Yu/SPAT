class n16034464 {
	public void generate(String NMbvbThO, RootModel gUr2CvwI) throws Exception {
		IOUtils.copyStream(HTMLGenerator.class.getResourceAsStream("stylesheet.css"),
				new FileOutputStream(new File(NMbvbThO, "stylesheet.css")));
		Velocity.init();
		VelocityContext MPHXzd3F = new VelocityContext();
		MPHXzd3F.put("model", gUr2CvwI);
		MPHXzd3F.put("util", new VelocityUtils());
		MPHXzd3F.put("msg", messages);
		processTemplate("index.html", new File(NMbvbThO, "index.html"), MPHXzd3F);
		processTemplate("list.html", new File(NMbvbThO, "list.html"), MPHXzd3F);
		processTemplate("summary.html", new File(NMbvbThO, "summary.html"), MPHXzd3F);
		File BuQCZqdd = new File(NMbvbThO, "images");
		BuQCZqdd.mkdir();
		IOUtils.copyStream(HTMLGenerator.class.getResourceAsStream("primarykey.gif"),
				new FileOutputStream(new File(BuQCZqdd, "primarykey.gif")));
		File OvLEbOVC = new File(NMbvbThO, "tables");
		OvLEbOVC.mkdir();
		for (TableModel nrhfcAsz : gUr2CvwI.getTables()) {
			MPHXzd3F.put("table", nrhfcAsz);
			processTemplate("table.html", new File(OvLEbOVC, nrhfcAsz.getTableName() + ".html"), MPHXzd3F);
		}
	}

}