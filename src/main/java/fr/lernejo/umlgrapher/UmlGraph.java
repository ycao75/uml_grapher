package fr.lernejo.umlgrapher;

public class UmlGraph {
    private final Class[] myclass;
    public UmlGraph(Class... myclass){
        this.myclass = myclass;
    }
    public String as(GraphType graphType){
        String chaine = "classDiagram\n";
        for (Class Myclass : myclass) {
            switch (graphType) {
                case Mermaid:
                    chaine = chaine + "class " + Myclass.getSimpleName() + " {\n";
                    if (Myclass.isInterface()) {
                        chaine = chaine + "    <<interface>>\n";
                    }
                    chaine = chaine + "}\n";
                    break;
            }
        }
        return chaine;
    }
}
