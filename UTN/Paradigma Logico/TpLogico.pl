%% Mi Cursada Universitaria %%

%% Base de Datos %%

%materia(nombre,horas por semana).
materia(analisis_Matematico_I,5).
materia(algebra_y_Geometria_Analitica,5).
materia(matematica_Discreta,3).
materia(sistemas_y_Organizaciones,3).
materia(algoritmo_y_Estructuras_de_Datos,5).
materia(arquitectura_de_Computadoras,4).
materia(ingenieria_y_Sociedad,2).
materia(quimica,3).
materia(fisica_I,5).
materia(analisis_Matematico_II,5).
materia(probabilidad_y_Estadistica,3).
materia(analisis_de_Sistemas,6).
materia(sintaxis_y_Semantica_de_los_Lenguajes,4).
materia(paradigmas_de_Programacion,4).
materia(ingles_I,2).
materia(sistemas_de_Representacion,3).
materia(sistemas_Operativos,4).
materia(disenio_de_Sistemas,6).
materia(fisica_II,5).
materia(matematica_Superior,4).
materia(gestion_de_Datos,4).
materia(legislacion,2).
materia(economia,3).
materia(ingles_II,2).
materia(redes_de_Informacion,4).
materia(administracion_de_Recursos,6).
materia(investigacion_Operativa,5).
materia(simulacion,4).
materia(ingenieria_de_Software,3).
materia(teoria_de_Control,3).
materia(comunicaciones,4).
materia(proyecto_Final,6).
materia(inteligencia_Artificial,3).
materia(administracion_Gerencial,3).
materia(sistemas_de_Gestion,4).

integradora(sistemas_y_Organizaciones).
integradora(analisis_de_Sistemas).
integradora(disenio_de_Sistemas).
integradora(administracion_de_Recursos).
integradora(proyecto_Final).

%correlativas(nombre,lista de correlativas)
correlativas(analisis_de_Sistemas,[sistemas_y_Organizaciones, algoritmos_y_Estructuras_de_Datos]).
correlativas(analisis_Matematico_II,[analisis_Matematico_I, algebra_y_Geometria_Analitica]).
correlativas(sintaxis_y_Semantica_de_los_Lenguajes,[matematica_Discreta, algoritmos_y_Estructuras_de_Datos]).
correlativas(paradigmas_de_Programacion,[matematica_Discreta, algoritmos_y_Estructuras_de_Datos]).
correlativas(probabilidad_y_Estadistica,[analisis_Matematico_I, algebra_y_Geometria_Analitica]).
correlativas(disenio_de_Sistemas,[analisis_de_Sistemas, paradigmas_de_Programacion]).
correlativas(sistemas_Operativos,[matematica_Discreta, algoritmos_y_Estructuras_de_Datos, arquitectura_de_Computadoras]).
correlativas(fisica_II,[analisis_Matematico_I, fisica_I]).
correlativas(economia,[analisis_de_Sistemas]).
correlativas(gestion_de_Datos,[analisis_de_Sistemas, paradigmas_de_Programacion, sintaxis_y_Semantica_de_los_Lenguajes]).
correlativas(ingles_II,[ingles_I]).
correlativas(matematica_Superior,[analisis_Matematico_II]).
correlativas(legislacion,[analisis_de_Sistemas, ingenieria_y_Sociedad]).
correlativas(administracion_de_Recursos,[disenio_de_Sistemas, sistemas_Operativos, economia]).
correlativas(ingenieria_de_Software,[probabilidad_y_Estadistica, disenio_de_Sistemas, gestion_de_Datos]).
correlativas(teoria_de_Control,[quimica, matematica_Superior]).
correlativas(comunicaciones,[arquitectura_de_Computadoras, analisis_Matematico_II, fisica_II]).
correlativas(redes_de_Inforrmacion,[sistemas_Operativos, comunicaciones]).
correlativas(investigacion_Operativa,[probabilidad_y_Estadistica, matematica_Superior]).
correlativas(simulacion,[probabilidad_y_Estadistica, matematica_Superior]).
correlativas(inteligencia_Artificial,[investigacion_Operativa, simulacion]).
correlativas(administracion_Gerencial,[administracion_de_Recursos, investigacion_Operativa]).
correlativas(sistemas_de_Gestion,[administracion_de_Recursos, investigacion_Operativa, simulacion]).
correlativas(proyecto_Final,[legislacion, administracion_de_Recursos, redes_de_Informacion, ingenieria_de_Software]).



% Las Materias %

