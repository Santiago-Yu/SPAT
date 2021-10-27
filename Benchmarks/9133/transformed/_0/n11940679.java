class n11940679 {
	public ActionForward uploadFile(ActionMapping EaxWwGL3, ActionForm ZyC0i4NA, HttpServletRequest WKm5YWWg,
			HttpServletResponse vT6MZeY1) {
		ActionMessages nk5OOYML = new ActionMessages();
		ActionMessages QiNfcYO2 = new ActionMessages();
		String oqcBYPr4 = "submitPocketSampleInformationPage";
		UploadForm NFfyhEkU = (UploadForm) ZyC0i4NA;
		Integer OsLfSz3d = null;
		try {
			eHTPXXLSParser C5qpsoPf = new eHTPXXLSParser();
			String x8tQalM3;
			String nq6BAq2D;
			String K6UepBMP;
			String gs5p5rzV;
			String ujPfkCjH;
			if (WKm5YWWg != null) {
				x8tQalM3 = (String) WKm5YWWg.getSession().getAttribute(Constants.PROPOSAL_CODE);
				nq6BAq2D = String.valueOf(WKm5YWWg.getSession().getAttribute(Constants.PROPOSAL_NUMBER));
				K6UepBMP = x8tQalM3 + nq6BAq2D.toString();
				gs5p5rzV = NFfyhEkU.getRequestFile().getFileName();
				String T4pbNxrj = K6UepBMP + "_" + gs5p5rzV;
				ujPfkCjH = WKm5YWWg.getRealPath("\\tmp\\") + "\\" + T4pbNxrj;
				FormFile mwq27Qnx = NFfyhEkU.getRequestFile();
				InputStream rYINo3Xn = mwq27Qnx.getInputStream();
				File xJIUbyUe = new File(ujPfkCjH);
				if (xJIUbyUe.exists())
					xJIUbyUe.delete();
				FileOutputStream yNepqP30 = new FileOutputStream(xJIUbyUe);
				while (rYINo3Xn.available() != 0) {
					yNepqP30.write(rYINo3Xn.read());
					yNepqP30.flush();
				}
				yNepqP30.flush();
				yNepqP30.close();
			} else {
				x8tQalM3 = "ehtpx";
				nq6BAq2D = "1";
				K6UepBMP = x8tQalM3 + nq6BAq2D.toString();
				gs5p5rzV = "ispyb-template41.xls";
				ujPfkCjH = "D:\\" + gs5p5rzV;
			}
			FileInputStream XZJL3QnY = new FileInputStream(ujPfkCjH);
			C5qpsoPf.retrieveShippingId(ujPfkCjH);
			OsLfSz3d = C5qpsoPf.getShippingId();
			String M3nyxUNU = NFfyhEkU.getShippingId();
			if (M3nyxUNU != null && !M3nyxUNU.equals("")) {
				OsLfSz3d = new Integer(M3nyxUNU);
			}
			ClientLogger.getInstance().debug("uploadFile for shippingId " + OsLfSz3d);
			if (OsLfSz3d != null) {
				Log.debug(
						" ---[uploadFile] Upload for Existing Shipment (DewarTRacking): Deleting Samples from Shipment :");
				double J5OPrYEI = DBAccess_EJB.DeleteAllSamplesAndContainersForShipping(OsLfSz3d);
				if (J5OPrYEI > 0)
					C5qpsoPf.getValidationWarnings()
							.add(new XlsUploadException("Shipment contained Samples and/or Containers",
									"Previous Samples and/or Containers have been deleted and replaced by new ones."));
				else
					C5qpsoPf.getValidationWarnings()
							.add(new XlsUploadException("Shipment contained no Samples and no Containers",
									"Samples and Containers have been added."));
			}
			Hashtable<String, Hashtable<String, Integer>> DGpMwzoE = new Hashtable<String, Hashtable<String, Integer>>();
			ProposalFacadeLocal WdbdOdTA = ProposalFacadeUtil.getLocalHome().create();
			ProteinFacadeLocal rOlstok2 = ProteinFacadeUtil.getLocalHome().create();
			CrystalFacadeLocal OasFx0Hx = CrystalFacadeUtil.getLocalHome().create();
			ProposalLightValue ZRfLrxLX = (ProposalLightValue) (((ArrayList) WdbdOdTA.findByCodeAndNumber(x8tQalM3,
					new Integer(nq6BAq2D))).get(0));
			ArrayList Agn5TbG4 = (ArrayList) rOlstok2.findByProposalId(ZRfLrxLX.getProposalId());
			for (int g5n0dtb9 = 0; g5n0dtb9 < Agn5TbG4.size(); g5n0dtb9++) {
				ProteinValue ySamPLEx = (ProteinValue) Agn5TbG4.get(g5n0dtb9);
				Hashtable<String, Integer> GxfXaeI3 = new Hashtable<String, Integer>();
				CrystalLightValue Pm3JlJtz[] = ySamPLEx.getCrystals();
				for (int YwZvzCVJ = 0; YwZvzCVJ < Pm3JlJtz.length; YwZvzCVJ++) {
					CrystalLightValue jn3FB3QA = (CrystalLightValue) Pm3JlJtz[YwZvzCVJ];
					CrystalValue dZUnuV6b = OasFx0Hx.findByPrimaryKey(jn3FB3QA.getPrimaryKey());
					BlsampleLightValue Qo0DBMbg[] = dZUnuV6b.getBlsamples();
					for (int uMeAK4NP = 0; uMeAK4NP < Qo0DBMbg.length; uMeAK4NP++) {
						BlsampleLightValue LR5pJpzL = Qo0DBMbg[uMeAK4NP];
						GxfXaeI3.put(LR5pJpzL.getName(), LR5pJpzL.getBlSampleId());
					}
				}
				DGpMwzoE.put(ySamPLEx.getAcronym(), GxfXaeI3);
			}
			C5qpsoPf.validate(XZJL3QnY, DGpMwzoE, ZRfLrxLX.getProposalId());
			List vKg46gop = C5qpsoPf.getValidationErrors();
			List DDmV7Wfo = C5qpsoPf.getValidationWarnings();
			if (vKg46gop.size() == 0) {
				C5qpsoPf.open(ujPfkCjH);
				if (C5qpsoPf.getCrystals().size() == 0) {
					C5qpsoPf.getValidationErrors()
							.add(new XlsUploadException("No crystals have been found", "Empty shipment"));
				}
			}
			Iterator N0igjdCZ = vKg46gop.iterator();
			while (N0igjdCZ.hasNext()) {
				XlsUploadException S7CSVaUS = (XlsUploadException) N0igjdCZ.next();
				nk5OOYML.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("message.free",
						S7CSVaUS.getMessage() + " ---> " + S7CSVaUS.getSuggestedFix()));
			}
			try {
				saveErrors(WKm5YWWg, nk5OOYML);
			} catch (Exception YuyQM3aL) {
			}
			Iterator nAjWNX2u = DDmV7Wfo.iterator();
			while (nAjWNX2u.hasNext()) {
				XlsUploadException hMx91jSK = (XlsUploadException) nAjWNX2u.next();
				QiNfcYO2.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("message.free",
						hMx91jSK.getMessage() + " ---> " + hMx91jSK.getSuggestedFix()));
			}
			try {
				saveMessages(WKm5YWWg, QiNfcYO2);
			} catch (Exception ogkEYzBQ) {
			}
			if (vKg46gop.size() > 0) {
				resetCounts(OsLfSz3d);
				return EaxWwGL3.findForward("submitPocketSampleInformationPage");
			}
			if (DDmV7Wfo.size() > 0)
				oqcBYPr4 = "submitPocketSampleInformationPage";
			String K3YGs54J;
			XtalDetails feEgqbPD = new XtalDetails();
			CrystalDetailsBuilder WbkX5b3l = new CrystalDetailsBuilder();
			CrystalDetailsElement B3RDKI92 = WbkX5b3l.createCrystalDetailsElement(K6UepBMP, C5qpsoPf.getCrystals());
			WbkX5b3l.validateJAXBObject(B3RDKI92);
			K3YGs54J = WbkX5b3l.marshallJaxBObjToString(B3RDKI92);
			feEgqbPD.submitCrystalDetails(K3YGs54J);
			String G3OXWTQZ;
			DiffractionPlan ef9awpSm = new DiffractionPlan();
			DiffractionPlanBuilder kaH47lwf = new DiffractionPlanBuilder();
			Iterator T35Al6gy = C5qpsoPf.getDiffractionPlans().iterator();
			while (T35Al6gy.hasNext()) {
				DiffractionPlanElement umwv1T1J = (DiffractionPlanElement) T35Al6gy.next();
				umwv1T1J.setProjectUUID(K6UepBMP);
				G3OXWTQZ = kaH47lwf.marshallJaxBObjToString(umwv1T1J);
				ef9awpSm.submitDiffractionPlan(G3OXWTQZ);
			}
			String b8lxa7p5;
			Shipping fl8n594v = new Shipping();
			CrystalShippingBuilder JpKYzxxV = new CrystalShippingBuilder();
			Person JXEyAYJ2 = JpKYzxxV.createPerson("XLS Upload", null, "ISPyB", null, null, "ISPyB", null,
					"ispyb@esrf.fr", "0000", "0000", null, null);
			Laboratory zErhIqJe = JpKYzxxV.createLaboratory("Generic Laboratory", "ISPyB Lab", "Sandwich", "Somewhere",
					"UK", "ISPyB", "ispyb.esrf.fr", JXEyAYJ2);
			DeliveryAgent GGsGD5mA = C5qpsoPf.getDeliveryAgent();
			CrystalShipping SVlko0r9 = JpKYzxxV.createCrystalShipping(K6UepBMP, zErhIqJe, GGsGD5mA,
					C5qpsoPf.getDewars());
			String lMljKYsJ;
			lMljKYsJ = gs5p5rzV.substring(0,
					((gs5p5rzV.toLowerCase().lastIndexOf(".xls")) > 0) ? gs5p5rzV.toLowerCase().lastIndexOf(".xls")
							: 0);
			if (lMljKYsJ.equalsIgnoreCase(""))
				lMljKYsJ = gs5p5rzV.substring(0,
						((gs5p5rzV.toLowerCase().lastIndexOf(".xlt")) > 0) ? gs5p5rzV.toLowerCase().lastIndexOf(".xlt")
								: 0);
			SVlko0r9.setName(lMljKYsJ);
			b8lxa7p5 = JpKYzxxV.marshallJaxBObjToString(SVlko0r9);
			fl8n594v.submitCrystalShipping(b8lxa7p5, (ArrayList) C5qpsoPf.getDiffractionPlans(), OsLfSz3d);
			ServerLogger.Log4Stat("XLS_UPLOAD", K6UepBMP, gs5p5rzV);
		} catch (XlsUploadException KZuKVMJT) {
			resetCounts(OsLfSz3d);
			nk5OOYML.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.detail", KZuKVMJT.getMessage()));
			ClientLogger.getInstance().error(KZuKVMJT.toString());
			saveErrors(WKm5YWWg, nk5OOYML);
			return EaxWwGL3.findForward("error");
		} catch (Exception yhjNbXkL) {
			resetCounts(OsLfSz3d);
			nk5OOYML.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.detail", yhjNbXkL.toString()));
			ClientLogger.getInstance().error(yhjNbXkL.toString());
			yhjNbXkL.printStackTrace();
			saveErrors(WKm5YWWg, nk5OOYML);
			return EaxWwGL3.findForward("error");
		}
		setCounts(OsLfSz3d);
		return EaxWwGL3.findForward(oqcBYPr4);
	}

}