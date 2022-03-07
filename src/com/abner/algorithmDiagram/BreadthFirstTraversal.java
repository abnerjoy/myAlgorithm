package com.abner.algorithmDiagram;

import java.util.*;

public class BreadthFirstTraversal {

    private static Map<String, List<String>> graph = new HashMap<>();

    public static boolean breadthFirstSearch(String name){
        Queue<String> queue = new ArrayDeque<>(graph.get(name));
        List<String> searchList = new ArrayList<>();
        while (!queue.isEmpty()){
            String poll = queue.poll();
            if(!searchList.contains(poll)){
                if(person_is_seller(poll)){
                    System.out.println(poll + " is a mango seller!");
                    return true;
                }else {
                    queue.addAll(graph.get(poll));
                    // Marks this person as searched
                    searchList.add(poll);
                }
            }
        }
        return false;
    }

    private static boolean person_is_seller(String name) {
        return name.endsWith("m");
    }

    public static void main(String[] args) {
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
        graph.put("anuj", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());

        breadthFirstSearch("you");
    }

}