%1) Las materias pesadas son las integradoras de 6 horas por semana y las que sin ser integradoras tienen al menos 4 horas por semana.
materiaPesada(Materia):-
    materia(Materia,Horas),
    integradora(Materia),
    Horas = 6.
materiaPesada(Materia):-
    materia(Materia,Horas),
    not(integradora(Materia)),
    Horas >= 4.

%2)
%A- Las materias iniciales son aquellas que no piden ninguna materia para cursarlas.
materiaInicial(Materia):-
    materia(Materia,_),
    not(correlativas(Materia,_)).

%B- Todas las materias necesarias para cursar una materia.
materiasNecesarias(Materia,MateriaNecesaria):- %directas
    correlativas(Materia,Correlativas),
    member(MateriaNecesaria,Correlativas).
materiasNecesarias(Materia,MateriaNecesaria):- %indirectas
    correlativas(Materia,Correlativas),
    member(X,Correlativas),
    materiasNecesarias(X,MateriaNecesaria).

%C- Todas las materias que habilita una materia.
queMateriasHabilita(Materia,MateriaHabilitada):-
    materia(Materia,_),
    materiasNecesarias(MateriaHabilitada,Materia).

% Lxs estudiantes %

% Criterios para aprobar la cursada de una materia.
cursada(Estudiante,Materia):- %cursada normal
    materia(Materia,_),
    estudiante(Estudiante,Materia,NotaCursada,_,_,_),
    between(6,10,NotaCursada).
cursada(Estudiante,Materia):- %por aprobar el final libre
    materia(Materia,_),
    estudiante(Estudiante,Materia,0,NotaFinal,_,libre),
    between(6,10,NotaFinal).

% Criterios para aprobar una materia.
aprobada(Estudiante,Materia):- %aprobada por promocion
    materia(Materia,_),
    estudiante(Estudiante,Materia,NotaCursada,_,_,_),
    cursada(Estudiante,Materia),
    NotaCursada > 7.
aprobada(Estudiante,Materia):- %aprobada por final
    materia(Materia,_),
    estudiante(Estudiante,Materia,NotaCursada,NotaFinal,_,_),
    cursada(Estudiante,Materia),
    between(6,7,NotaCursada),
    between(6,10,NotaFinal).
aprobada(Estudiante,Materia):- %aprobada por final libre
    materia(Materia,_),
    estudiante(Estudiante,Materia,0,NotaFinal,_,libre),
    between(6,10,NotaFinal).

%3
%A- Las materias cursadas de un estudiante.
materiasCursadas(Estudiante,Materias):-
    findall(Materia,cursada(Estudiante,Materia),Materias).

%B- Las materias aprobadas de un estudiante.
materiasAprobadas(Estudiante,Materias):-
    findall(Materia,aprobada(Estudiante,Materia),Materias).

% Casos de prueba %
%estudiante(estudiante,materia,nota de la cursada,nota del final,año que curso la materia,modalidad)
estudiante(vero,analisis_Matematico_I,8,0,2016,anual).
estudiante(vero,algebra_y_Geometria_Analitica,8,0,2016,anual).
estudiante(vero,matematica_Discreta,8,0,2016,anual).
estudiante(vero,sistemas_y_Organizaciones,8,0,2016,anual).
estudiante(vero,algoritmo_y_Estructuras_de_Datos,8,0,2016,anual).
estudiante(vero,arquitectura_de_Computadoras,8,0,2016,anual).
estudiante(vero,ingenieria_y_Sociedad,8,0,2016,cuatrimestre2).
estudiante(vero,fisica_I,8,0,2017,anual).
estudiante(vero,ingles_I,8,0,2017,cuatrimestre1).
estudiante(vero,sistemas_de_Representacion,8,0,2017,anual).
estudiante(vero,ingles_II,0,10,2017,libre).

estudiante(alan,sistemas_y_Organizaciones,6,4,2016,anual).
estudiante(alan,analisis_Matematico_I,6,0,2016,anual).
estudiante(alan,analisis_de_Sistemas,2,0,2017,anual).
estudiante(alan,analisis_de_Sistemas,9,0,2018,anual).
estudiante(alan,fisica_I,2,0,2017,anual).
estudiante(alan,ingles_I,0,2,2017,cuatrimestre1).

% Casos de prueba (perfiles)
estudiante(conMuchasRecursadas,quimica,2,0,2016,anual).
estudiante(conMuchasRecursadas,quimica,3,0,2017,cuatrimestre1).
estudiante(conMuchasRecursadas,quimica,4,0,2017,cuatrimestre2).
estudiante(conMuchasRecursadas,quimica,5,0,2018,anual).
estudiante(conMuchasRecursadas,fisica_I,2,0,2017,verano).
estudiante(conMuchasRecursadas,fisica_I,2,0,2018,anual).

