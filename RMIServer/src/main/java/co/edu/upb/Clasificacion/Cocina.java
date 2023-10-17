package co.edu.upb.Clasificacion;


import co.edu.upb.list.DoubleLinkedList;

import java.io.Serializable;

public class Cocina implements Serializable {
    DoubleLinkedList<DoubleLinkedList> ciudad = new DoubleLinkedList<>();
    DoubleLinkedList barrio = new DoubleLinkedList<>();

    public Cocina(){


    }
    /*
Barrios: Ciudad Venecia, Villa Alicia, El Rocío, Toledo Plata, Dangond, Manuela Beltrán I y II,
Igzabelar, Santa María,
Los Robles, Granjas de Julio Rincón, Jardines de Coaviconsa, El Candado, Malpaso, El Porvenir, Las Delicias.

     */
    private void CrearBarrios(){
        // Comuna 1
        /*Barrio losAngeles = new Barrio("Los Angeles", 1);
        Barrio villaHelenaI = new Barrio("Villa Helena I", 1);
        Barrio villaHelenaII = new Barrio("Villa Helena II", 1);
        Barrio joseMariaCordoba = new Barrio("José María Córdoba", 1);
        Barrio esperanzaI = new Barrio("Esperanza I", 1);
        Barrio esperanzaII = new Barrio("Esperanza II", 1);
        Barrio esperanzaIII = new Barrio("Esperanza III", 1);
        Barrio lizcanoI = new Barrio("Lizcano I", 1);
        Barrio lizcanoII = new Barrio("Lizcano II", 1);
        Barrio regaderoNorte = new Barrio("Regadero Norte", 1);
        Barrio sanCristobal = new Barrio("San Cristóbal", 1);

// Comuna 2
        Barrio laJuventud = new Barrio("La Juventud", 2);
        Barrio transicionI = new Barrio("Transición I", 2);
        Barrio transicionII = new Barrio("Transición II", 2);
        Barrio transicionIII = new Barrio("Transición III", 2);
        Barrio transicionIV = new Barrio("Transición IV", 2);
        Barrio transicionV = new Barrio("Transición V", 2);

// Comuna 3
        Barrio laIndependencia = new Barrio("La Independencia", 3);
        Barrio villaMercedes = new Barrio("Villa Mercedes", 3);
        Barrio bosqueNorte = new Barrio("Bosque Norte", 3);
        Barrio elRosal = new Barrio("El Rosal", 3);
        Barrio colorados = new Barrio("Colorados", 3);
        Barrio cafeMadrid = new Barrio("Café Madrid", 3);
        Barrio lasHamacas = new Barrio("Las Hamacas", 3);

// Comuna 4
        Barrio altosDelKennedy = new Barrio("Altos del Kennedy", 4);
        Barrio kennedy = new Barrio("Kennedy", 4);
        Barrio balconesDelKennedy = new Barrio("Balcones del Kennedy", 4);
        Barrio lasOlas = new Barrio("Las Olas", 4);
        Barrio villaRosa = new Barrio("Villa Rosa", 4);
        Barrio omaga = new Barrio("Omagá", 4);
        Barrio minutoDeDios = new Barrio("Minuto de Dios", 4);

// Comuna 5
        Barrio tejarNorte = new Barrio("Tejar Norte", 5);
        Barrio miramar = new Barrio("Miramar", 5);
        Barrio miradoresDelKennedy = new Barrio("Miradores del Kennedy", 5);
        Barrio elPablon = new Barrio("El Pablón", 5);
        Barrio norteBajo = new Barrio("Norte Bajo", 5);
        Barrio sanRafael = new Barrio("San Rafael", 5);
        Barrio elCinal = new Barrio("El Cinal", 5);
        Barrio chapinero = new Barrio("Chapinero", 5);

// Comuna 6
        Barrio comuneros = new Barrio("Comuneros", 6);
        Barrio laUniversidad = new Barrio("La Universidad", 6);
        Barrio mutualidad = new Barrio("Mutualidad", 6);
        Barrio modelo = new Barrio("Modelo", 6);
        Barrio sanFrancisco = new Barrio("San Francisco", 6);
        Barrio alarcon = new Barrio("Alarcón", 6);
        Barrio gaitan = new Barrio("Gaitán", 6);
        Barrio granadas = new Barrio("Granadas", 6);
        Barrio narino = new Barrio("Nariño", 6);
        Barrio girardot = new Barrio("Girardot", 6);
        Barrio laFeria = new Barrio("La Feria", 6);
        Barrio napoles = new Barrio("Nápoles", 6);
        Barrio pioXII = new Barrio("Pío Xll", 6);
        Barrio junio23 = new Barrio("23 de Junio", 6);
        Barrio santander = new Barrio("Santander", 6);

// Comuna 7
        Barrio donBosco = new Barrio("Don Bosco", 7);
        Barrio octubre12 = new Barrio("12 de Octubre", 7);
        Barrio laGloria = new Barrio("La Gloria", 7);
        Barrio quintaEstrella = new Barrio("Quinta Estrella", 7);
        Barrio alfonsoLopez = new Barrio("Alfonso López", 7);
        Barrio laJoya = new Barrio("La Joya", 7);
        Barrio chorrerasDeDonJuan = new Barrio("Chorreras de Don Juan", 7);
        Barrio campohermoso = new Barrio("Campohermoso", 7);
        Barrio laEstrella = new Barrio("La Estrella", 7);
        Barrio primeroDeMayo = new Barrio("Primero de Mayo", 7);
        Barrio laConcordia = new Barrio("La Concordia", 7);
        Barrio sanMiguel = new Barrio("San Miguel", 7);
        Barrio candiles = new Barrio("Candiles", 7);

// Comuna 8
        Barrio aeropuertoGomezNino = new Barrio("Aeropuerto Gómez Niño", 8);
        Barrio ricaurte = new Barrio("Ricaurte", 8);
        Barrio laCeiba = new Barrio("La Ceiba", 8);
        Barrio laSalle = new Barrio("La Salle", 8);
        Barrio laVictoria = new Barrio("La Victoria", 8);
        Barrio ciudadelaRealDeMinas = new Barrio("Ciudadela Real de Minas", 8);
        Barrio sanGerardo = new Barrio("San Gerardo", 8);
        Barrio antiguoColombia = new Barrio("Antiguo Colombia", 8);
        Barrio losCanelos = new Barrio("Los Canelos", 8);
        Barrio bucaramanga = new Barrio("Bucaramanga", 8);
        Barrio cordoncilloI = new Barrio("Cordoncillo I", 8);
        Barrio cordoncilloII = new Barrio("Cordoncillo II", 8);
        Barrio pabloVI = new Barrio("Pablo VI", 8);
        Barrio julio20 = new Barrio("20 de Julio", 8);
        Barrio africa = new Barrio("África", 8);
        Barrio juanXXIII = new Barrio("Juan XXIII", 8);

// Comuna 9
        Barrio losLaureles = new Barrio("Los Laureles", 9);
        Barrio quebradaLaIglesia = new Barrio("Quebrada la Iglesia", 9);
        Barrio antoniaSantosSur = new Barrio("Antonia Santos Sur", 9);
        Barrio sanPedroClaver = new Barrio("San Pedro Claver", 9);
        Barrio sanMartin = new Barrio("San Martín", 9);
        Barrio nuevaGranada = new Barrio("Nueva Granada", 9);
        Barrio laPedregosa = new Barrio("La Pedregosa", 9);
        Barrio laLibertad = new Barrio("La Libertad", 9);
        Barrio diamanteI = new Barrio("Diamante I", 9);
        Barrio villaInes = new Barrio("Villa Inés", 9);
        Barrio asturias = new Barrio("Asturias", 9);
        Barrio lasCasitas = new Barrio("Las Casitas", 9);
        Barrio diamanteII = new Barrio("Diamante II", 9);
        Barrio sanLuis = new Barrio("San Luis", 9);

// Comuna 10
        Barrio provenza = new Barrio("Provenza", 10);
        Barrio elCristal = new Barrio("El Cristal", 10);
        Barrio fontana = new Barrio("Fontana", 10);
        Barrio granjasDeProvenza = new Barrio("Granjas de Provenza", 10);
        Barrio ciudadVenecia = new Barrio("Ciudad Venecia", 10);
        Barrio villaAlicia = new Barrio("Villa Alicia", 10);
        Barrio elRocio = new Barrio("El Rocío", 10);
        Barrio toledoPlata = new Barrio("Toledo Plata", 10);
        Barrio dangond = new Barrio("Dangond", 10);
        Barrio manuelaBeltranI = new Barrio("Manuela Beltrán I", 10);
        Barrio manuelaBeltranII = new Barrio("Manuela Beltrán II", 10);
        Barrio igzabelar = new Barrio("Igzabelar", 10);
        Barrio santaMaria = new Barrio("Santa María", 10);
        Barrio losRobles = new Barrio("Los Robles", 10);
        Barrio granjasDeJulioRincon = new Barrio("Granjas de Julio Rincón", 10);
        Barrio jardinesDeCoaviconsa = new Barrio("Jardines de Coaviconsa", 10);
        Barrio elCandado = new Barrio("El Candado", 10);
        Barrio malpaso = new Barrio("Malpaso", 10);
        Barrio elPorvenir = new Barrio("El Porvenir", 10);
        Barrio lasDelicias = new Barrio("Las Delicias", 10);

// Comuna 11
        Barrio cabeceraDelLlano = new Barrio("Cabecera del Llano", 11);
        Barrio sotomayor = new Barrio("Sotomayor", 11);
        Barrio antiguoCampestre = new Barrio("Antiguo Campestre", 11);
        Barrio bolarqui = new Barrio("Bolarquí", 11);
        Barrio mercedes = new Barrio("Mercedes", 11);
        Barrio puertaDelSol = new Barrio("Puerta del Sol", 11);
        Barrio conucos = new Barrio("Conucos", 11);
        Barrio elJardin = new Barrio("El Jardín", 11);
        Barrio panDeAzucar = new Barrio("Pan de Azúcar", 11);
        Barrio losCedros = new Barrio("Los Cedros", 11);
        Barrio terrazas = new Barrio("Terrazas", 11);
        Barrio laFloresta = new Barrio("La Floresta", 11);
        Barrio losPinos = new Barrio("Los Pinos", 11);
        Barrio sanAlonso = new Barrio("San Alonso", 11);

// Comuna 12
        Barrio galan = new Barrio("Galan", 12);
        Barrio laAurora = new Barrio("La Aurora", 12);
        Barrio lasAmericas = new Barrio("Las Américas", 12);
        Barrio elPrado = new Barrio("El Prado", 12);
        Barrio mejorasPublicas = new Barrio("Mejoras Públicas", 12);
        Barrio antoniaSantos = new Barrio("Antonia Santos", 12);
        Barrio bolivar = new Barrio("Bolívar", 12);
        Barrio alvarez = new Barrio("Álvarez", 12);
        Barrio vegasDeMorrorico = new Barrio("Vegas de Morrorico", 12);
        Barrio elDiviso = new Barrio("El Diviso", 12);
        Barrio morrorico = new Barrio("Morrorico", 12);
        Barrio albania = new Barrio("Albania", 12);
        Barrio miraflores = new Barrio("Miraflores", 12);
        Barrio buenosAires = new Barrio("Buenos Aires", 12);
        Barrio limoncito = new Barrio("Limoncito", 12);
        Barrio losSauces = new Barrio("Los Sauces", 12);

// Comuna 13
        Barrio centro = new Barrio("Centro", 13);
        Barrio garciaRovira = new Barrio("García Rovira", 13);
        Barrio lagosDelCacique = new Barrio("Lagos del Cacique", 13);
        Barrio elTejar = new Barrio("El Tejar", 13);
        Barrio sanExpedito = new Barrio("San Expedito", 13);
        Barrio mutis = new Barrio("Mutis", 13);
        Barrio balconcitos = new Barrio("Balconcitos", 13);
        Barrio monterredondo = new Barrio("Monterredondo", 13);
        Barrio heroes = new Barrio("Héroes", 13);
        Barrio estoraquesI = new Barrio("Estoraques I", 13);
        Barrio estoraquesII = new Barrio("Estoraques II", 13);
        Barrio pradosDelMutis = new Barrio("Prados del Mutis", 13);



        //florida
        //comuna1
        Barrio nogalesDeFlorida = new Barrio("Nogales de Florida", 1);
        Barrio jardinDeLimoncito = new Barrio("Jardín de Limoncito", 1);
        Barrio limoncitoFlo = new Barrio("Limoncito", 1);
        Barrio altamira = new Barrio("Altamira", 1);
        Barrio bosquesDeLaFlorida = new Barrio("Bosques de la Florida", 1);
        Barrio pirineos = new Barrio("Pirineos", 1);
        Barrio andes = new Barrio("Andes", 1);
        Barrio cracovia = new Barrio("Cracovia", 1);
        Barrio favuis = new Barrio("Favuis", 1);
        Barrio cascoAntiguo = new Barrio("Casco Antiguo", 1);
        Barrio floridaReal = new Barrio("Florida Real", 1);
        Barrio villasDeSanFrancisco = new Barrio("Villas de San Francisco", 1);
        Barrio paraguitas = new Barrio("Paraguitas", 1);
        Barrio villaJardin = new Barrio("Villa Jardín", 1);
        Barrio santaColoma = new Barrio("Santa Coloma", 1);
        Barrio villaPiedraDelSol = new Barrio("Villa Piedra del Sol", 1);
        Barrio estanciaCampestre = new Barrio("Estancia Campestre", 1);
        Barrio elManantial = new Barrio("El Manantial", 1);
        Barrio portalDeCastilla = new Barrio("Portal de Castilla", 1);
        Barrio quintasDeLaFlorida = new Barrio("Quintas de la Florida", 1);
        Barrio acacias = new Barrio("Acacias", 1);
        Barrio elVerde = new Barrio("El Verde", 1);
        Barrio sena = new Barrio("Sena", 1);
        Barrio colegioAgustiniano = new Barrio("Colegio Agustiniano", 1);
        Barrio universidadSantoTomas = new Barrio("Universidad Santo Tomás", 1);
        Barrio elRecreo = new Barrio("El Recreo", 1);
        Barrio laPaz = new Barrio("La Paz", 1);
        Barrio ciudadelaLosPrincipes = new Barrio("Ciudadela Los Príncipes", 1);
        Barrio portalDelSigloXXI = new Barrio("Portal del Siglo XXI", 1);
        Barrio ministerioDeObrasINVIAS = new Barrio("Ministerio de Obras INVIAS", 1);
        Barrio buenosAiresFlo = new Barrio("Buenos Aires", 1);
        Barrio costadoSurDeLaCalle200 = new Barrio("Costado sur de la calle 200", 1);
        Barrio seminario = new Barrio("Seminario", 1);
        Barrio turenaLaPera = new Barrio("Turena La Pera", 1);
        Barrio clubHouse = new Barrio("Club House", 1);
        Barrio alamosParque = new Barrio("Álamos Parque", 1);
        Barrio hoyoEnUno = new Barrio("Hoyo en Uno", 1);
        Barrio montellanoCampestre = new Barrio("Montellano Campestre", 1);
        Barrio laLomita = new Barrio("La Lomita", 1);*/


    }
}
