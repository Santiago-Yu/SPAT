class n7606030 {
	public String excute(String gDLhcK3N, String oh3h8zaG, String QsSQBW6n) {
		URL lAj05ZRc;
		HttpURLConnection YAGcXfMz = null;
		try {
			lAj05ZRc = new URL(gDLhcK3N);
			YAGcXfMz = (HttpURLConnection) lAj05ZRc.openConnection();
			YAGcXfMz.setRequestMethod(QsSQBW6n);
			YAGcXfMz.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			YAGcXfMz.setRequestProperty("Content-Length", "" + Integer.toString(oh3h8zaG.getBytes().length));
			YAGcXfMz.setRequestProperty("Content-Language", CHAR_SET);
			YAGcXfMz.setRequestProperty("Connection", "close");
			YAGcXfMz.setUseCaches(false);
			YAGcXfMz.setDoInput(true);
			YAGcXfMz.setDoOutput(true);
			if (oh3h8zaG != null) {
				if (oh3h8zaG.length() > 0) {
					DataOutputStream VEdaZSLQ;
					VEdaZSLQ = new DataOutputStream(YAGcXfMz.getOutputStream());
					VEdaZSLQ.writeBytes(oh3h8zaG);
					VEdaZSLQ.flush();
					VEdaZSLQ.close();
				}
			}
			InputStream A5y8pCuY = YAGcXfMz.getInputStream();
			BufferedReader kje4lfID = new BufferedReader(new InputStreamReader(A5y8pCuY, CHAR_SET));
			String pruGWRev;
			StringBuffer PZeP48S9 = new StringBuffer();
			while ((pruGWRev = kje4lfID.readLine()) != null) {
				PZeP48S9.append(pruGWRev);
				PZeP48S9.append("\r\n");
			}
			kje4lfID.close();
			return PZeP48S9.toString();
		} catch (MalformedURLException i5g9B0SK) {
			i5g9B0SK.printStackTrace();
		} catch (IOException JuDynoW9) {
			JuDynoW9.printStackTrace();
		}
		return null;
	}

}