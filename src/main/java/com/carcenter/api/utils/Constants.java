package com.carcenter.api.utils;

public class Constants {
	
	public static final String TIPOS_IDENTIFICACION="TIDE";
	public static final String LIMT_MECA_DISPONIBLES="LMDI";
	public static final String MANT_SIN_ASIGNAR="S";
	public static final String ESTADO_ACTIVO="A";
	public static final String ESTADO_INACTIVO="I";
	public static final String ESTADO_NO_ASIGNADO="S";
	
	public static final String CONS_MEC_DISP = "SELECT mec.documento as documento, mec.tipo_documento as tipo_documento,\r\n"
			+ "	CONCAT(mec.primer_nombre , mec.segundo_nombre ,' ', mec.primer_apellido , mec.segundo_apellido) as nombre_completo,\r\n"
			+ "	SUM(allM.tiempo_asignacion) as tiempo_asignacion\r\n"
			+ "FROM (\r\n"
			+ "	(SELECT mec.documento as documento, mec.tipo_documento as tipo_documento,\r\n"
			+ "			0 as tiempo_asignacion FROM mecanicos mec \r\n"
			+ "	LEFT JOIN mantenimientos man\r\n"
			+ "	ON mec.tipo_documento = man.mec_tipo_documento and mec.documento = man.mec_documento\r\n"
			+ "	WHERE man.mec_documento is null and man.mec_tipo_documento is null and mec.estado = 'A')\r\n"
			+ "		UNION ALL\r\n"
			+ "	(SELECT mec.documento, mec.tipo_documento, IFNULL(SUM(sxm.tiempo_estimado),0) as tiempo_asignacion\r\n"
			+ "		FROM mecanicos mec, mantenimientos man \r\n"
			+ "		INNER JOIN servicios_x_mantenimiento sxm\r\n"
			+ "		ON man.codigo = sxm.cod_mantenimiento\r\n"
			+ "	WHERE mec.tipo_documento = man.mec_tipo_documento\r\n"
			+ "		AND mec.documento = man.mec_documento\r\n"
			+ "		AND mec.estado = 'A' \r\n"
			+ "		AND man.estado = 'T'\r\n"
			+ "		AND fecha BETWEEN DATE_FORMAT(LAST_DAY(DATE_SUB(SYSDATE(), INTERVAL 1 MONTH)) ,'%Y-%m-01') AND LAST_DAY(DATE_SUB(SYSDATE(), INTERVAL 1 MONTH))\r\n"
			+ "	GROUP BY mec.documento, mec.tipo_documento\r\n"
			+ "	ORDER BY tiempo_asignacion)\r\n"
			+ "		UNION ALL\r\n"
			+ "	(SELECT mec.documento, mec.tipo_documento, IFNULL(SUM(rxm.tiempo_estimado),0) as tiempo_asignacion\r\n"
			+ "		FROM mecanicos mec, mantenimientos man \r\n"
			+ "		INNER JOIN repuestos_x_mantenimiento rxm\r\n"
			+ "		ON man.codigo = rxm.cod_mantenimiento\r\n"
			+ "	WHERE mec.tipo_documento = man.mec_tipo_documento\r\n"
			+ "		AND mec.documento = man.mec_documento\r\n"
			+ "		AND mec.estado = 'A' \r\n"
			+ "		AND man.estado = 'T'\r\n"
			+ "		AND fecha BETWEEN DATE_FORMAT(LAST_DAY(DATE_SUB(SYSDATE(), INTERVAL 1 MONTH)) ,'%Y-%m-01') AND LAST_DAY(DATE_SUB(SYSDATE(), INTERVAL 1 MONTH))\r\n"
			+ "	GROUP BY mec.documento, mec.tipo_documento\r\n"
			+ "	ORDER BY tiempo_asignacion)\r\n"
			+ ") allM\r\n"
			+ "LEFT JOIN mecanicos mec \r\n"
			+ "ON allM.documento = mec.documento\r\n"
			+ "AND allM.tipo_documento = mec.tipo_documento\r\n"
			+ "GROUP BY allM.documento, allM.tipo_documento\r\n"
			+ "ORDER BY allM.tiempo_asignacion\r\n"
			+ "LIMIT 0 , ?1";
	
}
