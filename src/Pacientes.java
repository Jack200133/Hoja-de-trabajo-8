public class Pacientes implements Comparable<Pacientes> {
    private String prioridad;
    private String datos;
    private String Name;



    public Pacientes(String s, String s1, String s2) {
        prioridad = s;
        datos = s1;
        Name = s2;
    }


    public String getPrioridad() {
        return prioridad;
    }

    public String getDatos() {
        return datos;
    }



    @Override
    public String toString() {
        return  Name + ": "+ datos + " - " + prioridad;
    }


    @Override
    public int compareTo(Pacientes o) {
        return this.getPrioridad().compareTo(o.getPrioridad());
    }
}
