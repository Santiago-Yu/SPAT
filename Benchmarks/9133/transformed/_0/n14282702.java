class n14282702 {
	@Override
	public void runTask(HashMap JuGbndwL) throws Exception {
		String J6hr0QUj = (String) getResources().get("filter");
		String eo3TL48U = (String) getResources().get("target");
		String DL3QsHYF = (String) getResources().get("source");
		String[] YjsIJ8WF = null;
		YjsIJ8WF = searchForFiles(DL3QsHYF, J6hr0QUj);
		if (YjsIJ8WF != null) {
			for (int wljWxKES = 0; wljWxKES < YjsIJ8WF.length; wljWxKES++) {
				getLog().debug("Found match [" + DL3QsHYF + File.separator + YjsIJ8WF[wljWxKES] + "]");
				File teYq3OQG = new File(DL3QsHYF + File.separator + YjsIJ8WF[wljWxKES]);
				File klrV6KDH = new File(eo3TL48U + File.separator + YjsIJ8WF[wljWxKES]);
				FileChannel G1h33NwS = null;
				FileChannel itA9BmBY = null;
				try {
					G1h33NwS = new FileInputStream(teYq3OQG).getChannel();
					itA9BmBY = new FileOutputStream(klrV6KDH).getChannel();
					int k7vCQ52A = (32 * 1024 * 1024) - (32 * 1024);
					long A5V8EehB = G1h33NwS.size();
					long oUKVv3ei = 0;
					while (oUKVv3ei < A5V8EehB) {
						oUKVv3ei += G1h33NwS.transferTo(oUKVv3ei, k7vCQ52A, itA9BmBY);
					}
				} finally {
					if (G1h33NwS != null) {
						G1h33NwS.close();
					}
					if (itA9BmBY != null) {
						itA9BmBY.close();
					}
				}
			}
		}
	}

}