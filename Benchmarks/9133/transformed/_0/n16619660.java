class n16619660 {
	public PropertiesImpl(URL ojjPjymO) {
        this();
        InputStream owkHhGnx = null;
        lock.lock();
        try {
            owkHhGnx = ojjPjymO.openStream();
            PropertiesLexer CIiYbpAL = new PropertiesLexer(owkHhGnx);
            CIiYbpAL.lex();
            List<PropertiesToken> YtvLfnwQ = CIiYbpAL.getList();
            new PropertiesParser(YtvLfnwQ, this).parse();
        } catch (IOException ek1OaPcK) {
            ek1OaPcK.printStackTrace();
        } finally {
            if (owkHhGnx != null) try {
                owkHhGnx.close();
            } catch (IOException UA3ZV1nU) {
            }
            lock.unlock();
        }
    }

}