import main.Graph;

import java.util.*;

public class Buscas{

        // a hash map is used to store nodes that have been visited
        private static HashMap<Integer, Integer> closedList = new HashMap<Integer, Integer>();
        private static HashMap<Integer, Integer> beam = new HashMap<Integer, Integer>();
        //private static final Integer[] heuristic = {1, 0, 1, 1, 2, 1, 1, 2, 2, 1};
        private static final Integer[] heuristic = {0, 2, 1, 3, 2, 2, 2, 3, 2, 1};
        public static Integer compare_hashMap_min(HashMap<Integer, Integer> scores) {
            Collection c = scores.values();
            Integer minvalue = (Integer) Collections.min(c);
            Integer minIndex = 0;
            Set<Integer> scores_set = scores.keySet();
            Iterator<Integer> scores_it = scores_set.iterator();
            while(scores_it.hasNext()) {
                Integer id = scores_it.next();
                Integer value = scores.get(id);
                if (value == minvalue) {
                    minIndex = id;
                    break;
                }
            }
            return minIndex;
        }

        public static Integer search(Graph G, Integer start, Integer goal, Integer beamWidth) {
            int g = 0;
            int v = G.V();
            int initial = v + 1; // just the symbol of null
            int fail = initial + 1;
            System.out.println("If failed, then the result will be : " + fail );
            closedList.put(start, initial);
            beam.put(start, initial);

            // main Loop
            // expand the best node in the beam and then update the beam with best b nodes
            // (evaluated by the current heuristic function) among the non-expanded nodes
            // and the children
            while (beam.size() != 0) {
                System.out.println("Beam :" + beam);
                System.out.println("ClosedList :" + closedList);
                HashMap<Integer, Integer> set = new HashMap<Integer, Integer>();
                HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
                for (Integer node : beam.keySet()) {
                    values.put(node, heuristic[node]);
                    set.put(node, beam.get(node));
                }
                Integer index = compare_hashMap_min(values);
                for (Integer neighbor : G.adj(index)) {
                    if (neighbor == goal )
                        return g + 1;
                    set.put(neighbor, index);
                }
                set.remove(index);
                System.out.println("Set : " + set);
                beam = new HashMap<Integer, Integer>();
                g = g + 1;

                while ((set.size() != 0 ) && (beamWidth > beam.size())) {
                    HashMap<Integer, Integer> heuristicValue = new HashMap<Integer, Integer>();
                    for (Integer key : set.keySet()) {
                        heuristicValue.put(key, heuristic[key]);
                    }
                    Integer minIndex = compare_hashMap_min(heuristicValue);
                    Iterator<Integer> keys = set.keySet().iterator();
                    while(keys.hasNext()) {
                        Integer key = keys.next();
                        if (key == minIndex) keys.remove();
                    }

                    if (!closedList.containsKey(minIndex)) {
                        closedList.put(minIndex, set.get(minIndex));
                        beam.put(minIndex, set.get(minIndex));
                    }
                }
            }
            return fail;
        }
    }