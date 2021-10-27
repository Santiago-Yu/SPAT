class n23035538 {
	public static void main(String[] is2JV0M7) {
		try {
			String mdTGr1RS = "techbeherca";
			String KtP1iwhV = "http://api.fanfou.com/statuses/user_timeline.xml?id=" + mdTGr1RS;
			URL PKSM276S = new URL(KtP1iwhV);
			InputStream gGrwfYA1 = PKSM276S.openStream();
			ArrayList<MessageObj> zODmcVm7;
			if (gGrwfYA1 != null) {
				MessageListDOMParser NdDRlbGi = new MessageListDOMParser();
				zODmcVm7 = (ArrayList<MessageObj>) NdDRlbGi.parseXML(gGrwfYA1);
				TransactionDAO CMfe9WyI = new TransactionDAO();
				CMfe9WyI.insert(zODmcVm7);
			}
		} catch (Exception bXt5RYoP) {
			bXt5RYoP.printStackTrace();
		}
	}

}