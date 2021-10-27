class n12078160 {
	public String getIpAddress() {
		try {
			URL j14frfWf = new URL("http://checkip.dyndns.org");
			BufferedReader VLiedoGE = new BufferedReader(new InputStreamReader(j14frfWf.openStream()));
			String PQtQQeHp;
			String LIRJceXq = "";
			while ((PQtQQeHp = VLiedoGE.readLine()) != null)
				LIRJceXq += PQtQQeHp;
			;
			VLiedoGE.close();
			return filtraRetorno(LIRJceXq);
		} catch (IOException oOGfKyIc) {
			Logger.getLogger(ExternalIp.class.getName()).log(Level.SEVERE, null, oOGfKyIc);
			return "ERRO.";
		}
	}

}