package fr.lernejo.umlgrapher;

public class UmlType {
    private final Class classes;
    private final String name;
    private final String packageName;
    UmlType(Class classes){
        this.classes= classes;
        this.name= classes.getSimpleName();
        this.packageName=classes.getPackageName();
    }
    public Class classes(){return this.classes;}
    public String getName(){return this.name;}
    public String getPackageName(){return this.packageName;}
}
