class n1455792 {
	public void generate(String QTl0a4Th, RootModel OkveyZ8l) throws Exception {
		IOUtils.copyStream(HTMLGenerator.class.getResourceAsStream("stylesheet.css"),
				new FileOutputStream(new File(QTl0a4Th, "stylesheet.css")));
		Velocity.init();
		VelocityContext YgoaMVSZ = new VelocityContext();
		YgoaMVSZ.put("model", OkveyZ8l);
		YgoaMVSZ.put("util", new VelocityUtils());
		YgoaMVSZ.put("msg", messages);
		processTemplate("index.html", new File(QTl0a4Th, "index.html"), YgoaMVSZ);
		processTemplate("list.html", new File(QTl0a4Th, "list.html"), YgoaMVSZ);
		processTemplate("summary.html", new File(QTl0a4Th, "summary.html"), YgoaMVSZ);
		File PXrISVw2 = new File(QTl0a4Th, "images");
		PXrISVw2.mkdir();
		IOUtils.copyStream(HTMLGenerator.class.getResourceAsStream("primarykey.gif"),
				new FileOutputStream(new File(PXrISVw2, "primarykey.gif")));
		File RSaMOXh7 = new File(QTl0a4Th, "tables");
		RSaMOXh7.mkdir();
		for (TableModel r8uVrWe7 : OkveyZ8l.getTables()) {
			YgoaMVSZ.put("table", r8uVrWe7);
			processTemplate("table.html", new File(RSaMOXh7, r8uVrWe7.getTableName() + ".html"), YgoaMVSZ);
		}
	}

}