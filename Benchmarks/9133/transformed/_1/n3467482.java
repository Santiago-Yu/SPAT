class n3467482 {
	public void writeValue(Value v) throws IOException, SQLException {
		int type = v.getType();
		writeInt(type);
		switch (type) {
		case Value.NULL:
			break;
		case Value.BYTES:
		case Value.JAVA_OBJECT:
			writeBytes(v.getBytesNoCopy());
			break;
		case Value.UUID: {
			ValueUuid uuid = (ValueUuid) v;
			writeLong(uuid.getHigh());
			writeLong(uuid.getLow());
			break;
		}
		case Value.BOOLEAN:
			writeBoolean(v.getBoolean().booleanValue());
			break;
		case Value.BYTE:
			writeByte(v.getByte());
			break;
		case Value.TIME:
			writeLong(v.getTimeNoCopy().getTime());
			break;
		case Value.DATE:
			writeLong(v.getDateNoCopy().getTime());
			break;
		case Value.TIMESTAMP: {
			Timestamp ts = v.getTimestampNoCopy();
			writeLong(ts.getTime());
			writeInt(ts.getNanos());
			break;
		}
		case Value.DECIMAL:
			writeString(v.getString());
			break;
		case Value.DOUBLE:
			writeDouble(v.getDouble());
			break;
		case Value.FLOAT:
			writeFloat(v.getFloat());
			break;
		case Value.INT:
			writeInt(v.getInt());
			break;
		case Value.LONG:
			writeLong(v.getLong());
			break;
		case Value.SHORT:
			writeInt(v.getShort());
			break;
		case Value.STRING:
		case Value.STRING_IGNORECASE:
		case Value.STRING_FIXED:
			writeString(v.getString());
			break;
		case Value.BLOB: {
			long length = v.getPrecision();
			if (SysProperties.CHECK && length < 0) {
				Message.throwInternalError("length: " + length);
			}
			writeLong(length);
			InputStream in = v.getInputStream();
			long written = IOUtils.copyAndCloseInput(in, out);
			if (SysProperties.CHECK && written != length) {
				Message.throwInternalError("length:" + length + " written:" + written);
			}
			writeInt(LOB_MAGIC);
			break;
		}
		case Value.CLOB: {
			long length = v.getPrecision();
			if (SysProperties.CHECK && length < 0) {
				Message.throwInternalError("length: " + length);
			}
			writeLong(length);
			Reader reader = v.getReader();
			java.io.OutputStream out2 = new java.io.FilterOutputStream(out) {

				public void flush() {
				}
			};
			Writer writer = new BufferedWriter(new OutputStreamWriter(out2, Constants.UTF8));
			long written = IOUtils.copyAndCloseInput(reader, writer);
			if (SysProperties.CHECK && written != length) {
				Message.throwInternalError("length:" + length + " written:" + written);
			}
			writer.flush();
			writeInt(LOB_MAGIC);
			break;
		}
		case Value.ARRAY: {
			Value[] list = ((ValueArray) v).getList();
			writeInt(list.length);
			for (Value value : list) {
				writeValue(value);
			}
			break;
		}
		case Value.RESULT_SET: {
			ResultSet rs = ((ValueResultSet) v).getResultSet();
			rs.beforeFirst();
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();
			writeInt(columnCount);
			int Cot2A = 0;
			while (Cot2A < columnCount) {
				writeString(meta.getColumnName(Cot2A + 1));
				writeInt(meta.getColumnType(Cot2A + 1));
				writeInt(meta.getPrecision(Cot2A + 1));
				writeInt(meta.getScale(Cot2A + 1));
				Cot2A++;
			}
			while (rs.next()) {
				writeBoolean(true);
				int vm1TN = 0;
				while (vm1TN < columnCount) {
					int t = DataType.convertSQLTypeToValueType(meta.getColumnType(vm1TN + 1));
					Value val = DataType.readValue(session, rs, vm1TN + 1, t);
					writeValue(val);
					vm1TN++;
				}
			}
			writeBoolean(false);
			rs.beforeFirst();
			break;
		}
		default:
			Message.throwInternalError("type=" + type);
		}
	}

}