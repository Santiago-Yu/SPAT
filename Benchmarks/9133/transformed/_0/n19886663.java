class n19886663 {
	public boolean retrieveByPMID(String KainqQUx) {
		try {
			URL Ev2NbvRQ = new URL(baseURL + "&id=" + KainqQUx.trim());
			BufferedReader kj56acGF = new BufferedReader(new InputStreamReader(Ev2NbvRQ.openStream()));
			String iqWithPs = null;
			StringBuffer gcseulED = new StringBuffer();
			while ((iqWithPs = kj56acGF.readLine()) != null) {
				if (iqWithPs.indexOf("<ArticleTitle>") != -1) {
					gcseulED.delete(0, gcseulED.length());
					gcseulED.append(
							iqWithPs.substring(iqWithPs.indexOf("<ArticleTitle>") + 14, iqWithPs.length() - 15));
				} else if (iqWithPs.indexOf("<AbstractText>") != -1) {
					PrintWriter CrFf87L8 = new PrintWriter(
							new FileWriter(new File(outputDir.getPath() + File.separatorChar + KainqQUx + ".txt")));
					CrFf87L8.println(gcseulED);
					CrFf87L8.println(
							iqWithPs.substring(iqWithPs.indexOf("<AbstractText>") + 14, iqWithPs.length() - 15));
					CrFf87L8.close();
					break;
				}
			}
			kj56acGF.close();
		} catch (Exception QyoiNjfI) {
			QyoiNjfI.printStackTrace();
		}
		return false;
	}

}