estudiante(conAlgunasRecursadas,quimica,2,0,2016,anual).
estudiante(conAlgunasRecursadas,quimica,3,0,2017,cuatrimestre2).
estudiante(conAlgunasRecursadas,fisica_I,2,0,2017,anual).
estudiante(conAlgunasRecursadas,fisica_I,10,0,2018,cuatrimestre1).

estudiante(veraniego,quimica,6,0,2016,anual).
estudiante(veraniego,fisica_I,6,0,2016,verano).
estudiante(veraniego,matematica_Discreta,2,0,2017,anual).
estudiante(veraniego,matematica_Discreta,8,0,2017,verano).

estudiante(atr,quimica,10,0,2016,cuatrimestre1).
estudiante(atr,fisica_I,10,0,2016,cuatrimestre2).

% Modalidades %

% Estudiante de prueba
estudiante(roberto,sistemas_y_Organizaciones,8,0,2015,anual).
estudiante(roberto,quimica,2,0,2015,cuatrimestre1).
estudiante(roberto,quimica,8,0,2015,cuatrimestre2).
estudiante(roberto,fisica_I,10,0,2015,verano).

%4- Año lectivo en que un estudiante cursó x materia.
anioCursado(Estudiante,Materia,Anio):-
    estudiante(Estudiante,Materia,_,_,Anio,Modalidad),
    Modalidad \= verano.
anioCursado(Estudiante,Materia,Anio):-
    estudiante(Estudiante,Materia,_,_,Anio1,verano),
    Anio is Anio1 + 1.

%5- Materias recursadas por un estudiante.
materiaQueRecurso(Estudiante,Materia):-
    estudiante(Estudiante,Materia,_,_,Anio1,_),
    estudiante(Estudiante,Materia,_,_,Anio2,_),
    Anio1 \= Anio2.
materiaQueRecurso(Estudiante,Materia):-
    estudiante(Estudiante,Materia,_,_,Anio,Modalidad1),
    estudiante(Estudiante,Materia,_,_,Anio,Modalidad2),
    Modalidad1 \= Modalidad2.

%6- Perfiles de estudiantes.
% Siempre que recursó una materia la volvió a cursar inmediatamente a continuación de haberla cursado originalmente.
sinDescanso(Estudiante):-
    estudiante(Estudiante,_,_,_,_,_),
    materiaQueRecurso(Estudiante,_),
    forall((estudiante(Estudiante,Materia,_,_,_,_),materiaQueRecurso(Estudiante,Materia)),recursoInmediato(Estudiante,Materia)).
% funciones auxiliares para sinDescanso.
recursoInmediato(Estudiante,Materia):-
    materiaQueRecurso(Estudiante,Materia),
    estudiante(Estudiante,Materia,_,_,Anio,cuatrimestre1),
    estudiante(Estudiante,Materia,_,_,Anio,cuatrimestre2).
recursoInmediato(Estudiante,Materia):-
    materiaQueRecurso(Estudiante,Materia),
    estudiante(Estudiante,Materia,_,_,Anio,cuatrimestre2),
    Anio1 is Anio + 1,
    estudiante(Estudiante,Materia,_,_,Anio1,Modalidad),
    not(Modalidad = cuatrimestre2),
    not(Modalidad = verano).
recursoInmediato(Estudiante,Materia):-
    materiaQueRecurso(Estudiante,Materia),
    estudiante(Estudiante,Materia,_,_,Anio,anual),
    Anio1 is Anio + 1,
    estudiante(Estudiante,Materia,_,_,Anio1,Modalidad),
    not(Modalidad = cuatrimestre2),
    not(Modalidad = verano).
recursoInmediato(Estudiante,Materia):-
    materiaQueRecurso(Estudiante,Materia),
    estudiante(Estudiante,Materia,_,_,Anio,verano),
    Anio1 is Anio + 1,
    estudiante(Estudiante,Materia,_,_,Anio1,Modalidad),
    not(Modalidad = cuatrimestre2),
    not(Modalidad = verano).
    
% Nunca recursó una materia.
invictus(Estudiante):-
    estudiante(Estudiante,_,_,_,_,_),
    forall(estudiante(Estudiante,Materia,_,_,_,_),not(materiaQueRecurso(Estudiante,Materia))).
    
