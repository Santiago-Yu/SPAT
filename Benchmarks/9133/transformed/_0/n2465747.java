class n2465747 {
	public static String postRequest(String D0UDqY8W, HashMap nYUh7Jdi) {
		String P9rviWXA = "";
		try {
			URL qi8jg9zD = new URL(D0UDqY8W);
			URLConnection XInHRCmV = qi8jg9zD.openConnection();
			XInHRCmV.setDoOutput(true);
			XInHRCmV.setDoInput(true);
			PrintWriter JpwASTUl = new PrintWriter(XInHRCmV.getOutputStream());
			Object[] ApzQIlTD = nYUh7Jdi.keySet().toArray();
			Object[] eJaLkm2w = nYUh7Jdi.values().toArray();
			for (int Tbj3DDbF = 0; Tbj3DDbF < ApzQIlTD.length; Tbj3DDbF++) {
				JpwASTUl.print(URLEncoder.encode((String) ApzQIlTD[Tbj3DDbF]) + "="
						+ URLEncoder.encode((String) eJaLkm2w[Tbj3DDbF]));
				if ((Tbj3DDbF + 1) < ApzQIlTD.length)
					JpwASTUl.print("&");
			}
			JpwASTUl.close();
			BufferedReader VegvvdXZ = new BufferedReader(new InputStreamReader(XInHRCmV.getInputStream()));
			String M6vftPDD;
			while ((M6vftPDD = VegvvdXZ.readLine()) != null) {
				P9rviWXA += M6vftPDD;
			}
			VegvvdXZ.close();
		} catch (Exception FGbIVcZc) {
			FGbIVcZc.printStackTrace();
			P9rviWXA = null;
		}
		return (P9rviWXA);
	}

}