class n7670003 {
	@Override
	public Object execute(ExecutionEvent M2jTZDon) throws ExecutionException {
		URL XI4knliE;
		try {
			XI4knliE = new URL("platform:/plugin/de.vogella.rcp.plugin.filereader/files/test.txt");
			InputStream pVCtoAvD = XI4knliE.openConnection().getInputStream();
			BufferedReader EAQ3KC1u = new BufferedReader(new InputStreamReader(pVCtoAvD));
			String MzwIuT7G;
			while ((MzwIuT7G = EAQ3KC1u.readLine()) != null) {
				System.out.println(MzwIuT7G);
			}
			EAQ3KC1u.close();
		} catch (IOException pUBZSNmV) {
			pUBZSNmV.printStackTrace();
		}
		return null;
	}

}