package com.ideaheap;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsBasedCalculator {

    public Map<String, String> getStringTransition(
        final Set<String> stringSet,
        final Map<String, Double> stringCosts) {

        Set<Map.Entry<String, Double>> stringCostSet = stringCosts.entrySet();
        return stringCosts.keySet().parallelStream().collect(
            Collectors.toConcurrentMap(
                (state) -> state,
                (state) -> stringTransitionCost(state, stringSet, stringCostSet)
            )
        );
    }

    private String stringTransitionCost(
        final String state,
        final Set<String> stringSet,
        final Set<Map.Entry<String, Double>> expectedUtilities) {
        return stringSet.stream().max(
            Comparator.comparing(
                act -> calculateExpectedUtility(state, act, expectedUtilities)
            )
        ).get();
    }

    private Double calculateExpectedUtility(
        String state,
        String act,
        Set<Map.Entry<String, Double>> expectedUtilities) {

        return expectedUtilities
            .stream()
            .mapToDouble(
                n -> getStateProbability(state, act, n.getKey()) * n.getValue()
            ).sum();
    }

    private Double getStateProbability(String state, String act, String key) {
        return 5.0;
    }

}