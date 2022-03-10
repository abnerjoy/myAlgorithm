package com.abner.algorithmDiagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDijkstrasAlgorithm {
    private static Map<String, Map<String, Double>> graph = new HashMap<>();
    private static List<String> processed = new ArrayList<>();
    public static void main(String[] args) {
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6.0);
        graph.get("start").put("b", 2.0);

        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1.0);

        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3.0);
        graph.get("b").put("fin", 5.0);

        graph.put("fin", new HashMap<>());

        // The costs table
        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 6.0);
        costs.put("b", 2.0);
        costs.put("fin", Double.POSITIVE_INFINITY);

        // the parents table
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);


        String low=findLowestNode(costs);
        while(low!=null){
            Map<String, Double> neighborMap = graph.get(low);//get neighbor for low node
            Double cost = costs.get(low);
            for(String node:neighborMap.keySet()){
                Double newCost =cost+neighborMap.get(node);
                if(newCost<costs.get(node)){
                    costs.put(node,newCost);
                    parents.put(node,low);
                }
            }
            processed.add(low);
            low= findLowestNode(costs);
        }
        System.out.println("Cost from the start to each node:");
        System.out.println(costs);
        System.out.println(parents);
    }

    private static String findLowestNode(Map<String, Double> costs) {
        String lowetNode = null;
        Double lowetValue=Double.POSITIVE_INFINITY;
        for (Map.Entry<String,Double> node:costs.entrySet()){
            if(node.getValue()<lowetValue&&!processed.contains(node.getKey())){
                lowetNode=node.getKey();
                lowetValue=node.getValue();
            }
        }
        return lowetNode;
    }
}
