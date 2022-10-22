package fr.lernejo.umlgrapher;

public enum GraphType {
    Mermaid("""
    classDiagram
    class Machin {
        <<interface>>
    }
    """);
    private final String typeGraph;

    GraphType(String strings) {this.typeGraph = strings;}
    public String getTypeGraph() {return typeGraph;}
}
