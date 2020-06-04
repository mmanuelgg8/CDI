INSERT INTO USUARIO (USERNAME,DTYPE,EMAIL,NOMBRE,PASSWORD,ROL_GESTOR) VALUES ('gestor','PDI','gestor@gestor.com','Gestor','gestor',1)
INSERT INTO USUARIO (USERNAME,DTYPE,EMAIL,NOMBRE,PASSWORD,ROL_GESTOR) VALUES ('pdi','PDI','pdi@pdi.com','PDI','pdi',0)
INSERT INTO USUARIO (USERNAME,DTYPE,EMAIL,NOMBRE,PASSWORD) VALUES ('alumno','ALUMNO','alumno@alumno.com','Alumno','alumno')
INSERT INTO USUARIO (USERNAME,DTYPE,EMAIL,NOMBRE,PASSWORD) VALUES ('pas','PAS','pas@pas.com','PAS','pas')
INSERT INTO USUARIO (USERNAME,DTYPE,EMAIL,NOMBRE,PASSWORD) VALUES ('ong','ONG','ong@ong.com','ONG','ong')
INSERT INTO PROYECTO (ID, ESTADO, FECHA, NOMBRE, REQUISITOS, ES_CREADO_POR_USERNAME) VALUES (1, 0, '2020-06-04', 'Por un mundo más limpio', 'Si eres menor de edad hay que traer permiso parental.', 'gestor')
INSERT INTO ACTIVIDAD (ID, ZONA, ESTADO, FECHA, HORARIO, INFORMACION, NOMBRE, REQUISITOS, TIPO, ES_GESTIONADA_USERNAME, ES_GESTIONADA_POR_USERNAME, PERTENECE_A_ID) VALUES (2, 'Centro Málaga', 1, '2020-06-04', 'Mañana', 'Se dispondrá de material necesario.', 'Recogida de basura', 'Si eres menor de edad hay que traer permiso parental.', 0, 'gestor', 'ong', 1)

