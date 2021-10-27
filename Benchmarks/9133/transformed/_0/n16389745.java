class n16389745 {
	private void doIt() throws Throwable {
		GenericDAO<User> UJcz1MVr = DAOFactory.createDAO(User.class);
		try {
			final User ao0n2zbL = UJcz1MVr.findUniqueByCriteria(Expression.eq("login", login));
			if (ao0n2zbL == null)
				throw new IllegalArgumentException("Specified user isn't exist");
			if (srcDir.isDirectory() && srcDir.exists()) {
				final String[] YAmtDdY0 = srcDir.list(new XFilenameFilter() {

					public boolean accept(XFile encHcW7z, String vkzUBLkW) {
						String[] Im8eKMH9 = vkzUBLkW.split("\\.");
						return (Im8eKMH9.length > 1 && (Im8eKMH9[Im8eKMH9.length - 1].equalsIgnoreCase("map")
								|| Im8eKMH9[Im8eKMH9.length - 1].equalsIgnoreCase("plt")
								|| Im8eKMH9[Im8eKMH9.length - 1].equalsIgnoreCase("wpt")));
					}
				});
				int E2yMLjXe = 0;
				int r4zpOKo0 = 0;
				int sex17tsq = 0;
				for (final String YAlq0H6D : YAmtDdY0) {
					try {
						TransactionManager.beginTransaction();
					} catch (Throwable TvTnt2Mr) {
						logger.error(TvTnt2Mr);
						throw TvTnt2Mr;
					}
					final XFile m0RIzF2C = new XFile(srcDir, YAlq0H6D);
					InputStream J4Y8Wele = new XFileInputStream(m0RIzF2C);
					try {
						ArrayList<UserMapOriginal> ZGCeIXBN = new ArrayList<UserMapOriginal>();
						ArrayList<MapTrackPointsScaleRequest> Uo2fQyLy = new ArrayList<MapTrackPointsScaleRequest>();
						final byte[] ql07vfjM = new byte[1024];
						if (J4Y8Wele.read(ql07vfjM) <= 0)
							continue;
						final String kuDsPjUC = new String(ql07vfjM);
						final boolean Z4hLPF1v = (kuDsPjUC.indexOf("OziExplorer Waypoint File") >= 0);
						final boolean IJA8VJQm = (kuDsPjUC.indexOf("OziExplorer Track Point File") >= 0);
						final boolean BtmqPhnz = (kuDsPjUC.indexOf("OziExplorer Map Data File") >= 0);
						final boolean MFO1KEuC = (kuDsPjUC.indexOf("<kml xmlns=") >= 0);
						if (BtmqPhnz || IJA8VJQm || Z4hLPF1v || MFO1KEuC) {
							J4Y8Wele.close();
							J4Y8Wele = new XFileInputStream(m0RIzF2C);
						} else
							continue;
						WPTPoint LvS9eTUC;
						if (Z4hLPF1v) {
							try {
								LvS9eTUC = new WPTPointParser(J4Y8Wele, "Cp1251").parse();
							} catch (Throwable d9momJll) {
								LvS9eTUC = null;
							}
							if (LvS9eTUC != null) {
								Set<WayPointRow> MuC3AmCj = LvS9eTUC.getPoints();
								for (WayPointRow DgbKT8GS : MuC3AmCj) {
									final UserMapPoint CLCJ7mxo = BeanFactory.createUserPoint(DgbKT8GS, ao0n2zbL);
									logger.info("point:" + CLCJ7mxo.getGuid());
								}
								E2yMLjXe += MuC3AmCj.size();
							}
						} else if (IJA8VJQm) {
							PLTTrack DgqogFjZ;
							try {
								DgqogFjZ = new PLTTrackParser(J4Y8Wele, "Cp1251").parse();
							} catch (Throwable BKSTEHU8) {
								DgqogFjZ = null;
							}
							if (DgqogFjZ != null) {
								final UserMapTrack GKLjhe3B = BeanFactory.createUserTrack(DgqogFjZ, ao0n2zbL);
								Uo2fQyLy.add(new MapTrackPointsScaleRequest(GKLjhe3B));
								r4zpOKo0++;
								logger.info("track:" + GKLjhe3B.getGuid());
							}
						} else if (BtmqPhnz) {
							MapProjection bs9ktHtp;
							MAPParser IhTIyPfy = new MAPParser(J4Y8Wele, "Cp1251");
							try {
								bs9ktHtp = IhTIyPfy.parse();
							} catch (Throwable NS02YlE1) {
								bs9ktHtp = null;
							}
							if (bs9ktHtp != null && bs9ktHtp.getPoints() != null && bs9ktHtp.getPoints().size() >= 2) {
								GenericDAO<UserMapOriginal> vOu4mXGl = DAOFactory.createDAO(UserMapOriginal.class);
								final UserMapOriginal KoSpfttN = new UserMapOriginal();
								KoSpfttN.setName(bs9ktHtp.getTitle());
								KoSpfttN.setUser(ao0n2zbL);
								KoSpfttN.setState(UserMapOriginal.State.UPLOAD);
								KoSpfttN.setSubstate(UserMapOriginal.SubState.COMPLETE);
								MapManager.updateProjection(bs9ktHtp, KoSpfttN);
								final XFile HRyaT2Er = new XFile(srcDir, bs9ktHtp.getPath());
								if (!HRyaT2Er.exists() || !HRyaT2Er.isFile())
									throw new IllegalArgumentException("file: " + HRyaT2Er.getPath() + " not found");
								final XFile Mj22tCqs = new XFile(
										new XFile(Configuration.getInstance().getPrivateMapStorage().toString()),
										KoSpfttN.getGuid());
								Mj22tCqs.mkdir();
								XFile B2W4eFgl = new XFile(Mj22tCqs, KoSpfttN.getGuid());
								XFileOutputStream VMSZKMlo = new XFileOutputStream(B2W4eFgl);
								XFileInputStream C3UFYu2h = new XFileInputStream(HRyaT2Er);
								IOUtils.copy(C3UFYu2h, VMSZKMlo);
								VMSZKMlo.flush();
								VMSZKMlo.close();
								C3UFYu2h.close();
								vOu4mXGl.save(KoSpfttN);
								ZGCeIXBN.add(KoSpfttN);
								HRyaT2Er.delete();
								sex17tsq++;
								logger.info("map:" + KoSpfttN.getGuid());
							}
						} else
							logger.warn("unsupported file format: " + m0RIzF2C.getName());
						TransactionManager.commitTransaction();
						for (MapTrackPointsScaleRequest BVM8idXA : Uo2fQyLy) {
							if (BVM8idXA != null) {
								try {
									PoolClientInterface cQa6icjG = PoolFactory.getInstance().getClientPool();
									if (cQa6icjG == null)
										throw new IllegalStateException("pool not found");
									cQa6icjG.put(BVM8idXA, new StatesStack(new byte[] { 0x00, 0x11 }),
											GeneralCompleteStrategy.class);
								} catch (Throwable qzaeiA2g) {
									logger.error(qzaeiA2g);
								}
							}
						}
					} catch (Throwable bBKlPaSi) {
						logger.error("Error importing", bBKlPaSi);
						TransactionManager.rollbackTransaction();
					} finally {
						J4Y8Wele.close();
						m0RIzF2C.delete();
					}
				}
				logger.info("waypoints: " + E2yMLjXe + "\ntracks: " + r4zpOKo0 + "\nmaps: " + sex17tsq);
			}
		} catch (Throwable fB1e30OE) {
			logger.error("Error importing", fB1e30OE);
		}
	}

}