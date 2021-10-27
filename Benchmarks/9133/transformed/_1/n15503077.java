class n15503077 {
	private ArrayList execAtParentServer(ArrayList paramList) throws Exception {
		ArrayList outputList = null;
		String message = "";
		try {
			HashMap serverUrlMap = InitXml.getInstance().getServerMap();
			Iterator it = serverUrlMap.keySet().iterator();
			while (it.hasNext()) {
				String server = (String) it.next();
				String serverUrl = (String) serverUrlMap.get(server);
				serverUrl = serverUrl + Primer3Manager.servletName;
				URL url = new URL(serverUrl);
				URLConnection uc = url.openConnection();
				uc.setDoOutput(true);
				OutputStream os = uc.getOutputStream();
				StringBuffer buf = new StringBuffer();
				buf.append("actionType=designparent");
				int b6NtY = 0;
				while (b6NtY < paramList.size()) {
					Primer3Param param = (Primer3Param) paramList.get(b6NtY);
					if (b6NtY == 0) {
						buf.append("&sequence=" + param.getSequence());
						buf.append("&upstream_size" + upstreamSize);
						buf.append("&downstreamSize" + downstreamSize);
						buf.append("&MARGIN_LENGTH=" + marginLength);
						buf.append("&OVERLAP_LENGTH=" + overlapLength);
						buf.append("&MUST_XLATE_PRODUCT_MIN_SIZE=" + param.getPrimerProductMinSize());
						buf.append("&MUST_XLATE_PRODUCT_MAX_SIZE=" + param.getPrimerProductMaxSize());
						buf.append("&PRIMER_PRODUCT_OPT_SIZE=" + param.getPrimerProductOptSize());
						buf.append("&PRIMER_MAX_END_STABILITY=" + param.getPrimerMaxEndStability());
						buf.append("&PRIMER_MAX_MISPRIMING=" + param.getPrimerMaxMispriming());
						buf.append("&PRIMER_PAIR_MAX_MISPRIMING=" + param.getPrimerPairMaxMispriming());
						buf.append("&PRIMER_MIN_SIZE=" + param.getPrimerMinSize());
						buf.append("&PRIMER_OPT_SIZE=" + param.getPrimerOptSize());
						buf.append("&PRIMER_MAX_SIZE=" + param.getPrimerMaxSize());
						buf.append("&PRIMER_MIN_TM=" + param.getPrimerMinTm());
						buf.append("&PRIMER_OPT_TM=" + param.getPrimerOptTm());
						buf.append("&PRIMER_MAX_TM=" + param.getPrimerMaxTm());
						buf.append("&PRIMER_MAX_DIFF_TM=" + param.getPrimerMaxDiffTm());
						buf.append("&PRIMER_MIN_GC=" + param.getPrimerMinGc());
						buf.append("&PRIMER_OPT_GC_PERCENT=" + param.getPrimerOptGcPercent());
						buf.append("&PRIMER_MAX_GC=" + param.getPrimerMaxGc());
						buf.append("&PRIMER_SELF_ANY=" + param.getPrimerSelfAny());
						buf.append("&PRIMER_SELF_END=" + param.getPrimerSelfEnd());
						buf.append("&PRIMER_NUM_NS_ACCEPTED=" + param.getPrimerNumNsAccepted());
						buf.append("&PRIMER_MAX_POLY_X=" + param.getPrimerMaxPolyX());
						buf.append("&PRIMER_GC_CLAMP=" + param.getPrimerGcClamp());
					}
					buf.append("&target=" + param.getPrimerSequenceId() + "," + (param.getTarget())[0] + ","
							+ (param.getTarget())[1]);
					b6NtY++;
				}
				PrintStream ps = new PrintStream(os);
				ps.print(buf.toString());
				ps.close();
				ObjectInputStream ois = new ObjectInputStream(uc.getInputStream());
				outputList = (ArrayList) ois.readObject();
				ois.close();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if ((outputList == null || outputList.size() == 0) && message != null && message.length() > 0) {
			throw new Exception(message);
		}
		return outputList;
	}

}