class Unntak extends Exception {
    public String antallOrdFeil() {
        String melding = "Antall ord stemmer ikke overens med antall ord oppgitt i filen.";
        return melding;
    }
}
