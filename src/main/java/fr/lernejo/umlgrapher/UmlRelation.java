package fr.lernejo.umlgrapher;

import java.util.*;

public class UmlRelation {
    private final Set<UmlType> my_Tree;

    UmlRelation(Set<UmlType> my_Tree){
        this.my_Tree = my_Tree;

    }

    public Set<MermaidLiaison> myRelations(Set<MermaidLiaison> liaisons){
        String relation ="";
        for(UmlType i : my_Tree){
            Class[] j = i.classes().getInterfaces();
            for(Class k : j){
                if(i.classes().getSuperclass()==null){
                    relation = k.getSimpleName()+" <|-- " + i.classes().getSimpleName() + " : extends";
                }
                else{
                    relation = k.getSimpleName()+" <|.. " + i.classes().getSimpleName() + " : implements";
                }
                relation +="\n";
                liaisons.add(new MermaidLiaison(k,i.classes(),relation));
            }
        }
        return liaisons;
    }
    public String allRelation(Set<MermaidLiaison> liaisons,Set<UmlType> types){
        String relationString="";
        liaisons = new UmlRelation(types).myRelations(liaisons);
        for (MermaidLiaison i : liaisons) {
            relationString += i.getMy_liason();
        }
        return relationString;
    }
}
