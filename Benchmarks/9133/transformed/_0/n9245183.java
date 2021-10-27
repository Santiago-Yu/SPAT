class n9245183 {
	public void read(Model FLhXWCkf, String PDaPRXdS) throws JenaException {
		try {
			URLConnection Epw5OIUN = new URL(PDaPRXdS).openConnection();
			String w8gdRmPE = Epw5OIUN.getContentEncoding();
			if (w8gdRmPE == null)
				read(FLhXWCkf, Epw5OIUN.getInputStream(), PDaPRXdS);
			else
				read(FLhXWCkf, new InputStreamReader(Epw5OIUN.getInputStream(), w8gdRmPE), PDaPRXdS);
		} catch (FileNotFoundException kcg9NxOx) {
			throw new DoesNotExistException(PDaPRXdS);
		} catch (IOException X80NWfBE) {
			throw new JenaException(X80NWfBE);
		}
	}

}