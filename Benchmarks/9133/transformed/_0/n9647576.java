class n9647576 {
	private void Reserve() throws SQLException {
		Statement rgEZeKg4, HXrlVW4a;
		String XzHt6HgP = "";
		if (useragent)
			XzHt6HgP = "agent";
		else
			XzHt6HgP = "user";
		String yRYPl1SC = "";
		String JIOJF3za = "";
		String SId8yWlm = String.valueOf(System.currentTimeMillis());
		String mn0ceuXD;
		String MJWnph8v;
		try {
			if (useragent) {
				JIOJF3za = "update hp_administrator.agent_bookings set BOOKINGS = xmlquery('copy $new := $BOOKINGS modify do insert ";
				JIOJF3za += " <detail booking_id=\"" + booking_details.getTicketno() + "\" status=\"open\" train_no=\""
						+ booking_details.getTrain_no() + "\" source=\"" + booking_details.getSource() + "\" dest=\""
						+ booking_details.getDestination() + "\" dep_date=\"" + booking_details.getDate() + "\" > ";
			} else if (!useragent) {
				yRYPl1SC = "update hp_administrator.user_bookings set BOOKINGS = xmlquery('copy $new := $BOOKINGS modify do insert ";
				yRYPl1SC += " <detail booking_id=\"" + booking_details.getTicketno() + "\" status=\"open\" train_no=\""
						+ booking_details.getTrain_no() + "\" source=\"" + booking_details.getSource() + "\" dest=\""
						+ booking_details.getDestination() + "\" dep_date=\"" + booking_details.getDate() + "\" > ";
			}
			for (int bTAucO2e = 0; bTAucO2e < booking_details.getNoOfPersons(); bTAucO2e++) {
				mn0ceuXD = coach.get(bTAucO2e);
				MJWnph8v = seatno.get(bTAucO2e);
				if (!mn0ceuXD.equals("WL")) {
					String PnHtDflO = "update hp_administrator.chart_wl_order set AVAILABLE_BOOKED = xmlquery('copy $new := $AVAILABLE_BOOKED   modify do insert ";
					PnHtDflO += "<seat number=\"" + MJWnph8v + "\"><details user_id=\"" + booking_details.getUserId()
							+ "\" usertype=\"" + XzHt6HgP + "\" ticket_no=\"" + booking_details.getTicketno()
							+ "\" name=\"" + booking_details.getNameAt(bTAucO2e) + "\" age=\""
							+ booking_details.getAgeAt(bTAucO2e) + "\" sex=\"" + booking_details.getSexAt(bTAucO2e)
							+ "\" type=\"primary\"  /></seat>";
					PnHtDflO += " into $new/status/class[@name=\"" + booking_details.getTclass()
							+ "\"]/coach[@number=\"" + mn0ceuXD + "\"] ";
					PnHtDflO += " return  $new' ) where train_no like '" + booking_details.getTrain_no()
							+ "' and date = '" + booking_details.getDate() + "' ";
					System.out.println(PnHtDflO);
					HXrlVW4a = conn.createStatement();
					int sqLSNmE4 = HXrlVW4a.executeUpdate(PnHtDflO);
					if (sqLSNmE4 > 0)
						System.out.println("chart_wl  availability  updated");
				} else if (mn0ceuXD.equals("WL")) {
					String ATkNUPYB = "update hp_administrator.chart_wl_order set WAITLISTING = xmlquery('copy $new := $WAITLISTING modify do insert ";
					ATkNUPYB += "<details user_id=\"" + booking_details.getUserId() + "\" usertype=\"" + XzHt6HgP
							+ "\" ticket_no=\"" + booking_details.getTicketno() + "\" name=\""
							+ booking_details.getNameAt(bTAucO2e) + "\" age=\"" + booking_details.getAgeAt(bTAucO2e)
							+ "\" sex=\"" + booking_details.getSexAt(bTAucO2e) + "\" type=\"primary\" /></seat>";
					ATkNUPYB += " into $new/status/class[@name=\"" + booking_details.getTclass() + "\"] ";
					ATkNUPYB += " return  $new' ) where train_no like '" + booking_details.getTrain_no()
							+ "' and date = '" + booking_details.getDate() + "' ";
					System.out.println(ATkNUPYB);
					HXrlVW4a = conn.createStatement();
					int pkIa5A6Z = HXrlVW4a.executeUpdate(ATkNUPYB);
					if (pkIa5A6Z > 0)
						System.out.println("chart_wl  waitlisting  updated");
				}
				if (useragent)
					JIOJF3za += "<person><coach>" + mn0ceuXD + "</coach><seat>" + MJWnph8v + "</seat></person>";
				else
					yRYPl1SC += "<person><coach>" + mn0ceuXD + "</coach><seat>" + MJWnph8v + "</seat></person>";
			}
			if (useragent) {
				JIOJF3za += "</detail>   as first into $new/book return  $new' ) where agent_id like '"
						+ booking_details.getUserId() + "'";
				System.out.println(JIOJF3za);
				rgEZeKg4 = conn.createStatement();
				int rvSyV2qM = rgEZeKg4.executeUpdate(JIOJF3za);
				if (rvSyV2qM > 0)
					System.out.println("agent bookings updated");
			} else {
				yRYPl1SC += "</detail>   as first into $new/book return  $new' ) where user_id like '"
						+ booking_details.getUserId() + "'";
				System.out.println(yRYPl1SC);
				rgEZeKg4 = conn.createStatement();
				int xwlnC2OA = rgEZeKg4.executeUpdate(yRYPl1SC);
				if (xwlnC2OA > 0)
					System.out.println("user bookings  updated");
			}
		} catch (SQLException XcaSlI1O) {
			conn.rollback();
			XcaSlI1O.printStackTrace();
		}
	}

}