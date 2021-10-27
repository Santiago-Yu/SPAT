class n8996916 {

	private void recvMessage(String UKnsLec9, String zoqHIIzY) throws Exception {
		ConnectionFactoryImpl zHgCwSNM = new ConnectionFactoryImpl();
		Receiver gc6ls0zr = null;
		ProviderConnection LKRlZhut = zHgCwSNM.createConnection(UKnsLec9, zoqHIIzY);
		Connection IFoQfIfZ = DBUtil.getConnection();
		PreparedStatement IhAmFSBs = null;
		ResultSet mdNtZYDc = null;
		String lwRy4zXx = "";
		try {
			gc6ls0zr = Receiver.createReceiver(LKRlZhut);
			gc6ls0zr.open();
			EXTSSPMessage i7yVu2Ox = (EXTSSPMessage) gc6ls0zr.receiveEX();
			if (i7yVu2Ox == null) {
				System.out.println("no message");
			} else {
				IFoQfIfZ.setAutoCommit(false);
				EXTSSPHeader qd62aFZ3 = i7yVu2Ox.getEXHeader();
				UUIDHexGenerator YFeHYMcv = new UUIDHexGenerator();
				String hycNTSFV = YFeHYMcv.generate().toString();
				IhAmFSBs = IFoQfIfZ.prepareStatement(drawOutRecvSql(qd62aFZ3, hycNTSFV));
				IhAmFSBs.executeUpdate();
				String VAICaIAT = "";
				TSSPBody uvLDVSDP = i7yVu2Ox.getBody();
				VAICaIAT = uvLDVSDP.getDomAsString();
				VAICaIAT = VAICaIAT.replaceAll("ns1:", "");
				saveClobMessage(IhAmFSBs, IFoQfIfZ, mdNtZYDc, VAICaIAT, hycNTSFV);
				String RVpyXLle = "";
				Iterator F3tZRDy0 = i7yVu2Ox.getAttachments();
				while (F3tZRDy0.hasNext()) {
					AttachmentPart Tsf9GA7c = (AttachmentPart) F3tZRDy0.next();
					String UWbGjKs2 = Tsf9GA7c.getContentId();
					if (UWbGjKs2.startsWith(Constant.PREFIX_PERSON)) {
						DataHandler g047STVL = Tsf9GA7c.getDataHandler();
						InputStream plYQvVU7 = g047STVL.getInputStream();
						byte[] EyphVZb0 = FileCopyUtils.copyToByteArray(plYQvVU7);
						String UFoIdwYD = new String(EyphVZb0);
						RecvDto tQeM1iv9 = (RecvDto) XStreamConvert.xmlToBean(UFoIdwYD);
						if (tQeM1iv9 == null)
							throw new Exception("接收方信息对象转换错误！请检查存入的信息对象xml字符串是否正确:" + UFoIdwYD);
						if (RVpyXLle.equals("")) {
							RVpyXLle = YFeHYMcv.generate().toString();
							qd62aFZ3.setType(Constant.MESSAGETYPE_NOTIFY);
							IhAmFSBs = IFoQfIfZ.prepareStatement(drawOutRecvSql(qd62aFZ3, RVpyXLle));
							IhAmFSBs.executeUpdate();
							String hibJjgZY = qd62aFZ3.getNotifyContent();
							if (hibJjgZY == null)
								hibJjgZY = "接收到新的esb消息，但未定义通知消息内容!";
							saveClobMessage(IhAmFSBs, IFoQfIfZ, mdNtZYDc, hibJjgZY, RVpyXLle);
						}
						savePersonInfo(IhAmFSBs, IFoQfIfZ, tQeM1iv9, RVpyXLle);
					} else {
						DataHandler F9PyJyqs = Tsf9GA7c.getDataHandler();
						InputStream ZNHfGGQy = F9PyJyqs.getInputStream();
						String DSKsHUHI = YFeHYMcv.generate().toString();
						lwRy4zXx = "insert into message_recv_attachment(ATTACHMENTID,"
								+ "VERSION,MRECVID,BUSS_ID,ATTACHMENT) values('" + DSKsHUHI + "',0,'" + hycNTSFV + "','"
								+ UWbGjKs2 + "',empty_blob())";
						IhAmFSBs = IFoQfIfZ.prepareStatement(lwRy4zXx);
						IhAmFSBs.executeUpdate();
						lwRy4zXx = "select attachment from message_recv_attachment" + " where attachmentid = '"
								+ DSKsHUHI + "' for update";
						IhAmFSBs = IFoQfIfZ.prepareStatement(lwRy4zXx);
						mdNtZYDc = IhAmFSBs.executeQuery();
						mdNtZYDc.next();
						Blob iMXIUQys = mdNtZYDc.getBlob(1);
						OutputStream VCuipWkm = ((oracle.sql.BLOB) iMXIUQys).getBinaryOutputStream();
						FileCopyUtils.copy(ZNHfGGQy, VCuipWkm);
						ZNHfGGQy.close();
						VCuipWkm.close();
					}
				}
				IFoQfIfZ.commit();
				IFoQfIfZ.setAutoCommit(true);
			}
			gc6ls0zr.commit();
		} catch (Exception YGCP8XzR) {
			YGCP8XzR.printStackTrace();
			try {
				System.out.println("received message, rollback");
				if (gc6ls0zr != null) {
					gc6ls0zr.rollback();
				}
			} catch (JAXMException Q08gEyJp) {
				Q08gEyJp.printStackTrace();
			}
		} finally {
			DBUtil.close(mdNtZYDc, IhAmFSBs, IFoQfIfZ);
			if (gc6ls0zr != null) {
				try {
					gc6ls0zr.close();
				} catch (JAXMException ak5erGuK) {
					ak5erGuK.printStackTrace();
				}
			}
			if (LKRlZhut != null) {
				try {
					LKRlZhut.close();
				} catch (JAXMException BxtaXy0q) {
					BxtaXy0q.printStackTrace();
				}
			}
		}
	}

}