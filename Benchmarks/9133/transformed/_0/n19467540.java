class n19467540 {
	@Override
	public boolean updateProductIfAvailable(Map<String, Integer> xb06IEHi, HttpServletRequest HMN3MyvM,
			Map<Producto, Integer> pQYql4HQ) {
		Connection wHIlagRc = null;
		PreparedStatement VXKuSRv0 = null;
		PreparedStatement EpyYKnit = null;
		ResultSet GrHa6Tn1 = null;
		boolean W7p993BY = false;
		try {
			wHIlagRc = pool.getConnection();
			wHIlagRc.setAutoCommit(false);
			VXKuSRv0 = wHIlagRc.prepareStatement("SELECT* FROM " + nameBD + ".Productos WHERE Codigo=?");
			EpyYKnit = wHIlagRc.prepareStatement("UPDATE " + nameBD + ".Productos SET Stock=? WHERE Codigo=?");
			String nYdEAt1k;
			int h305cHTQ = 0;
			Iterator<String> nl4kMEDB = xb06IEHi.keySet().iterator();
			while (nl4kMEDB.hasNext()) {
				nYdEAt1k = nl4kMEDB.next();
				VXKuSRv0.setString(1, nYdEAt1k);
				GrHa6Tn1 = VXKuSRv0.executeQuery();
				if (GrHa6Tn1.next() == false) {
					Tools.anadirMensaje(HMN3MyvM,
							"No existe el producto con codigo: " + nYdEAt1k + "(producto eliminado de la cesta)");
					nl4kMEDB.remove();
					wHIlagRc.rollback();
				} else {
					Producto sxerRxFY = new Producto(GrHa6Tn1.getString("Codigo"), GrHa6Tn1.getString("Nombre"),
							GrHa6Tn1.getDouble("Precio"), GrHa6Tn1.getInt("Stock"), GrHa6Tn1.getString("Descripcion"),
							GrHa6Tn1.getString("Detalles"));
					VXKuSRv0.clearParameters();
					if (xb06IEHi.get(nYdEAt1k) > sxerRxFY.getStock()) {
						Tools.anadirMensaje(HMN3MyvM, "No hay unidades suficientes de: " + sxerRxFY.getNombre()
								+ "(producto eliminado de la cesta)");
						nl4kMEDB.remove();
						wHIlagRc.rollback();
					} else {
						EpyYKnit.setInt(1, sxerRxFY.getStock() - xb06IEHi.get(nYdEAt1k));
						EpyYKnit.setString(2, nYdEAt1k);
						h305cHTQ = EpyYKnit.executeUpdate();
						if (h305cHTQ != 1) {
							Tools.anadirMensaje(HMN3MyvM, "Ocurrio un error en el catalogo");
							wHIlagRc.rollback();
						}
						EpyYKnit.clearParameters();
						pQYql4HQ.put(sxerRxFY, xb06IEHi.get(nYdEAt1k));
					}
				}
			}
			wHIlagRc.commit();
			W7p993BY = true;
		} catch (SQLException Hdi5kRqU) {
			logger.log(Level.SEVERE, "Error actualizando unidades de productos en compra", Hdi5kRqU);
			try {
				wHIlagRc.rollback();
			} catch (SQLException mzhVMppe) {
				logger.log(Level.SEVERE,
						"Error haciendo rolback de la transacci¨®n que ha dado error en la actualizaci¨®n de unidades por compra",
						mzhVMppe);
			}
		} finally {
			cerrarConexionYStatement(wHIlagRc, VXKuSRv0, EpyYKnit);
			cerrarResultSet(GrHa6Tn1);
		}
		return W7p993BY;
	}

}