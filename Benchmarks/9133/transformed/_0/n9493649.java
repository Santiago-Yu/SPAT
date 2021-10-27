class n9493649 {
	public boolean loadFile(String R96PJGFF) {
		if (osmlContainer == null)
			return false;
		hApdx.clear();
		try {
			BufferedReader IyFNcJjU = null;
			if (R96PJGFF.indexOf("http://") >= 0) {
				URL ph9we4em = null;
				ph9we4em = new URL(R96PJGFF);
				URLConnection Qil82RYo = ph9we4em.openConnection();
				Qil82RYo.setUseCaches(false);
				InputStreamReader t4ZhIizv = new InputStreamReader(Qil82RYo.getInputStream());
				IyFNcJjU = new BufferedReader(t4ZhIizv);
			} else {
				IyFNcJjU = new BufferedReader(new FileReader(R96PJGFF));
			}
			String GYTGgKpL = null;
			while ((GYTGgKpL = IyFNcJjU.readLine()) != null) {
				StringTokenizer oJ6mBmR8 = new StringTokenizer(GYTGgKpL, "\t\n\r");
				if (oJ6mBmR8.countTokens() < 2)
					continue;
				String Q25CT2Ck = oJ6mBmR8.nextToken();
				String ytkIM2Yj = oJ6mBmR8.nextToken();
				String jpxpAbbK = "";
				if (oJ6mBmR8.countTokens() > 0)
					jpxpAbbK = oJ6mBmR8.nextToken();
				if (Q25CT2Ck.length() == 0 || ytkIM2Yj.length() == 0)
					continue;
				OmicElementContainer UMFBNyAr = (OmicElementContainer) OmicElementContainer.createContainer();
				UMFBNyAr.setName(Q25CT2Ck);
				UMFBNyAr.setNote(jpxpAbbK);
				UMFBNyAr.addAppendix(ytkIM2Yj);
				String exJAwcp9[] = commaPattern.split(ytkIM2Yj);
				for (int vywZvfMF = 0; vywZvfMF < exJAwcp9.length; vywZvfMF++) {
					ArrayList ZlzGUXsf = (ArrayList) hApdx.get(exJAwcp9[vywZvfMF]);
					if (ZlzGUXsf == null)
						ZlzGUXsf = new ArrayList();
					ZlzGUXsf.add(UMFBNyAr);
					hApdx.put(exJAwcp9[vywZvfMF], ZlzGUXsf);
				}
			}
			IyFNcJjU.close();
		} catch (MalformedURLException p5UaEgA7) {
			System.out.println("MalformedURLException");
			return false;
		} catch (IOException QyIIe1Gr) {
			System.out.println("IOException");
			return false;
		}
		System.out.println("appendix name list size " + hApdx.size());
		if (bElementDirected) {
			int JvNHpkxd = 0;
			ArrayList<OmicElementContainer> fRn6hcmD = osmlContainer.getAllOmicElementContainers();
			for (OmicElementContainer bEoOuoH6 : fRn6hcmD) {
				String NyfbW3RL = bEoOuoH6.getName();
				String WsZ0EwWA = bEoOuoH6.getAppendix();
				if (NyfbW3RL.length() == 0)
					continue;
				String F0XooyKm[] = commaPattern.split(NyfbW3RL);
				String MgZI7yuC[] = commaPattern.split(WsZ0EwWA);
				String yqrlyqs1[] = new String[F0XooyKm.length + MgZI7yuC.length];
				for (int SFFJovGo = 0; SFFJovGo < F0XooyKm.length; SFFJovGo++)
					yqrlyqs1[SFFJovGo] = F0XooyKm[SFFJovGo];
				for (int sAWvjCtn = 0; sAWvjCtn < MgZI7yuC.length; sAWvjCtn++)
					yqrlyqs1[sAWvjCtn + F0XooyKm.length] = MgZI7yuC[sAWvjCtn];
				for (int Oq1i81Lf = 0; Oq1i81Lf < yqrlyqs1.length; Oq1i81Lf++) {
					ArrayList UO8qJvZl = (ArrayList) hApdx.get(yqrlyqs1[Oq1i81Lf]);
					if (UO8qJvZl == null)
						continue;
					for (int OOIB4MAt = 0; OOIB4MAt < UO8qJvZl.size(); OOIB4MAt++) {
						OmicElementContainer NNQc7n8N = (OmicElementContainer) UO8qJvZl.get(OOIB4MAt);
						bEoOuoH6.addAppendix(NNQc7n8N.getName());
						JvNHpkxd++;
					}
				}
			}
			System.out.println("match appendix element " + JvNHpkxd + " items");
		}
		if (bFunctionDirected) {
			int n0LvspxN = 0;
			FunctionalClassContainer Ee4ooX3W[] = osmlContainer.getFunctionalClassContainer("[@container=all]");
			ArrayList Ry5GjxrT = new ArrayList();
			for (int Hc9ZeOSr = 0; Hc9ZeOSr < Ee4ooX3W.length; Hc9ZeOSr++) {
				if (!Ry5GjxrT.contains(Ee4ooX3W[Hc9ZeOSr]))
					Ry5GjxrT.add(Ee4ooX3W[Hc9ZeOSr]);
			}
			for (int vjXgha50 = 0; vjXgha50 < Ry5GjxrT.size(); vjXgha50++) {
				FunctionalClassContainer B7I4Npto = (FunctionalClassContainer) Ry5GjxrT.get(vjXgha50);
				String SeTWIJbS = B7I4Npto.getName();
				if (SeTWIJbS.length() == 0)
					continue;
				String WJy310q8[] = SeTWIJbS.split(",");
				for (int cBvocxvd = 0; cBvocxvd < WJy310q8.length; cBvocxvd++) {
					ArrayList KkHgY0Vf = (ArrayList) hApdx.get(WJy310q8[cBvocxvd]);
					if (KkHgY0Vf == null)
						continue;
					for (int NvdPNVnA = 0; NvdPNVnA < KkHgY0Vf.size(); NvdPNVnA++) {
						OmicElementContainer xg6sAjuf = (OmicElementContainer) KkHgY0Vf.get(NvdPNVnA);
						Ee4ooX3W[vjXgha50].addOmicElementContainer(xg6sAjuf);
						n0LvspxN++;
					}
				}
			}
			System.out.println("match appendix function " + n0LvspxN + " items");
		}
		return true;
	}

}