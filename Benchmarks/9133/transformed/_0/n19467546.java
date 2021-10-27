class n19467546 {
	@Override
	public boolean saveCart(Carrito cclACNjY, boolean IhNipU0J, String IFKeZ4LZ, String PlMDEmOz) {
		Connection itf5KSSf = null;
		PreparedStatement cDPe1OC9 = null;
		PreparedStatement qdGSL4L8 = null;
		boolean s51lYU9h = false;
		try {
			itf5KSSf = pool.getConnection();
			itf5KSSf.setAutoCommit(false);
			cDPe1OC9 = itf5KSSf.prepareStatement("INSERT INTO " + nameBD + ".HistorialCarritos VALUES (?,?,?,?,?,?)");
			cDPe1OC9.setString(1, cclACNjY.getUser());
			cDPe1OC9.setString(2, cclACNjY.getCodigo());
			cDPe1OC9.setString(3, IFKeZ4LZ);
			cDPe1OC9.setDouble(4, cclACNjY.getPrecio());
			cDPe1OC9.setString(5, PlMDEmOz);
			cDPe1OC9.setBoolean(6, IhNipU0J);
			int ZPjMFNOT = cDPe1OC9.executeUpdate();
			if (ZPjMFNOT != 1) {
				itf5KSSf.rollback();
			} else {
				qdGSL4L8 = itf5KSSf.prepareStatement("INSERT INTO " + nameBD + ".Carritos VALUES (?,?,?,?,?)");
				Iterator<String> j8PhA2oj = cclACNjY.getArticulos().keySet().iterator();
				while (j8PhA2oj.hasNext()) {
					String Obu4hSDV = j8PhA2oj.next();
					Producto BbD1vHHb = getProduct(Obu4hSDV);
					int O7sn1FIZ = cclACNjY.getArticulos().get(Obu4hSDV);
					qdGSL4L8.setString(1, cclACNjY.getCodigo());
					qdGSL4L8.setString(2, BbD1vHHb.getCodigo());
					qdGSL4L8.setString(3, BbD1vHHb.getNombre());
					qdGSL4L8.setDouble(4, BbD1vHHb.getPrecio());
					qdGSL4L8.setInt(5, O7sn1FIZ);
					ZPjMFNOT = qdGSL4L8.executeUpdate();
					if (ZPjMFNOT != 1) {
						itf5KSSf.rollback();
						break;
					}
					qdGSL4L8.clearParameters();
				}
				itf5KSSf.commit();
				s51lYU9h = true;
			}
		} catch (SQLException SPED73ui) {
			logger.log(Level.SEVERE, "Error a?adiendo carrito al registro", SPED73ui);
			try {
				itf5KSSf.rollback();
			} catch (SQLException AQ8ZGta4) {
				logger.log(Level.SEVERE,
						"Error haciendo rollback de la transacci¨®n para insertar carrito en el registro", AQ8ZGta4);
			}
		} finally {
			cerrarConexionYStatement(itf5KSSf, qdGSL4L8, cDPe1OC9);
		}
		return s51lYU9h;
	}

}