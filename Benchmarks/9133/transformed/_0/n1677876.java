class n1677876 {
	public static String upload_file(String PX05O2Hl, String XGSvTz5O, String khYvcNhk) {
		String PIALgLv6 = "If you see this message, there is some problem inside the function:upload_file()";
		String GAkfpme4 = XGSvTz5O;
		String k10sYHZT = "https://s2.cloud.cm/rpc/json/?session_id=" + PX05O2Hl + "&c=Storage&m=upload_file&tag="
				+ khYvcNhk;
		String Uhncxr0D = "\r\n";
		String wkjnrg11 = "--";
		String lVAkzKOn = "******";
		try {
			URL ASs1NJ5J = new URL(k10sYHZT);
			HttpURLConnection ScVL92MB = (HttpURLConnection) ASs1NJ5J.openConnection();
			ScVL92MB.setDoInput(true);
			ScVL92MB.setDoOutput(true);
			ScVL92MB.setUseCaches(false);
			ScVL92MB.setRequestMethod("POST");
			ScVL92MB.setRequestProperty("Connection", "Keep-Alive");
			ScVL92MB.setRequestProperty("Charset", "UTF-8");
			ScVL92MB.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + lVAkzKOn);
			DataOutputStream rtpubZJM = new DataOutputStream(ScVL92MB.getOutputStream());
			rtpubZJM.writeBytes(wkjnrg11 + lVAkzKOn + Uhncxr0D);
			rtpubZJM.writeBytes("Content-Disposition: form-data; name=\"file\"; filename=\""
					+ GAkfpme4.substring(GAkfpme4.lastIndexOf("/") + 1) + "\"" + Uhncxr0D);
			rtpubZJM.writeBytes(Uhncxr0D);
			FileInputStream wn0oaMJF = new FileInputStream(GAkfpme4);
			byte[] iNzJFnTD = new byte[8192];
			int Keo7gff0 = 0;
			while ((Keo7gff0 = wn0oaMJF.read(iNzJFnTD)) != -1) {
				rtpubZJM.write(iNzJFnTD, 0, Keo7gff0);
			}
			wn0oaMJF.close();
			rtpubZJM.writeBytes(Uhncxr0D);
			rtpubZJM.writeBytes(wkjnrg11 + lVAkzKOn + wkjnrg11 + Uhncxr0D);
			rtpubZJM.flush();
			InputStream b1IzDfmx = ScVL92MB.getInputStream();
			InputStreamReader eOddzolw = new InputStreamReader(b1IzDfmx, "utf-8");
			BufferedReader ebA7YnWP = new BufferedReader(eOddzolw);
			PIALgLv6 = ebA7YnWP.readLine();
			rtpubZJM.close();
			b1IzDfmx.close();
			return PIALgLv6;
		} catch (Exception bo1eU9kQ) {
			bo1eU9kQ.printStackTrace();
		}
		return PIALgLv6;
	}

}