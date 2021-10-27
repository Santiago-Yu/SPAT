class n3542936 {
	public boolean deleteByQuery(String T0MLBkXY, int Qjjc8v7p) {
		try {
			URL VB9S63D0 = new URL(solrUrl + "/core" + Qjjc8v7p + "/update");
			URLConnection S56vNPxa = VB9S63D0.openConnection();
			S56vNPxa.setDoOutput(true);
			S56vNPxa.setRequestProperty("Content-type", "text/xml");
			S56vNPxa.setRequestProperty("charset", "utf-8");
			OutputStreamWriter fsO5oLFQ = new OutputStreamWriter(S56vNPxa.getOutputStream());
			System.out.println("******************" + T0MLBkXY);
			fsO5oLFQ.write("<delete><query>" + T0MLBkXY + "</query></delete>");
			fsO5oLFQ.flush();
			BufferedReader ZWo9B68W = new BufferedReader(new InputStreamReader(S56vNPxa.getInputStream()));
			String j6xLGSNO;
			while ((j6xLGSNO = ZWo9B68W.readLine()) != null) {
				System.out.println(j6xLGSNO);
			}
			fsO5oLFQ.close();
			ZWo9B68W.close();
			S56vNPxa = VB9S63D0.openConnection();
			S56vNPxa.setDoOutput(true);
			S56vNPxa.setRequestProperty("Content-type", "text/xml");
			S56vNPxa.setRequestProperty("charset", "utf-8");
			fsO5oLFQ = new OutputStreamWriter(S56vNPxa.getOutputStream());
			fsO5oLFQ.write("<commit/>");
			fsO5oLFQ.flush();
			ZWo9B68W = new BufferedReader(new InputStreamReader(S56vNPxa.getInputStream()));
			while ((j6xLGSNO = ZWo9B68W.readLine()) != null) {
				System.out.println(j6xLGSNO);
			}
			fsO5oLFQ.close();
			ZWo9B68W.close();
		} catch (Exception fXRGzaJM) {
			fXRGzaJM.printStackTrace();
			return false;
		}
		return true;
	}

}