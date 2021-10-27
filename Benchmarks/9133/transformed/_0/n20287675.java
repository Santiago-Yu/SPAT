class n20287675 {
	protected void doPost(HttpServletRequest r2Mqs9Dq, HttpServletResponse UDxsCg6s)
			throws ServletException, IOException {
		String ai4R6IyG = r2Mqs9Dq.getPathInfo();
		getLog().info("Process request " + ai4R6IyG);
		if (null != ai4R6IyG) {
			String zscpG2Kd = getPathId(ai4R6IyG);
			JobResources ucyffSKY = ContextUtil.getJobResource(zscpG2Kd);
			if (null != ucyffSKY) {
				RequestType l28J8EpU = getRequestType(r2Mqs9Dq);
				ResultAccess qgbuJWZY = new ResultAccess(ucyffSKY);
				Collection<Long> PEmp21uF = ucyffSKY.getUniqIds();
				boolean oelexbNy = false;
				{
					List<String> biairwC3 = getSeqList(r2Mqs9Dq);
					if (!biairwC3.isEmpty()) {
						oelexbNy = true;
						PEmp21uF = qgbuJWZY.loadIds(biairwC3);
					}
				}
				try {
					if ((l28J8EpU.equals(RequestType.FASTA)) || (l28J8EpU.equals(RequestType.SWISSPROT))) {
						OutputStreamWriter V9KdxO9J = null;
						V9KdxO9J = new OutputStreamWriter(UDxsCg6s.getOutputStream());
						for (Long GMVYGMgS : PEmp21uF) {
							if (l28J8EpU.equals(RequestType.FASTA)) {
								SwissProt X37jzPKW = qgbuJWZY.getSwissprotEntry(GMVYGMgS);
								if (null != X37jzPKW) {
									PrintFactory.instance().print(ConvertFactory.instance().SwissProt2fasta(X37jzPKW),
											V9KdxO9J);
								} else {
									System.err.println("Not able to read Swissprot entry " + GMVYGMgS + " in project "
											+ ucyffSKY.getBaseDir());
								}
							} else if (l28J8EpU.equals(RequestType.SWISSPROT)) {
								File QUR9OSmy = ucyffSKY.getSwissprotFile(GMVYGMgS);
								if (QUR9OSmy.exists()) {
									InputStream PcrrT74x = null;
									try {
										PcrrT74x = new FileInputStream(QUR9OSmy);
										IOUtils.copy(PcrrT74x, V9KdxO9J);
									} catch (IOException VaCcuVMM) {
										VaCcuVMM.printStackTrace();
										System.err.println("Problems with reading file to output stream " + QUR9OSmy);
									} finally {
										IOUtils.closeQuietly(PcrrT74x);
									}
								} else {
									System.err.println("Swissprot file does not exist: " + QUR9OSmy);
								}
							}
						}
						V9KdxO9J.flush();
					} else {
						if (PEmp21uF.size() <= 2) {
							oelexbNy = false;
							PEmp21uF = ucyffSKY.getUniqIds();
						}
						Tree AIeFyWMQ = qgbuJWZY.getTreeByUniquId(PEmp21uF);
						if (l28J8EpU.equals(RequestType.TREE)) {
							UDxsCg6s.getWriter().write(AIeFyWMQ.toNewHampshireX());
						} else if (l28J8EpU.equals(RequestType.PNG)) {
							List<SwissProt> Z1hWgTOJ = qgbuJWZY.getSwissprotEntriesByUniquId(PEmp21uF);
							ImageMap Yga8uzrz = ImageFactory.instance().createProteinCard(Z1hWgTOJ, AIeFyWMQ, true,
									ucyffSKY);
							UDxsCg6s.setContentType("image/png");
							UDxsCg6s.addHeader("Content-Disposition", "filename=ProteinCards.png");
							ImageFactory.instance().printPNG(Yga8uzrz.getImage(), UDxsCg6s.getOutputStream());
							UDxsCg6s.getOutputStream().flush();
						} else if (l28J8EpU.equals(RequestType.HTML)) {
							List<SwissProt> z1Fzx0wT = qgbuJWZY.getSwissprotEntriesByUniquId(PEmp21uF);
							createHtml(ucyffSKY, qgbuJWZY, AIeFyWMQ, r2Mqs9Dq, UDxsCg6s, z1Fzx0wT, oelexbNy);
						}
					}
				} catch (Exception T8x77Q7U) {
					T8x77Q7U.printStackTrace();
					getLog().error("Problem with Request: " + ai4R6IyG + "; type " + l28J8EpU, T8x77Q7U);
				}
			} else {
				getLog().error("Resource is null: " + zscpG2Kd + "; path " + ai4R6IyG);
			}
		} else {
			getLog().error("PathInfo is null!!!");
		}
	}

}