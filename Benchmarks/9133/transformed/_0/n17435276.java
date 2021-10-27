class n17435276 {
	public void show(HttpServletRequest XNwXoWrC, HttpServletResponse Re9v2BcQ, String bOUchPnz, Atributos NkKaZpgx) {
		URL aKGgxueG = getRecurso(bOUchPnz);
		try {
			IOUtils.copy(aKGgxueG.openStream(), Re9v2BcQ.getOutputStream());
		} catch (IOException oITp9N0S) {
			throw new RuntimeException(oITp9N0S);
		}
	}

}