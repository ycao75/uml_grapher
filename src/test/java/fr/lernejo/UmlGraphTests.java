package fr.lernejo;

import fr.lernejo.umlgrapher.GraphType;
import fr.lernejo.umlgrapher.UmlGraph;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UmlGraphTests {

        public sealed interface Living {
            sealed interface Animal extends Living {
                final class Ant implements Animal {
                }

                final class Cat implements Animal {
                }
            }

            sealed interface Plant extends Living {
                sealed interface Tree extends Plant {
                    final class Alder implements Tree {
                    }
                }
            }
        }

        @Test
        void interface_with_no_relation() {
            Class<?>[] user_class = {Living.Animal.Ant.class, Living.Animal.Cat.class, Living.Plant.Tree.Alder.class};
            UmlGraph graph = new UmlGraph(user_class);
            String output = graph.as(GraphType.Mermaid);

            Assertions.assertThat(output).isEqualTo("""
                classDiagram
                class Alder
                class Animal {
                    <<interface>>
                }
                class Ant
                class Cat
                class Living {
                    <<interface>>
                }
                class Plant {
                    <<interface>>
                }
                class Tree {
                    <<interface>>
                }
                Tree <|.. Alder : implements
                Living <|-- Animal : extends
                Animal <|.. Ant : implements
                Animal <|.. Cat : implements
                Living <|-- Plant : extends
                Plant <|-- Tree : extends
                """);
        }


        @Test
        void empty_interface_with_no_relation() {
            UmlGraph graph = new UmlGraph(Machin.class);
            String output = graph.as(GraphType.Mermaid);
            Assertions.assertThat(output).isEqualTo("""
                classDiagram
                class Machin {
                    <<interface>>
                }
                """);
        }

        interface Machin {
        }
    }

