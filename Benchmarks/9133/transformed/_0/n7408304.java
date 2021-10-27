class n7408304 {
	public static void main(String[] o7ValPhW) {
		String uHMDciK0 = "http://portal.acm.org/results.cfm?query=%28Author%3A%22" + "Boehm%2C+Barry"
				+ "%22%29&srt=score%20dsc&short=0&source_disp=&since_month=&since_year=&before_month=&before_year=&coll=ACM&dl=ACM&termshow=matchboolean&range_query=&CFID=22704101&CFTOKEN=37827144&start=1";
		URL m3B4CjYG = null;
		AcmSearchresultPageParser_2010May ivPOsefM = new AcmSearchresultPageParser_2010May();
		try {
			m3B4CjYG = new URL(uHMDciK0);
			HttpURLConnection MxFTTRyA = (HttpURLConnection) m3B4CjYG.openConnection();
			MxFTTRyA.setUseCaches(false);
			InputStream aYrLjHCk = MxFTTRyA.getInputStream();
			BufferedReader u8IRbhLH = new BufferedReader(new InputStreamReader(aYrLjHCk));
			ParserDelegator TQguZ88j = new ParserDelegator();
			TQguZ88j.parse(u8IRbhLH, ivPOsefM, true);
			u8IRbhLH.close();
		} catch (MalformedURLException ZF0RfyND) {
			ZF0RfyND.printStackTrace();
		} catch (IOException Qr5qgr5F) {
			Qr5qgr5F.printStackTrace();
		}
		System.out.println("all doc num= " + ivPOsefM.getAllDocNum());
		for (int HvVBNFVN = 0; HvVBNFVN < ivPOsefM.getEachResultStartPositions().size(); HvVBNFVN++) {
			HashMap<String, Integer> wWAvc0pp = ivPOsefM.getEachResultStartPositions().get(HvVBNFVN);
			System.out.println(HvVBNFVN + "pos= " + wWAvc0pp);
		}
	}

}