class n18431646 {
	public Savable loadResource(String ayz3BEgr, PrimitiveLoader O7uzG00F) {
		Savable jqE0uNhO = null;
		URL yK5U99YV = ResourceLocator.locateFile(O7uzG00F.getBaseFolder(), ayz3BEgr, O7uzG00F.getCompiledExtension());
		if (yK5U99YV == null) {
			yK5U99YV = ResourceLocator.locateFile(O7uzG00F.getBaseFolder(), ayz3BEgr, O7uzG00F.getPrimitiveExtension());
			if (yK5U99YV != null) {
				try {
					jqE0uNhO = O7uzG00F.loadResource(ayz3BEgr, yK5U99YV.openStream());
					File gh4E6UXT = ResourceLocator.replaceExtension(yK5U99YV, O7uzG00F.getCompiledExtension());
					BinaryExporter.getInstance().save(jqE0uNhO, gh4E6UXT);
				} catch (IOException dqOwlIQD) {
					dqOwlIQD.printStackTrace();
				} catch (URISyntaxException GikeLxan) {
					GikeLxan.printStackTrace();
				}
			}
		} else {
			try {
				jqE0uNhO = BinaryImporter.getInstance().load(yK5U99YV.openStream());
			} catch (IOException A4k2Kpwy) {
				A4k2Kpwy.printStackTrace();
			}
		}
		return jqE0uNhO;
	}

}