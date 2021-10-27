class n15503077 {
	private ArrayList execAtParentServer(ArrayList wbn6NE3u) throws Exception {
		ArrayList e31hM1Y3 = null;
		String l1wjIw0K = "";
		try {
			HashMap z1xb58GF = InitXml.getInstance().getServerMap();
			Iterator XDDKTkpD = z1xb58GF.keySet().iterator();
			while (XDDKTkpD.hasNext()) {
				String MYZ2RbLy = (String) XDDKTkpD.next();
				String XKoOMOum = (String) z1xb58GF.get(MYZ2RbLy);
				XKoOMOum = XKoOMOum + Primer3Manager.servletName;
				URL qjQnzMee = new URL(XKoOMOum);
				URLConnection tX1OpROP = qjQnzMee.openConnection();
				tX1OpROP.setDoOutput(true);
				OutputStream wllmD63W = tX1OpROP.getOutputStream();
				StringBuffer BGiDG1fu = new StringBuffer();
				BGiDG1fu.append("actionType=designparent");
				for (int eA4CaKqf = 0; eA4CaKqf < wbn6NE3u.size(); eA4CaKqf++) {
					Primer3Param MNjPYjkn = (Primer3Param) wbn6NE3u.get(eA4CaKqf);
					if (eA4CaKqf == 0) {
						BGiDG1fu.append("&sequence=" + MNjPYjkn.getSequence());
						BGiDG1fu.append("&upstream_size" + upstreamSize);
						BGiDG1fu.append("&downstreamSize" + downstreamSize);
						BGiDG1fu.append("&MARGIN_LENGTH=" + marginLength);
						BGiDG1fu.append("&OVERLAP_LENGTH=" + overlapLength);
						BGiDG1fu.append("&MUST_XLATE_PRODUCT_MIN_SIZE=" + MNjPYjkn.getPrimerProductMinSize());
						BGiDG1fu.append("&MUST_XLATE_PRODUCT_MAX_SIZE=" + MNjPYjkn.getPrimerProductMaxSize());
						BGiDG1fu.append("&PRIMER_PRODUCT_OPT_SIZE=" + MNjPYjkn.getPrimerProductOptSize());
						BGiDG1fu.append("&PRIMER_MAX_END_STABILITY=" + MNjPYjkn.getPrimerMaxEndStability());
						BGiDG1fu.append("&PRIMER_MAX_MISPRIMING=" + MNjPYjkn.getPrimerMaxMispriming());
						BGiDG1fu.append("&PRIMER_PAIR_MAX_MISPRIMING=" + MNjPYjkn.getPrimerPairMaxMispriming());
						BGiDG1fu.append("&PRIMER_MIN_SIZE=" + MNjPYjkn.getPrimerMinSize());
						BGiDG1fu.append("&PRIMER_OPT_SIZE=" + MNjPYjkn.getPrimerOptSize());
						BGiDG1fu.append("&PRIMER_MAX_SIZE=" + MNjPYjkn.getPrimerMaxSize());
						BGiDG1fu.append("&PRIMER_MIN_TM=" + MNjPYjkn.getPrimerMinTm());
						BGiDG1fu.append("&PRIMER_OPT_TM=" + MNjPYjkn.getPrimerOptTm());
						BGiDG1fu.append("&PRIMER_MAX_TM=" + MNjPYjkn.getPrimerMaxTm());
						BGiDG1fu.append("&PRIMER_MAX_DIFF_TM=" + MNjPYjkn.getPrimerMaxDiffTm());
						BGiDG1fu.append("&PRIMER_MIN_GC=" + MNjPYjkn.getPrimerMinGc());
						BGiDG1fu.append("&PRIMER_OPT_GC_PERCENT=" + MNjPYjkn.getPrimerOptGcPercent());
						BGiDG1fu.append("&PRIMER_MAX_GC=" + MNjPYjkn.getPrimerMaxGc());
						BGiDG1fu.append("&PRIMER_SELF_ANY=" + MNjPYjkn.getPrimerSelfAny());
						BGiDG1fu.append("&PRIMER_SELF_END=" + MNjPYjkn.getPrimerSelfEnd());
						BGiDG1fu.append("&PRIMER_NUM_NS_ACCEPTED=" + MNjPYjkn.getPrimerNumNsAccepted());
						BGiDG1fu.append("&PRIMER_MAX_POLY_X=" + MNjPYjkn.getPrimerMaxPolyX());
						BGiDG1fu.append("&PRIMER_GC_CLAMP=" + MNjPYjkn.getPrimerGcClamp());
					}
					BGiDG1fu.append("&target=" + MNjPYjkn.getPrimerSequenceId() + "," + (MNjPYjkn.getTarget())[0] + ","
							+ (MNjPYjkn.getTarget())[1]);
				}
				PrintStream UZjAOAxy = new PrintStream(wllmD63W);
				UZjAOAxy.print(BGiDG1fu.toString());
				UZjAOAxy.close();
				ObjectInputStream ySY9XSD7 = new ObjectInputStream(tX1OpROP.getInputStream());
				e31hM1Y3 = (ArrayList) ySY9XSD7.readObject();
				ySY9XSD7.close();
			}
		} catch (IOException A4HSaam7) {
			A4HSaam7.printStackTrace();
		}
		if ((e31hM1Y3 == null || e31hM1Y3.size() == 0) && l1wjIw0K != null && l1wjIw0K.length() > 0) {
			throw new Exception(l1wjIw0K);
		}
		return e31hM1Y3;
	}

}