% Cursó alguna materia de manera anual y no aprobó, pero como venía más o menos, prefirió volver a cursarla en el 
% primer cuatrimestre del próximo año, donde la promocionó.
repechaje(Estudiante):-
    estudiante(Estudiante,Materia,_,_,Anio,anual),
    materiaQueRecurso(Estudiante,Materia),
    Anio1 is Anio + 1,
    estudiante(Estudiante,Materia,X,_,Anio1,cuatrimestre1),
    between(8,10,X).

% Promocionó todas las materias que cursó.
buenasCursadas(Estudiante):-
    estudiante(Estudiante,_,_,_,_,_),
    forall(estudiante(Estudiante,Materia,X,Y,_,_),(aprobada(Estudiante,Materia),Y=0,between(8,10,X))).

% Desde que empezó a cursar, todos los veranos cursó alguna materia.
seLoQueHicisteElVeranoPasado(Estudiante):-
    findall(Anio,estudiante(Estudiante,_,_,_,Anio,_),Lista),
    min_member(PrimerAnio,Lista),
    max_member(UltimoAnio,Lista),
    forall(between(PrimerAnio, UltimoAnio, X),estudiante(Estudiante,_,_,_,X,verano)).

%7 Aquellos estudiantes que cumplen únicamente con un perfil.
unicoPerfil(Estudiante):-
    sinDescanso(Estudiante),
    not(invictus(Estudiante)),
    not(repechaje(Estudiante)),
    not(buenasCursadas(Estudiante)),
    not(seLoQueHicisteElVeranoPasado(Estudiante)).

unicoPerfil(Estudiante):-
    not(sinDescanso(Estudiante)),
    invictus(Estudiante),
    not(repechaje(Estudiante)),
    not(buenasCursadas(Estudiante)),
    not(seLoQueHicisteElVeranoPasado(Estudiante)).

unicoPerfil(Estudiante):-
    not(sinDescanso(Estudiante)),
    not(invictus(Estudiante)),
    repechaje(Estudiante),
    not(buenasCursadas(Estudiante)),
    not(seLoQueHicisteElVeranoPasado(Estudiante)).

unicoPerfil(Estudiante):-
    not(sinDescanso(Estudiante)),
    not(invictus(Estudiante)),
    not(repechaje(Estudiante)),
    buenasCursadas(Estudiante),
    not(seLoQueHicisteElVeranoPasado(Estudiante)).

unicoPerfil(Estudiante):-
    not(sinDescanso(Estudiante)),
    not(invictus(Estudiante)),
    not(repechaje(Estudiante)),
    not(buenasCursadas(Estudiante)),
    seLoQueHicisteElVeranoPasado(Estudiante).

% Desempeño academico %
% Índice de desempeño académico de un alumno, calculado de la siguiente manera:
% Anuales:  Se considera la nota de cursada.
% Cuatrimestrales: Se considera la nota de cursada menos el nro de cuatrimestre.
% De verano: Se considera la mitad de la nota de cursada, excepto si el año calendario es par, en cuyo caso se considera 5.

desempenioAcademico(estudiante(Estudiante,Materia,X,_,Anio,Modalidad),Desempenio):-
    estudiante(Estudiante,Materia,X,_,Anio,Modalidad),
    Modalidad = anual,
    Desempenio = X.
desempenioAcademico(estudiante(Estudiante,Materia,X,_,Anio,Modalidad),Desempenio):-
    estudiante(Estudiante,Materia,X,_,Anio,Modalidad),
    Modalidad = cuatrimestre1,
    Desempenio is X-1.
desempenioAcademico(estudiante(Estudiante,Materia,X,_,Anio,Modalidad),Desempenio):-
    estudiante(Estudiante,Materia,X,_,Anio,Modalidad),
    Modalidad = cuatrimestre2,
    Desempenio is X-2.
desempenioAcademico(estudiante(Estudiante,Materia,X,_,Anio,Modalidad),Desempenio):-
    estudiante(Estudiante,Materia,X,_,Anio,Modalidad),
    Modalidad = verano,
    not(even(Anio)),
    Desempenio is X / 2.
desempenioAcademico(estudiante(Estudiante,Materia,X,_,Anio,Modalidad),Desempenio):-
    estudiante(Estudiante,Materia,X,_,Anio,Modalidad),
    Modalidad = verano,
    even(Anio),
    Desempenio is 5.

even(X) :-
    Y is mod(X,2),
    Y =:= 0.

promedioDesempenio(Estudiante,Promedio):-
    findall(Desempenio,desempenioAcademico(estudiante(Estudiante,_,_,_,_,_),Desempenio),Lista),
    sumlist(Lista,Suma),
    length(Lista,Cant),
    Promedio is Suma / Cant.
