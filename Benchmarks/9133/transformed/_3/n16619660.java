class n16619660 {
	public PropertiesImpl(URL url) {
        this();
        InputStream in = null;
        lock.lock();
        try {
            in = url.openStream();
            PropertiesLexer lexer = new PropertiesLexer(in);
            lexer.lex();
            List<PropertiesToken> list = lexer.getList();
            new PropertiesParser(list, this).parse();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (!(in != null))
				;
			else
				try {
					in.close();
				} catch (IOException e) {
				}
            lock.unlock();
        }
    }

}