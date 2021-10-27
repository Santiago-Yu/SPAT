class n18433984 {
	protected void doUpload(HttpServletRequest nmo6zxBd, HttpServletResponse wlsynxOz)
			throws ServletException, IOException {
		HttpSession Tv141DnI = nmo6zxBd.getSession();
		ArrayList<File> TeL4vLfW = new ArrayList<File>();
		LOG.info("UploadServlet Upload request received");
		if (ServletFileUpload.isMultipartContent(nmo6zxBd)) {
			LOG.debug("UploadServlet Received a multipart request.");
		} else {
			LOG.debug("UploadServlet Received a non-multipart request.");
		}
		String rSRTdPfV = UUID.randomUUID().toString();
		File FYLfeu1f = new File(adapter.getRootPath() + File.separator + "temp" + File.separator + rSRTdPfV);
		FYLfeu1f.getParentFile().mkdir();
		while (FYLfeu1f.exists()) {
			rSRTdPfV = UUID.randomUUID().toString();
			FYLfeu1f = new File(adapter.getRootPath() + File.separator + "temp" + File.separator + rSRTdPfV);
		}
		FYLfeu1f.mkdir();
		File K4DQLr1H = (File) (Tv141DnI.getAttribute("up2p:attachdir"));
		if (K4DQLr1H != null) {
			LOG.info("UploadServlet: Copying provided attachment to upload dir from: " + K4DQLr1H.getAbsolutePath());
			FYLfeu1f.delete();
			K4DQLr1H.renameTo(FYLfeu1f);
			Tv141DnI.removeAttribute("up2p:attachdir");
		}
		LOG.info("UploadServlet: Using temporary directory: " + FYLfeu1f.getPath());
		PairList mf114Mtc = null;
		if (ServletFileUpload.isMultipartContent(nmo6zxBd)) {
			mf114Mtc = getMultipartParameters(nmo6zxBd, uploadHandler, LOG, FYLfeu1f.getPath());
			if (mf114Mtc.size() == 0) {
				LOG.debug("UploadServlet Parsed multipart request and " + "found no parameters. Parsing as regular"
						+ " request instead.");
				mf114Mtc = copyParameters(nmo6zxBd);
				LOG.debug("UploadServlet Parsed as regular request and found " + mf114Mtc.size() + " parameters.");
			}
		} else {
			mf114Mtc = copyParameters(nmo6zxBd);
		}
		String UCm9V3DO = getCurrentCommunityId(nmo6zxBd.getSession());
		String hkomTc7h = mf114Mtc.getValue(HttpParams.UP2P_COMMUNITY);
		LOG.debug("UploadServlet: Got active community: " + hkomTc7h);
		if (hkomTc7h != null) {
			UCm9V3DO = hkomTc7h;
			LOG.debug("switching to community" + UCm9V3DO);
		}
		if (UCm9V3DO == null || UCm9V3DO.length() == 0) {
			LOG.warn("UploadServlet Current community ID is missing from" + "the user session.");
			writeError(nmo6zxBd, wlsynxOz, "The current community is unknown."
					+ " Please select a community before performing " + "any actions.", mf114Mtc);
			for (File LhP2KRu1 : FYLfeu1f.listFiles()) {
				LhP2KRu1.delete();
			}
			FYLfeu1f.delete();
			return;
		}
		LOG.info("UploadServlet Uploading to community " + UCm9V3DO + ".");
		TeL4vLfW.clear();
		Iterator<String> NhyzY1Tq = mf114Mtc.getValues(HttpParams.UP2P_FILENAME);
		String Ajop0eWP = "";
		try {
			if (NhyzY1Tq.hasNext()) {
				Ajop0eWP = NhyzY1Tq.next();
			} else {
				throw new IOException("UploadServlet: No up2p:filename parameters were found.");
			}
			if (Ajop0eWP.startsWith("file:"))
				Ajop0eWP = Ajop0eWP.substring(5);
			if (Ajop0eWP.length() == 0) {
				throw new IOException("UploadServlet: An empty up2p:filename parameter was submitted.");
			}
			File W5CZUaeb = null;
			W5CZUaeb = new File(adapter.getStorageDirectory(UCm9V3DO), Ajop0eWP);
			File NmtPfamG = new File(FYLfeu1f, Ajop0eWP);
			if (!NmtPfamG.exists() && !W5CZUaeb.exists()) {
				throw new IOException("UploadServlet: The uploaded resource could not be found.");
			}
			if ((NmtPfamG.exists() && W5CZUaeb.exists()) || (NmtPfamG.exists() && !W5CZUaeb.exists())) {
				W5CZUaeb = FileUtil.createUniqueFile(W5CZUaeb);
				LOG.info("UploadServlet: Direct upload, copying resource file.\n\tOriginal: " + NmtPfamG.getPath()
						+ "\n\tNew: " + W5CZUaeb.getPath());
				W5CZUaeb.getParentFile().mkdir();
				FileOutputStream gQmbNQgw = new FileOutputStream(W5CZUaeb);
				FileUtil.writeFileToStream(gQmbNQgw, NmtPfamG, true);
				Ajop0eWP = W5CZUaeb.getName();
			}
			LOG.info("UploadServlet: resource file name: " + Ajop0eWP);
			TeL4vLfW.add(W5CZUaeb);
		} catch (IOException BmkOXS9r) {
			LOG.error("UploadServlet: " + BmkOXS9r.getMessage());
			writeError(nmo6zxBd, wlsynxOz, BmkOXS9r.getMessage(), mf114Mtc);
			return;
		}
		String vaXe7XjA = mf114Mtc.getValue(HttpParams.UP2P_EDIT_RESOURCE);
		if (vaXe7XjA != null && vaXe7XjA.length() > 0) {
			LOG.debug("UploadServlet: Got edit resource: " + vaXe7XjA);
			File WhBc2l1H = new File(adapter.getAttachmentStorageDirectory(UCm9V3DO, vaXe7XjA));
			if (WhBc2l1H.exists() && WhBc2l1H.isDirectory()) {
				LOG.debug("UploadServlet: Copying additional attachments from: " + WhBc2l1H.getAbsolutePath());
				for (File JK1u1dcA : WhBc2l1H.listFiles()) {
					File gNSMel1l = new File(FYLfeu1f, JK1u1dcA.getName());
					if (!gNSMel1l.exists()) {
						LOG.debug("UploadServlet: Copying attachment: " + JK1u1dcA.getAbsolutePath() + " to "
								+ gNSMel1l.getAbsolutePath());
						FileOutputStream w4weDuNS = new FileOutputStream(gNSMel1l);
						FileUtil.writeFileToStream(w4weDuNS, JK1u1dcA, true);
					} else {
						LOG.debug("UploadServlet: Attachment " + gNSMel1l.getName()
								+ " explicitly replaced in new upload.");
					}
				}
			}
		}
		String VPQcp8Aq = mf114Mtc.getValue(HttpParams.UP2P_BATCH);
		boolean fejMULTz = VPQcp8Aq != null && VPQcp8Aq.length() > 0;
		if (fejMULTz) {
			LOG.info("UploadSerlvet Recieved batch upload request.");
			File WgkcSBBD = new File(adapter.getStorageDirectory(UCm9V3DO), TeL4vLfW.get(0).getName());
			TeL4vLfW.clear();
			LOG.debug("UploadServlet resource file stored at: " + WgkcSBBD.getPath());
			XMLReader D9b6LUf8 = TransformerHelper.getXMLReader();
			D9b6LUf8.setContentHandler(new BatchCopyHandler(UCm9V3DO, TeL4vLfW));
			try {
				FileInputStream kPTNIMRB = new FileInputStream(WgkcSBBD);
				D9b6LUf8.parse(new InputSource(kPTNIMRB));
				kPTNIMRB.close();
			} catch (Exception vYFbI0qJ) {
				LOG.error("UploadServlet: Error parsing batch upload file.");
				LOG.error("UploadServlet: " + vYFbI0qJ.getMessage());
				writeError(nmo6zxBd, wlsynxOz, "Uploaded content was not a valid batch resource file.", mf114Mtc);
				return;
			}
			WgkcSBBD.delete();
			adapter.addNotification("Batch file succesfully processed into " + TeL4vLfW.size() + " resources.");
		}
		boolean S5UTVAn5 = mf114Mtc.getValue(HttpParams.UP2P_PUSH) != null
				&& mf114Mtc.getValue(HttpParams.UP2P_PUSH).length() > 0;
		String bvhcmmx6 = "";
		boolean ZEmhxvSA = false;
		int FMZLxAzR = 0;
		for (int hY5cFGhx = 0; hY5cFGhx < TeL4vLfW.size(); hY5cFGhx++) {
			LOG.info("UploadServlet Publishing resource to WebAdapter: " + TeL4vLfW.get(hY5cFGhx).getName());
			try {
				bvhcmmx6 = adapter.publish(UCm9V3DO, new File(TeL4vLfW.get(hY5cFGhx).getName()), FYLfeu1f);
				TeL4vLfW.remove(hY5cFGhx);
				hY5cFGhx--;
				FMZLxAzR++;
				LOG.info("UploadServlet Resource published with id: " + bvhcmmx6);
			} catch (IOException lqzFY4fM) {
				LOG.warn("UploadServlet IO Error occured in reading the uploaded file: " + lqzFY4fM.getMessage(),
						lqzFY4fM);
				uploadFilesCleanup(TeL4vLfW, FYLfeu1f);
				writeError(nmo6zxBd, wlsynxOz,
						"An error occured in reading the uploaded file: " + lqzFY4fM.getMessage(), mf114Mtc);
				return;
			} catch (SAXParseException ujMwp6pY) {
				LOG.warn("UploadServlet SAX Parse Error occured in uploaded resource: " + ujMwp6pY.getMessage());
				String WOyOOm2N = "Invalid XML in the uploaded resource.<br/>" + ujMwp6pY.getMessage()
						+ "<br/><br/>File location: " + TeL4vLfW.get(hY5cFGhx).getAbsolutePath() + "<br/>Line: "
						+ ujMwp6pY.getLineNumber() + " Column: " + ujMwp6pY.getColumnNumber();
				uploadFilesCleanup(TeL4vLfW, FYLfeu1f);
				writeError(nmo6zxBd, wlsynxOz, WOyOOm2N, mf114Mtc);
				return;
			} catch (SAXException iP15Vt5z) {
				LOG.warn("UploadServlet Invalid XML in uploaded resource: " + iP15Vt5z.getMessage());
				String ssRv4ygm = "Invalid XML in uploaded resource<br/><i>" + iP15Vt5z.getMessage() + "</i><br/>"
						+ "File location: " + TeL4vLfW.get(hY5cFGhx).getAbsolutePath();
				uploadFilesCleanup(TeL4vLfW, FYLfeu1f);
				writeError(nmo6zxBd, wlsynxOz, ssRv4ygm, mf114Mtc);
				return;
			} catch (DuplicateResourceException YXbF9KAF) {
				LOG.info("UploadServlet Duplicate Resource: " + YXbF9KAF.getResourceId() + " Community: "
						+ YXbF9KAF.getCommunityId());
				if (fejMULTz) {
					if (!ZEmhxvSA) {
						adapter.addNotification("Warning: Batch upload contained previously published "
								+ " resources which have been discarded.");
						ZEmhxvSA = true;
					}
				} else {
					uploadFilesCleanup(TeL4vLfW, FYLfeu1f);
					String v4bZZPe8 = mf114Mtc.getValue(HttpParams.UP2P_FETCH_XML);
					if (v4bZZPe8 != null && v4bZZPe8.length() > 0) {
						writeError(nmo6zxBd, wlsynxOz,
								"This resource is already shared with resource " + " id: " + YXbF9KAF.getResourceId(),
								mf114Mtc);
						return;
					}
					String Kio1JYf6 = wlsynxOz.encodeURL("/overwrite.jsp?up2p:community=" + YXbF9KAF.getCommunityId()
							+ "&up2p:resource=" + YXbF9KAF.getResourceId());
					LOG.info("UploadServlet Redirecting to " + Kio1JYf6);
					RequestDispatcher sHZIvMwr = nmo6zxBd.getRequestDispatcher(Kio1JYf6);
					sHZIvMwr.forward(nmo6zxBd, wlsynxOz);
					return;
				}
			} catch (NetworkAdapterException R6HWTt3l) {
				LOG.info("UploadServlet Error in the Network Adapter for" + " community ID " + UCm9V3DO, R6HWTt3l);
				uploadFilesCleanup(TeL4vLfW, FYLfeu1f);
				writeError(nmo6zxBd, wlsynxOz,
						"Error in the Network Adapter for this community. <br/>" + R6HWTt3l.getMessage(), mf114Mtc);
				return;
			} catch (ResourceNotFoundException fjOevwkf) {
				LOG.info("UploadServlet Error Resource not found " + fjOevwkf);
				uploadFilesCleanup(TeL4vLfW, FYLfeu1f);
				writeError(nmo6zxBd, wlsynxOz, "Error : <br/>" + fjOevwkf.getMessage(), mf114Mtc);
				return;
			}
		}
		uploadFilesCleanup(TeL4vLfW, FYLfeu1f);
		String BFv8EPeW = mf114Mtc.getValue(HttpParams.UP2P_XMLHTTP);
		String nafBfqn4 = mf114Mtc.getValue(HttpParams.UP2P_FETCH_XML);
		if (nafBfqn4 != null && nafBfqn4.length() > 0) {
			wlsynxOz.setContentType("text/xml");
			PrintWriter OodiluSz = wlsynxOz.getWriter();
			OodiluSz.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			OodiluSz.println("<upload success=\"true\" >");
			OodiluSz.println("<resid>" + bvhcmmx6 + "</resid>");
			OodiluSz.println("</upload>");
		} else if (BFv8EPeW != null && BFv8EPeW.length() > 0) {
			LOG.debug("UploadServlet Recieved xmlHttp request, responding with XML");
			wlsynxOz.setContentType("text/xml");
			PrintWriter GE4jaQSj = wlsynxOz.getWriter();
			GE4jaQSj.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			GE4jaQSj.print("<resource id=\"" + nmo6zxBd.getParameter(HttpParams.UP2P_RESOURCE) + "\" ");
			if (nmo6zxBd.getParameter(HttpParams.UP2P_PEERID) != null) {
				GE4jaQSj.print("peerid=\"" + nmo6zxBd.getParameter(HttpParams.UP2P_PEERID) + "\" ");
			}
			GE4jaQSj.println("/>");
		} else if (fejMULTz) {
			adapter.addNotification(FMZLxAzR + " resources were succesfully published.");
			nmo6zxBd.setAttribute("up2p.display.mode", "view");
			String Ml1gW6ni = wlsynxOz.encodeURL("/view.jsp?up2p:community=" + UCm9V3DO);
			LOG.info("UploadServlet Redirecting to " + Ml1gW6ni);
			RequestDispatcher pG6ftB0F = nmo6zxBd.getRequestDispatcher(Ml1gW6ni);
			pG6ftB0F.forward(nmo6zxBd, wlsynxOz);
		} else if (!S5UTVAn5) {
			nmo6zxBd.setAttribute("up2p.display.mode", "view");
			String oaYccR82 = wlsynxOz.encodeURL("/view.jsp?up2p:resource=" + bvhcmmx6);
			LOG.info("UploadServlet Redirecting to " + oaYccR82);
			RequestDispatcher hoa1e7vB = nmo6zxBd.getRequestDispatcher(oaYccR82);
			hoa1e7vB.forward(nmo6zxBd, wlsynxOz);
		}
		return;
	}

}