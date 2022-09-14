--Tesoros Piratas--
data Pirata = UnPirata{
    apodo :: String,
    botin :: [Tesoro],
    formaDeSaqueo :: (Tesoro -> Bool)
} deriving Show

data Tesoro= UnTesoro{
    nombre :: String,
    valor :: Number
} deriving Show


cantidadTesoros :: Pirata -> Number
cantidadTesoros pirata = length (botin pirata)

pirataAfortunado :: Pirata -> Bool
pirataAfortunado pirata = ((>10000).sum.(tomarDelTesoro valor)) pirata

tomarDelTesoro :: (Tesoro -> a) -> Pirata -> [a]
tomarDelTesoro funcion pirata = map funcion (botin pirata)

tesoroEnComun :: Pirata -> Pirata -> Bool
tesoroEnComun pirata1 pirata2 = length (eliminarDuplicado ((tomarDelTesoro nombre pirata1) ++ (tomarDelTesoro nombre pirata2)))< (length ((tomarDelTesoro nombre pirata1) ++ (tomarDelTesoro nombre pirata2)))

eliminarDuplicado :: (Eq a) => [a] -> [a]
eliminarDuplicado [] = []
eliminarDuplicado (x:xs) = x : eliminarDuplicado (filter (/= x) xs)

elValorDelTesoroMasValioso:: Pirata -> Number
elValorDelTesoroMasValioso pirata =  (maximum.(tomarDelTesoro valor)) pirata

nuevoTesoroAlPirata:: Tesoro -> Pirata -> Pirata 
nuevoTesoroAlPirata tesoro pirata = UnPirata (apodo pirata)  (tesoro : (botin pirata)) (formaDeSaqueo pirata)

sinTesorosValiosos :: Pirata -> Pirata
sinTesorosValiosos pirata  = UnPirata (apodo pirata) (filter (not.(esTesoroValioso))  (botin pirata)) (formaDeSaqueo pirata)

esTesoroValioso:: Tesoro -> Bool
esTesoroValioso tesoro = (valor tesoro) > 100

jackSparrow = UnPirata  "jackSparrow" [( UnTesoro "brujula" 10000),( UnTesoro "frascoDeArena"  0 )] saqueoTesoroValioso
davidJones = UnPirata "davidJones" [(UnTesoro "cajitaMusical"  1)] (saqueoComplejo saqueoTesoroQueEmpiezaConE saqueoTesoroValioso)
anneBonny = UnPirata "anneBonny" [(UnTesoro  "doblones" 100),( UnTesoro "frascoDeArena"  1)] (saqueoFobia oro)

piedraPreciosa=UnTesoro "piedraPreciosa" 500
escudoInvisible =UnTesoro "escudoInvisible" 100000
diamanteFalso=UnTesoro "diamanteFalso" 0
collar=UnTesoro "collar" 1450
oro =UnTesoro "oro" 100


--- TEMPORADA DE SAQUEOS ---

noSaqueaNada::Tesoro -> Bool
noSaqueaNada tesoro = False

saqueoTesoroValioso:: Tesoro -> Bool
saqueoTesoroValioso tesoro = esTesoroValioso tesoro


saqueoTesoroQueEmpiezaConE::Tesoro -> Bool
saqueoTesoroQueEmpiezaConE tesoro = (head (nombre tesoro)) == 'e'

saqueoComplejo::(Tesoro -> Bool) -> (Tesoro -> Bool) -> Tesoro -> Bool
saqueoComplejo saqueo1 saqueo2 tesoro = (saqueo1 tesoro) || (saqueo2 tesoro)

---saque el tesoro que termine con vocal abierta ---
esVocalAbierta::Char -> Bool
esVocalAbierta 'a'= True
esVocalAbierta 'e'= True
esVocalAbierta 'o' = True
esVocalAbierta _ = False

saqueoTesoroTermineConVocalAbierta::Tesoro -> Bool
saqueoTesoroTermineConVocalAbierta tesoro = (esVocalAbierta.last)(nombre tesoro)

saqueoEspecifico :: Tesoro -> Tesoro -> Bool
saqueoEspecifico especifico tesoro = (nombre especifico) == nombre tesoro

saqueoFobia :: Tesoro -> Tesoro -> Bool
saqueoFobia fobia tesoro = (nombre tesoro) /= (nombre fobia)

saquear::Pirata -> Tesoro -> Pirata
saquear pirata tesoro 
    | (formaDeSaqueo pirata) tesoro = nuevoTesoroAlPirata tesoro pirata
    | otherwise = pirata

-- Navegando los siete mares --

data Barco= UnBarco{
    tripulacion :: [Pirata],
    maneraDeSaquearBarco :: (Tesoro->Bool)
} deriving Show

incorporaALaTripulacion :: Pirata -> Barco -> Barco
incorporaALaTripulacion pirata barco = UnBarco (pirata : tripulacion barco) (maneraDeSaquearBarco barco)

abandonaLaTripulacion :: Pirata -> Barco -> Barco
abandonaLaTripulacion pirata barco = UnBarco (eliminarTripulante pirata (tripulacion barco)) (maneraDeSaquearBarco barco)

eliminarTripulante :: Pirata -> [Pirata] -> [Pirata]
eliminarTripulante pirata [] = []
eliminarTripulante pirata (x:xs) | (apodo x) == (apodo pirata) = eliminarTripulante pirata xs
                                 | otherwise = x : (eliminarTripulante pirata xs)

