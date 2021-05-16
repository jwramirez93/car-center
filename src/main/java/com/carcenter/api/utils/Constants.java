package com.carcenter.api.utils;

public class Constants {
	
	public static final String TIPOS_IDENTIFICACION="TIDE";
	public static final String LIMT_MECA_DISPONIBLES="LMDI";
	public static final String MANT_SIN_ASIGNAR="S";
	public static final String ESTADO_ACTIVO="A";
	public static final String ESTADO_INACTIVO="I";
	
	public static final String CONS_MEC_DISP = "SELECT mec.documento as documento, mec.tipo_documento as tipo_documento, \r\n"
			+ "	CONCAT(mec.primer_nombre , mec.segundo_nombre ,' ', mec.primer_apellido , mec.segundo_apellido) as nombre_completo,\r\n"
			+ "	0 as tiempo_asignacion FROM mecanicos mec LEFT JOIN mantenimientos man\r\n"
			+ "ON mec.tipo_documento = man.mec_tipo_documento and mec.documento = man.mec_documento\r\n"
			+ "WHERE man.mec_documento is null and man.mec_tipo_documento is null and mec.estado = 'A'\r\n"
			+ "UNION ALL\r\n"
			+ "SELECT mec.documento as documento, mec.tipo_documento as tipo_documento,\r\n"
			+ "	CONCAT(mec.primer_nombre , mec.segundo_nombre ,' ', mec.primer_apellido , mec.segundo_apellido) as nombre_completo,\r\n"
			+ "	mec_ava.tiempo_asignacion as tiempo_asignacion FROM (\r\n"
			+ "	SELECT mec.documento, mec.tipo_documento, SUM(sxm.tiempo_estimado) as tiempo_asignacion\r\n"
			+ "	FROM mecanicos mec, mantenimientos man, servicios_x_mantenimiento sxm\r\n"
			+ "	where mec.tipo_documento = man.mec_tipo_documento\r\n"
			+ "	and mec.documento = man.mec_documento\r\n"
			+ "	and mec.estado = 'A' and man.estado = 'T' and man.estado != 'A'\r\n"
			+ "	and man.codigo = sxm.cod_mantenimiento\r\n"
			+ "	and fecha BETWEEN DATE_FORMAT(LAST_DAY(DATE_SUB(SYSDATE(), INTERVAL 1 MONTH)) ,'%Y-%m-01') and LAST_DAY(DATE_SUB(SYSDATE(), INTERVAL 1 MONTH))\r\n"
			+ "	group by mec.documento, mec.tipo_documento\r\n"
			+ "	order by tiempo_asignacion LIMIT 0 , 10) mec_ava\r\n"
			+ "	LEFT JOIN mecanicos mec ON mec_ava.documento = mec.documento\r\n"
			+ "	AND mec_ava.tipo_documento = mec.tipo_documento";
	
}
