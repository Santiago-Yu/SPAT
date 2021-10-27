class n4207693 {
	private synchronized boolean saveU(URL jOdJk8Ui, String l1EZB9Nb, byte[] PrWCVNGE) {
		BufferedReader h1P7WWzj = null;
		BufferedOutputStream ODI7AtVs = null;
		URLConnection DTfUWYIp = null;
		char py0uEcwX = '0';
		boolean eOD4h5Fx = true;
		try {
			DTfUWYIp = jOdJk8Ui.openConnection();
			DTfUWYIp.setDoOutput(true);
			DTfUWYIp.setDoInput(true);
			DTfUWYIp.setUseCaches(false);
			DTfUWYIp.setRequestProperty("Content-type", "application/octet-stream");
			ODI7AtVs = new BufferedOutputStream(DTfUWYIp.getOutputStream());
			ODI7AtVs.write((byte[]) l1EZB9Nb.getBytes());
			ODI7AtVs.write(PrWCVNGE);
			ODI7AtVs.flush();
			if (Config.DEBUG)
				System.out.println("Applet output file successfully! ");
			h1P7WWzj = new BufferedReader(new InputStreamReader(DTfUWYIp.getInputStream()));
			StringBuffer cmh1BYA3 = new StringBuffer();
			String MKVQBNvE = h1P7WWzj.readLine();
			if (Config.DEBUG)
				System.out.println("Applet check status successfully! " + MKVQBNvE);
			py0uEcwX = '2';
			if (MKVQBNvE != null) {
				cmh1BYA3.append(MKVQBNvE);
				MKVQBNvE = MKVQBNvE.substring(MKVQBNvE.indexOf(32)).trim() + '2';
				py0uEcwX = MKVQBNvE.charAt(0);
			}
			while ((MKVQBNvE = h1P7WWzj.readLine()) != null) {
				if (MKVQBNvE.length() <= 0)
					break;
			}
		} catch (Throwable HdZRt36b) {
			HdZRt36b.printStackTrace();
			return false;
		} finally {
			try {
				if (ODI7AtVs != null)
					ODI7AtVs.close();
				if (h1P7WWzj != null)
					h1P7WWzj.close();
			} catch (Throwable Oeq1euqR) {
				Oeq1euqR.printStackTrace();
			}
			if (py0uEcwX == '2' || py0uEcwX == '3')
				eOD4h5Fx = true;
			else
				eOD4h5Fx = false;
		}
		return eOD4h5Fx;
	}

}