anclarEnUnaIsla :: Tesoro -> Barco -> Barco
anclarEnUnaIsla isla barco =  UnBarco (map (nuevoTesoroAlPirata isla) (tripulacion barco)) (maneraDeSaquearBarco barco)

-- Cuando es abordado por otro barco,si el primer barco tiene mas tripulantes, entonces se queda con la tripulacion del otro barco. Si este es menor, queda el barco sin tripulantes, sin embargo, si ambos tienen misma cantidad de tripulantes, cada uno sigue su camino sin hacerse nada 
abordar::Barco -> Barco -> Barco
abordar barcoAtacado barcoAtacante 
    |length(tripulacion barcoAtacante) > length(tripulacion barcoAtacado) = UnBarco ((tripulacion barcoAtacado) ++ (tripulacion barcoAtacante)) (maneraDeSaquearBarco barcoAtacante)
    |length(tripulacion barcoAtacante) < length(tripulacion barcoAtacado) = UnBarco [] (maneraDeSaquearBarco barcoAtacante)
    |otherwise = UnBarco (tripulacion barcoAtacante) (maneraDeSaquearBarco barcoAtacante)

perlaNegra= UnBarco [jackSparrow, anneBonny] saqueoTesoroTermineConVocalAbierta
holandesErrante= UnBarco [davidJones] saqueoTesoroValioso

elizabethSwann= UnPirata "Elizabeth Swann" [(UnTesoro "moneda del cofre muerto" 100),(UnTesoro "espada de hierro" 50)] (saqueoEspecifico diamanteFalso)
willTurner= UnPirata "Will Turner" [(UnTesoro "cuchillo" 5)] (saqueoComplejo saqueoTesoroQueEmpiezaConE saqueoTesoroValioso)

islaTortuga = UnTesoro "frasco de arena" 1
islaDelRon = UnTesoro "botella de ron" 25

-- Universidad Pirata --

data Universidad=UnaUniversidad{
    nombreUni::String,
    habilidadDesarrollada::Barco->Barco
}deriving Show

universidadAntiDictaminanteDeEstilos = UnaUniversidad "Universidad Anti Dictaminante de Estilo" saqueoInverso
universidadDeBuitresAlternativos = UnaUniversidad "Universidad De Buitres Alternativos"  saqueoDeFormaCompleja
universidadAtlanticaInofensiva =UnaUniversidad "Universidad Atlantica Inofensiva" saqueoQueNoAfecta 

saqueoInverso :: Barco -> Barco
saqueoInverso barco = UnBarco (tripulacion barco) (not.(maneraDeSaquearBarco barco))

saqueoDeFormaCompleja::Barco -> Barco
saqueoDeFormaCompleja barco = UnBarco (tripulacion barco) (saqueoComplejo saqueoTesoroValioso (maneraDeSaquearBarco barco))

saqueoQueNoAfecta::Barco -> Barco
saqueoQueNoAfecta barco = UnBarco (tripulacion barco) (maneraDeSaquearBarco barco)

irALaUniversidad:: Universidad -> Barco -> Barco
irALaUniversidad universidad barco = (habilidadDesarrollada universidad) barco

-- Historias de barcos --

aventurasDelBarco :: [Barco -> Barco] -> Barco -> Barco
aventurasDelBarco listaDeAcciones barco = foldr ($) barco listaDeAcciones  

lista1= [(irALaUniversidad universidadAntiDictaminanteDeEstilos),(incorporaALaTripulacion elizabethSwann),(anclarEnUnaIsla islaDelRon),(abordar holandesErrante)]

barcoConMasTripulacion :: [Barco -> Barco] -> [Barco] -> Barco
barcoConMasTripulacion listaDeAcciones barcos = UnBarco (tripulacion (last(barcosOrdenados (map (aventurasDelBarco listaDeAcciones) barcos)))) (maneraDeSaquearBarco (last(barcosOrdenados (map (aventurasDelBarco listaDeAcciones) barcos))))

barcosOrdenados::[Barco]->[Barco]
barcosOrdenados [] = []
barcosOrdenados (x:xs) = barcosOrdenados(menores) ++ [x] ++ barcosOrdenados(mayores)
    where
    menores = [y | y <-xs, (length (tripulacion y)) < (length (tripulacion x))]
    mayores = [z | z <-xs, (length (tripulacion z)) >= (length (tripulacion x))]

-- Proliferación de piratas --

barcoInfinito :: Barco -> Pirata -> Barco
barcoInfinito barco pirata = barco {tripulacion = piratasInfinitos pirata 0}

piratasInfinitos :: Pirata -> Number -> [Pirata]
piratasInfinitos pirata x = (UnPirata ("pirata" ++ (show (x))) (botin pirata) (formaDeSaqueo pirata)) : piratasInfinitos pirata (x + 1)

{-
i)No devuelven nada por quedarse evaluando infinitamente. 
ii)Devuelven una respuesta infinita 
iii)Devuelven una respuesta finita 
iv)Según cuál sea la otra información del barco o con qué otros parámetros se la invoque, pueden pasar diferentes cosas.
i) anclarEnUnaIsla, abordar
ii) incorporaALaTripulacion, abandonaLaTripulacion, irALaUniversidad
iii)
iv) aventurasDelBarco
-}
