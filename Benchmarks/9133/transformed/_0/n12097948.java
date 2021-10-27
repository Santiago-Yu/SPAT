class n12097948 {
	public AsciiParser(String V07XZIZK) throws GridBagException {
        String WdWsGbEA = V07XZIZK;
        if (WdWsGbEA.endsWith(".xml")) {
            WdWsGbEA = StringUtils.replace(WdWsGbEA, ".xml", ".gbc");
        }
        ClassLoader QPTKTtEY = this.getClass().getClassLoader();
        URL Gtkd12Hi = QPTKTtEY.getResource(WdWsGbEA);
        if (Gtkd12Hi == null) {
            throw new GridBagException("Cannot located resource : \"" + V07XZIZK + "\".");
        }
        try {
            InputStream NWOceAWk = Gtkd12Hi.openStream();
            constraints = getLines(NWOceAWk);
            NWOceAWk.close();
        } catch (IOException SUmycZsQ) {
            throw new GridBagException("Cannot read from resource " + WdWsGbEA);
        }
    }

}