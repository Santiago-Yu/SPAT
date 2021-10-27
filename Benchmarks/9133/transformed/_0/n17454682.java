class n17454682 {
	@Override
	public void run() {
		try {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Backupthread started");
			}
			if (_file.exists()) {
				_file.delete();
			}
			final ZipOutputStream pkzfSZOH = new ZipOutputStream(new FileOutputStream(_file));
			pkzfSZOH.setLevel(9);
			final File Uuzh0vgD = File.createTempFile("mp3db", ".xml");
			final OutputStream eGRICe1N = new FileOutputStream(Uuzh0vgD);
			final XMLStreamWriter wh1iBm3z = XMLOutputFactory.newInstance().createXMLStreamWriter(eGRICe1N, "UTF-8");
			wh1iBm3z.writeStartDocument("UTF-8", "1.0");
			wh1iBm3z.writeCharacters("\n");
			wh1iBm3z.writeStartElement("mp3db");
			wh1iBm3z.writeAttribute("version", Integer.toString(Main.ENGINEVERSION));
			final MediafileDAO eR8gS9KR = new MediafileDAO();
			final AlbumDAO dMwF2G0W = new AlbumDAO();
			final CdDAO amp0Bt6o = new CdDAO();
			final CoveritemDAO e71nnyZc = new CoveritemDAO();
			int oQUT85yC = 0;
			try {
				oQUT85yC += eR8gS9KR.getCount();
				oQUT85yC += dMwF2G0W.getCount();
				oQUT85yC += amp0Bt6o.getCount();
				oQUT85yC += e71nnyZc.getCount();
				fireStatusEvent(new StatusEvent(this, StatusEventType.MAX_VALUE, oQUT85yC));
			} catch (final Exception KNJkx5dC) {
				LOG.error("Error getting size", KNJkx5dC);
				fireStatusEvent(new StatusEvent(this, StatusEventType.MAX_VALUE, -1));
			}
			int tFhPbLJQ = 0;
			int l5xkJ572 = 0;
			int Ga8M9g1h = 0;
			int jDWuif61 = 0;
			int hBPtd0Wn = 0;
			final List<CdIf> RB1oksNq = amp0Bt6o.getCdsOrderById();
			if (RB1oksNq.size() > 0) {
				final Map<Integer, Integer> Sn1R37GT = new HashMap<Integer, Integer>();
				final Iterator<CdIf> PD9pommX = RB1oksNq.iterator();
				while (PD9pommX.hasNext() && !_break) {
					final CdIf hasgcvS5 = PD9pommX.next();
					final Integer gUwsp1T1 = Integer.valueOf(tFhPbLJQ++);
					wh1iBm3z.writeStartElement(TypeConstants.XML_CD);
					exportCd(wh1iBm3z, hasgcvS5, gUwsp1T1);
					fireStatusEvent(new StatusEvent(this, StatusEventType.NEW_VALUE, ++hBPtd0Wn));
					final List<MediafileIf> Gd5CuKvM = hasgcvS5.getMediafiles();
					final Iterator<MediafileIf> PORLtxbo = Gd5CuKvM.iterator();
					MediafileIf EpZ0WsRP;
					while (PORLtxbo.hasNext() && !_break) {
						EpZ0WsRP = PORLtxbo.next();
						final Integer MyXWuPMX = Integer.valueOf(l5xkJ572++);
						wh1iBm3z.writeStartElement(TypeConstants.XML_MEDIAFILE);
						exportMediafile(wh1iBm3z, EpZ0WsRP, MyXWuPMX);
						fireStatusEvent(new StatusEvent(this, StatusEventType.NEW_VALUE, ++hBPtd0Wn));
						final AlbumIf ciUW7HTA = EpZ0WsRP.getAlbum();
						if (ciUW7HTA != null) {
							Integer EGoLx9QQ;
							if (Sn1R37GT.containsKey(ciUW7HTA.getAid())) {
								EGoLx9QQ = Sn1R37GT.get(ciUW7HTA.getAid());
								writeLink(wh1iBm3z, TypeConstants.XML_ALBUM, EGoLx9QQ);
							} else {
								EGoLx9QQ = Integer.valueOf(Ga8M9g1h++);
								wh1iBm3z.writeStartElement(TypeConstants.XML_ALBUM);
								exportAlbum(wh1iBm3z, ciUW7HTA, EGoLx9QQ);
								fireStatusEvent(new StatusEvent(this, StatusEventType.NEW_VALUE, ++hBPtd0Wn));
								Sn1R37GT.put(ciUW7HTA.getAid(), EGoLx9QQ);
								if (ciUW7HTA.hasCoveritems() && !_break) {
									final List<CoveritemIf> QY5qZxSs = ciUW7HTA.getCoveritems();
									final Iterator<CoveritemIf> enePpkrO = QY5qZxSs.iterator();
									while (enePpkrO.hasNext() && !_break) {
										final Integer W3D3aNyn = Integer.valueOf(jDWuif61++);
										exportCoveritem(wh1iBm3z, pkzfSZOH, enePpkrO.next(), W3D3aNyn);
										fireStatusEvent(new StatusEvent(this, StatusEventType.NEW_VALUE, ++hBPtd0Wn));
									}
								}
								wh1iBm3z.writeEndElement();
							}
							GenericDAO.getEntityManager().close();
						}
						wh1iBm3z.writeEndElement();
					}
					wh1iBm3z.writeEndElement();
					wh1iBm3z.flush();
					PD9pommX.remove();
					GenericDAO.getEntityManager().close();
				}
			}
			wh1iBm3z.writeEndElement();
			wh1iBm3z.writeEndDocument();
			wh1iBm3z.flush();
			wh1iBm3z.close();
			eGRICe1N.flush();
			eGRICe1N.close();
			if (_break) {
				pkzfSZOH.close();
				_file.delete();
			} else {
				pkzfSZOH.putNextEntry(new ZipEntry("mp3.xml"));
				final InputStream w9MKKsHX = FileUtils.openInputStream(Uuzh0vgD);
				IOUtils.copy(w9MKKsHX, pkzfSZOH);
				w9MKKsHX.close();
				pkzfSZOH.close();
			}
			Uuzh0vgD.delete();
			fireStatusEvent(new StatusEvent(this, StatusEventType.FINISH));
		} catch (final Exception rt98WTC6) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Error backup database", rt98WTC6);
			}
			fireStatusEvent(new StatusEvent(this, rt98WTC6, ""));
			_messenger.fireMessageEvent(new MessageEvent(this, "ERROR", MessageEventTypeEnum.ERROR,
					GuiStrings.getInstance().getString("error.backup"), rt98WTC6));
		}
	}

}