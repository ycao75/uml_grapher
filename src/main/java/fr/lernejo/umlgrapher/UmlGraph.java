package fr.lernejo.umlgrapher;

public class UmlGraph {
    public <Machin> UmlGraph(Machin Mac) {
        Mac.toString();
    }

    public String as(GraphType mermai) {
        return mermai.Mermaid.getTypeGraph();
    }
}
