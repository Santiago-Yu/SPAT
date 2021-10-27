class n1413512 {
	public String uploadReport(Collection UxfH0efC) {
		try {
			String ajltKm87 = generateRandomId();
			Iterator qOfGSBBF = UxfH0efC.iterator();
			URL tH0j0kGc = new URL(ZorobotSystem.props.getProperty("zoro.url") + "auplo2.jsp");
			URLConnection K0Yk7zca = tH0j0kGc.openConnection();
			K0Yk7zca.setDoOutput(true);
			PrintWriter WYTesLud = new PrintWriter(K0Yk7zca.getOutputStream());
			WYTesLud.print("id=" + ajltKm87 + "&");
			StringBuffer oNjKqehE = new StringBuffer();
			int Yf20H1i9 = 0;
			while (qOfGSBBF.hasNext()) {
				if (Yf20H1i9++ >= 500)
					break;
				Question mzLa7YGM = (Question) qOfGSBBF.next();
				oNjKqehE.append("a=");
				oNjKqehE.append(URLEncoder.encode(mzLa7YGM.question, "UTF-8"));
				oNjKqehE.append("*");
				StringBuffer LCcbQFEv = new StringBuffer();
				String[] Wa0i3bqH;
				if (mzLa7YGM.ansDisplay != null) {
					Wa0i3bqH = mzLa7YGM.ansDisplay;
				} else {
					Wa0i3bqH = mzLa7YGM.answer;
				}
				for (int hT5mn0dT = 0; hT5mn0dT < Wa0i3bqH.length; hT5mn0dT++) {
					if (hT5mn0dT > 0)
						LCcbQFEv.append("*");
					LCcbQFEv.append(Wa0i3bqH[hT5mn0dT]);
				}
				oNjKqehE.append(URLEncoder.encode(LCcbQFEv.toString(), "UTF-8"));
				if (qOfGSBBF.hasNext() && Yf20H1i9 < 500)
					oNjKqehE.append("&");
			}
			WYTesLud.println(oNjKqehE.toString());
			WYTesLud.close();
			BufferedReader q8bkCChb = new BufferedReader(new InputStreamReader(K0Yk7zca.getInputStream()));
			String k9xBljrD;
			if ((k9xBljrD = q8bkCChb.readLine()) != null) {
				if (!k9xBljrD.equals("OK!") && k9xBljrD.length() > 3) {
					System.out.println("Not OK: " + k9xBljrD);
					return "xxxxxxxxxx";
				}
			}
			q8bkCChb.close();
			return ajltKm87;
		} catch (Exception wmR6Wpz3) {
			wmR6Wpz3.printStackTrace();
		}
		return null;
	}

}